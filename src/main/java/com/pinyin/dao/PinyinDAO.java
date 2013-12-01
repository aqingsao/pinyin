package com.pinyin.dao;

import com.pinyin.domain.Pinyin;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class PinyinDAO {

    private SqlSessionFactory sqlSessionFactory;

    public PinyinDAO(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public String getPinyin(String chineseWord) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            Pinyin pinyin = (Pinyin) session.selectOne("Pinyin.getByName", chineseWord);
            return pinyin == null ? null : pinyin.getPinyin();
        } finally {
            session.close();
        }
    }

    public void updatePinyin(String chineseWord, String pinyin) {
//        properties.setProperty(chineseWord, pinyin);
    }
}
