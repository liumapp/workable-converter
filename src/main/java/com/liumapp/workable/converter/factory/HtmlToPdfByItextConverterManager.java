package com.liumapp.workable.converter.factory;

import com.liumapp.workable.converter.core.Converter;
import com.liumapp.workable.converter.strategies.ItextConverter;

/**
 * Created by Haoxy on 2019-06-18.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
public class HtmlToPdfByItextConverterManager extends AbstractConverterManager{


    private static class HtmlToPdfByItextConverterManagerHolder {
        private static final HtmlToPdfByItextConverterManager INSTANCE = new HtmlToPdfByItextConverterManager();
    }

    private HtmlToPdfByItextConverterManager() {
    }

    public static synchronized Converter getInstance () {
        return HtmlToPdfByItextConverterManager.HtmlToPdfByItextConverterManagerHolder.INSTANCE.getConverter();
    }

    @Override
    public Converter getConverter() {
        if (this.converter == null) {
            this.converter = new ItextConverter();
        }
        return this.converter;
    }
}
