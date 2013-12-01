package com.pinyin.utils;

public class StringParser {
    public int parseAndSum(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }

        int total = 0;
        for (String s : string.split(",")) {
            total += asInt(s);

        }
        return total;
    }

    private int asInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Argument should be int");
        }
    }
}
