package com.example.hj;

public class Listitem {
    private String head;
    private String desc;
    private String datetime;

    public Listitem(String head, String desc, String datetime) {
        this.head = head;
        this.desc = desc;
        this.datetime=datetime;
    }

    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }
    public String getDatetime() { return datetime; }
}
