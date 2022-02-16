/*
Coding Round 3 - at Nvidia
* // 1. check all 52 cards available or not
// 2. check which card is missing
// 3. check if we have a duplicate card


String[] cardsDeck = new String[]
{ "AH", "KH", "10D", "5H", "AC", "10S", "AS", "8H", "9D", "5S", "3D", "7S", "2D", "JH",
"QS", "2H", "QD", "6S", "5D", "8D", "2C", "JC", "KS", "KD", "4H", "3H", "3C", "6D", "QH", "9H", "JD", "7D",
"AD", "2S", "3S", "4S", "9S", "9C", "5C", "7C", "QC", "10H", "10C", "8S", "JS", "4D", "6H", "4C", "8C",
"7H", "6C", "KC" };

Cards: A J Q K, 2 - 10
Suit
D - Diamond
S - Spade
H - Heart
C - Club
*
*
*
*
* */

import java.util.*;
import java.util.stream.Collectors;

public class CardDeckProblem {
    public static void main(String[] args) {

        Set<String> prePopulatedCardDeck = prepopulateUniqueCards();

        testNullCardDeck();
        test52CardsWithEmptyCardDeck();
        testDuplicateAndMissingCards(prePopulatedCardDeck);
        testMissingCards(prePopulatedCardDeck);
        testNoMissingCards(prePopulatedCardDeck);

    }


    public static void testNullCardDeck() {
        validateCardDeck(null);
    }

    public static void test52CardsWithEmptyCardDeck() {
        String[] cardsDeck = new String[]{"AH"};
        validateCardDeck(cardsDeck);
    }

    public static void testDuplicateAndMissingCards(Set<String> prePopulatedCardDeck) {
        //duplicate AH
        String[] cardsDeck = new String[]
                {"AH", "AH", "10D", "5H", "AC", "10S", "AS", "8H", "9D", "5S", "3D", "7S", "2D", "JH",
                        "QS", "2H", "QD", "6S", "5D", "8D", "2C", "JC", "KS", "KD", "4H", "3H", "3C", "6D", "QH", "9H", "JD", "7D",
                        "AD", "2S", "3S", "4S", "9S", "9C", "5C", "7C", "QC", "10H", "10C", "8S", "JS", "4D", "6H", "4C", "8C",
                        "7H", "6C", "KC"};
        Set<String> uniqueCardDeck = getUniqueCardDeck(cardsDeck);
        findMissingCards(prePopulatedCardDeck, uniqueCardDeck);
    }

    public static void testNoMissingCards(Set<String> prePopulatedCardDeck) {
        //All valid 52 cards
        String[] cardsDeck = new String[]
                {"AH", "KH", "10D", "5H", "AC", "10S", "AS", "8H", "9D", "5S", "3D", "7S", "2D", "JH",
                        "QS", "2H", "QD", "6S", "5D", "8D", "2C", "JC", "KS", "KD", "4H", "3H", "3C", "6D", "QH", "9H", "JD", "7D",
                        "AD", "2S", "3S", "4S", "9S", "9C", "5C", "7C", "QC", "10H", "10C", "8S", "JS", "4D", "6H", "4C", "8C",
                        "7H", "6C", "KC"};
        Set<String> uniqueCardDeck = getUniqueCardDeck(cardsDeck);
        findMissingCards(prePopulatedCardDeck, uniqueCardDeck);
    }

    public static void testMissingCards(Set<String> prePopulatedCardDeck) {
        //missing AK, AH
        String[] cardsDeck = new String[]
                {"ZK", "ZK", "10D", "5H", "AC", "10S", "AS", "8H", "9D", "5S", "3D", "7S", "2D", "JH",
                        "QS", "2H", "QD", "6S", "5D", "8D", "2C", "JC", "KS", "KD", "4H", "3H", "3C", "6D", "QH", "9H", "JD", "7D",
                        "AD", "2S", "3S", "4S", "9S", "9C", "5C", "7C", "QC", "10H", "10C", "8S", "JS", "4D", "6H", "4C", "8C",
                        "7H", "6C", "KC"};
        Set<String> uniqueCardDeck = getUniqueCardDeck(cardsDeck);
        findMissingCards(prePopulatedCardDeck, uniqueCardDeck);
    }

    private static void validateCardDeck(String[] cardsDeck) {
        if (cardsDeck == null || cardsDeck.length == 0) {
            System.out.println("Invalid input or empty input");
            return;
        }

        if (cardsDeck.length < 52) {
            System.out.println("Number of cards in the deck are less than 52");
        }
    }

    private static Set<String> getUniqueCardDeck(String[] cardsDeck) {
        Set<String> uniqueCardDeck = new TreeSet<>();
        StringBuilder duplicate = new StringBuilder();
        for (String card : cardsDeck) {
            boolean result = uniqueCardDeck.add(card);
            if (!result) {
                duplicate.append(card + " ");
            }
        }
        String duplicateMessage = duplicate.toString().length() > 0 ? "Found duplicate card: " + duplicate.toString() : "No duplicate card found";
        System.out.println(duplicateMessage);
        return uniqueCardDeck;
    }

    private static void findMissingCards(Set<String> prePopulatedCardDeck, Set<String> uniqueCardDeck) {
        Set<String> missingCards = prePopulatedCardDeck.stream().filter(prePopulatedCard -> {
            return uniqueCardDeck.stream().noneMatch(givenCard -> {
                return prePopulatedCard.equals(givenCard);
            });
        }).collect(Collectors.toSet());

        String missingCardMessage = missingCards.size() > 0 ? "Missing cards: " + missingCards : "No missing card";
        System.out.println(missingCardMessage);
    }


    private static Set<String> prepopulateUniqueCards() {

        Set<String> uniqueCardDeck = new TreeSet<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                StringBuilder sb = new StringBuilder();
                if (j == 1) {
                    sb.append("A");
                } else if (j == 11) {
                    sb.append("J");
                } else if (j == 12) {
                    sb.append("Q");
                } else if (j == 13) {
                    sb.append("K");
                } else {
                    sb.append(j);
                }

                if (i == 0) {
                    sb.append("D");
                } else if (i == 1) {
                    sb.append("S");
                } else if (i == 2) {
                    sb.append("H");
                } else if (i == 3) {
                    sb.append("C");
                }
                uniqueCardDeck.add(sb.toString());
            }
        }

        return uniqueCardDeck;

    }
}
