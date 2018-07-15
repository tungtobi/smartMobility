package vn.hrtech.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import vn.hrtech.myapplication.Modals.Cabinet;
import vn.hrtech.myapplication.Modals.User;
import vn.hrtech.myapplication.MyRequest.CabinetRequest;

public class CabinetListActivity extends AppCompatActivity {

    Cabinet cabinet;
    CardView cabinetCV;
    CardView cabinetCV2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabinet_list);

        CabinetRequest cabinetRequest = new CabinetRequest(this);
        cabinet = cabinetRequest.getCabinet();

        cabinetCV = (CardView)findViewById(R.id.cabinet);
        cabinetCV2 = (CardView)findViewById(R.id.cabinet2);


        cabinetCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CabinetListActivity.this, QrCodeScannerActivity.class);
                intent.putExtra("key", "1");
                startActivity(intent);
            }
        });

        cabinetCV2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CabinetListActivity.this, QrCodeScannerActivity.class);
                intent.putExtra("key", "2");
                startActivity(intent);
            }
        });

    }
}
