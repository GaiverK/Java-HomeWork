package com.company;

public class Main {

    public static void main(String[] args) {
        IHumanLifecycleObserver observer = new IHumanLifeCycleObserverLogger();
	    HumanLifecycle humanLifecycle = new HumanLifecycle(observer);

	    humanLifecycle.startLife();

    }

	    private static class IHumanLifeCycleObserverLogger implements IHumanLifecycleObserver{

            @Override
            public void onChildWasBorn(BornParams bParams) {
                System.out.printf("Child with name %s born at %-5s with weight %.2f kilograms and gender is %s\n",
                        bParams.name,
                        bParams.date,
                        bParams.weight,
                        bParams.gender
                );
            }

            @Override
            public void onGoesToKindergarten(KinderGartenParams kinderGartenParams) {
                System.out.printf("In %s year, child goes to kindergarten №%d, group %1s\n",
                        kinderGartenParams.date,
                        kinderGartenParams.kindergartenNum,
                        kinderGartenParams.groupName
                );
            }

            @Override
            public void onGoesToSchool(SchoolParams schoolParams) {
                System.out.printf("In %s year, child goes to school №%d, class \"%1s\" with %s bias\n",
                        schoolParams.date,
                        schoolParams.schoolNum,
                        schoolParams.className,
                        schoolParams.bias
                );
            }

            @Override
            public void onGoesToUniversity(UniversityParams universityParams, BornParams bornParams) {
                System.out.printf("In %s year, teenager %s goes to University \"%s\", faculty \"%s\", group \"%s\"\n",
                        universityParams.date,
                        bornParams.name,
                        universityParams.university,
                        universityParams.faculty,
                        universityParams.group
                );
            }

            @Override
            public void onGoesToWork(WorkParams workParams, BornParams bornParams) {
                System.out.printf("In %s year, bachelor %s find job in \"%s\" for the post %s with salary %d UAH\n",
                        workParams.date,
                        bornParams.name,
                        workParams.company,
                        workParams.profession,
                        workParams.salary
                );
            }

            @Override
            public void onCreateFamily(FamilyParams familyParams, BornParams bornParams) {
                System.out.printf("In %s year, %s with %s decided to start a family\n",
                        familyParams.date,
                        bornParams.name,
                        familyParams.wife
                );
            }

            @Override
            public void onHaveKids(HaveKidsParams haveKidsParams, FamilyParams familyParams, BornParams bornParams) {
                System.out.printf("In %s year, %s and %s have kid with name %s, weight %s kilograms and gender %s. %s was stumped because child looks like %s\n",
                        haveKidsParams.date,
                        bornParams.name,
                        familyParams.wife,
                        haveKidsParams.childName,
                        haveKidsParams.childWeight,
                        haveKidsParams.childGender,
                        bornParams.name,
                        haveKidsParams.looksLike
                );
            }

            @Override
            public void onRetired(RetiredParams retiredParams, BornParams bornParams) {
                System.out.printf("In %s year, %s is retired and have a minimal pension %s UAH",
                        retiredParams.date,
                        bornParams.name,
                        retiredParams.pension
                );
                if( retiredParams.haveBenefits ) System.out.print(", but have some benefits\n");
                else System.out.print(" and hasn't any benefits\n");
            }

            @Override
            public void onHumanDied(DeathParams deathParams, BornParams bornParams) {
                System.out.printf("In %s year, %s is die because %s. Before human died he is just say - \"%s\". Human is buried in cemetry №%d.",
                        deathParams.date,
                        bornParams.name,
                        deathParams.reason,
                        deathParams.lastWords,
                        deathParams.cemetryNum
                );
            }
        }
}
