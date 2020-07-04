package com.example.filelistener.service.impl;

import com.example.filelistener.service.SmartFileListenerService;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @ClassName : SmartFileListenerServiceImpl
 * @Description : TODO
 * @Author : Mr.Wang
 * @Date : 2020-07-04 16:56
 **/

@Service
public class SmartFileListenerServiceImpl implements SmartFileListenerService {
    @Override
    public void onDirectoryCreate(File directory) {
        System.out.println("find new directory : " + directory.getName());
    }

    @Override
    public void onFileCreate(File file) {
        System.out.println("find new file : " + file.getName());
        System.out.println("in path       : " + file.getPath());
    }
}
