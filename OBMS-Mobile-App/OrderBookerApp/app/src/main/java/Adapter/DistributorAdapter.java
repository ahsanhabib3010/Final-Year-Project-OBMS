package Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahsanhabib.orderbookerapp.R;
import com.example.ahsanhabib.orderbookerapp.Shopkeeper_Products;

import java.util.List;

import Model.Distributor;

/**
 * Created by Ahsan Habib on 14-Jul-18.
 */

public class DistributorAdapter extends BaseAdapter {

    Context context;
    List<Distributor> distributorList;
    public DistributorAdapter(Context context, List<Distributor> distributorList){

        this.context = context;
        this.distributorList = distributorList;

        layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return distributorList.size();
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

        View rootView = layoutInflater.inflate(R.layout.item_distributor,null);

        viewHolder.txtId = (TextView) rootView.findViewById(R.id.dis_id);
        viewHolder.txtName = (TextView) rootView.findViewById(R.id.dis_name);
        viewHolder.txtContact = (TextView) rootView.findViewById(R.id.dis_contact);

        final Distributor distributor = distributorList.get(i);

        viewHolder.txtId.setText(distributor.getId());
        viewHolder.txtName.setText(distributor.getName());
        viewHolder.txtContact.setText(distributor.getContact());

        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(context,distributor.getId()+" - "+distributor.getName(),Toast.LENGTH_SHORT).show();

                Intent product = new Intent(context, Shopkeeper_Products.class);
                product.putExtra("id", distributor.getId());
                product.putExtra("name",distributor.getName());
                Log.i("Distributor ID = ", distributor.getId());
                Log.i("Distributor Name = ", distributor.getName());
                context.startActivity(product);

            }
        });
        return rootView;
    }
}
