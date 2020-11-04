package com.greencity.study.javastudy0601;

public class TestParcel {
    public static void main(String[] args) {
        Parcel4 parcel4 = new Parcel4();
        Contents contents = parcel4.contents();
        Destination tasmania = parcel4.destination("Tasmania");
        
    }
}
