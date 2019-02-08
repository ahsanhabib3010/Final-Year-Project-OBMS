package Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ahsanhabib.orderbookerapp.R;
import com.example.ahsanhabib.orderbookerapp.Shopkeeper_Products;

import java.util.List;

import Helper.Helper;
import Model.Distributor;
import Model.Products;

/**
 * Created by Ahsan Habib on 24-Jul-18.
 */

public class FinalOrderAdapter extends BaseAdapter {

    Context context;
    List<Products> productsList;
    public FinalOrderAdapter(Context context, List<Products> productsList){

        this.context = context;
        this.productsList = productsList;

        layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return productsList.size();
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
        protected TextView productName;
        protected TextView productQuantity;
        protected TextView productPrice;
    }

    private static LayoutInflater layoutInflater = null;
    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder();

        View rootView = layoutInflater.inflate(R.layout.selected_order,null);

        viewHolder.productName = (TextView) rootView.findViewById(R.id.productName);
        viewHolder.productQuantity = (TextView) rootView.findViewById(R.id.productQty);
        viewHolder.productPrice = (TextView) rootView.findViewById(R.id.productPrice);

        final Products products = productsList.get(i);

        viewHolder.productName.setText(products.getProduct_name());
        viewHolder.productQuantity.setText( String.valueOf(products.getOrderQuantity()));
        viewHolder.productPrice.setText(products.getProduct_perunitprize());


        return rootView;
    }
}
