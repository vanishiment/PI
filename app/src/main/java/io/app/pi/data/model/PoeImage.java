package io.app.pi.data.model;

public class PoeImage {

    private String url;

    public PoeImage(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "PoeImage{" +
                "url='" + url + '\'' +
                '}';
    }
}