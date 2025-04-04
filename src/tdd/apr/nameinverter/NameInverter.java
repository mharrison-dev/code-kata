package tdd.apr.nameinverter;

public class NameInverter {
    private static final String HONORIFICS_REGEX = "^(Mr|Mrs|Miss|Mx|Ind|Misc)[.]*\\s";

    public String invert(String name) {
        String[] nameComponents = getNameComponents(name);
        return buildInvertedName(nameComponents);
    }

    private static String[] getNameComponents(String name) {
        return name
                .trim()
                .replaceAll("\\s+", " ")
                .replaceAll(HONORIFICS_REGEX, "")
                .split(" ");
    }

    private static String buildInvertedName(String[] nameComponents) {
        StringBuilder invertedNameBuilder = new StringBuilder();

        if (nameComponents.length == 1) {
            invertedNameBuilder.append(nameComponents[0]);
        } else {
            invertedNameBuilder
                    .append(nameComponents[1])
                    .append(", ")
                    .append(nameComponents[0]);

            for (int i = 2; i < nameComponents.length; i++) {
                invertedNameBuilder
                        .append(" ")
                        .append(nameComponents[i]);
            }
        }

        return invertedNameBuilder.toString();
    }
}