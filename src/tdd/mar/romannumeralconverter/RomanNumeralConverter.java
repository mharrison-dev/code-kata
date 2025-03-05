package tdd.mar.romannumeralconverter;

public class RomanNumeralConverter {
    public String convertToRomanNumeral(int number) {
        StringBuilder romanNumeralBuilder = new StringBuilder();
        for (int i = 0; i < number; i++) {
            romanNumeralBuilder.append("I");
        }

        return romanNumeralBuilder.toString();
    }
}
