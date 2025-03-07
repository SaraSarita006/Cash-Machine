package Sample;

import Beans.Db_casher;
import Beans.Db_cashmachineinfo;
import Beans.Db_productinfo;

import java.util.ArrayList;

public class GlobalObject
{
    public static Db_casher currentcasher;
    public static Db_cashmachineinfo cashmachineinfo=new Db_cashmachineinfo(1,"1001","1");
    public static ArrayList<Db_productinfo> productinfos = new ArrayList<>();
}
