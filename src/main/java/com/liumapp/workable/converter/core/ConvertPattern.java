package com.liumapp.workable.converter.core;

import com.liumapp.workable.converter.enums.Patterns;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import com.liumapp.workable.converter.exceptions.UnsupportedConverterParameterException;
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
     * @throws ConvertFailedException convert failed exception
     */
    @Deprecated
    public void setConvertByFilePathRequire (String srcWaitingConvertFilePath, String destConvertedFilePath) throws ConvertFailedException;

    /**
     * convert file to file
     * @param srcWaitingConvertFilePath src file path
     * @param destConvertedFilePath dest file path
     * @throws ConvertFailedException
     */
    public void fileToFile (String srcWaitingConvertFilePath, String destConvertedFilePath) throws ConvertFailedException;

    /**
     * convert by filepath
     * @param srcWaitingConvertFilePath file path to be convert
     * @param destConvertedPath folder path to save converted files
     * @throws ConvertFailedException convert failed exception
     */
    public void fileToFiles (String srcWaitingConvertFilePath, String destConvertedPath) throws ConvertFailedException;

    /**
     * convert by stream
     * @param srcStream data to be convert
     * @param destStream data converted
     */
    @Deprecated
    public void setConvertByStream (InputStream srcStream, OutputStream destStream) throws ConvertFailedException;

    /**
     * convert by stream
     * @param srcStream read data from src stream
     * @param destStream converted data to dest stream
     */
    public void streamToStream (InputStream srcStream, OutputStream destStream) throws ConvertFailedException;

    /**
     * convert by base64
     * @param srcBase64 the base64 of src file to be convert
     */
    @Deprecated
    public void setConvertByBase64(String srcBase64) throws ConvertFailedException;

    /**
     * convert by base64
     * @param srcBase64 the base64 of src file to be convert
     */
    public void base64ToBase64 (String srcBase64) throws ConvertFailedException;

    /**
     * return base64 result
     * @return String the base64 result of converted value
     */
    public String getBase64Result();

    public void choicePatterns (Patterns patterns);

    public void setSrcFilePrefix (DocumentFormat formatRegistry) throws UnsupportedConverterParameterException;

    public void setDestFilePrefix (DocumentFormat formatRegistry) throws UnsupportedConverterParameterException;

    public Parameter getParameter ();

}
