package comtroller;

import model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("Student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
     @GetMapping
    public ResponseEntity<Collection<Student>> getAllStudent() {
      return ResponseEntity.ok(studentService.findStudent());
    }

    @PostMapping
    public Student createStudent(@RequestParam Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping
    public  ResponseEntity<Student> editStudent(@RequestParam Student student){
        Student foundStudent = StudentService.editStudent(student);
        if (foundStudent == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(foundStudent);
    }

    @DeleteMapping
    public Student deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }
    @GetMapping
    public ResponseEntity<Student> filterAgeStudent(@RequestParam int age){
        Student foundStudent = StudentService.filterAgeStudent(age);
        if (foundStudent == null){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(foundStudent);
    }
}
