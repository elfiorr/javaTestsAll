package packageWithAllTests.ui.tpExamplesTests.tp.afiliacjaTests;

import automatedTestsProject.main.exampleClassesForUi_tp_m2m.tp.framePages.AffiliationSidebarMenuPage;
import packageWithAllTests.ui.tpExamplesTests.AbstractStepdefs;
import cucumber.api.Scenario;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Before;

public class HistoriaPartnerowStepdefs {

    private Scenario scenario;
    private AbstractStepdefs abstractStepdefs;

    public HistoriaPartnerowStepdefs(AbstractStepdefs abstractStepdefs) {
        this.abstractStepdefs = abstractStepdefs;
    }

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @After
    public void closeDriver() {
        if (scenario != null) {
            abstractStepdefs
                    .after(scenario);
        }
    }

    @When("Klikam w menu Afiliacja -> Historia Partnerow")
    public void klikam_w_menu_afiliacja_administracja_partnerami_historia_partnerow() {

        new AffiliationSidebarMenuPage(abstractStepdefs.getDriver())
                .clickPartnerHistory();
    }
}



