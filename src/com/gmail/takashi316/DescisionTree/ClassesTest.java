/**
 * 
 */
package com.gmail.takashi316.DescisionTree;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Takashi SASAKI
 * 
 */
public class ClassesTest {

	Classes classes1;
	Classes classes2;
	Logger logger = Logger.getLogger(ClassesTest.class.getSimpleName());

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		classes1 = new Classes();
		classes1.add(1);
		classes1.add(2);
		classes1.add(3);
		classes1.add(4);
		classes1.add(5);
		classes1.add(6);

		classes2 = new Classes();
		classes2.add(1);
		classes2.add(1);
		classes2.add(2);
		classes2.add(3);
		classes2.add(3);
		classes2.add(3);
		classes2.add(2);
		classes2.add(1);
		classes2.add(1);
		classes2.add(3);
		classes2.add(1);
		classes2.add(2);
		classes2.add(2);
		classes2.add(3);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.gmail.takashi316.DescisionTree.Classes#getEntropy()}.
	 */
	@Test
	public void testGetEntropy1() {
		double entropy = classes1.getEntropy();
		logger.info(classes1.toString());
		assertTrue(entropy > 2.58);
		assertTrue(entropy < 2.59);
	}

	@Test
	public void testGetEntropy2() {
		double entropy = classes2.getEntropy();
		logger.info(classes2.toString());
		assertTrue(entropy > 1.57);
		assertTrue(entropy < 1.58);
	}
}
