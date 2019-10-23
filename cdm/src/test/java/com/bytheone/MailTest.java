package com.bytheone;


import com.bytheone.entity.SysSource;
import com.bytheone.utility.MailManager;
import org.junit.Test;


import javax.mail.Message;
import javax.mail.Store;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MailTest {

    @Test
    public void receiveMailTest() {
        MailManager mailManager = new MailManager();
        Store store = mailManager.initSession();
        List<String> folderList = new ArrayList<>();

        folderList.add("01_job51");
        folderList.add("02_zhilian");
        folderList.add("03_cjol");
        folderList.add("04_dajie");
        folderList.add("05_chinahr");

        for (String folder : folderList) {
            List<Message> messageList = mailManager.getMessages(store, folder);
            if (messageList != null && messageList.size() > 0) {
                for (Message message : messageList) {

                    SysSource source;
                    try {
                        source = mailManager.feedMessage(message);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                //mailManager.removeMessages(store, messageList, folder, "archived");
            }
        }

    }
}
