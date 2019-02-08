package Helper;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import Adapter.ProductInventoryAdapter;
import Model.Products;

/**
 * Created by Ahsan Habib on 21-Jul-18.
 */

public class Helper {
    public static List<Products> SELECTED_PRODUCTS = new ArrayList<>();

    public static String localhost = "192.168.0.103";

//    public static String  REGISTER_SHOPKEEPER_URL = "https://ahsanhabib3010.000webhostapp.com/script/addShopkeeper.php";

    // Shopkeeper Login URL
//    public static String LOGIN_SHOPKEEPER_URL = "https://ahsanhabib3010.000webhostapp.com/script/shopkeeperLogin.php";

    // Shopkeeper Update URL
//    public static String UPDATE_SHOPKEEPER_PROFILE_URL = "https://ahsanhabib3010.000webhostapp.com/script/updateShopkeeper.php";


    // Getting distributor list URL for Shopkeeper
//    public static String Distributor_List_URL = "https://ahsanhabib3010.000webhostapp.com/script/getDistributorList.php";

    // Getting Product list of  Selected Distributor
//    public static String Product_List_URL = "https://ahsanhabib3010.000webhostapp.com/script/getProductList.php";


    // Final Order Placement URL
//    public static String FINAL_ORDER_URL = "https://ahsanhabib3010.000webhostapp.com/script/finalOrderPlacement.php";

    ///////////////////////////////////////////////////////

//    public static String REGISTER_DISTRIBUTOR_URL = "https://ahsanhabib3010.000webhostapp.com/cms/distributorScripts/distributorRegister.php";
    // Distributor Login URL
//    public static String LOGIN_DISTRIBUTOR_URL = "https://ahsanhabib3010.000webhostapp.com/cms/distributorScripts/distributorLogin.php";
    // Shopkeeper List URL
//    public static String Shopkeeper_List_URL = "https://ahsanhabib3010.000webhostapp.com/cms/distributorScripts/getShopkeeperList.php";

//    public static String Orders_List_URL = "https://ahsanhabib3010.000webhostapp.com/cms/distributorScripts/orders.php";

//    public static String Orders_Reject_URL = "https://ahsanhabib3010.000webhostapp.com/cms/distributorScripts/orders-reject.php";






    // Shopkeeper Full Functionality URL below---->>>
    // Shopkeeper Registration URL
    public static String  REGISTER_SHOPKEEPER_URL = "http://"+localhost+":8080/FYP/obms/script/addShopkeeper.php";
//
//    // Shopkeeper Login URL
    public static String LOGIN_SHOPKEEPER_URL = "http://"+localhost+":8080/FYP/obms/script/shopkeeperLogin.php";
//
//    // Shopkeeper Update URL
    public static String UPDATE_SHOPKEEPER_PROFILE_URL = "http://"+localhost+":8080/FYP/obms/script/updateShopkeeper.php";
//
//
//    // Getting distributor list URL for Shopkeeper
    public static String Distributor_List_URL = "http://"+localhost+":8080/FYP/obms/script/getDistributorList.php";
//
//    // Getting Product list of  Selected Distributor
    public static String Product_List_URL = "http://"+localhost+":8080/FYP/obms/script/getProductList.php";
//
//
//    // Final Order Placement URL
    public static String FINAL_ORDER_URL = "http://"+localhost+":8080/FYP/obms/script/finalOrderPlacement.php";




    // Distributor Full Functionality URL below---->>>
    // Distributor Registration URL
    public static String REGISTER_DISTRIBUTOR_URL = "http://"+localhost+":8080/FYP/obms/cms/distributorScripts/distributorRegister.php";
//    // Distributor Login URL
    public static String LOGIN_DISTRIBUTOR_URL = "http://"+localhost+":8080/FYP/obms/cms/distributorScripts/distributorLogin.php";
//    // Shopkeeper List URL
    public static String Shopkeeper_List_URL = "http://"+localhost+":8080/FYP/obms/cms/distributorScripts/getShopkeeperList.php";
//
    public static String Orders_List_URL = "http://"+localhost+":8080/FYP/obms/cms/distributorScripts/orders.php";
//
    public static String Orders_Reject_URL = "http://"+localhost+":8080/FYP/obms/cms/distributorScripts/orders-reject.php";


}
