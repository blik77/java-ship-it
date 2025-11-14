package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {
    private final int maxWeightParcels;
    private final ArrayList<T> parcelList = new ArrayList<>();

    public ParcelBox(int maxWeightParcels) {
        this.maxWeightParcels = maxWeightParcels;
    }

    public void addParcel(T parcel) {
        int totalWeightParcels = 0;
        for (T parcelPart : parcelList) {
            totalWeightParcels += parcelPart.weight;
        }
        if (totalWeightParcels + parcel.weight > maxWeightParcels) {
            System.out.println("Превышен общий вес посылок для коробки.");
        } else {
            parcelList.add(parcel);
        }
    }

    public ArrayList<T> getAllParcels() {
        return parcelList;
    }
}
