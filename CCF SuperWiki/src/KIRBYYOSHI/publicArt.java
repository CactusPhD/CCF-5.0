package KIRBYYOSHI;

/**
 * Created by coola on 3/31/2017.
 */
public class publicArt {
    private double x, y;
    private double[] location = new double[2];
    private String venue;
    private String streetAddress;
    private String type;
    private String description;
    private String image;

    public publicArt() {
    }

    public publicArt(double x, double y, String venue, String streetAddress, String type,
                     String description, String image) {
        this.x = x;
        this.y = y;
        this.venue = venue;
        this.streetAddress = streetAddress;
        this.type = type;
        this.description = description;
        this.image = image;

    }

    private double getX() {
        return x;
    }

    private double getY() {
        return y;
    }

    public String getVenue() {
        return venue;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }
    public double[] createLocation(){
        location[0] = y;//latitude
        location[1] = x;//longitude
        return location;
    }

}
