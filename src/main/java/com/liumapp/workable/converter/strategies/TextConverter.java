package com.liumapp.workable.converter.strategies;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfTextFormField;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.liumapp.qtools.file.base64.Base64FileTool;
import com.liumapp.workable.converter.config.ConvertRequire;
import com.liumapp.workable.converter.config.PdfEditDTO;
import com.liumapp.workable.converter.core.Parameter;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;

public class TextConverter extends ConverterStrategy {

    private static Logger logger = LoggerFactory.getLogger(TextConverter.class);

    @Override
    protected boolean byFilePath(ConvertRequire require) throws ConvertFailedException {

        try {
            // 编辑后的文件
            PdfWriter pdfWriter = new PdfWriter(require.getResultFilePath());
            PdfDocument pdfDocument = new PdfDocument(new PdfReader(new File(require.getWaitingFilePath())), pdfWriter);
            PdfAcroForm pdfAcroForm = PdfAcroForm.getAcroForm(pdfDocument, true);
            //font
            Rectangle rectangle;
            for (PdfEditDTO editDTO : require.getTextRequire().getPdfEditDTOList()) {
                ClassLoader classLoader = this.getClass().getClassLoader();
                System.out.println(editDTO.getFontType().getType());
                String ttfPath = classLoader.getResource("./font/"+editDTO.getFontType().getFont()).getPath();
                PdfTextFormField pdfTextFormField;
                // 读取ttf字体文件
                FontProgram fontProgram = FontProgramFactory.createFont(ttfPath);
                // 编码使用 PdfEncodings.IDENTITY_H
                PdfFont font = PdfFontFactory.createFont(fontProgram, PdfEncodings.IDENTITY_H, true);
                // 设置表单域的位置
                rectangle = new Rectangle(editDTO.getPositionX(), editDTO.getPositionY(), editDTO.getWidth(), editDTO.getHeight());
                pdfTextFormField = PdfTextFormField.createText(pdfDocument, rectangle,editDTO.getFieldName(), editDTO.getText());
                pdfTextFormField.setBorderWidth(0).setReadOnly(true).setColor(ColorConstants.BLACK).setFontAndSize(font,
                        editDTO.getFontSize());
                /** 将表单域加入pdf的指定页中 */
                pdfAcroForm.addField(pdfTextFormField, pdfDocument.getPage(editDTO.getPageNum()));

            }
            // 将表单域中的value嵌入到pdf文件中
            pdfAcroForm.flattenFields();
            pdfDocument.close();
            pdfWriter.close();
        } catch (IOException e) {
            throw new ConvertFailedException(e.getMessage());
        }
        return true;
    }

    @Override
    @Deprecated
    protected boolean byFileFolder(ConvertRequire require) throws ConvertFailedException {
        throw new ConvertFailedException("text converter do not support by file folder");
    }

    @Override
    protected boolean byStream(ConvertRequire require) throws ConvertFailedException {
        throw new ConvertFailedException("text converter do not support by file stream");
    }

    @Override
    protected boolean byBase64(ConvertRequire require) throws ConvertFailedException {
        // 编辑后的文件
        PdfDocument pdfDocument = null;
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            pdfDocument = new PdfDocument(new PdfReader(Base64FileTool.decodeBase64ToInputStream(require.getSrcBase64())), new PdfWriter(os));
            PdfAcroForm pdfAcroForm = PdfAcroForm.getAcroForm(pdfDocument, true);
            //font
            Rectangle rectangle;
            for (PdfEditDTO editDTO : require.getTextRequire().getPdfEditDTOList()) {
                String ttfPath = this.getClass().getClassLoader().getResource("./font/"+editDTO.getFontType().getFont()).getPath();
                PdfTextFormField pdfTextFormField;
                // 读取ttf字体文件
                FontProgram fontProgram = FontProgramFactory.createFont(ttfPath);
                // 编码使用 PdfEncodings.IDENTITY_H
                PdfFont font = PdfFontFactory.createFont(fontProgram, PdfEncodings.IDENTITY_H, true);
                // 设置表单域的位置
                rectangle = new Rectangle(editDTO.getPositionX(), editDTO.getPositionY(), editDTO.getWidth(), editDTO.getHeight());
                pdfTextFormField = PdfTextFormField.createText(pdfDocument, rectangle,editDTO.getFieldName(), editDTO.getText());
                pdfTextFormField.setBorderWidth(0).setReadOnly(true).setColor(ColorConstants.BLACK).setFontAndSize(font,
                        editDTO.getFontSize());
                /** 将表单域加入pdf的指定页中 */
                pdfAcroForm.addField(pdfTextFormField, pdfDocument.getPage(editDTO.getPageNum()));

            }
            // 将表单域中的value嵌入到pdf文件中
            pdfAcroForm.flattenFields();
            pdfDocument.close();

            String result = Base64FileTool.ByteArrayToBase64(os.toByteArray());
            require.setDestBase64(result);
        } catch (IOException e) {
            throw new ConvertFailedException(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean convert(Parameter require) throws ConvertFailedException {
        logger.info("text converter begin at : " + ZonedDateTime.now());
        return accordingRequire((ConvertRequire) require);
    }
}
