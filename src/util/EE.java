/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Gabriel
 */
public class EE {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if(i == 9 && j == 9){
                    System.out.print("30 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println("");
            //eai
        }
    }

}
