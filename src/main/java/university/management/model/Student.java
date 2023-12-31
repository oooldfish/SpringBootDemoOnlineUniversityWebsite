package university.management.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * @author Michael Pogrebinsky - www.topdeveloperacademy.com
 * Persistence entity that represents a student, registered at the university
 */

@Entity
@Table(name = "Students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60, nullable = false)
    private String firstName;

    @Column(length = 60, nullable = false)
    private String lastName;

    @Column(length = 60, nullable = false, unique = true)
    private String email;

    private LocalDate dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private LearnerProfile learnerProfile;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "program_id")
    private Program program;

    @ManyToMany(mappedBy = "enrolledStudents", cascade = CascadeType.ALL)
    private Set<Course> courses;

    public Student() {
    }

    public Student(String firstName,
                   String lastName,
                   String email,
                   LocalDate dateOfBirth,
                   Program program) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.learnerProfile = new LearnerProfile((short) LocalDate.now().getYear());
        this.program = program;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LearnerProfile getLearnerProfile() {
        return learnerProfile;
    }

    public Program getProgram() {
        return program;
    }

    public Set<Course> getCourses() {
        return courses;
    }
}
