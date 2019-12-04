package Printer;

import Orders.Order;
import Orders.OrderItem;
import Orders.Projects;
import Orders.Vacancy;
import Persons.Client;
import Persons.Customers;
import Persons.Freelancers;
import Persons.PersonsFactory;
import Profiles.Account;

public class Printer {

    public void printArray(Client[] clients){
        for (Client k : clients){
            System.out.println(k.getName() + " " + k.getAge());
        }
    }

    public void printArray(Projects[] projects){
        for (Projects k : projects){
            System.out.println(k.customer_id + " " + k.getSubject() + " " + k.getBudget() + "$");
        }
    }

    public void printArray(Vacancy[] vacancies){
        for (Vacancy k : vacancies){
            System.out.println(k.customer_id + " " + k.getSubject() + " " + k.getSalary() + "$");
        }
    }

    public void printArray(Account[] accounts){
        for (Account k : accounts){
            System.out.println(k.client_id + " " +  k.getEmail() + " " + k.getPassword() + " is Customer - " + k.getIs_customer());
        }
    }

    public void printArray(OrderItem[] nOI, String type) {

        for (OrderItem k : nOI){
            if( type == "proj" ){
                System.out.println(k.order_id + " " +  k.project.getSubject() + " Бюджет " + k.project.getBudget() + "$ Customer_id = " + k.project.customer_id);
            }else System.out.println(k.order_id + " " +  k.vacans.getSubject() + " Зарплата " + k.vacans.getSalary() + "$ Customer_id = " + k.vacans.customer_id);
        }
    }

    public void printArray(Freelancers[] fls){
        for (Freelancers k : fls){
            System.out.println(k.prof.phone + " " + k.prof.skill.getLang_name() + " " + k.client_id);
        }
    }

    public void printArray(OrderItem[] orders, Account[] cust, String type){
        PersonsFactory pf = new PersonsFactory();

        if( type == "projects" ) {
            String hor_delimiter = "-------------------------------------------------------------------------------------------------------------------------------------------------";
            String subj = "Заказы на создание проектов";
            System.out.print(Colors.BLUE.getColor());
            System.out.println(hor_delimiter);
            System.out.printf("%" + ((hor_delimiter.length() / 2) + (subj.length() / 2)) + "s\n", subj);
            System.out.println(hor_delimiter);

            for (OrderItem ord : orders) {
                // Single project data
                int cid = ord.project.customer_id;
                Account info = pf.findAcc(cust, cid);
                String order_num = "Заказ #" + ord.order_id;
                String customer = "Заказчик: Имя - " + info.cl_name + " Возраст - " + info.cl_age;
                String project_lang = "Язык разработки: " + ord.project.lang_type;
                String title = "Заголовок";
                String title_info = ord.project.getSubject();
                String description = "Описание задачи";
                String description_info = ord.project.getDescription();
                String budget = "Бюджет: " + ord.project.getBudget() + "$";

                // Single project print out
                System.out.print(Colors.CIAN.getColor());
                System.out.printf("%-" + customer.length() + "s", customer);
                System.out.print(Colors.GREEN.getColor());
                System.out.printf("%" + (hor_delimiter.length() - project_lang.length() + project_lang.length() - customer.length()) + "s\n", project_lang);
                System.out.printf("%" + ((hor_delimiter.length() / 2) + (order_num.length() / 2)) + "s\n", order_num);
                System.out.print(Colors.RED.getColor());
                System.out.printf("%" + ((hor_delimiter.length() / 2) + (title.length() / 2)) + "s\n", title);
                System.out.printf("%" + ((hor_delimiter.length() / 2) + (title_info.length() / 2)) + "s\n", title_info);
                System.out.print(Colors.WHITE.getColor());
                System.out.printf("%" + ((hor_delimiter.length() / 2) + (description.length() / 2)) + "s\n", description);
                System.out.printf("%" + ((hor_delimiter.length() / 2) + (description_info.length() / 2)) + "s\n", description_info);
                System.out.print(Colors.GREEN.getColor());
                System.out.printf("%" + (hor_delimiter.length() - budget.length() + budget.length()) + "s\n", budget);
                System.out.print(Colors.BLUE.getColor());
                System.out.println(hor_delimiter);
            }
        }else {
            String hor_delimiter = "-------------------------------------------------------------------------------------------------------------------------------------------------";
            String subj = "Свежие вакансии";
            System.out.print(Colors.BLUE.getColor());
            System.out.println(hor_delimiter);
            System.out.printf("%" + ((hor_delimiter.length() / 2) + (subj.length() / 2)) + "s\n", subj);
            System.out.println(hor_delimiter);

            for (OrderItem ord : orders) {
                // Single project data
                int cid = ord.vacans.customer_id;
                Account info = pf.findAcc(cust, cid);
                String order_num = "Вакансия #" + ord.order_id;
                String customer = "Заказчик: Имя - " + info.cl_name + " | Возраст - " + info.cl_age;
                String project_lang = "Язык разработки: " + ord.vacans.lang_type;
                String title = "Заголовок";
                String title_info = ord.vacans.getSubject();
                String description = "Описание вакансии";
                String description_info = ord.vacans.getDescription();
                String budget = "Зарплата: " + ord.vacans.getSalary() + "$";

                // Single project print out
                System.out.print(Colors.CIAN.getColor());
                System.out.printf("%-" + customer.length() + "s", customer);
                System.out.print(Colors.GREEN.getColor());
                System.out.printf("%" + (hor_delimiter.length() - project_lang.length() + project_lang.length() - customer.length()) + "s\n", project_lang);
                System.out.printf("%" + ((hor_delimiter.length() / 2) + (order_num.length() / 2)) + "s\n", order_num);
                System.out.print(Colors.RED.getColor());
                System.out.printf("%" + ((hor_delimiter.length() / 2) + (title.length() / 2)) + "s\n", title);
                System.out.printf("%" + ((hor_delimiter.length() / 2) + (title_info.length() / 2)) + "s\n", title_info);
                System.out.print(Colors.WHITE.getColor());
                System.out.printf("%" + ((hor_delimiter.length() / 2) + (description.length() / 2)) + "s\n", description);
                System.out.printf("%" + ((hor_delimiter.length() / 2) + (description_info.length() / 2)) + "s\n", description_info);
                System.out.print(Colors.GREEN.getColor());
                System.out.printf("%" + (hor_delimiter.length() - budget.length() + budget.length()) + "s\n", budget);
                System.out.print(Colors.BLUE.getColor());
                System.out.println(hor_delimiter);
            }
        }
    }


}
