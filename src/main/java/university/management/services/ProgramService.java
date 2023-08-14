package university.management.services;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import university.management.model.Program;
import university.management.repositories.ProgramsRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Michael Pogrebinsky - www.topdeveloperacademy.com
 * A service that applies business logic to university programs
 */
@Service
public class ProgramService {

    /**
     * Returns the Program object by field of study and degree from the database if it exists
     * or creates a new object
     */

    private final ProgramsRepository programsRepository;

    public ProgramService(ProgramsRepository programsRepository) {
        this.programsRepository = programsRepository;
    }

    public Program getOrCreateProgram(String fieldOfStudy, Program.Degree degree) {
        Optional<Program> program = programsRepository.findByFieldOfStudyAndDegree(fieldOfStudy, degree); // Placeholder

        if (program.isPresent()) {
            return program.get();
        }
        return new Program(fieldOfStudy, degree);
    }

    /**
     * Returns all the programs from the database
     */
    public List<Program> getAllProgramsWithStudents() {
        Sort sortOrder = Sort.by("fieldOfStudy").ascending()
                .and(Sort.by("degree").ascending());
        return programsRepository.findAll(sortOrder);
    }
}
