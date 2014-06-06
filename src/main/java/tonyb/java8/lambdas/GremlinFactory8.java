package tonyb.java8.lambdas;

import static tonyb.java8.lambdas.Humidity.Dry;
import static tonyb.java8.lambdas.Humidity.Wet;
import static tonyb.java8.lambdas.Time.AfterMidnight;
import static tonyb.java8.lambdas.Time.BeforeMidnight;

public class GremlinFactory8 {

    public static void main(String[] args) {
        Gremlin mogwai = GremlinFactory8.newGremlin(BeforeMidnight, Dry);
        interactWith(mogwai);

        Gremlin secondGenerationGremlin = GremlinFactory8.newGremlin(BeforeMidnight, Wet);
        interactWith(secondGenerationGremlin);

        Gremlin thirdGenerationGremlin = GremlinFactory8.newGremlin(AfterMidnight, Wet);
        interactWith(thirdGenerationGremlin);

        Gremlin unknownGremlin = GremlinFactory8.newGremlin(null, null);
        interactWith(unknownGremlin);

    }

    public static Gremlin newGremlin(Time time, Humidity dryness) {
        if (time != null) {
            switch (time) {
            case BeforeMidnight:
                return (dryness.equals(Humidity.Dry))
                        ? new LambdaGremlin(Speech::happy, Mood::gentle)
                        : new LambdaGremlin(Speech::dissy, Mood::uppity);
            case AfterMidnight:
                return (dryness.equals(Humidity.Dry))
                        ? new LambdaGremlin(Speech::dissy, Mood::uppity)
                        : new LambdaGremlin(Speech::scarey, Mood::aggressive);
            default:
                throw new IllegalArgumentException("Sorry, Time seems to be broken. Please come back sometime last month.");
            }
        } else {
            return new LambdaGremlin(
                    () -> "err",
                    () -> "confused");
        }
    }

    public static class LambdaGremlin implements Gremlin, Speech, Mood {
        private final Speech speech;
        private final Mood mood;

        public LambdaGremlin(Speech speech, Mood mood) {
            this.speech = speech;
            this.mood = mood;
        }

        public String speak() {
            return speech.speak();
        }

        public String act() {
            return mood.act();
        }

        public String toString() {
            return describe();
        }
    }

    public interface Speech {
        String speak();

        static String happy() {
            return "happy, gurgling song";
        }

        static String dissy() {
            return "snigger";
        }

        static String scarey() {
            return "growl";
        }
    }

    public interface Mood {
        String act();

        static String gentle() {
            return "cute & cuddly";
        }

        static String uppity() {
            return "snarky";
        }

        static String aggressive() {
            return "bitey, scratchy, nasty";
        }
    }

    private static void interactWith(Gremlin gremlin) {
        System.out.println(String.format("Gremlin (%s) says '%s'", gremlin, gremlin.speak()));
        System.out.println(String.format("Gremlin (%s) acts %s", gremlin, gremlin.act()));
    }
}
