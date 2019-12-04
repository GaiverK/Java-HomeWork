package com.company;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HumanLifecycle {
    private final IHumanLifecycleObserver observer;

    public HumanLifecycle(IHumanLifecycleObserver observer) {
        this.observer = observer;
    }

    public void startLife(){
        // Initialize and format date of birth
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        String dateFormat = formatForDateNow.format(dateNow);

        // Child was born
        IHumanLifecycleObserver.BornParams bornParams = new IHumanLifecycleObserver.BornParams("Vasya", dateFormat, 4.12f, "male");
        observer.onChildWasBorn(bornParams);

        // get 2 years after
        dateFormat = this.getYearWhenHumanAgeIs(2);

        // Child goes to kindergarten
        IHumanLifecycleObserver.KinderGartenParams kinderGartenParams = new IHumanLifecycleObserver.KinderGartenParams(dateFormat, 106, "B");
        observer.onGoesToKindergarten(kinderGartenParams);

        dateFormat = this.getYearWhenHumanAgeIs(6);

        // Child goes to school
        IHumanLifecycleObserver.SchoolParams schoolParams = new IHumanLifecycleObserver.SchoolParams(dateFormat, 152, 'A', "English");
        observer.onGoesToSchool(schoolParams);

        dateFormat = this.getYearWhenHumanAgeIs(17);

        // Teenager goes to University
        IHumanLifecycleObserver.UniversityParams universityParams = new IHumanLifecycleObserver.UniversityParams(dateFormat, "Karazina", "Law", "L24");
        observer.onGoesToUniversity(universityParams, bornParams);

        dateFormat = this.getYearWhenHumanAgeIs(25);

        // Student goes to work
        IHumanLifecycleObserver.WorkParams workParams = new IHumanLifecycleObserver.WorkParams(dateFormat, "MacDonalds", "janitor",3500);
        observer.onGoesToWork(workParams, bornParams);

        dateFormat = this.getYearWhenHumanAgeIs(27);

        // Human create Family
        IHumanLifecycleObserver.FamilyParams familyParams = new IHumanLifecycleObserver.FamilyParams(dateFormat, "Anna Petrova");
        observer.onCreateFamily(familyParams, bornParams);

        dateFormat = this.getYearWhenHumanAgeIs(35);

        // Human have kids
        IHumanLifecycleObserver.HaveKidsParams haveKidsParams = new IHumanLifecycleObserver.HaveKidsParams(dateFormat, "Petya", "male", 5.23f,"neighbour");
        observer.onHaveKids(haveKidsParams, familyParams, bornParams);

        dateFormat = this.getYearWhenHumanAgeIs(65);

        // Human retired
        IHumanLifecycleObserver.RetiredParams retiredParams = new IHumanLifecycleObserver.RetiredParams(dateFormat, 1300, true);
        observer.onRetired(retiredParams, bornParams);

        dateFormat = this.getYearWhenHumanAgeIs(67);

        // Human die
        IHumanLifecycleObserver.DeathParams deathParams = new IHumanLifecycleObserver.DeathParams(dateFormat, "drink a lot of alcohol", 111, "Why I am not learned JAVA?");
        observer.onHumanDied(deathParams, bornParams);
    }


    private String getYearWhenHumanAgeIs(int humanYears){
        Date dateNow = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dateNow);
        c.add(Calendar.YEAR, humanYears);
        Date newDate = c.getTime();
        SimpleDateFormat formatForDateNow  = new SimpleDateFormat("yyyy");
        String dateFormat = formatForDateNow.format(newDate);
        return dateFormat;
    }

}
