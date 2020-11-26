package automatedTestsProject.main.countryApi;

public class CountryRequestJsonDataFactory {

    private String nameOfCountry;
    private String capital;
    private int population;
    private Long surface;
    private String officialLanguage;
    private String telephoneCode;

    public CountryRequestJsonDataFactory(
            String nameOfCountry,
            String capital,
            int population,
            Long surface,
            String officialLanguage,
            String telephoneCode
    ) {
        this.nameOfCountry = nameOfCountry;
        this.capital = capital;
        this.population = population;
        this.surface = surface;
        this.officialLanguage = officialLanguage;
        this.telephoneCode = telephoneCode;
    }

    public CountryRequestJsonModel addCountryRequestJsonModel() {

        CountryRequestJsonModel countryRequestJsonModel = new CountryRequestJsonModel();
        countryRequestJsonModel.setNameOfCountry(nameOfCountry);
        countryRequestJsonModel.setCapital(capital);
        countryRequestJsonModel.setPopulation(population);

        return  countryRequestJsonModel;
    }
}
