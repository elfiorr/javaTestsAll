
package automatedTestsProject.main.wows.api.account.playerPersonalData.playerPersonalDataResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "max_xp",
    "damage_to_buildings",
    "main_battery",
    "max_ships_spotted_ship_id",
    "max_damage_scouting",
    "art_agro",
    "max_xp_ship_id",
    "ships_spotted",
    "second_battery",
    "max_frags_ship_id",
    "xp",
    "survived_battles",
    "dropped_capture_points",
    "max_damage_dealt_to_buildings",
    "torpedo_agro",
    "draws",
    "control_captured_points",
    "battles_since_510",
    "max_total_agro_ship_id",
    "planes_killed",
    "battles",
    "max_ships_spotted",
    "max_suppressions_ship_id",
    "survived_wins",
    "frags",
    "damage_scouting",
    "max_total_agro",
    "max_frags_battle",
    "capture_points",
    "ramming",
    "suppressions_count",
    "max_suppressions_count",
    "torpedoes",
    "max_planes_killed_ship_id",
    "aircraft",
    "team_capture_points",
    "control_dropped_points",
    "max_damage_dealt",
    "max_damage_dealt_to_buildings_ship_id",
    "max_damage_dealt_ship_id",
    "wins",
    "losses",
    "damage_dealt",
    "max_planes_killed",
    "max_scouting_damage_ship_id",
    "team_dropped_capture_points",
    "battles_since_512"
})
public class Pvp {

    @JsonProperty("max_xp")
    private Long maxXp;
    @JsonProperty("damage_to_buildings")
    private Long damageToBuildings;
    @JsonProperty("main_battery")
    private automatedTestsProject.main.wows.api.account.playerPersonalData.playerPersonalDataResponse.MainBattery mainBattery;
    @JsonProperty("max_ships_spotted_ship_id")
    private Long maxShipsSpottedShipId;
    @JsonProperty("max_damage_scouting")
    private Long maxDamageScouting;
    @JsonProperty("art_agro")
    private Long artAgro;
    @JsonProperty("max_xp_ship_id")
    private Long maxXpShipId;
    @JsonProperty("ships_spotted")
    private Long shipsSpotted;
    @JsonProperty("second_battery")
    private SecondBattery secondBattery;
    @JsonProperty("max_frags_ship_id")
    private Long maxFragsShipId;
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
    @JsonProperty("control_captured_points")
    private Long controlCapturedPoints;
    @JsonProperty("battles_since_510")
    private Long battlesSince510;
    @JsonProperty("max_total_agro_ship_id")
    private Long maxTotalAgroShipId;
    @JsonProperty("planes_killed")
    private Long planesKilled;
    @JsonProperty("battles")
    private Long battles;
    @JsonProperty("max_ships_spotted")
    private Long maxShipsSpotted;
    @JsonProperty("max_suppressions_ship_id")
    private Object maxSuppressionsShipId;
    @JsonProperty("survived_wins")
    private Long survivedWins;
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
    @JsonProperty("suppressions_count")
    private Long suppressionsCount;
    @JsonProperty("max_suppressions_count")
    private Long maxSuppressionsCount;
    @JsonProperty("torpedoes")
    private Torpedoes torpedoes;
    @JsonProperty("max_planes_killed_ship_id")
    private Long maxPlanesKilledShipId;
    @JsonProperty("aircraft")
    private automatedTestsProject.main.wows.api.account.playerPersonalData.playerPersonalDataResponse.Aircraft aircraft;
    @JsonProperty("team_capture_points")
    private Long teamCapturePoints;
    @JsonProperty("control_dropped_points")
    private Long controlDroppedPoints;
    @JsonProperty("max_damage_dealt")
    private Long maxDamageDealt;
    @JsonProperty("max_damage_dealt_to_buildings_ship_id")
    private Object maxDamageDealtToBuildingsShipId;
    @JsonProperty("max_damage_dealt_ship_id")
    private Long maxDamageDealtShipId;
    @JsonProperty("wins")
    private Long wins;
    @JsonProperty("losses")
    private Long losses;
    @JsonProperty("damage_dealt")
    private Long damageDealt;
    @JsonProperty("max_planes_killed")
    private Long maxPlanesKilled;
    @JsonProperty("max_scouting_damage_ship_id")
    private Long maxScoutingDamageShipId;
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
    public automatedTestsProject.main.wows.api.account.playerPersonalData.playerPersonalDataResponse.MainBattery getMainBattery() {
        return mainBattery;
    }

    @JsonProperty("main_battery")
    public void setMainBattery(MainBattery mainBattery) {
        this.mainBattery = mainBattery;
    }

    @JsonProperty("max_ships_spotted_ship_id")
    public Long getMaxShipsSpottedShipId() {
        return maxShipsSpottedShipId;
    }

