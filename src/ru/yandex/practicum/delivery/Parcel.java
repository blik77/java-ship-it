package ru.yandex.practicum.delivery;

import java.util.Scanner;

public abstract class Parcel {
    private static final Scanner scanner = new Scanner(System.in);

    protected String description;
    protected int weight;
    protected String deliveryAddress;
    protected int sendDay;

    protected Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public void packageItem() {
        System.out.println("Посылка <<" + description + ">> упакована");
    }

    public void deliver() {
        System.out.println("Посылка <<" + description + ">> доставлена по адресу " + deliveryAddress);
    }

    public int calculateDeliveryCost() {
        return weight * getBaseCost();
    }

    public abstract int getBaseCost();

    @Override
    public String toString() {
        return "Посылка: '" + description + "', " + weight + "кг., до " + deliveryAddress + ", " + sendDay + " день";
    }
}
