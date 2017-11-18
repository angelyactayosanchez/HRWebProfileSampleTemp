package pe.edu.utp.hrwebprofile.models;

import java.sql.Connection;
import java.util.List;

public class HrDataStore {
    private Connection connection;
    private RegionsEntity regionsEntity;
    private CountriesEntity countriesEntity;

    public HrDataStore(Connection connection) {
        this.connection = connection;
    }

    public HrDataStore() {
    }

    public Region findRegionById(int id) {
        if(connection == null) return null;
        return getRegionsEntity().findById(id);
    }

    public Country findCountryById(String id) {
        if(connection == null) return null;
        return getCountriesEntity().findById(id, getRegionsEntity());
    }

    public List<Region> findAllRegions() {
        return connection == null ? null: getRegionsEntity().findAll();
    }

    public List<Country> findAllCountries() { return connection == null ? null : getCountriesEntity().findAll(getRegionsEntity()); }

    public boolean eraseRegion(int id) {
        return connection == null ?
                false :
                getRegionsEntity().erase(id);
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    private RegionsEntity getRegionsEntity() {
        if(regionsEntity == null) {
            regionsEntity = new RegionsEntity();
            regionsEntity.setConnection(connection);
        }
        return regionsEntity;
    }

    private CountriesEntity getCountriesEntity() {
        if(countriesEntity == null) {
            countriesEntity = new CountriesEntity();
            countriesEntity.setConnection(connection);
        }
        return countriesEntity;
    }

}






