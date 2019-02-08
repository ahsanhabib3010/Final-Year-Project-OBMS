package Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahsanhabib.orderbookerapp.R;
import com.example.ahsanhabib.orderbookerapp.Shopkeeper_FinalOrder;
import com.example.ahsanhabib.orderbookerapp.Shopkeeper_Products;

import java.util.ArrayList;
import java.util.List;

import Model.ProductInventory;
import Model.Products;

/**
 * Created by Ahsan Habib on 21-Jul-18.
 */

public class ProductInventoryAdapter extends BaseAdapter {

    Context context;
    List<Products> inventoryList;
    private static LayoutInflater inflater=null;

    public ProductInventoryAdapter(Context context, List<Products> inventoryList) {
        // TODO Auto-generated constructor stub
        this.context=context;
        this.inventoryList = inventoryList;
        Log.i("length", inventoryList.size()+"");
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return inventoryList.size();
    }

    @Override
    public Object getItem(int i) {
        return inventoryList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    public static class Holder
    {
        CheckBox checkbox;
        TextView textView;
        TextView txtQty;
        LinearLayout plus;
        LinearLayout minus;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //TODO Auto-generated method stub
        Holder holder=null;

        if(convertView==null){
            convertView = inflater.inflate(R.layout.item_inventory, null);
            holder = new Holder();

            holder.checkbox=(CheckBox) convertView.findViewById(R.id.checkbox);
            holder.textView=(TextView) convertView.findViewById(R.id.product_name);
            holder.txtQty=(TextView) convertView.findViewById(R.id.txt_qty);
            holder.plus=(LinearLayout) convertView.findViewById(R.id.plus);
            holder.minus=(LinearLayout) convertView.findViewById(R.id.minus);


// Sir ka code hai neechey...!!!
            holder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    int getPosition = (Integer) buttonView.getTag();  // Here we get the position that we have set for the checkbox using setTag.

                    inventoryList.get(getPosition).setChecked(buttonView.isChecked()); // Set the value of checkbox to maintain its state.

                    //Helper.showToast(context,inventoryList.get(position).getQty()+"");
                }
            });
            convertView.setTag(holder);
            convertView.setTag(R.id.product_name, holder.textView);
            convertView.setTag(R.id.checkbox, holder.checkbox);
            convertView.setTag(R.id.plus, holder.plus);
            convertView.setTag(R.id.minus, holder.minus);
            convertView.setTag(R.id.txt_qty, holder.txtQty);

            final Holder finalHolder = holder;
            holder.plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int qty = inventoryList.get(position).getOrderQuantity()+1;
                    if(qty<=inventoryList.get(position).getQuantity()){
                        inventoryList.get(position).setOrderQuantity(qty);
                        finalHolder.txtQty.setText(String.valueOf(qty));
                    }
                }
            });

            holder.minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int qty = inventoryList.get(position).getOrderQuantity()-1;
                    if(qty>=0){
                        inventoryList.get(position).setOrderQuantity(qty);
                        finalHolder.txtQty.setText(String.valueOf(qty));
                    }
                }
            });

        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.checkbox.setTag(position); // This line is important.

        holder.textView.setText(inventoryList.get(position).getProduct_name());
//        holder.checkbox.setChecked(inventoryList.get(position).getChecked());
        holder.checkbox.setText(inventoryList.get(position).getOrderQuantity()+"");

        return convertView;
    }

}
