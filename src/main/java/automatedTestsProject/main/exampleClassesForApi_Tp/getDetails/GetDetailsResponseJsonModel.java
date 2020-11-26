package automatedTestsProject.main.exampleClassesForApi_Tp.getDetails;

import java.util.List;

public class GetDetailsResponseJsonModel {

    private Integer id;
    private String fullName;
    private String subdomain;
    private String email;
    private String accountType;
    private String pesel;
    private String city;
    private String zipCode;
    private String address;
    private String phoneNumber;
    private String iban;
    private String bankName;
    private Integer specialization;
    private String companyName;
    private String nip;
    private String regon;
    private String krs;
    private String registeredNumber;
    private String country;
    private Boolean newsletter;
    private List<DocumentListResponseJsonModel> documentList = null;
    private String affiliationCommissionModel;
    private String referralUrl;
    private Boolean referrerAgreement;
    private Boolean affiliateNetworkAgreement;
    private String registrationDate;
    private List<DistributorResponseJsonModel> distributors = null;
    private Boolean hasAffiliateNetwork;
    private Boolean isRecommended;

    public GetDetailsResponseJsonModel(List<DistributorResponseJsonModel> distributors) {
        this.distributors = distributors;
    }

    public Boolean getIsRecommended() {
        return isRecommended;
    }

    public void setIsRecommended(Boolean recommended) {
        isRecommended = recommended;
    }

    public Integer getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getSubdomain() {
        return subdomain;
    }

    public String getEmail() {
        return email;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getPesel() {
        return pesel;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getAddress() {
        return address;
    }

    public String getAffiliationCommissionModel() {
        return affiliationCommissionModel;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getIban() {
        return iban;
    }

    public String getBankName() {
        return bankName;
    }

    public Integer getSpecialization() {
        return specialization;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getNip() {
        return nip;
    }

    public String getRegon() {
        return regon;
    }

    public String getKrs() {
        return krs;
    }

    public String getRegisteredNumber() {
        return registeredNumber;
    }

    public String getCountry() {
        return country;
    }

    public Boolean getNewsletter() {
        return newsletter;
    }

    public List<DocumentListResponseJsonModel> getDocumentList() {
        return documentList;
    }

    public String getReferralUrl() {
        return referralUrl;
    }

    public Boolean getReferrerAgreement() {
        return referrerAgreement;
    }

    public Boolean getAffiliateNetworkAgreement() {
        return affiliateNetworkAgreement;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public List<DistributorResponseJsonModel> getDistributors() {
        return distributors;
    }

    public Boolean getHasAffiliateNetwork() {
        return hasAffiliateNetwork;
    }

}
