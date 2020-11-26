package springProject.springBoot1.countries.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springProject.springBoot1.countries.dao.entity.Country;

@Repository
public interface CountryRepo extends CrudRepository<Country, Long> {
}
