package com.liumapp.workable.converter.demo;

import org.jodconverter.JodConverter;
import org.jodconverter.document.DefaultDocumentFormatRegistry;
import org.jodconverter.office.LocalOfficeManager;
import org.jodconverter.office.OfficeException;
import org.jodconverter.office.OfficeManager;

import java.io.*;

/**
 * file ConvertByStreamDemo.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/4/26
 */
public class ConvertByStreamDemo {

    public static void main (String[] args) throws Exception {
        InputStream is = new FileInputStream(new File("./data/test2_2.docx"));
        OutputStream os = new FileOutputStream(new File("./data/test2_2.pdf"));

        OfficeManager officeManager = LocalOfficeManager.builder()
                .install()
                .portNumbers(2002, 2003, 2004, 2005)
                .officeHome("C:\\Program Files\\LibreOffice")
                .build();

        officeManager.start();
        JodConverter
                .convert(is)
                .as(DefaultDocumentFormatRegistry.DOCX)
                .to(os)
                .as(DefaultDocumentFormatRegistry.PDF)
                .execute();

        os.flush();
        os.close();
        is.close();
    }

}
