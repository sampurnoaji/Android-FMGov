package iot.android.fm.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import iot.android.fm.data.repository.RepositoryLogin;
import iot.android.fm.network.response.LoginResponse;

public class LoginViewModel extends ViewModel {

    LiveData<LoginResponse> login(String username, String password) {
        RepositoryLogin repositoryLogin = new RepositoryLogin();
        return repositoryLogin.login(username, password);
    }
}

