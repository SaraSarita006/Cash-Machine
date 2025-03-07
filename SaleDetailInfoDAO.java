package DAO;

import Utils.DBHelper;

public class SaleDetailInfoDAO
{
    public static void Insert(String str)
    {
        DBHelper.ExcuteNoQuery(str);
    }
}
