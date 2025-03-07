package BLL;

import Beans.Db_casher;
import DAO.CasherDAO;
import Utils.DBHelper;

//define all the operations about casher here.
public class CasherBLL
{
    public static void updateCasherOnlineStatus(Db_casher casher)
    {
        String updateSql = "update Db_casher  set Casher_Status = "+casher.getCasher_Status()+" where Casher_ID = "+casher.getCasher_ID();

        CasherDAO.UpdateCasher(updateSql);
    }
}
