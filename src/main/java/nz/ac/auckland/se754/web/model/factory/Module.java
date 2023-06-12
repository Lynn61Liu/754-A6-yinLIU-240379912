package nz.ac.auckland.se754.web.model.factory;

public interface Module {
    void type();

    boolean isCompleted();

    long getId();

    String getName();

    String getDescription();
}
