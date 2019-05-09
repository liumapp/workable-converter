package com.liumapp.workable.converter.factory;

/**
 * file WorkableConverterManager.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/9
 */
public class WorkableConverterManager implements Manager {

    private static WorkableConverterManager INSTANCE;

    private WorkableConverterManager() {
    }

    public WorkableConverterManager getInstance () {
        if (INSTANCE == null) {
            INSTANCE = new WorkableConverterManager();
        }
        return INSTANCE;
    }
}
