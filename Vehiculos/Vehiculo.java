/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Examen;

/**
 *
 * @author Gustavo Perdomo 20241220595
 */
public class Vehiculo {
    private String placa;
    private String marca;
    private double precio;
    private int cilindraje;
    private double impuestoCirculacion;
    private double cuotaMesGaraje;

    public static final double CUOTA_MENSUAL_BASE = 100;

    public Vehiculo(String placa, String marca, double precio, int cilindraje) {
        this.placa = placa;
        this.marca = marca;
        this.precio = precio;
        this.cilindraje = cilindraje;
        this.impuestoCirculacion = precio * 0.02;
        this.cuotaMesGaraje = CUOTA_MENSUAL_BASE;
    }

    public double getImpuestoCirculacion() {
        return impuestoCirculacion;
    }

    public void setImpuestoCirculacion(double impuestoCirculacion) {
        this.impuestoCirculacion = impuestoCirculacion;
    }

    public double getCuotaMesGaraje() {
        return cuotaMesGaraje;
    }

    public void setCuotaMesGaraje(double cuotaMesGaraje) {
        if (cuotaMesGaraje >= 0) {
            this.cuotaMesGaraje = cuotaMesGaraje;
        }
    }

    public String getPlaca() {
        return placa;
    }
}