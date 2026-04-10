public class reis {
    private String beginstation;
    private String eindstation;
    private double prijs;

    public reis(String beginstation, String eindstation, double prijs) {
        this.beginstation = beginstation;
        this.eindstation = eindstation;
        this.prijs = prijs;
    }

    public double berekenPrijs() {
        return prijs;
    }

    public String getBeginstation() {
        return beginstation;
    }

    public String getEindstation() {
        return eindstation;
    }
}