package com.example.hj;

public class modelpedo {
    String dateandtime,textviewstepcount,textview1stepdetect;

    public modelpedo(String textviewstepcount, String dateandtime, String textview1stepdetect) {

        this.dateandtime = dateandtime;
        this.textviewstepcount = textviewstepcount;
        this.textview1stepdetect = textview1stepdetect;
    }



    public String getDateandtime() {
        return dateandtime;
    }

    public void setDateandtime(String dateandtime) {
        this.dateandtime = dateandtime;
    }
    public String getTextviewstepcount() {
        return textviewstepcount;
    }

    public void setTextviewstepcount(String textviewstepcount) {
        this.textviewstepcount = textviewstepcount;
    }

    public String getTextview1stepdetect() {
        return textview1stepdetect;
    }

    public void setTextview1stepdetect(String textview1stepdetect) {
        this.textview1stepdetect = textview1stepdetect;
    }
}
