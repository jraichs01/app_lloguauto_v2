package com.llogaauto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            GestorAutomobils agencia = new GestorAutomobils();
            menu(agencia, sc);
        } catch(Exception e) {
            System.out.println("S'ha produït un error: " + e.getMessage() + ". El programa es tancarà.");
        }

        System.out.println("Programa finalitzat.");
    }

    public static void menu(GestorAutomobils agencia, Scanner sc) {
        boolean sortir = false;

        while (!sortir) {
            System.out.println("\n--- GESTIÓ DE FLOTA ---");
            System.out.println("1. Afegir Cotxe");
            System.out.println("2. Afegir Camion");
            System.out.println("3. Eliminar Automòbil");
            System.out.println("4. Llistar Vehicles");
            System.out.println("5. Sortir");
            System.out.print("Tria una opció: ");

            if (sc.hasNextInt()) {
                int opcio = sc.nextInt();
                sc.nextLine();

                switch (opcio) {
                    case 1: // usuari ha triat afegir cotxe
                        Cotxe cotxe = crearCotxe(sc);
                        if (cotxe != null) {
                            if (!agencia.existeixAutomobil(cotxe.getMatricula())) {
                                agencia.afegirAutomobil(cotxe);
                                System.out.println("Cotxe afegit correctament.");
                            } else {
                                System.out.println("El cotxe ja existeix!");
                            }
                        }
                        break;

                    case 2:
                        Camio camio = crearCamio(sc);
                        if (camio != null) {
                            if (!agencia.existeixAutomobil(camio.getMatricula())) {
                                agencia.afegirAutomobil(camio);
                                System.out.println("Camió afegit correctament.");
                            } else {
                                System.out.println("El camió ja existeix!");
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Matrícula a eliminar: ");
                        String matricula = sc.nextLine().trim();
                        if (matricula.isEmpty()) {
                            System.out.println("Matrícula no vàlida.");
                        } else {
                            if (agencia.existeixAutomobil(matricula)) {
                                agencia.eliminarAutomobil(matricula);
                                System.out.println("Automòbil eliminat.");
                            } else {
                                System.out.println("Automòbil no trobat.");
                            }
                            agencia.llistarAutomobils(); // mostrar llista actualitzada després de l'eliminació
                        }
                        break;

                    case 4:
                        agencia.llistarAutomobils();
                        break;

                    case 5:
                        sortir = true;
                        break;

                    default:
                        System.out.println("Opció no vàlida (1-5).");
                }
            } else {
                sc.nextLine(); // clear invalid input
                System.out.println("Opció invàlida. Introdueix un número (1-5).");
            }
        }
    }

     private static Cotxe crearCotxe(Scanner sc){
        String matricula = "";

        System.out.print("Marca: ");
        String mc = sc.nextLine();
        System.out.print("Model: ");
        String modc = sc.nextLine();
        
        System.out.print("Matrícula: ");
        while (Automobil.validarMatricula(matricula) == false){
            matricula = sc.nextLine();
            if(Automobil.validarMatricula(matricula)==false){
                System.out.print("Matricula incorrecta!! Matrícula: ");
            } else{
                break;
            }
        }
       
        System.out.print("Numero de portes: ");
        int nump = Integer.parseInt(sc.nextLine());
        TipusCombustible tcombustible = seleccionarCombustible(sc);
        
        Cotxe cotxe = new Cotxe(mc, modc, matricula, tcombustible, nump);
        return cotxe;
    }

    private static Camio crearCamio(Scanner sc){
        String matricula = "";

        System.out.print("Marca: ");
        String mc = sc.nextLine();
        System.out.print("Model: ");
        String modc = sc.nextLine();

        System.out.print("Matrícula: ");
        while (Automobil.validarMatricula(matricula) == false){
            matricula = sc.nextLine();
            if(Automobil.validarMatricula(matricula)==false){
                System.out.print("Matricula incorrecta!! Matrícula: ");
            } else{
                break;
            }
        }
   
        System.out.print("Tara: ");
        Float tara = Float.parseFloat(sc.nextLine());
        System.out.print("Pes Màxim: ");
        Float pesMaxim = Float.parseFloat(sc.nextLine());
        TipusCombustible tcombustible = seleccionarCombustible(sc);
        
        Camio camio = new Camio(mc, modc, matricula,tcombustible,tara,pesMaxim);
        return camio;
    }

    private static TipusCombustible seleccionarCombustible(Scanner sc) {
        System.out.println("Tria el combustible:");
        TipusCombustible[] valors = TipusCombustible.values();
        for (int i = 0; i < valors.length; i++) {
            System.out.println(i + ". " + valors[i]);
        }
        int tria = sc.nextInt();
        return valors[tria];
    }

}
