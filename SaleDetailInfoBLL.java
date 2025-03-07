package BLL;

import Beans.Db_saledetailinfo;
import Beans.Db_saleinfo;
import DAO.SaleInfoDAO;

public class SaleDetailInfoBLL
{
    public static void CreateNewSaleDetailInfo(Db_saledetailinfo saledetailinfo)
    {
        String insertSaleDetailInfo= "insert into Db_saleinfo values ('"
                +saledetailinfo.getSaleInfo_Code()+"','"
               // another properties here.
                +"')";
        SaleInfoDAO.Insert(insertSaleDetailInfo);
    }
}
