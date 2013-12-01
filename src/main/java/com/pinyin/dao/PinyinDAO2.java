package com.pinyin.dao;

import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

public class PinyinDAO2 {

    private final Properties properties;
    public static final String PROPERTY_PINYIN_FILE = "pinyin.properties";

    public PinyinDAO2(){
        properties = loadProperties(PROPERTY_PINYIN_FILE);
    }

    public String getPinyin(String chineseWord) {
        return properties.getProperty(chineseWord);
    }

    private Properties loadProperties(String propertyFile) {
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(ClassLoader.getSystemResourceAsStream(propertyFile), "utf-8");
            Properties properties = new Properties();
            properties.load(reader);
            return properties;
        } catch (Exception e) {
            throw new RuntimeException("system error", e);
        } finally {
            closeQuietly(reader);
        }
    }

    private void closeQuietly(Reader reader) {
        try {
            reader.close();
        } catch (IOException e) {
        }
    }

    public void updatePinyin(String chineseWord, String pinyin) {
        properties.setProperty(chineseWord, pinyin);
    }
}
