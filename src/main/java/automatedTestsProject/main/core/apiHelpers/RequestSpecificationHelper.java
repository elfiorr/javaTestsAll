package automatedTestsProject.main.core.apiHelpers;

import com.jayway.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;

public class RequestSpecificationHelper {

    public static RequestSpecification createRequestSpecificationWithParams(
            RequestSpecification requestSpecificationWithoutParams,
            HashMap <String, Object> mapOfParams
    ){

        RequestSpecification requestSpecification = requestSpecificationWithoutParams;

        for (String key: mapOfParams.keySet()) {

            requestSpecification
                    .param(key, mapOfParams.get(key));
        }

        return requestSpecification;

    }

    public static HashMap<String, Object> createMapBasedOfJSONObject(
            JSONObject jsonObject
    ) {

        Iterator<String> keys = jsonObject.keys();

        HashMap<String, Object> map = new HashMap<>();

        while (keys.hasNext()) {

            String key = keys.next();
            Object value = jsonObject.get(key);

            map.put(key, value);

        }

        return map;
    }

}
