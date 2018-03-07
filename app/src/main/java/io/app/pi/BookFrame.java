package io.app.pi;


public class BookFrame {

    private String name;
    private String cover;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public String toString() {
        return "BookFrame{" +
                "name='" + name + '\'' +
                ", cover='" + cover + '\'' +
                '}';
    }
}
