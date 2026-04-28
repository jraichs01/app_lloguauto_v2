package com.llogaauto;

public class Cotxe extends Automobil {
    private int numPortes;

    // Constructor
    public Cotxe(String marca, String model, String matricula, TipusCombustible combustible,int numeroPortes){
        // Cridem el constructor de la classe pare
        super(marca,model,matricula,combustible);
        this.numPortes = numeroPortes;
    }

    public Cotxe(){
        super("","","",null);
        this.numPortes = 0;
    }

    // Setters i Getters
    public int getNumPortes() {
        return numPortes;
    }

    public void setNumPortes(int numPortes) {
        this.numPortes = numPortes;
    }

    // sobrecarreguem la funció mostrar dades
    @Override
    public String mostrarDades(){
        return super.mostrarDades() + " Numero de portes : " + this.numPortes;
    }
 
}
