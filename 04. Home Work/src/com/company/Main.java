package com.company;

import Buildings.*;
import ObjectsEquals.*;
import Plants.*;


public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
	    // 1.equals, tostring, hashcode testing
        Human pers = new Human("Kolya", 35);
        Human same = pers;
        Human clonePers = (Human) pers.clone();
        Human pers2 = new Human("Egor", 46);
        Animal rabbit = new Animal("Rabbit name", 1);
        String printBorder = "====================================================================";
        // equals
        System.out.println(printBorder);
        System.out.println(pers.equals(same)); // if (this == o) return true;

        System.out.println(pers.equals(rabbit)); // instanceof

        System.out.println(pers.equals(pers2)); // last instruction;

        // hashcode
        System.out.println(printBorder);
        System.out.println(pers.hashCode());
        System.out.println(same.hashCode()); // the same
        System.out.println(clonePers.hashCode()); // clone the same
        System.out.println(pers2.hashCode()); // different

        // tostring
        System.out.println(printBorder);
        System.out.println(pers);
        System.out.println(pers2);

        // 3.Buildings
        System.out.println(printBorder);
        Cottedge cottedge = new Cottedge("Some cottedge", 2, "brick", 5, 120, true, true, 50, true);
        ApartmentHouse apHouse = new ApartmentHouse("Some Apartment House", 12, "concrete", 600, 5.481, true, true, 3);
        PrivateHouse pHouse = new PrivateHouse("Some Private House", 1, "wood", 4, 56, true, true, 30);

        System.out.println(cottedge);
        System.out.println(apHouse);
        System.out.println(pHouse);

        // 4.Plants
        System.out.println(printBorder);

        Flower chamomile = new Flower("Астровые", "Двудольные", "Ромашка", false, "Ромашка полевая", "Белый");
        ToxicFlower akonit = new ToxicFlower("Лютиковые", "Двудольные", "Борец", false, "Аконит", "blue", true, "Использовался для наконечников стрел");
        ToxicMedicalFlower barvinok = new ToxicMedicalFlower("Кутровые", "Двудольные", "Барвинок", false, "Барвинок большой", "Фиолетовый", true, "Используется для гадания", true, "Употребляется при диарее, кровотечении, чахотке, цинге, зубной боли");

        Bush barberry = new Bush("Барбарисовые", "Двудольные", "Барбарис", true, "Барбарис обыкновенный");
        PoisonBush snowberry = new PoisonBush("Жимолостные", "Двудольные", "Снежноягодник", false, "Снежноягодник округлый", false, true, true);

        Tree poplar = new Tree("Ивовые", "Двудольные", "Тополь", true, "Тополь Канадский", 60, "Черешковые");
        FruitTree AppleTree = new FruitTree("Розовые", "Двудольные", "Яблоня", true, "Китайка", 12, "Продолговатые", true, "Яблоко");

        System.out.println(chamomile);
        System.out.println(akonit);
        System.out.println(barvinok);

        System.out.println(barberry);
        System.out.println(snowberry);

        System.out.println(poplar);
        System.out.println(AppleTree);

    }
}
