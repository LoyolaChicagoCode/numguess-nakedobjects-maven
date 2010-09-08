package edu.luc.cs.cs442.numguess.services;

import org.nakedobjects.applib.AbstractService;

import edu.luc.cs.cs442.numguess.domain.BestScore;

public class DefaultBestScoreService extends AbstractService implements
		BestScoreService {

	private int bestScore = Integer.MAX_VALUE;

	public int lookupBestScore() {
		return bestScore;
	}

	public boolean recordNewScore(final int bestScore) {
		boolean result = bestScore < this.bestScore;
		if (result) {
			this.bestScore = bestScore;
		}
		return result;
	}

	public void persistCurrentScore(final String name) {
		final BestScore bs = getContainer().newTransientInstance(BestScore.class);
		bs.setScore(bestScore);
		bs.setName(name);
		getContainer().persist(bs);
	}
}