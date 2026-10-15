package railwaystation;

public interface StationManagement extends ScheduleInfo, StationSecurity, TrackLogistics {
    void coordinateArrival(String trainId);
}