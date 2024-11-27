/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Examen;

/**
 *
 * @author Gustavo Perdomo 20241220595
 */
public class Auto extends Vehiculo {
    private boolean radio;
    private boolean navegador;

    public Auto(String placa, String marca, double precio, int cilindraje, boolean radio, boolean navegador) {
        super(placa, marca, precio, cilindraje);
        this.radio = radio;
        this.navegador = navegador;

        double impuestoAdicional = 0;
        if (radio) impuestoAdicional += precio * 0.01;
        if (navegador) impuestoAdicional += precio * 0.02;
        
        setImpuestoCirculacion(getImpuestoCirculacion() + impuestoAdicional);
        if (cilindraje > 2499) setCuotaMesGaraje(getCuotaMesGaraje() * 1.2);
    }

    public boolean tieneRadio() {
        return radio;
    }

    public void setRadio(boolean radio) {
        this.radio = radio;
    }

    public boolean tieneNavegador() {
        return navegador;
    }

    public void setNavegador(boolean navegador) {
        this.navegador = navegador;
    }
}