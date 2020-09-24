package lab7_WorkTracker;

import java.io.*;

public class Main {
    public static final String TRACKER_BIN = "tracker.bin";
    public static final String HELP = "One option required. Possible options : [start, pause, status, reset]";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Tracker tracker = (new File(TRACKER_BIN).exists()) ?  load() : new Tracker();

        String userCommand;
        if (args.length == 1) {
            userCommand = args[0];
        } else {
            System.err.println(HELP);
            return;
        }

        switch (userCommand) {
            case "start": {
                tracker.start();
                System.out.println("Tracker started");
                break;
            }
            case "pause": {
                tracker.pause();
                System.out.println("Tracker paused");
                System.out.println("Your working time is " + millisToTime(tracker.getWorkingTime()));
                break;
            }
            case "status": {
                System.out.println("Your working time is " + millisToTime(tracker.getWorkingTime()));
                break;
            }
            case "reset": {
                tracker.reset();
                System.out.println("Tracker reset");
                break;
            }
            default: {
                System.err.println(HELP);
            }
        }
        save(tracker);
    }

    static void save(Tracker tracker) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(TRACKER_BIN))) {
            oos.writeObject(tracker);
            oos.flush();
        }
    }

    static Tracker load() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(TRACKER_BIN))) {
            return (Tracker) ois.readObject();
        }
    }

    static String millisToTime(long millis){
        long hours = millis/1000 / 60 / 60;
        long minutes = ((millis/1000) / 60) % 60 ;
        long seconds = (millis/1000) % 60;
        return hours + " hours " + minutes + " minutes " + seconds + " seconds ";
    }
}
