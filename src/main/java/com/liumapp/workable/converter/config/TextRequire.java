package com.liumapp.workable.converter.config;

import com.liumapp.workable.converter.core.Parameter;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TextRequire implements Parameter, Serializable {

    /**
     * pdf模板表单数据
     */
    private List<PdfEditDTO> pdfEditDTOList;
}
