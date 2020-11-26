//package packageWithAllTests.tpExamplesTests.ui.tpWithoutCucumber.report.reportConversion;
//
//import automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.reportsPages.FilterFieldsTypes;
//
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class FilterForPartnerInConversionReportTest extends ReportConversionTests{
//
//    private static final String PARTNER_VALUE = "Osiemdziestat Tyysiecy";
//    private static final boolean WITH_UPLOAD_CSV = false;
//
//    public FilterForPartnerInConversionReportTest() throws FileNotFoundException {
//        super(listOfFilterValues(), WITH_UPLOAD_CSV);
//    }
//
//    private static List<Object[]> listOfFilterValues(){
//        List<Object[]> list = new ArrayList<>();
//
//        list.add(new Object[]{FilterFieldsTypes.PARTNER, PARTNER_VALUE});
//
//        return list;
//    }
//}
