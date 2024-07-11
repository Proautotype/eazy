package com.eazybytes.cards.service;

import org.springframework.util.Assert;

import java.util.*;

public class Working {
    char boom = '1';
//    public static void main(String[] args) {
//        char c = doWork("ngrhhqbhnsipkcoqjyviikvxbxyphsnjpdxkhtadltsuxbfbrkof");
////        char c = doWork("abacabaabacaba");
//        System.out.println("character " + c);
//    }
     static char doWork(String s){
         //get the lengths
         char outChar = '_';
         String name = "";
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

     char least(Map<String, Integer> allDup){
        //get the lengths
        char outChar = '_';
        Wash<ArrayList<String>> listWash = new Wash<>();
         var days = new String[] { "Sunday", "Monday", "Tuesday",
                 "Wednesday", "Thursday", "Friday", "Saturday" };
         for (int i = 1; i <= days.length; i++)
             System.out.println(days[i]);

         return outChar;
    }


    static class Wash<T extends Collection>{
         T item;
         public void clean(T item){
             System.out.println("Cleaned " + item.isEmpty() + " items.");
         }
    }

}
