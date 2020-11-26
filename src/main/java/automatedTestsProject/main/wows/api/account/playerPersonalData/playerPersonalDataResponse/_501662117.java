
package automatedTestsProject.main.wows.api.account.playerPersonalData.playerPersonalDataResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "last_battle_time",
    "account_id",
    "leveling_tier",
    "created_at",
    "leveling_points",
    "updated_at",
    "private",
    "hidden_profile",
    "logout_at",
    "karma",
    "statistics",
    "nickname",
    "stats_updated_at"
})
public class _501662117 {

    @JsonProperty("last_battle_time")
    private Long lastBattleTime;
    @JsonProperty("account_id")
    private Long accountId;
    @JsonProperty("leveling_tier")
    private Long levelingTier;
    @JsonProperty("created_at")
    private Long createdAt;
    @JsonProperty("leveling_points")
    private Long levelingPoints;
    @JsonProperty("updated_at")
    private Long updatedAt;
    @JsonProperty("private")
    private Object _private;
    @JsonProperty("hidden_profile")
    private Boolean hiddenProfile;
    @JsonProperty("logout_at")
    private Long logoutAt;
    @JsonProperty("karma")
    private Object karma;
    @JsonProperty("statistics")
    private Statistics statistics;
    @JsonProperty("nickname")
    private String nickname;
    @JsonProperty("stats_updated_at")
    private Long statsUpdatedAt;

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

    @JsonProperty("leveling_tier")
    public Long getLevelingTier() {
        return levelingTier;
    }

    @JsonProperty("leveling_tier")
    public void setLevelingTier(Long levelingTier) {
        this.levelingTier = levelingTier;
    }

    @JsonProperty("created_at")
    public Long getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("leveling_points")
    public Long getLevelingPoints() {
        return levelingPoints;
    }

    @JsonProperty("leveling_points")
    public void setLevelingPoints(Long levelingPoints) {
        this.levelingPoints = levelingPoints;
    }

    @JsonProperty("updated_at")
    public Long getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updated_at")
    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("private")
    public Object getPrivate() {
        return _private;
    }

    @JsonProperty("private")
    public void setPrivate(Object _private) {
        this._private = _private;
    }

    @JsonProperty("hidden_profile")
    public Boolean getHiddenProfile() {
        return hiddenProfile;
    }

    @JsonProperty("hidden_profile")
    public void setHiddenProfile(Boolean hiddenProfile) {
        this.hiddenProfile = hiddenProfile;
    }

    @JsonProperty("logout_at")
    public Long getLogoutAt() {
        return logoutAt;
    }

    @JsonProperty("logout_at")
    public void setLogoutAt(Long logoutAt) {
        this.logoutAt = logoutAt;
    }

    @JsonProperty("karma")
    public Object getKarma() {
        return karma;
    }

    @JsonProperty("karma")
    public void setKarma(Object karma) {
        this.karma = karma;
    }

    @JsonProperty("statistics")
    public Statistics getStatistics() {
        return statistics;
    }

    @JsonProperty("statistics")
    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    @JsonProperty("nickname")
    public String getNickname() {
        return nickname;
    }

    @JsonProperty("nickname")
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @JsonProperty("stats_updated_at")
    public Long getStatsUpdatedAt() {
        return statsUpdatedAt;
    }

    @JsonProperty("stats_updated_at")
    public void setStatsUpdatedAt(Long statsUpdatedAt) {
        this.statsUpdatedAt = statsUpdatedAt;
    }

}
