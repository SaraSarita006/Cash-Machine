package DAO;

import Beans.Db_casher;
import Beans.Db_productinfo;
import Utils.DBHelper;

import java.util.ArrayList;

public class ProductInfoDAO
{
    public static ArrayList<Db_productinfo> GetAllProductInfos() throws ClassNotFoundException
    {
        //by the DBHelper, we get all the cashers in database.
        return DBHelper.<Db_productinfo>selectData("db_productinfo",new Db_productinfo());
    }

    public static boolean InsertProductInfo(String sql)
    {
        return DBHelper.ExcuteNoQuery(sql);
    }
}
