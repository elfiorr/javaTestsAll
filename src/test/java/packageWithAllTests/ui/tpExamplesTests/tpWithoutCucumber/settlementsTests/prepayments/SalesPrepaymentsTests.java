//package PackageWithAllTests.TpExamplesTests.ui.tpWithoutCucumber.settlementsTests.prepayments;
//
//import AutomatedTestsProject.main.core.commonPages.LoadersPage;
//import AutomatedTestsProject.main.core.fileHelpers.CsvMaker;
//import AutomatedTestsProject.main.exampleClassesForApi_Tp.login.LoginOperations;
//import AutomatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.settlementsPages.prepaymentsPages.PrepaymentTypes;
//import AutomatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.settlementsPages.prepaymentsPages.PrepaymentsAlertsPage;
//import AutomatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.settlementsPages.prepaymentsPages.PrepaymentsFiltersPage;
//import AutomatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.settlementsPages.prepaymentsPages.PrepaymentsListPage;
//import PackageWithAllTests.TpExamplesTests.ui.tpWithoutCucumber.AbstractTest;
//import com.jayway.restassured.response.ValidatableResponse;
//import org.apache.log4j.Logger;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.WebDriverException;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import static PackageWithAllTests.TpExamplesTests.ui.AbstractStepdefs.RETURN_VALUE_MESSAGE;
//import static org.junit.Assert.*;
//import static org.junit.Assume.assumeTrue;
//
//public class SalesPrepaymentsTests extends AbstractTest {
//
//    private final PrepaymentTypes provisionType;
//    private final String dateOfSale;
//    private final boolean positiveScenario;
//    private StatsCampaignsTableResponseJsonModel statsCampaignsTableResponseJsonModel;
//    private int applicationId;
//    private Double payoutAmountForSettlements;
//    private String offererType;
//    private Double m2mSummaryValueResult;
//    private final String bearer;
//    private Boolean positiveSecondSettleScenario;
//    private PrepaymentTypes provisionTypeSecondSettle;
//    private StatsCampaignsTableResponseJsonModel responseFromStatsCampaignsTableResponseJsonModel;
//
//    private final PrepaymentsAlertsPage prepaymentsAlertsPage = new PrepaymentsAlertsPage(driver);
//    private final PrepaymentsFiltersPage prepaymentsFiltersPage = new PrepaymentsFiltersPage(driver);
//    private final PrepaymentsListPage prepaymentsListPage = new PrepaymentsListPage(driver);
//    private final LoadersPage loadersPage = new LoadersPage(driver);
//    private final CsvMaker csvMaker = new CsvMaker();
//
//    private static final Logger log = Logger.getLogger(SalesPrepaymentsTests.class);
//    private static final String DIVIDER = "";
//
//    public SalesPrepaymentsTests(
//            PrepaymentTypes provisionType,
//            String dateOfSale,
//            boolean positiveScenario
//    ) throws FileNotFoundException {
//        this.provisionType = provisionType;
//        this.dateOfSale = dateOfSale;
//        this.positiveScenario = positiveScenario;
//
//        this.bearer = new LoginOperations("PARTNER_WITH_80_THOUSANDS_CLICKS")
//                .getUserBearer();
//
//        setUp();
//    }
//
//    public SalesPrepaymentsTests(
//            PrepaymentTypes provisionType,
//            String dateOfSale,
//            boolean positiveScenario,
//            Boolean positiveSecondSettleScenario,
//            PrepaymentTypes provisionTypeSecondSettle
//    ) throws FileNotFoundException {
//        this.provisionType = provisionType;
//        this.dateOfSale = dateOfSale;
//        this.positiveScenario = positiveScenario;
//        this.positiveSecondSettleScenario = positiveSecondSettleScenario;
//        this.provisionTypeSecondSettle = provisionTypeSecondSettle;
//
//        this.bearer = new LoginOperations(PARTNER_WITH_80_THOUSANDS_CLICKS)
//                .getUserBearer();
//
//        setUp();
//    }
//
//    @AfterEach
//    public void after() {
//
//        driver.quit();
//    }
//
//    @Test
//    public void salesPrepaymentUploadTest() {
//
//        getPayoutAmountForSettlements();
//
//        loadersPage.waitToListSpinnerLoaderDisappear();
//
//        log.info(DIVIDER);
//        log.info(String.format("TEST STEP: Set provision type as: %s", provisionType));
//
//        prepaymentsFiltersPage
//                .setPrepaymentFormSaleTypeSelect(provisionType);
//
//        setValuesForPrepayment();
//
//        if (positiveScenario) {
//
//            assertThatSummaryAndApplicationsRowsDisplayed();
//            submitAndAssertSuccessAlert();
//            assertThatValuesAreCorrect();
//        } else {
//
//            assertThatDangerAlertDisplayed();
//        }
//
//        if (positiveSecondSettleScenario != null) {
//
//            getPayoutAmountForSettlements();
//
//            loadersPage.waitToListSpinnerLoaderDisappear();
//
//            log.info(DIVIDER);
//            log.info(String.format("TEST STEP: Set provision type as: %s", provisionTypeSecondSettle));
//
//            prepaymentsFiltersPage
//                    .setPrepaymentFormSaleTypeSelect(provisionTypeSecondSettle);
//
//            setValuesForPrepayment();
//
//            if (positiveSecondSettleScenario) {
//
//                assertThatSummaryAndApplicationsRowsDisplayed();
//                submitAndAssertSuccessAlert();
//                assertThatValuesAreCorrect();
//            } else {
//
//                assertThatDangerAlertDisplayed();
//            }
//        }
//    }
//
//    private StatsCampaignsTableResponseJsonModel getStatsCampaignsTableResponseJsonModel() {
//
//        log.info(DIVIDER);
//        log.info("INITIAL CONDITION: Get response from stats campaigns table.");
//
//        return getValidatableResponseFromCampaignsStatistic()
//                .extract()
//                .as(StatsCampaignsTableResponseJsonModel.class);
//    }
//
//    private ValidatableResponse getValidatableResponseFromCampaignsStatistic() {
//
//        String currentDate = new DateGenerator(DateFormat.DASH)
//                .getCurrentDate();
//
//        List<Integer> campaignToFilter = new PartnerInformation(bearer)
//                .getListOfIdsSaleChannel();
//
//        List<String> columns = new ArrayList<>();
//
//        columns.add("campaign");
//        columns.add("advertiser");
//        columns.add("applicationId");
//        columns.add("clicks");
//
//        return new StatsCampaignsTableOperations(
//                bearer,
//                new StatsCampaignsTableRequestJsonDataFactory()
//                        .getStatsCampaignsCustomColumnsTableRequestJsonModelWithCustomCampaigns(
//                                currentDate,
//                                currentDate,
//                                columns,
//                                campaignToFilter,
//                                "applicationId",
//                                "DESC"))
//                .getResponseFromStatsCampaignsTable()
//                .then()
//                .assertThat()
//                .log()
//                .all();
//    }
//
//    private Double getPayoutAmount() {
//
//        log.info(DIVIDER);
//        log.info("INITIAL CONDITION: Get payout amount.");
//
//        ValidatableResponse validatableResponse = new EarningsBasicInformationOperations(bearer)
//                .getResponseFromEarningsBasicInformation()
//                .then()
//                .assertThat();
//
//        EarningsBasicInformationResponseJsonModel earningsBasicInformationResponseJsonModel = validatableResponse
//                .log()
//                .all()
//                .extract()
//                .as(EarningsBasicInformationResponseJsonModel.class);
//
//        return earningsBasicInformationResponseJsonModel
//                .getPayoutAmount();
//    }
//
//    private void uploadCsvFile() {
//
//        log.info(DIVIDER);
//        log.info("TEST STEP: Upload CSV file.");
//
//        try {
//            prepaymentsFiltersPage
//                    .uploadCsvFile(
//                            USER_DIR
//                                    .concat("/")
//                                    .concat(TOTALPANEL_TARGET_CSV_RESOURCES_PATH)
//                                    .concat(FILE_NAME)
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
//    private void assertThatValuesAreCorrect() {
//
//        Double payoutAmountForSettlementAfterSettle;
//        payoutAmountForSettlementAfterSettle = getPayoutAmount();
//
//        log.info(DIVIDER);
//        log.info(String.format("INITIAL CONDITION: Multiply: \n" +
//                        "1. value from direct before settlements: %s * 100\n" +
//                        "2. value from direct after settlements: %s * 100\n" +
//                        "3. value from m2m table result: %s * 100\n",
//                        payoutAmountForSettlementAfterSettle,
//                payoutAmountForSettlements,
//                m2mSummaryValueResult));
//
//        Double valueFromDirectBeforeSettlements = payoutAmountForSettlements * 100;
//        Double valueFromDirectAfterSettlements = payoutAmountForSettlementAfterSettle * 100;
//        Double valueFromM2mTableResult = m2mSummaryValueResult * 100;
//
//        log.info(DIVIDER);
//        log.info(String.format("TEST DATA: After multiply: \n" +
//                "1. value from direct before settlements = %s\n" +
//                "2. value from direct after settlements = %s\n" +
//                "3. value from m2m table result: %s\n" +
//                "Sum of 'value before settlements' and 'm2m table result' = %s\n",
//                valueFromDirectAfterSettlements,
//                valueFromDirectBeforeSettlements,
//                valueFromM2mTableResult,
//                valueFromDirectBeforeSettlements.intValue() + valueFromM2mTableResult.intValue()));
//
//        int actualValue = valueFromDirectAfterSettlements.intValue();
//        int sumOfPayoutAmountBeforeSettlementsAndM2mSummaryValueResultFromTable = valueFromDirectBeforeSettlements.intValue() + valueFromM2mTableResult.intValue();
//
//        log.info(DIVIDER);
//        log.info(String.format("EXPECTED CONDITION: Assert that " +
//                        "sum of payout amount before settlements and value from m2m summary table: %s == " +
//                        "actual value: %s",
//                sumOfPayoutAmountBeforeSettlementsAndM2mSummaryValueResultFromTable,
//                actualValue));
//
//        assertEquals(RETURN_VALUE_MESSAGE,
//                sumOfPayoutAmountBeforeSettlementsAndM2mSummaryValueResultFromTable,
//                actualValue);
//    }
//
//    private String getAdvertiser() {
//
//        log.info(DIVIDER);
//        log.info("INITIAL CONDITION: Get advertiser.");
//
//        return responseFromStatsCampaignsTableResponseJsonModel
//                .getData()
//                .get(0)
//                .getAdvertiser();
//    }
//
//    private void generateClick() {
//
//        log.info(DIVIDER);
//        log.info(String.format("INITIAL CONDITION: Set distributor id as %s.", DISTRIBUTOR_ID_FOR_PARTNER_WITH_80_THOUSANDS_CLICKS));
//
//        log.info(DIVIDER);
//        log.info(String.format("INITIAL CONDITION: Set sale channel id as %s.", SALE_CHANNEL_ID_FOR_MBANK));
//
//        log.info(DIVIDER);
//        log.info("INITIAL CONDITION: Generate click.");
//
//        new DirectOperations()
//                .generateClick(DISTRIBUTOR_ID_FOR_PARTNER_WITH_80_THOUSANDS_CLICKS, SALE_CHANNEL_ID_FOR_MBANK);
//    }
//
//    private void createCsvFile() {
//
//        this.statsCampaignsTableResponseJsonModel = responseFromStatsCampaignsTableResponseJsonModel;
//
//        this.applicationId = statsCampaignsTableResponseJsonModel.getData().get(0).getApplicationId();
//
//        log.info(DIVIDER);
//        log.info(String.format("INITIAL CONDITION: First from list application id have value: %s",
//                applicationId
//        ));
//
//        List<Object[]> listOfCsvRows = new ArrayList<>();
//
//        listOfCsvRows.add(new Object[]{applicationId, 0, 0});
//
//        log.info(DIVIDER);
//        log.info("INITIAL CONDITION: Create CSV file.");
//
//        try {
//            csvMaker.csvWithObjects(listOfCsvRows, FILE_NAME, SALES_CSV_HEADERS);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void getPayoutAmountForSettlements() {
//
//        this.payoutAmountForSettlements = getPayoutAmount();
//
//        log.info(DIVIDER);
//        log.info(String.format("INITIAL CONDITION: Payout amount settlements have value: %s",
//                payoutAmountForSettlements
//        ));
//    }
//
//
//    private void setUp() {
//
//        generateClick();
//
//        this.responseFromStatsCampaignsTableResponseJsonModel = getStatsCampaignsTableResponseJsonModel();
//
//        this.offererType = getAdvertiser();
//
//        log.info(DIVIDER);
//        log.info(String.format("INITIAL CONDITION: Offerer have value: %s", offererType));
//
//        createCsvFile();
//
//        log.info(DIVIDER);
//        log.info("INITIAL CONDITION: Log to total panel.");
//
//        logToTotalpanel();
//
//        log.info(DIVIDER);
//        log.info("INITIAL CONDITION: Go to prepayment sidebar menu.");
//
//        new SettlementsSidebarMenuPage(driver)
//                .clickSalesPrepaymentSidebarMenu();
//    }
//
//    private void assertThatDangerAlertDisplayed() {
//
//        log.info(DIVIDER);
//        log.info("EXPECTED CONDITION: Assert that danger alert is displayed.");
//
//        assertTrue(CHECK_ELEMENT_DISPLAY_MESSAGE,
//                prepaymentsAlertsPage
//                        .isDangerAlertDisplayed());
//    }
//
//    private void setValuesForPrepayment() {
//
//        uploadCsvFile();
//
//        log.info(DIVIDER);
//        log.info(String.format("TEST STEP: Set offerer type as: %s",
//                offererType));
//
//        prepaymentsFiltersPage
//                .setPrepaymentFormOffererSelect(offererType);
//
//        log.info(DIVIDER);
//        log.info("TEST STEP: Choose first element from list prepayment product select.");
//
//        prepaymentsFiltersPage
//                .chooseFirstFromTheListPrepaymentFormProductSelect();
//
//        log.info(DIVIDER);
//        log.info(String.format("TEST STEP: Set date of sale as: %s",
//                dateOfSale));
//
//        prepaymentsFiltersPage
//                .setPrepaymentFormDateInput(dateOfSale);
//
//        log.info(DIVIDER);
//        log.info("TEST STEP: Submit search button.");
//
//        prepaymentsFiltersPage
//                .submitSearchForm();
//
//        loadersPage.waitToListSpinnerLoaderDisappear();
//    }
//
//    private void assertThatSummaryAndApplicationsRowsDisplayed() {
//
//        log.info(DIVIDER);
//        log.info("EXPECTED CONDITION: Assert that summary and application row is displayed.");
//
//        assertTrue(CHECK_ELEMENT_DISPLAY_MESSAGE,
//                prepaymentsListPage.isSummaryRowDisplayed() && prepaymentsListPage.isApplicationsRowDisplayed());
//    }
//
//    private void submitAndAssertSuccessAlert() {
//
//        this.m2mSummaryValueResult = prepaymentsListPage.getM2mSummaryValue();
//
//        log.info(DIVIDER);
//        log.info(String.format("TEST DATA: For field m2m in summary result table value = %s",
//                m2mSummaryValueResult
//        ));
//
//        log.info(DIVIDER);
//        log.info("TEST STEP: Submit upload button.");
//
//        prepaymentsListPage
//                .submitUploadForm();
//
//        log.info(DIVIDER);
//        log.info("EXPECTED CONDITION: Assert that success alert is displayed.");
//
//        assertTrue(CHECK_ELEMENT_DISPLAY_MESSAGE,
//                prepaymentsAlertsPage
//                        .isSuccessAlertDisplayed());
//
//        log.info(DIVIDER);
//        log.info("EXPECTED CONDITION: Assert that summary row is not displayed.");
//
//        assertFalse(CHECK_ELEMENT_DISPLAY_MESSAGE,
//                prepaymentsListPage
//                        .isSummaryRowDisplayed());
//    }
//}
