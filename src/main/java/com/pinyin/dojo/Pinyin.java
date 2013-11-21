package com.pinyin.dojo;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class Pinyin {

    public static Properties readFile() throws Exception{
        Properties p = new Properties();
        FileInputStream inputStream = new FileInputStream("/Users/aqingsao/Projects/Java/Pinyin/src/test/resources/pinyin.properties") ;


        p.load(new InputStreamReader(inputStream,"UTF8"));
        return p;
    }

    public static String getPropertiesValue(String str,Properties p){
        return p.getProperty(str);
    }

    public static String getPingyin(String chn) throws Exception {
        if (chn == null) return "";
        Properties p = readFile();

        StringBuffer sb = new StringBuffer();
        for (int i=0;i<chn.length();i++){
            char c = chn.charAt(i);
            String pinying = getPropertiesValue(String.valueOf(c),p);
            if(i==1){
                sb.append(" ");
            }

            if (pinying == null || pinying.equals("")){
                sb.append("?");
            }
            else{
                String first = pinying.substring(0,1);
                pinying = first.toUpperCase()+pinying.substring(1,pinying.length());

                sb.append(pinying);
            }

        }
        return sb.toString();
    }

    public static String getPingyinHead(String chn) throws Exception {
        if (chn == null) return "";
        Properties p = readFile();

        StringBuffer sb = new StringBuffer();
        for (int i=0;i<chn.length();i++){
            char c = chn.charAt(i);
            String pinying = getPropertiesValue(String.valueOf(c),p);
            if(i==1){
                sb.append(" ");
            }

            if (pinying == null || pinying.equals("")){
                sb.append("?");
            }
            else{
                String first = pinying.substring(0,1);


                sb.append(first.toUpperCase());
            }

        }
        return sb.toString();
    }
}
