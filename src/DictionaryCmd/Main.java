/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DictionaryCmd;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Hung Vi Manh
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        DictionaryCommandLine dict = new DictionaryCommandLine();
        Scanner s = new Scanner(System.in);
        System.out.println("Lựa chọn phiên bản!!!");
        System.out.println("1. Cơ bản");
        System.out.println("2. Nâng cao");
        System.out.println("3. Hoàn thiện");

        try {
            int choose = s.nextInt();
            switch (choose) {
                case 1: {
                    //Version 1.0
                    dict.dictionaryBasic();
                    break;
                }
                case 2: {
                    //Version 2.0
                    dict.dictionaryAdvanced();
                    break;
                }
                case 3: {
                    dict.dictionaryStable();
                    break;
                }
                default:{
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println(e);
        }

    }
}
