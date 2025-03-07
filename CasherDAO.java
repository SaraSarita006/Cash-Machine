package DAO;

import Beans.Db_casher;
import Utils.DBHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CasherDAO
{
    public static ArrayList<Db_casher> GetAllUsers() throws ClassNotFoundException
    {
        //by the DBHelper, we get all the cashers in database.
        return DBHelper.<Db_casher>selectData("db_casher",new Db_casher());
    }

    public static void UpdateCasher(String str)
    {
        DBHelper.ExcuteNoQuery(str);
    }
}
