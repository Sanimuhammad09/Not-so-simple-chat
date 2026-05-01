package com.example.coffeeshop.template;

public abstract class CoffeePreparationTemplate {

    public final void prepareCoffee() {
        boilWater();
        brewCoffeeGrinds();
        pourInCup();
        addCondiments();
    }

    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    protected abstract void brewCoffeeGrinds();
    protected abstract void addCondiments();
}

class EspressoPreparation extends CoffeePreparationTemplate {
    @Override
    protected void brewCoffeeGrinds() {
        System.out.println("Dripping espresso through filter");
    }

    @Override
    protected void addCondiments() {
        // Espresso has no condiments usually
    }
}
