package codingame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LauncherTest {

    @Test
    void should_return_optimal_solution_for_6() {
        Launcher.Change sol = Launcher.optimalSolution(6);
        Assertions.assertEquals(sol.bill10, 0L);
        Assertions.assertEquals(sol.bill5, 0L);
        Assertions.assertEquals(sol.coin2, 3L);
    }

    @Test
    void should_return_optimal_solution_for_7() {
        Launcher.Change sol = Launcher.optimalSolution(7);
        Assertions.assertEquals(sol.bill10, 0L);
        Assertions.assertEquals(sol.bill5, 1L);
        Assertions.assertEquals(sol.coin2, 1L);
    }

    @Test
    void should_return_optimal_solution_for_20() {
        Launcher.Change sol = Launcher.optimalSolution(10);
        Assertions.assertEquals(sol.bill10, 1L);
        Assertions.assertEquals(sol.bill5, 0L);
        Assertions.assertEquals(sol.coin2, 0L);
    }

    @Test
    void should_return_optimal_solution_for_42() {
        Launcher.Change sol = Launcher.optimalSolution(42);
        Assertions.assertEquals(sol.bill10, 4L);
        Assertions.assertEquals(sol.bill5, 0L);
        Assertions.assertEquals(sol.coin2, 1L);
    }

    @Test
    void should_return_empty_solution() {
        Launcher.Change sol = Launcher.optimalSolution(43);
        Assertions.assertNull(sol);
    }

}