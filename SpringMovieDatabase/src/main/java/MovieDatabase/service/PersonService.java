package MovieDatabase.service;

import MovieDatabase.constant.RoleType;
import MovieDatabase.dto.PersonDTO;

import java.util.List;

public interface PersonService {
    PersonDTO addPerson(PersonDTO personDTO);

    List<PersonDTO> getPeople(RoleType roleType, int limit);

    PersonDTO editPerson(Long personId, PersonDTO personDTO);

    PersonDTO removePerson(Long personId);

    PersonDTO getPerson(Long personId);
}
