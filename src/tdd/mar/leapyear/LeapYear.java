package tdd.mar.leapyear;

public class LeapYear {
    public boolean validate(int year) {
        if (year % 100 == 0 && year % 400 != 0) {
            return false;
        }

        return year % 4 == 0;
    }
}