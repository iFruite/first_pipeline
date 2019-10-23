package com.bytheone.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.bytheone.base.BaseMapper;
import com.bytheone.base.impl.BaseServiceImpl;
import com.bytheone.entity.SysSource;
import com.bytheone.mapper.SysSourceMapper;
import com.bytheone.service.SourceService;
import com.bytheone.service.SysUserService;
import com.bytheone.utility.MailManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.Store;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author ArtLinty
 * @date 2017/12/12.
 * @email liu.tingli@qq.com
 */
@Service
public class SourceServiceImpl extends BaseServiceImpl<SysSource, String> implements SourceService {

    @Autowired
    private SysSourceMapper sourceDao;

    @Autowired
    private SysUserService userService;

    public SourceServiceImpl() {
    }

    @Override
    public BaseMapper<SysSource, String> getMapper() {
        return sourceDao;
    }

    @Override
    public int insert(SysSource source) {
        return sourceDao.insert(source);
    }

    @Override
    public SysSource selectByPrimaryKey(String id) {
        return sourceDao.selectByPrimaryKey(id);
    }

    @Override
    public JSONArray getSourceJson(String id) {
        SysSource source = sourceDao.selectByPrimaryKey(id);
        JSONArray jsonArr = new JSONArray();
        jsonArr.add(source);
        return jsonArr;
    }

    @Override
    public int sync() {
        MailManager mailManager = new MailManager();
        Store store = mailManager.initSession();
        List<String> folderList = new ArrayList<>();

        folderList.add("01_job51");
        folderList.add("02_zhilian");
        folderList.add("03_cjol");
        folderList.add("04_dajie");
        folderList.add("05_chinahr");
        folderList.add("08_zhaopin");
//        folderList.add("temp");

        for (String folder : folderList) {
            List<Message> messageList = mailManager.getMessages(store, folder);
            if (messageList != null && messageList.size() > 0) {
                for (Message message : messageList) {

                    SysSource source;
                    try {
                        source = mailManager.feedMessage(message);
                        if (source != null && source.getMobile() != null) {
                            sourceDao.insert(source);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                mailManager.removeMessages(store, messageList, folder, "archived");
            }
        }


        return 0;
    }


}
