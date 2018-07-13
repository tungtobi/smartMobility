package vn.hrtech.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        TextView textViewName = (TextView)findViewById(R.id.textViewName);
        textViewName.setText(User.data.getId());

        CardView btnReadList = (CardView) findViewById(R.id.cardViewReadList);
        btnReadList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, OrderListActivity.class);
                startActivity(intent);
            }
        });

        CardView btnAccount = (CardView) findViewById(R.id.cardViewAccount);
        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, AccountActivity.class);
                startActivity(intent);
            }
        });
    }
}
