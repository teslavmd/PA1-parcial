package usecase;

import exception.FechaNacNullException;
import exception.LicenciaNullException;
import exception.NombreNullException;
import model.Piloto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.UUID;

public class PilotoUsecaseTest
{

    @Test
    void crearPiloto() throws LicenciaNullException, FechaNacNullException, NombreNullException {
        CrearPilotoImpl crearPiloto = Mockito.mock(CrearPilotoImpl.class);
        UUID licencia = UUID.fromString("cabbd417-1841-4b25-8798-e8d54df1416e");
        String nombre = "Juan Perez";
        String dni = "LP123456";
        LocalDate fecha = LocalDate.of(2000, 1, 1);

        Piloto piloto = Piloto.create(licencia, nombre, dni, fecha);

        Mockito.when(crearPiloto.crearPiloto(piloto)).thenReturn(UUID.randomUUID());


    }



}
