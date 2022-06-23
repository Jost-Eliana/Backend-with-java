package dao;

import modelo.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    private Logger logger = Logger.getLogger(OdontologoDaoH2.class);

    @Override
    public Odontologo guardar(Odontologo odontologo) throws Exception {
        logger.debug("Iniciando método 'guardar()'");

        if (odontologo == null) throw new Exception("El odontologo no puede ser null");
        Connection connection= null;

        try{
            //conectarnos a la base
            connection=getConnection();
            //preparar la la operación de guardar un odontologo
            PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO odontologos (matricula, apellido, nombre) VALUES (?,?,?)");
            preparedStatement.setInt(1, odontologo.getNumeroDeMatricula());
            preparedStatement.setString(2, odontologo.getApellido());
            preparedStatement.setString(3, odontologo.getNombre());

            //ejecutar
            preparedStatement.executeUpdate();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            }
            catch (SQLException t){
                t.printStackTrace();
            }
        }
        logger.debug("Terminó la ejecución del método 'guardar()' con éxito");
        return odontologo;
    }

    @Override
    public List<Odontologo> consultarTodos() throws Exception {
        logger.debug("Iniciando método 'consultarTodos()'");

        Connection connection= null;
        connection=getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM odontologos");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Odontologo> odontologos = new ArrayList<>();

        while (resultSet.next()) {
            Odontologo odontologo = new Odontologo(
                    resultSet.getInt("id"),
                    resultSet.getString("nombre"),
                    resultSet.getString("apellido"),
                    resultSet.getString("numeroDeMatricula")
            );
            odontologos.add(odontologo);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();

        logger.debug("Terminó la ejecución del método 'consultarTodos()' con éxito");
        return odontologos;
    }

    private static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/ElianaJost","sa","sa");
    }


}
