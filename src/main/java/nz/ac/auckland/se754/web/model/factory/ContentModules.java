package nz.ac.auckland.se754.web.model.factory;
import java.util.Date;

public abstract class ContentModules implements Module{
    long id;
    String name;
    String description;
    boolean isCompleted = false;

    Date startDate;

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    @Override
    public boolean isCompleted() {
        return isCompleted;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public String getDescription() {
        return description;
    }

    public Date getStartDate() {
        return startDate;
    }
}
