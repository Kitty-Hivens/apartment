package goldyl.dao;

import java.sql.*;
import java.util.*;

public abstract class AbstractDAO<T> {
    protected Connection connection;

    public AbstractDAO(Connection connection) {
        this.connection = connection;
    }

    public abstract List<T> findAll() throws SQLException;
}
