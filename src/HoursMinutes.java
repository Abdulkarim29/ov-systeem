import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class HoursMinutes {

    public String getFormattedTime() {
        LocalTime now = LocalTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return now.format(formatter);
    }
}