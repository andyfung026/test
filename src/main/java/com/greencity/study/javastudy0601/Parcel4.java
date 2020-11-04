package com.greencity.study.javastudy0601;

class Parcel4{
private class PContents implements Contents {
    private int i = 11;

    @Override
    public int value() {
        return i;
    }

}
    protected class PDestination implements Destination {
        private String lable;

        private PDestination(String whereTo) {
            lable = whereTo;
        }

        @Override
        public String readLable() {
            return lable;
        }
    }

    public Destination destination(String s) {
        return new PDestination(s);
    }

    public Contents contents() {
        return new PContents();
    }
    }



