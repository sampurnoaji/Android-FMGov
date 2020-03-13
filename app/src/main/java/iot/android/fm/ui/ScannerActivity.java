package iot.android.fm.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import iot.android.fm.R;

public class ScannerActivity extends AppCompatActivity {

    SurfaceView surfaceView;
    BarcodeDetector barcodeDetector;
    CameraSource cameraSource;
    final int RequestCameraPermissionID = 1001;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
       switch (requestCode)
       {
           case RequestCameraPermissionID:
           {
               if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
               { if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
                   return;
                   try {
                       cameraSource.start(surfaceView.getHolder());
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
           }
           break;
       }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        surfaceView = (SurfaceView)findViewById(R.id.surfaceView);

        barcodeDetector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.QR_CODE)
                .build();
        cameraSource = new CameraSource
                .Builder(this, barcodeDetector)
                .setRequestedPreviewSize(640,480)
                .build();

        //Add Event
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
                    //Request permission
                    ActivityCompat.requestPermissions(ScannerActivity.this,
                            new String[]{Manifest.permission.CAMERA}, RequestCameraPermissionID);

                try {
                    cameraSource.start(surfaceView.getHolder());
                } catch (IOException e) {
                    e.printStackTrace();
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
               //final SparseArray<Barcode> qrcodes = detections.getDetectedItems();
                //if(qrcodes.size() != 0)
                //{
                   // txtResult.post(new Runnable() {
                      //  @Override
                      //  public void run() {
                            //Create vibrate
                            //Vibrator vibrator = (Vibrator)getApplication().getSystemService(Context.VIBRATOR_SERVICE);
                           // vibrator.vibrate(1000);
                           // txtResult.setText(qrcodes.valueAt(0).displayValue);
                       // }
                  //  });
               // }
            }
        });
    }
}