package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;

public class DeliveryCostTest {
    private static final StandardParcel standardParcel = new StandardParcel(
"test standart parcel", 10, "test city", 3);
    private static final FragileParcel fragileParcel = new FragileParcel(
"test standart parcel", 10, "test city", 3);
    private static final PerishableParcel perishableParcel = new PerishableParcel(
"test standart parcel", 10, "test city", 3, 4);

    @Test
    public void shouldCostStandardParcel() {
        Assertions.assertEquals(20, standardParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldCostFragileParcel() {
        Assertions.assertEquals(40, fragileParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldCostPerishableParcel() {
        Assertions.assertEquals(30, perishableParcel.calculateDeliveryCost());
    }

}
