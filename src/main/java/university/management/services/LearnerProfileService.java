package university.management.services;

import org.springframework.stereotype.Service;
import university.management.model.LearnerProfile;
import university.management.repositories.LearnerProfilesRepository;

import java.util.List;

/**
 * @author Michael Pogrebinsky - www.topdeveloperacademy.com
 * A service that applies business logic to learner profiles
 */
@Service
public class LearnerProfileService {
    /**
     * Returns all the active students' learner profiles in the database,
     * sorted by their GPA in descending order
     */

    private final LearnerProfilesRepository learnerProfilesRepository;

    public LearnerProfileService(LearnerProfilesRepository learnerProfilesRepository) {
        this.learnerProfilesRepository = learnerProfilesRepository;
    }



    public List<LearnerProfile> getActiveStudentProfilesOrderedByGpa() {
        return learnerProfilesRepository.findAllByIsGraduatedIsFalseOrderByGpaDesc();
    }
}
