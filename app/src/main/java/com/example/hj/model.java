 package com.example.hj;

public class model {
    String starttime,date,endtime;

    public model(String starttime , String date, String endtime) {
        this.starttime = starttime;
        this.date = date;
        this.endtime = endtime;
    }



    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }
}
