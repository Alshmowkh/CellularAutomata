/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cellularautomata.Azaani;

import cellularautomata.models.D1;

/**
 *
 * @author bakee
 */
public class MyTester {

    void randomByte() {
        for (int i = 0; i < 27; i++) {
            p(Math.round(Math.random()));
        }
//               pl(Math.random());
        pl("");
    }

    String getBinary(int rule) {
        String bin = Integer.toBinaryString(rule);
        pl(bin);
        return bin;
    }

    void D1() {
        D1 d1 = new D1(8, 150, true, false);
        d1.iterations(2);
//        boolean[] rule=d1.generateRule(150);
//        for(int i=0;i<rule.length;i++){
//            if(rule[i]) p("1");
//            else p("0");
//        }
        pl("");
    }

    void initialize() {
        boolean next, actual, prev;
        boolean[] space = new boolean[]{true, false, false, false, true, false, false, true};
        prev = space[(((0 - 1) % space.length) + space.length) % space.length];
        int op = ((7 % 8) + 8) % 8;
        pl(op);
        pl(space[op]);
        for (int i = 0; i < space.length; i++) {
            prev = space[(((i - 1) % space.length) + space.length) % space.length];
            actual = space[i];
            next = space[(((i + 1) % space.length) + space.length) % space.length];
        }
    }

    void frame1() {
        Frame1 d3 = new Frame1();
        d3.Run();
    }

    void udating() {
        space = new boolean[]{true, false, false, false, true, false, false, true};
//        rule=new 
        nextStep();
    }
    boolean[] space;
    boolean[] rule;

    private synchronized void nextStep() {
        boolean next, actual, prev;
        boolean[] spaceTemp = space;
        for (int i = 0; i < space.length; i++) {

            prev = space[(((i - 1) % space.length) + space.length) % space.length];
            actual = space[i];
            next = space[(((i + 1) % space.length) + space.length) % space.length];

            if (prev && actual && next) {
                spaceTemp[i] = rule[0];
            } else if (prev && actual && !next) {
                spaceTemp[i] = rule[1];
            } else if (prev && !actual && next) {
                spaceTemp[i] = rule[2];
            } else if (prev && !actual && !next) {
                spaceTemp[i] = rule[3];
            } else if (!prev && actual && next) {
                spaceTemp[i] = rule[4];
            } else if (!prev && actual && !next) {
                spaceTemp[i] = rule[5];
            } else if (!prev && !actual && next) {
                spaceTemp[i] = rule[6];
            } else if (!prev && !actual && !next) {
                spaceTemp[i] = rule[7];
            }
        }

        System.arraycopy(spaceTemp, 0, space, 0, space.length);
    }

    public static void main(String[] args) {
        MyTester test = new MyTester();
//        test.frame1();
        test.initialize();
//        test.getBinary(150);
//        test.randomByte();
//        test.D1();

    }

    public static void pl(Object o) {
        System.out.println(o);
    }

    public static void p(Object o) {
        System.out.print(o);
    }
}
