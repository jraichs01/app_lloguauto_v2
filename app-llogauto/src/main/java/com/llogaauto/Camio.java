package com.llogaauto;

public class Camio extends Automobil{
    private float tara;
    private float pesMaxim;

     // Constructor per defecte i constructor amb paràmetres
    public Camio(String marca, String model, String matricula, TipusCombustible combustible,float tara,float pesMaxim){
        super(marca,model,matricula,combustible); //crida al constructor de la classe pare
        this.tara = tara;
        this.pesMaxim = pesMaxim;
    }

    public Camio(){
        super("","","",null);
        this.tara = 0;
        this.pesMaxim = 0;
    }

    // Getters i Setters   
    public float getTara() {
        return tara;
    }

    public void setTara(float tara) {
        this.tara = tara;
    }

    public float getPesMaxim() {
        return pesMaxim;
    }

    public void setPesMaxim(float pesMaxim) {
        this.pesMaxim = pesMaxim;
    }

    // Sobrecarreguem mostrarDades de la classe pare
    @Override
    public String mostrarDades(){
        return super.mostrarDades() + " Tara : " + this.tara + " Pes Màxim : " + this.pesMaxim;
    }

}
