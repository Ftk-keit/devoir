package projetps.repository.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RepositoryDbImp<T> {
    // public abstract T convert(ResultSet rs) throws SQLException;
    protected Connection conn;
    private String url = "jdbc:mysql://localhost:5432/gestRv";
    private String user = "root";
    private String password = "123";
    protected PreparedStatement ps;

    public void getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        conn = DriverManager.getConnection(url, user, password);
    }

    public int executeUpdate() throws SQLException {
        return ps.executeUpdate();
    }
    public ResultSet executeQuery() throws SQLException {
        return ps.executeQuery();
        
    }

    public void initPrepareStatement(String sql) throws SQLException {
        this.getConnection();
        if (sql.toUpperCase().trim().startsWith("INSERT")) {
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        } else {
            ps = conn.prepareStatement(sql);

        }
    }

    public void closeConnexion() throws SQLException {
        if ( conn != null && !conn.isClosed() ) {
            conn.close();
        }
    }
}
