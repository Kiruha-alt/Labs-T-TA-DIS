package railwaystation;

public class PlatformPatrolPost implements StationSecurity, TrackLogistics {
    private int sectorNumber;

    public PlatformPatrolPost(int sectorNumber) {
        this.sectorNumber = sectorNumber;
    }

    public int getSectorNumber() { return sectorNumber; }

    @Override
    public void announceAlert(String platform) {
        System.out.println("[KL11 PlatformPatrolPost #" + sectorNumber + "] Проверка безопасности на платформе " + platform);
    }

    @Override
    public int allocateTrack(int trainLength, int priority) {
        return (trainLength > 10) ? 1 : priority + 1;
    }

    public String inspectBaggage(String owner) {
        return "[KL11 PlatformPatrolPost] Досмотр багажа пассажира: " + owner + " — Успешно.";
    }
}