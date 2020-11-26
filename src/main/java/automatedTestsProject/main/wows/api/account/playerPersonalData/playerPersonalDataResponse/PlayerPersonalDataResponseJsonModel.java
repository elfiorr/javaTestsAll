
package automatedTestsProject.main.wows.api.account.playerPersonalData.playerPersonalDataResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "meta",
    "data"
})
public class PlayerPersonalDataResponseJsonModel {

    @JsonProperty("status")
    private String status;
    @JsonProperty("meta")
    private automatedTestsProject.main.wows.api.account.playerPersonalData.playerPersonalDataResponse.Meta meta;
    @JsonProperty("data")
    private automatedTestsProject.main.wows.api.account.playerPersonalData.playerPersonalDataResponse.Data data;

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("meta")
    public automatedTestsProject.main.wows.api.account.playerPersonalData.playerPersonalDataResponse.Meta getMeta() {
        return meta;
    }

    @JsonProperty("meta")
    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    @JsonProperty("data")
    public automatedTestsProject.main.wows.api.account.playerPersonalData.playerPersonalDataResponse.Data getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Data data) {
        this.data = data;
    }

}
