package Orders;

public class OrderItem {
    public Projects project;
    public Vacancy vacans;
    static int order_id_counter=0;
    public int order_id;

    public  OrderItem(){};

    public OrderItem(Projects aProject){
        order_id_counter++;
        project = aProject;
        order_id = order_id_counter;
    }

    public OrderItem(Vacancy aVacancy){
        order_id_counter++;
        vacans = aVacancy;
        order_id = order_id_counter;
    }

    public OrderItem[] registerProject_orders( Projects[] projects ){
        OrderItem[] oI = new OrderItem[projects.length];
        int starter = 0;
        int test = 0;
        for( Projects p : projects ){
            oI[starter++] = new OrderItem(p);
        }
        return oI;
    }

    public void addOrder(Vacancy aVacans){
        vacans = aVacans;
    }

    public OrderItem[] registerVacancies_orders(Vacancy[] vacancies) {
        OrderItem[] oI = new OrderItem[vacancies.length];
        int starter = 0;
        int test = 0;
        for( Vacancy v : vacancies ){
            oI[starter++] = new OrderItem(v);
        }
        return oI;
    }
}
