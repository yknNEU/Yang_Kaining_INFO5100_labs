package model;

import java.util.ArrayList;

public class MasterOrderList {

    private ArrayList<Order> orderList;

    public MasterOrderList() {
        orderList = new ArrayList<Order>();
    }

    public Order addOrder() {
        Order order = new Order();
        orderList.add(order);
        return order;
    }

    public Order addOrder(Order order) {
        orderList.add(order);
        return order;
    }

    public void removeOrder(Order order) {
        orderList.remove(order);
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }
}
