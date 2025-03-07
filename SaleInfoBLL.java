package BLL;

import Beans.Db_saleinfo;
import DAO.SaleInfoDAO;
import Sample.GlobalObject;

import java.util.Date;

public class SaleInfoBLL
{
    public static void CreateNewSaleInfo(Db_saleinfo saleinfo)
    {
        String insertSaleInfo= "insert into Db_saleinfo values ('"+saleinfo.getCasher_ID()+"','"
                +saleinfo.getSaleInfo_Code()+"','"
                +saleinfo.getSaleInfo_TotalPayment()+"','"
                +saleinfo.getSaleInfo_Charge()+"','"
                +saleinfo.getSaleInfo_TotalNormalPayment()+"','"
                +"')";
        SaleInfoDAO.Insert(insertSaleInfo);
    }

    public static String GenerateNewSaleInfoCode()
    {
        //datetime, current casher, current mashine number
        String datetime =String.valueOf(new Date().getTime());
        String cashercode = GlobalObject.currentcasher.getCasher_Code();
        String machinecode = GlobalObject.cashmachineinfo.getCashMachineInfo_Code();
        return cashercode+machinecode+datetime;

    }
}
