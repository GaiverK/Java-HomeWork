package Profiles;

public class Skill {
    int experience;
    String lang_name;
    ProgLanguages[] prLangs;

    public Skill(ProgLanguages[] pL){
        prLangs = pL;
        experience = (int)(Math.random() * (10) + 1);
        lang_name = pL[(int)(Math.random() * (pL.length-1) + 1)].getLanguage_name();
    }

    public int getExperience() {
        return experience;
    }

    public String getLang_name() {
        return lang_name;
    }
}
