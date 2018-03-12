package io.app.pi.data.model;

public class PoeDate {

    private String date;
    private String dateHans;

    public PoeDate(String date, String dateHans) {
        this.date = date;
        this.dateHans = dateHans;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateHans() {
        return dateHans;
    }

    public void setDateHans(String dateHans) {
        this.dateHans = dateHans;
    }

    @Override
    public String toString() {
        return "PoeDate{" +
                "date='" + date + '\'' +
                ", dateHans='" + dateHans + '\'' +
                '}';
    }
}