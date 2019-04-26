package com.liumapp.workable.converter.demo;

import org.jodconverter.LocalConverter;
import org.jodconverter.office.LocalOfficeManager;
import org.jodconverter.office.OfficeManager;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * file UsingFileterDemo.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/4/26
 */
public class UsingFileterDemo {

    public static void main (String[] args) throws Exception {
        File inputFile = new File("./data/test2.docx");
        File outputFile = new File("./data/test2_convert_page2.pdf");
        Map<String, Object> filterData = new HashMap<>();
        filterData.put("PageRange", "2");
        Map<String, Object> customProperties = new HashMap<>();
        customProperties.put("FilterData", filterData);

        OfficeManager officeManager = LocalOfficeManager.builder()
                .install()
                .portNumbers(2002, 2003, 2004, 2005)
                .officeHome("C:\\Program Files\\LibreOffice")
                .build();

        officeManager.start();
        LocalConverter
                .builder()
                .storeProperties(customProperties)
                .build()
                .convert(inputFile)
                .to(outputFile)
                .execute();
    }

}
