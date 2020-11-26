
package automatedTestsProject.main.wows.api.warships.statistics.statisticsResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "max_xp",
    "damage_to_buildings",
    "main_battery",
    "suppressions_count",
    "max_damage_scouting",
    "art_agro",
    "ships_spotted",
    "second_battery",
    "xp",
    "survived_battles",
    "dropped_capture_points",
    "max_damage_dealt_to_buildings",
    "torpedo_agro",
    "draws",
    "battles_since_510",
    "planes_killed",
    "battles",
    "max_ships_spotted",
    "team_capture_points",
    "frags",
    "damage_scouting",
    "max_total_agro",
    "max_frags_battle",
    "capture_points",
    "ramming",
    "torpedoes",
    "aircraft",
    "survived_wins",
    "max_damage_dealt",
    "wins",
    "losses",
    "damage_dealt",
    "max_planes_killed",
    "max_suppressions_count",
    "team_dropped_capture_points",
    "battles_since_512"
})
public class Pvp {

    @JsonProperty("max_xp")
    private Long maxXp;
    @JsonProperty("damage_to_buildings")
    private Long damageToBuildings;
    @JsonProperty("main_battery")
    private MainBattery mainBattery;
    @JsonProperty("suppressions_count")
    private Long suppressionsCount;
    @JsonProperty("max_damage_scouting")
    private Long maxDamageScouting;
    @JsonProperty("art_agro")
    private Long artAgro;
    @JsonProperty("ships_spotted")
    private Long shipsSpotted;
    @JsonProperty("second_battery")
    private SecondBattery secondBattery;
    @JsonProperty("xp")
    private Long xp;
    @JsonProperty("survived_battles")
    private Long survivedBattles;
    @JsonProperty("dropped_capture_points")
    private Long droppedCapturePoints;
    @JsonProperty("max_damage_dealt_to_buildings")
    private Long maxDamageDealtToBuildings;
    @JsonProperty("torpedo_agro")
    private Long torpedoAgro;
    @JsonProperty("draws")
    private Long draws;
    @JsonProperty("battles_since_510")
    private Long battlesSince510;
    @JsonProperty("planes_killed")
    private Long planesKilled;
    @JsonProperty("battles")
    private Long battles;
    @JsonProperty("max_ships_spotted")
    private Long maxShipsSpotted;
    @JsonProperty("team_capture_points")
    private Long teamCapturePoints;
    @JsonProperty("frags")
    private Long frags;
    @JsonProperty("damage_scouting")
    private Long damageScouting;
    @JsonProperty("max_total_agro")
    private Long maxTotalAgro;
    @JsonProperty("max_frags_battle")
    private Long maxFragsBattle;
    @JsonProperty("capture_points")
    private Long capturePoints;
    @JsonProperty("ramming")
    private Ramming ramming;
    @JsonProperty("torpedoes")
    private Torpedoes torpedoes;
    @JsonProperty("aircraft")
    private Aircraft aircraft;
    @JsonProperty("survived_wins")
    private Long survivedWins;
    @JsonProperty("max_damage_dealt")
    private Long maxDamageDealt;
    @JsonProperty("wins")
    private Long wins;
    @JsonProperty("losses")
    private Long losses;
    @JsonProperty("damage_dealt")
    private Long damageDealt;
    @JsonProperty("max_planes_killed")
    private Long maxPlanesKilled;
    @JsonProperty("max_suppressions_count")
    private Long maxSuppressionsCount;
    @JsonProperty("team_dropped_capture_points")
    private Long teamDroppedCapturePoints;
    @JsonProperty("battles_since_512")
    private Long battlesSince512;

    @JsonProperty("max_xp")
    public Long getMaxXp() {
        return maxXp;
    }

    @JsonProperty("max_xp")
    public void setMaxXp(Long maxXp) {
        this.maxXp = maxXp;
    }

    @JsonProperty("damage_to_buildings")
    public Long getDamageToBuildings() {
        return damageToBuildings;
    }

    @JsonProperty("damage_to_buildings")
    public void setDamageToBuildings(Long damageToBuildings) {
        this.damageToBuildings = damageToBuildings;
    }

    @JsonProperty("main_battery")
    public MainBattery getMainBattery() {
        return mainBattery;
    }

    @JsonProperty("main_battery")
    public void setMainBattery(MainBattery mainBattery) {
        this.mainBattery = mainBattery;
    }

