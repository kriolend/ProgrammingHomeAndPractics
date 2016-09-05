package ua.org.oa.rumyancevv.practics2;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArraySumTest {
    @Test
    public void testSum() {
        int expecteds = 10;
        int octual = ArraySum.Sum(mass);
        Assert.assertEquals("Mesage", expecteds, octual, 0.001);

    }

    @Test
    public void testSum1() {
        int expecteds = 10;
        int octual = ars.Sum();
        Assert.assertEquals("Mesage", expecteds, octual, 0.001);

    }

    @Test(expected = java.lang.NullPointerException.class)
    public void nullMas() {
        ars1.Sum(null);
    }

    int[] mass;
    ArraySum ars;
    ArraySum ars1;

    @Before
    public void initMass() {
        mass = new int[]{3, 3, 4};
        ars = new ArraySum(mass);
        ars1 = new ArraySum(mass);
    }

}