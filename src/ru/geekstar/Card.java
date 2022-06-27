package ru.geekstar;

public class Card {

    private float deposit;

    private String numberCard;

    private String paySystem;

    private int countTransactions = 0;

    private String[] transactions = new String[50];

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    public String getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

    public String getPaySystem() {
        return paySystem;
    }

    public void setPaySystem(String paySystem) {
        this.paySystem = paySystem;
    }

    public int getCountTransactions() {
        return countTransactions;
    }

    public void setCountTransactions(int countTransactions) {
        this.countTransactions = countTransactions;
    }

    public String[] getTransactions() {
        return transactions;
    }

    public void setTransactions(String transactions) {
        this.transactions[countTransactions++] = transactions;
    }

    public void pay(float sumPay) {
        //списать сумму покупки с карты
        boolean payStatus;
        byte errorTransaction = 0;
        do {
            payStatus = withdrawal(sumPay);
            if (payStatus) { //payStatus == true
                String transaction = paySystem + " " + numberCard + ": " + "Покупка " + sumPay + " Остаток на карте " + deposit;
                setTransactions(transaction);
                //System.out.println(transaction);
            }else errorTransaction++;
        }while (!payStatus && errorTransaction < 3);
        /*
        todo: перевести сумму на счет магазина
         */
    }

    public void transfer(float sumTransfer) {
        //нужно рассчитать комиссию за перевод
        float comission;
        if (sumTransfer < 50000) {
            comission = 0;
        }else { //sumTransfer == 50000 || sumTransfer > 50000
            comission = sumTransfer * 0.01f;
        }
        //затем списать деньги с карты
        boolean transferStatus;
        byte errorTransaction = 0;
        do {
            transferStatus = withdrawal(sumTransfer + comission);
            if (transferStatus) {
                String transaction = paySystem + " " + numberCard + ": " + "Переведено " + sumTransfer + "Комиссия составила " + comission + " Остаток на карте " + deposit;
                setTransactions(transaction);
                //System.out.println(transaction);
            }else errorTransaction++;
        }while (!transferStatus && errorTransaction < 3);
        //и перевести деньги на другую карту

        //и перевести комиссию на счет банка
    }

    private boolean withdrawal(float sum) {
        if (deposit >= sum) {
            deposit = deposit - sum;
            return true;
        }else {
            String transaction = paySystem + " " + numberCard + ": " + "Недостаточно средств на карте " + deposit;
            setTransactions(transaction);
            return false;
        }

    }


}
