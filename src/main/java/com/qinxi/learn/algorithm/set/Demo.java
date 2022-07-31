package com.qinxi.learn.algorithm.set;

import java.util.TreeSet;

public class Demo {

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        //[10, 20], [15, 25], [20, 30]]
        System.out.println(myCalendar.book(10, 20));
        System.out.println(myCalendar.book(20, 30));
        System.out.println(myCalendar.book(15, 25));
        System.out.println(myCalendar.book(30, 40));
    }

}


class MyCalendar {

    private final TreeSet<int[]> bookedSet;

    public MyCalendar() {
        bookedSet = new TreeSet<>(((o1, o2) -> {
            if(o1[1] <= o2[0]) {
                return -1;
            } else if(o1[0] >= o2[1]) {
                return 1;
            } else {
                return 0;
            }
        }));
    }

    public boolean book(int start, int end) {
        return bookedSet.add(new int[]{start, end});
    }
}
