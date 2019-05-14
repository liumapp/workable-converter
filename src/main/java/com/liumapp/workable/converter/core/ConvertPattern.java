package com.liumapp.workable.converter.core;

import com.liumapp.workable.converter.enums.Patterns;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import org.jodconverter.document.DefaultDocumentFormatRegistry;
import org.jodconverter.document.DocumentFormat;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * file ConvertPattern.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/13
 */
public interface ConvertPattern extends Parameter {

    public void setConvertByFilePathRequire (String srcWaitingConvertFilePath, String destConvertedFilePath) throws ConvertFailedException;

    /**
     * convert by stream
     * @param inputStream 输入流包含要转换的文件数据
     * @param outputStream 输出流包含转换结果的文件数据
     */
    public void setConvertByStream (InputStream inputStream, OutputStream outputStream);

    public void choicePatterns (Patterns patterns);

    public void setSrcFilePrefix (DocumentFormat formatRegistry);

    public void setDestFilePrefix (DocumentFormat formatRegistry);

    public Parameter getParameter ();

}
