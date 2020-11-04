package com.greencity.study.javastudy0517;


import java.util.Random;

class Letter{
    char c;

    @Override
    public String toString() {
        return "Letter{" +
                "c=" + c +
                '}';
    }
}


public class OperatorStudy {
    public static void main(String[] args) {
        //print("Hello World");
        //print(new Date());
        int x = 1, y = 2, z = 3;
        int a = x + y - 2 / 2 + z;
        int b = y - x + 2 * 3 - z;
        System.out.println("a =" + a + "b =" + b);


        Tank tank1 = new Tank();
        Tank tank2 = new Tank();

        tank1.level = 12;
        tank2.level = 34;

        System.out.println("tank1: " + tank1 + ", tank2: " + tank2);

        //tank1 = tank2;
        tank1.level = tank2.level;
        System.out.println("tank1: " + tank1 + ", tank2: " + tank2);

        tank1.level = 999;
        //tank1  和  tank2   指的是同一个对象  ，tank1  和  tank2  包含了相同的引用；
        System.out.println("tank1: " + tank1 + ", tank2: " + tank2);


        //创建 letter 对象
        Letter letter = new Letter();
        letter.c = 'a';

        System.out.println("1: letter.c: " + letter.c);
        //传入的参数是a   别名引起的问题，应该知道他的存在  实际改变的是f()之外的对象
        f(letter);
        System.out.println("2: letter.c: " + letter.c);


        Random random = new Random(47);

        int j, k, l;

        //生成随机数字  并且设置了上限   而其下限为0   这个下限不是我们想要的，因为会产生除0的可能性，所以进行了+1的操作
        j = random.nextInt(100)+1;

        System.out.println(j);


        int q = 1;

        //1
        System.out.println("q :" + q);
        //2
        System.out.println("++q :" + ++q);
        //2
        System.out.println("q++ :" + q++);
        //3
        System.out.println("q :" + q);
        //2
        System.out.println("--q :" + --q);
        //2
        System.out.println("q-- :" + q--);
        //1
        System.out.println("q :" + q);

    }


    static class Tank {
        int level;

        @Override
        public String toString() {
            return "Tank{" +
                    "level=" + level +
                    '}';
        }
    }


    static void f(Letter y) {

        System.out.println("y : = "+y );
        y.c = 'z';


    }
}

