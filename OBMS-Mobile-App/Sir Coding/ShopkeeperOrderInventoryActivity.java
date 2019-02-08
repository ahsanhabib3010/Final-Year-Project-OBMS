package pk.org.hands.handsinternational;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Adapter.ProductListAdapter;
import Adapter.SelectedProductAdapter;
import Adapter.UserListAdapter;
import Helper.Helper;
import Helper.SQLiteHandler;
import Model.Product;
import Model.User;

public class ShopkeeperOrderInventoryActivity extends AppCompatActivity {
    ListView listView;
    ImageView imgGoBack;
    TextView txtView;
    Context context;
    SelectedProductAdapter adapter;
    SQLiteHandler db;
    Button btnCheckout;
    //List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getAttributes().windowAnimations = R.style.Fade;
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        setContentView(R.layout.activity_shopkeeper_order_inventory);
        context = this;
        db = new SQLiteHandler(this);

        initializeControl();
    }

    private void initializeControl() {
        imgGoBack = (ImageView) findViewById(R.id.img_back);
        btnCheckout = (Button) findViewById(R.id.btn_go_to_next);
        txtView = (TextView) findViewById(R.id.txt_noor);

        listView = (ListView) findViewById(R.id.list_inventory);
        txtView.setText("Noor Name : "+ Helper.Selected_NOOR.getMarviName());

        imgGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Helper.Selected_NOOR = null;
                Helper.SELECTED_PRODUCT = new ArrayList<>();

                finish();
            }
        });

        if (db.getRowCount(Helper.PRODUCT) > 0) {
            Helper.SELECTED_PRODUCT = db.getAllProductsForSale();
            adapter = new SelectedProductAdapter(context, Helper.SELECTED_PRODUCT);
            listView.setAdapter(adapter);
        }

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0;i<Helper.SELECTED_PRODUCT.size();i++){
                    Product product = Helper.SELECTED_PRODUCT.get(i);
                    if(product.isChecked()){
                        Log.i("Product Id",product.getProductId());
                        Log.i("Product Id",product.getProductName());
                        Log.i("Quantity",product.getSelectedQty()+"");
                        Log.i("Unit Price",product.gettP());
                        Log.i("Total Price",(product.getSelectedQty()*Double.parseDouble(product.gettP()))+"");
                    }
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Helper.Selected_NOOR = null;
        Helper.SELECTED_PRODUCT = new ArrayList<>();

        finish();
    }
}
