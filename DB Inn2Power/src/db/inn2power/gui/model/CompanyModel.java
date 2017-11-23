/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.inn2power.gui.model;



import db.inn2power.bll.CompanySearcher;
import db.inn2power.be.Company;
import db.inn2power.bll.CompanyManager;
import db.inn2power.bll.exception.Inn2PowerException;
import db.inn2power.dal.CompanyDAL;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author pgn
 */
public class CompanyModel
{

    private final ObservableList<Company> companiesInView;
    private CompanyDAL companyDAL = new CompanyDAL();
    private CompanyManager companyManager = new CompanyManager();
    private CompanySearcher companySearcher = new CompanySearcher();
    
    public CompanyModel() throws Inn2PowerException, IOException, SQLException
    {
        this.companiesInView = FXCollections.observableArrayList();
        
        companiesInView.addAll(companyDAL.getAllCompanies());
        
    }

    public ObservableList<Company> getAllCompanies()
    {
        return companiesInView;
    }
    
        public void searchByName(String searchText) throws SQLException
    {
        //Now I will do some BLL logic here:
        List<Company> allCompanies = companyDAL.getAllCompanies();
        List<Company> searchResults = companySearcher.searchByCompanyName(allCompanies, searchText);
        companiesInView.clear();
        companiesInView.addAll(searchResults);
    }
        
    public void searchByCountry(String searchText) throws SQLException
    {
        List<Company> allCompanies = companyDAL.getAllCompanies();
        List<Company> searchResults = companySearcher.searchByCompanyCoutnry(allCompanies, searchText);
        companiesInView.clear();
        companiesInView.addAll(searchResults);
    }
    

    public void remove(Company selectCompany) 
    {
        companiesInView.remove(selectCompany);
        companyManager.remove(selectCompany);
    }

    public void createCompany(String name, String adress, String country, String website, String supplyChainCat, String businessRole, double lat, double lng, int sme) throws SQLException {
        
        companyManager.createCompany(name, adress, country, website, supplyChainCat, businessRole, lat, lng, sme);
        
    }

}
