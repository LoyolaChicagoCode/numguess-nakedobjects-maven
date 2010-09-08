package edu.luc.cs.cs442.numguess.services;

public interface BestScoreService {

	public boolean recordNewScore(int bestScore);

	public int lookupBestScore();

	public void persistCurrentScore(String name);
}