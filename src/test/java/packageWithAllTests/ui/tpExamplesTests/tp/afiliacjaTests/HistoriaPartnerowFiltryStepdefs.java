package packageWithAllTests.ui.tpExamplesTests.tp.afiliacjaTests;

import automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.affiliationPages.PartnerHistoryFiltersPage;
import automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.framePages.MainHeaderPage;
import packageWithAllTests.ui.tpExamplesTests.AbstractStepdefs;
import cucumber.api.Scenario;
import cucumber.api.java.en.Then;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.assertTrue;

public class HistoriaPartnerowFiltryStepdefs {

    private Scenario scenario;
    private AbstractStepdefs abstractStepdefs;
    private PartnerHistoryFiltersPage partnerHistoryFiltersPage;

    private static final String FEATURE_NAME = "Administracja Partnerami / Historia Partnerów";

    public HistoriaPartnerowFiltryStepdefs(AbstractStepdefs abstractStepdefs) {
        this.abstractStepdefs = abstractStepdefs;
        partnerHistoryFiltersPage = new PartnerHistoryFiltersPage(abstractStepdefs.getDriver());
    }

    @Before
    public void before(Scenario scenario)
    {
        this.scenario = scenario;
    }

    @After
    public void closeDriver() {
        if (scenario != null) {
            abstractStepdefs
                    .after(scenario);
        }
    }

    @Then("Widze przycisk Wyswietl w Historii Partnerow")
    public void widze_przycisk_wyswietl_w_historii_partnerow() {

        assertTrue(AbstractStepdefs.CHECK_ELEMENT_DISPLAY_MESSAGE,
                partnerHistoryFiltersPage
                        .isSubmitButtonDisplayed());
    }

    @Then("Widze przycisk Wyczysc w Historii Partnerow")
    public void widze_przycisk_wyczysc_w_historii_partnerow() {

        assertTrue(AbstractStepdefs.CHECK_ELEMENT_DISPLAY_MESSAGE,
                partnerHistoryFiltersPage
                        .isClearButtonDisplayed());
    }

    @Then("Widze przycisk Eksportuj CSV w Historii Partnerow")
    public void widze_przycisk_eksportuj_csv_W_historii_partnerow() {

        assertTrue(AbstractStepdefs.CHECK_ELEMENT_DISPLAY_MESSAGE,
                partnerHistoryFiltersPage
                        .isExportCsvDisplayed());
    }

    @Then("Widze Tytul zakladki Historia Partnerow")
    public void widze_tytul_zakladki_historia_partnerow() {

        assertTrue(AbstractStepdefs.CHECK_MAIN_TAB_TITLE_MESSAGE,
                new MainHeaderPage(abstractStepdefs.getDriver())
                        .getTabTitle()
                        .contains(FEATURE_NAME));
    }

    @Then("Widze input Data rejestracji od w Historia Partnerow")
    public void widze_input_data_rejestracji_od() {

        assertTrue(AbstractStepdefs.CHECK_ELEMENT_DISPLAY_MESSAGE,
                partnerHistoryFiltersPage
                        .isDateTimeStartInputDisplayed());
    }

    @Then("Widze input Data rejestracji do w Historia Partnerow")
    public void widze_input_data_rejestracji_do() {

        assertTrue(AbstractStepdefs.CHECK_ELEMENT_DISPLAY_MESSAGE,
                partnerHistoryFiltersPage
                        .isDateTimeEndInputDisplayed());
    }

    @Then("Widze selekt Okres w Historia Partnerow")
    public void widze_selekt_okres() {

        assertTrue(AbstractStepdefs.CHECK_ELEMENT_DISPLAY_MESSAGE,
                partnerHistoryFiltersPage
                        .isPeriodSelectDisplayed());
    }

    @Then("Widze input Partner w Historii Partnerow")
    public void widze_input_partner() {

        assertTrue(AbstractStepdefs.CHECK_ELEMENT_DISPLAY_MESSAGE,
                partnerHistoryFiltersPage
                        .isPartnerInputDisplayed());
    }

    @Then("Widze input Wykonane przez w Historia Partnerow")
    public void widze_input_wykonane_przez() {

        assertTrue(AbstractStepdefs.CHECK_ELEMENT_DISPLAY_MESSAGE,
                partnerHistoryFiltersPage
                        .isExecutorInputDisplayed());
    }

    @Then("Widze input Akcja w Historia Partnerow")
    public void widze_input_akcja() {

        assertTrue(AbstractStepdefs.CHECK_ELEMENT_DISPLAY_MESSAGE,
                partnerHistoryFiltersPage
                        .isEventNameInputDisplayed());
    }
}
