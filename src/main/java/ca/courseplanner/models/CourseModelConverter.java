package ca.courseplanner.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by leom on 23/03/18.
 */
public class CourseModelConverter {
    ArrayList<Course> listOfConvertedModel;

    public ArrayList<Course> getListOfConvertedModel() {
        return listOfConvertedModel;
    }

    public CourseModelConverter() {
        this.listOfConvertedModel = new ArrayList<>();
    }

    public void startConversion(ArrayList<CsvModel> listOfCsvModel){
        convertModel(listOfCsvModel);
    }

    private void convertModel(ArrayList<CsvModel> listOfCsvModel) {
        ArrayList<Course> convertModel = new ArrayList<>();
        for (CsvModel currentModel : listOfCsvModel){
            Course newModel = new Course(currentModel);
            convertModel.add(newModel);
        }

        convertModel = removeDuplicateSubjectCatalogNumber(convertModel);

        for (Course currentCourse: convertModel){
            for (CsvModel currentModel : listOfCsvModel){
                if (currentCourse.getSubject().equals(currentModel.getSubject()) && currentCourse.getCatalogNumber().equals(currentModel.getCatalogNumber())) {
                    CourseOffering courseOffering = new CourseOffering(currentModel);
                    CourseOffering currentCourseOffering = currentCourse.findCourseOffering(courseOffering);
                    if (currentCourseOffering != null) {
                        currentCourseOffering.addInstructor(currentModel.getInstructors());
                    } else {
                        currentCourse.addCourseOffering(courseOffering);
                    }
                    CourseSection courseSection = new CourseSection(currentModel);
                    CourseSection currentCourseSection = currentCourseOffering.findCourseSection(courseSection);
                }
            }
        }
    }


    private ArrayList<Course> removeDuplicateSubjectCatalogNumber(ArrayList<Course> oldModel){
        ArrayList<Course> converted = new ArrayList<>();
        Set<Course> removedDuplicate = new HashSet<>();
        removedDuplicate.addAll(oldModel);
        converted.clear();
        converted.addAll(removedDuplicate);
        return converted;
    }

    public boolean containCourse(CsvModel csvModel){
        ArrayList<Course> listOfCourse = getListOfConvertedModel();
        for (Course currentModel : listOfCourse){
            if (currentModel.getSubject().equals(csvModel.getSubject()) && currentModel.getCatalogNumber().equals(csvModel.getSubject())){
                return true;
            }
        }
        return false;
    }
}
