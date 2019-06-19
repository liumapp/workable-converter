package com.liumapp.workable.converter.strategies;

import com.liumapp.qtools.file.base64.Base64FileTool;
import com.liumapp.workable.converter.WorkableConverter;
import com.liumapp.workable.converter.config.EditorRequire;
import com.liumapp.workable.converter.core.ConvertPattern;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import com.liumapp.workable.converter.factory.ConvertPatternManager;
import com.liumapp.workable.converter.factory.HtmlToPdfByItextConverterManager;
import org.jodconverter.document.DefaultDocumentFormatRegistry;
import org.junit.Test;
import java.io.IOException;
import java.util.Base64;

import static org.junit.Assert.assertEquals;

/**
 * Created by Haoxy on 2019-06-18.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
public class ItextConverterTest {

    @Test
    public void testItextConverter() throws ConvertFailedException, IOException {
        WorkableConverter converter = new WorkableConverter();
        converter.setConverterType(HtmlToPdfByItextConverterManager.getInstance());
        ConvertPattern pattern = ConvertPatternManager.getInstance();
        EditorRequire editorRequire = new EditorRequire();
        editorRequire.setContent("<html><div>你好,word</div></html>");
        pattern.setEditorRequire(editorRequire);
        pattern.setSrcFilePrefix(DefaultDocumentFormatRegistry.HTML);
        pattern.setDestFilePrefix(DefaultDocumentFormatRegistry.PDF);
        String base64 = Base64.getEncoder().encodeToString(editorRequire.getContent().getBytes());
        pattern.base64ToBase64(base64);
        assertEquals(true,converter.convert(pattern.getParameter()));
        String base64Result = pattern.getBase64Result();
        Base64FileTool.saveBase64File(base64Result,"./data/test2.pdf");
    }
}
