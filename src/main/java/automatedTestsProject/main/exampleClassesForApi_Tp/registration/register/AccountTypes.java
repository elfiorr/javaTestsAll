package automatedTestsProject.main.exampleClassesForApi_Tp.registration.register;

public enum AccountTypes {

    PERSONAL("personal"),
    COMPANY("company"),
    FOREIGN_COMPANY("foreignCompany");

    private String accountType;

    AccountTypes(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType() {
        return accountType;
    }


}