    @JsonProperty("suppressions_count")
    public Long getSuppressionsCount() {
        return suppressionsCount;
    }

    @JsonProperty("suppressions_count")
    public void setSuppressionsCount(Long suppressionsCount) {
        this.suppressionsCount = suppressionsCount;
    }

    @JsonProperty("max_damage_scouting")
    public Long getMaxDamageScouting() {
        return maxDamageScouting;
    }

    @JsonProperty("max_damage_scouting")
    public void setMaxDamageScouting(Long maxDamageScouting) {
        this.maxDamageScouting = maxDamageScouting;
    }

    @JsonProperty("art_agro")
    public Long getArtAgro() {
        return artAgro;
    }

    @JsonProperty("art_agro")
    public void setArtAgro(Long artAgro) {
        this.artAgro = artAgro;
    }

    @JsonProperty("ships_spotted")
    public Long getShipsSpotted() {
        return shipsSpotted;
    }

    @JsonProperty("ships_spotted")
    public void setShipsSpotted(Long shipsSpotted) {
        this.shipsSpotted = shipsSpotted;
    }

    @JsonProperty("second_battery")
    public SecondBattery getSecondBattery() {
        return secondBattery;
    }

    @JsonProperty("second_battery")
    public void setSecondBattery(SecondBattery secondBattery) {
        this.secondBattery = secondBattery;
    }

    @JsonProperty("xp")
    public Long getXp() {
        return xp;
    }

    @JsonProperty("xp")
    public void setXp(Long xp) {
        this.xp = xp;
    }

    @JsonProperty("survived_battles")
    public Long getSurvivedBattles() {
        return survivedBattles;
    }

    @JsonProperty("survived_battles")
    public void setSurvivedBattles(Long survivedBattles) {
        this.survivedBattles = survivedBattles;
    }

    @JsonProperty("dropped_capture_points")
    public Long getDroppedCapturePoints() {
        return droppedCapturePoints;
    }

    @JsonProperty("dropped_capture_points")
    public void setDroppedCapturePoints(Long droppedCapturePoints) {
        this.droppedCapturePoints = droppedCapturePoints;
    }

    @JsonProperty("max_damage_dealt_to_buildings")
    public Long getMaxDamageDealtToBuildings() {
        return maxDamageDealtToBuildings;
    }

    @JsonProperty("max_damage_dealt_to_buildings")
    public void setMaxDamageDealtToBuildings(Long maxDamageDealtToBuildings) {
        this.maxDamageDealtToBuildings = maxDamageDealtToBuildings;
    }

    @JsonProperty("torpedo_agro")
    public Long getTorpedoAgro() {
        return torpedoAgro;
    }

    @JsonProperty("torpedo_agro")
    public void setTorpedoAgro(Long torpedoAgro) {
        this.torpedoAgro = torpedoAgro;
    }

    @JsonProperty("draws")
    public Long getDraws() {
        return draws;
    }

    @JsonProperty("draws")
    public void setDraws(Long draws) {
        this.draws = draws;
    }

    @JsonProperty("battles_since_510")
    public Long getBattlesSince510() {
        return battlesSince510;
    }

    @JsonProperty("battles_since_510")
    public void setBattlesSince510(Long battlesSince510) {
        this.battlesSince510 = battlesSince510;
    }

    @JsonProperty("planes_killed")
    public Long getPlanesKilled() {
        return planesKilled;
    }

    @JsonProperty("planes_killed")
    public void setPlanesKilled(Long planesKilled) {
        this.planesKilled = planesKilled;
    }

    @JsonProperty("battles")
    public Long getBattles() {
        return battles;
    }

    @JsonProperty("battles")
    public void setBattles(Long battles) {
        this.battles = battles;
    }

    @JsonProperty("max_ships_spotted")
    public Long getMaxShipsSpotted() {
        return maxShipsSpotted;
    }

    @JsonProperty("max_ships_spotted")
    public void setMaxShipsSpotted(Long maxShipsSpotted) {
        this.maxShipsSpotted = maxShipsSpotted;
    }

    @JsonProperty("team_capture_points")
    public Long getTeamCapturePoints() {
        return teamCapturePoints;
    }

    @JsonProperty("team_capture_points")
    public void setTeamCapturePoints(Long teamCapturePoints) {
        this.teamCapturePoints = teamCapturePoints;
    }

