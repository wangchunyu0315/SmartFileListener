package com.example.filelistener.listener;

import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @ClassName : SmartFileListenerRunner
 * @Description : SpringBoot 启动是执行
 * @Author : Mr.Wang
 * @Date : 2020-07-04 17:03
 **/

@Component
public class SmartFileListenerRunner implements CommandLineRunner {

    @Autowired
    private SmartFileListenerFactory fileListenerFactory;

    @Override
    public void run(String... args) throws Exception {
        // 创建监听者
        FileAlterationMonitor fileAlterationMonitor = fileListenerFactory.getMonitor();
        try {
            // do not stop this thread
            fileAlterationMonitor.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
