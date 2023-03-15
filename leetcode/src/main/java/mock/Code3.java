package mock;

import java.time.LocalDate;

public class Code3 {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(1900, 1, 1);
        int count = 0;
        while (true) {
            localDate = localDate.plusDays(1);//+1天
            int year = localDate.getYear();
            int month = localDate.getMonthValue();
            int day = localDate.getDayOfMonth();
            int s1 = year % 10 + (year/10) % 10 + (year/100) % 10 + (year/1000) % 10;
            int s2 = month % 10 + (month/10) % 10 + day % 10 + (day/10) % 10;
            if (s1 == s2) {
                count++;
                System.out.println(year + " : " + month + " : " + day);
            }

            if (year == 9999 && month == 12 && day == 31) {
                break;
            }
        }
        System.out.println(count);
    }
}
