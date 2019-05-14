package com.liumapp.workable.converter.strategies;

import com.liumapp.workable.converter.config.ConvertRequire;
import com.liumapp.workable.converter.core.Parameter;
import com.liumapp.workable.converter.enums.Patterns;
import com.liumapp.workable.converter.exceptions.ConvertFailedException;

/**
 * file CommonConverter.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/5/14
 */
public class CommonConverter extends ConverterStrategy {

    @Override
    public boolean convert(Parameter require) throws ConvertFailedException {
        return accordingRequire((ConvertRequire) require);
    }

    private boolean accordingRequire (ConvertRequire require) {
        if (require.getPatterns() == Patterns.By_File_Path) {
            return byFilePath(require);
        }
        return false;
    }

    private boolean byFilePath (ConvertRequire require) {

        return true;
    }

}
