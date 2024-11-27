/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Examen;

/**
 *
 * @author Gustavo Perdomo 20241220595
 */
public class Camion extends Vehiculo {
    private int ejes;
    private String tipo;
    private double carga;

    public Camion(String placa, String marca, double precio, int cilindraje, int ejes, String tipo, double carga) {
        super(placa, marca, precio, cilindraje);

        if (tipo.equalsIgnoreCase("Sencillo")) {
            if (ejes != 2) throw new IllegalArgumentException("Un camión sencillo debe tener exactamente 2 ejes.");
            this.tipo = "Sencillo";
            this.ejes = 2;
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.75);
        } else if (tipo.equalsIgnoreCase("Doble")) {
            if (ejes < 3 || ejes > 6) throw new IllegalArgumentException("Un camión doble debe tener entre 3 y 6 ejes.");
            this.tipo = "Doble";
            this.ejes = ejes;
            setCuotaMesGaraje(getCuotaMesGaraje() * 2.25);
        } else {
            throw new IllegalArgumentException("Tipo de camión no válido. Debe ser 'Sencillo' o 'Doble'.");
        }
        this.carga = carga;

        double impuestoAdicional = (carga / 5) * 10;
        setImpuestoCirculacion(getPrecio() * 0.09 + impuestoAdicional);
    }

    public int getEjes() {
        return ejes;
    }

    public String getTipo() {
        return tipo;
    }

    public double getCarga() {
        return carga;
    }

    private double getPrecio() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
