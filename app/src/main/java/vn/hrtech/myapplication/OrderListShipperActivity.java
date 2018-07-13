package vn.hrtech.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderListShipperActivity extends AppCompatActivity {

    ListAdapter adapter;
    ListView listView;
    ArrayList<Order> orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list_shipper);

        listView = (ListView)findViewById(R.id.listView);

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


        adapter = new ListAdapter(OrderListShipperActivity.this, R.layout.order_custom_layout, orders);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (!orders.get(position).isComplete()) {
                    Intent intent = new Intent(OrderListShipperActivity.this, QrCodeScannerActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
