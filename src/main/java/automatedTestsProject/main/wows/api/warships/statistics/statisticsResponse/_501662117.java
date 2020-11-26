
package automatedTestsProject.main.wows.api.warships.statistics.statisticsResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "pvp",
    "last_battle_time",
    "account_id",
    "distance",
    "updated_at",
    "battles",
    "ship_id",
    "private"
})
public class _501662117 {

    @JsonProperty("pvp")
    private Pvp pvp;
    @JsonProperty("last_battle_time")
    private Long lastBattleTime;
    @JsonProperty("account_id")
    private Long accountId;
    @JsonProperty("distance")
    private Long distance;
    @JsonProperty("updated_at")
    private Long updatedAt;
    @JsonProperty("battles")
    private Long battles;
    @JsonProperty("ship_id")
    private Long shipId;
    @JsonProperty("private")
    private Object _private;

    @JsonProperty("pvp")
    public Pvp getPvp() {
        return pvp;
    }

    @JsonProperty("pvp")
    public void setPvp(Pvp pvp) {
        this.pvp = pvp;
    }

    @JsonProperty("last_battle_time")
    public Long getLastBattleTime() {
        return lastBattleTime;
    }

    @JsonProperty("last_battle_time")
    public void setLastBattleTime(Long lastBattleTime) {
        this.lastBattleTime = lastBattleTime;
    }

    @JsonProperty("account_id")
    public Long getAccountId() {
        return accountId;
    }

    @JsonProperty("account_id")
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @JsonProperty("distance")
    public Long getDistance() {
        return distance;
    }

    @JsonProperty("distance")
    public void setDistance(Long distance) {
        this.distance = distance;
    }

    @JsonProperty("updated_at")
    public Long getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updated_at")
    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("battles")
    public Long getBattles() {
        return battles;
    }

    @JsonProperty("battles")
    public void setBattles(Long battles) {
        this.battles = battles;
    }

    @JsonProperty("ship_id")
    public Long getShipId() {
        return shipId;
    }

    @JsonProperty("ship_id")
    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    @JsonProperty("private")
    public Object getPrivate() {
        return _private;
    }

    @JsonProperty("private")
    public void setPrivate(Object _private) {
        this._private = _private;
    }

}
