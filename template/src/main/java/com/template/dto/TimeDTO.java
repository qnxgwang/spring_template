package com.template.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class TimeDTO {

    @NotEmpty
    public long time1;

    @NotEmpty
    public long time2;

    public long getTime1() {
        return time1;
    }

    public void setTime1(long time1) {
        this.time1 = time1;
    }

    public long getTime2() {
        return time2;
    }

    public void setTime2(long time2) {
        this.time2 = time2;
    }
}
