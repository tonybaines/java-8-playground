package tonyb.java8.lambdas;

public interface Gremlin {
    String speak();

    String act();

    default String describe() {
        return this.getClass().getSimpleName();
    }
}
