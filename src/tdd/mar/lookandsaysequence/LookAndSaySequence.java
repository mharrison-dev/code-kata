package tdd.mar.lookandsaysequence;

import java.util.ArrayList;
import java.util.List;

public class LookAndSaySequence {
    public String nextMember(String member) {
        return (member.isEmpty())
                ? ""
                : buildNextMember(member);
    }

    private String buildNextMember(String member) {
        StringBuilder nextMemberStringBuilder = new StringBuilder();

        String[] homogenousSubstrings = splitIntoHomogenousSubstrings(member);
        for (String homogenousSubstring : homogenousSubstrings) {
            nextMemberStringBuilder
                    .append(homogenousSubstring.length())
                    .append(homogenousSubstring.charAt(0));
        }

        return nextMemberStringBuilder.toString();
    }

    private String[] splitIntoHomogenousSubstrings(String member) {
        List<StringBuilder> homogenousSubstringBuilders = new ArrayList<>();

        StringBuilder currentHomogenousSubstringBuilder = new StringBuilder();
        String[] digits = member.split("");
        for (String digit : digits) {
            if (currentHomogenousSubstringBuilder.isEmpty()) {
                currentHomogenousSubstringBuilder.append(digit);
                homogenousSubstringBuilders.add(currentHomogenousSubstringBuilder);
            } else if (currentHomogenousSubstringBuilder.indexOf(digit) > -1) {
                currentHomogenousSubstringBuilder.append(digit);
            } else {
                currentHomogenousSubstringBuilder = new StringBuilder();
                currentHomogenousSubstringBuilder.append(digit);
                homogenousSubstringBuilders.add(currentHomogenousSubstringBuilder);
            }
        }

        return homogenousSubstringBuilders.stream()
                .map(StringBuilder::toString)
                .toArray(String[]::new);
    }
}