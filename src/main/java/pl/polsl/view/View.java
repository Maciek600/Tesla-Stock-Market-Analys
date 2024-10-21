/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.view;
import java.util.Scanner;
import pl.polsl.model.*;
/**
 * @version 1.0
 * @author Maciej Fajlhauer
 */
public class View {
    private final Scanner scanner;

    public View(Model model) {
        this.scanner = new Scanner(System.in);
    }

    // Pobranie danych od użytkownika i przekazanie ich do kontrolera
    public int getInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextInt();
    }
    
    
    public float getInputA(String prompt) {
        System.out.println(prompt);
        return scanner.nextFloat();
    }
    
    public int getInputChoice(String prompt1){
        System.out.println(prompt1);
        return scanner.nextInt();
    }

    // Wyświetlenie wyniku z modelu
    public void displayResult(int result) {
        System.out.println("The result of the addition is: " + result);
    }
    
    public void displayResult(float result) {
        System.out.println("The result of the addition is: " + result);
    }

}
