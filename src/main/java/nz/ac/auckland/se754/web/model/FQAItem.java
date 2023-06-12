package nz.ac.auckland.se754.web.model;


import java.util.Objects;

public class FQAItem {
    private int id;
    private String title;
    private String text;

    public FQAItem(int id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title=title;
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text=text;
    }


}