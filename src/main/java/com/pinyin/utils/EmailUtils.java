package com.pinyin.utils;

import java.util.regex.Pattern;

public class EmailUtils {

    public static final Pattern EMAIL_PATTERN = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");

    public static boolean isValid(String email) {
        return EMAIL_PATTERN.matcher(email).find();
    }
}
