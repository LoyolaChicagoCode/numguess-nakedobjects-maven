package edu.luc.cs.cs442.numguess.domain;

import org.apache.log4j.Logger;

import edu.luc.cs.cs442.numguess.services.BestScoreService;

/**
 * This bean is used to represent guess results going back from the game to the
 * user. It is an example of the ValueObject (TransferObject) pattern.
 */
public class GuessResult {

	private final static Logger LOGGER = Logger.getLogger(GuessResult.class);

	private int guess;
	private int comparison;
	private int guesses;
	private int bestScore;
	private boolean newBestScore;

	private BestScoreService bestScoreService;

	protected BestScoreService getBestScoreService() {
		return bestScoreService;
	}

	public void setBestScoreService(final BestScoreService bestScoreService) {
		LOGGER.debug(this + " setting bestScoreService to " + bestScoreService);
		this.bestScoreService = bestScoreService;
	}

	public int getGuess() {
		return guess;
	}

	public void setGuess(final int guess) {
		this.guess = guess;
	}

	public int getComparison() {
		return comparison;
	}

	public void setComparison(final int comparison) {
		this.comparison = comparison;
	}

	public int getNumGuesses() {
		return guesses;
	}

	public void setNumGuesses(final int guesses) {
		this.guesses = guesses;
	}

	public int getBestScore() {
		return bestScore;
	}

	public void setBestScore(final int bestScore) {
		this.bestScore = bestScore;
	}

	public boolean isNewBestScore() {
		return newBestScore;
	}

	public void setNewBestScore(final boolean newBestScore) {
		this.newBestScore = newBestScore;
	}

	public void enterNameForBestScore(final String name) {
		assert newBestScore;
		getBestScoreService().persistCurrentScore(name);
	}
}