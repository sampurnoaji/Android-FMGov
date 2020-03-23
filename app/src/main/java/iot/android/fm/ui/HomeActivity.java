package iot.android.fm.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import iot.android.fm.R;
import iot.android.fm.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityHomeBinding binding;
    private SharedPreferenceUtil preferenceUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        preferenceUtil = new SharedPreferenceUtil(this);

        binding.buttonPindai.setOnClickListener(this);
        binding.btnLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonPindai:
                Intent intent = new Intent(HomeActivity.this, ScannerActivity.class);
                startActivity(intent);
                break;
            case R.id.btnLogout:
                preferenceUtil.logoutUser();
                Intent intentLogout = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intentLogout);
                finish();
                break;
        }
    }
}
