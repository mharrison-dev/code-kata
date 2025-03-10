package tdd.mar.bank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Account implements AccountService {
    private final List<Transaction> transactions = new ArrayList<>();
    private int balance = 0;
    private static final Calender CALENDER = Calender.getInstance();

    @Override
    public void deposit(int amount) {
        balance += amount;
        transactions.add(new Transaction(CALENDER.getCurrentDate(), amount, balance));
    }

    @Override
    public void withdraw(int amount) {
        balance -= amount;
        transactions.add(new Transaction(CALENDER.getCurrentDate(), -amount, balance));
    }

    @Override
    public void printStatement() {
        String header = "Date||Amount||Balance";
        System.out.print(header);

        for (Transaction transaction : transactions.reversed()) {
            String entry = getEntryFor(transaction);
            System.out.print("\n" + entry);
        }
    }

    private String getEntryFor(Transaction transaction) {
        String[] entryComponents = new String[3];
        entryComponents[0] = formatDate(transaction.date.toString());
        entryComponents[1] = String.valueOf(transaction.amount);
        entryComponents[2] = String.valueOf(transaction.balance);

        return String.join("||", entryComponents);
    }

    private String formatDate(String date) {
        // Swap the position of the day and year
        String[] dateComponents = date.split("-");
        String year = dateComponents[0];
        dateComponents[0] = dateComponents[2];
        dateComponents[2] = year;

        // Replace each "-" with a "/"
        return String.join("/", dateComponents);
    }

    private record Transaction(LocalDate date, int amount, int balance) {
    }
}
