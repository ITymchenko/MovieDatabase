package MovieDatabase.service;

import MovieDatabase.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserDTO create(UserDTO model);

}

