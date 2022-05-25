package ladder.view;

import ladder.domain.Line;
import ladder.domain.Player;

import java.util.List;

public class Output {
    public static void print(String payload) {
        System.out.print(payload);
    }

    public static void printLine(List<Boolean> points) {
        points
            .stream()
            .map(p -> p ? "-" : " ")
            .map(p -> p.repeat(5) + "|")
            .forEach(System.out::print);
    }

    public static void printLines(List<Line> lines) {
        lines.forEach(line -> {
            System.out.print(" ".repeat(4) + "|");
            Output.printLine(line.points());
            System.out.println();
        });

    }
    public static String format(String name) {
        return String.format("%-6s", name);
    }

    public static void printPlayers(List<Player> players) {
        Output.print(" ".repeat(2));
        players.forEach(p -> Output.print(format(p.name())));
        Output.print("\n");
    }
}
