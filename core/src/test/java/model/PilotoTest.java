package model;


import exception.FechaNacNullException;
import exception.LicenciaNullException;
import exception.MenorDeEdadException;
import exception.NombreNullException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

public class PilotoTest {

    @Test
    void crearPiloto() throws LicenciaNullException, FechaNacNullException, MenorDeEdadException, NombreNullException {

        UUID licencia = UUID.fromString("cabbd417-1841-4b25-8798-e8d54df1416e");
        String nombre = "Juan Perez";
        String dni = "LP123456";
        LocalDate fecha = LocalDate.of(2000, 1, 1);

        Piloto piloto = Piloto.create(licencia, nombre, dni, fecha);

        Assertions.assertNotNull(piloto);
        Assertions.assertEquals(licencia, piloto.getLicencia());
        Assertions.assertEquals(nombre, piloto.getNombre());
    }


    @Test
    void pilotosConMismosDatosDeberianSerIguales() throws LicenciaNullException, FechaNacNullException, MenorDeEdadException, NombreNullException {

        UUID licencia = UUID.fromString("cabbd417-1841-4b25-8798-e8d54df1416e");
        String nombre = "Juan Perez";
        String dni = "LP123456";
        LocalDate fecha = LocalDate.of(2000, 1, 1);

        Piloto piloto1 = Piloto.create(licencia, nombre, dni, fecha);
        Piloto piloto2 = Piloto.create(licencia, nombre, dni, fecha);

        Assertions.assertEquals(piloto1, piloto2);

    }


    @Test
    void pilotoNoPuedeSerMenorDeEdad(){
        UUID licencia = UUID.fromString("cabbd417-1841-4b25-8798-e8d54df1416e");
        String nombre = "Juan Perez";
        String dni = "LP123456";
        LocalDate fechaNacimientoMenor = LocalDate.now().minusYears(10);

        MenorDeEdadException exception = Assertions.assertThrows(MenorDeEdadException.class, () -> {
            Piloto.create(licencia, nombre, dni, fechaNacimientoMenor);
        });

        Assertions.assertEquals("El piloto no puede ser menor de 18 años", exception.getMessage());
    }

}
