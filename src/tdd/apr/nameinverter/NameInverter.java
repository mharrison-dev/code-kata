package tdd.apr.nameinverter;

import java.util.stream.IntStream;

public class NameInverter {
    private static final int FORENAME = 0;
    private static final int SURNAME = 1;
    private static final int FIRST_POSTNOMINAL = 2;

    private static final String SPACE = " ";
    private static final String EMPTY_SPACE = "";
    private static final String NAME_DELIMITER = ", ";

    private static final String EXCESSIVE_WHITESPACE = "\\s+";
    private static final String HONORIFICS = "^(Mr|Mrs|Miss|Mx|Ind|Misc)[.]*\\s";

    public String invert(String name) {
        String[] nameComponents = getNameComponents(name);
        return buildInvertedName(nameComponents);
    }

    private static String[] getNameComponents(String name) {
        return name
                .trim()
                .replaceAll(EXCESSIVE_WHITESPACE, SPACE)
                .replaceAll(HONORIFICS, EMPTY_SPACE)
                .split(SPACE);
    }

    private static String buildInvertedName(String[] nameComponents) {
        if (isMissingForenameOrSurname(nameComponents)) {
            return nameComponents[0];
        }

        if (isMissingForenameOrSurnameAndHasPostnominal(nameComponents)) {
            return String.join(SPACE, nameComponents);
        }

        StringBuilder invertedNameBuilder = new StringBuilder();
        invertedNameBuilder
                .append(nameComponents[SURNAME])
                .append(NAME_DELIMITER)
                .append(nameComponents[FORENAME]);

        IntStream.range(FIRST_POSTNOMINAL, nameComponents.length)
                .forEach(postnominal -> invertedNameBuilder
                        .append(SPACE)
                        .append(nameComponents[postnominal]));

        return invertedNameBuilder.toString();
    }

    private static boolean isMissingForenameOrSurname(String[] nameComponents) {
        return nameComponents.length == 1;
    }

    private static boolean isMissingForenameOrSurnameAndHasPostnominal(String[] nameComponents) {
        return nameComponents[0].contains(".") || nameComponents[1].contains(".");
    }
}