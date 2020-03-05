package iot.android.fm.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import iot.android.fm.data.repository.RepositoryLogin;
import iot.android.fm.network.request.LoginRequest;
import iot.android.fm.network.response.LoginResponse;

public class LoginViewModel extends ViewModel {
    private  LiveData<LoginResponse> loginResponseLiveData;
    private String username;
    private String password;

    public LoginViewModel(){
        RepositoryLogin repositoryLogin = new RepositoryLogin();
        this.loginResponseLiveData = repositoryLogin.login(username, password);
    }

    public LiveData<LoginResponse> login(String username, String password) {
        this.username = username;
        this.password = password;
        return loginResponseLiveData;
    }
}

