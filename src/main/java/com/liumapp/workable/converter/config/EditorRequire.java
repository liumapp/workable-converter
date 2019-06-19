package com.liumapp.workable.converter.config;

import com.liumapp.workable.converter.core.Parameter;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Haoxy on 2019-06-18.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
@Data
public class EditorRequire implements Parameter, Serializable {

    private String content;

    public EditorRequire() {
    }

    public EditorRequire(String content) {
        this.content = content;
    }
}
