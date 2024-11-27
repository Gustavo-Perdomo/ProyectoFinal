/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Examen;

/**
 *
 * @author Gustavo Perdomo 20241220595
 */
import java.util.ArrayList;

public class RedGarajes {
    private ArrayList<Garaje> listaGarajes;

    public RedGarajes() {
        this.listaGarajes = new ArrayList<>();
    }

    // Para agregar un garaje
    public void agregarGaraje(Garaje garaje) throws ExcepcionGaraje {
        if (garaje == null) {
            throw new ExcepcionGaraje("El garaje no puede ser nulo.");
        }
        listaGarajes.add(garaje);
    }

    // Para eliminar un garaje
    public void eliminarGaraje(Garaje garaje) throws ExcepcionGaraje {
        if (!listaGarajes.remove(garaje)) {
            throw new ExcepcionGaraje("El garaje no existe en la red.");
        }
    }

    // Para buscar un garaje por dirección
    public Garaje buscarGaraje(String direccion) {
        for (Garaje g : listaGarajes) {
            if (g.getDireccion().equalsIgnoreCase(direccion)) {
                return g;
            }
        }
        return null; // Por si no lo encuentra
    }

    // Para verificar si un vehículo ya está registrado en algún otro garaje
    public boolean verificarVehiculoEnRed(String placa) {
        for (Garaje garaje : listaGarajes) {
            if (garaje.buscarVehiculo(placa) != null) {
                return true;
            }
        }
        return false;
    }

    // Para mostrar la ocupación de los garajes
    public void mostrarOcupacionPorGaraje() {
        for (Garaje garaje : listaGarajes) {
            System.out.println("Garaje en " + garaje.getDireccion() + ":");
            System.out.println("Ocupación: " + garaje.calcularOcupacion() + "/" + garaje.getNumeroEspacios());
        }
    }

    // Para mostrar recaudo mensual por garaje
    public void mostrarRecaudoMensual() {
        double totalRecaudo = 0;
        for (Garaje garaje : listaGarajes) {
            double recaudoGaraje = garaje.calcularIngresos();
            totalRecaudo += recaudoGaraje;
            System.out.println("Recaudo mensual en garaje (" + garaje.getDireccion() + "): $" + recaudoGaraje);
        }
        System.out.println("Recaudo total: $" + totalRecaudo);
    }
}