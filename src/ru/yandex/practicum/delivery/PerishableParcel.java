package ru.yandex.practicum.delivery;

import java.util.Scanner;

public class PerishableParcel extends Parcel {
    static final int baseCost = 3;
    private static final Scanner scanner = new Scanner(System.in);
    protected int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public int getBaseCost() {
        return baseCost;
    }

    public boolean isExpired(int currentDay) {
        return sendDay + timeToLive < currentDay;
    }

    @Override
    public String toString() {
        return super.toString() + ", годность " + timeToLive + " дней";
    }
}
