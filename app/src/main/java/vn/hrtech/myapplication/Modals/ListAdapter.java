package vn.hrtech.myapplication.Modals;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.hrtech.myapplication.Modals.Order;
import vn.hrtech.myapplication.R;

public class ListAdapter extends ArrayAdapter<Goods> {

    public ListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ListAdapter(Context context, int resource, List<Goods> items) {
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

        Goods goods = getItem(position);

        if (goods != null) {
            ImageView imageStatus = (ImageView)view.findViewById(R.id.imageStatus);
            if (goods.getStatus() >= 0) {
                //int status = Integer.parseInt(goods.getStatus());
                if (goods.getStatus() < 5) {
                    imageStatus.setImageResource(R.drawable.ic_loop_black_24dp);
                } else if (goods.getStatus() == 5) {
                    imageStatus.setImageResource(R.drawable.ic_input_black_24dp);
                } else {
                    imageStatus.setImageResource(R.drawable.ic_check_black_24dp);
                }

                TextView textViewName = (TextView) view.findViewById(R.id.textViewName);
                textViewName.setText(goods.getName());

                TextView textViewDescribe = (TextView) view.findViewById(R.id.textViewDescribe);
                textViewDescribe.setText(goods.getAddressRecive());
            }
        }
        return view;
    }


}
