package automatedTestsProject.main.exampleClassesForApi_Tp;

import automatedTestsProject.main.core.dataMappingConfig.DataConfig;
import automatedTestsProject.main.core.dataMappingConfig.ResourcesPathFactory;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import java.io.FileNotFoundException;

import static com.jayway.restassured.RestAssured.given;

public class CreateDirectM2mRequest {

    /**
     * @param idDistributor - this is the id from GetDetailsResponseJsonModel
     * @param idSaleChannel = this is the id of campaign from CampaignsResponseJsonModel
     * @return
     */
    public static Response responseFromClickGeneratingUrl(
            String idDistributor,
            String idSaleChannel
    ) {

        try {
            return createRequestSpecificationToDirect(idDistributor, idSaleChannel)
                    .when()
                    .get();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Unable to build request. Configuration variable not found in the specified file");
        }
    }

    private static RequestSpecification createRequestSpecificationToDirect(
            String idDistributor,
            String idSaleChannel
    ) throws FileNotFoundException {

        RestAssured.baseURI = DataConfig
                .getConnectionData(
                        ResourcesPathFactory.PATH_TO_URL,
                        "direct_m2m_url");

        return given()
                .proxy("10.3.76.14", 80)
                .header("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:62.0) Gecko/20100101 Firefox/62.0")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                .header("Accept-Language", "en-US,en;q=0.5")
                .header("Cookie", "directtrack=5b4327b9df678; gaVisitorUuid=9c6b76bc-db17-474c-824a-e6219f7af2c5; PWA_adbd=0; _ga=GA1.2.1942596938.1531127741; __gfp_64b=aXhlCyfri5syiC1Kiy3Du3PcZuSQ07nCiCevFJJrowT.q7; PWA_adbd=1")
                .header("Connection", "keep-alive")
                .header("Upgrade-Insecure-Requests", "1")
                .param("idSaleChannel", idSaleChannel)
                .param("idDistributor", idDistributor)
                .log()
                .all();
    }
}
