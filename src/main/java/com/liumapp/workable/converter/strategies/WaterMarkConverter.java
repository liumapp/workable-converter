package com.liumapp.workable.converter.strategies;

import com.liumapp.qtools.file.base64.Base64FileTool;
import com.liumapp.workable.converter.config.ConvertRequire;
import com.liumapp.workable.converter.config.WaterMarkRequire;
import com.liumapp.workable.converter.core.Parameter;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.multipdf.Overlay;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.HashMap;

/**
 * file WaterMarkConverter.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/29
 */
public class WaterMarkConverter extends ConverterStrategy {

    private static Logger logger = LoggerFactory.getLogger(WaterMarkConverter.class);

    @Override
    public boolean convert(Parameter require) throws ConvertFailedException {
        logger.info("watermark converter begin at : " + ZonedDateTime.now());
        return accordingRequire((ConvertRequire) require);
    }

    @Override
    public boolean byFilePath(ConvertRequire require) throws ConvertFailedException {
        try {
            PDDocument pdfFile = PDDocument.load(new File(require.getWaitingFilePath()));
            HashMap<Integer, String> overlayGuide = new HashMap<>();

            String tmpName = this.getTmpName(require.getWaterMarkRequire());

            //0 means add watermark in all page
            if (require.getWaterMarkRequire().getWaterMarkPage() == 0) {
                for (int i = 0; i < pdfFile.getNumberOfPages(); i++) {
                    overlayGuide.put(i + 1, tmpName);
                }
            } else {
                overlayGuide.put(require.getWaterMarkRequire().getWaterMarkPage(), tmpName);
            }
            Overlay overlay = new Overlay();
            overlay.setInputPDF(pdfFile);
            overlay.setOverlayPosition(Overlay.Position.BACKGROUND);
            overlay.overlay(overlayGuide);
            pdfFile.save(require.getResultFilePath());
        } catch ( IOException e) {
            throw new ConvertFailedException(e.getMessage());
        }

        return true;
    }

    @Deprecated
    @Override
    public boolean byFileFolder(ConvertRequire require) throws ConvertFailedException {
        throw new ConvertFailedException("waterMark converter do not support by file folder");
    }

    @Override
    public boolean byStream(ConvertRequire require) throws ConvertFailedException {
        try {
            PDDocument pdfFile = PDDocument.load(require.getSrcStream());
            HashMap<Integer, String> overlayGuide = new HashMap<>();

            String tmpName = this.getTmpName(require.getWaterMarkRequire());
            //0 means add watermark in all page
            if (require.getWaterMarkRequire().getWaterMarkPage() == 0) {
                for (int i = 0; i < pdfFile.getNumberOfPages(); i++) {
                    overlayGuide.put(i + 1, tmpName);
                }
            } else {
                overlayGuide.put(require.getWaterMarkRequire().getWaterMarkPage(), tmpName);
            }
            Overlay overlay = new Overlay();
            overlay.setInputPDF(pdfFile);
            overlay.setOverlayPosition(Overlay.Position.BACKGROUND);
            overlay.overlay(overlayGuide);
            pdfFile.save(require.getDestStream());
        } catch (IOException e) {
            throw new ConvertFailedException(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean byBase64(ConvertRequire require) throws ConvertFailedException {
        try {
            String tmpFileName = this.saveTmpFileByBase64(require.getSrcBase64(), "pdf");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PDDocument pdfFile = PDDocument.load(new File(tmpFileName));
            HashMap<Integer, String> overlayGuide = new HashMap<>();
            String tmpName = this.getTmpName(require.getWaterMarkRequire());
            //0 means add watermark in all page
            if (require.getWaterMarkRequire().getWaterMarkPage() == 0) {
                for (int i = 0; i < pdfFile.getNumberOfPages(); i++) {
                    overlayGuide.put(i + 1, tmpName);
                }
            } else {
                overlayGuide.put(require.getWaterMarkRequire().getWaterMarkPage(), tmpName);
            }
            Overlay overlay = new Overlay();
            overlay.setInputPDF(pdfFile);
            overlay.setOverlayPosition(Overlay.Position.BACKGROUND);
            overlay.overlay(overlayGuide);
            pdfFile.save(byteArrayOutputStream);
            require.setDestBase64(Base64FileTool.ByteArrayToBase64(byteArrayOutputStream.toByteArray()));
        } catch (IOException e) {
            throw new ConvertFailedException(e.getMessage());
        }
        return true;
    }

    private String getTmpName (WaterMarkRequire require) throws IOException, ConvertFailedException {
        if (require.getWaterMarkPDFBase64() != null) {
            return saveTmpFileByBase64(require.getWaterMarkPDFBase64(), "pdf");
        } else if (require.getWaterMarkPDFBytes() != null) {
            return saveTmpFileByBytes(require.getWaterMarkPDFBytes(), "pdf");
        } else {
            throw new ConvertFailedException("water mark pdf must be specified");
        }
    }


}
