package tdd.mar.bank;

import java.time.LocalDate;

public class Calender {
    private LocalDate currentDate = null;
    private static Calender instance;

    private Calender() {
    }

    public static Calender getInstance() {
        if (instance == null) {
            instance = new Calender();
        }

        return instance;
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }
}
