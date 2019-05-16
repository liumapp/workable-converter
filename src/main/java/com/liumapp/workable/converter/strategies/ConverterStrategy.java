package com.liumapp.workable.converter.strategies;

import com.liumapp.workable.converter.config.ConvertRequire;
import com.liumapp.workable.converter.core.Converter;
import com.liumapp.workable.converter.enums.Patterns;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;

/**
 * file ConverterStrategy.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/10
 */
public abstract class ConverterStrategy implements Converter {

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

}
