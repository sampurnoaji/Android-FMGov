package iot.android.fm.ui;

import androidx.appcompat.app.AppCompatActivity;
import iot.android.fm.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonPindai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //set click event of image button but not working
        buttonPindai = findViewById(R.id.buttonPindai);

        buttonPindai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ScannerActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
