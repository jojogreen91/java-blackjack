package domain.participant;

import domain.card.Card;
import domain.result.Versus;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {

    private static final String NOT_DEALER_BLACK_JACK_SITUATION_ERROR_MESSAGE = "[Error] 딜러가 BlackJack 이 아닙니다.";

    private final List<Player> players;

    public Players(List<Name> names, List<List<Card>> initCards) {
        this.players = IntStream.range(0, names.size())
                .mapToObj(i -> new Player(names.get(i), initCards.get(i)))
                .collect(Collectors.toList());
    }

    public void addCardByName(Name name, Card card) {
        players.stream()
                .filter(player -> player.isNameMatch(name))
                .forEach(player -> player.addCard(card));
    }

    public String showHandByName(Name name) {
        return players.stream()
                .filter(player -> player.isNameMatch(name))
                .map(Player::showHand)
                .findFirst()
                .orElseThrow();
    }

    public int getBestScoreByName(Name name) {
        return players.stream()
                .filter(player -> player.isNameMatch(name))
                .map(Player::getBestScore)
                .findFirst()
                .orElseThrow();
    }

    public boolean isBustByName(Name name) {
        return players.stream()
                .filter(player -> player.isNameMatch(name))
                .map(Player::isBust)
                .findFirst()
                .orElseThrow();
    }

    public boolean isNotAllBust() {
        long count = players.stream()
                .filter(Player::isBust)
                .count();
        return count != players.size();
    }

    public boolean isBlackJackByName(Name name) {
        return players.stream()
                .filter(player -> player.isNameMatch(name))
                .findFirst()
                .orElseThrow()
                .isBlackJack();
    }

    public boolean isMaxScoreByName(Name name) {
        return players.stream()
                .filter(player -> player.isNameMatch(name))
                .map((Player::isMaxScore))
                .findFirst()
                .orElseThrow();
    }

    public Map<Name, Versus> getResultAtDealerBlackJack(Dealer dealer) {
        if (!dealer.isBlackJack()) {
            throw new IllegalStateException(NOT_DEALER_BLACK_JACK_SITUATION_ERROR_MESSAGE);
        }
        Map<Name, Versus> map = new LinkedHashMap<>();
        players.stream().forEach(player -> map.put(player.getName(), player.compareAtDealerBlackJack()));
        return map;
    }

    public Map<Name, Versus> getResultAtFinal(Participant other) {
        Map<Name, Versus> map = new LinkedHashMap<>();
        players.stream().forEach(player -> map.put(player.getName(), player.compareAtFinal(other)));
        return map;
    }
}
