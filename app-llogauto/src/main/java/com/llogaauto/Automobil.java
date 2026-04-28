package com.llogaauto;

public abstract class Automobil {
    // Atributs privats
    private String marca;
    private String model;
    private String matricula;

    // atribut de tipus enumerat per al tipus de combustible. Exemple de tipus
    // enumerat: BENZINA_95, BENZINA_98, DIESEL, ELECTRIC, HIBRID
    protected TipusCombustible combustible;

    // Atribut de classe per comptar el nombre d'automobils creats
    private static int comptador = 0;

    // Constructors: un constructor per defecte i un constructor amb paràmetres
    Automobil(String mar, String mod, String mat, TipusCombustible combu) {
        this.marca = mar;
        this.model = mod;
        this.matricula = mat;
        this.combustible = combu;
        Automobil.comptador++;
    }

    Automobil() {
        this.marca = "";
        this.model = "";
        this.matricula = "";
        this.combustible = null;
        Automobil.comptador++;
    }

    // Getters i Setters
    public String getMarca() {
        return this.marca;
    }

    public String getModel() {
        return model;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public TipusCombustible getCombustible() {
        return combustible;
    }

    public void setCombustible(TipusCombustible combustible) {
        this.combustible = combustible;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    // Metode per mostrar les dades de l'automobil. SOBRECARREGUT a les classes filles
    public String mostrarDades() {
        return " marca : " + this.marca + "   model: " + this.model
                + "  matricula: " + this.matricula + " Combustible: " + this.combustible;
    }

    // Metodes de classe per accedir al comptador d'automobils creats
    public static int getComptador() {
        return comptador;
    }

    // Metode de classe per validar la matricula d'un automobil.
    public static boolean validarMatricula(String matricula) {
        // Regex: 4 dígits + 3 lletres majúscules (excloent vocals segons l'estàndard i el test)
        return matricula != null && matricula.matches("^[0-9]{4}[BCDFGHJKLMNPQRSTVWXYZ]{3}$");
    }

}
