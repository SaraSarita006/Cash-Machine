package Sample;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class BaseController implements Initializable
{
    private Program application;
    public void initialize(URL location, ResourceBundle resources)
    {

    }
    public void setApp(Program application)
    {
        this.application = application;
    }
    public Program getApp()
    {
        return application;
    }
}
