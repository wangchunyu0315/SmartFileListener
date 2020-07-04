package com.example.filelistener.listener;

import com.example.filelistener.service.SmartFileListenerService;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;

/**
 * @ClassName : SmartFileListener
 * @Description : TODO
 * @Author : Mr.Wang
 * @Date : 2020-07-04 16:53
 **/

public class SmartFileListener extends FileAlterationListenerAdaptor {

    // 声明业务服务
    private SmartFileListenerService listenerService;

    /**
     * @Description : 采用构造函数注入服务
     * @Param       :
     * @return      :
     * @Author      : Mr.Wang
     * @Date        : 2020-07-04 17:27
     */
    public SmartFileListener(SmartFileListenerService listenerService) {
        this.listenerService = listenerService;
    }

    /**
     * @Description : 文件创建执行
     * @Param       :
     * @return      :
     * @Author      : Mr.Wang
     * @Date        : 2020-07-04 17:27
     */
    @Override
    public void onFileCreate(File file) {
        System.out.println("new file : " + file.getName());
        listenerService.onFileCreate(file);
    }

    /**
     * @Description : 文件创建修改
     * @Param       :
     * @return      :
     * @Author      : Mr.Wang
     * @Date        : 2020-07-04 17:27
     */
    @Override
    public void onFileChange(File file) {
        System.out.println("change file : " + file.getName());

        listenerService.onFileCreate(file);
    }

    /**
     * @Description : 文件创建删除
     * @Param       :
     * @return      :
     * @Author      : Mr.Wang
     * @Date        : 2020-07-04 17:28
     */
    @Override
    public void onFileDelete(File file) {
    }

    /** 目录创建
     * @Description :
     * @Param       :
     * @return      :
     * @Author      : Mr.Wang
     * @Date        : 2020-07-04 17:27
     */
    @Override
    public void onDirectoryCreate(File directory) {
        // 触发业务
        listenerService.onDirectoryCreate(directory);
    }

    /** 目录修改
     * @Description :
     * @Param       :
     * @return      :
     * @Author      : Mr.Wang
     * @Date        : 2020-07-04 17:27
     */
    @Override
    public void onDirectoryChange(File directory) {
    }

    /**
     * @Description : 目录删除
     * @Param       :
     * @return      :
     * @Author      : Mr.Wang
     * @Date        : 2020-07-04 17:28
     */
    @Override
    public void onDirectoryDelete(File directory) {
    }


    /**
     * @Description : 轮询开始
     * @Param       :
     * @return      :
     * @Author      : Mr.Wang
     * @Date        : 2020-07-04 17:28
     */
    @Override
    public void onStart(FileAlterationObserver observer) {
    }

    /**
     * @Description : 轮询结束
     * @Param       :
     * @return      :
     * @Author      : Mr.Wang
     * @Date        : 2020-07-04 17:28
     */
    @Override
    public void onStop(FileAlterationObserver observer) {
    }
}
