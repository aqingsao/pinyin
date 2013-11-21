package com.pinyin.service;

import com.pinyin.dao.PinyinDAO;

public class PinyinService {
    private PinyinDAO pinyinDAO = new PinyinDAO();
    private EmailService emailService;

    public PinyinService() {
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
        this.emailService.sendEmail("admin@host.com", "title", "body");
    }
}