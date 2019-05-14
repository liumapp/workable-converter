package com.liumapp.workable.converter;

import com.liumapp.workable.converter.config.ConvertRequire;
import com.liumapp.workable.converter.factory.ConvertRequireManager;
import com.liumapp.workable.converter.factory.DocToPdfConverterManager;
import com.liumapp.workable.converter.enums.Orders;
import com.liumapp.workable.converter.proxies.ConverterProxy;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

/**
 * file Console.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/13
 */
public class Console {

    public static TextIO textIO;

    public static WorkableConverter workableConverter;

    public static void main (String[] args) throws Exception {
        textIO = TextIoFactory.getTextIO();
        textIO.getTextTerminal().getProperties().setPaneWidth(1280);
        textIO.getTextTerminal().getProperties().setPaneHeight(960);

        workableConverter = ConverterProxy.getInstance().getProxy();
        showPrimaryMenu();
    }

    private static void showPrimaryMenu () throws Exception {
        Orders orders = textIO.newEnumInputReader(Orders.class)
                .read("choice your order...");
        try {
            handOrder(orders);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

    }

    private static void handOrder (Orders orders) throws Exception {
        ConvertRequire require = ConvertRequireManager.getInstance();
        switch (orders) {
            case ConvertDocToPDF:
                String inputFilePath = textIO.newStringInputReader().read("请输入要转换的doc文件地址（./data/test.doc）：");
                inputFilePath = (inputFilePath == null || inputFilePath.length() == 0) ? "./data/test.doc" : inputFilePath;
                String outputFilePaht = textIO.newStringInputReader().read("请输入转换后的pdf文件保存地址(./data/result.pdf)");
                outputFilePaht = (outputFilePaht == null || outputFilePaht.length() == 0) ? "./data/result.pdf" : outputFilePaht;
                require.setConvertByFilePathRequire(
                    inputFilePath, outputFilePaht
                );
                workableConverter.setConverterType(DocToPdfConverterManager.getInstance());
                workableConverter.convertByFilePath(require);
                textIO.dispose("转换成功！");
                break;
            case ConvertHtmlToPDF:

                break;
            case ConvertDocToPng:
                break;
            case ConvertPngToPDF:
                break;
            default:
                break;
        }
        showPrimaryMenu();
    }

}
