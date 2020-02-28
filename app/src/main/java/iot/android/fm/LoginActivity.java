package iot.android.fm;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import iot.android.fm.databinding.ActivityLoginBinding;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityLoginBinding binding;

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
                Toast.makeText(this, "login", Toast.LENGTH_SHORT).show();
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
