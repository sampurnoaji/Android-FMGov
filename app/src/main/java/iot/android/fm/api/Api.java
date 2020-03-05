package iot.android.fm.api;

import iot.android.fm.models.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {
    @POST("/asset/system/authentication/login")
    Call<LoginResponse> login(
            @Field ("username") String username,
            @Field ("password") String password
    );
}
