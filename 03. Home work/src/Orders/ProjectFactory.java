package Orders;

import Profiles.Account;
import Profiles.ProgLanguages;

public class ProjectFactory {
    static int id;
    String subject;
    ProgLanguages[] prLangs;
    public String lang_type;
    String description;
    public int customer_id;

    public ProjectFactory(ProgLanguages[] aPrLang){
        prLangs = aPrLang;
    }

    public ProjectFactory(String aSubject, ProgLanguages[] aPrLang, String aDescription, int aCustomer_id, String aLang){
        subject = aSubject;
        prLangs = aPrLang;
        description = aDescription;
        customer_id = aCustomer_id;
        lang_type = aLang;
     }

    public Projects[] customerCreatesProjects(Account[] customers, int how){
        Projects[] np = new Projects[how];
        int starter = 0;
        while(0 < how--){
            int cust_id = customers[(int)(Math.random() * (customers.length-1) + 1)].client_id;
            Projects n = addProject(cust_id);
            np[starter++] = n;
        }

        return np;
    }

    public Vacancy[] customerCreatesVacancies(Account[] customers, int how){
        Vacancy[] np = new Vacancy[how];
        int starter = 0;
        while(0 < how--){
            int cust_id = customers[(int)(Math.random() * (customers.length-1) + 1)].client_id;
            Vacancy n = addVacancy(cust_id);
            np[starter++] = n;
        }

        return np;
    }

    public Projects addProject(int customer_id){
        String pLang = prLangs[ (int)(Math.random() * (prLangs.length-1) + 1) ].getLanguage_name();

        Projects newProj = new Projects("Разработка скрипта на " + pLang, prLangs, "Описание задачи по " + pLang, (int)(Math.random() * (3000) + 1000), customer_id, pLang);
        id++;
        return  newProj;
    }

    public Vacancy addVacancy(int customer_id){
        String pLang = prLangs[ (int)(Math.random() * (prLangs.length-1) + 1) ].getLanguage_name();

        Vacancy newVacancy = new Vacancy("Full time разработчик " + pLang, prLangs, "Предоставим жилье и оформим переезд", (int)(Math.random() * (3000) + 1000), customer_id, pLang);
        id++;
        return  newVacancy;
    }

    public String getSubject() {
        return subject;
    }

    public String getDescription() {
        return description;
    }
}
