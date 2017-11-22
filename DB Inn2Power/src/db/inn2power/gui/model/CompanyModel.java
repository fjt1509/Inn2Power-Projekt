/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.inn2power.gui.model;


import dal.CompanyDAO;
import db.inn2power.BLL.CompanySearcher;
import db.inn2power.be.Company;
import db.inn2power.bll.CompanyManager;
import db.inn2power.bll.exception.Inn2PowerException;
import java.io.IOException;
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
    private CompanyManager companyManager;
    private CompanyDAO companyDAO;
    private CompanySearcher companySearcher;
    
    public CompanyModel() throws Inn2PowerException, IOException
    {
        this.companiesInView = FXCollections.observableArrayList();
        
        
        companyManager = new CompanyManager();
        companiesInView.addAll(companyManager.getAllCompanies());
        
    }

    public ObservableList<Company> getAllCompanies()
    {
        return companiesInView;
    }
    
        public void search(String searchText)
    {
        //Now I will do some BLL logic here:
        List<be.Company> allCompanies = companyDAO.getAllCompanies();
        List<be.Company> searchResults = companySearcher.searchByCompanyName(allCompanies, searchText);
        companiesInView.clear();
        //companiesInView.addAll(searchResults);
    }
    
    public void createCompany(String name)
    {
        
    }

}
