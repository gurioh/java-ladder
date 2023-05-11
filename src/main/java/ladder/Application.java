package ladder;

import ladder.service.LadderGame;
import ladder.view.InputMessages;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Application {
    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame();

        ladderGame.setPlayer(InputView.showMessage(InputMessages.PLAYER_NAMES_QUESTION));
        ladderGame.setHeight(InputView.showMessage(InputMessages.MAXIMUM_LADDER_HEIGHT_QUESTION));

        ResultView.getResultHeader();
    }
}
