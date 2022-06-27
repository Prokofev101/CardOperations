package ru.geekstar;

public class Main {

    public static void main(String[] args) {

        Card visaCard = new Card();
        visaCard.setDeposit(7100.00f);
        visaCard.setNumberCard("0000 0000 0000 0000");
        visaCard.setPaySystem("VISA");
        visaCard.pay(100.50f);
        visaCard.pay(250.00f);
        visaCard.transfer(100.00f);

        //System.out.println("\nОперации по карте " + visaCard.getPaySystem() + " " +visaCard.getNumberCard() + ": ");
        String[] transactions = visaCard.getTransactions();
        int countTransactions = visaCard.getCountTransactions();
        for (int id = 0; id < countTransactions; id++) {
            //System.out.println("Операция #" + id + " по карте " + transactions[id]);
        }

        Card masterCard = new Card();
        masterCard.setDeposit(5600.00f);
        masterCard.setNumberCard("1111 1111 1111 1111");
        masterCard.setPaySystem("MASTERCARD");
        masterCard.pay(50.25f);

        //создадим массив карт

        Card[] cards = new Card[2];
        cards[0] = visaCard;
        cards[1] = masterCard;

        cards[0].pay(100.00f);
        cards[1].transfer(200.00f);

        System.out.println("Операции по всем картам: ");
        for (int idCard = 0; idCard < cards.length; idCard++) {
            Card card = cards[idCard];
            String[] cardTransactions = card.getTransactions();
            int cardCountTransactions = card.getCountTransactions();

            for (int id = 0; id < cardCountTransactions; id++) {
                System.out.println("Операция #" + id + " по карте " + cardTransactions[id]);
            }
        }


    }
}
