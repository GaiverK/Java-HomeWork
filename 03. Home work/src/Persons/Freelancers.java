package Persons;

import Profiles.Account;
import Profiles.Profile;
import Profiles.ProgLanguages;
import Profiles.Skill;

public class Freelancers {
    Skill[] skills;
    Account[] accounts;
    public Profile prof;
    public int client_id;

    public  Freelancers(int cli_id){
        client_id = cli_id;
    }

    public void fillProfile(ProgLanguages[] pL){
        prof = new Profile(pL);
    }
}
