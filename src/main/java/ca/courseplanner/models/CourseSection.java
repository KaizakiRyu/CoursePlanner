package ca.courseplanner.models;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by leom on 23/03/18.
 */
public class CourseSection {
    private String componentCode;
    private int enrolmentCapacity;
    private int enrolmentTotal;

    public CourseSection(CsvModel csvModel) {
        this.componentCode = csvModel.getComponentCode();
        this.enrolmentCapacity = Integer.valueOf(csvModel.getEnrolmentCapacity()).intValue();
        this.enrolmentTotal = Integer.valueOf(csvModel.getEnrolmentTotal()).intValue();
    }

    public String getComponentCode() {
        return componentCode;
    }

    public int getEnrolmentCapacity() {
        return enrolmentCapacity;
    }

    public void addEnrolmentCapacity(int enrolmentCapacity) {
        this.enrolmentCapacity += enrolmentCapacity;
    }

    public int getEnrolmentTotal() {
        return enrolmentTotal;
    }

    public void addEnrolmentTotal(int enrolmentTotal) {
        this.enrolmentTotal += enrolmentTotal;
    }

    public static Comparator<CourseSection> CourseSectionComparator = new Comparator<CourseSection>() {
        @Override
        public int compare(CourseSection courseSection1, CourseSection courseSection2) {
            int sectionCompare = courseSection1.getComponentCode().compareTo(courseSection2.getComponentCode());
            return sectionCompare;
        }
    };
}
