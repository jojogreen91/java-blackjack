package view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String INIT_MESSAGE_FORMAT = "\n딜러와 %s에게 2장의 나누었습니다.\n";
    private static final String BUST_MESSAGE = "[ Bust!!! ]";
    private static final String BLACK_JACK_MESSAGE = "[ SCORE IS 21 ]";
    private static final String RESULT_TITLE_MESSAGE = "\n## 최종 승패";
    private static final String DEALER_RESULT_MESSAGE_FORMAT = "딜러: %d승 %d무 %d패\n";
    private static final String PLAYER_RESULT_MESSAGE_FORMAT = "%s: %s\n";
    private static final String DEALER_DRAW_MESSAGE = "\n딜러는 16이하라 한장의 카드를 더 받았습니다.";
    private static final String DEALER_BLACK_JACK_MESSAGE = "\n== DEALER IS BLACK JACK ==";
    public static final String PLAYER_IS_BLACK_JACK_MESSAGE = "\n== %s IS BLACK JACK ==\n";

    public static void printInitMessage(List<String> names) {
        String namesForPrint = names.stream().collect(Collectors.joining(", "));
        System.out.printf(INIT_MESSAGE_FORMAT, namesForPrint);
    }

    public static void printParticipantStatus(String dealerStatus, List<String> playerStatuses) {
        printNewLine();
        System.out.println(dealerStatus);
        playerStatuses.forEach(System.out::println);
    }

    public static void printHand(String hand) {
        System.out.println(hand);
    }

    public static void printBustMessage() {
        System.out.println(BUST_MESSAGE);
    }

    public static void printBlackJackMessage() {
        System.out.println(BLACK_JACK_MESSAGE);
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

    public static void printDealerDrawMessage() {
        System.out.println(DEALER_DRAW_MESSAGE);
    }

    public static void printDealerBlackJackMessage() {
        System.out.println(DEALER_BLACK_JACK_MESSAGE);
    }

    public static void printPlayerBlackJackMessage(String name) {
        System.out.printf(PLAYER_IS_BLACK_JACK_MESSAGE, name);
    }

    private static void printNewLine() {
        System.out.println();
    }
}
