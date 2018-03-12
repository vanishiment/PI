package io.app.pi.data;


public class Poetry {

    private String title;
    private String dynasty;
    private String author;
    private String content;
    private String note;
    private String appreciate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAppreciate() {
        return appreciate;
    }

    public void setAppreciate(String appreciate) {
        this.appreciate = appreciate;
    }

    @Override
    public String toString() {
        return "Poetry{" +
                "title='" + title + '\'' +
                ", dynasty='" + dynasty + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", note='" + note + '\'' +
                ", appreciate='" + appreciate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Poetry poetry = (Poetry) o;

        if (title != null ? !title.equals(poetry.title) : poetry.title != null) return false;
        if (dynasty != null ? !dynasty.equals(poetry.dynasty) : poetry.dynasty != null)
            return false;
        if (author != null ? !author.equals(poetry.author) : poetry.author != null) return false;
        if (content != null ? !content.equals(poetry.content) : poetry.content != null)
            return false;
        if (note != null ? !note.equals(poetry.note) : poetry.note != null) return false;
        return appreciate != null ? appreciate.equals(poetry.appreciate) : poetry.appreciate == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (dynasty != null ? dynasty.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (appreciate != null ? appreciate.hashCode() : 0);
        return result;
    }
}
