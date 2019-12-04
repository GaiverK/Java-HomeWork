package Profiles;

public class ProfilesFactory {

    public ProgLanguages[] addLangs(){
        String[] langVacab = {"Action Script","C++/CLI","C++","ColdFusion","Delphi","Dylan","Eiffel","Game Maker Language","Groovy","Haxe","Java","JavaScript","Object Pascal","Objective-C","Perl","PHP","Pike","Python","Ruby","Self","Simula","Smalltalk","Swift","Vala","Visual Basic","Visual DataFlex","Zonnon"};
        ProgLanguages[] prLang = new ProgLanguages[langVacab.length];
        int start = 0;
        for( String k : langVacab ){
            prLang[start++] = new ProgLanguages(k);
        }
        return prLang;
    }

    public void fillClientsProfile(Account[] accounts, int how_many){

    }

    public void addSkill(){

    }
}
