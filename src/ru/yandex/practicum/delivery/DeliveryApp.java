package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Parcel> allParcels = new ArrayList<>();
    private static final List<Trackable> allTrackParcels = new ArrayList<>();

    private static final ParcelBox<StandardParcel> standardParcelBox = new ParcelBox<>(10);
    private static final ParcelBox<FragileParcel> fragileParcelBox = new ParcelBox<>(5);
    private static final ParcelBox<PerishableParcel> perishableParcelBox = new ParcelBox<>(7);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addParcel();
                    break;
                case "2":
                    sendParcels();
                    break;
                case "3":
                    calculateCosts();
                    break;
                case "4":
                    trackParcels();
                    break;
                case "5":
                    showParcelBoxContents();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Отследить посылки");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    private static void addParcel() {
        boolean running = true;
        while (running) {
            System.out.println("Выберите тип посылки:");
            System.out.println("1 — Стандартная посылка");
            System.out.println("2 — Хрупкая посылка");
            System.out.println("3 — Скоропортящаяся посылка");
            System.out.println("0 — Отмена");
            String choice = scanner.nextLine();

            if (choice.equals("1") || choice.equals("2") || choice.equals("3")) {
                System.out.println("Ввод параметров посылки");

                System.out.println("Введите краткое описание посылки");
                String description = scanner.nextLine();

                System.out.println("Введите вес посылки (целое число, больше 0)");
                int weight = Integer.parseInt(scanner.nextLine());

                System.out.println("Введите адрес места назначения посылки");
                String deliveryAddress = scanner.nextLine();

                System.out.println("Введите день месяца, в который посылка была отправлена (целое число, от 1 до 30)");
                int sendDay = Integer.parseInt(scanner.nextLine());

                if (choice.equals("1")) {
                    StandardParcel standardParcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
                    allParcels.add(standardParcel);
                    standardParcelBox.addParcel(standardParcel);
                } else if (choice.equals("2")) {
                    FragileParcel fragileParcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
                    allParcels.add(fragileParcel);
                    allTrackParcels.add(fragileParcel);
                    fragileParcelBox.addParcel(fragileParcel);
                } else {
                    System.out.println("Введите срок в днях, за который посылка не испортится (целое число, больше 0)");
                    int timeToLive = Integer.parseInt(scanner.nextLine());

                    PerishableParcel perishableParcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
                    allParcels.add(perishableParcel);
                    perishableParcelBox.addParcel(perishableParcel);
                }

                running = false;
            } else if (choice.equals("0")) {
                running = false;
            } else {
                System.out.println("Неверный выбор.");
            }
        }
    }

    private static void sendParcels() {
        if (allParcels.isEmpty()) {
            System.out.println("Список посылок пуст.");
        } else {
            for (Parcel parcel : allParcels) {
                parcel.packageItem();
                parcel.deliver();
            }
        }
    }

    private static void calculateCosts() {
        if (allParcels.isEmpty()) {
            System.out.println("Список посылок пуст.");
        } else {
            int totalCost = 0;
            for (Parcel parcel : allParcels) {
                totalCost += parcel.calculateDeliveryCost();
            }
            System.out.println("Общая стоимость всех доставок: " + totalCost);
        }
    }

    private static void trackParcels() {
        if (allTrackParcels.isEmpty()) {
            System.out.println("Список отслеживаемых посылок пуст.");
        } else {
            for (Trackable parcel : allTrackParcels) {
                System.out.println("Введите новое местоположение для: " + parcel);
                String newLocation = scanner.nextLine();
                parcel.reportStatus(newLocation);
            }
        }
    }

    public static void showParcelBoxContents() {
        System.out.println("Выберите тип коробки:");
        System.out.println("1 — Коробка для обычных посылок");
        System.out.println("2 — Коробка для хрупких посылок");
        System.out.println("3 — Коробка для скоропортящихся посылок");
        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            if (standardParcelBox.getAllParcels().isEmpty()) {
                System.out.println("Коробка пуста");
            } else {
                for (Parcel parcel : standardParcelBox.getAllParcels()) {
                    System.out.println(parcel);
                }
            }
        } else if (choice.equals("2")) {
            if (fragileParcelBox.getAllParcels().isEmpty()) {
                System.out.println("Коробка пуста");
            } else {
                for (Parcel parcel : fragileParcelBox.getAllParcels()) {
                    System.out.println(parcel);
                }
            }
        } else if (choice.equals("3")) {
            if (perishableParcelBox.getAllParcels().isEmpty()) {
                System.out.println("Коробка пуста");
            } else {
                for (Parcel parcel : perishableParcelBox.getAllParcels()) {
                    System.out.println(parcel);
                }
            }
        } else {
            System.out.println("Неверный выбор.");
        }
    }

}

