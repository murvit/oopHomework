package lesson3;

import java.io.*;
import java.util.Scanner;

/**
 * Created by VMurashkin on 25.05.2015.
 */
public class DrawRectangle {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter X:");
        int x = scanner.nextInt();
        System.out.println("Enter Y:");
        int y = scanner.nextInt();

        for (int i=1; i<y+1; i++) {
            for (int j = 1; j < x+1; j++){
                if (i==1 || j==1 || i==y || j==x){
                    System.out.print("*");
                }
                else
                    System.out.print(" ");
            }
            System.out.println("\r");
        }
    }
}
