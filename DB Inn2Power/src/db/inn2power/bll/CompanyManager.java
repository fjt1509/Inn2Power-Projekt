/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.inn2power.bll;

import db.inn2power.be.Company;
import db.inn2power.bll.exception.Inn2PowerException;
import db.inn2power.dal.CompanyDAL;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author pgn
 */
public class CompanyManager
{

    private CompanyDAL companyDAO;

    public CompanyManager() throws Inn2PowerException
    {
        try
        {
            companyDAO = new CompanyDAL();
        } catch (IOException ex)
        {
            throw new Inn2PowerException(ex);
        }
    }

    public List<Company> getAllCompanies() throws Inn2PowerException
    {
        try
        {
          return companyDAO.getAllCompanies();
        } catch (SQLException ex)
        {
            throw new Inn2PowerException(ex);
        }
    }

    public void remove(Company company)
    {
        companyDAO.remove(company);
        
    }

    public void createCompany(String name, String adress, String country, String website, String supplyChainCat, String businessRole, double lat, double lng, int sme) throws SQLException 
    {
        companyDAO.createCompany(name, adress, country, website, supplyChainCat, businessRole, lat, lng, sme);
    }
    
    public boolean isValidCompany(Company company)
    {
    	if(!company.getName().isBlank() && !company.getAddress().isBlank()) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public boolean isCompanyWebsiteValidURL(String url)
    {
        String regex = "((http|https)://)(www.)?"
              + "[a-zA-Z0-9@:%._\\+~#?&//=]"
              + "{2,256}\\.[a-z]"
              + "{2,6}\\b([-a-zA-Z0-9@:%"
              + "._\\+~#?&//=]*)";
 

        Pattern p = Pattern.compile(regex);

        if (url == null) {
            return false;
        }

        Matcher m = p.matcher(url);
 
        return m.matches();
    }
 

}
