package vn.hrtech.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends ArrayAdapter<Order> {

    public ListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ListAdapter(Context context, int resource, List<Order> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater layoutInflater;
            layoutInflater = LayoutInflater.from(getContext());
            view = layoutInflater.inflate(R.layout.order_custom_layout, null);
        }

        Order order = getItem(position);

        if (order != null) {
            ImageView imageStatus = (ImageView)view.findViewById(R.id.imageStatus);
            imageStatus.setImageResource(
                    order.isComplete() ? R.drawable.ic_check_black_24dp : R.drawable.ic_loop_black_24dp);

            TextView textViewName = (TextView)view.findViewById(R.id.textViewName);
            textViewName.setText(order.getName());

            TextView textViewDescribe = (TextView)view.findViewById(R.id.textViewDescribe);
            textViewDescribe.setText(order.getDescribe());
        }

        return view;
    }
}
