package railwaystation;

public abstract class AbstractDispatchUnit implements ScheduleInfo {
    private String dispatcherName;

    public AbstractDispatchUnit(String dispatcherName) {
        this.dispatcherName = dispatcherName;
    }

    public String getDispatcherName() { return dispatcherName; }

    public int calculateDelay(int scheduledMin, int actualMin) {
        return Math.max(0, actualMin - scheduledMin);
    }

    public abstract void updateBoard();
}