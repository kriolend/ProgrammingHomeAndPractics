package ua.org.oa.rumyancevv.practics2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayProdTest{
    int[] mass;
    ArrayProd ars;
    ArrayProd ars1;

    @Test
    public void testSum1() {
        int expecteds = 10;
        int octual = ars.Sum();
        Assert.assertEquals("Mesage", expecteds, octual, 0.001);

    }

    @Before
    public void initMass() {
        mass = new int[]{3, 3, 4};
        ars = new ArrayProd(mass);
        ars1 = new ArrayProd(mass);
    }
}