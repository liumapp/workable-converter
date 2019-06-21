package com.liumapp.workable.converter.strategies;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.attach.impl.DefaultTagWorkerFactory;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.font.FontProvider;
import com.liumapp.qtools.file.base64.Base64FileTool;
import com.liumapp.workable.converter.config.ConvertRequire;
import com.liumapp.workable.converter.core.Parameter;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.time.ZonedDateTime;


/**
 * Created by Haoxy on 2019-06-18.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
public class ItextConverter extends ConverterStrategy {

    public static final String FONT = "msyh.ttf";

    private static final String RESOURCE_PREFIX_INDEX = "/tmp/pdf/";

    private static final String RESOURCE_SUFFIX = "-itext";

    private static Logger logger = LoggerFactory.getLogger(ItextConverter.class);


    /**
     * @param pdfFileName
     * @param htmlString     : html文件内容
     * @param resourcePrefix
     */
    private String createPdfFromHtml(String pdfFileName, String htmlString, String resourcePrefix) throws ConvertFailedException {
        PdfDocument pdfDoc = null;
        try {
            FileOutputStream outputStream = new FileOutputStream(resourcePrefix + pdfFileName);
            //ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            WriterProperties writerProperties = new WriterProperties();
            writerProperties.addXmpMetadata();
            PdfWriter pdfWriter = new PdfWriter(outputStream, writerProperties);
            pdfDoc = createPdfDoc(pdfWriter);
            ConverterProperties props = createConverterProperties(resourcePrefix);
            logger.info("Start the conversion task...");
            HtmlConverter.convertToPdf(htmlString, pdfDoc, props);
            //String base64 = Base64FileTool.ByteArrayToBase64(outputStream.toByteArray());
            String base64 = Base64FileTool.filePathToBase64(resourcePrefix + pdfFileName);
            FileUtils.forceDelete(new File(resourcePrefix + pdfFileName));
            if (base64 != null && !"".equals(base64)) {
                logger.info("Conversion task completed...");
            }
            return base64;
        } catch (Exception e) {
            logger.error("failed to create pdf from html exception: ", e);
            throw new ConvertFailedException("failed to create pdf from html exception");
        } finally {
            pdfDoc.close();
        }
    }

    private void copyFont(String dirStr) {
        try {
            File file = new File(dirStr + FONT);
            if (file.exists()) {
                return;
            }
            InputStream inputStream = ItextConverter.class.getClassLoader().getResourceAsStream("./font/" + FONT);
            File dir = new File(dirStr);
            FileUtils.forceMkdir(dir);
            FileOutputStream fout = new FileOutputStream(file);
            if (inputStream != null && fout != null) {
                IOUtils.copy(inputStream, fout);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ConverterProperties createConverterProperties(String resourcePrefix) {
        ConverterProperties props = new ConverterProperties();
        props.setFontProvider(createFontProvider(resourcePrefix));
        props.setBaseUri(resourcePrefix);
        props.setCharset("UTF-8");
        DefaultTagWorkerFactory tagWorkerFactory = new DefaultTagWorkerFactory();
        props.setTagWorkerFactory(tagWorkerFactory);
        return props;
    }

    private FontProvider createFontProvider(String resourcePrefix) {
        FontProvider fp = new FontProvider();
        fp.addStandardPdfFonts();
        fp.addDirectory(resourcePrefix);
        return fp;
    }

    private PdfDocument createPdfDoc(PdfWriter pdfWriter) {
        PdfDocument pdfDoc;
        pdfDoc = new PdfDocument(pdfWriter);
        pdfDoc.getCatalog().setLang(new PdfString("zh-CN"));
        pdfDoc.setTagged();
        pdfDoc.getCatalog().setViewerPreferences(new PdfViewerPreferences().setDisplayDocTitle(true));
        return pdfDoc;
    }

    @Override
    protected boolean byFilePath(ConvertRequire require) throws ConvertFailedException {
        throw new ConvertFailedException("text converter do not support by file path");
    }

    @Override
    protected boolean byFileFolder(ConvertRequire require) throws ConvertFailedException {
        throw new ConvertFailedException("text converter do not support by file folder");
    }

    @Override
    protected boolean byStream(ConvertRequire require) throws ConvertFailedException {
        throw new ConvertFailedException("text converter do not support by file stream");
    }

    @Override
    protected boolean byBase64(ConvertRequire require) throws ConvertFailedException {
        String content = require.getEditorRequire().getContent();
        String tempFile = ItextConverter.RESOURCE_PREFIX_INDEX;
        createDirs(tempFile);
        //安装字体
        copyFont(tempFile);
        File pdfFile = createFlawPdfFile(tempFile, System.currentTimeMillis() + ItextConverter.RESOURCE_SUFFIX);
        String baseResult = createPdfFromHtml(pdfFile.getName(), content, tempFile);
        if (baseResult != null) {
            require.setDestBase64(baseResult);
            return true;
        }
        return false;
    }


    @Override
    public boolean convert(Parameter require) throws ConvertFailedException {
        logger.info("text converter begin at : " + ZonedDateTime.now());
        return accordingRequire((ConvertRequire) require);
    }

    private static void createDirs(String dirsPath) {
        File temFile = new File(dirsPath);
        if (!temFile.exists()) {
            temFile.mkdirs();
        }
    }

    private static File createFlawPdfFile(String fileDir, String fileName) {
        File tempFile;
        do {
            tempFile = new File(fileDir + fileName + ".pdf");
        } while (tempFile.exists());
        return tempFile;
    }
}
