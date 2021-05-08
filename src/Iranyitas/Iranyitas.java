package Iranyitas;

import java.util.Scanner;
import java.util.Set;

public class Iranyitas {
    private Scanner scanner;

    public Iranyitas(){
        scanner = new Scanner(System.in);
    }

    public String valaszt(Set<String> keys){
        keys.remove("");
        String input = scanner.next();
        boolean valos = false;
        if(keys.contains(input)){
            valos = true;
            return input;
        }
        while(!valos){
            System.err.println("Hibás menüpont! A kiválasztáshoz írja be a szögletes zárójelek közötti részt!");
            input = scanner.next();
            if(keys.contains(input)){
                valos = true;
            }
        }
        return input;
    }
}
