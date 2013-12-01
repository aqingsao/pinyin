package com.pinyin.service;

import com.pinyin.dao.PinyinDAO;
import com.pinyin.domain.Address;
import com.pinyin.domain.Email;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class PinyinServiceMockTest {

    private PinyinService pinyinService;
    private PinyinDAO pinyinDAO;
    private EmailService emailService;

    @Before
    public void before() {
        pinyinDAO = mock(PinyinDAO.class);
        when(pinyinDAO.getPinyin("章")).thenReturn("zhang");
        when(pinyinDAO.getPinyin("子")).thenReturn("zi");
        when(pinyinDAO.getPinyin("怡")).thenReturn("yi");
        when(pinyinDAO.getPinyin("武")).thenReturn("wu");

        emailService = mock(EmailService.class);

        pinyinService = new PinyinService(pinyinDAO, emailService);

    }

    @Test
    public void should_update_朝_to_chao() {
        pinyinService.updatePinyin("朝", "chao");

        verify(pinyinDAO, times(1)).updatePinyin("朝", "chao");

        ArgumentCaptor<Email> argumentCaptor = spy(ArgumentCaptor.forClass(Email.class));
        verify(emailService).sendEmail(argumentCaptor.capture());

        Email actual = argumentCaptor.getValue();
        assertThat(actual.getFrom().getUserName(), is("doNotReply"));
        assertThat(actual.getFrom().getUserAddress(), is("doNotReply@host.com"));
        assertThat(actual.getTo().getUserName(), is("admin"));
        assertThat(actual.getTo().getUserAddress(), is("admin@host.com"));
        assertThat(actual.getMessage(), is("message"));
        assertThat(actual.getSubject(), is("subject"));
    }
}
