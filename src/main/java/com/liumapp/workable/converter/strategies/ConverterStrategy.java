package com.liumapp.workable.converter.strategies;

import com.liumapp.qtools.file.base64.Base64FileTool;
import com.liumapp.qtools.str.random.StrRandomTool;
import com.liumapp.workable.converter.config.ConvertRequire;
import com.liumapp.workable.converter.config.ConverterConfig;
import com.liumapp.workable.converter.core.Converter;
import com.liumapp.workable.converter.enums.Patterns;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;
import com.liumapp.workable.converter.factory.ConverterConfigManager;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * file ConverterStrategy.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/10
 */
public abstract class ConverterStrategy implements Converter {

    protected ConverterConfig converterConfig = ConverterConfigManager.getInstance().getParams();

    protected boolean accordingRequire(ConvertRequire require) throws ConvertFailedException {
        if (require.getPatterns() == Patterns.By_File_To_File) return byFilePath(require);
        if (require.getPatterns() == Patterns.By_File_To_Folder) return byFileFolder(require);
        if (require.getPatterns() == Patterns.By_Stream) return byStream(require);
        if (require.getPatterns() == Patterns.By_Base64) return byBase64(require);
        throw new ConvertFailedException("can not found convert patterns .");
    };

    protected abstract boolean byFilePath (ConvertRequire require) throws ConvertFailedException;

    protected abstract boolean byFileFolder (ConvertRequire require) throws ConvertFailedException;

    protected abstract boolean byStream (ConvertRequire require) throws ConvertFailedException;

    protected abstract boolean byBase64 (ConvertRequire require) throws ConvertFailedException;

    protected String saveTmpFileByBase64 (String fileBase64, String prefix) throws IOException {
        String tmpName = converterConfig.getTmpPath() + "/" + StrRandomTool.getRandom(12) + "." + prefix;
        Base64FileTool.saveBase64File(fileBase64, tmpName);
        return tmpName;
    }

    protected String saveTmpFileByBytes (byte[] fileBytes, String prefix) throws IOException {
        String tmpName = converterConfig.getTmpPath() + "/" + StrRandomTool.getRandom(12) + "." + prefix;
        FileUtils.writeByteArrayToFile(new File(tmpName), fileBytes);
        return tmpName;
    }

}
