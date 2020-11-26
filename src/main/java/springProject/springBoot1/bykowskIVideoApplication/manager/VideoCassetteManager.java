package springProject.springBoot1.bykowskIVideoApplication.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springProject.springBoot1.bykowskIVideoApplication.dao.VideoCasseteRepo;
import springProject.springBoot1.bykowskIVideoApplication.dao.entity.VideoCassette;

import java.util.Optional;

@Service
public class VideoCassetteManager {

    private VideoCasseteRepo videoCasseteRepo;

    @Autowired
    public VideoCassetteManager(VideoCasseteRepo videoCasseteRepo) {
        this.videoCasseteRepo = videoCasseteRepo;
    }

    public Optional<VideoCassette> findById(Long id) {
        return videoCasseteRepo.findById(id);
    }

    public Iterable<VideoCassette> findAll() {
        return videoCasseteRepo.findAll();
    }

    public VideoCassette save(VideoCassette videoCassette) {
        return videoCasseteRepo.save(videoCassette);
    }

    public void deleteById(Long id) {
        videoCasseteRepo.deleteById(id);
    }
}