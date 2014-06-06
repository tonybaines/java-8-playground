package tonyb.java8.lambdas;

import static tonyb.java8.lambdas.Time.*;
import static tonyb.java8.lambdas.Humidity.*;

public class GremlinFactory7 {

    public static void main(String[] args) {
        Gremlin mogwai = GremlinFactory7.newGremlin(BeforeMidnight, Dry);
        interactWith(mogwai);

        Gremlin secondGenerationGremlin = GremlinFactory7.newGremlin(BeforeMidnight, Wet);
        interactWith(secondGenerationGremlin);

        Gremlin thirdGenerationGremlin = GremlinFactory7.newGremlin(AfterMidnight, Wet);
        interactWith(thirdGenerationGremlin);
    }

    public static Gremlin newGremlin(Time time, Humidity dryness) {
        switch (time) {
        case BeforeMidnight:
            return (dryness.equals(Humidity.Dry))
                    ? new Mogwai()
                    : new SecondGenGremlin();
        case AfterMidnight:
            return (dryness.equals(Humidity.Dry))
                    ? new SecondGenGremlin()
                    : new ThirdGenGremlin();
        default:
            throw new IllegalArgumentException("Sorry, Time seems to be broken. Please come back sometime last month.");
        }
    }

    public static class Mogwai implements Gremlin {
        public String speak() {
            return "happy, gurgling song";
        }

        public String act() {
            return "cute & cuddly";
        }

        public String toString() {
            return describe();
        }
    }

    public static class SecondGenGremlin implements Gremlin {
        public String speak() {
            return "snigger";
        }

        public String act() {
            return "snarky";
        }

        public String toString() {
            return describe();
        }
    }

    public static class ThirdGenGremlin implements Gremlin {
        public String speak() {
            return "growl";
        }

        public String act() {
            return "bitey, scratchy, nasty";
        }

        public String toString() {
            return describe();
        }
    }

    private static void interactWith(Gremlin gremlin) {
        System.out.println(String.format("Gremlin (%s) says '%s'", gremlin, gremlin.speak()));
        System.out.println(String.format("Gremlin (%s) acts %s", gremlin, gremlin.act()));
    }
}
