package comtroller;

import model.Faculty;
import model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.FacultyService;
import service.StudentService;

import java.util.Collection;

public class FacultyController {
    private FacultyService facultyService;

    public FacultyController(StudentService studentService) {
        this.facultyService = facultyService;
    }
    @GetMapping
    public ResponseEntity<Collection<Faculty>> getAllStudent() {
        return ResponseEntity.ok(facultyService.findFaculty());
    }

    @PostMapping
    public Faculty createFaculty(@RequestParam Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @PutMapping
    public  ResponseEntity<Faculty> editFaculty(@RequestParam Faculty faculty){
        Faculty foundFaculty = FacultyService.editFaculty(faculty);
        if (foundFaculty == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(foundFaculty);
    }

    @DeleteMapping
    public Faculty deleteFaculty(@PathVariable Long id) {
        return facultyService.deleteFaculty(id);
    }

    @GetMapping
    public ResponseEntity<Faculty> filterAgeFaculty(@RequestParam int age){
        Faculty foundFaculty = FacultyService.filterAgeFaculty(age);
        if (foundFaculty == null){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(foundFaculty);
    }
}
