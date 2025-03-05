package tdd.mar.romannumeralconverter;

public class RomanNumeralConverter {
    public String convertToRomanNumeral(int number) {
        StringBuilder romanNumeralBuilder = new StringBuilder();
        int difference = number;
        while (difference > 0) {
            if (difference == 5) {
                difference -= 5;
                romanNumeralBuilder.append("V");
            }

            if (difference >= 1) {
                difference--;
                romanNumeralBuilder.append("I");
                int indexOfMalformedNumeral = romanNumeralBuilder.indexOf("IIII");
                if (indexOfMalformedNumeral > -1) {
                    romanNumeralBuilder.delete(indexOfMalformedNumeral, romanNumeralBuilder.length());
                    romanNumeralBuilder.append("IV");
                }
            }
        }

        return romanNumeralBuilder.toString();
    }
}
