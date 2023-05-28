package ladder.service;

import ladder.model.*;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    public static final String COMMA =",";
    private Players players;
    private Ladder ladder;
    private Results results;

    private int height;

    private LadderGame(Players players, Ladder ladder, Results results) {
        this.players = players;
        this.ladder = ladder;
        this.results = results;
    }

    public static LadderGame of(Players players, Ladder ladder, Results results) {
        return new LadderGame(players, ladder, results);
    }

    public LadderGame(String[] names, String[] results) {
        this(new Players(names), new Ladder(), new Results(results));
    }

    public Players getPlayers() {
        return players;
    }

    public void makeLine() {
        ladder.makeLine(players.size(), height);
    }

    public List<Line> getLines() {
        return ladder.getLines();
    }

    public List<Result> getResults() {return results.list();}

    public String result(String name){
        if(name.equals("all")){
            return players.getPlayers().stream()
                    .map(player -> player.getName() + " : " + getGameResult(player.getName()))
                    .collect(Collectors.joining("\n"));

        }
        return getGameResult(name);
    }

    private String getGameResult(String name) {
        return results.list()
                .get(ladder.end(players.playerSequence(name)))
                .value();
    }

}
