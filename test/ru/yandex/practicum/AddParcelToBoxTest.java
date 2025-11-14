package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ru.yandex.practicum.delivery.StandardParcel;
import ru.yandex.practicum.delivery.ParcelBox;

public class AddParcelToBoxTest {
    private static final StandardParcel standardParcel = new StandardParcel(
            "test standart parcel", 10, "test city", 3);
    private static final ParcelBox<StandardParcel> standardParcelBoxLittle = new ParcelBox<>(5);
    private static final ParcelBox<StandardParcel> standardParcelBoxLarge = new ParcelBox<>(55);

    @Test
    public void shouldAddParcelToBox() {
        standardParcelBoxLarge.addParcel(standardParcel);
        Assertions.assertFalse(standardParcelBoxLarge.getAllParcels().isEmpty());
    }

    @Test
    public void shouldNotAddParcelToBox() {
        standardParcelBoxLittle.addParcel(standardParcel);
        Assertions.assertTrue(standardParcelBoxLittle.getAllParcels().isEmpty());
    }
}
