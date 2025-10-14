package usecase;

import exception.FechaNacNullException;
import exception.LicenciaNullException;
import exception.NombreNullException;
import model.Piloto;

import java.time.LocalDate;
import java.util.UUID;

public class CrearPilotoImpl implements CrearPilotoUsecase{


    @Override
    public UUID crearPiloto(Piloto p) throws LicenciaNullException, FechaNacNullException, NombreNullException {
        try {
            UUID uuid = UUID.randomUUID();

            Piloto piloto = Piloto.create(uuid, p.getNombre(), p.getDni(), p.getFechaNacimiento());
            return piloto.getLicencia();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
