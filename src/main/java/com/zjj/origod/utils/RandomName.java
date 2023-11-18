package com.zjj.origod.utils;

import java.sql.Time;
import java.util.Random;

public class RandomName {
    public static char nextChar(int seed){
        Random random = new Random(System.currentTimeMillis()+seed);
        int number = Math.abs(random.nextInt()%25);
        return (char)('a'+number);
    }
    public static String MakeName(){
        StringBuffer s = new StringBuffer();
        for(int i=0;i<10;i++){
            s.append(nextChar(i));
        }
        return "User-"+s.toString();
    }
}
