package MovieDatabase.dto.mapper;

import MovieDatabase.dto.PersonDTO;
import MovieDatabase.entity.PersonEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonEntity toEntity(PersonDTO source);

    PersonDTO toDTO(PersonEntity source);
}
