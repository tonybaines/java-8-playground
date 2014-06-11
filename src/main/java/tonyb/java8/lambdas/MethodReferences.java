package tonyb.java8.lambdas;

import java.util.ArrayList;
import java.util.List;

public class MethodReferences {
    private ArrayList<String> strings;
    private ArrayList<Integer> ints;

    public static class Telephone {
        private final String ringtone;
        public Telephone(String ringtone) {this.ringtone = ringtone;}
        public String ring() { return ringtone; }
    }

    public static void main(String[] args) {
        List<Telephone> telephones = new ArrayList<Telephone>() {{
            add(new Telephone("bring, bring"));
            add(new Telephone("bring dada ding dada ding"));
            add(new Telephone("ring-a-lama-ding-dong"));
        }};

        telephones
                .stream()
                .map(Telephone::ring) // map( t -> t.ring() )
                .forEach(it -> System.out.println(it));
    }

    public void references() {
        strings.sort(String::compareToIgnoreCase);
        strings.stream().map(String::toUpperCase);

        ints.sort(Integer::compareUnsigned);
        ints.stream().map(Integer::toHexString);
    }
}
