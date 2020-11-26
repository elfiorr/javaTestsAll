package springProject.springBoot1.countries.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springProject.springBoot1.countries.dao.entity.Country;
import springProject.springBoot1.countries.manager.CountryManager;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

import static springProject.springBoot1.EndpointFactory.*;

@RestController
@RequestMapping(API + COUNTRY)
public class CountryApi {

    private CountryManager countryManager;

    @Autowired
    public CountryApi(CountryManager countryManager) {
        this.countryManager = countryManager;
    }

    @GetMapping(ALL)
    public Iterable<Country> getAll() {
        return countryManager.findAll();
    }

    @GetMapping(GET_BY_ID)
    public ResponseEntity<Country> getById(@PathVariable Long id)
            throws ResourceNotFoundException {

        Country country = countryManager.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found for id : " + id));

        return ResponseEntity.ok().body(country);
    }

    @PostMapping(ADD_NEW)
    public Country addCountry(@Valid @RequestBody Country country) {
        return countryManager.save(country);
    }

    @PutMapping(EDIT_BY_ID)
    public ResponseEntity<Country> updateCountry(
            @Valid @RequestBody Country countryDetails,
            @PathVariable Long id
    ) throws ResourceNotFoundException {

        Country country = countryManager.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found for id : " + id));

        country.setNameOfCountry(countryDetails.getNameOfCountry());
        country.setCapital(countryDetails.getCapital());
        country.setPopulation(countryDetails.getPopulation());

        final Country updateCountry = countryManager.save(country);

        return ResponseEntity.ok(updateCountry);
    }

    @DeleteMapping(ALL)
    public Map<String, Boolean> deleteAll() {

        countryManager.deleteAll();

        return responseForDeletedEndpoint();
    }

    @DeleteMapping(DELETE_BY_ID)
    public Map<String, Boolean> deleteCountry(
            @Valid @RequestBody Country countryDetails,
            @PathVariable Long id
    ) {

        Country country = countryManager.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found for id : " + id));

        countryManager.deleteBy(country);

        return responseForDeletedEndpoint();
    }

    private Map<String, Boolean> responseForDeletedEndpoint() {

        Map<String, Boolean> response = new HashMap<>();
        response.put("Record/s have been deleted:", Boolean.TRUE);

        return response;
    }
}

//do testu zanim podepnie sie baze
//    private List<Country> countryList;
//
//    public CountryApi() {
//        countryList = new ArrayList<>();
//        countryList.add(new Country(1L, "Poland", "Warsaw", 39000));
//    }
//
//    @GetMapping("/all")
//    public List<Country> getAll() {
//        return countryList;
//    }
//
//    @GetMapping()
//    public Country getById(@RequestParam int index) {
//        Optional<Country> first = countryList.stream()
//                .filter(element -> element.getId() == index)
//                .findFirst();
//
//        return first.get();
//    }
//
