package codingame;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author bikha on 16/04/2019
 * @project Codingame - give back the change using limited number of available coins
 */
public class Launcher {


    public static class Change {
        long coin2 = 0;
        long bill5 = 0;
        long bill10 = 0;

        @Override
        public String toString() {
            return String.join(" ", "{", "coin2: " + coin2, ", bill5: " + bill5, ", bill10: " + bill10, "}");
        }
    }


    public static void main(String[] args) {
        System.out.println(optimalSolution(7)); // 2: 1, 5: 1
        System.out.println(optimalSolution(8)); // 2: 4
        System.out.println(optimalSolution(9)); // 2: 2, 5: 1
        System.out.println(optimalSolution(10)); // 10: 1
        System.out.println(optimalSolution(11)); // null
        System.out.println(optimalSolution(12)); // 2: 1, 10: 1
        System.out.println(optimalSolution(13)); // null
        System.out.println(optimalSolution(15)); // 5: 1, 10: 1
        System.out.println(optimalSolution(22)); // 2: 1, 10: 2
        System.out.println(optimalSolution(42)); // 2: 1, 10: 4
    }

    /**
     * This method return optimal solution if exist.
     *
     * @param change change
     * @return optional of solution
     */
    public static Change optimalSolution(Integer change) {
        Optional<Map<Long, Long>> optimalSolution = Stream.of(
                new long[]{10},
                new long[]{10, 5},
                new long[]{10, 5, 2},
                new long[]{5},
                new long[]{5, 2},
                new long[]{2})
                .map(coins -> solution(change, coins)).filter(Optional::isPresent).findFirst().flatMap(Function.identity());
        return optimalSolution.map(sol -> {
            Change cha = new Change();
            cha.coin2 = sol.getOrDefault(2L, 0L);
            cha.bill5 = sol.getOrDefault(5L, 0L);
            cha.bill10 = sol.getOrDefault(10L, 0L);
            return cha;
        }).orElse(null);
    }

    /**
     * This method check and return how we can express change with the given coins.
     *
     * @param change chane
     * @param coins  available coins
     * @return optional of solution.
     */
    private static Optional<Map<Long, Long>> solution(long change, long... coins) {
        Map<Long, Long> solution = new ConcurrentHashMap<>();
        long rest = LongStream.of(coins).boxed().sorted(Comparator.reverseOrder()).reduce(change, (r, c) -> {
            solution.put(c, r / c);
            return r % c;
        });
        return Optional.ofNullable(0 != rest ? null : solution);
    }

}
