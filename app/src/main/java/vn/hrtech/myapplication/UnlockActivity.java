package vn.hrtech.myapplication;

import android.graphics.Bitmap;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class UnlockActivity extends AppCompatActivity {

    private EditText text;
    private Button btnGetQRCode;
    private String text2QR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unlock);

        text = (EditText) findViewById(R.id.textInput);
        btnGetQRCode = (Button) findViewById(R.id.btnGetQRCode);

        btnGetQRCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showQrCodeDialog();
            }
        });
    }

    private void getQRCode(ImageView imageView) {
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(text2QR, BarcodeFormat.QR_CODE, 240, 240);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            imageView.setImageBitmap(bitmap);
        }
        catch (WriterException e) {
            e.printStackTrace();
        }
    }

    private void showQrCodeDialog() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(UnlockActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_show_qrcode, null);
        final ImageView imageQRCode = (ImageView) mView.findViewById(R.id.qrCode);
        Button btnQuit = (Button) mView.findViewById(R.id.btnQuit);

        text2QR = text.getText().toString().trim();
        getQRCode(imageQRCode);

        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();

        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}
