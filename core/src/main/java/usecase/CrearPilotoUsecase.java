package usecase;

import exception.FechaNacNullException;
import exception.LicenciaNullException;
import exception.NombreNullException;
import model.Piloto;

import java.util.UUID;

public interface CrearPilotoUsecase {
    UUID crearPiloto(Piloto p) throws LicenciaNullException, FechaNacNullException, NombreNullException;
}
