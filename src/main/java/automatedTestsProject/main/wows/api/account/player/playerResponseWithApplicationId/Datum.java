
package automatedTestsProject.main.wows.api.account.player.playerResponseWithApplicationId;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Datum {

    private String nickname;
    private Integer accountId;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @JsonProperty("account_id")
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

}
