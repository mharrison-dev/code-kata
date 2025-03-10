package tdd.mar.bank;

import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    @Test
    public void printEmptyStatement() {
        PrintStream productionOut = System.out;
        ByteArrayOutputStream byteArrayOutputStreamOfTestOut = new ByteArrayOutputStream();
        PrintStream testOut = new PrintStream(byteArrayOutputStreamOfTestOut);
        System.setOut(testOut);

        AccountService accountService = new Account();
        accountService.printStatement();

        String expectedStatement = "Date||Amount||Balance";
        String actualStatement = byteArrayOutputStreamOfTestOut.toString();
        assertEquals(expectedStatement, actualStatement);

        System.setOut(productionOut);
    }
}