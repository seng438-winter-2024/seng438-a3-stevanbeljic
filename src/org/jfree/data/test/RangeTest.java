package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;
public class RangeTest {
    private Range exampleRange1;
    private Range exampleRange2;
    private Range exampleRange3;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { 
    	exampleRange1 = new Range(-1, 1);
    	exampleRange2 = new Range(1, 5);
    	exampleRange3 = new Range(-5, -1);
    }


    @Test
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
        0, exampleRange1.getCentralValue(), .000000001d);
    }
    
    
    /*--------------- getLowerBound() -----------------*/
	/*
	 * Testing getLowerBound function
	 * Input: range with 1 lower and 5 upper
	 * Expected result: 1.0
	 */
    @Test
    public void getLowerBoundTestWithPositiveBounds() {
    	assertEquals("The expected getLowerBound() return does not match expected. ",
    			1.0,exampleRange2.getLowerBound(),.000000001d);
    }
	/*
	 * Testing getLowerBound function with negative number
	 * Input: range with 1 lower and 5 upper
	 * Expected result: 1.0
	 */
    @Test
    public void getLowerBoundTestWithNegativeLowerBound() {
    	assertEquals("The expected getLowerBound() return does not match expected. ",
    			-1.0,exampleRange1.getLowerBound(),.000000001d);
    }
	/*
	 * Testing getLowerBound function with negative number
	 * Input: range with 0 lower and 0 upper
	 * Expected result: 0.0
	 */
    @Test
    public void getLowerBoundTestWithZeroLower() {
    	Range input1 = new Range(0,5);
    	assertEquals("The expected getLowerBound() return does not match expected. ",
    			0.0,input1.getLowerBound(),.000000001d);
    }
    
    /*--------------- getUpperBound() -----------------*/
	/*
	 * Testing getUpperBound function
	 * Input: range with 1 lower and 5 upper
	 * Expected result: 5.0
	 */
    @Test
    public void getUpperBoundTestWithPositiveBounds() {
    	assertEquals("The expected getUpperBound() return does not match expected. ",
    			5.0,exampleRange2.getUpperBound(),.000000001d);
    } 
	/*
	 * Testing getUpperBound function
	 * Input: range with -5 lower and -1.0 upper
	 * Expected result: -1.0
	 */
    @Test
    public void getUpperBoundTestWithNegativeLowerBound() {
    	assertEquals("The expected getUpperBound() return does not match expected. ",
    			-1.0,exampleRange3.getUpperBound(),.000000001d);
    } 
    
	/*
	 * Testing getUpperBound function
	 * Input: range with 0 lower and 0.0 upper
	 * Expected result: 0.0
	 */
    @Test
    public void getUpperBoundTestWithZeroUpper() {
    	Range input1 = new Range(-5,0);
    	assertEquals("The expected getUpperBound() return does not match expected. ",
    			0.0,input1.getUpperBound(),.000000001d);
    } 
    
    /*--------------- To string tests-----------------
	/*
	 * Testing toString function
	 * Input: range with 1 lower and 5 upper
	 * Expected result: Range[1.0,5.0]
	 */
    @Test
    public void toStringTestWithPositiveBounds() {
    	assertEquals("The expected toString() return does not match expected. ",
    			"Range[1.0,5.0]",exampleRange2.toString());
    }
    
	/*
	 * Testing toString function with negative range
	 * Input: range with -1 lower and 1 upper
	 * Expected result: Range[-1.0,1.0]
	 */
    
    @Test
    public void toStringTestWithNegativeLowerBound() {
    	assertEquals("The expected toString() return does not match expected. ",
    			"Range[-1.0,1.0]",exampleRange1.toString());
    }
    
	/*
	 * Testing toString function with zero range
	 * Input: range with 0 lower and 3 upper
	 * Expected result: Range[0.0,3.0]
	 */
    
    @Test
    public void toStringTestWithZeroLower() {
    	Range input1 = new Range(0,3);
    	assertEquals("The expected toString() return does not match expected. ",
    			"Range[0.0,3.0]",input1.toString());
    }
	/*
	 * Testing toString function with zero range
	 * Input: range with -3 lower and 0 upper
	 * Expected result: Range[-3.0,0.0]
	 */
    
    @Test
    public void toStringTestWithZeroUpper() {
    	Range input1 = new Range(-3,0);
    	assertEquals("The expected toString() return does not match expected. ",
    			"Range[-3.0,0.0]",input1.toString());
    }
	/*
	 * Testing toString function with negative range
	 * Input: range with -9.0 lower and -5.0 upper
	 * Expected result: Range[-9.0,-5.0]
	 */
    
    @Test
    public void toStringTestWithTwoNegative() {
    	Range input1 = new Range(-9,-5);
    	assertEquals("The expected toString() return does not match expected. ",
    			"Range[-9.0,-5.0]",input1.toString());
    }
    
    
  /*----------shift Tests--------------*/
    /*
     * Testing shift function with delta of 0 on a Range with positive bounds 
     * Input: Range[1.0,5.0]
     * Expected result: Range[1.0,5.0]
     */
    @Test
    public void shiftPositiveAndPositiveRangeWith0Test() {
    	assertEquals("The expected shift of exampleRange2 does not match expected", Range.shift(exampleRange2, 0), new Range(1.0, 5.0));
    }
    
    /*
     * Testing shift function with delta of 0 on a Range with a negative bound 
     * Input: Range[-1.0,1.0]
     * Expected result: Range[-1.0,1.0]
     */
    @Test
    public void shiftPositiveAndNegativeRangeWith0Test() {
    	assertEquals("The expected shift of exampleRange2 does not match expected", Range.shift(exampleRange1, 0), new Range(-1.0, -1.0));
    }
    
    /*
     * Testing shift function with delta of 0 on a Range with negative bounds
     * Input: Range[-5.0,-1.0]
     * Expected result: Range[-5.0,-1.0]
     */
    @Test
    public void shiftNegativeAndNegativeRangeWith0Test() {
    	assertEquals("The expected shift of exampleRange2 does not match expected", Range.shift(exampleRange3, 0), new Range(-5.0, -1.0));
    }
    
    /*
     * Testing shift function with a positive delta on a Range with positive bounds 
     * Input: Range[1.0,5.0]
     * Expected result: Range[3.0,7.0]
     */
    @Test
    public void shiftPositiveAndPositiveRangeWithPositiveValueTest() {
    	assertEquals("The expected shift of exampleRange2 does not match expected", Range.shift(exampleRange2, 2), new Range(3.0, 7.0));
    }
    
    /*
     * Testing shift function with a negative delta on a Range with a negative bound 
     * Input: Range[1.0,5.0]
     * Expected result: Range[-1.0,3.0]
     */
    @Test
    public void shiftPositiveAndPositiveRangeWithNegativeValueTest() {
    	assertEquals("The expected shift of exampleRange2 does not match expected", Range.shift(exampleRange2, -2), new Range(-1.0, 3.0));
    }

    /*
     * Testing shift function with a positive delta on a Range with a negative bound 
     * Input: Range[-1.0,1.0]
     * Expected result: Range[1.0,3.0]
     */
    @Test
    public void shiftPositiveAndNegativeRangeWithPositiveValueTest() {
    	assertEquals("The expected shift of exampleRange1 does not match expected", Range.shift(exampleRange1, 2), new Range(1.0, 3.0));
    }
    
    /*
     * Testing shift function with a negative delta on a Range with a negative bound 
     * Input: Range[-1.0,1.0]
     * Expected result: Range[-3.0,-1.0]
     */
    @Test
    public void shiftPositiveAndNegativeRangeWithNegativeValueTest() {
    	assertEquals("The expected shift of exampleRange1 does not match expected", Range.shift(exampleRange1, -2), new Range(-3.0, -1.0));
    }

    /*
     * Testing shift function with a positive delta on a Range with negative bounds
     * Input: Range[-1.0,-5.0]
     * Expected result: Range[-3.0,-1.0]
     */
    @Test
    public void shiftNegativeAndNegativeRangeWithPositiveValueTest() {
    	assertEquals("The expected shift of exampleRange1 does not match expected", Range.shift(exampleRange3, 2), new Range(-3.0, 1.0));
    }

    /*
     * Testing shift function with a negative delta on a Range with negative bounds
     * Input: Range[-1.0,-5.0]
     * Expected result: Range[-3.0,-1.0]
     */
    @Test
    public void shiftNegativeAndNegativeRangeWithNegativeValueTest() {
    	assertEquals("The expected shift of exampleRange1 does not match expected", Range.shift(exampleRange3, -2), new Range(-7.0, -3.0));
    }
    
    /*----------intersection Tests--------------*/
    /*
     * Testing intersects function on ranges that intersect within bounds
     * Input: Range[-1.0,1.0] with 0.0 and 2.0
     * Expected result: True
     */
    @Test
    public void intersectsWithinBoundsTest() {
    	assertTrue("Ranges from -1 to 1 and 0 to 2 don't intersect as expected", exampleRange1.intersects(0.0, 2.0));
    }
    
    /*
     * Testing intersects function on ranges that intersect only on the bounds
     * Input: Range[-1.0,1.0] with 0.0 and 2.0
     * Expected result: True
     */
    @Test
    public void intersectsOnBoundsTest() {
    	assertTrue("Ranges from -1 to 1 and 1 to 2 don't intersect as expected", exampleRange1.intersects(1.0, 2.0));
    }
    
    /*
     * Testing intersects function on ranges that intersect only on the bounds
     * Input: Range[-1.0,1.0] with 2.0 and 3.0
     * Expected result: False
     */
    @Test
    public void intersectOutsideBoundsTest() {
    	assertFalse("Ranges from -1 to 1 and 2 to 3 shouldn't intersect", exampleRange1.intersects(2.0, 3.0));
    }
    
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
