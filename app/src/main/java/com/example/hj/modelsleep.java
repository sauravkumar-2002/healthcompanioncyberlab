package com.example.hj;

public class modelsleep {
    String datesleep,statussleep;

    public modelsleep(String datesleep, String statussleep) {
        this.datesleep = datesleep;
        this.statussleep = statussleep;
    }

    public String getDatesleep() {
        return datesleep;
    }

    public void setDatesleep(String datesleep) {
        this.datesleep = datesleep;
    }

    public String getStatussleep() {
        return statussleep;
    }

    public void setStatussleep(String statussleep) {
        this.statussleep = statussleep;
    }
}
