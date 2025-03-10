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
    private final static Calender CALENDER = Calender.getInstance();

    @BeforeEach
    public void setUp() {
        CALENDER.setCurrentDate(LocalDate.of(2012, 1, 10));
        accountService = new Account();

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

        String expectedStatement = "Date||Amount||Balance\n10/01/2012||2000||3000\n10/01/2012||1000||1000";
        String actualStatement = byteArrayOutputStreamOfTestOut.toString();
        assertEquals(expectedStatement, actualStatement);
    }

    @Test
    public void printStatementAfterMakingDepositsOnTwoDifferentDays() {
        accountService.deposit(1000);
        CALENDER.setCurrentDate(LocalDate.of(2012, 1, 11));
        accountService.deposit(2000);
        accountService.printStatement();

        String expectedStatement = "Date||Amount||Balance\n11/01/2012||2000||3000\n10/01/2012||1000||1000";
        String actualStatement = byteArrayOutputStreamOfTestOut.toString();
        assertEquals(expectedStatement, actualStatement);
    }

    @Test
    public void printStatementAfterMakingWithdrawal() {
        accountService.withdraw(500);
        accountService.printStatement();

        String expectedStatement = "Date||Amount||Balance\n10/01/2012||-500||-500";
        String actualStatement = byteArrayOutputStreamOfTestOut.toString();
        assertEquals(expectedStatement, actualStatement);
    }

    @Test
    public void passAcceptanceTest() {
        CALENDER.setCurrentDate(LocalDate.of(2012, 1, 10));
        accountService.deposit(1000);
        CALENDER.setCurrentDate(LocalDate.of(2012, 1, 13));
        accountService.deposit(2000);
        CALENDER.setCurrentDate(LocalDate.of(2012, 1, 14));
        accountService.withdraw(500);
        accountService.printStatement();

        String expectedStatement = "Date||Amount||Balance\n14/01/2012||-500||2500\n13/01/2012||2000||3000\n10/01/2012||1000||1000";
        String actualStatement = byteArrayOutputStreamOfTestOut.toString();
        assertEquals(expectedStatement, actualStatement);
    }
}