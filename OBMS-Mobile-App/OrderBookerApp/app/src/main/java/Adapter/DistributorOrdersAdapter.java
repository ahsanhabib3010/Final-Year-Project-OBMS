package Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahsanhabib.orderbookerapp.Distributor_Orders;
import com.example.ahsanhabib.orderbookerapp.R;

import java.util.List;

import Model.Orders;
import Model.Shopkeeper;

/**
 * Created by Ahsan Habib on 31-Aug-18.
 */

public class DistributorOrdersAdapter extends BaseAdapter {

    Context context;
    List<Orders> orderList;

    public DistributorOrdersAdapter(Context context, List<Orders> orderList) {

        this.context = context;
        this.orderList = orderList;

        layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return orderList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    class ViewHolder {
        protected TextView product_name;
        protected TextView quantity;
        protected TextView unitPrice;
    }

    private static LayoutInflater layoutInflater = null;

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder();

        View rootView = layoutInflater.inflate(R.layout.distributor_orders, null);

        viewHolder.product_name = (TextView) rootView.findViewById(R.id.name);
        viewHolder.quantity = (TextView) rootView.findViewById(R.id.qty);
        viewHolder.unitPrice = (TextView) rootView.findViewById(R.id.unit_price);

        final Orders orders = orderList.get(i);

        viewHolder.product_name.setText(orders.getProduct_name());
        viewHolder.quantity.setText(orders.getQuantity());
        viewHolder.unitPrice.setText(orders.getUnit_Price());

        return rootView;
    }
}