    @JsonProperty("max_ships_spotted_ship_id")
    public void setMaxShipsSpottedShipId(Long maxShipsSpottedShipId) {
        this.maxShipsSpottedShipId = maxShipsSpottedShipId;
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

    @JsonProperty("max_xp_ship_id")
    public Long getMaxXpShipId() {
        return maxXpShipId;
    }

    @JsonProperty("max_xp_ship_id")
    public void setMaxXpShipId(Long maxXpShipId) {
        this.maxXpShipId = maxXpShipId;
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

    @JsonProperty("max_frags_ship_id")
    public Long getMaxFragsShipId() {
        return maxFragsShipId;
    }

    @JsonProperty("max_frags_ship_id")
    public void setMaxFragsShipId(Long maxFragsShipId) {
        this.maxFragsShipId = maxFragsShipId;
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

    @JsonProperty("control_captured_points")
    public Long getControlCapturedPoints() {
        return controlCapturedPoints;
    }

    @JsonProperty("control_captured_points")
    public void setControlCapturedPoints(Long controlCapturedPoints) {
        this.controlCapturedPoints = controlCapturedPoints;
    }

    @JsonProperty("battles_since_510")
    public Long getBattlesSince510() {
        return battlesSince510;
    }

    @JsonProperty("battles_since_510")
    public void setBattlesSince510(Long battlesSince510) {
        this.battlesSince510 = battlesSince510;
    }

    @JsonProperty("max_total_agro_ship_id")
    public Long getMaxTotalAgroShipId() {
        return maxTotalAgroShipId;
    }

    @JsonProperty("max_total_agro_ship_id")
    public void setMaxTotalAgroShipId(Long maxTotalAgroShipId) {
        this.maxTotalAgroShipId = maxTotalAgroShipId;
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

    @JsonProperty("max_suppressions_ship_id")
    public Object getMaxSuppressionsShipId() {
        return maxSuppressionsShipId;
    }

    @JsonProperty("max_suppressions_ship_id")
    public void setMaxSuppressionsShipId(Object maxSuppressionsShipId) {
        this.maxSuppressionsShipId = maxSuppressionsShipId;
    }

    @JsonProperty("survived_wins")
    public Long getSurvivedWins() {
        return survivedWins;
    }

    @JsonProperty("survived_wins")
    public void setSurvivedWins(Long survivedWins) {
        this.survivedWins = survivedWins;
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

    @JsonProperty("suppressions_count")
    public Long getSuppressionsCount() {
        return suppressionsCount;
    }

    @JsonProperty("suppressions_count")
    public void setSuppressionsCount(Long suppressionsCount) {
        this.suppressionsCount = suppressionsCount;
    }

    @JsonProperty("max_suppressions_count")
    public Long getMaxSuppressionsCount() {
        return maxSuppressionsCount;
    }

    @JsonProperty("max_suppressions_count")
    public void setMaxSuppressionsCount(Long maxSuppressionsCount) {
        this.maxSuppressionsCount = maxSuppressionsCount;
    }

    @JsonProperty("torpedoes")
    public Torpedoes getTorpedoes() {
        return torpedoes;
    }

    @JsonProperty("torpedoes")
    public void setTorpedoes(Torpedoes torpedoes) {
        this.torpedoes = torpedoes;
    }

    @JsonProperty("max_planes_killed_ship_id")
    public Long getMaxPlanesKilledShipId() {
        return maxPlanesKilledShipId;
    }

    @JsonProperty("max_planes_killed_ship_id")
    public void setMaxPlanesKilledShipId(Long maxPlanesKilledShipId) {
        this.maxPlanesKilledShipId = maxPlanesKilledShipId;
    }

    @JsonProperty("aircraft")
    public automatedTestsProject.main.wows.api.account.playerPersonalData.playerPersonalDataResponse.Aircraft getAircraft() {
        return aircraft;
    }

    @JsonProperty("aircraft")
    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    @JsonProperty("team_capture_points")
    public Long getTeamCapturePoints() {
        return teamCapturePoints;
    }

    @JsonProperty("team_capture_points")
    public void setTeamCapturePoints(Long teamCapturePoints) {
        this.teamCapturePoints = teamCapturePoints;
    }

    @JsonProperty("control_dropped_points")
    public Long getControlDroppedPoints() {
        return controlDroppedPoints;
    }

    @JsonProperty("control_dropped_points")
    public void setControlDroppedPoints(Long controlDroppedPoints) {
        this.controlDroppedPoints = controlDroppedPoints;
    }

    @JsonProperty("max_damage_dealt")
    public Long getMaxDamageDealt() {
        return maxDamageDealt;
    }

    @JsonProperty("max_damage_dealt")
    public void setMaxDamageDealt(Long maxDamageDealt) {
        this.maxDamageDealt = maxDamageDealt;
    }

    @JsonProperty("max_damage_dealt_to_buildings_ship_id")
    public Object getMaxDamageDealtToBuildingsShipId() {
        return maxDamageDealtToBuildingsShipId;
    }

    @JsonProperty("max_damage_dealt_to_buildings_ship_id")
    public void setMaxDamageDealtToBuildingsShipId(Object maxDamageDealtToBuildingsShipId) {
        this.maxDamageDealtToBuildingsShipId = maxDamageDealtToBuildingsShipId;
    }

    @JsonProperty("max_damage_dealt_ship_id")
    public Long getMaxDamageDealtShipId() {
        return maxDamageDealtShipId;
    }

    @JsonProperty("max_damage_dealt_ship_id")
    public void setMaxDamageDealtShipId(Long maxDamageDealtShipId) {
        this.maxDamageDealtShipId = maxDamageDealtShipId;
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

    @JsonProperty("max_scouting_damage_ship_id")
    public Long getMaxScoutingDamageShipId() {
        return maxScoutingDamageShipId;
    }

    @JsonProperty("max_scouting_damage_ship_id")
    public void setMaxScoutingDamageShipId(Long maxScoutingDamageShipId) {
        this.maxScoutingDamageShipId = maxScoutingDamageShipId;
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
