package vn.hrtech.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AccountActivity extends AppCompatActivity {

    private TextView mNameLabel;
    private TextView mSubNameLabel;
    private TextView mRoleLabel;
    private TextView mSubRoleLabel;
    private TextView mIdLabel;
    private TextView mAddressLabel;

    private Button btnLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        btnLogOut = (Button)findViewById(R.id.log_out);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        setUIData();
    }

    private void setUIData() {
        mNameLabel = (TextView)findViewById(R.id.textViewName);
        mNameLabel.setText(User.data.getUsername());

        mSubNameLabel = (TextView)findViewById(R.id.textViewName2);
        mSubNameLabel.setText(User.data.getUsername());

        mRoleLabel = (TextView)findViewById(R.id.textViewRole);
        mRoleLabel.setText(User.data.getRole() + "");

        mSubRoleLabel = (TextView)findViewById(R.id.textViewRole2);
        mSubRoleLabel.setText(User.data.getRole() + "");

        mIdLabel = (TextView)findViewById(R.id.textViewId);
        mIdLabel.setText(User.data.getId());

        mAddressLabel = (TextView)findViewById(R.id.textViewAddress);
        mAddressLabel.setText("Cầu Giấy - Hà Nội");
    }
}
