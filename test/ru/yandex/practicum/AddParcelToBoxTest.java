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
    private static final ParcelBox<StandardParcel> standardParcelBoxFull = new ParcelBox<>(15);

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

    @Test
    public void shouldAddParcelToNotEmptyBox() {
        standardParcelBoxFull.addParcel(standardParcel); // Предварительно наполним коробку
        StandardParcel standardParcel1 = new StandardParcel(
                "test standart parcel 1", 5, "test city", 3);
        // попытка добавить в непустую коробку
        Assertions.assertTrue(standardParcelBoxFull.addParcel(standardParcel1));
    }

    @Test
    public void shouldNotAddParcelNotEmptyBox() {
        StandardParcel standardParcel2 = new StandardParcel(
                "test standart parcel 2", 5, "test city", 3);
        // попытка добавить в заполненную коробку
        Assertions.assertFalse(standardParcelBoxFull.addParcel(standardParcel2));
    }
}
