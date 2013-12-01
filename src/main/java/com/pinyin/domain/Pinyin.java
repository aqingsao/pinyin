package com.pinyin.domain;

public class Pinyin {

    private int id;
    private String name;
    private String pinyin;


    public Pinyin(int id, String name, String pinyin) {
        this.id = id;
        this.name = name;
        this.pinyin = pinyin;
    }

    public Pinyin(String name, String pinyin) {
        this.name = name;
        this.pinyin = pinyin;
    }

    public Pinyin() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Id = ").append(id).append(" - ");
        sb.append("Name = ").append(name).append(" - ");
        sb.append("Phone = ").append(pinyin).append(" - ");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        Pinyin contact = (Pinyin) obj;
        if (this.id != contact.id){
            return false;
        }
        if (!this.name.equals(contact.getName())){
            return false;
        }
        if (!this.pinyin.equals(contact.getPinyin())){
            return false;
        }
        return true;
    }
}
