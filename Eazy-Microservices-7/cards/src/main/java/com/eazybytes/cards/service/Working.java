package com.eazybytes.cards.service;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Working {
//    public static void main(String[] args) {
//        char c = doWork("ngrhhqbhnsipkcoqjyviikvxbxyphsnjpdxkhtadltsuxbfbrkof");
////        char c = doWork("abacabaabacaba");
//        System.out.println("character " + c);
//    }
     static char doWork(String s){
         //get the lengths
         char outChar = '_';
         Map<String, Integer>  allDup = new HashMap<>();
         List<String> dubs = new ArrayList<>();
         for(char sub : s.toCharArray()){
             String tst = String.valueOf(sub);
             Integer old = allDup.get(tst);
             int len = old != null ? old.intValue() + 1 : 1;
             if(len >= 2){
                 dubs.remove(tst);
             }else{
                 dubs.add(tst);
                 allDup.put(tst, len);
             }
         }

         return dubs.size() > 0 ? dubs.getFirst().charAt(0) : outChar;
    }

    static char least(Map<String, Integer> allDup){
        //get the lengths
        char outChar = '_';
        for (Map.Entry<String, Integer> entry: allDup.entrySet()){

        }
        return outChar;
    }

}
