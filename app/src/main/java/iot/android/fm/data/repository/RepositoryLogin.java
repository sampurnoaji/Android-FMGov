package iot.android.fm.data.repository;

import androidx.lifecycle.MutableLiveData;

import iot.android.fm.network.request.LoginRequest;
import iot.android.fm.network.response.LoginResponse;
import iot.android.fm.network.retrofit.RetrofitClient;
import iot.android.fm.network.service.FMGovApiService;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoryLogin {

    private static final String TAG = RepositoryLogin.class.getSimpleName();
    private FMGovApiService loginApi;

    public RepositoryLogin() {
        loginApi = RetrofitClient.getRetrofitInstance().create(FMGovApiService.class);
    }

    public MutableLiveData<LoginResponse> login(String username, String password) {
        final MutableLiveData<LoginResponse> mutableLiveData = new MutableLiveData<>();

        LoginRequest loginRequest = new LoginRequest(username, password);

        loginApi.login(loginRequest).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    mutableLiveData.setValue(new LoginResponse(true, response.body(), response.code(), null));
                } else {
                    mutableLiveData.setValue(new LoginResponse(false, response.body(), response.code(), null));
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                mutableLiveData.setValue(new LoginResponse(false, null, 0, t));
            }
        });
        return mutableLiveData;
    }
}
