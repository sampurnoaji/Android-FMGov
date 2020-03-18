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

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(Context.MODE_PRIVATE);
        String userName = sharedPreferences.getString("username", null);
        String password = sharedPreferences.getString("password", null);
        if (userName != null && password != null ) {
            doLogin(userName, password);
        }

        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        binding.buttonLogin.setOnClickListener(this);
        binding.forgotPass.setOnClickListener(this);
        binding.createAcc.setOnClickListener(this);

        loginViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(LoginViewModel.class);
    }

    private void getUser() {
        username = binding.editTextEmail.getText().toString();
        password = binding.editTextPass.getText().toString();
    }


    private void login() {

        getUser();

        loginViewModel.login(username, password).observe(this, new Observer<LoginUIModel>() {
            @Override
            public void onChanged(LoginUIModel loginUIModel) {
                if (loginUIModel.isSuccess()) {
                    SharedPreferences sharedPreferences = getSharedPreferences("preferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", _nameText.getText().toString();
                    // this should be salted
                    editor.putString("password", _passwordText.getText().toString();
                    editor.commit();
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
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
