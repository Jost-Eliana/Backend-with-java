package dao;

import java.sql.SQLException;
import java.util.List;

public interface IDao <T> {
    T guardar(T t) throws Exception;
    List<T> consultarTodos() throws Exception;
}
