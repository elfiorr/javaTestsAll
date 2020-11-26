//package packageWithAllTests.tpExamplesTests.ui.tpWithoutCucumber.report.reportConversion;
//
//import automatedTestsProject.main.core.fileHelpers.CsvMaker;
//import automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.reportsPages.FilterFieldsTypes;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UploadStatusAndFilterForInstitutionAndDateInReportTest extends ReportConversionTests {
//
//    private static final String INSTITUTION_VALUE = "Alior Bank";
//    private static final String ID_APPLICATION_VALUE = "10857374,10855107,10854199";
//    private static final String DATE_FROM_VALUE = "2010-01-01";
//    private static final boolean WITH_UPLOAD_CSV = true;
//
//    public UploadStatusAndFilterForInstitutionAndDateInReportTest() throws FileNotFoundException {
//        super(createCsvFile(),
//                INSTITUTION_VALUE,
//                listOfFilterValues(),
//                WITH_UPLOAD_CSV
//        );
//    }
//
//    private static List<Object[]> listOfFilterValues() {
//        List<Object[]> list = new ArrayList<>();
//
//        list.add(new Object[]{FilterFieldsTypes.INSTITUTION, INSTITUTION_VALUE});
//        list.add(new Object[]{FilterFieldsTypes.ID_APPLICATION, ID_APPLICATION_VALUE});
//        list.add(new Object[]{FilterFieldsTypes.DATE_FROM, DATE_FROM_VALUE});
//
//        return list;
//    }
//
//    private static final String createCsvFile() {
//
//        CsvMaker csvMaker = new CsvMaker();
//
//        List<Object[]> listOfCsvRows = new ArrayList<>();
//
//        String FILE_NAME = new Timestamp(System.currentTimeMillis())
//                .toString()
//                .replace(" ", "_")
//                .concat(".csv");
//
//        listOfCsvRows.add(new Object[]{10857374, "", "10857374".concat(TIMESTAMP)});
//        listOfCsvRows.add(new Object[]{10855107, "248010855107", "10855107".concat(TIMESTAMP)});
//        listOfCsvRows.add(new Object[]{10854199, "10854199", "10854199".concat(TIMESTAMP)});
//
////        try {
////            csvMaker.csvWithObjects(listOfCsvRows, FILE_NAME, SALES_CSV_HEADERS);
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//
//        return FILE_NAME;
//    }
//}
