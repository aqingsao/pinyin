package com.pinyin.dao;

import com.pinyin.commons.DAOTestRunner;
import com.pinyin.domain.Contact;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;
import static org.junit.internal.matchers.IsCollectionContaining.hasItem;

@RunWith(DAOTestRunner.class)
public class ContactDAOTest {

    private static ContactDAO contactDAO;
    private static Contact zhangSan;
    private static Contact liSi;

    @BeforeClass
    public static void runBeforeClass() {
        contactDAO = new ContactDAO(MyBatisConnectionFactory.getSqlSessionFactory());

        zhangSan = persistedContact("ZhangSan", "(010) 6688 5544", "zhangsan@host.com");
        liSi = persistedContact("LiSi", "(010) 6688 5533", "lisi@host.com");
    }

    @Test
    public void testSelectAll() {
        List<Contact> list = contactDAO.selectAll();
        assertThat(list, not(nullValue()));
        assertThat(list, hasItem(zhangSan));
        assertThat(list, hasItem(liSi));
    }

    @Test
    public void testSelectById() {
        Contact actual = contactDAO.selectById(zhangSan.getId());

        assertNotNull(actual);
        assertEquals(zhangSan, actual);
    }

    @Test
    public void testUpdate() {
        liSi.setName("lisi2");
        liSi.setEmail("lisi2@host.com");
        liSi.setPhone("(010) 2222 2222");
        contactDAO.update(liSi);

        Contact actual = contactDAO.selectById(liSi.getId());

        assertNotNull(actual);
        assertThat(actual.getName(), is(liSi.getName()));
        assertThat(actual.getPhone(), is(liSi.getPhone()));
        assertThat(actual.getEmail(), is(liSi.getEmail()));
    }

    @Test
    public void testInsert() {

        Contact expected = new Contact();
        expected.setName("Loiane");
        expected.setPhone("(000) 111-1111");
        expected.setEmail("loianeg@gmail.com");
        contactDAO.insert(expected);
        assertThat(expected.getId(), not(nullValue()));

        Contact actual = contactDAO.selectById(expected.getId()); //id = 21

        assertEquals(expected, actual);
        assertThat(actual.getName(), is(expected.getName()));
        assertThat(actual.getPhone(), is(expected.getPhone()));
        assertThat(actual.getEmail(), is(expected.getEmail()));
    }

    @Test
    public void testDelete() {

        contactDAO.delete(21);

        Contact expected = contactDAO.selectById(21);

        assertNull(expected);
    }

    private static Contact persistedContact(String name, String phone, String email) {
        Contact contact = new Contact(name, phone, email);
        contactDAO.insert(contact);
        return contact;
    }
}