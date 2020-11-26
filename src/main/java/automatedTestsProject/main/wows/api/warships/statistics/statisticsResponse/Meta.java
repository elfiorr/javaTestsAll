
package automatedTestsProject.main.wows.api.warships.statistics.statisticsResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "count",
    "hidden"
})
public class Meta {

    @JsonProperty("count")
    private Long count;
    @JsonProperty("hidden")
    private Object hidden;

    @JsonProperty("count")
    public Long getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(Long count) {
        this.count = count;
    }

    @JsonProperty("hidden")
    public Object getHidden() {
        return hidden;
    }

    @JsonProperty("hidden")
    public void setHidden(Object hidden) {
        this.hidden = hidden;
    }

}
