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

    /**
     * convert by filepath
     * @param srcWaitingConvertFilePath file path to be convert
     * @param destConvertedFilePath file path converted
     * @throws ConvertFailedException
     */
    public void setConvertByFilePathRequire (String srcWaitingConvertFilePath, String destConvertedFilePath) throws ConvertFailedException;

    /**
     * convert by stream
     * @param srcStream data to be convert
     * @param destStream data converted
     */
    public void setConvertByStream (InputStream srcStream, OutputStream destStream);

    /**
     * convert by base64
     * @param srcBase64 the base64 of src file to be convert
     */
    public void setConvertByBase64(String srcBase64);

    /**
     * return base64 result
     * @return String the base64 result of converted value
     */
    public String getBase64Result();

    public void choicePatterns (Patterns patterns);

    public void setSrcFilePrefix (DocumentFormat formatRegistry);

    public void setDestFilePrefix (DocumentFormat formatRegistry);

    public Parameter getParameter ();

}
