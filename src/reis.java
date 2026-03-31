import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class reis {

    private String beginstation;
    private String eindstation;
    private double prijs;
    public String formattedTime;

    public reis(String beginstation, String eindstation, double prijs, String formattedTime) {
        this.beginstation = beginstation;
        this.eindstation = eindstation;
        this.prijs = prijs;
        this.formattedTime = formattedTime;

    }

    public double berekenPrijs() {
        return prijs;
    }

    public String beginstation() {
        return beginstation;
    }

    public String eindstation() {
        return eindstation;
    }
}