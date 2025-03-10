package tdd.mar.bank;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private AccountService accountService = null;
    private ByteArrayOutputStream byteArrayOutputStreamOfTestOut = null;
    private final PrintStream productionOut = System.out;

    @BeforeEach
    public void setUp() {
        LocalDate accountCreationDate = LocalDate.of(2012, 1, 10);
        accountService = new Account(accountCreationDate);

        byteArrayOutputStreamOfTestOut = new ByteArrayOutputStream();
        PrintStream testOut = new PrintStream(byteArrayOutputStreamOfTestOut);
        System.setOut(testOut);
    }

    @AfterEach
    public void cleanUp() {
        System.setOut(productionOut);
    }

    @Test
    public void printEmptyStatement() {
        accountService.printStatement();

        String expectedStatement = "Date||Amount||Balance";
        String actualStatement = byteArrayOutputStreamOfTestOut.toString();
        assertEquals(expectedStatement, actualStatement);
    }

    @Test
    public void printStatementAfterMakingDeposit() {
        accountService.deposit(1000);
        accountService.printStatement();

        String expectedStatement = "Date||Amount||Balance\n10/01/2012||1000||1000";
        String actualStatement = byteArrayOutputStreamOfTestOut.toString();
        assertEquals(expectedStatement, actualStatement);
    }

    @Test
    public void printStatementAfterMakingTwoDeposits() {
        accountService.deposit(1000);
        accountService.deposit(2000);
        accountService.printStatement();

        String expectedStatement = "Date||Amount||Balance\n10/01/2012||1000||1000\n10/01/2012||2000||3000";
        String actualStatement = byteArrayOutputStreamOfTestOut.toString();
        assertEquals(expectedStatement, actualStatement);
    }
}