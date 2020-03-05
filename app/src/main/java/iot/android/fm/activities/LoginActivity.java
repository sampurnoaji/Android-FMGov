package iot.android.fm.activities;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import iot.android.fm.R;
import iot.android.fm.api.Api;
import iot.android.fm.api.RetrofitClient;
import iot.android.fm.databinding.ActivityLoginBinding;
import iot.android.fm.models.LoginResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityLoginBinding binding;

    private String textEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        binding.buttonLogin.setOnClickListener(this);
        binding.forgotPass.setOnClickListener(this);
        binding.createAcc.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonLogin:
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
