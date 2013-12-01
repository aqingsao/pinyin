package com.pinyin.dao;

import com.pinyin.domain.Contact;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ContactDAO {

    private SqlSessionFactory sqlSessionFactory;

    public ContactDAO(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<Contact> selectAll(){
        SqlSession session = sqlSessionFactory.openSession();

        try {
            return session.selectList("Contact.getAll");
        } finally {
            session.close();
        }
    }

    public Contact selectById(int id){
        SqlSession session = sqlSessionFactory.openSession();

        try {
            return (Contact) session.selectOne("Contact.getById",id);
        } finally {
            session.close();
        }
    }

    public void update(Contact contact){
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.update("Contact.update", contact);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void insert(Contact contact){
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.insert("Contact.insert", contact);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void delete(int id){
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.delete("Contact.deleteById", id);
            session.commit();
        } finally {
            session.close();
        }
    }
}
