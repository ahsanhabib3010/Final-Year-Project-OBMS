package Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahsanhabib.orderbookerapp.R;
import com.example.ahsanhabib.orderbookerapp.Shopkeeper_Products;

import java.util.List;

import Model.Distributor;
import Model.Products;

/**
 * Created by Ahsan Habib on 21-Jul-18.
 */
//
//public class ProductListAdapter extends BaseAdapter {
//
//    Context context;
//    List<Products> productsList;
//    public ProductListAdapter(Context context, List<Products> productsList){
//
//        this.context = context;
//        this.productsList = productsList;
//
//        layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//    }
//
//
//    @Override
//    public int getCount() {
//        return productsList.size();
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return 0;
//    }
//
//
//    class ViewHolder{
//        protected TextView productName;
//    }
//
//    private static LayoutInflater layoutInflater = null;
//    @Override
//    public View getView(final int i, View view, ViewGroup viewGroup) {
//        ViewHolder viewHolder = new ViewHolder();
//
//        View rootView = layoutInflater.inflate(R.layout.item_inventory,null);
//
//        viewHolder.productName = (TextView) rootView.findViewById(R.id.product_name);
//
//        final Products products = productsList.get(i);
//
//        viewHolder.productName.setText(products.getProduct_name());
//
////        rootView.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Toast.makeText(context,products.getProduct_name()+" - "+products.getProduct_id(),Toast.LENGTH_SHORT).show();
////
//////                Intent product = new Intent(context, Shopkeeper_Products.class);
////
//////                product.putExtra("id", products.getId());
//////                Log.i("id = ", products.g());
//////                context.startActivity(product);
////                Toast.makeText(context, "Product list of Selected Distributor = "+ products.getProduct_id(), Toast.LENGTH_LONG).show();etId
////            }
////        });
//        return rootView;
//    }
//
//
//}
