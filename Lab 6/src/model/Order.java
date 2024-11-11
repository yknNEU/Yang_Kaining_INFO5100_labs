package model;

import java.util.ArrayList;

public class Order {
    
    private ArrayList<OrderItem> orderItemList;

    public Order() {
        orderItemList = new ArrayList<OrderItem>();
    }

    public OrderItem addNewOrderItem(Product product, int quantity, double salesPrice) {
        OrderItem orderItem = new OrderItem(product, quantity, salesPrice);
        orderItemList.add(orderItem);
        return orderItem;
    }

    public void removeOrderItem(OrderItem orderItem) {
        orderItemList.remove(orderItem);
    }

    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public void deleteItem(OrderItem orderItem) {
        this.orderItemList.remove(orderItem);
    }

    public OrderItem findProduct(Product product) {
        for (OrderItem orderItem : orderItemList) {
            if (orderItem.getProduct().equals(product)) {
                return orderItem;
            }
        }
        return null;
    }
}
