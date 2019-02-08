package Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ahsanhabib.orderbookerapp.Distributor_Orders;
import com.example.ahsanhabib.orderbookerapp.R;

import java.util.List;

import Model.Shopkeeper;

/**
 * Created by Ahsan Habib on 31-Aug-18.
 */

public class ShopkeeperAdapter extends BaseAdapter {
    Context context;
    List<Shopkeeper> shopkeeperList;
    public ShopkeeperAdapter(Context context, List<Shopkeeper> shopkeeperList){

        this.context = context;
        this.shopkeeperList = shopkeeperList;

        layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return shopkeeperList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    class ViewHolder{
        protected TextView txtId;
        protected TextView txtName;
        protected TextView txtContact;
    }

    private static LayoutInflater layoutInflater = null;

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder();

        View rootView = layoutInflater.inflate(R.layout.item_orders,null);

        viewHolder.txtId = (TextView) rootView.findViewById(R.id.shopkeeper_id);
        viewHolder.txtName = (TextView) rootView.findViewById(R.id.shopkeeper_name);
        viewHolder.txtContact = (TextView) rootView.findViewById(R.id.shopkeeper_contact);

        final Shopkeeper shopkeeper = shopkeeperList.get(i);

        viewHolder.txtId.setText(shopkeeper.getId());
        viewHolder.txtName.setText(shopkeeper.getName());
        viewHolder.txtContact.setText(shopkeeper.getContact());

        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(context,distributor.getId()+" - "+distributor.getName(),Toast.LENGTH_SHORT).show();

                Intent orders = new Intent(context, Distributor_Orders.class);
                orders.putExtra("id", shopkeeper.getId());
                orders.putExtra("name",shopkeeper.getName());
                Log.i("Shopkeeper ID = ", shopkeeper.getId());
                Log.i("Shopkeeper Name = ", shopkeeper.getName());
                context.startActivity(orders);

            }
        });


        return rootView;
    }
}
