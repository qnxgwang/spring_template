package com.template.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class PlayerDTO implements Serializable {

    @Size(min = 5, max = 10, message = "用户名长度限制在5和10之间")
    String userId;

    @NotNull(message = "用户time不能为空")
    long time;

    @NotBlank(message = "用户channelId不能为空")
    String channelId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
}
