package tdd.mar.lookandsaysequence;

public class LookAndSaySequence {
    public String nextMember(String member) {
        return (member.isEmpty())
                ? ""
                : "1" + member;
    }
}