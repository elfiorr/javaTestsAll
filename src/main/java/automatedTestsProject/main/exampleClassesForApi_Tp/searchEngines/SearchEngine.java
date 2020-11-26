package automatedTestsProject.main.exampleClassesForApi_Tp.searchEngines;

import com.jayway.restassured.response.Response;
import java.util.List;

public abstract class SearchEngine<T> extends BasicSearchEngine{

    public abstract List<String> getListOfAllIdsInResponse();

    public abstract List<String> getListOfAllProductSlugsInResponse();

    public abstract Response getSearchEngineObject(
            String key,
            String value);

}
