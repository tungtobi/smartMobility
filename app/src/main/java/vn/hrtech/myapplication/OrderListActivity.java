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

import java.util.ArrayList;

import vn.hrtech.myapplication.Modals.ListAdapter;
import vn.hrtech.myapplication.Modals.Order;

public class OrderListActivity extends AppCompatActivity {

    private FloatingActionButton btnAddGoods;
    private ArrayList<Order> orders;
    ListView listView;
    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        listView = (ListView)findViewById(R.id.listView);

        btnAddGoods = (FloatingActionButton)findViewById(R.id.floatingActionButton);
        btnAddGoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddGoodsDialog();
            }
        });

        orders = new ArrayList<Order>();
        orders.add(new Order("ĐƠN HÀNG 01", "L01", "Miêu tả đơn hàng"));
        orders.add(new Order("ĐƠN HÀNG 02", "L34", "Miêu tả đơn hàng"));
        orders.add(new Order("ĐƠN HÀNG 03", "L78", "Miêu tả đơn hàng"));
        orders.add(new Order("ĐƠN HÀNG 04", "L78", "Miêu tả đơn hàng"));
        orders.add(new Order("ĐƠN HÀNG 05", "L78", "Miêu tả đơn hàng"));
        orders.add(new Order("ĐƠN HÀNG 06", "L78", "Miêu tả đơn hàng"));
        orders.add(new Order("ĐƠN HÀNG 07", "L78", "Miêu tả đơn hàng"));
        orders.add(new Order("ĐƠN HÀNG 08", "L78", "Miêu tả đơn hàng"));
        orders.add(new Order("ĐƠN HÀNG 09", "L78", "Miêu tả đơn hàng"));
        orders.add(new Order("ĐƠN HÀNG 10", "L78", "Miêu tả đơn hàng"));
        orders.add(new Order("ĐƠN HÀNG 11", "L78", "Miêu tả đơn hàng"));
        orders.add(new Order("ĐƠN HÀNG 12", "L78", "Miêu tả đơn hàng"));
        orders.add(new Order("ĐƠN HÀNG 13", "L78", "Miêu tả đơn hàng"));
        orders.add(new Order("ĐƠN HÀNG 14", "L78", "Miêu tả đơn hàng"));
        orders.add(new Order("ĐƠN HÀNG 15", "L78", "Miêu tả đơn hàng"));
        orders.add(new Order("ĐƠN HÀNG 16", "L78", "Miêu tả đơn hàng"));
        orders.add(new Order("ĐƠN HÀNG 17", "L78", "Miêu tả đơn hàng"));
        orders.add(new Order("ĐƠN HÀNG 18", "L78", "Miêu tả đơn hàng"));
        orders.add(new Order("ĐƠN HÀNG 19", "L78", "Miêu tả đơn hàng"));
        orders.add(new Order("ĐƠN HÀNG 20", "L78", "Miêu tả đơn hàng"));


        adapter = new ListAdapter(OrderListActivity.this, R.layout.order_custom_layout, orders);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (!orders.get(position).isComplete()) {
                    Intent intent = new Intent(OrderListActivity.this, QrCodeScannerActivity.class);
                    startActivity(intent);
                }
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

                orders.add(0, new Order(id, "X", describle));

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
