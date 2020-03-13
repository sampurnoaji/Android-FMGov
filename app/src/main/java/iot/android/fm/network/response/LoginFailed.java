package iot.android.fm.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginFailed {
    @SerializedName("reason")
    @Expose
    private String reason;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("message")
    @Expose
    private String message;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
