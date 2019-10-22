package zadanie3;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HealthProfile hf = new HealthProfile();
        System.out.println("Imie:");
        hf.setImie(scanner.nextLine());
        System.out.println("Nazwisko:");
        hf.setNazwisko(scanner.nextLine());
        askDate(hf,scanner);
        askMasa(hf,scanner);
        askWzrost(hf,scanner);
        askPlec(hf,scanner);
        scanner.close();
        System.out.println(hf);
    }


    private static void askDate(HealthProfile hf, Scanner scanner) {
        System.out.println("Data urodzenia(YYYY-MM-DD):");
        String data = scanner.nextLine();
        try {
            hf.setDataUrodzenia(LocalDate.parse(data));
        } catch (DateTimeParseException e) {
            System.out.println("Niepoprawna wartość");
            askDate(hf,scanner);
        }
    }
    private static void askWzrost(HealthProfile hf, Scanner scanner) {
        System.out.println("Wzrost w cm:");
        String wzrost = scanner.nextLine();
        try {
            hf.setWzrost(Double.parseDouble(wzrost));
        } catch (NumberFormatException e) {
            System.out.println("Niepoprawna wartość");
            askWzrost(hf,scanner);
        }
    }
    private static void askMasa(HealthProfile hf, Scanner scanner) {
        System.out.println("Masa w kg:");
        String masa = scanner.nextLine();
        try {
            hf.setMasa(Double.parseDouble(masa));
        } catch (NumberFormatException e) {
            System.out.println("Niepoprawna wartość");
            askMasa(hf,scanner);
        }
    }
    private static void askPlec(HealthProfile hf, Scanner scanner) {
        System.out.println("Płeć (K/M):");
        String plec=scanner.nextLine().toUpperCase();
        try {
            HealthProfile.Plec p = HealthProfile.Plec.valueOf(plec);
            hf.setPlec(p);        }
        catch (IllegalArgumentException e) {
            System.out.println("Niepoprawna wartość");
            askPlec(hf,scanner);
        }
    }



}
