package nz.ac.auckland.se754.web.model.factory;

import java.util.HashMap;
import java.util.Map;

public class Enrolment {
    String userID;

    //1 means that the course is fully completed, 0 means that nothing in the course is completed
    Map<Course, Float> progress;

    public Enrolment(String userID) {
        this.userID = userID;
        this.progress = new HashMap<Course, Float>();
    }

    public Enrolment() {
        this.userID = "UNASSIGNED";
    }

    public Map<Course, Float> getEnrolledCourses() {
        return progress;
    }

    public String getUserID() {
        return this.userID;
    }

    public void setEnrolledCourses(Map<Course, Float> progress) {
        this.progress = progress;
    }

    public void setEnrolledCourseProgress(Course course, Float progress) {
        this.progress.put(course, progress);
    }

    public Float getProgress(Course course) {
        return progress.get(course);
    }
}
