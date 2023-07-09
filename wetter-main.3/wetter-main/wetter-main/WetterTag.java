


public class WetterTag {

    private String Tag;
    private double Temp;

    private String Description;


    public WetterTag(String tag, double temp, String description) {
        Tag = tag;
        Temp = temp;
        Description = description;
    }

    public String getTag() {
        return Tag;
    }
    public double getTemp() {
        return Temp;
    }

    public String getDate() {
        return Description;
    }

    public void setTag(String tag) {
        Tag = tag;
    }

    public void setTemp(double temp) {
        this.Temp = temp;
    }

    public void setDate(String date) {
        this.Description = date;
    }

    @Override
    public String toString() {
        return "Api{" +
                "Tag='" + Tag + '\'' +
                ", Temp='" + Temp + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}