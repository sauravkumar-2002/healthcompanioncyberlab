 package com.example.hj;

public class model {
    String starttime,date,endtime;

    public model(String date , String starttime, String endtime) {
        this.date = date;
        this.starttime = starttime;

        this.endtime = endtime;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }





    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }
}
