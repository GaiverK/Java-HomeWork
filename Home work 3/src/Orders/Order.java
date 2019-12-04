package Orders;

import Persons.Freelancers;

public class Order {
    public OrderItem[] orders;
    public Freelancers[] freelancers;

    public Order( OrderItem[] ords  ){
        orders = ords;
    }

}
