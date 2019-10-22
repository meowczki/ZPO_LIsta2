package zadanie2;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        LocalDate date=LocalDate.of(2019,8,10);
        date = date.of(date.getYear(),date.getMonth(),1);
        Month miesiac = date.getMonth();
        int liczbaDni = miesiac.length(date.isLeapYear());
        int pierwszyDzienMiesiaca = date.getDayOfWeek().getValue()-1;
        System.out.printf("%1$s, %2$d\n",
                miesiac.toString(),date.getYear());
        for(DayOfWeek dzien : DayOfWeek.values()){
            System.out.printf("%s\t",dzien.name().substring(0, 3));
        }
        System.out.println();
        for(int i = 0; i < pierwszyDzienMiesiaca;++i){
            System.out.print("  \t");
        }
        for(int day = 1; day <= liczbaDni;++day){
            System.out.printf("%02d\t",day );
            if((day + pierwszyDzienMiesiaca)% 7 ==0){
                System.out.println();
            }
        }
        System.out.println();
    }

}
