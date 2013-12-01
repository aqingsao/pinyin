package com.pinyin.dao;

import com.pinyin.commons.DAOTestRunner;
import com.pinyin.domain.Contact;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(DAOTestRunner.class)
public class PinyinIbatisTest {

    private static ContactDAO contactDAO;

    @BeforeClass
    public static void runBeforeClass() {
        contactDAO = new ContactDAO();
    }

    @AfterClass
    public static void runAfterClass() {
        contactDAO = null;
    }

    @Test
    public void testSelectAll() {
        List<Contact> list = contactDAO.selectAll();
        assertNotNull(list);
        assertEquals(20, list.size());
    }

    @Test
    public void testSelectById() {

        Contact actual = new Contact(2, "Contact1", "(000) 000-0000", "contact1@loianetest.com");

        Contact expected = contactDAO.selectById(2);

        assertNotNull(expected);
        assertEquals(actual, expected);
        assertNotSame(actual, expected);
    }

    @Test
    public void testUpdate() {

        Contact actual = new Contact(3, "Contact2Updated", "(000) 111-1111", "contact1updated@loianetest.com");

        Contact expected = contactDAO.selectById(3);
        expected.setEmail("contact1updated@loianetest.com");
        expected.setName("Contact2Updated");
        expected.setPhone("(000) 111-1111");
        contactDAO.update(expected);
        expected = contactDAO.selectById(3);

        assertNotNull(expected);
        assertEquals(actual, expected);
        assertNotSame(actual, expected);
    }

    @Test
    public void testInsert() {

        Contact actual = new Contact();
        actual.setName("Loiane");
        actual.setPhone("(000) 111-1111");
        actual.setEmail("loianeg@gmail.com");
        contactDAO.insert(actual);

        assertEquals(21, actual.getId());

        Contact expected = contactDAO.selectById(actual.getId()); //id = 21

        assertEquals(actual, expected);
        assertNotSame(actual, expected);

    }

    @Test
    public void testDelete() {

        contactDAO.delete(21);

        Contact expected = contactDAO.selectById(21);

        assertNull(expected);
    }

}