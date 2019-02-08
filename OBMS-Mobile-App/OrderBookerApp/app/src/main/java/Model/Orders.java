package Model;

/**
 * Created by Ahsan Habib on 31-Aug-18.
 */

public class Orders {

    private String product_name;
    private String quantity;
    private String unit_Price;
    private String total_price;
    private String order_id;
    private String product_id;


    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnit_Price() {
        return unit_Price;
    }

    public void setUnit_Price(String unit_Price) {
        this.unit_Price = unit_Price;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }


}
