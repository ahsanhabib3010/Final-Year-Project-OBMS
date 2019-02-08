package Model;

/**
 * Created by Ahsan Habib on 21-Jul-18.
 */

public class ProductInventory {

    String order_id;
    String shopkeeper_id;
    String distributor_id;
    String order_name;
    int order_quantity;
    String order_perunitprice;
    String order_status;
    boolean checked;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getShopkeeper_id() {
        return shopkeeper_id;
    }

    public void setShopkeeper_id(String shopkeeper_id) {
        this.shopkeeper_id = shopkeeper_id;
    }

    public String getDistributor_id() {
        return distributor_id;
    }

    public void setDistributor_id(String distributor_id) {
        this.distributor_id = distributor_id;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public int getOrder_quantity() {
        return order_quantity;
    }

    public void setOrder_quantity(int order_quantity) {
        this.order_quantity = order_quantity;
    }

    public String getOrder_perunitprice() {
        return order_perunitprice;
    }

    public void setOrder_perunitprice(String order_perunitprice) {
        this.order_perunitprice = order_perunitprice;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
