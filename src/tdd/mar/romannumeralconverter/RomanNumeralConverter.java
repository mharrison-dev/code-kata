package tdd.mar.romannumeralconverter;

public class RomanNumeralConverter {
    public String convertToRomanNumeral(int number) {
        StringBuilder romanNumeralBuilder = new StringBuilder();
        for (int i = 0; i < number; i++) {
            romanNumeralBuilder.append("I");
            int indexOfMalformedNumeral = romanNumeralBuilder.indexOf("IIII");
            if (indexOfMalformedNumeral > -1) {
                romanNumeralBuilder.delete(indexOfMalformedNumeral, romanNumeralBuilder.length());
                romanNumeralBuilder.append("IV");
            }
        }

        return romanNumeralBuilder.toString();
    }
}
