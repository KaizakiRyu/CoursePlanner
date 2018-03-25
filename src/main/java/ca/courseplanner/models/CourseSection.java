package ca.courseplanner.models;
import java.util.ArrayList;

/**
 * Created by leom on 23/03/18.
 */
public class CourseSection {
    private String componentCode;
    private int enrolmentCapacity;
    private int enrolmentTotal;

    public CourseSection(CsvModel csvModel) {
        this.componentCode = csvModel.getComponentCode();
        this.enrolmentCapacity = Integer.parseInt(csvModel.getEnrolmentCapacity());
        this.enrolmentTotal = Integer.parseInt(csvModel.getEnrolmentTotal());
    }

    public String getComponentCode() {
        return componentCode;
    }

    public void setComponentCode(String componentCode) {
        this.componentCode = componentCode;
    }

    public int getEnrolmentCapacity() {
        return enrolmentCapacity;
    }

    public void setEnrolmentCapacity(int enrolmentCapacity) {
        this.enrolmentCapacity = enrolmentCapacity;
    }

    public int getEnrolmentTotal() {
        return enrolmentTotal;
    }

    public void setEnrolmentTotal(int enrolmentTotal) {
        this.enrolmentTotal = enrolmentTotal;
    }
}