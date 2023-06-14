


public class WetterTag {

    private String Tag;
    private String Temp;

    private String Date;


    public WetterTag(String tag, String temp, String date) {
        Tag = tag;
        Temp = temp;
        Date = date;
    }

    public String getTag() {
        return Tag;
    }
    public String getTemp() {
        return Temp;
    }

    public String getDate() {
        return Date;
    }

    public void setTag(String tag) {
        Tag = tag;
    }

    public void setTemp(String temp) {
        this.Temp = temp;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    @Override
    public String toString() {
        return "Api{" +
                "Tag='" + Tag + '\'' +
                ", Temp='" + Temp + '\'' +
                ", Date='" + Date + '\'' +
                '}';
    }
}
