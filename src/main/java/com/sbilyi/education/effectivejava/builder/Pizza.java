package com.sbilyi.education.effectivejava.builder;

import java.util.EnumSet;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

import static java.util.Objects.requireNonNull;

/**
 * Pizza represents Builder pattern from 2.2 of Effective Java
 *
 */
public abstract class Pizza {
    public enum Topping {
        HAM, MUSHROOM, ONION, PEPER, SAUSAGE
    }
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        private Set<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addToppping(Topping topping) {
            toppings.add(requireNonNull(topping, "Can't add null as topping"));
            return self();
        }

        protected abstract T self();
        abstract Pizza build();
    }

    Pizza(Builder<?> builder) {
        this.toppings = ImmutableSet.copyOf(builder.toppings);
    }
}
