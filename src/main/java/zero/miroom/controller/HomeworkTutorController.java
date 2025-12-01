package zero.miroom.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zero.miroom.dto.HomeworkRequest;


/*@RestController
@RequestMapping("/api/tutor")
public class HomeworkTutorController {

    private final HomeworkTutorService tutorService;

    public HomeworkTutorController(HomeworkTutorService tutorService) {
        this.tutorService = tutorService;
    }

    @PostMapping
    public ResponseEntity<String> askTutor(@RequestBody HomeworkRequest request) {
        String answer = tutorService.askTutor(request);
        return ResponseEntity.ok(answer);
    }
}*/
