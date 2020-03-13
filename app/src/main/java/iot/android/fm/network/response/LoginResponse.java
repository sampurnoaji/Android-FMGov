package iot.android.fm.network.response;

import okhttp3.ResponseBody;

public class LoginResponse {
    private boolean isSuccess;
    private ResponseBody response;
    private int httpCode;
    private Throwable throwable;

    public LoginResponse(boolean isSuccess, ResponseBody response, int httpCode, Throwable throwable) {
        this.isSuccess = isSuccess;
        this.response = response;
        this.httpCode = httpCode;
        this.throwable = throwable;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public ResponseBody getResponse() {
        return response;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public Throwable getThrowable() {
        return throwable;
    }
}
