package vn.hrtech.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class CabinetListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabinet_list);

        CardView cabinet = (CardView)findViewById(R.id.cabinet);
        cabinet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CabinetListActivity.this, QrCodeScannerActivity.class);
                startActivity(intent);
            }
        });
    }
}
