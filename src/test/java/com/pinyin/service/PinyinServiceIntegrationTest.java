package com.pinyin.service;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PinyinServiceIntegrationTest {

    private PinyinService pinyinService;

    @Before
    public void before(){
        pinyinService = new PinyinService();
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

    @Test
    public void should_update_朝_to_chao() {
        pinyinService.updatePinyin("朝", "chao");
        assertThat(pinyinService.getPinyin("朝"), is("Chao"));
    }
}
