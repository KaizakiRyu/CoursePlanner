package ca.courseplanner.models;

import java.util.ArrayList;

public class CourseBySubjectCatalogNumberSemesterLocation extends Course {
    private int semester;
    private String subject;
    private String catalogNumber;
    private String location;
    private ArrayList<ClassSession> classSession;
}
