/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.inn2power.gui.controller;

import db.inn2power.be.Company;
import db.inn2power.bll.exception.Inn2PowerException;
import db.inn2power.gui.model.CompanyModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 *
 * @author pgn
 */
public class MainWindowController implements Initializable
{

    @FXML
    private ListView<Company> lstCompanies;

    private CompanyModel companyModel;
    @FXML
    private TextField txtQurry;
    @FXML
    private RadioButton radbtnName;
    @FXML
    private ToggleGroup searchGroup;
    @FXML
    private RadioButton radbtnCountry;

    public MainWindowController() throws Inn2PowerException, IOException, SQLException
    {
     
        companyModel = new CompanyModel();
     
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
       lstCompanies.setItems(companyModel.getAllCompanies());
    }
    

    @FXML
    public void eventCreateCompanybtn(ActionEvent event) throws IOException 
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CreateCompanyWindow.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1)); 
        stage.show();
        
            
    }

    @FXML
    private void handleSearch(ActionEvent event) throws SQLException 
    {
            
        if (radbtnName.isSelected())
        {
            String searchText = txtQurry.getText().trim();
            if(!searchText.isEmpty())
            {
                companyModel.searchByName(searchText);     
            }
        } 
        if (radbtnCountry.isSelected())
        {
            String searchText = txtQurry.getText().trim();
            if(!searchText.isEmpty())
            {
                companyModel.searchByCountry(searchText);
            }
        }    
        
    }


    @FXML
    private void eventDeleteCompanyBtn(ActionEvent event) 
    {
        Company selectCompany = lstCompanies.getSelectionModel().getSelectedItem();
        companyModel.remove(selectCompany);
    }

    @FXML
    private void eventRefreshListBten(ActionEvent event) 
    {
        lstCompanies.setItems(companyModel.getAllCompanies());
    }
}

