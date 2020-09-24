package lab7_WorkTracker;

import java.io.Serializable;

public class Tracker implements Serializable {
    private long workingTime;
    private long startTime;
    private static final long serialVersionUID = 4263245655L;

    public long getWorkingTime() {
        if (startTime != 0) {
            workingTime += (System.currentTimeMillis() - startTime);
            startTime = System.currentTimeMillis();
        }
        return workingTime;
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }
    
    public void pause() {
        if (startTime != 0) {
            workingTime += (System.currentTimeMillis() - startTime);
            startTime = 0;
        }
    }
    
    public void reset() {
        startTime = 0;
        workingTime = 0;
    }
}
