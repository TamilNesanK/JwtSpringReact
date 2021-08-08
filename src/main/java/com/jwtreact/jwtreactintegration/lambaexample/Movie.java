package com.jwtreact.jwtreactintegration.lambaexample;

public class Movie {

	private String actorName;
	private String movieName;
	private Integer releaseYear;

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public Movie() {

	}

	@Override
	public String toString() {
		return "Movie [actorName=" + actorName + ", movieName=" + movieName + ", releaseYear=" + releaseYear + "]";
	}

	public Movie(String actorName, String movieName, Integer releaseYear) {
		super();
		this.actorName = actorName;
		this.movieName = movieName;
		this.releaseYear = releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

}
