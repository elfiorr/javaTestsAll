package springProject.springBoot1.bykowskIVideoApplication.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springProject.springBoot1.bykowskIVideoApplication.dao.entity.VideoCassette;
import springProject.springBoot1.bykowskIVideoApplication.manager.VideoCassetteManager;

import java.util.Optional;

//rest controller do laczenia po api
@RestController
@RequestMapping("/api/cassettes")
public class VideoCassetteApi {

    //konstruktor byl do testu
//    private List<VideoCassette> videoCassettes;

//    public VideoCassetteApi() {
//        videoCassettes = new ArrayList<>();
//        videoCassettes.add(new VideoCassette(1L, "Titanic", LocalDate.of(1995, 1, 1)));
//        videoCassettes.add(new VideoCassette(1L, "Pulp Fiction", LocalDate.of(1990, 2, 2)));
//    }

    private VideoCassetteManager videoCassettes;

    @Autowired
    public VideoCassetteApi(VideoCassetteManager videoCassettes) {
        this.videoCassettes = videoCassettes;
    }

    @GetMapping("/all")
    public Iterable<VideoCassette> getAll() {
        return videoCassettes.findAll();
    }

    @GetMapping
    public Optional<VideoCassette> getById(@RequestParam Long index) {
        return videoCassettes.findById(index);
    }

    @PostMapping()
    public VideoCassette addVideo(@RequestBody VideoCassette videoCassette) {
        return videoCassettes.save(videoCassette);
    }

    @PutMapping()
    public VideoCassette updateVideo(@RequestBody VideoCassette videoCassette) {
        return videoCassettes.save(videoCassette);
    }

    @DeleteMapping()
    public void deleteVideo(@RequestParam Long index) {
        videoCassettes.deleteById(index);
    }
}
