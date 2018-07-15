package vn.hrtech.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;

import vn.hrtech.myapplication.Modals.User;
import vn.hrtech.myapplication.MyRequest.CabinetRequest;

public class QrCodeScannerActivity extends AppCompatActivity {

    SurfaceView cameraPreview;
    TextView textViewResult;
    BarcodeDetector barcodeDetector;
    CameraSource cameraSource;
    int requestCameraPermissionId = 1001;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1001: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    try {
                        cameraSource.start(cameraPreview.getHolder());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code_scanner);

        cameraPreview = (SurfaceView) findViewById(R.id.cameraPreview);
        textViewResult = (TextView) findViewById(R.id.textViewResult);
        textViewResult.setVisibility(View.INVISIBLE);
        barcodeDetector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.QR_CODE)
                .build();
        cameraSource = new CameraSource
                .Builder(this, barcodeDetector)
                .setRequestedPreviewSize(640, 480)
                .build();

        // Add event
        cameraPreview.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    // Request permission
                    ActivityCompat.requestPermissions(QrCodeScannerActivity.this,
                            new String[]{Manifest.permission.CAMERA}, requestCameraPermissionId);
                    return;
                }
                try {
                    cameraSource.start(cameraPreview.getHolder());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                cameraSource.stop();
            }
        });
        TextView title = (TextView)findViewById(R.id.title);
        if (!User.data.getUsername().equals("shipper")) {
            if (User.data.getUsername().equals("sender")) {
                title.setText("Quét LOCKER 1");
            } else {
                title.setText("Quét LOCKER 2");
            }
        }

        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> qrcodes = detections.getDetectedItems();
                if (qrcodes.size() != 0) {
                    textViewResult.post(new Runnable() {
                        @Override
                        public void run() {
                            Vibrator vibrator = (Vibrator)getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                            vibrator.vibrate(1000);
                            //textViewResult.setText(qrcodes.valueAt(0).displayValue);
                            //TODO: làm gì đó
                            CabinetRequest cabinetRequest = new CabinetRequest(QrCodeScannerActivity.this);
                            String url;
                            if (User.data.getUsername().equals("sender")) {
                                url = "http://smartdelivery.ml/api/Auth/CustomerSend/locker1";
                            } else if (User.data.getUsername().equals("receive")) {
                                url = "http://smartdelivery.ml/api/Auth/CustomerRecievie/locker2";
                            } else {
                                if (getIntent().getStringExtra("key").equals("1")) {
                                    url = "http://smartdelivery.ml/api/Auth/ShipperSend/locker1";
                                } else {
                                    url = "http://smartdelivery.ml/api/Auth/ShipperRecievie/015fabf4-2436-4933-a294-0a25ae4080a1/locker2";
                                }
                            }
                            cabinetRequest.openCabinet(url);
                            finish();
                        }
                    });
                }
            }
        });

    }
}