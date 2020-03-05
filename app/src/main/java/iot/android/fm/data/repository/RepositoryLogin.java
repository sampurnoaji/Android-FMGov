package iot.android.fm.data.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import iot.android.fm.network.request.LoginRequest;
import iot.android.fm.network.response.LoginResponse;
import iot.android.fm.network.retrofit.RetrofitClient;
import iot.android.fm.network.service.FMGovApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoryLogin {

    private static final String TAG = RepositoryLogin.class.getSimpleName();
    private FMGovApiService loginApi;

    public RepositoryLogin() {
        loginApi = RetrofitClient.getRetrofitInstance().create(FMGovApiService.class);
    }

    public LiveData<LoginResponse> login(String username, String password) {
        final MutableLiveData<LoginResponse> mutableLiveData = new MutableLiveData<>();

        LoginRequest loginRequest = new LoginRequest(username, password);

        loginApi.login(loginRequest).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()){
                    if (response.body() != null){
                        mutableLiveData.setValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                mutableLiveData.setValue(null);
            }
        });
        return mutableLiveData;
    }
}
