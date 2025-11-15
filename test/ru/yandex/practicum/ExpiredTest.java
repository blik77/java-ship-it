package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ru.yandex.practicum.delivery.PerishableParcel;

public class ExpiredTest {
    private static final PerishableParcel perishableParcel = new PerishableParcel(
            "test standart parcel", 10, "test city", 3, 4);

    @Test
    public void shouldNotExpiredParcel() {
        Assertions.assertFalse(perishableParcel.isExpired(5));
    }

    @Test
    public void shouldExpiredParcel() {
        Assertions.assertTrue(perishableParcel.isExpired(15));
    }

    @Test
    public void shouldExpiredParcelBoundaryCondition() {
        Assertions.assertFalse(perishableParcel.isExpired(7));
    }
}
