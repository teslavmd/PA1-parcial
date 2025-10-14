package model;

import exception.FechaNacNullException;
import exception.LicenciaNullException;
import exception.MenorDeEdadException;
import exception.NombreNullException;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Piloto {

    private UUID licencia;
    private String nombre;
    private String dni;
    private LocalDate fechaNacimiento;

    private Piloto(UUID licencia, String nombre, String dni, LocalDate fechaNacimiento) throws LicenciaNullException, NombreNullException, FechaNacNullException, MenorDeEdadException {
        if (licencia == null) {
            throw new LicenciaNullException("La licencia no puede ser nula");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new NombreNullException("El nombre no puede ser nulo o vacío");
        }
        if (dni == null || dni.trim().isEmpty()) {
            throw new IllegalArgumentException("El DNI no puede ser nulo o vacío");
        }
        if (fechaNacimiento == null) {
            throw new FechaNacNullException("La fecha de nacimiento no puede ser nula");
        }
        if (fechaNacimiento.plusYears(18).isAfter(LocalDate.now())) {
            throw new MenorDeEdadException("El piloto no puede ser menor de 18 años");
        }


        this.licencia = licencia;
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }


    public static Piloto create(UUID licencia, String nombre, String dni, LocalDate fechaNacimiento) throws LicenciaNullException, FechaNacNullException, MenorDeEdadException, NombreNullException {
        return new Piloto(licencia, nombre, dni, fechaNacimiento);
    }

    public UUID getLicencia() {
        return this.licencia;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDni(){
        return this.dni;
    }

    public LocalDate getFechaNacimiento(){
        return this.fechaNacimiento;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piloto piloto = (Piloto) o;
        return Objects.equals(licencia, piloto.licencia) &&
               Objects.equals(nombre, piloto.nombre) &&
               Objects.equals(dni, piloto.dni) &&
               Objects.equals(fechaNacimiento, piloto.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licencia, nombre, dni, fechaNacimiento);
    }
}
