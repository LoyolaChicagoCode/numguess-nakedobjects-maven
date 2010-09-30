package edu.luc.cs.cs442.numguess.domain;

import org.nakedobjects.applib.AbstractDomainObject;

public class BestScore extends AbstractDomainObject {

	private int score;

	private String name;

	public int getScore() {
		return score;
	}

	public String getName() {
		return name;
	}

	public void setScore(final int score) {
		this.score = score;
	}

	public void setName(final String name) {
		this.name = name;
	}
}
