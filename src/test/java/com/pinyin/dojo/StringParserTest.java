package com.pinyin.dojo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StringParserTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void should_return_1_when_given_1() {
        int result = new StringParser().parseAndSum("1");
        assertThat(result, is(1));
    }

    @Test
    public void should_return_3_when_given_1_2() {
        int result = new StringParser().parseAndSum("1,2");
        assertThat(result, is(3));
    }

    @Test
    public void should_throw_exception_when_given_character(){
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Argument should be int");

        new StringParser().parseAndSum("a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_given_null() {
        new StringParser().parseAndSum(null);
    }
}
