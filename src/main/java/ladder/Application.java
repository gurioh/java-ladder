package ladder;

import ladder.model.Ladder;
import ladder.model.Players;
import ladder.model.Result;
import ladder.model.Results;
import ladder.service.LadderGame;
import ladder.common.InputMessages;
import ladder.util.StringParseUtil;
import ladder.view.InputView;
import ladder.view.ResultView;

import static ladder.service.LadderGame.COMMA;

public class Application {
    public static void main(String[] args) {

        Players players = Players.of(StringParseUtil.splitString(InputView.showMessage(InputMessages.PLAYER_NAMES_QUESTION), COMMA));
        Results results = Results.of(StringParseUtil.splitString(InputView.showMessage(InputMessages.RUN_RESULT_QUESTION), COMMA));
        LadderGame ladderGame = LadderGame.of(
                players,
                Ladder.of(players.size(),StringParseUtil.parseToInt(InputView.showMessage(InputMessages.MAXIMUM_LADDER_HEIGHT_QUESTION))),
                results);

        ResultView.showResultHeader();
        ResultView.showPlayers(ladderGame.getPlayers());
        ResultView.showLines(ladderGame.getLines());
        ResultView.showResults(ladderGame.getResults());

        String name = "";
        while(!name.equals("all")){
            name = InputView.showMessage(InputMessages.SPECIFIC_PLAYER_CHOICE_QUESTION);

            System.out.println("실행 결과");
            System.out.println(ladderGame.result(name));
        }
    }
}