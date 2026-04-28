package com.llogaauto;

import java.util.ArrayList;
import java.util.Iterator;

public class GestorAutomobils {

    // Atributs privats
    private ArrayList<Automobil> llistaAutomobils;

   // Constructor per defecte
    public GestorAutomobils() {
        this.llistaAutomobils = new ArrayList<>();
    }

    // Metode per afegir un automobil a la llista
    public void afegirAutomobil(Automobil auto) {
        if(auto != null && !existeixAutomobil(auto.getMatricula())){
            llistaAutomobils.add(auto);
        } else {
            System.out.println("No s'ha pogut afegir l'automòbil. Matricula ja existeix o és null.");
        }
    }

    // Metode per eliminar un automobil per matricula. Utilitzan un iterador
    public void eliminarAutomobil(String matricula) {
        Iterator<Automobil> it = llistaAutomobils.iterator();
        boolean eliminat = false;

        while (it.hasNext() && !eliminat) {
            Automobil auto = it.next();
            if (auto.getMatricula().equals(matricula)) {
                it.remove();
                eliminat = true;
            }
        }
        if (!eliminat) {
            System.out.println("No s'ha trobat l'automòbil amb matrícula: " + matricula);
        }   
    }

    // Metode per llistar tots els automobils   
    public void llistarAutomobils() {
        if (llistaAutomobils.isEmpty()) {
            System.out.println("No hi ha automòbils a la llista.");
        } else {
            for (Automobil auto : llistaAutomobils) {
                System.out.println(auto.mostrarDades());
            }
        }       
    }

    //  Metode per comprovar si existeix un automobil a la llista per matricula. Utilitzan un iterador
    public boolean existeixAutomobil(String matricula) {
        Iterator<Automobil> it = llistaAutomobils.iterator();
        while (it.hasNext()) {
            Automobil auto = it.next();
            if (auto.getMatricula().equals(matricula)) {
                return true;
            }
        }
        return false;
    }

}