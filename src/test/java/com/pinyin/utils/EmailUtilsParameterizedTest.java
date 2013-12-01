package com.pinyin.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class EmailUtilsParameterizedTest {
    @Parameterized.Parameters
    public static java.util.Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {"a@b.com", true}, {"a@b.", false}
        });
    }

    private String email;
    private boolean epxected;

    public EmailUtilsParameterizedTest(String email, boolean epxected){
        this.email = email;
        this.epxected = epxected;
    }
    @Test
    public void test_email(){
      assertThat(EmailUtils.isValid(email), is(epxected));
    }
}
