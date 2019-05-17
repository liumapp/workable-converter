package com.liumapp.workable.converter.strategies;

import com.liumapp.qtools.file.basic.FileTool;
import com.liumapp.qtools.str.basic.StrTool;
import com.liumapp.qtools.str.suffix.SuffixTool;
import com.liumapp.workable.converter.config.ConvertRequire;
import com.liumapp.workable.converter.core.Parameter;
import com.liumapp.workable.converter.enums.Patterns;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.image.BufferedImage;
import java.io.File;

/**
 * file PdfBoxConverter.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/16
 */
public class PdfBoxConverter extends ConverterStrategy {

    private static Logger logger = LoggerFactory.getLogger(PdfBoxConverter.class);

    @Override
    public boolean convert (Parameter require) throws ConvertFailedException {
        logger.info("pdf box converter begin: ");
        return accordingRequire((ConvertRequire) require);
    }

    /**
     * todo
     */
    @Override
    protected boolean byFilePath (ConvertRequire require) throws ConvertFailedException {
        throw new ConvertFailedException("pdf box converter do not support by file path convert pattern right now");
    }

    @Override
    protected boolean byFileFolder(ConvertRequire require) throws ConvertFailedException {
        logger.info("pdfbox convert by file folder begin :");
        try {
            File srcFile = new File(require.getWaitingFilePath());
            PDDocument document = PDDocument.load(srcFile);
            PDFRenderer renderer = new PDFRenderer(document);
            for (int page = 0; page < document.getNumberOfPages(); page++) {
                BufferedImage image = renderer.renderImageWithDPI(page, 300, ImageType.RGB);
                String savename = require.getDestConvertedPath() + "/" + SuffixTool.deleteSuffix(srcFile.getName()) + "_" + page + ".png";
                ImageIOUtil.writeImage(image, savename, 300);
            }
            document.close();
        } catch (Exception e) {
            throw new ConvertFailedException(e.getMessage());
        }
        return true;
    }

    /**
     * todo
     */
    @Override
    protected boolean byStream (ConvertRequire require) throws ConvertFailedException {
        throw new ConvertFailedException("pdf box converter do not support by stream right now");
    }

    /**
     * todo
     */
    @Override
    protected boolean byBase64 (ConvertRequire require) throws ConvertFailedException {
        logger.info("pdfbox convert by base64 begin:");
        try {

        } catch (Exception e) {
            throw new ConvertFailedException(e.getMessage());
        }
        return true;
    }



}
