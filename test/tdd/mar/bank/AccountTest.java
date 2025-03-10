package tdd.mar.bank;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    @Test
    public void printEmptyStatement() {
        PrintStream productionOut = System.out;
        ByteArrayOutputStream byteArrayOutputStreamOfTestOut = new ByteArrayOutputStream();
        PrintStream testOut = new PrintStream(byteArrayOutputStreamOfTestOut);
        System.setOut(testOut);

        LocalDate accountCreationDate = LocalDate.of(2012, 1, 10);
        AccountService accountService = new Account(accountCreationDate);
        accountService.printStatement();

        String expectedStatement = "Date||Amount||Balance";
        String actualStatement = byteArrayOutputStreamOfTestOut.toString();
        assertEquals(expectedStatement, actualStatement);

        System.setOut(productionOut);
    }

    @Test
    public void printStatementAfterMakingDeposit() {
        PrintStream productionOut = System.out;
        ByteArrayOutputStream byteArrayOutputStreamOfTestOut = new ByteArrayOutputStream();
        PrintStream testOut = new PrintStream(byteArrayOutputStreamOfTestOut);
        System.setOut(testOut);

        LocalDate accountCreationDate = LocalDate.of(2012, 1, 10);
        AccountService accountService = new Account(accountCreationDate);
        accountService.deposit(1000);
        accountService.printStatement();

        String expectedStatement = "Date||Amount||Balance\n10/01/2012||1000||1000";
        String actualStatement = byteArrayOutputStreamOfTestOut.toString();
        assertEquals(expectedStatement, actualStatement);

        System.setOut(productionOut);
    }
}