package org.example.exercises.refactor;

import java.util.List;


public class SumPricesRefactorEx2 {

//    List<Order> orders = getOrders(); // Orders have a list of Items
//    double totalPrice = 0.0;
//    for (Order order : orders) {
//        for (Item item : order.getItems()) {
//            if (item.getPrice() > 100) {
//                totalPrice += item.getPrice();
//            }
//        }
//    }

    public static double sumPrices(List<ROrder> orders){

       return orders.stream()
                .flatMap(order -> order.getItems().stream())
                .filter(item -> item.getPrice()>100 )
                .mapToDouble(RItem::getPrice).sum();


    }


}
