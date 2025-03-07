package BLL;

import Beans.Db_productinfo;
import DAO.ProductInfoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ProductInfoBLL
{
    //to get all the productINfos
    public static ArrayList<Db_productinfo> getAllProductInfos() throws ClassNotFoundException
    {
        return ProductInfoDAO.GetAllProductInfos();
    }

    public static boolean createNewProductInfo(Db_productinfo p)
    {
        boolean flag = false;
        String sql = "INSERT INTO `db_cashsys`.`db_productinfo`(`Product_Code`, `Product_Name`, `Product_Unit`, `Product_Amount`, `Product_NormalPrice`, `Product_Status`, `CasherID`) VALUES ('"
                +p.getProduct_Code()+"','"
                +p.getProduct_Name()+"','"
                +p.getProduct_Unit()+"','"
                +p.getProduct_Amount()+"','"
                +p.getProduct_NormalPrice()+"','"
                +p.getProduct_Status()+"','"
                +p.getCasherID()
                // another properties here.
                +"')";
        flag = ProductInfoDAO.InsertProductInfo(sql);
        return flag;
    }

    public static String generateProductCode(ObservableList<Db_productinfo> ps) throws ClassNotFoundException
    {
        if(ps.size()==0)
        {
            ps = FXCollections.observableArrayList(ProductInfoBLL.getAllProductInfos());
        }
        long size = ps.size();
        return String.valueOf(10000000+size+1);
    }
}
