package com.liumapp.workable.converter.strategies;

import com.liumapp.qtools.file.base64.Base64FileTool;
import com.liumapp.qtools.str.random.StrRandomTool;
import com.liumapp.qtools.str.suffix.SuffixTool;
import com.liumapp.workable.converter.config.ConvertRequire;
import com.liumapp.workable.converter.config.ConverterConfig;
import com.liumapp.workable.converter.core.Parameter;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import com.liumapp.workable.converter.factory.ConverterConfigManager;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.image.BufferedImage;
import java.io.File;
import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.List;

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

    private static ConverterConfig params = ConverterConfigManager.getInstance().getParams();

    @Override
    public boolean convert (Parameter require) throws ConvertFailedException {
        logger.info("pdf box converter begin at : " + ZonedDateTime.now());
        return accordingRequire((ConvertRequire) require);
    }

    /**
     * todo
     */
    @Deprecated
    @Override
    public boolean byFilePath (ConvertRequire require) throws ConvertFailedException {
        throw new ConvertFailedException("pdf box converter do not support by file path convert pattern right now");
    }

    @Override
    public boolean byFileFolder(ConvertRequire require) throws ConvertFailedException {
        logger.info("pdfbox convert by file folder begin(src file must be a pdf file) :");
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
        logger.info("pdf box convert by filepath success");
        return true;
    }

    /**
     * todo
     */
    @Deprecated
    @Override
    public boolean byStream (ConvertRequire require) throws ConvertFailedException {
        throw new ConvertFailedException("pdf box converter do not support by stream right now");
    }

    /**
     * convert a pdf base64 file to png pics
     */
    @Override
    public boolean byBase64 (ConvertRequire require) throws ConvertFailedException {
        logger.info("pdfbox convert by base64 begin(src file must be a pdf file):");
        try {
            String srcFileTmpName = StrRandomTool.getUuid(true) + ".pdf";
            Base64FileTool.saveBase64File(require.getSrcBase64(), params.getTmpPath() + "/" + srcFileTmpName);
            File srcFile = new File(params.getTmpPath() + "/" + srcFileTmpName);
            PDDocument document = PDDocument.load(srcFile);
            PDFRenderer renderer = new PDFRenderer(document);
            List<String> results = new LinkedList<>();
            for (int page = 0; page < document.getNumberOfPages(); page++) {
                BufferedImage image = renderer.renderImageWithDPI(page, 300, ImageType.RGB);
                String savePath = params.getTmpPath() + "/" + SuffixTool.deleteSuffix(srcFile.getName()) + "_" + page + ".png";
                ImageIOUtil.writeImage(image, savePath, 300);
                results.add(Base64FileTool.filePathToBase64(savePath));
            }
            require.setDestBase64s(results);
            document.close();
        } catch (Exception e) {
            throw new ConvertFailedException(e.getMessage());
        }
        logger.info("pdf box convert by base64 success");
        return true;
    }



}
