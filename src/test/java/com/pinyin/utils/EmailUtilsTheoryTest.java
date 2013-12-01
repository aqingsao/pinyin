package com.pinyin.utils;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static com.pinyin.utils.EmailUtilsTheoryTest.TestData.aData;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(Theories.class)
public class EmailUtilsTheoryTest {
    @DataPoints
    public static TestData[] ARRAYS = new TestData[]{aData("a@b.com", true), aData("a@b.", false)};

    @Theory
    public void should_check_whether_email_is_valid(TestData testData){
         assertThat(EmailUtils.isValid(testData.email), is(testData.expected));
    }

    static class TestData {
        public String email;
        public boolean expected;
        static TestData aData(String email, boolean expected) {
            return new TestData(email, expected);
        }


        public TestData(String email, boolean expected) {
            this.email = email;
            this.expected = expected;
        }
    }
}
