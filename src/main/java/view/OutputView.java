package view;

import domain.participant.Dealer;
import domain.participant.Name;
import domain.participant.Player;
import domain.participant.Players;
import domain.result.Result;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String INIT_MESSAGE_FORMAT = "\n딜러와 %s에게 2장의 나누었습니다.\n";
    private static final String SHOW_ONE_HAND_FORMAT = "딜러: %s\n";
    private static final String SHOW_HAND_FORMAT = "%s 카드: %s\n";
    private static final String STATUS_FORMAT = "%s 카드: %s - 결과 : %d\n";
    private static final String BUST_MESSAGE = "[ Bust!!! ]";
    private static final String MAX_SCORE_MESSAGE = "[ SCORE IS 21 ]";
    private static final String RESULT_TITLE_MESSAGE = "\n## 최종 승패";
    private static final String DEALER_RESULT_MESSAGE_FORMAT = "딜러: %d승 %d무 %d패\n";
    private static final String PLAYER_RESULT_MESSAGE_FORMAT = "%s: %s\n";
    private static final String DEALER_DRAW_MESSAGE = "\n딜러는 16이하라 한장의 카드를 더 받았습니다.";
    private static final String DEALER_BLACK_JACK_MESSAGE = "\n== DEALER IS BLACK JACK ==";
    public static final String PLAYER_IS_BLACK_JACK_MESSAGE = "\n== %s IS BLACK JACK ==\n";

    public static void printInitHandsMessage(List<Name> names) {
        String namesForPrint = names.stream().map(Name::getName).collect(Collectors.joining(", "));
        System.out.printf(INIT_MESSAGE_FORMAT, namesForPrint);
    }

    public static void printParticipantInitHands(List<Name> names, Dealer dealer, Players players) {
        printInitHandsMessage(names);
        printNewLine();
        System.out.printf(SHOW_ONE_HAND_FORMAT, dealer.getFirstHand().toString());
        for (Name name : names) {
            printPlayerHand(name, players);
        }
    }

    public static void printPlayerHand(Name name, Players players) {
        System.out.printf(SHOW_HAND_FORMAT, name.getName(), players.showHandByName(name));
    }


    public static boolean printIfMaxScoreOrBust(Players players, Name name) {
        if (players.isMaxScoreByName(name)) {
            System.out.println(MAX_SCORE_MESSAGE);
            return false;
        }
        if (players.isBustByName(name)) {
            System.out.println(BUST_MESSAGE);
            return false;
        }
        return true;
    }

    public static void printDealerDrawMessage() {
        System.out.println(DEALER_DRAW_MESSAGE);
    }

    public static void printStatuses(List<Name> names, Dealer dealer, Players players) {
        printNewLine();
        System.out.printf(STATUS_FORMAT, "딜러", dealer.showHand(), dealer.getBestScore());
        for (Name name : names) {
            System.out.printf(
                    STATUS_FORMAT, name.getName(),
                    players.showHandByName(name),
                    players.getBestScoreByName(name)
            );
        }
    }

    public static void printDealerBlackJackResult(List<Name> names, Dealer dealer, Players players) {
        Result dealerBlackjackResult = new Result(players.getResultAtDealerBlackJack(dealer));
        OutputView.printDealerBlackJackMessage();
        OutputView.printResultTitle();
        OutputView.printDealerResult(
                dealerBlackjackResult.getDealerWinCount(),
                dealerBlackjackResult.getDealerDrawCount(),
                dealerBlackjackResult.getDealerLoseCount()
        );
        for (Name name : names) {
            OutputView.printPlayerResult(name.getName(), dealerBlackjackResult.getVersusOfPlayer(name).getResult());
        }
    }

    public static void printDealerBlackJackMessage() {
        System.out.println(DEALER_BLACK_JACK_MESSAGE);
    }

    public static void printPlayerBlackJackMessage(Name name, Players players) {
        if (players.isMaxScoreByName(name)) {
            System.out.printf(PLAYER_IS_BLACK_JACK_MESSAGE, name.getName());
        }
    }

    public static void printResultTitle() {
        System.out.println(RESULT_TITLE_MESSAGE);
    }

    public static void printDealerResult(int winCount, int drawCount, int loseCount) {
        System.out.printf(DEALER_RESULT_MESSAGE_FORMAT, winCount, drawCount, loseCount);
    }

    public static void printPlayerResult(String name, String result) {
        System.out.printf(PLAYER_RESULT_MESSAGE_FORMAT, name, result);
    }

    private static void printNewLine() {
        System.out.println();
    }
}
