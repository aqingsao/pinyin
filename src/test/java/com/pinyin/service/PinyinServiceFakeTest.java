package com.pinyin.service;

import com.pinyin.dao.PinyinDAO;
import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PinyinServiceFakeTest {

    private PinyinService pinyinService;
    private PinyinDAO pinyinDAO;

    @Before
    public void before() {
        pinyinDAO = new FakePinyinDAO();
        pinyinService = new PinyinService(pinyinDAO);

    }

    @Test
    public void should_return_Zhang_when_given_章() {
        String actual = pinyinService.getPinyin("章");
        assertThat(actual, is("Zhang"));
    }

    @Test
    public void should_return_ZhangZiYi_when_given_章子怡() {
        String actual = pinyinService.getPinyin("章子怡");
        assertThat(actual, is("ZhangZiYi"));
    }

    @Test
    public void should_return_WuQuestoinMark_when_given_武瞾() {
        String actual = pinyinService.getPinyin("武瞾");
        assertThat(actual, is("Wu?"));
    }

    @Test
    public void should_return_ZZY_when_given_章子怡() {
        String actual = pinyinService.getPinyinHeader("章子怡");
        assertThat(actual, is("ZZY"));
    }

    @Test
    public void should_return_WQuestoinMark_when_given_武瞾() {
        String actual = pinyinService.getPinyinHeader("武瞾");
        assertThat(actual, is("W?"));
    }

    private class FakePinyinDAO extends PinyinDAO {
        private Properties properties;

        public FakePinyinDAO() {
            properties = new Properties();
            properties.setProperty("章", "zhang");
            properties.setProperty("子", "zi");
            properties.setProperty("怡", "yi");
            properties.setProperty("武", "wu");
        }

        @Override
        public String getPinyin(String chineseWord) {
            return properties.getProperty(chineseWord);
        }
    }
}
