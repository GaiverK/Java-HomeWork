package com.company;

import Orders.*;
import Persons.*;
import Printer.Printer;
import Printer.Colors;
import Profiles.Account;
import Profiles.ProfilesFactory;
import Profiles.ProgLanguages;


public class Main {

    public static void main(String[] args) {

        // Initialize PersonFactory, ProfileFactory, Printer
        PersonsFactory persF = new PersonsFactory();
        ProfilesFactory pff = new ProfilesFactory();
        Printer pr = new Printer();

        // Add programm langs
        ProgLanguages[] pl = pff.addLangs();

        // Create clients
        int how_many = 20;
        Client[] clients = persF.createClients(20);

        // register accounts for clients
        Account nc = new Account(clients);
        Account[] resAcc = nc.registerAll();

        // Make some clients as freelancers by filling profile
        Freelancers[] nf = persF.createFreelancers(resAcc, 20, pl);

        // Make some clients is customers now
        Account[] newAcc = persF.createCustomers(resAcc, 10);

        // Random customers creates random projects and vacancies
        ProjectFactory pf = new ProjectFactory(pl);
        Projects[] custProjects =  pf.customerCreatesProjects(newAcc, 20);
        Vacancy[] custVacancies =  pf.customerCreatesVacancies(newAcc, 10);


        // Register projects and vacancies in order
        OrderItem oI = new OrderItem();
        OrderItem[] nOI = oI.registerProject_orders(custProjects);
        OrderItem[] nOI2 = oI.registerVacancies_orders(custVacancies);

        // Show orders for projects and vacancies
        Order ord = new Order(nOI); // projects orders
        Order ord2 = new Order(nOI2); // vacancies orders

        pr.printArray(ord.orders, newAcc, "projects"); // Show list of projects orders
//        pr.printArray(ord2.orders, newAcc, "vacancies");

    }


}
