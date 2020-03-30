package iot.android.fm.ui;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import iot.android.fm.R;

public class ScannerActivity extends AppCompatActivity {

    SurfaceView surfaceQRcode;
    BarcodeDetector barcodeDetector;
    CameraSource cameraSource;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        setupScanQRCode();
    }

    private void setupScanQRCode() {
        surfaceQRcode = (SurfaceView)findViewById(R.id.surfaceView);
        txtResult = findViewById(R.id.txtResult);
        barcodeDetector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.ALL_FORMATS)
                .build();
        cameraSource = new CameraSource
                .Builder(getApplicationContext(), barcodeDetector)
                .setRequestedPreviewSize(1024,768)
                .setAutoFocusEnabled(true)
                .build();

        //Add Event
        surfaceQRcode.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                try {
                    if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                            Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                        cameraSource.start(surfaceQRcode.getHolder());
                    } else {
                        ActivityCompat.requestPermissions(ScannerActivity.this,
                                new String[]{Manifest.permission.CAMERA}, 1024);
                    }
                } catch (IOException e) {
                    Log.e("Camera start error--> ", e.getMessage().toString());
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                cameraSource.stop();
            }
        });

        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
               SparseArray<Barcode> qrcodes = detections.getDetectedItems();
                if(qrcodes.size() > 0) {
//                    barcodeDetector.release();
//                    ToneGenerator toneGenerator = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 1000);
//                    toneGenerator.startTone(ToneGenerator.TONE_PROP_BEEP,150);
//                    String scanResult = qrcodes.valueAt(0).displayValue;

                    txtResult.post(new Runnable() {
                      @Override
                      public void run() {
                          //Create vibrate
                          Vibrator vibrator = (Vibrator)getApplication().getSystemService(Context.VIBRATOR_SERVICE);
                          vibrator.vibrate(1000);
                          txtResult.setText(qrcodes.valueAt(0).displayValue);
                      }
                    });

//                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
//                    startActivity(intent);
                }
            }
        });
    }
    @Override
    protected void onResume(){
        super.onResume();
        setupScanQRCode();
    }
}