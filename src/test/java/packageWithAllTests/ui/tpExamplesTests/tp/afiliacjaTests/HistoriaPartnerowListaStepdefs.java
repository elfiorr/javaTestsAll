package packageWithAllTests.ui.tpExamplesTests.tp.afiliacjaTests;

import automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.affiliationPages.PartnerHistoryListPage;
import packageWithAllTests.ui.tpExamplesTests.AbstractStepdefs;
import cucumber.api.Scenario;
import cucumber.api.java.en.Then;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.assertTrue;

public class HistoriaPartnerowListaStepdefs {

    private Scenario scenario;
    private AbstractStepdefs abstractStepdefs;
    private PartnerHistoryListPage partnerHistoryListPage;

    public HistoriaPartnerowListaStepdefs(AbstractStepdefs abstractStepdefs) {
        this.abstractStepdefs = abstractStepdefs;
        partnerHistoryListPage = new PartnerHistoryListPage(abstractStepdefs.getDriver());
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

    @Then("Widze kolumne Nazwa partnera")
    public void widze_kolumne_nazwa_partnera() {

        assertTrue(AbstractStepdefs.CHECK_ELEMENT_DISPLAY_MESSAGE,
                partnerHistoryListPage
                        .isPartnerNameColumnDisplayed());
    }

    @Then("Widze kolumne Akcja")
    public void widze_kolumne_akcja() {

        assertTrue(AbstractStepdefs.CHECK_ELEMENT_DISPLAY_MESSAGE,
                partnerHistoryListPage
                        .isEventNameColumnDisplayed());
    }

    @Then("Widze kolumne Wykonane przez")
    public void widze_kolumne_wykonane_przez() {

        assertTrue(AbstractStepdefs.CHECK_ELEMENT_DISPLAY_MESSAGE,
                partnerHistoryListPage
                        .isExecutorColumnDisplayed());
    }

    @Then("Widze kolumne Data akcji")
    public void widze_kolumne_Data_akcji() {

        assertTrue(AbstractStepdefs.CHECK_ELEMENT_DISPLAY_MESSAGE,
                partnerHistoryListPage
                        .isDateTimeColumnDisplayed());
    }

    @Then("Widze kolumne Adres IP")
    public void widze_kolumne_adres_ip() {

        assertTrue(AbstractStepdefs.CHECK_ELEMENT_DISPLAY_MESSAGE,
                partnerHistoryListPage
                        .isIpAddressColumnDisplayed());
    }

    @Then("Widze kolumne Szczegoly")
    public void widze_kolumne_szczegoly() {

        assertTrue(AbstractStepdefs.CHECK_ELEMENT_DISPLAY_MESSAGE,
                partnerHistoryListPage
                        .isDataColumnDisplayed());
    }
}
