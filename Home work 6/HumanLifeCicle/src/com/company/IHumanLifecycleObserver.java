package com.company;

public interface IHumanLifecycleObserver {

    void onChildWasBorn(BornParams bParams);

    void onGoesToKindergarten(KinderGartenParams kinderGartenParams);

    void onGoesToSchool(SchoolParams schoolParams);

    void onGoesToUniversity(UniversityParams universityParams, BornParams bornParams);

    void onGoesToWork(WorkParams workParams, BornParams bornParams);

    void onCreateFamily(FamilyParams familyParams, BornParams bornParams);

    void onHaveKids(HaveKidsParams haveKidsParams, FamilyParams familyParams, BornParams bornParams);

    void onRetired(RetiredParams retiredParams, BornParams bornParams);

    void onHumanDied(DeathParams deathParams, BornParams bornParams);

    class BornParams{
        String name;
        String date;
        Float weight;
        String gender;

        /**
         * @param name Name of child string
         * @param date Formatted date string
         * @param weight Weight in kilograms float
         * @param gender Child gender string
         */
        public BornParams(String name, String date, Float weight, String gender) {
            this.name = name;
            this.date = date;
            this.weight = weight;
            this.gender = gender;
        }
    }

    class KinderGartenParams{
        String date;
        int kindergartenNum;
        String groupName;

        public KinderGartenParams(String date, int kindergartenNum, String groupName) {
            this.date = date;
            this.kindergartenNum = kindergartenNum;
            this.groupName = groupName;
        }
    }

    class SchoolParams{
        String date;
        int schoolNum;
        char className;
        String bias;

        public SchoolParams(String date, int schoolNum, char className, String bias) {
            this.date = date;
            this.schoolNum = schoolNum;
            this.className = className;
            this.bias = bias;
        }
    }

    class UniversityParams{
        String date;
        String university;
        String faculty;
        String group;

        public UniversityParams(String date, String university, String faculty, String group) {
            this.date = date;
            this.university = university;
            this.faculty = faculty;
            this.group = group;
        }
    }

    class WorkParams{
        String date;
        String company;
        String profession;
        int salary;

        public WorkParams(String date, String company, String profession, int salary) {
            this.date = date;
            this.company = company;
            this.profession = profession;
            this.salary = salary;
        }
    }

    class FamilyParams{
        String date;
        String wife;

        public FamilyParams(String date, String wife) {
            this.date = date;
            this.wife = wife;
        }
    }

    class RetiredParams{
        String date;
        int pension;
        boolean haveBenefits;

        public RetiredParams(String date, int pension, boolean haveBenefits) {
            this.date = date;
            this.pension = pension;
            this.haveBenefits = haveBenefits;
        }
    }

    class DeathParams{
        String date;
        String reason;
        int cemetryNum;
        String lastWords;

        public DeathParams(String date, String reason, int cemetryNum, String lastWords) {
            this.date = date;
            this.reason = reason;
            this.cemetryNum = cemetryNum;
            this.lastWords = lastWords;
        }
    }

    class HaveKidsParams{
        String date;
        String childName;
        String childGender;
        Float childWeight;
        String looksLike;

        public HaveKidsParams(String date, String childName, String childGender, Float childWeight, String looksLike) {
            this.date = date;
            this.childName = childName;
            this.childGender = childGender;
            this.childWeight = childWeight;
            this.looksLike = looksLike;
        }
    }
}
