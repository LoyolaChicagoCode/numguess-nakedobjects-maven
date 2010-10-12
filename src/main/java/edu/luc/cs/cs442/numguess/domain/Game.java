package edu.luc.cs.cs442.numguess.domain;

import java.util.Random;

import org.apache.log4j.Logger;
import org.nakedobjects.applib.DomainObjectContainer;
import org.nakedobjects.applib.annotation.Disabled;

import edu.luc.cs.cs442.numguess.services.BestScoreService;

/**
 * A class representing the business logic of the game. There is one instance of
 * this class per user session.
 */
public class Game {

	private final static Logger LOGGER = Logger.getLogger(Game.class);

	private DomainObjectContainer container;

	protected DomainObjectContainer getContainer() {
        return this.container;
    }

	public void setContainer(final DomainObjectContainer container) {
        this.container = container;
    }

	private BestScoreService bestScoreService;

	protected BestScoreService getHighScoreService() {
		return this.bestScoreService;
	}

	public void setHighScoreService(final BestScoreService bestScoreService) {
		LOGGER.debug(this + " setting bestScoreService to " + bestScoreService);
		this.bestScoreService = bestScoreService;
	}

	private int answer = -1;

	private int numGuesses = 0;

	// NO bug: the HTML interface won't work without at least one property.
	@Disabled
	public int getNumGuesses() {
		return numGuesses;
	}

	public GuessResult guess(final int guess) {
		boolean isNewBestScore = false;
		int bestScore = Integer.MAX_VALUE;
		// update data model
		numGuesses++;
		// update best score in shared data model if available
		if (guess == answer) {
			isNewBestScore = bestScoreService.recordNewScore(numGuesses);
			bestScore = bestScoreService.lookupBestScore();
		}
		// populate resulting ValueObject
		final GuessResult result = getContainer().newTransientInstance(GuessResult.class);
		result.setGuess(guess);
		result.setNumGuesses(numGuesses);
		result.setComparison(guess - answer);
		result.setBestScore(bestScore);
		result.setNewBestScore(isNewBestScore);
		return result;
	}

	public void reset(final int min, final int max) {
		answer = min + Math.abs(new Random().nextInt() % (max - min + 1));
		numGuesses = 0;
		LOGGER.info("The answer is " + answer);
	}
}