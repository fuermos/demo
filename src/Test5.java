import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/**
 * @author: he zhi
 * @date: 2019/7/3 10:54
 * @description:
 */
public class Test5 {

    public static void main(String[] args) {


        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        List<Transaction> tr2011 = transactions.stream().
                filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());
        System.out.println(tr2011);

        List<String> cities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());
        System.out.println(cities);

        List<Trader> traders = transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getTrader)
                .sorted(comparing(Trader::getName))
                .collect(toList());
        System.out.println(traders);

        String traderStr =
                transactions.stream()
                        .map(Transaction::getTrader)
                        .map(Trader::getName)
                        .distinct()
                        .sorted()
                        .collect(joining(","));
        System.out.println(traderStr);


        System.out.println(
                transactions.stream()
                        .map(Transaction::getTrader)
                        .anyMatch(trader -> "Milan".equals(trader.getCity()))
        )
        ;


        transactions.stream()
                .filter(Transaction -> "Cambridge".equals(Transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        System.out.println(
                transactions.stream()
                        .map(Transaction::getValue)
                        .reduce(Integer::max).get()
        );

        System.out.println(
                transactions.stream()
                        .map(Transaction::getValue)
                        .reduce(Integer::min).get()
        );

        int a = 7;

        List<int[]> list =IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}).collect(toList());
        for (int [] obj:
           list  ) {
            System.out.println(obj[0] + ":"+obj[1] );


        }

        Stream.iterate(0, n -> n + 2)
               .limit(10)
                .forEach(System.out::println);


        System.out.println(
                
        );

    }
}
