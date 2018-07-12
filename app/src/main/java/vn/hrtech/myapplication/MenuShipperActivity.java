package vn.hrtech.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuShipperActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_shipper);

        TextView textViewName = (TextView)findViewById(R.id.textViewName);
        textViewName.setText(User.data.getId());

        CardView btnGetPackage = (CardView) findViewById(R.id.cardViewGetPack);
        btnGetPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuShipperActivity.this, UnlockActivity.class);
                startActivity(intent);
            }
        });

        CardView btnReadList = (CardView) findViewById(R.id.cardViewReadList);
        btnReadList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuShipperActivity.this, OrderListActivity.class);
                startActivity(intent);
            }
        });
    }
}
