package empCRUD;

import java.util.Scanner;

public class Utilities {
    public static String getInput(String prompt){
        System.out.println(prompt);
        return new Scanner(System.in).next();
    }
}