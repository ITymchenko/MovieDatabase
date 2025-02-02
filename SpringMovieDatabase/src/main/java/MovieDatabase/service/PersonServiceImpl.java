package MovieDatabase.service;

import MovieDatabase.constant.RoleType;
import MovieDatabase.dto.PersonDTO;
import MovieDatabase.dto.mapper.PersonMapper;
import MovieDatabase.entity.PersonEntity;
import MovieDatabase.entity.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper personMapper;

    public PersonDTO addPerson(PersonDTO personDTO) {
        PersonEntity entity = personMapper.toEntity(personDTO);
        PersonEntity savedEntity = personRepository.save(entity);
        return personMapper.toDTO(savedEntity);
    }

    public List<PersonDTO> getPeople(RoleType roleType, int limit) {
        Page<PersonEntity> pageOfPeople = personRepository.getAllByRole(roleType, PageRequest.of(0, limit));
        List<PersonEntity> personEntities = pageOfPeople.getContent();

        List<PersonDTO> result = new ArrayList<>();
        for (PersonEntity e : personEntities) {
            result.add(personMapper.toDTO(e));
        }
        return result;
    }

    public PersonDTO editPerson(Long personId, PersonDTO personDTO) {
        if (!personRepository.existsById(personId)) {
            throw new EntityNotFoundException("Person with id " + personId + " wasn't found in the database.");
        }
        PersonEntity entity = personMapper.toEntity(personDTO);
        entity.setId(personId);
        personRepository.save(entity);
        PersonEntity saved = personRepository.save(entity);
        return personMapper.toDTO(saved);
    }

    public PersonDTO removePerson(Long personId) {
        PersonEntity person = personRepository.findById(personId).orElseThrow(EntityNotFoundException::new);
        PersonDTO model = personMapper.toDTO(person);
        personRepository.delete(person);
        return model;
    }

    public PersonDTO getPerson(Long personId) {
        PersonEntity person = personRepository.getReferenceById(personId);
        return personMapper.toDTO(person);
    }
}
