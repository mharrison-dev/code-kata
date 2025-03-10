package tdd.mar.bank;

import java.time.LocalDate;

public final class Account implements AccountService {
    private int amount = 0;
    private int balance = 0;
    private final LocalDate accountCreationDate;

    public Account(LocalDate accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    @Override
    public void deposit(int amount) {
        this.amount = amount;
        this.balance = amount;
    }

    @Override
    public void withdraw(int amount) {

    }

    @Override
    public void printStatement() {
        String header = "Date||Amount||Balance";
        System.out.print(header);

        if (amount > 0) {
            String entry = getEntry();
            System.out.print("\n" + entry);
        }
    }

    private String getEntry() {
        String[] entryComponents = new String[3];
        entryComponents[0] = formatDate(accountCreationDate.toString());
        entryComponents[1] = String.valueOf(amount);
        entryComponents[2] = String.valueOf(balance);

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
}
