package com.bytheone.core.quartz.CustomQuartz;


import com.bytheone.entity.SysUser;
import com.bytheone.service.SysUserService;
import com.bytheone.service.impl.SysUserServiceImpl;
import com.bytheone.util.SpringUtil;

import java.text.SimpleDateFormat;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;

/**
 * @author ArtLinty
 * @date 2018/1/7.
 * @email liu.tingli@qq.com
 * <p>
 * 定时测试类
 */
@Slf4j
public class JobDemo2 implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("JobDemo2：启动任务=======================");
        run();
        System.out.println("JobDemo2：下次执行时间=====" +
                new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
                        .format(context.getNextFireTime()) + "==============");
    }

    public void run() {
        ApplicationContext applicationContext = SpringUtil.getApplicationContext();
        SysUserService sys = SpringUtil.getBean(SysUserServiceImpl.class);
        List<SysUser> userList = sys.selectListByPage(new SysUser());
        log.info(userList.get(0).getUsername());
        log.info("JobDemo2：执行完毕=======================");
    }
}
