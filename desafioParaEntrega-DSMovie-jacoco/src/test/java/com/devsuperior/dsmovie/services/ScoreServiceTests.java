package com.devsuperior.dsmovie.services;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.entities.MovieEntity;
import com.devsuperior.dsmovie.entities.ScoreEntity;
import com.devsuperior.dsmovie.entities.UserEntity;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import com.devsuperior.dsmovie.repositories.ScoreRepository;
import com.devsuperior.dsmovie.services.exceptions.ResourceNotFoundException;
import com.devsuperior.dsmovie.tests.MovieFactory;
import com.devsuperior.dsmovie.tests.ScoreFactory;
import com.devsuperior.dsmovie.tests.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class ScoreServiceTests {

	@InjectMocks
	private ScoreService service;

	@Mock
	private UserService userService;

	@Mock
	private ScoreRepository scoreRepository;

	@Mock
	private MovieRepository movieRepository;

	private Long existingMovieId, nonExistingMovieId;
	private UserEntity user;
	private MovieEntity movie;
	private ScoreEntity score;

	@BeforeEach
	void setUp() throws Exception {
		existingMovieId = 1L;
		nonExistingMovieId = 2L;
		score = ScoreFactory.createScoreEntity();
		movie = MovieFactory.createMovieEntity();
		movie.getScores().add(score);
		user = UserFactory.createUserEntity();

		when(userService.authenticated()).thenReturn(user);

		when(movieRepository.findById(existingMovieId)).thenReturn(Optional.of(movie));
		when(movieRepository.findById(nonExistingMovieId)).thenReturn(Optional.empty());

		when(scoreRepository.saveAndFlush(any())).thenReturn(score);
		when(movieRepository.save(any())).thenReturn(movie);
	}

	@Test
	public void saveScoreShouldReturnMovieDTO() {
		ScoreDTO scoreDTO = new ScoreDTO(score);

		MovieDTO result = service.saveScore(scoreDTO);
		Assertions.assertNotNull(result);
	}

	@Test
	public void saveScoreShouldThrowResourceNotFoundExceptionWhenNonExistingMovieId() {

		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.saveScore(new ScoreDTO(nonExistingMovieId, score.getValue()));
		});
	}
}
