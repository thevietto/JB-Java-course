package ru.kpfu.itis.util;


import org.junit.*;
import org.junit.runner.RunWith;

//@RunWith()
public class CalculatorTest {

    Calculator c;

    @Before
    public void setUp() {
        c = new Calculator();
    }

    @After
    public void tearDown() {

    }

    @BeforeClass
    public void beforeClass() {

    }

    @Test
    public void tessSum() {
        int a = c.sum(1, 3);
        Assert.assertEquals(4, a);
    }

    @Test
    public void testDiv() {
        int a = c.dev(4, 2);
        Assert.assertEquals(2, a);
    }


    @Test(expected = ArithmeticException.class)
    public void devByZero() {
        int a = c.dev(4, 0);
    }

}
