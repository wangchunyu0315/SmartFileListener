package com.example.filelistener.listener;

import com.example.filelistener.service.SmartFileListenerService;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.HiddenFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.apache.commons.io.IOCase.INSENSITIVE;

/**
 * @ClassName : SmartFileListenerFactory
 * @Description : 文件监听器工厂类
 * @Author : Mr.Wang
 * @Date : 2020-07-04 16:59
 **/
@Component
public class SmartFileListenerFactory {
    // 设置监听路径
    @Value("${file.listen.path}")
    private String monitorDir;

    @Value("${file.listen.interval}")
    private Long loopInterval;

    // 设置轮询间隔
    private final long interval = TimeUnit.SECONDS.toMillis(loopInterval);

    // 自动注入业务服务
    @Autowired
    private SmartFileListenerService listenerService;

    public FileAlterationMonitor getMonitor() {
        // 创建过滤器
        IOFileFilter directories = FileFilterUtils.and(
                FileFilterUtils.directoryFileFilter(),
                HiddenFileFilter.VISIBLE);
        IOFileFilter files = FileFilterUtils.or(
                FileFilterUtils.fileFileFilter(),
                FileFilterUtils.suffixFileFilter(".log", INSENSITIVE),
                FileFilterUtils.suffixFileFilter(".ok", INSENSITIVE),
                FileFilterUtils.suffixFileFilter(".end", INSENSITIVE),
                FileFilterUtils.suffixFileFilter(".txt", INSENSITIVE));
        IOFileFilter filter = FileFilterUtils.or(directories, files);

        // 装配过滤器
//         FileAlterationObserver observer = new FileAlterationObserver(monitorDir);
        FileAlterationObserver observer = new FileAlterationObserver(monitorDir, filter);

        // 向监听者添加监听器，并注入业务服务
        observer.addListener(new SmartFileListener(listenerService));

        // 返回监听者
        return new FileAlterationMonitor(interval, observer);
    }
}
