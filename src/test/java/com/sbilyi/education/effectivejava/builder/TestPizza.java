package com.sbilyi.education.effectivejava.builder;

import junit.framework.TestCase;

import static com.sbilyi.education.effectivejava.builder.NyPizza.Size.SMALL;

/**
 * Tests {@link Pizza} and its subclasses
 */
public class TestPizza extends TestCase {
    public void testNyPizza() {
        NyPizza pizza = new NyPizza.Builder(SMALL).addToppping(Pizza.Topping.HAM).addToppping(Pizza.Topping.PEPER).build();
        assertEquals(pizza.toppings.size(), 2);
        assertTrue(pizza.toppings.contains(Pizza.Topping.HAM));
        assertTrue(pizza.toppings.contains(Pizza.Topping.PEPER));
        assertEquals(pizza.getSize(), SMALL);
    }

    public void testCalzonePizza() {
        Calzone pizza = new Calzone.Builder().addToppping(Pizza.Topping.HAM).addToppping(Pizza.Topping.PEPER).build();
        assertEquals(pizza.toppings.size(), 2);
        assertTrue(pizza.toppings.contains(Pizza.Topping.HAM));
        assertTrue(pizza.toppings.contains(Pizza.Topping.PEPER));
        assertFalse(pizza.isSauseInside());
    }
}
