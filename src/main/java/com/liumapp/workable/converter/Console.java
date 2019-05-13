package com.liumapp.workable.converter;

import com.liumapp.workable.converter.config.ConvertRequire;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import com.liumapp.workable.converter.factory.DocToPdfConverterManager;
import com.liumapp.workable.converter.orders.Orders;
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

    public static void main (String[] args) throws ConvertFailedException {
        textIO = TextIoFactory.getTextIO();
        textIO.getTextTerminal().getProperties().setPaneWidth(1280);
        textIO.getTextTerminal().getProperties().setPaneHeight(960);

        workableConverter = ConverterProxy.getInstance().getProxy();
        showPrimaryMenu();
    }

    private static void showPrimaryMenu () throws ConvertFailedException {
        Orders orders = textIO.newEnumInputReader(Orders.class)
                .read("choice your order...");
        handOrder(orders);
    }

    private static void handOrder (Orders orders) throws ConvertFailedException {
        ConvertRequire require = new ConvertRequire();
        switch (orders) {
            case ConvertDocToPDF:
                require.setConvertByFilePathRequire(
                        textIO.newStringInputReader().read("请输入要转换的doc文件地址（./data/test.doc）："),
                        textIO.newStringInputReader().read("请输入转换后的pdf文件保存地址(./data/result.pdf)")
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
