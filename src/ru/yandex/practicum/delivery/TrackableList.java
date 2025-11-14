package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class TrackableList<T extends Trackable> {
    ArrayList<T> list = new ArrayList<>();

    public void add(T el) {
        list.add(el);
    }

    public ArrayList<T> getAll() {
        return list;
    }
}
