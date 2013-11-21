package com.pinyin.dojo;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class TheoryTest {
    @DataPoint public static int input1 = 45;
    @DataPoint
    public static int input2 = 46;
    @DataPoints
    public static String[] inputs = new String[] { "foobar", "barbar" };

    @Theory public void testString1(String input) {
        System.out.println("testString1 input=" + input);
    }

    @Theory public void testString2(String input) {
        System.out.println("testString2 input=" + input);
    }

    @Theory public void test1(int input) {
        System.out.println("test1 input=" + input);
    }

    @Theory
    public void test2(int input) {
        System.out.println("test2 input=" + input);
    }
}
