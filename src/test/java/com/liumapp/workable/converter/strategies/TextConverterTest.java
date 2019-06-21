package com.liumapp.workable.converter.strategies;

import com.liumapp.qtools.file.base64.Base64FileTool;
import com.liumapp.workable.converter.WorkableConverter;
import com.liumapp.workable.converter.config.PdfEditDTO;
import com.liumapp.workable.converter.config.TextRequire;
import com.liumapp.workable.converter.core.ConvertPattern;
import com.liumapp.workable.converter.enums.FontType;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import com.liumapp.workable.converter.factory.ConvertPatternManager;
import com.liumapp.workable.converter.factory.TextConverterManager;
import org.jodconverter.document.DefaultDocumentFormatRegistry;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TextConverterTest {

    @Test
    public void byFilePath() throws ConvertFailedException {
        WorkableConverter converter = new WorkableConverter();
        converter.setConverterType(TextConverterManager.getInstance());

        ConvertPattern pattern = ConvertPatternManager.getInstance();
        TextRequire templateRequire = new TextRequire();

        List<PdfEditDTO> pdfEditDTOList = new ArrayList<>();

        PdfEditDTO pdfEditDTO = new PdfEditDTO();
        pdfEditDTO.setFieldName("one");
        pdfEditDTO.setFontSize(18);
        pdfEditDTO.setFontType(FontType.SIMYOU);
        pdfEditDTO.setPositionX(0f);
        pdfEditDTO.setPositionY(10f);
        pdfEditDTO.setText("Hello World I am One Field");
        pdfEditDTO.setWidth(250f);
        pdfEditDTO.setHeight(20f);
        pdfEditDTO.setPageNum(1);

        pdfEditDTOList.add(pdfEditDTO);

        PdfEditDTO pdfEditDTO2 = new PdfEditDTO();
        pdfEditDTO2.setFieldName("two");
        pdfEditDTO2.setFontSize(18);
        pdfEditDTO2.setFontType(FontType.STKAITI);
        pdfEditDTO2.setPositionX(0f);
        pdfEditDTO2.setPositionY(820f);
        pdfEditDTO2.setText("Hello World I am Two Field");
        pdfEditDTO2.setWidth(250f);
        pdfEditDTO2.setHeight(20f);
        pdfEditDTO2.setPageNum(2);

        pdfEditDTOList.add(pdfEditDTO2);

        templateRequire.setPdfEditDTOList(pdfEditDTOList);

        pattern.setTextRequire(templateRequire);
        pattern.setSrcFilePrefix(DefaultDocumentFormatRegistry.PDF);
        pattern.setDestFilePrefix(DefaultDocumentFormatRegistry.PDF);
        pattern.fileToFile("./data/txt.pdf","./data/txt2.pdf");

        boolean result = converter.convert(pattern.getParameter());
        assertEquals(true, result);
    }

    @Test
    public void byBase64() throws IOException, ConvertFailedException {
        WorkableConverter converter = new WorkableConverter();
        converter.setConverterType(TextConverterManager.getInstance());

        ConvertPattern pattern = ConvertPatternManager.getInstance();
        TextRequire templateRequire = new TextRequire();

        List<PdfEditDTO> pdfEditDTOList = new ArrayList<>();

        PdfEditDTO pdfEditDTO = new PdfEditDTO();
        pdfEditDTO.setFieldName("one");
        pdfEditDTO.setFontSize(18);
        pdfEditDTO.setFontType(FontType.SIMYOU);
        pdfEditDTO.setPositionX(0f);
        pdfEditDTO.setPositionY(10f);
        pdfEditDTO.setText("Hello World I am One Field");
        pdfEditDTO.setWidth(250f);
        pdfEditDTO.setHeight(20f);
        pdfEditDTO.setPageNum(1);

        pdfEditDTOList.add(pdfEditDTO);

        PdfEditDTO pdfEditDTO2 = new PdfEditDTO();
        pdfEditDTO2.setFieldName("two");
        pdfEditDTO2.setFontSize(18);
        pdfEditDTO2.setFontType(FontType.STKAITI);
        pdfEditDTO2.setPositionX(0f);
        pdfEditDTO2.setPositionY(820f);
        pdfEditDTO2.setText("Hello World I am Two Field");
        pdfEditDTO2.setWidth(250f);
        pdfEditDTO2.setHeight(20f);
        pdfEditDTO2.setPageNum(2);

        pdfEditDTOList.add(pdfEditDTO2);

        templateRequire.setPdfEditDTOList(pdfEditDTOList);

        pattern.setTextRequire(templateRequire);
        pattern.setSrcFilePrefix(DefaultDocumentFormatRegistry.PDF);
        pattern.setDestFilePrefix(DefaultDocumentFormatRegistry.PDF);
        pattern.base64ToBase64(Base64FileTool.FileToBase64(new File("./data/txt.pdf")));

        boolean result = converter.convert(pattern.getParameter());
        String base64Result = pattern.getBase64Result();
        Base64FileTool.saveBase64File(base64Result,"./data/txt2.pdf");

    }
}
