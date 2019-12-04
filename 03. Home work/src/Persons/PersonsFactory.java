package Persons;

import Profiles.Account;
import Profiles.Profile;
import Profiles.ProgLanguages;

import java.util.Random;

public class PersonsFactory {

    public Client getClient(){
        Client newClient = new Client();
        String[] names_vacab = {"Юлий", "Харитон", "Сава", "Харитон", "Конрад", "Александр", "Остап", "Тарас", "Трофим", "Орландо", "Ян", "Никита", "Лоренс", "Валериан", "Павел", "Виль", "Фёдор", "Юлий", "Бронислав", "Орландо", "Матвей", "Тарас", "Кир", "Дан", "Иннокентий", "Платон", "Ждан", "Эрик", "Радислав", "Харитон", "Жигер", "Устин", "Юрий", "Остин", "Назар", "Лаврентий", "Устин", "Богдан", "Платон", "Зуфар", "Артём", "Евсей", "Богдан", "Ярослав", "Гордей", "Юлий", "Харитон", "Мирослав", "Лаврентий"};

        newClient.setName(names_vacab[ (int)(Math.random() * (names_vacab.length-1) + 1) ]);
        newClient.setAge(getRandomInt(20, 50));

        return newClient;
    }

    public Client[] createClients(int how_many){
        Client[] clients = new Client[how_many];
        int starter = 0;
        while(how_many-- > 0){
            clients[starter++] = this.getClient();
        }

        return clients;
    }

    public Account[] createCustomers(Account[] accounts, int how_many){
        Account[] customers = new Account[how_many];
        int starter = 0;
        while( starter < how_many ){
            int rNum = getRandomInt(0, accounts.length-1);
            if( accounts[rNum].getIs_customer() != 1 ) {
                accounts[rNum].setIs_customer(1);
                customers[starter] = accounts[rNum];
            }else {
                starter--;
            }
            starter++;
        }

        return customers;
    }

    public Account findAcc(Account[] aAccounts, int id){
        for( Account acc : aAccounts ){
            if( acc.client_id == id ) return acc;
        }
        return null;
    }


    public Freelancers[] createFreelancers(Account[] accounts, int how_many, ProgLanguages[] pl){
        Freelancers[] nf = new Freelancers[how_many];
        Integer[] in_use = new Integer[how_many];
        int starter = 0;
        while( starter < how_many ){
            boolean allowed = false;
            int rNum = getRandomInt(0, accounts.length-1);
            int repeater = starter;
            int flag = 0;
            while( 0 < repeater && repeater > 0 ){
                if( in_use[flag++] == rNum ) allowed = true;
                repeater--;
            }
            if( accounts[rNum].getIs_customer() != 1 && !allowed ){
                in_use[starter] = rNum;
                Freelancers fl = new Freelancers(accounts[rNum].client_id);
                fl.fillProfile(pl);
                nf[starter] = fl;
            }else {
                starter--;
            }
            starter++;
        }

        return nf;
    }


    public void printArray(Client[] clients){
        for (Client k : clients){
            System.out.println(k.getName() + " " + k.getAge());
        }
    }


    private int getRandomInt(int min, int max){ // Here I create random age for clients
        Random rn = new Random();
        return  rn.nextInt(max - min + 1) + min;
    }

    private String createEmail(String client_name){
        return client_name.toLowerCase() + "@gmail.com";
    }
}
