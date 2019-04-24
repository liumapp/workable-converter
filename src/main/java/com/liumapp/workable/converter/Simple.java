package com.liumapp.workable.converter;

import java.util.Date;
import java.io.File;
import com.sun.star.beans.PropertyValue;
import com.sun.star.comp.helper.Bootstrap;
import com.sun.star.frame.XComponentLoader;
import com.sun.star.frame.XDesktop;
import com.sun.star.frame.XStorable;
import com.sun.star.lang.XComponent;
import com.sun.star.lang.XMultiComponentFactory;
import com.sun.star.text.XTextDocument;
import com.sun.star.uno.UnoRuntime;
import com.sun.star.uno.XComponentContext;
import com.sun.star.util.XReplaceDescriptor;
import com.sun.star.util.XReplaceable;
/**
 * file Simple.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/4/24
 */
public class Simple {

    public static void main (String[] args) throws Exception {
        // Initialise
        XComponentContext xContext = Bootstrap.bootstrap();

        XMultiComponentFactory xMCF = xContext.getServiceManager();

        Object oDesktop = xMCF.createInstanceWithContext(
                "com.sun.star.frame.Desktop", xContext);

        XDesktop xDesktop = (XDesktop) UnoRuntime.queryInterface(
                XDesktop.class, oDesktop);

        // Load the Document
        String workingDir = "D:/project/workable-converter/";
        String myTemplate = "letterTemplate.doc";

        if (!new File(workingDir + myTemplate).canRead()) {
            throw new RuntimeException("Cannot load template:" + new File(workingDir + myTemplate));
        }

        XComponentLoader xCompLoader = (XComponentLoader) UnoRuntime
                .queryInterface(com.sun.star.frame.XComponentLoader.class, xDesktop);

        String sUrl = "file:///" + workingDir + myTemplate;

        PropertyValue[] propertyValues = new PropertyValue[0];

        propertyValues = new PropertyValue[1];
        propertyValues[0] = new PropertyValue();
        propertyValues[0].Name = "Hidden";
        propertyValues[0].Value = new Boolean(true);

        XComponent xComp = xCompLoader.loadComponentFromURL(
                sUrl, "_blank", 0, propertyValues);
    }

}
