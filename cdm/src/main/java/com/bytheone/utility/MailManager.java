package com.bytheone.utility;

import com.bytheone.entity.ResumeType;
import com.bytheone.entity.SysSource;

import javax.mail.*;
import javax.mail.internet.MimeUtility;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MailManager {
    private final String CONFIG_FOLDER_PATH = String.format("%s/cdm-sys/src/main/resources/config/", System.getProperty("user.dir"));

    /**
     * 初始化邮件对话
     *
     * @return Store
     */
    public Store initSession() {
        String baseResumeSourceFileName = "BaseResumeSource.yaml";
        Map mailConfig = YamlHelper.getMap(this.CONFIG_FOLDER_PATH + baseResumeSourceFileName);
        String imapServer = YamlHelper.getMapValue(mailConfig, "ImapServer");
        String protocol = YamlHelper.getMapValue(mailConfig, "Protocol");
        String account = YamlHelper.getMapValue(mailConfig, "Account");
        String password = YamlHelper.getMapValue(mailConfig, "Password");

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", protocol);
        props.setProperty("mail.imap.host", imapServer);

        // 获取连接
        Session session = Session.getDefaultInstance(props);
        session.setDebug(false);
        // 获取Store对象
        Store store = null;
        try {
            store = session.getStore(protocol);
            if (store != null) {
                store.connect(imapServer, account, password);
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return store;

    }

    public List<Message> getMessages(Store store, String folderName) {
        List<Message> messageList = new ArrayList<>();
        if (store != null) {
            Folder folder = null;
            try {
                folder = store.getFolder(folderName);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            try {
                if (folder != null) {
                    folder.open(Folder.READ_WRITE);
                    Message[] messages = folder.getMessages();
                    Collections.addAll(messageList, messages);
                }
            } catch (MessagingException e) {
                e.printStackTrace();
            }

        }
        return messageList;
    }

    public SysSource feedMessage(Message message) throws IOException {
        if (message == null) {
            return null;
        }

        String subject = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");

        String mailId = sdf.format(new Date());
        Address fromAddress = null;
        Address toAddress = null;
        Date receiveDate = null;
        try {
            subject = message.getSubject();
            fromAddress = message.getFrom()[0];
            toAddress = message.getRecipients(Message.RecipientType.TO)[0];
            receiveDate = message.getReceivedDate();
        } catch (MessagingException e) {
            e.printStackTrace();
        }


        String from = formatAddress(fromAddress);
        String to = formatAddress(toAddress);


        System.out.println("邮件的主题为: " + subject + ",发件人地址为: " + from + ",收件人地址：" + to + ",接收时间为：" + receiveDate.toString());

        String baseResumeSourceFileName = "BaseResumeSource.yaml";
        Map mailConfig = YamlHelper.getMap(this.CONFIG_FOLDER_PATH + baseResumeSourceFileName);
        String lastRunTimeString = YamlHelper.getMapValue(mailConfig, "LastRunTime");
        String resumeFolder = YamlHelper.getMapValue(mailConfig, "ResumeSaveFolder");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String messageText = null;
        String messageContentType;

        boolean flag = false;

        ResumeFactory resumeFactory = new ResumeFactory();
        ResumeType resumeType = resumeFactory.parseEmailType(from);

        try {
            Date lastRunTime = df.parse(lastRunTimeString);
            if (receiveDate.before(lastRunTime)) {
                return null;
            }

            messageContentType = message.getContentType();
            if (messageContentType.endsWith("multipart/") || message.isMimeType("multipart/*")) {

                Multipart mpt = (Multipart) message.getContent();
                BodyPart bp = mpt.getBodyPart(0);

                if (resumeType == ResumeType.CJOL) {
                    messageText = new String(bp.getContent().toString().getBytes("GB2312"), "GB2312");
                    messageText = messageText.replace("GB2312", "UTF-8");
                } else {
                    messageText = bp.getContent().toString();
                }

            } else if (messageContentType.toUpperCase().contains("UTF-8")) {
                messageText = new String(message.getContent().toString().getBytes("GB2312"), "GB2312");

            } else {
                messageText = message.getContent().toString();
            }
            if (isInvalidMessage(messageText)) {
                return null;
            }

            Flags flags = message.getFlags();
            if (flags.contains(Flags.Flag.FLAGGED)) {
                flag = true;
            }
            saveResumeHtml(messageText, String.format("%s\\resume_%s.html", resumeFolder, mailId));
        } catch (ParseException | MessagingException e) {
            e.printStackTrace();
        }


        SysSource source = resumeFactory.parseEmail(mailId, messageText, resumeType);
        if (source != null) {
            Byte status = 0;
            source.setStatus(status);
            source.setReceiveDate(receiveDate);
            source.setPriority(flag ? "低" : "中");
        }


        return source;
    }

    /**
     * 判断 Message 是否 Invalid
     *
     * @param messageText
     * @return
     */
    private boolean isInvalidMessage(String messageText) {
        if (messageText != null) {
            String resumeFilterFileName = "ResumeFilter.yaml";
            Map mailConfig = YamlHelper.getMap(this.CONFIG_FOLDER_PATH + resumeFilterFileName);
            Map ageMap = YamlHelper.getMapDict(mailConfig, "Age");

            Iterator iter = ageMap.entrySet().iterator();
            boolean isInvalid = false;
            while (iter.hasNext()) {
                if (isInvalid) {
                    break;
                }
                Map.Entry entry = (Map.Entry) iter.next();
                String val = entry.getValue().toString();

                isInvalid = messageText.contains(val);

            }
            return isInvalid;
        }
        return true;
    }

    public void removeMessages(Store store, List<Message> messageList, String sourceFolder, String targetFolder) {
        if (store != null) {
            Folder inbox_folder = null;// 获得用户的邮件帐户
            try {
                inbox_folder = store.getFolder(sourceFolder);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            try {
                if (inbox_folder != null) {
                    inbox_folder.open(Folder.READ_WRITE); // 设置对邮件帐户的访问权限
                }
            } catch (MessagingException e) {
                e.printStackTrace();
            }

            Folder archive_folder = null;// 获得用户的邮件帐户
            try {
                archive_folder = store.getFolder(targetFolder);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            try {
                if (archive_folder != null) {
                    archive_folder.open(Folder.READ_WRITE); // 设置对邮件帐户的访问权限
                }
            } catch (MessagingException e) {
                e.printStackTrace();
            }

            try {
                Message[] messages = new Message[messageList.size()];
                messages = messageList.toArray(messages);
                if (inbox_folder != null) {
                    if (archive_folder != null) {
                        inbox_folder.copyMessages(messages, archive_folder);//复制到新文件夹
                    }
                }
                if (inbox_folder != null) {
                    inbox_folder.setFlags(messages, new Flags(Flags.Flag.DELETED), true);//删除源文件夹下的邮件
                }
            } catch (MessagingException e) {
                e.printStackTrace();
            }


        }
    }

    private String formatAddress(Address address) {

        if (address == null) {
            return null;
        }

        String formattedAddress = null;
        if (address.toString().startsWith("=?")) {
            // 把文件名编码成符合RFC822规范
            try {
                formattedAddress = MimeUtility.decodeText(address.toString());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            formattedAddress = address.toString();
        }

        return formattedAddress;
    }

    private void saveResumeHtml(String messageText, String fileName) {

        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(fileName))) {
            OutputStreamWriter osw = new OutputStreamWriter(fileOutputStream);


//            messageText = messageText.replace("<html>", "");
//            messageText = messageText.replace("<body>", "");

            osw.write(messageText);
            osw.flush();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}