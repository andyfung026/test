package com.greencity.study.javastudy0517;

public class TestDog {
    public static void main(String[] args) {

        Dog spot = new Dog("spot","Ruff!");
        Dog scruffy = new Dog("scruff", "Wurf!");

        System.out.println(spot);

        System.out.println(scruffy);


        Dog dog = new Dog("spot", "Ruff!");
        //dog=spot;
        System.out.println(dog.equals(spot));
        System.out.println(dog == spot);
        System.out.println(dog.equals(scruffy));
        System.out.println(dog==scruffy);

    }
}
