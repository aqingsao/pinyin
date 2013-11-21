package com.pinyin.dojo;

import org.junit.Test;

import java.util.Properties;

import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class PinyinTest {

    @Test(expected = Exception.class, timeout =100)
    public void test_should_return_true(){
      assertThat(0, not(nullValue()));
    }
    public static void main(String[] arg0) throws Exception {
        Properties p = Pinyin.readFile();
        String a = Pinyin.getPingyin("子子子");
        String a1 = Pinyin.getPingyin("章自衣");
        String a2 = Pinyin.getPingyin("章子衣");
        String a3 = Pinyin.getPingyinHead("章自衣");
        String a4 = Pinyin.getPingyinHead("章子衣");
        System.out.println(a);
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);
        System.out.println();

    }
}
