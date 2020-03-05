package iot.android.fm.network.service;

import iot.android.fm.network.request.LoginRequest;
import iot.android.fm.network.response.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface FMGovApiService {
    @POST("/asset/system/authentication/login")
    Call<LoginResponse> login(
            @Body LoginRequest loginRequest
    );
}
