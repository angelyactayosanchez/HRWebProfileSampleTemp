package pe.edu.utp.hrwebprofile.models;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class HrService {
    private Connection connection;
    private HrDataStore dataStore;

    public HrService() {
        try {
            InitialContext context = new InitialContext();
            dataStore = new HrDataStore();
            connection = ((DataSource) context
                    .lookup("MySQLDataSource"))
                    .getConnection();
            dataStore.setConnection(connection);
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public HrDataStore getDataStore() {
        return dataStore;
    }

    public void setDataStore(HrDataStore dataStore) {
        this.dataStore = dataStore;
    }

    public Region findRegionById(int id) {
        return dataStore.findRegionById(id);
    }

    public List<Region> findAllRegions() { return dataStore.findAllRegions(); }

    public List<Country> findAllCountries() { return dataStore.findAllCountries(); }

}





