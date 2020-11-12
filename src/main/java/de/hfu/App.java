package de.hfu;
import java.util.Scanner;


public class App {
    public static void main( String[] args ){
		Scanner t = new Scanner(System.in);
		String eingabe;
		
        System.out.println("Geben Sie einen Text ein: ");		//Ausgabe
		eingabe = t.nextLine();									//Einlesen von String
		
		eingabe = eingabe.toUpperCase();						//String zu Grossbuchstaben
		System.out.println(eingabe);
    }
}
