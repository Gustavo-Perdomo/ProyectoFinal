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

public class Garaje {
    private String departamento;
    private String ciudad;
    private String direccion;
    private String telefono;
    private String email;
    private String nombreAdministrador;
    private int numeroEspacios;
    private ArrayList<Vehiculo> espacios;

    
    public Garaje(String departamento, String ciudad, String direccion, String telefono, String email, String nombreAdministrador, int numeroEspacios) {
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.nombreAdministrador = nombreAdministrador;
        this.numeroEspacios = numeroEspacios;
        this.espacios = new ArrayList<>(numeroEspacios);
    }

    
    public String getDepartamento() {
        return departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getNombreAdministrador() {
        return nombreAdministrador;
    }

    public int getNumeroEspacios() {
        return numeroEspacios;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public boolean validarIngresoCamion(Camion camion) throws ExcepcionGaraje {
        int maxCamiones = numeroEspacios < 100 ? 10 : 20;
        int camionesRegistrados = 0;

        for (Vehiculo v : espacios) {
            if (v instanceof Camion) {
                camionesRegistrados++;
            }
        }

        if (camionesRegistrados >= maxCamiones) {
            throw new ExcepcionGaraje("Número máximo de camiones alcanzado en este garaje.");
        }
        return true;
    }

    public boolean validarIngresoMoto(Moto moto) throws ExcepcionGaraje {
        int maxMotos = (int) (numeroEspacios * 0.2);
        int motosRegistradas = 0;

        for (Vehiculo v : espacios) {
            if (v instanceof Moto) {
                motosRegistradas++;
            }
        }

        if (motosRegistradas >= maxMotos) {
            throw new ExcepcionGaraje("Número máximo de motos alcanzado en este garaje.");
        }
        return true;
    }

    
    public double calcularIngresos() {
        double totalIngresos = 0;
        for (Vehiculo vehiculo : espacios) {
            if (vehiculo != null) {
                totalIngresos += vehiculo.getCuotaMesGaraje();
            }
        }
        return totalIngresos;
    }

   
    public Vehiculo buscarVehiculo(String placa) {
        for (Vehiculo vehiculo : espacios) {
            if (vehiculo != null && vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                return vehiculo;
            }
        }
        return null; 
    }

   
    public int calcularOcupacion() {
        int ocupados = 0;
        for (Vehiculo vehiculo : espacios) {
            if (vehiculo != null) {
                ocupados++;
            }
        }
        return ocupados;
    }

    
    public void agregarVehiculo(Vehiculo vehiculo) throws ExcepcionGaraje {
        if (vehiculo == null) {
            throw new ExcepcionGaraje("El vehículo no puede ser nulo.");
        }
        if (calcularOcupacion() >= numeroEspacios) {
            throw new ExcepcionGaraje("No hay espacios disponibles en este garaje.");
        }
        
       
        if (vehiculo instanceof Camion) {
            validarIngresoCamion((Camion) vehiculo);
        } else if (vehiculo instanceof Moto) {
            validarIngresoMoto((Moto) vehiculo);
        }

        espacios.add(vehiculo);
    }

    
    public void retirarVehiculo(String placa) throws ExcepcionGaraje {
        Vehiculo vehiculo = buscarVehiculo(placa);
        if (vehiculo == null) {
            throw new ExcepcionGaraje("El vehículo con la placa " + placa + " no se encuentra en este garaje.");
        }
        espacios.remove(vehiculo);
    }
}
