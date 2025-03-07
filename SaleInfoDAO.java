package DAO;

import Beans.Db_saleinfo;
import Utils.DBHelper;

public class SaleInfoDAO
{
    public static void Insert(String str)
    {
        DBHelper.ExcuteNoQuery(str);
    }
}
