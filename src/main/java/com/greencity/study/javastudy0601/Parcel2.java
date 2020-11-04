package com.greencity.study.javastudy0601;

public class Parcel2 {
    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }
    class Destination{
        private String lable;

        Destination(String whereTo) {
            lable = whereTo;
        }

        String readLable() {
            return lable;
        }
    }

    public Destination to(String s) {
        return new Destination(s);
    }

    public Contents contents() {
        return new Contents();
    }

    public void ship(String dest) {
        Contents c = contents();
        Destination to = to(dest);
        System.out.println(to.readLable());
    }

    public static void main(String[] args) {
        Parcel2 parcel2 = new Parcel2();
        parcel2.ship("Tasmania");
        Parcel2 parcel21 = new Parcel2();
        Parcel2.Contents contents = parcel21.contents();
        Parcel2.Destination destination = parcel21.to("Borneo");
    }
}
