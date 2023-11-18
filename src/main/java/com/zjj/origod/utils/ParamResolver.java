package com.zjj.origod.utils;

import java.util.Map;
public class ParamResolver {
//    mp为接收的请求参数集合,keys为目标字段
    public static void resolve(Map<String,Object>mp,String[] keys) throws Exception{
        for(int i=0;i<keys.length;i++){
            if(!mp.containsKey(keys[i])){
                throw new Exception("传参错误");
            }
        }
    }
}
