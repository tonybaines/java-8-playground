package tonyb.java8.streams;

public class Streams {
    public static void main(String[] args) {
        final int totalForAllMonths_GCA = COINSData
                .records
                .parallelStream()
                .filter((r) -> r.category.equals("GCA"))
                .map((r) -> r.april_2010_mth + r.may_2010_mth + r.june_2010_mth)
                .reduce(Integer::sum)
                .get();

        System.out.println("The total for april, may and june for GCA records is "+totalForAllMonths_GCA);
    }
}
