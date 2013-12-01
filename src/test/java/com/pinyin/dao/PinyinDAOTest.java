package com.pinyin.dao;

import com.pinyin.commons.DAOTestRunner;
import com.pinyin.commons.MyBatisConnectionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(DAOTestRunner.class)
public class PinyinDAOTest {

    private PinyinDAO pinyinDAO = new PinyinDAO(MyBatisConnectionFactory.getSqlSessionFactory());

    @Test
    public void test_return_zi_when_given_子(){
        assertThat(pinyinDAO.getPinyin("子"), is("zi"));
    }

    @Test
    public void should_return_null_when_given_unExisted_word(){
        assertThat(pinyinDAO.getPinyin("瞾"), is(nullValue()));
    }

    @Test
    public void should_update_朝_to_chao() {
        pinyinDAO.updatePinyin("朝", "chao");
        assertThat(pinyinDAO.getPinyin("朝"), is("chao"));
    }
}
