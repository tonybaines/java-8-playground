package tonyb.java8.defaultmethods;

public class Mixins {

    public static interface Animal {
        String name();
        String move();
    }

    public static interface SwimmingMovement {
        default String swim() { return "swim";}
    }

    public static interface WalkingMovement {
        default String walk() { return "walk";}
    }

    public static interface FlyingMovement {
        default String fly() { return "fly";}
    }

    public static class Fish implements Animal, SwimmingMovement {
        public String name() { return "Fish"; }
        public String move() { return swim(); }
    }

    public static class Duck implements Animal, SwimmingMovement, WalkingMovement, FlyingMovement {
        public String name() { return "Duck"; }
        public String move() { return swim()+walk()+fly(); }
    }

    public static class Cat implements Animal, SwimmingMovement, WalkingMovement {
        public String name() { return "Duck"; }
        public String move() { return swim()+walk(); }
        @Override
        public String swim() {return "only when dropped in";}
    }

}
