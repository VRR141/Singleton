import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private int num = 1;
    private static Logger instance;
    private long start;
    private Logger(){
        this.start = System.currentTimeMillis();
    }

    public void log(String msg){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH-mm-ss");
        System.out.println("[" + dateTimeFormatter.format(LocalDateTime.now()) + " " + num++ + "] " + msg);
    }

    public static Logger getInstance(){
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
}
