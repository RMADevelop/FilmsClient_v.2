package com.example.romanm.filmsclientv2.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Roma on 10.09.2017.
 */

public class SessionId {
    @SerializedName("success")
    @Expose
    private boolean success;
    @SerializedName("session_id")
    @Expose
    private String sessionId;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
