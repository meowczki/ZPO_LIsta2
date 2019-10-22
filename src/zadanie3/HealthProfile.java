package zadanie3;

import java.time.LocalDate;
import java.util.InputMismatchException;

/**
 * Klasa HealthProfile program reprezentue profil Osoby
 * @author  Ola Skowronska
 * @version 1.0
 */
public class HealthProfile {

    private String imie;
    private double wzrost;
    private double masa;
    private String nazwisko;
    private LocalDate dataUrodzenia;
    private Plec plec;

    public HealthProfile(String imie, double wzrost, double masa, String nazwisko, LocalDate dataUrodzenia, Plec plec) {
        this.imie = imie;
        this.wzrost = wzrost;
        this.masa = masa;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.plec = plec;
    }

    public HealthProfile() {

    }
    /**
     * zwraca wiek na podstawie daty urodzenia
     * @return Wiek
     */
    public int getWiek() {
        return LocalDate.now().getYear() - dataUrodzenia.getYear();
    }

    /**
     * zwraca plec obiektu
     * @return plec obiektu klasy HealthProfile
     */
    public Plec getPlec() {
        return plec;
    }
    /**
     * ustawia plec obiektu
     * @param plec obiektu klasy HealthProfile
     * @see Plec
     */
    public void setPlec(Plec plec) {
        this.plec = plec;
    }

    /**
     * zwraca imie obiektu
     * @return Imie obiektu klasy HealthProfile
     */
    public String getImie() {
        return imie;
    }
    /**
     * ustawia imie obiektu
     * @param imie obiektu klasy HealthProfile
     */
    public void setImie(String imie) {
        this.imie = imie;
    }
    /**
     * zwraca nazwisko obiektu
     * @return nazwisko obiektu HelathProfile
     */
    public String getNazwisko() {
        return nazwisko;
    }
    /**
     * ustawia nazwisko obiektu
     * @param nazwisko obiektu HelathProfile
     */
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    /**
     * zwraca date urodzenia obiektu HelathProfile
     * @return data urodzenia obiektu HelathProfile
     */
    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }
    /**
     * ustawia date urodzenia obiektu HelathProfile
     * @param dataUrodzenia obiektu HealthProfile
     */
    public void setDataUrodzenia(LocalDate dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }
    /**
     * zwraca wzrost obiektu obiektu HealthProfile
     * @return wzrost obiektu HealthProfile
     */
    public double getWzrost() {
        return wzrost;
    }
    /**
     * ustawia wzrost obiektu HealthProfile
     * @param wzrost obiektu HealthProfile
     */
    public void setWzrost(double wzrost) {
        this.wzrost = wzrost;
    }
    /**
     * zwraca mase obiektu HealthProfile
     * @return masa obiektu HealthProfile
     */
    public double getMasa() {

        return masa;
    }
    /** ustawia mase obiektu HealthProfile
     * @param masa obiektu HealthProfile
     */
    public void setMasa(double masa) {
    this.masa=masa;
    }
    /**
     * zwraca docelowe tetno na podstawie maksymalnego tetna
     * @return docelowe tetno
     */
    public int getDoceloweTetno() {
        return (int)(getMaksymalneTetno()*0.6);
    }
    /**
     * zwraca maksymalne tetno na podstawie wieku
     * @return maksymalne tetno
     */
    public int getMaksymalneTetno() {
        return 220-getWiek();
    }
    /**
     * zwraca maksymalne tetno na podstawie wieku
     * @return maksymalne tetno
     */
    public double getBMI() {
        return getMasa()/Math.pow((getWzrost()/100),2);
    }

    public enum Plec {
        K, M;
    }
    @Override
    public String toString(){
        return "Imię: "+getImie()+"\n"+"Nazwisko: "+getNazwisko()+"\n"+"Płeć: "+getPlec()+"\n"+"Data urodzenia: "+getDataUrodzenia()+"\n"+"Wzrost: "+getWzrost()+" cm"+"\n"+"Masa: "+getMasa()+" kg"+"\n"+"BMI: "+getBMI()+"\n"+"Maksymalne tętno: "+getMaksymalneTetno()+"\n"+"Docelowe tętno: "+getDoceloweTetno();
    }

}
