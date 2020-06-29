package com.company.Playground;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplendorPurchase {
    Map<String, Integer> wallet;

    List<Card> cardsOwned;

    Map<String, Integer> colorsOwned;


    public SplendorPurchase(List<Money> initialMoney) {
        wallet = new HashMap<String, Integer>();
        colorsOwned = new HashMap<String, Integer>();
        cardsOwned = new ArrayList<Card>();
        for (Money money : initialMoney) {
            wallet.put(money.color, money.num);
        }
    }

    public boolean canPurchase(Card card) {
        for (Money money : card.price) {
            int colorsNum = this.colorsOwned.get(money.color);
            int discountedPrice = Math.min(0, money.num - colorsNum);
            if (discountedPrice <= 0) {
                continue;
            }
            if (!this.wallet.containsKey(money.color)) {
                return false;
            }
            int num = this.wallet.get(money.color);
            if (num < discountedPrice) {
                return false;
            }
        }
        return true;
    }

    public void purchase(Card card) {
        if (!canPurchase(card)) {
            return;
        }
        for (Money money : card.price) {
            int colorsNum = this.colorsOwned.get(money.color);
            int discountedPrice = Math.min(0, money.num - colorsNum);
            this.wallet.put(money.color, Math.min(0, this.wallet.get(money.color) - discountedPrice));
            this.colorsOwned.put(money.color, this.colorsOwned.get(money.color) + 1);
        }
        this.cardsOwned.add(card);
    }
}

class Card {
    List<Money> price;

    public Card(List<Money> price) {
        this.price = price;
    }
}

class Money {
    String color;

    int num;

    public Money(String color, int num) {
        this.color = color;
        this.num = num;
    }
}