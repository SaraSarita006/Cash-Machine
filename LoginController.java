package Sample;

import BLL.*;
import Beans.Db_casher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginController extends BaseController
{
    @FXML
    private TextField textfield_CasherCode; //this is the variable for the textfield in fxml.
    // the name must identical to the id
    @FXML
    private  TextField textfield_password;
    @FXML
    private Button btn_OK;
    @FXML
    private Button btn_Cancle;

    public void btn_OK_Clicked(ActionEvent e) throws ClassNotFoundException, CloneNotSupportedException
    {
        //"write your login code here based on the login process;
        //1. get the user's input of the casher's code and its pwd
        String casherCode = textfield_CasherCode.getText();//get the code from the fxml.
        String casherPwd = textfield_password.getText();
        casherCode="100001";
        casherPwd="12345";
        //2. encapsulate the information to a casher object.
        //the following code is to create an casher object about the loginer.
        Db_casher tempCasher = new Db_casher();
        tempCasher.setCasher_Code(casherCode);
        tempCasher.setCasher_PWD(casherPwd);

        //3. then find an object to check the login casher information is correct or not to decide
        //whether current user can login or not.
        LoginBLL loginBLL = new LoginBLL();
        Db_casher loginCasher = loginBLL.Login(tempCasher);
        if(loginCasher!=null)
        {
            //1. save the cashers information.
            GlobalObject.currentcasher = (Db_casher) loginCasher.clone();
            //2. change the status of current casher and
            // then update the online status of the current casher.
            GlobalObject.currentcasher.setCasher_Status(1);
            CasherBLL.updateCasherOnlineStatus(GlobalObject.currentcasher);
            //3. jump to the cash page
            getApp().gotoCashPage();
        }
        else
        {
            //show the error message by a dialog.
            getApp().gotoDialog("Login error","error","code or pwd wrong");
        }
    }

    public void btn_Cancle_Clicked(ActionEvent e)
    {
        System.out.println("write your exit code here.");
    }
}
