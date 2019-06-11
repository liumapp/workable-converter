package com.liumapp.workable.converter.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FontType {

    /**
     * 华文幼圆
     */
    SIMYOU(1,"SIMYOU.TTF"),

    /**
     * 楷体
     */
    STKAITI(2,"STKAITI.TTF")

    ;

    private Integer type;

    private String font;
}
