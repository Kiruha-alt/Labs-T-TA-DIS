package railwaystation;

public class CentralCommandPost extends PlatformPatrolPost implements StationManagement {
    private String chiefOfficer;

    public CentralCommandPost(int sectorNumber, String chiefOfficer) {
        super(sectorNumber);
        this.chiefOfficer = chiefOfficer;
    }

    @Override
    public String getTrainStatus(String trainNumber) {
        return "[KL14 CentralCommandPost] Поезд " + trainNumber + " идет по графику (Дежурный: " + chiefOfficer + ")";
    }

    @Override
    public void coordinateArrival(String trainId) {
        System.out.println("[KL14 CentralCommandPost] Прием поезда " + trainId + " на путь №" + allocateTrack(12, 1));
    }

    public void emergencyTrackLock() {
        System.out.println("[KL14 CentralCommandPost] Экстренная блокировка путей дежурным " + chiefOfficer);
    }
}