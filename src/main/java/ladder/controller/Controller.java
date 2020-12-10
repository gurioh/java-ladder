package ladder.controller;

import ladder.domain.game.Ladder;
import ladder.domain.game.Name;
import ladder.domain.game.Names;
import ladder.strategy.ConnectionStrategy;
import ladder.strategy.RandomConnectionStrategy;
import ladder.view.InputView;
import ladder.view.LadderView;
import ladder.view.ResultView;

import java.util.Scanner;

/**
 * Created By mand2 on 2020-12-07.
 */
public class Controller {

    public final static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Names participants = Names.from(InputView.askParticipantList());

        Names goals = Names.from(InputView.askGoal());

        int height = InputView.askLadderHeight();

        ConnectionStrategy connectionStrategy = new RandomConnectionStrategy();
        Ladder ladder = Ladder.of(participants.getParticipantNum(), connectionStrategy, height);

        ResultView.printLadder(participants, ladder, goals);

        LadderView ladderView = LadderView.of(participants, ladder.moveAll(goals));

        String inputName;

        do {
            inputName = InputView.askResultPerson();
            ResultView.printGoals(ladderView, inputName);
        } while (!inputName.equals(ResultView.RESERVED_WORD_ALL));

    }
}