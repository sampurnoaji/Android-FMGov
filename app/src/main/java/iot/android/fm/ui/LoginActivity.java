package iot.android.fm.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import iot.android.fm.R;
import iot.android.fm.databinding.ActivityLoginBinding;
import iot.android.fm.network.response.LoginResponse;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityLoginBinding binding;
    private LoginViewModel loginViewModel;

    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        binding.buttonLogin.setOnClickListener(this);
        binding.forgotPass.setOnClickListener(this);
        binding.createAcc.setOnClickListener(this);

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
    }

    private void getUser() {
        username = binding.editTextEmail.getText().toString();
        password = binding.editTextPass.getText().toString();
    }

    private void login() {

        getUser();

        loginViewModel.login(username, password).observe(this, new Observer<LoginResponse>() {
            @Override
            public void onChanged(LoginResponse loginResponse) {
                if (loginResponse != null) {
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);

                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Login GAGAL", Toast.LENGTH_SHORT).show();
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
