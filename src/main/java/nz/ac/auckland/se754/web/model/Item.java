package nz.ac.auckland.se754.web.model;


import java.util.Map;
import java.util.Objects;

public class Item {
    private int id;
    private String name;

    private Map<String, Boolean> answers;

    public Item(int id, String name, Map<String, Boolean> answers) {
        this.id = id;
        this.name = name;
        this.answers = answers;
    }

    public Map<String, Boolean> getAnswers() {
        return answers;
    }

    public String getCorrectness(String answer) {
        return answers.get(answer) ? "correct" : "incorrect";
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Course{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}