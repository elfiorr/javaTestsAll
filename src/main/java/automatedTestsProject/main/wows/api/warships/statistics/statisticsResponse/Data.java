
package automatedTestsProject.main.wows.api.warships.statistics.statisticsResponse;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "501662117"
})
public class Data {

    @JsonProperty("501662117")
    private List<automatedTestsProject.main.wows.api.warships.statistics.statisticsResponse._501662117> _501662117 = null;

    @JsonProperty("501662117")
    public List<automatedTestsProject.main.wows.api.warships.statistics.statisticsResponse._501662117> get501662117() {
        return _501662117;
    }

    @JsonProperty("501662117")
    public void set501662117(List<automatedTestsProject.main.wows.api.warships.statistics.statisticsResponse._501662117> _501662117) {
        this._501662117 = _501662117;
    }

}
