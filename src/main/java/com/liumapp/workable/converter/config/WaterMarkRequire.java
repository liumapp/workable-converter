package com.liumapp.workable.converter.config;

import com.liumapp.workable.converter.core.Parameter;
import lombok.Data;

import java.io.Serializable;

/**
 * file WaterMarkRequire.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/30
 */
@Data
public class WaterMarkRequire implements Parameter, Serializable {

    private static final long serialVersionUID = -2036663284702922443L;

    private String waterMarkPicBase64;

    private byte[] waterMarkPicBytes;

    /**
     * the page which need water mark
     * 0: means all page
     */
    private int waterMarkPage;

//    private

    public WaterMarkRequire() {
    }



}
