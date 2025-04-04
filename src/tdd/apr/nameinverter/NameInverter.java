package tdd.apr.nameinverter;

public class NameInverter {
    private static final String HONORIFICS_REGEX = "^(Mr|Mrs|Miss|Mx|Ind|Misc)[.]*\s";

    public String invert(String name) {
        String[] nameComponents = name
                .trim()
                .replaceAll("\s+", " ")
                .replaceAll(HONORIFICS_REGEX, "")
                .split(" ");

        return (nameComponents.length == 1) ?
                nameComponents[0]
                : nameComponents[1] + ", " + nameComponents[0];
    }
}