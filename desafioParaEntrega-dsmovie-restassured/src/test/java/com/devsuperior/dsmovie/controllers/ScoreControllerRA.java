package com.devsuperior.dsmovie.controllers;

import com.devsuperior.dsmovie.tests.TokenUtil;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ScoreControllerRA {

	private String clientUsername, clientPassword, clientToken;
	private Long nonExistingMovieId;
	private Map<String, Object> putScoreInstance;

	@BeforeEach
	public void setUp() throws Exception {
		baseURI = "http://localhost:8080";

		clientUsername = "alex@gmail.com";
		clientPassword = "123456";

		clientToken = TokenUtil.obtainAccessToken(clientUsername, clientPassword);

		putScoreInstance = new HashMap<>();
	}

	@Test
	public void saveScoreShouldReturnNotFoundWhenMovieIdDoesNotExist() throws Exception {
		nonExistingMovieId = 100L;
		putScoreInstance.put("movieId", nonExistingMovieId);
		putScoreInstance.put("score", 4);

		JSONObject score = new JSONObject(putScoreInstance);

		given()
				.header("Content-type", "application/json")
				.header("Authorization", "Bearer " + clientToken)
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(score)
				.when()
				.put("/scores")
				.then()
				.statusCode(404);
	}

	@Test
	public void saveScoreShouldReturnUnprocessableEntityWhenMissingMovieId() throws Exception {
		putScoreInstance.put("movieId", "");
		putScoreInstance.put("score", 4);

		JSONObject score = new JSONObject(putScoreInstance);

		given()
				.header("Content-type", "application/json")
				.header("Authorization", "Bearer " + clientToken)
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(score)
				.when()
				.put("/scores")
				.then()
				.statusCode(422);
	}

	@Test
	public void saveScoreShouldReturnUnprocessableEntityWhenScoreIsLessThanZero() throws Exception {
		putScoreInstance.put("movieId", 1);
		putScoreInstance.put("score", -10);

		JSONObject score = new JSONObject(putScoreInstance);

		given()
				.header("Content-type", "application/json")
				.header("Authorization", "Bearer " + clientToken)
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(score)
				.when()
				.put("/scores")
				.then()
				.statusCode(422);
	}
}