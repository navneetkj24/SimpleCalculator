import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Controller implements Initializable {

    @FXML
    private CheckBox CbCharger;

    @FXML
    private CheckBox CbMouse;

    @FXML
    private CheckBox CbUsb;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnTotal;

    @FXML
    private TextField txtCharger;

    @FXML
    private TextField txtMouse;



    @FXML
    private TextField txtUSB;

    @FXML
    private TextField txtDiscount;
    

  

    @FXML
    private GridPane pane;
    Stage primaryStage;

    @FXML
    void exit(ActionEvent event) {
        primaryStage = (Stage) pane.getScene().getWindow();
        primaryStage.close();

    }

    @FXML
    void reset(ActionEvent event) {
        txtCharger.setText(null);
        txtMouse.setText(null);
        txtUSB.setText(null);

    }
    @FXML private TextArea resultArea;
    private final double USB = 20;
    private final double CHARGER = 15;
    private final double MOUSE = 10;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtUSB.setText("");
        txtUSB.setDisable(true);
        txtCharger.setDisable(true);
        txtCharger.setText("");
        txtMouse.setDisable(true);
        txtMouse.setText("");
    }    
    
    @FXML
    void USB(ActionEvent event) 
    {
        if(CbUsb.isSelected())
            txtUSB.setDisable(false);
        else
        {
            txtUSB.setText("");
            txtUSB.setDisable(true);
        }
    }
    
    @FXML
    void Charger(ActionEvent event)
    {
        if(CbCharger.isSelected())
            txtCharger.setDisable(false);
        else
        {
            txtCharger.setText("");
            txtCharger.setDisable(true);
        }
    }
    
    @FXML
    void mouse(ActionEvent event)
    {
        if(CbMouse.isSelected())
            txtMouse.setDisable(false);
        else
        {
            txtMouse.setText("");
            txtMouse.setDisable(true);
        }
    }
    
    @FXML
    private void TotalButtonAction()
    {
        int numOfUSB = 0, numOfCharger = 0, numOfMouse = 0;
        String usbString = "", chargerString = "", mouseString = "", discountString = "", totalString = "";
        double usbTot = 0, charTot = 0, mouseTot = 0, discount = 0, allTotal = 0;
        if(CbUsb.isSelected())
        {
            if(txtUSB.getText().equals(""))
                JOptionPane.showMessageDialog(null, "Please enter number of USB's!");
            else
            {
                numOfUSB = Integer.parseInt(txtUSB.getText().trim());
                usbString = "USB = $" + (numOfUSB * USB);
                usbTot = (numOfUSB * USB);
            }
        }
        else
        {
            numOfUSB = 0;
            usbString = "";
            usbTot = 0;
        }
        
        if(CbCharger.isSelected())
        {
            if(txtCharger.getText().equals(""))
                JOptionPane.showMessageDialog(null, "Please enter number of Chargers!");
            else
            {
                numOfCharger = Integer.parseInt(txtCharger.getText().trim());
                chargerString = "Charger = $" + (numOfCharger * CHARGER);
                charTot = (numOfCharger * CHARGER);
            }
        }
        else
        {
            numOfCharger = 0;
            chargerString = "";
            charTot = 0;
        }
        
        if(CbMouse.isSelected())
        {
            if(txtMouse.getText().equals(""))
                JOptionPane.showMessageDialog(null, "Please enter number of Mouse!");
            else
            {
                numOfMouse = Integer.parseInt(txtMouse.getText().trim());
                mouseString = "Mouse = $" + (numOfMouse * MOUSE);
                mouseTot = (numOfMouse * MOUSE);
            }
        }
        else
        {
            numOfMouse = 0;
            mouseString = "";
            mouseTot = 0;
        }
        
        if(txtDiscount.getText().equals(""))
        {
            discount = 0;
            discountString = "";
        }
        else
        {
            discount = Double.parseDouble(txtDiscount.getText().trim());
            discountString = "Discount = $" + discount;
        }
        
        allTotal = (usbTot + charTot + mouseTot) - discount;
        totalString = usbString + "\n" 
                    + chargerString + "\n" 
                    + mouseString + "\n"
                    + discountString + "\n------------------------------\n"
                    + "Total = $" + allTotal;
        totalString = totalString.replaceAll("(?m)^\\s*$[\n\r]{1,}", "");   // remove extra new lines
        
        resultArea.setText(totalString);
    }

        

    }

