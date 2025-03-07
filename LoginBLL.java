package BLL;

import Beans.Db_casher;
import DAO.*;
import javafx.util.*;

import java.util.ArrayList;

public class LoginBLL
{
    public Db_casher Login(Db_casher casher) throws ClassNotFoundException
    {
       Db_casher logincasher=null;
       ArrayList<Db_casher> cashers = CasherDAO.GetAllUsers();//get all cashers in database
       for(Db_casher c : cashers)//check the login casher object in the cashers list one by one
       {
           if(c.getCasher_Code().equals(casher.getCasher_Code()) &&
              c.getCasher_PWD().equals(casher.getCasher_PWD()))
           {
               logincasher = c;
               break;
           }
       }
       return logincasher;
    }
}
