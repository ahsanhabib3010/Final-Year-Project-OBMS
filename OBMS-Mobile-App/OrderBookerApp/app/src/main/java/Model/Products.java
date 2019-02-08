package Model;

/**
 * Created by Ahsan Habib on 20-Jul-18.
 */

public class Products {

    String product_id;
    String distributor_id;
    String product_name;
    String product_perunitprize;
    int quantity;
    int orderQuantity;
    Boolean checked;

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getDistributor_id() {
        return distributor_id;
    }

    public void setDistributor_id(String distributor_id) {
        this.distributor_id = distributor_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_perunitprize() {
        return product_perunitprize;
    }

    public void setProduct_perunitprize(String product_perunitprize) {
        this.product_perunitprize = product_perunitprize;
    }
}
