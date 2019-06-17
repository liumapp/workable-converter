package com.liumapp.workable.converter.config;

import com.liumapp.workable.converter.enums.FontType;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class PdfEditDTO {

    /**
     * 字体大小
     */
    private Integer fontSize;

    /**
     * 内容宽
     */
    private Float width;

    /**
     * 内容高
     */
    private Float heitht;

    /**
     * 占位符别名
     */
    private String fieldName;

    /**
     * 合同页数
     */
    private Integer pageNum;

    /**
     * 左下角X
     */
    private Float positionX;

    /**
     * 左下角Y
     */
    private Float positionY;

    /**
     * 填充的文本内容
     */
    private String text;

    /**
     * 字体类型（枚举） 默认宋体
     */
    private FontType fontType = FontType.SIMHEI;

    private Integer fontTypeNum = 0;


    public FontType getFontType() {
        List<FontType> fontTypeList =
                Arrays.asList(FontType.SIMSUN,FontType.SIMKAI, FontType.SIMHEI,FontType.SIMYOU,FontType.STKAITI);
        if (this.fontTypeNum >= fontTypeList.size()) {
            return fontTypeList.get(0);
        }
        return fontTypeList.get(this.fontTypeNum);
    }
}
