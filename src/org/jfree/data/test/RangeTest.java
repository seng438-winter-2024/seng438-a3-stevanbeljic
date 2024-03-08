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
    
    /*
     * New Tests Added
     */
    
    
    @Test(expected = IllegalArgumentException.class)
    public void constructorLowerGreaterThanUpperTest() {
    	Range example = new Range(2, 1);
    }
    
    @Test
    public void containsValueLessThanLowerTest() {
    	assertFalse(exampleRange1.contains(-2));
    }
    
    @Test
    public void containsValueGreaterThanUpperTest() {
    	assertFalse(exampleRange1.contains(2));
    }
    
    @Test
    public void containsValueBetweenBoundsTest() {
    	assertFalse(exampleRange1.contains(0));
    }
    
    
    @Test
    public void expandTest() {
        assertEquals(Range.expand(exampleRange1, 0.1, 0.1), new Range(-1.1, 1.1));
    }
    
    @Test
    public void shiftAllowZerocrossingTest() {
        assertEquals(Range.shift(exampleRange1, 1, true), new Range(0, 2));
    }
    
    @Test
    public void shiftWithNoZeroCrossingTest() {
        assertEquals(Range.shift(new Range(0,1), 1, false), new Range(1,2));
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void scaleWithNegativeFactorTest() {
        Range test = Range.scale(exampleRange1, -2);
    }
    
    @Test
    public void scaleWithPositiveFactorTest() {
        assertEquals(Range.scale(exampleRange1, 2), new Range(-2, 2));
    }
    
    @Test
    public void equalsNotWithRangeTest() {
        assertFalse(exampleRange1.equals(new Object()));
    }
    
    @Test
    public void BothNaNRangeTest() {
        assertTrue(new Range(2.0 % 0, 2.0 % 0).isNaNRange());
    }
    
    @Test
    public void constrainWithContainTest() {
        assertTrue(exampleRange1.constrain(0) == 0.0);
    }
    
    @Test
    public void constrainCloseToUpper() {
        assertTrue(exampleRange1.constrain(2) == 1.0);
    }
    
    @Test
    public void constrainCloseToLower() {
        assertTrue(exampleRange1.constrain(-2) == -1.0);
    }
    
    @Test
    public void combineIgnoringNaNRange1NullTest() {
        assertNull(Range.combineIgnoringNaN(null, new Range(2.0 % 0, 2.0 % 0)));
    }
    
    @Test
    public void combineIgnoringNaNRange2NullTest() {
        assertNull(Range.combineIgnoringNaN(new Range(2.0 % 0, 2.0 % 0), null));
    }
    
    @Test
    public void combineIgnoringNaNBothNanNullTest() {
        assertNull(Range.combineIgnoringNaN(new Range(2.0 % 0, 2.0 % 0), new Range(2.0 % 0, 2.0 % 0)));
    }
    
    @Test
    public void maxD2NaNTest() {
        assertTrue(Range.combineIgnoringNaN(exampleRange1, new Range(0, 2.0 % 0)) == exampleRange1);
    }
    
    @Test
    public void minD2NaNTest() {
        assertTrue(Range.combineIgnoringNaN(exampleRange1, new Range(2.0 % 0, 0)) == exampleRange1);
    }
    
    
    
 // Test cases for contains(double value) ___________-------- aaron stuff
    @Test
    public void containsValueBelowLowerBound() {
        assertFalse("Value below lower bound should return false", exampleRange1.contains(-2.0));
    }

    @Test
    public void containsValueAboveUpperBound() {
        assertFalse("Value above upper bound should return false", exampleRange1.contains(2.0));
    }

    @Test
    public void containsValueWithinRange() {
        assertTrue("Value within range should return true", exampleRange1.contains(0.5));
    }

    @Test
    public void containsValueEqualToLowerBound() {
        assertTrue("Value equal to lower bound should return true", exampleRange1.contains(-1.0));
    }

    @Test
    public void containsValueEqualToUpperBound() {
        assertTrue("Value equal to upper bound should return true", exampleRange1.contains(1.0));
    }
    
    
    // Test for combine()
    @Test
    public void combineWithNullRanges() {
        assertNull("Combining two null ranges should return null",
                   Range.combine(null, null));
    }

    @Test
    public void combineWithOneNullRange() {
        assertEquals("Combining one null range with another should return the non-null range",
                     exampleRange1, Range.combine(exampleRange1, null));
        assertEquals("Combining one null range with another should return the non-null range",
                     exampleRange1, Range.combine(null, exampleRange1));
    }

    @Test
    public void combineWithBothNonNullRanges() {
        Range combinedRange = Range.combine(exampleRange1, exampleRange2);
        assertEquals("Combining two non-null ranges should return the combined range",
                     new Range(-1, 5), combinedRange);
    }

    // Test for combineIgnoringNaN()
    @Test
    public void combineIgnoringNaNWithNullRanges() {
        assertNull("Combining two null ranges should return null",
                   Range.combineIgnoringNaN(null, null));
    }

    @Test
    public void combineIgnoringNaNWithOneNullRange() {
        assertEquals("Combining one null range with another should return the non-null range",
                     exampleRange1, Range.combineIgnoringNaN(exampleRange1, null));
        assertEquals("Combining one null range with another should return the non-null range",
                     exampleRange1, Range.combineIgnoringNaN(null, exampleRange1));
    }

    @Test
    public void combineIgnoringNaNWithBothNonNullRanges() {
        Range combinedRange = Range.combineIgnoringNaN(exampleRange1, exampleRange2);
        assertEquals("Combining two non-null ranges should return the combined range",
                     new Range(-1, 5), combinedRange);
    }

    @Test
    public void combineIgnoringNaNWithNaNRanges() {
        Range nanRange1 = new Range(Double.NaN, Double.NaN);
        Range nanRange2 = new Range(2, 4);
        assertNull("Combining two NaN ranges should return null",
                   Range.combineIgnoringNaN(nanRange1, nanRange2));
    }

    // Test for expandToInclude()
    @Test
    public void expandToIncludeWithNullRange() {
        assertEquals("Expanding a null range with a value should return a new range with that value",
                     new Range(5, 5), Range.expandToInclude(null, 5));
    }

    @Test
    public void expandToIncludeWithValueBelowLowerBound() {
        assertEquals("Expanding a range with a value below the lower bound should return a new range with the updated lower bound",
                     new Range(-2, 1), Range.expandToInclude(exampleRange1, -2));
    }

    @Test
    public void expandToIncludeWithValueAboveUpperBound() {
        assertEquals("Expanding a range with a value above the upper bound should return a new range with the updated upper bound",
                     new Range(-1, 2), Range.expandToInclude(exampleRange1, 2));
    }

    @Test
    public void expandToIncludeWithValueWithinBounds() {
        assertEquals("Expanding a range with a value within bounds should return the original range",
                     exampleRange1, Range.expandToInclude(exampleRange1, 0.5));
    }
    
    
    @Test(expected = IllegalArgumentException.class)
    public void getLowerboundWithIllegalRange() {
    	Range newRange = new Range(4, 1);
    	assertEquals("Expanding a range with a value within bounds should return the original range",
                4, newRange.getLowerBound());
    }
    
    
    @Test
    public void intersectsWithIntersectingRange() {
        // Create a new Range object with bounds that intersect exampleRange1
        Range intersectingRange = new Range(0, 2);
        
        // Check if intersectingRange intersects with exampleRange1
        assertTrue("Ranges should intersect", exampleRange1.intersects(intersectingRange));
    }

    @Test
    public void intersectsWithNonIntersectingRange() {
        // Create a new Range object with bounds that don't intersect exampleRange1
        Range nonIntersectingRange = new Range(2, 3);
        
        // Check if nonIntersectingRange intersects with exampleRange1
        assertFalse("Ranges should not intersect", exampleRange1.intersects(nonIntersectingRange));
    }
    
    
    @Test
    public void hashCodeWithEqualRanges() {
        // Create another Range object with the same bounds as exampleRange1
        Range equalRange = new Range(-1, 1);
        
        // Check if the hash codes are equal
        assertEquals("Hash codes should be equal", exampleRange1.hashCode(), equalRange.hashCode());
    }

    @Test
    public void hashCodeWithDifferentRanges() {
        // Create another Range object with different bounds from exampleRange1
        Range differentRange = new Range(-2, 2);
        
        // Check if the hash codes are different
        assertNotEquals("Hash codes should not be equal", exampleRange1.hashCode(), differentRange.hashCode());
    }
    
    
    // Test case for intersects(double b0, double b1)
    @Test
    public void intersectsWhenB1GreaterThanLower() {
    	Range testingRange = new Range(5,20);
        assertTrue("When b1 is greater than lower, the method should return true",
        		testingRange.intersects(-50, -10));
    }
    
    
    
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
