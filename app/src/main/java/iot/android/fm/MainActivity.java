package iot.android.fm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextViewForgotPass();
        initTextViewCreateacc();
    }
    private void initTextViewForgotPass () {
            TextView textViewForgotpass = (TextView) findViewById(R.id.forgotPass);
            textViewForgotpass.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
    private void initTextViewCreateacc () {
        TextView textViewCreateacc = (TextView) findViewById(R.id.createAcc);
        textViewCreateacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
