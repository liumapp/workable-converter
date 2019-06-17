package com.liumapp.workable.converter.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FontType {

    /**
     * 宋体
     */
    SIMSUN(0,"SIMSUN.TTF"),

    /**
     * 楷体
     */
    SIMKAI(1,"SIMKAI.TTF"),

    /**
     * 黑体
     */
    SIMHEI(2,"SIMHEI.TTF"),

    /**
     * 华文幼圆
     */
    SIMYOU(3,"SIMYOU.TTF"),

    /**
     * 华文楷体
     */
    STKAITI(4,"STKAITI.TTF"),



    ;

    private Integer type;

    private String font;
}
