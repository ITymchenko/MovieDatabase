package MovieDatabase.service;

import MovieDatabase.dto.MovieDTO;
import MovieDatabase.entity.filter.MovieFilter;

import java.util.List;

public interface MovieService {

    MovieDTO addMovie(MovieDTO movieDTO);

    List<MovieDTO> getAllMovies(MovieFilter movieFilter);

    MovieDTO editMovie(MovieDTO movieDTO, long id);

    MovieDTO removeMovie(Long id);

    MovieDTO getMovie(Long id);

}
