package iot.android.fm.ui;


import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import iot.android.fm.data.model.LoginUIModel;
import iot.android.fm.data.repository.RepositoryLogin;
import iot.android.fm.network.response.LoginResponse;

public class LoginViewModel extends ViewModel {


    LiveData<LoginUIModel> login(String username, String password) {
        RepositoryLogin repositoryLogin = new RepositoryLogin();

        MutableLiveData<LoginResponse> response = repositoryLogin.login(username, password);

        LiveData<LoginUIModel> loginResponse = Transformations.map(response, new Function<LoginResponse, LoginUIModel>() {
            @Override
            public LoginUIModel apply(LoginResponse input) {
                return new LoginUIModel(input.isSuccess(), input.getResponse(), input.getHttpCode(), input.getThrowable());
            }
        });

        return loginResponse;
    }
}

