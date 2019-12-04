package Orders;

import Profiles.ProgLanguages;

public class Vacancy extends ProjectFactory {
    int salary;

    public Vacancy(String subj, ProgLanguages[] prlangs, String descr, int aSalary, int customer_id, String pLang){
        super(subj, prlangs, descr, customer_id, pLang);
        salary = aSalary;
    }

    public int getSalary() {
        return salary;
    }
}
