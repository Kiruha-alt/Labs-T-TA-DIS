package app;

import smarthome.*;
import railwaystation.*;

public class MyClass {
    public static void main(String[] args) {
        System.out.println("=== ЧАСТЬ 1. СХЕМА 1 (ПРЕДМЕТНАЯ ОБЛАСТЬ: УМНЫЙ ДОМ) ===");

        MotionSensor motionSensor = new MotionSensor(5);
        SecurityGuardHub guardHub = new SecurityGuardHub(true);
        SmokeDetector smokeDetector = new SmokeDetector("Кухня", 40);
        WaterLeakSensor waterSensor = new WaterLeakSensor("Ванная", false);
        CentralSmartGate smartGate = new CentralSmartGate(true, "GATE-777");
        SmartHvacSystem hvacSystem = new SmartHvacSystem(22, 95);

        SmartDevice[] smartDevices = {
            motionSensor, guardHub, smokeDetector, waterSensor, smartGate, hvacSystem
        };

        System.out.println("\n--- 1.1 Полиморфный вызов через массив базового интерфейса SmartDevice (I1) ---");
        for (SmartDevice device : smartDevices) {
            System.out.println(device.getClass().getSimpleName() + " -> Мощность: "
                    + device.calculatePower(SmartDevice.DEFAULT_VOLTAGE, 2) + " Вт");
        }

        System.out.println("\n--- 1.2 Вызов методов через ссылки на интерфейсы и абстрактные классы ---");
        Sensor sensorRef = smokeDetector;
        System.out.println("Через Sensor (I2): Данные = " + sensorRef.readSensorData(10, 100));

        ClimateControl climateRef = hvacSystem;
        System.out.println("Через ClimateControl (I3): " + climateRef.adjustClimate("ЭКО-Комфорт"));

        SecurityModule securityRef = guardHub;
        securityRef.triggerAlarm("Задний двор");

        EnergySaver energyRef = smartGate;
        System.out.println("Через EnergySaver (I5): Нагрузка = " + energyRef.optimizeConsumption(3500, 2500) + " Вт");

        AirMonitor airRef = hvacSystem;
        airRef.checkAirQuality(420);

        SmartAutomation automationRef = smartGate;
        automationRef.runScenario("Ночной режим");

        AbstractEnvSensor envSensorRef = waterSensor;
        System.out.println("Через AbstractEnvSensor (AKL7): " + envSensorRef.getEnvReport());

        AbstractClimateUnit climateUnitRef = hvacSystem;
        climateUnitRef.startVentilation();

        System.out.println("\n--- 1.3 Приведение типов ВНИЗ (Downcasting) и вызов специфичных методов ---");
        for (SmartDevice device : smartDevices) {
            if (device instanceof MotionSensor) {
                ((MotionSensor) device).detectMotion(1, 12);
            } else if (device instanceof SmokeDetector) {
                ((SmokeDetector) device).testSiren();
            } else if (device instanceof WaterLeakSensor) {
                ((WaterLeakSensor) device).blockWaterSupply();
            } else if (device instanceof CentralSmartGate) {
                ((CentralSmartGate) device).lockAllDoors();
            } else if (device instanceof SecurityGuardHub) {
                System.out.println(((SecurityGuardHub) device).checkPerimeter("Главный вход"));
            } else if (device instanceof SmartHvacSystem) {
                ((SmartHvacSystem) device).purifyAir();
            }
        }

        System.out.println("\n=== ЧАСТЬ 2. СХЕМА 2 (ПРЕДМЕТНАЯ ОБЛАСТЬ: ВОКЗАЛ) ===");

        TicketKiosk ticketKiosk = new TicketKiosk(101);
        PlatformPatrolPost patrolPost = new PlatformPatrolPost(3);
        SuburbanCashDesk suburbanDesk = new SuburbanCashDesk("Иванова А.П.", "Минск — Молодечно");
        InternationalCashDesk intlDesk = new InternationalCashDesk("Петров С.В.", true);
        CentralCommandPost commandPost = new CentralCommandPost(1, "Майор Соколов");
        AutomatedDispatchCenter dispatchCenter = new AutomatedDispatchCenter("Сидорова Е.И.", 12);

        TicketService[] ticketUnits = { ticketKiosk, suburbanDesk, intlDesk, dispatchCenter };
        System.out.println("\n--- 2.1 Полиморфизм через массив базового типа TicketService (I2) ---");
        for (TicketService unit : ticketUnits) {
            System.out.println(unit.getClass().getSimpleName() + " -> Стоимость проезда: "
                    + unit.calculateFare(5, 3) + " руб.");
        }

        System.out.println("\n--- 2.2 Вызов через ссылки на интерфейсы и абстрактные классы ---");
        ScheduleInfo scheduleRef = commandPost;
        System.out.println(scheduleRef.getTrainStatus("702Б Минск-Брест"));

        StationSecurity secStationRef = patrolPost;
        secStationRef.announceAlert("Платформа №2");

        TrackLogistics logisticsRef = patrolPost;
        System.out.println("Назначен путь №" + logisticsRef.allocateTrack(14, 2));

        BoardingControl boardingRef = dispatchCenter;
        System.out.println("Билет валиден: " + boardingRef.verifyPassenger("BY-994812"));

        StationManagement managementRef = commandPost;
        managementRef.coordinateArrival("Поезд №055");

        AbstractCashDesk cashDeskRef = suburbanDesk;
        System.out.println(cashDeskRef.processRefund());

        AbstractDispatchUnit dispatchRef = dispatchCenter;
        dispatchRef.updateBoard();

        System.out.println("\n--- 2.3 Приведение типов ВНИЗ (Downcasting) для объектов Вокзала ---");
        Object[] stationObjects = {
            ticketKiosk, patrolPost, suburbanDesk, intlDesk, commandPost, dispatchCenter
        };
        for (Object obj : stationObjects) {
            if (obj instanceof TicketKiosk) {
                ((TicketKiosk) obj).printBoardingPass(5501, 2);
            } else if (obj instanceof SuburbanCashDesk) {
                ((SuburbanCashDesk) obj).issueSeasonTicket();
            } else if (obj instanceof InternationalCashDesk) {
                ((InternationalCashDesk) obj).checkPassportData();
            } else if (obj instanceof CentralCommandPost) {
                ((CentralCommandPost) obj).emergencyTrackLock();
            } else if (obj instanceof PlatformPatrolPost) {
                System.out.println(((PlatformPatrolPost) obj).inspectBaggage("Гражданин К."));
            } else if (obj instanceof AutomatedDispatchCenter) {
                ((AutomatedDispatchCenter) obj).syncPlatformGates();
            }
        }
    }
}