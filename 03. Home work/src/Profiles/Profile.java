package Profiles;

public class Profile {
   public Skill skill;
   public String phone;
   public String resume;
   public short freelance_status;

    public Profile(ProgLanguages[] pL){
        String[] phoneVacab = {"380637650111", "380637657935", "380637658181", "380637658607", "380637658671", "380637658765", "380637658811", "380637651908", "380637651955", "380637656130", "380637659933", "380637659988", "380637652233", "380637656668", "380637657650", "380637654048", "380637654326", "380637658743", "380637654977", "380637651989", "380637652424", "380637656677"};
        phone = phoneVacab[(int)(Math.random() * (phoneVacab.length-1) + 1)];
        resume = "Какое нибудь резюме";
        addSkills(3, pL);
        freelance_status = 1;
    }

    public void addSkills(int how_many, ProgLanguages[] pL){
        skill = new Skill(pL);
    }


}
