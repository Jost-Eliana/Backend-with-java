package servicio;

import dao.IDao;
import dao.OdontologoDaoH2;
import modelo.Odontologo;
import org.apache.log4j.Logger;

public class OdontologoService {
    private Logger logger = Logger.getLogger(OdontologoService.class);
    private IDao<Odontologo> odontologoDao;

    public OdontologoService(IDao<Odontologo> odontologoDao) {
        this.odontologoDao = odontologoDao;
    }

    public Odontologo guardar(Odontologo odontologo) throws Exception {
        return odontologoDao.guardar(odontologo);
    }
}


