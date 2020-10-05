package com.sbilyi.education.effectivejava.builder;

/**
 * Calzone pizza
 */
public class Calzone extends Pizza {

    private final Boolean sauseInside;

    public boolean isSauseInside() {
        return sauseInside;
    }
    public static class Builder extends Pizza.Builder<Builder>{

        private boolean sauseInside;

        public Builder sauseInside() {
            this.sauseInside = true;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        Calzone build() {
            return new Calzone(this);
        }
    }

    Calzone(Builder builder) {
        super(builder);
        this.sauseInside = builder.sauseInside;
    }
}
