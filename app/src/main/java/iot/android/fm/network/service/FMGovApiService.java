package iot.android.fm.network.service;

import iot.android.fm.network.request.LoginRequest;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface FMGovApiService {
    @POST("/asset/system/authentication/login")
    Call<ResponseBody> login(@Body LoginRequest loginRequest);
}
