package tdd.apr.nameinverter;

public class NameInverter {
    public String invert(String name) {
        String[] nameComponents = name
                .trim()
                .split(" ");

        return (nameComponents.length == 1) ?
                nameComponents[0]
                : nameComponents[1] + ", " + nameComponents[0];
    }
}