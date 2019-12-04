package Profiles;

import Persons.Client;

public class Account {
    Client[] clients;
    static int acc_id = 0;
    private String email;
    public String cl_name;
    public int cl_age;
    private int password;
    private int is_customer;
    private int is_freelancer;
    public int client_id;

    public Account(Client[] nClients){
        clients = nClients;
    }

    public void register(String aEmail, int aPassword, Client aClient){
        email = aEmail;
        password = aPassword;
        acc_id++;
        client_id = acc_id;
        cl_name = aClient.getName();
        cl_age = aClient.getAge();
    }

    public Account[] registerAll(){
        Account[] accounts = new Account[clients.length];
        int start = 0;
        for( Client k : clients ){
            Account newAcc = new Account(clients);
            newAcc.register(createEmail(k.getName()), k.hashCode(), k);
            accounts[start++] = newAcc;
        }

        return accounts;
    }


    private String createEmail(String client_name){
        return client_name.toLowerCase() + "@gmail.com";
    }

    public String login(String aEmail, int aPassword){
        if( email == aEmail && password == aPassword ) return "Logged in";
        return "Incorrect email or password";
    }

    public String getEmail(){
        return email;
    }

    public int getPassword() {
        return password;
    }

    public int getIs_customer() {
        return is_customer;
    }

    public int getIs_freelancer() {
        return is_freelancer;
    }

    public void setIs_customer(int is_customer) {
        this.is_customer = is_customer;
    }

    public void setIs_freelancer(int is_freelancer) {
        this.is_freelancer = is_freelancer;
    }

    public int getClient_id() {
        return client_id;
    }


}
