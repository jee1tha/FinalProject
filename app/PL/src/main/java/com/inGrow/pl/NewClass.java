/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inGrow.pl;

import static com.sun.org.apache.regexp.internal.RETest.test;

/**
 *
 * @author VABAYJE
 */
public class NewClass {
        public static void main(String[] args){
        
    Test_Service test = new Test_Service();
    Test proxy = test.getTestPort();
    String response = proxy.hello2("jee1");
    System.out.println(response);
 
  
   

    }
}
