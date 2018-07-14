package vn.hrtech.myapplication;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import vn.hrtech.myapplication.Modals.Goods;
import vn.hrtech.myapplication.Modals.ListAdapter;
import vn.hrtech.myapplication.Modals.Order;
import vn.hrtech.myapplication.MyRequest.GoodsRequest;
import vn.hrtech.myapplication.MyRequest.VolleyCallback;

public class OrderListActivity extends AppCompatActivity {

    private ArrayList<Goods> orders;
    ListView listView;
    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        listView = (ListView)findViewById(R.id.listView);

        FloatingActionButton btnAddGoods = (FloatingActionButton)findViewById(R.id.floatingActionButton);
        btnAddGoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddGoodsDialog();
            }
        });

        setListAdapter();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (orders.get(position).getStatus() == 5) {
                    Intent intent = new Intent(OrderListActivity.this, QrCodeScannerActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void setListAdapter() {
        GoodsRequest goodsRequest = new GoodsRequest(this);
        goodsRequest.getGoodsList(new VolleyCallback() {
            @Override
            public void onSuccess(JSONArray jsonArray) {
                orders = new Gson().fromJson(jsonArray.toString(), new TypeToken<List<Goods>>(){}.getType());
                adapter = new ListAdapter(OrderListActivity.this, R.layout.order_custom_layout, orders);
                listView.setAdapter(adapter);
            }

            @Override
            public void onError(VolleyError volleyError) {

            }
        });
    }

    private void showAddGoodsDialog() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(OrderListActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.activity_add_goods, null);

        final EditText editTextSender = (EditText)mView.findViewById(R.id.sender);
        final EditText editTextReceiver = (EditText) mView.findViewById(R.id.receiver);

        Button btnQuit = (Button) mView.findViewById(R.id.btnQuit);
        Button btnCreate = (Button) mView.findViewById(R.id.btnAdd);

        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editTextSender.getText().toString().trim();
                String describle = editTextReceiver.getText().toString().trim();

                GoodsRequest goodsRequest = new GoodsRequest(OrderListActivity.this);
                goodsRequest.createGoods(id, "");

                listView.setAdapter(adapter);

                dialog.dismiss();
            }
        });

        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}
