package com.liumapp.workable.converter;

import com.liumapp.workable.converter.core.ConvertPattern;
import com.liumapp.workable.converter.factory.CommonConverterManager;
import com.liumapp.workable.converter.factory.ConvertPatternManager;
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
        ConvertPattern require = ConvertPatternManager.getInstance();
        switch (orders) {
            case ConvertDocToPDF:
                String inputFilePath = textIO.newStringInputReader().withDefaultValue("./data/test.doc").read("请输入要转换的doc文件地址：");
                String outputFilePaht = textIO.newStringInputReader().withDefaultValue("./data/result.pdf").read("请输入转换后的pdf文件保存地址：");
                require.setConvertByFilePathRequire(
                    inputFilePath, outputFilePaht
                );
                workableConverter.setConverterType(CommonConverterManager.getInstance());
                boolean result = workableConverter.convert(require.getParameter());
                if (result) {
                    textIO.getTextTerminal().dispose("转换成功！");
                } else {
                    textIO.getTextTerminal().dispose("转换失败！");
                }
                break;
            case ConvertHtmlToPDF:
                //todo
                break;
            case ConvertDocToPng:
                //todo
                break;
            case ConvertPngToPDF:
                //todo
                break;
            default:
                break;
        }
        tryAgain();
    }

    private static void tryAgain () throws Exception {
        boolean again = textIO.newBooleanInputReader().withDefaultValue(true).read("再来一次？");
        if (again) {
            showPrimaryMenu();
        } else {
            System.exit(-1);
        }
    }

}
