package com.sbilyi.education.effectivejava.builder;

/**
 * New York sized pizza
 */
public class NyPizza extends Pizza {

    public enum Size{SMALL, MEDIUM, LARGE;}
    private final Size size;

    public Size getSize() {
        return size;
    }

    public static class Builder extends Pizza.Builder<Builder> {

        private final Size size;

        public Builder(Size size) {
            this.size = size;
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        NyPizza build() {
            return new NyPizza(this);
        }
    }

    NyPizza(Builder builder) {
        super(builder);
        this.size = builder.size;
    }
}
