package com.smn.pizzassalvadormellado.models;

import java.util.ArrayList;

public class Pizza {
    private String nombrePizza;
    private String ingredientePrincipal;
    private String basePizza;
    // Ingredientes
    private boolean cebolla;
    private boolean champinion;
    private boolean morron;
    private boolean tomate;
    private boolean tomateCherry;
    private boolean palta;
    // aliños
    private boolean ajo;
    private boolean albaca;
    private boolean oregano;
    private int precioPizza;

    public Pizza() { }

    public Pizza(String nombrePizza, String ingredientePrincipal, String basePizza, boolean cebolla, boolean champinion, boolean morron, boolean tomate, boolean tomateCherry, boolean palta, boolean ajo, boolean albaca, boolean oregano, int precioPizza) {
        this.nombrePizza = nombrePizza;
        this.ingredientePrincipal = ingredientePrincipal;
        this.basePizza = basePizza;
        this.cebolla = cebolla;
        this.champinion = champinion;
        this.morron = morron;
        this.tomate = tomate;
        this.tomateCherry = tomateCherry;
        this.palta = palta;
        this.ajo = ajo;
        this.albaca = albaca;
        this.oregano = oregano;
        this.precioPizza += precioPizza;
    }

    public Pizza(String nombrePizza, String ingredientePrincipal, String basePizza, boolean cebolla, boolean champinion, boolean morron, boolean tomate, boolean tomateCherry, boolean palta, boolean ajo, boolean albaca, boolean oregano) {
        this.nombrePizza = nombrePizza;
        this.ingredientePrincipal = ingredientePrincipal;
        this.basePizza = basePizza;
        this.cebolla = cebolla;
        this.champinion = champinion;
        this.morron = morron;
        this.tomate = tomate;
        this.tomateCherry = tomateCherry;
        this.palta = palta;
        this.ajo = ajo;
        this.albaca = albaca;
        this.oregano = oregano;
    }

    public String getNombrePizza() {
        return nombrePizza;
    }

    public void setNombrePizza(String nombrePizza) {
        this.nombrePizza = nombrePizza;
    }

    public String getIngredientePrincipal() {
        return ingredientePrincipal;
    }

    public void setIngredientePrincipal(String ingredientePrincipal) {
        this.ingredientePrincipal = ingredientePrincipal;
    }

    public String getBasePizza() {
        return basePizza;
    }

    public void setBasePizza(String basePizza) {
        this.basePizza = basePizza;
    }

    public boolean isCebolla() {
        return cebolla;
    }

    public void setCebolla(boolean cebolla) {
        this.cebolla = cebolla;
    }

    public boolean isChampinion() {
        return champinion;
    }

    public void setChampinion(boolean champinion) {
        this.champinion = champinion;
    }

    public boolean isMorron() {
        return morron;
    }

    public void setMorron(boolean morron) {
        this.morron = morron;
    }

    public boolean isTomate() {
        return tomate;
    }

    public void setTomate(boolean tomate) {
        this.tomate = tomate;
    }

    public boolean isTomateCherry() {
        return tomateCherry;
    }

    public void setTomateCherry(boolean tomateCherry) {
        this.tomateCherry = tomateCherry;
    }

    public boolean isPalta() {
        return palta;
    }

    public void setPalta(boolean palta) {
        this.palta = palta;
    }

    public boolean isAjo() {
        return ajo;
    }

    public void setAjo(boolean ajo) {
        this.ajo = ajo;
    }

    public boolean isAlbaca() {
        return albaca;
    }

    public void setAlbaca(boolean albaca) {
        this.albaca = albaca;
    }

    public boolean isOregano() {
        return oregano;
    }

    public void setOregano(boolean oregano) {
        this.oregano = oregano;
    }

    public int getPrecioPizza() {
        return precioPizza;
    }

    public void setPrecioPizza(int precioPizza) {
        this.precioPizza += precioPizza;
    }
}
