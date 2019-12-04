package Orders;

import Profiles.ProgLanguages;

public class Projects extends ProjectFactory {
    int budget;
    public int project_id;
    static int id_counter = 1;

    public Projects(String subj, ProgLanguages[] prlangs, String descr, int aBudget, int customer_id, String pLang){
        super(subj, prlangs, descr, customer_id, pLang);
        budget = aBudget;
        project_id = id_counter++;
    }

    public int getBudget() {
        return budget / 100;
    }

}
