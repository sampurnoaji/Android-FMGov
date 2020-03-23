package iot.android.fm.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.prefs.Preferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import iot.android.fm.R;
import iot.android.fm.data.model.LoginUIModel;
import iot.android.fm.databinding.ActivityLoginBinding;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityLoginBinding binding;
    private LoginViewModel loginViewModel;

    private String username;
    private String password;

    private SharedPreference preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        binding.buttonLogin.setOnClickListener(this);
        binding.forgotPass.setOnClickListener(this);
        binding.createAcc.setOnClickListener(this);

        loginViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(LoginViewModel.class);

        preference = new SharedPreference(getApplicationContext());

    }

    private void getUser() {
        username = binding.editTextEmail.getText().toString();
        password = binding.editTextPass.getText().toString();

        if(preference.readLoginStatus())
        {
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }
    }


    private void login() {

        getUser();

        loginViewModel.login(username, password).observe(this, new Observer<LoginUIModel>() {
            @Override
            public void onChanged(LoginUIModel loginUIModel) {
                if (loginUIModel.isSuccess()) {
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    preference.writeLoginStatus(true);
                    finish();
                } else {
                    if (loginUIModel.getThrowable() == null) {
                        switch (loginUIModel.getHttpCode()) {
                            case 401:
                                Toast.makeText(LoginActivity.this, "Username atau password salah", Toast.LENGTH_SHORT).show();
                                break;
                            case 500:
                                Toast.makeText(LoginActivity.this, "Internal server error", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "Terjadi kesalahan saat login", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonLogin:
                login();
                break;
            case R.id.forgotPass:
                Toast.makeText(this, "forgot", Toast.LENGTH_SHORT).show();
                break;
            case R.id.createAcc:
                Toast.makeText(this, "create new", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
