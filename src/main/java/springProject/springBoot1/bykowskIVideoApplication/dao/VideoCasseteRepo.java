package springProject.springBoot1.bykowskIVideoApplication.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springProject.springBoot1.bykowskIVideoApplication.dao.entity.VideoCassette;

@Repository
public interface VideoCasseteRepo extends CrudRepository<VideoCassette, Long> {
}
