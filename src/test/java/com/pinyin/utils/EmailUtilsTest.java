package com.pinyin.utils;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmailUtilsTest {

    @Test
    public void should_return_true_when_given_a_at_b_dot_com(){
         assertTrue(EmailUtils.isValid("a@b.com"));
    }

    @Test
    public void should_return_true_when_given_a_at_b_dot_com_dot_cn(){
         assertTrue(EmailUtils.isValid("a@b.com"));
    }

    @Test
    public void should_return_false_when_given_a_at_b_dot(){
         assertFalse(EmailUtils.isValid("a@b."));
    }

    @Test
    public void should_return_false_when_given_a_at_b(){
         assertFalse(EmailUtils.isValid("a@b"));
    }

    @Test
    public void should_return_false_when_given_b_dot_com(){
         assertFalse(EmailUtils.isValid("b.com"));
    }

    @Test
    public void should_return_false_when_given_at_b_dot_com(){
         assertFalse(EmailUtils.isValid("@b.com"));
    }

    @Test
    public void should_return_false_when_given_a_at_b_dot_com_dot_cn_dot_org(){
         assertFalse(EmailUtils.isValid("@b.com.cn.org"));
    }
}
