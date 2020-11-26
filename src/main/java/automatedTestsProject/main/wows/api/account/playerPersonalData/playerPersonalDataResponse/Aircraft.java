
package automatedTestsProject.main.wows.api.account.playerPersonalData.playerPersonalDataResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "max_frags_battle",
    "frags",
    "max_frags_ship_id"
})
public class Aircraft {

    @JsonProperty("max_frags_battle")
    private Long maxFragsBattle;
    @JsonProperty("frags")
    private Long frags;
    @JsonProperty("max_frags_ship_id")
    private Long maxFragsShipId;

    @JsonProperty("max_frags_battle")
    public Long getMaxFragsBattle() {
        return maxFragsBattle;
    }

    @JsonProperty("max_frags_battle")
    public void setMaxFragsBattle(Long maxFragsBattle) {
        this.maxFragsBattle = maxFragsBattle;
    }

    @JsonProperty("frags")
    public Long getFrags() {
        return frags;
    }

    @JsonProperty("frags")
    public void setFrags(Long frags) {
        this.frags = frags;
    }

    @JsonProperty("max_frags_ship_id")
    public Long getMaxFragsShipId() {
        return maxFragsShipId;
    }

    @JsonProperty("max_frags_ship_id")
    public void setMaxFragsShipId(Long maxFragsShipId) {
        this.maxFragsShipId = maxFragsShipId;
    }

}
