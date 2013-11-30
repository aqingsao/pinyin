package com.pinyin.dao;

import com.pinyin.domain.Contact;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ContactDAO {

    private SqlSessionFactory sqlSessionFactory;

    public ContactDAO(){
        sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }

    @SuppressWarnings("unchecked")
    public List<Contact> selectAll(){

        SqlSession session = sqlSessionFactory.openSession();

        try {
            List<Contact> list = session.selectList("Contact.getAll");
            return list;
        } finally {
            session.close();
        }
    }

    public Contact selectById(int id){

        SqlSession session = sqlSessionFactory.openSession();

        try {
            Contact contact = (Contact) session.selectOne("Contact.getById",id);
            return contact;
        } finally {
            session.close();
        }
    }

    /**
     * Updates an instance of Contact in the database.
     * @param contact the instance to be updated.
     */
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
