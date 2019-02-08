package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import Helper.Helper;
import Model.Inventory;
import Model.Mavras;
import pk.org.hands.handsinternational.MavraDetailActivity;
import pk.org.hands.handsinternational.R;

/**
 * Created by Daniyal Nawaz on 1/14/2018.
 */

public class InventoryAdapter extends BaseAdapter {

    Context context;
    List<Inventory> inventoryList;
    private static LayoutInflater inflater=null;

    public InventoryAdapter(Context context, List<Inventory> inventoryList) {
        // TODO Auto-generated constructor stub
        this.context=context;
        this.inventoryList =inventoryList;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return inventoryList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        CheckBox checkbox;
        TextView textView;
        TextView txtQty;
        LinearLayout plus;
        LinearLayout minus;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=null;

        if(convertView==null){
            convertView = inflater.inflate(R.layout.item_inventory, null);
            holder = new Holder();

            holder.checkbox=(CheckBox) convertView.findViewById(R.id.checkbox);
            holder.textView=(TextView) convertView.findViewById(R.id.textview);
            holder.txtQty=(TextView) convertView.findViewById(R.id.txt_qty);
            holder.plus=(LinearLayout) convertView.findViewById(R.id.plus);
            holder.minus=(LinearLayout) convertView.findViewById(R.id.minus);


            holder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    int getPosition = (Integer) buttonView.getTag();  // Here we get the position that we have set for the checkbox using setTag.
                    inventoryList.get(getPosition).setChecked(buttonView.isChecked()); // Set the value of checkbox to maintain its state.
                    //Helper.showToast(context,inventoryList.get(position).getQty()+"");
                }
            });
            convertView.setTag(holder);
            convertView.setTag(R.id.textview, holder.textView);
            convertView.setTag(R.id.checkbox, holder.checkbox);
            convertView.setTag(R.id.plus, holder.plus);
            convertView.setTag(R.id.minus, holder.minus);
            convertView.setTag(R.id.txt_qty, holder.txtQty);

            final Holder finalHolder = holder;
            holder.plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int qty = inventoryList.get(position).getQty()+1;
                    if(qty<=20){
                        inventoryList.get(position).setQty(qty);
                        finalHolder.txtQty.setText(String.valueOf(qty));
                    }
                }
            });

            holder.minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int qty = inventoryList.get(position).getQty()-1;
                    if(qty>=0){
                        inventoryList.get(position).setQty(qty);
                        finalHolder.txtQty.setText(String.valueOf(qty));
                    }
                }
            });

        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.checkbox.setTag(position); // This line is important.

        holder.textView.setText(inventoryList.get(position).getInventoryName());
        holder.checkbox.setChecked(inventoryList.get(position).isChecked());
        holder.checkbox.setText(inventoryList.get(position).getQty()+"");

        return convertView;
    }
}
