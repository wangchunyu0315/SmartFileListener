package com.example.filelistener.service;

import java.io.File;

/**
 * @ClassName : SmartFileListenerService
 * @Description : TODO
 * @Author : Mr.Wang
 * @Date : 2020-07-04 16:55
 **/

public interface SmartFileListenerService {
    void onDirectoryCreate(File directory);

    void onFileCreate(File file);
}
