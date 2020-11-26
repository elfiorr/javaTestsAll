
package automatedTestsProject.main.wows.api.account.playerPersonalData.playerPersonalDataResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "distance",
    "battles",
    "pvp"
})
public class Statistics {

    @JsonProperty("distance")
    private Long distance;
    @JsonProperty("battles")
    private Long battles;
    @JsonProperty("pvp")
    private automatedTestsProject.main.wows.api.account.playerPersonalData.playerPersonalDataResponse.Pvp pvp;

    @JsonProperty("distance")
    public Long getDistance() {
        return distance;
    }

    @JsonProperty("distance")
    public void setDistance(Long distance) {
        this.distance = distance;
    }

    @JsonProperty("battles")
    public Long getBattles() {
        return battles;
    }

    @JsonProperty("battles")
    public void setBattles(Long battles) {
        this.battles = battles;
    }

    @JsonProperty("pvp")
    public automatedTestsProject.main.wows.api.account.playerPersonalData.playerPersonalDataResponse.Pvp getPvp() {
        return pvp;
    }

    @JsonProperty("pvp")
    public void setPvp(Pvp pvp) {
        this.pvp = pvp;
    }

}
