package com.bytheone.core.BootListener;

import com.bytheone.core.quartz.JobTask;
import com.bytheone.entity.SysJob;
import com.bytheone.service.JobService;
import com.bytheone.util.SpringUtil;
import com.bytheone.service.RoleService;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author ArtLinty
 * @date 2018/1/6.
 * @email liu.tingli@qq.com
 * <p>
 * 启动数据库中已经设定为 启动状态(status:true)的任务 项目启动时init
 */
@Configuration
@Slf4j
public class DataSourceJobThread extends Thread {

    @Autowired
    RoleService roleService;

    @Autowired
    JobService jobService;

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            log.info("---------线程启动---------");
            JobTask jobTask = SpringUtil.getBean("jobTask");
            SysJob job = new SysJob();
            job.setStatus(true);
            List<SysJob> jobList = jobService.selectListByPage(job);
            //开启任务
            jobList.forEach(jobs -> {
                        log.info("---任务[" + jobs.getId() + "]系统 init--开始启动---------");
                        jobTask.startJob(jobs);
                    }
            );
            if (jobList.size() == 0) {
                log.info("---数据库暂无启动的任务---------");
            } else
                System.out.println("---任务启动完毕---------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
