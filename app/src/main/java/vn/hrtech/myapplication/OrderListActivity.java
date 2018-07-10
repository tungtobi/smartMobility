package vn.hrtech.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        ListView listView = (ListView)findViewById(R.id.listView);

        ArrayList<Order> orders = new ArrayList<Order>();
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


        ListAdapter adapter = new ListAdapter(OrderListActivity.this, R.layout.order_custom_layout, orders);
        listView.setAdapter(adapter);
    }
}
