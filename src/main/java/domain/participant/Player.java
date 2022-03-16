package domain.participant;

import java.util.List;

import domain.card.Card;
import domain.result.Versus;

public class Player extends Participant {

    private Money money;

    public Player(Name name, List<Card> hand, Money money) {
        super(name, hand);
        this.money = money;
    }

    @Override
    public boolean isNeedToDraw() {
        if (isBlackJack() || isUpperBoundScore() || isBust()) {
            return false;
        }
        return true;
    }

    public boolean isNameMatch(Name name) {
        return this.getName().equals(name);
    }

    public Versus compareAtDealerBlackJack() {
        if (this.isBlackJack()) {
            return Versus.DRAW;
        }
        return Versus.LOSE;
    }

    public Versus compareAtFinal(Participant other) {
        if (isBust()) {
            return Versus.LOSE;
        }
        if (this.isBlackJack() || other.isBust()) {
            return Versus.WIN;
        }
        return judgeVersus(other.calculateBestScore());
    }

    private Versus judgeVersus(int otherScore) {
        int playerScore = calculateBestScore();
        if (playerScore > otherScore) {
            return Versus.WIN;
        }
        if (playerScore < otherScore) {
            return Versus.LOSE;
        }
        return Versus.DRAW;
    }
}
