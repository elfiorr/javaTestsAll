package springProject.springBoot1.countries.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springProject.springBoot1.countries.dao.CountryRepo;
import springProject.springBoot1.countries.dao.entity.Country;

import java.util.Optional;

@Service

//Poniższe są dokładnie tym samym co Service i tworzymy to tylko wtedy, gdy wykonujemy jedną instancje
//Jedna klasa 'manager' powinna robic tylko jedna rzecz
//@Component
//@Controller
//@RestController
//@Repository
//@Bean
public class CountryManager {

    private CountryRepo countryRepo;

    @Autowired
    public CountryManager(CountryRepo countryRepo){
        this.countryRepo = countryRepo;
    }

    public Optional<Country> findById(Long id) {
        return countryRepo.findById(id)/*.orElseGet(() -> null)*/;
    }

    public Iterable<Country> findAll(){
        return countryRepo.findAll();
    }

    public Country save(Country country) {
        return countryRepo.save(country);
    }

    public void deleteById(Long id) {
        countryRepo.deleteById(id);
    }

    public void deleteBy(Country country) {
        countryRepo.delete(country);
    }

    public void deleteAll() {
        countryRepo.deleteAll();
    }
}
