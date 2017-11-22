/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.inn2power.gui.controller;

import db.inn2power.bll.exception.Inn2PowerException;
import db.inn2power.dal.CompanyDAO;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author frederik
 */
public class CreateCompanyWindowController implements Initializable {
    


    @FXML
    private TextField txtName;
    @FXML
    private TextField txtAdress;
    @FXML
    private TextField txtCountry;
     @FXML
    private TextField txtWebsite;   
    @FXML
    private TextField txtSupplyChainCat;
    @FXML
    private TextField txtBusinessRole;
    @FXML
    private TextField txtLat;
    @FXML
    private TextField txtLng;
    @FXML
    private CheckBox cboxSME;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void eventCreateCompanybtn(ActionEvent event) throws IOException, SQLException, Inn2PowerException 
    {
        CompanyDAO companydao = new CompanyDAO();
        
        String name = txtName.getText();
        String adress = txtAdress.getText();
        String country = txtCountry.getText();
        String website = txtWebsite.getText();
        String supplyChainCat = txtSupplyChainCat.getText();
        String businessRole = txtBusinessRole.getText();
        double lat = Integer.parseInt(txtLat.getText());
        double lng = Integer.parseInt(txtLng.getText());
        int sme;
        
        if (cboxSME.isSelected())
        {
            sme = 1;
        }else
        {
            sme = 0;
        } 
        
        companydao.createCompany(name, adress, country, website, supplyChainCat, businessRole, lat, lng, sme);     
    }

    @FXML
    private void eventToggleSMEcBox(ActionEvent event) {
    }


    
}
