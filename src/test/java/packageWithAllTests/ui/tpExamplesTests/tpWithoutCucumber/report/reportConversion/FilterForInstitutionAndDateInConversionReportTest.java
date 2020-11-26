//package packageWithAllTests.tpExamplesTests.ui.tpWithoutCucumber.report.reportConversion;
//
//import automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.reportsPages.FilterFieldsTypes;
//
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class FilterForInstitutionAndDateInConversionReportTest extends ReportConversionTests{
//
//    private static final String INSTITUTION_VALUE = "Alior Bank";
//    private static final String DATE_FROM_VALUE = "2010-01-01";
//    private static final boolean WITH_UPLOAD_CSV = false;
//
//    public FilterForInstitutionAndDateInConversionReportTest() throws FileNotFoundException {
//        super(listOfFilterValues(), WITH_UPLOAD_CSV);
//    }
//
//    private static List<Object[]> listOfFilterValues(){
//        List<Object[]> list = new ArrayList<>();
//
//        list.add(new Object[]{FilterFieldsTypes.INSTITUTION, INSTITUTION_VALUE});
//        list.add(new Object[]{FilterFieldsTypes.DATE_FROM, DATE_FROM_VALUE});
//
//        return list;
//    }
//}
