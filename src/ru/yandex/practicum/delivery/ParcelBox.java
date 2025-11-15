package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {
    private final int maxWeightParcels;
    private final ArrayList<T> parcelList = new ArrayList<>();

    public ParcelBox(int maxWeightParcels) {
        this.maxWeightParcels = maxWeightParcels;
    }

    public boolean addParcel(T parcel) {
        int totalWeightParcels = 0;
        for (T parcelPart : parcelList) {
            totalWeightParcels += parcelPart.getWeight();
        }
        if (totalWeightParcels + parcel.getWeight() > maxWeightParcels) {
            System.out.println("Превышен общий вес посылок для коробки.");
            return false;
        } else {
            parcelList.add(parcel);
        }
        return true;
    }

    public ArrayList<T> getAllParcels() {
        return parcelList;
    }
}
