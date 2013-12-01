package com.pinyin.service;

import com.pinyin.dao.MyBatisConnectionFactory;
import com.pinyin.dao.PinyinDAO;
import com.pinyin.domain.Address;
import com.pinyin.domain.Email;

import static org.mockito.Mockito.verify;

public class PinyinService {
    private PinyinDAO pinyinDAO ;
    private EmailService emailService;

    public PinyinService() {
        this(new PinyinDAO(MyBatisConnectionFactory.getSqlSessionFactory()));
    }

    public PinyinService(PinyinDAO pinyinDAO) {
        this(pinyinDAO, new EmailService());
    }

    public PinyinService(PinyinDAO pinyinDAO, EmailService emailService) {
        this.pinyinDAO = pinyinDAO;
        this.emailService = emailService;
    }

    public String getPinyin(String chineseName) {

        String result = "";

        for (int i = 0; i < chineseName.length(); i++) {
            String chineseWord = chineseName.substring(i, i + 1);
            String pinyin = pinyinDAO.getPinyin(chineseWord);
            result += pinyin == null ? "?" : capitalize(pinyin);
        }

        return result;
    }

    private String capitalize(String pinyin) {
        return pinyin.substring(0, 1).toUpperCase() + pinyin.substring(1, pinyin.length());
    }

    public String getPinyinHeader(String chineseName) {
        String result = "";

        for (int i = 0; i < chineseName.length(); i++) {
            String chineseWord = chineseName.substring(i, i + 1);
            String pinyin = pinyinDAO.getPinyin(chineseWord);
            result += pinyin == null ? "?" : getHeader(pinyin);
        }

        return result;
    }

    private String getHeader(String pinyin) {
        return pinyin.substring(0, 1).toUpperCase();
    }

    public void updatePinyin(String chineseWord, String pinyin) {
        this.pinyinDAO.updatePinyin(chineseWord, pinyin);

//        Address from = new Address();
//        from.setUserName("doNotReply");
//        from.setUserAddress("doNotReply@host.com");
//        Address to = new Address();
//        to.setUserName("admin");
//        to.setUserAddress("admin@host.com");
//
//        Email email = new Email();
//        email.setFrom(from);
//        email.setTo(to);
//        email.setSubject("subject");
//        email.setMessage("message");
//
        Address from = Address.anAddress("doNotReply", "doNotReply@host.com");
        Address to = Address.anAddress("admin", "admin@host.com");
        Email email = Email.anEmail(from, "subject", "message", to);

        this.emailService.sendEmail(email);
    }
}