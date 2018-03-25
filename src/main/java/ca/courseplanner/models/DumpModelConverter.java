package ca.courseplanner.models;

import java.util.ArrayList;

/**
 * Created by leom on 23/03/18.
 */
public class DumpModelConverter {
    ArrayList<DumpModel> listOfConvertedModel;

    public ArrayList<DumpModel> getListOfConvertedModel() {
        return listOfConvertedModel;
    }

    public DumpModelConverter() {
        this.listOfConvertedModel = new ArrayList<>();
    }

    public void startConversion(ArrayList<CsvModel> listOfCsvModel){
        convertModel(listOfCsvModel);
    }

    private void convertModel(ArrayList<CsvModel> listOfCsvModel) {
        for (CsvModel currentModel : listOfCsvModel){
            DumpModel newModel = new DumpModel(currentModel);
            CourseOffering newOffering = new CourseOffering(currentModel);
            CourseSection newSection = new CourseSection(currentModel);
            if (containCourse(currentModel)){

            }
        }
    }

    public boolean containCourse(CsvModel csvModel){
        ArrayList<DumpModel> listOfDumpModel = getListOfConvertedModel();
        for (DumpModel currentModel : listOfDumpModel){
            if (currentModel.getSubject().equals(csvModel.getSubject()) && currentModel.getCatalogNumber().equals(csvModel.getSubject())){
                return true;
            }
        }
        return false;
    }
}
