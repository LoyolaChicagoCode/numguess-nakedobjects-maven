package edu.luc.cs.cs442.numguess.test;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.apache.log4j.Logger;
import org.nakedobjects.applib.DomainObjectContainer;
import org.nakedobjects.applib.fixtures.FixtureType;
import org.nakedobjects.applib.fixtures.InstallableFixture;
import org.nakedobjects.applib.value.Color;


/**
 */
public class NumguessTestFixture extends TestCase implements InstallableFixture {

	private final static Logger LOGGER = Logger.getLogger(NumguessTestFixture.class);

	// NOF needs this constructor
	public NumguessTestFixture() { super("NumguessTestFixture"); }

	// JUnit needs this one
	public NumguessTestFixture(String name) { super(name); }

	private static DomainObjectContainer container;

	protected DomainObjectContainer getContainer() {
        return NumguessTestFixture.container;
    }

	public void setContainer(final DomainObjectContainer container) {
		LOGGER.debug("setting container to " + container);
		NumguessTestFixture.container = container;
    }

	@Override
	public void install() {
		LOGGER.info("installing the fixture");
		TestRunner.run(NumguessTestFixture.class);
		System.exit(0);
	}

	@Override
	public FixtureType getType() {
		return FixtureType.OTHER;
	}

	public void setUp() throws Exception {
	}

	public void tearDown() throws Exception {
	}

	public void testGame() {
		LOGGER.info("this is a test");
	}
}
