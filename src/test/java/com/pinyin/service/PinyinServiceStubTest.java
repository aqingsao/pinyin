package com.pinyin.service;

import com.pinyin.dao.PinyinDAO;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PinyinServiceStubTest {

    private PinyinService pinyinService;
    private PinyinDAO pinyinDAO;

    @Before
    public void before() {
        pinyinDAO = mock(PinyinDAO.class);
        when(pinyinDAO.getPinyin("章")).thenReturn("zhang");
        when(pinyinDAO.getPinyin("子")).thenReturn("zi");
        when(pinyinDAO.getPinyin("怡")).thenReturn("yi");
        when(pinyinDAO.getPinyin("武")).thenReturn("wu");

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
}
