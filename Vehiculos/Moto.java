/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Examen;

/**
 *
 * @author Gustavo Perdomo 20241220595
 */
public class Moto extends Vehiculo {
    private boolean sidecar;

    public Moto(String placa, String marca, double precio, int cilindraje, boolean sidecar) {
        super(placa, marca, precio, cilindraje);
        this.sidecar = sidecar;
        
        if (sidecar) {
            setImpuestoCirculacion(getImpuestoCirculacion() * 1.1);
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.5);
        }
    }

    public boolean tieneSidecar() {
        return sidecar;
    }

    public void setSidecar(boolean sidecar) {
        this.sidecar = sidecar;
    }
}
