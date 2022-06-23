package servicio;

import dao.OdontologoDaoH2;
import modelo.Odontologo;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTest {
    private Logger logger = Logger.getLogger(OdontologoServiceTest.class);
    @BeforeAll
    public static void cargarBD(){
        Connection connection=null;
        try{
            Class.forName("org.h2.Driver").newInstance();
            connection= DriverManager.getConnection("jdbc:h2:~/ElianaJost;INIT=RUNSCRIPT FROM 'create.sql'","sa","sa");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    @Test
    public void testguardarOdontologo() throws Exception {
        //dado
        OdontologoService odontologoService= new OdontologoService(new OdontologoDaoH2());
        Odontologo odontologo1= new Odontologo(56, 345111, "Noelia","Perez");
        //cuando
        odontologoService.guardar(odontologo1);
        //entonces
        Assertions.assertEquals(odontologo1.getNombre(), "Noelia");

    }
    @Test
    public void testConsultarTodos() {
        String respuestaNoEsperada = "No hay odontologos";

        String respuestaObtenida = OdontologoService.consultarTodos();

        assertNotEquals(respuestaNoEsperada, respuestaObtenida);
    }
}