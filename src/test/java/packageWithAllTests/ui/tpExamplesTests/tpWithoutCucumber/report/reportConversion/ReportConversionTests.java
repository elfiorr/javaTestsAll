//package packageWithAllTests.tpExamplesTests.ui.tpWithoutCucumber.report.reportConversion;
//
//import automatedTestsProject.main.core.commonPages.LoadersPage;
//import automatedTestsProject.main.core.generators.DateFormat;
//import automatedTestsProject.main.core.generators.DateGenerator;
//import automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.framePages.ReportsSidebarMenuPage;
//import automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.framePages.SettlementsSidebarMenuPage;
//import automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.reportsPages.ReportConversionFiltersPage;
//import automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.reportsPages.ReportConversionListPage;
//import automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.settlementsPages.prepaymentsPages.PrepaymentsAlertsPage;
//import automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.settlementsPages.prepaymentsPages.PrepaymentsListPage;
//import automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.settlementsPages.statusPages.SalesStatusFiltersPage;
//import automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.settlementsPages.statusPages.SalesStatusListPage;
//import packageWithAllTests.tpExamplesTests.ui.tpWithoutCucumber.AbstractTest;
//import org.apache.log4j.Logger;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriverException;
//import packageWithAllTests.tpExamplesTests.ui.AbstractStepdefs;
//
//import java.io.FileNotFoundException;
//import java.util.List;
//
//import static automatedTestsProject.main.core.dataMappingConfig.ResourcesPathFactory.USER_DIR;
//import static org.junit.Assert.assertTrue;
//import static org.junit.Assume.assumeTrue;
//
//public class ReportConversionTests extends AbstractTest {
//
//    private String institution;
//    private String pathToFile;
//    private LoadersPage loadersPage = new LoadersPage(driver);
//    private boolean uploadCsvScenario;
//    private List<Object[]> listOfFiltersFieldsToSetWithCustomData;
//    private SalesStatusFiltersPage salesStatusFiltersPage = new SalesStatusFiltersPage(driver);
//    private SalesStatusListPage salesStatusListPage = new SalesStatusListPage(driver);
//    private ReportConversionFiltersPage reportConversionFiltersPage = new ReportConversionFiltersPage(driver);
//    protected static final String TIMESTAMP = new DateGenerator(DateFormat.WITHOUT_SEPARATOR).getCurrentDate();
//    private static final Logger logger = Logger.getLogger(ReportConversionTests.class);
//
//    public ReportConversionTests(
//            String pathToFile,
//            String institution,
//            List<Object[]> listOfFiltersFieldsToSetWithCustomData,
//            boolean uploadCsvScenario
//    ) throws FileNotFoundException {
//        this.pathToFile = pathToFile;
//        this.institution = institution;
//        this.listOfFiltersFieldsToSetWithCustomData = listOfFiltersFieldsToSetWithCustomData;
//        this.uploadCsvScenario = uploadCsvScenario;
//
////        logToTotalpanel();
//
//        uploadStatusInOrderToCorrectlyDisplayDynamicDataGeneration();
//
//        assumeTrue(AbstractStepdefs.CHECK_ELEMENT_DISPLAY_MESSAGE,
//                new PrepaymentsAlertsPage(driver)
//                        .isSuccessAlertDisplayed());
//    }
//
//    public ReportConversionTests(
//            List<Object[]> listOfFiltersFieldsToSetWithCustomData,
//            boolean uploadCsvScenario
//    ) throws FileNotFoundException {
//        this.listOfFiltersFieldsToSetWithCustomData = listOfFiltersFieldsToSetWithCustomData;
//        this.uploadCsvScenario = uploadCsvScenario;
//
////        logToTotalpanel();
//    }
//
//    @BeforeEach
//    public void setUp() {
//
//        new ReportsSidebarMenuPage(driver)
//                .clickReportConversionSidebarMenu();
//    }
//
//    @AfterEach
//    public void after() {
//
//        driver.quit();
//    }
//
//    @Test
//    public void uploadStatusAndSearchForResultInTheConversionReport() {
//
////        fillFieldsAndSubmit();
//
//        if (uploadCsvScenario) {
//
//            assertTrue(AbstractStepdefs.CHECK_ELEMENT_DISPLAY_MESSAGE,
//                    areExternalStatusCorrectlyUpload(String.valueOf(TIMESTAMP)));
//        } else {
//
//            assertTrue(AbstractStepdefs.CHECK_ELEMENT_DISPLAY_MESSAGE,
//                    new ReportConversionListPage(driver)
//                            .isFirstExistingColumnDisplayed());
//        }
//    }
//
//    private void uploadFile() {
//
//        try {
//            salesStatusFiltersPage
//                    .uploadFile(
//                            USER_DIR
//                                    .concat("/")
//                                    .concat("PATH")
//                                    .concat(pathToFile)
//                    );
//        } catch (WebDriverException e) {
//
//            e.getMessage();
//
//            assumeTrue(UPLOAD_FILE_EXCEPTION_RESPONSE,
//                    System.getProperty("REMOTE_RUN_MODE") == null);
//        }
//    }
//
//    private boolean areExternalStatusCorrectlyUpload(String externalStatus) {
//
//        boolean isExternalStatusCorrect = true;
//
//        for (int i = 1; i <= 3; i++) {
//
//            String idApplication = driver.findElement(By.xpath(String.format("//table[@id='dtVerticalScrollExample']//tbody//tr[%d]//td[1]", i))).getText();
//            String extendedApplicationStatus = driver.findElement(By.xpath(String.format("//table[@id='dtVerticalScrollExample']//tbody//tr[%d]//td[5]", i))).getText();
//
//            boolean status = idApplication.concat(externalStatus).equals(extendedApplicationStatus);
//
//            if (!status) {
//
//                isExternalStatusCorrect = false;
//                logger.error(String.format("Status is incorrect for idApplication: %s", idApplication));
//            }
//        }
//
//        return isExternalStatusCorrect;
//    }
//
////    private void fillFieldsAndSubmit() {
////
////        for (Object[] filterTypeAndValue : listOfFiltersFieldsToSetWithCustomData) {
////
////            FilterFieldsTypes filtersFieldType = (FilterFieldsTypes) filterTypeAndValue[0];
////            String filtersFieldValue = (String) filterTypeAndValue[1];
////
////            reportConversionFiltersPage
////                    .setFilterFieldValue(
////                            filtersFieldType,
////                            filtersFieldValue);
////        }
////
////        reportConversionFiltersPage
////                .submitSearchForm(ShowFormButtonsTypes.SHOW);
////
////        loadersPage.waitToListSpinnerLoaderDisappear();
////    }
//
//    private void uploadStatusInOrderToCorrectlyDisplayDynamicDataGeneration() {
//
//        new SettlementsSidebarMenuPage(driver)
//                .clickSalesStatusSidebarMenu();
//
//        loadersPage.waitToListSpinnerLoaderDisappear();
//
//        salesStatusFiltersPage
//                .setOffererSelect(institution);
//
//        uploadFile();
//
//        salesStatusFiltersPage
//                .submitSearchForm();
//
//        assumeTrue(AbstractStepdefs.CHECK_ELEMENT_DISPLAY_MESSAGE,
//                salesStatusListPage
//                        .isSummaryRowIsDisplayed());
//
//        new PrepaymentsListPage(driver)
//                .submitUploadForm();
//    }
//}
