package com.liumapp.workable.converter.demo;

import org.jodconverter.DocumentConverter;
import org.jodconverter.JodConverter;
import org.jodconverter.LocalConverter;
import org.jodconverter.office.LocalOfficeManager;
import org.jodconverter.office.OfficeException;
import org.jodconverter.office.OfficeManager;

import java.io.File;

/**
 * file ConvertByFilePathdemo.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/4/26
 */
public class ConvertByFilePathdemo {

    public static void main (String[] args) {

        //convert by file path
        File inputFile = new File("./data/test.doc");
        File outputFile = new File("./data/test.pdf");

        OfficeManager officeManager = LocalOfficeManager.builder()
                .install()
                .portNumbers(2002, 2003, 2004, 2005)
                .officeHome("C:\\Program Files\\LibreOffice")
                .build();

        try {
            officeManager.start();
            JodConverter.convert(inputFile).to(outputFile).execute();
        } catch (OfficeException e) {
            e.printStackTrace();
        }

    }


}