    @JsonProperty("frags")
    public Long getFrags() {
        return frags;
    }

    @JsonProperty("frags")
    public void setFrags(Long frags) {
        this.frags = frags;
    }

    @JsonProperty("damage_scouting")
    public Long getDamageScouting() {
        return damageScouting;
    }

    @JsonProperty("damage_scouting")
    public void setDamageScouting(Long damageScouting) {
        this.damageScouting = damageScouting;
    }

    @JsonProperty("max_total_agro")
    public Long getMaxTotalAgro() {
        return maxTotalAgro;
    }

    @JsonProperty("max_total_agro")
    public void setMaxTotalAgro(Long maxTotalAgro) {
        this.maxTotalAgro = maxTotalAgro;
    }

    @JsonProperty("max_frags_battle")
    public Long getMaxFragsBattle() {
        return maxFragsBattle;
    }

    @JsonProperty("max_frags_battle")
    public void setMaxFragsBattle(Long maxFragsBattle) {
        this.maxFragsBattle = maxFragsBattle;
    }

    @JsonProperty("capture_points")
    public Long getCapturePoints() {
        return capturePoints;
    }

    @JsonProperty("capture_points")
    public void setCapturePoints(Long capturePoints) {
        this.capturePoints = capturePoints;
    }

    @JsonProperty("ramming")
    public Ramming getRamming() {
        return ramming;
    }

    @JsonProperty("ramming")
    public void setRamming(Ramming ramming) {
        this.ramming = ramming;
    }

    @JsonProperty("torpedoes")
    public Torpedoes getTorpedoes() {
        return torpedoes;
    }

    @JsonProperty("torpedoes")
    public void setTorpedoes(Torpedoes torpedoes) {
        this.torpedoes = torpedoes;
    }

    @JsonProperty("aircraft")
    public Aircraft getAircraft() {
        return aircraft;
    }

    @JsonProperty("aircraft")
    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    @JsonProperty("survived_wins")
    public Long getSurvivedWins() {
        return survivedWins;
    }

    @JsonProperty("survived_wins")
    public void setSurvivedWins(Long survivedWins) {
        this.survivedWins = survivedWins;
    }

    @JsonProperty("max_damage_dealt")
    public Long getMaxDamageDealt() {
        return maxDamageDealt;
    }

    @JsonProperty("max_damage_dealt")
    public void setMaxDamageDealt(Long maxDamageDealt) {
        this.maxDamageDealt = maxDamageDealt;
    }

    @JsonProperty("wins")
    public Long getWins() {
        return wins;
    }

    @JsonProperty("wins")
    public void setWins(Long wins) {
        this.wins = wins;
    }

    @JsonProperty("losses")
    public Long getLosses() {
        return losses;
    }

    @JsonProperty("losses")
    public void setLosses(Long losses) {
        this.losses = losses;
    }

    @JsonProperty("damage_dealt")
    public Long getDamageDealt() {
        return damageDealt;
    }

    @JsonProperty("damage_dealt")
    public void setDamageDealt(Long damageDealt) {
        this.damageDealt = damageDealt;
    }

    @JsonProperty("max_planes_killed")
    public Long getMaxPlanesKilled() {
        return maxPlanesKilled;
    }

    @JsonProperty("max_planes_killed")
    public void setMaxPlanesKilled(Long maxPlanesKilled) {
        this.maxPlanesKilled = maxPlanesKilled;
    }

    @JsonProperty("max_suppressions_count")
    public Long getMaxSuppressionsCount() {
        return maxSuppressionsCount;
    }

    @JsonProperty("max_suppressions_count")
    public void setMaxSuppressionsCount(Long maxSuppressionsCount) {
        this.maxSuppressionsCount = maxSuppressionsCount;
    }

    @JsonProperty("team_dropped_capture_points")
    public Long getTeamDroppedCapturePoints() {
        return teamDroppedCapturePoints;
    }

    @JsonProperty("team_dropped_capture_points")
    public void setTeamDroppedCapturePoints(Long teamDroppedCapturePoints) {
        this.teamDroppedCapturePoints = teamDroppedCapturePoints;
    }

    @JsonProperty("battles_since_512")
    public Long getBattlesSince512() {
        return battlesSince512;
    }

    @JsonProperty("battles_since_512")
    public void setBattlesSince512(Long battlesSince512) {
        this.battlesSince512 = battlesSince512;
    }

}
