package com.zjj.origod.utils;

import java.sql.Time;
import java.util.Random;
import java.util.UUID;
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
    public static String MakeFileName(String fileName){
        int index=fileName.lastIndexOf(".");
        String houzhui=fileName.substring(index);//获取后缀名
        String uuidFileName=UUID.randomUUID().toString().replace("-","")+houzhui;
        return uuidFileName;
    }
}
