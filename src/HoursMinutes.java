import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class HoursMinutes {
    public static void main(String[] args) {
        // Get the current local time
        LocalTime now = LocalTime.now();

        // Option 1: Get hours and minutes as integers
        int hours = now.getHour();
        int minutes = now.getMinute();
        System.out.printf("Hours: %02d, Minutes: %02d%n", hours, minutes);

        // Option 2: Format as HH:mm string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = now.format(formatter);

    }
}
