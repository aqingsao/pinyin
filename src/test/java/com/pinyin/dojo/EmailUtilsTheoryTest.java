package com.pinyin.dojo;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static com.pinyin.dojo.EmailUtilsTheoryTest.TestData.aData;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(Theories.class)
public class EmailUtilsTheoryTest {
    @DataPoints
    public static TestData[] ARRAYS = new TestData[]{aData("a@b.com", true), aData("a@b.", false)};

    @Theory
    public void should_return_true_when_given_a_at_b_dot_com_dot_cn(TestData testData){
         assertThat(EmailUtils.isValid(testData.getEmail()), is(testData.getExpected()));
    }

    static class TestData {
        private String email;
        private boolean expected;
        static TestData aData(String email, boolean expected) {
            return new TestData(email, expected);
        }


        public TestData(String email, boolean expected) {
            this.email = email;
            this.expected = expected;
        }

        private String getEmail() {
            return email;
        }

        private boolean getExpected() {
            return expected;
        }
    }
}
