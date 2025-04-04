package tdd.apr.nameinverter;

public class NameInverter {
    private static final String HONORIFICS_REGEX = "^(Mr|Mrs|Miss|Mx|Ind|Misc)[.]*\\s";

    public String invert(String name) {
        String[] nameComponents = name
                .trim()
                .replaceAll("\\s+", " ")
                .replaceAll(HONORIFICS_REGEX, "")
                .split(" ");

        if (nameComponents.length == 1) {
            return nameComponents[0];
        } else if (nameComponents.length == 2) {
            return nameComponents[1] + ", " + nameComponents[0];
        } else {
            return nameComponents[1] + ", " + nameComponents[0] + " " + nameComponents[2];
        }
    }
}