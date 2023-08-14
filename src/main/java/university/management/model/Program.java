package university.management.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author Michael Pogrebinsky - www.topdeveloperacademy.com
 * A Persistence entity that represents a program a student can follow to earn a degree in a
 * particular field of study
 */

@Entity
@Table(name = "Programs")
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "program_id")
    private Long programId;

    @Column(nullable = false)
    private int requiredYearsToGraduation = 4;

    @Column(nullable = false)
    private int requiredCreditsToGraduation = 200;

    @Column(nullable = false, updatable = false)
    private String fieldOfStudy;

    @Enumerated(EnumType.STRING)
    private Degree degree;

    @OneToMany(mappedBy = "program")
    private List<Student> students;

    public Program() {
    }

    public Program(String fieldOfStudy, Degree degree) {
        this.fieldOfStudy = fieldOfStudy;
        this.degree = degree;
    }

    public Long getProgramId() {
        return programId;
    }

    public int getRequiredYearsToGraduation() {
        return requiredYearsToGraduation;
    }

    public int getRequiredCreditsToGraduation() {
        return requiredCreditsToGraduation;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public Degree getDegree() {
        return degree;
    }

    public List<Student> getStudents() {
        return students;
    }

    public enum Degree {
        ASSOCIATE,
        BACHELOR,
        MASTER,
        PHD,
    }
}
