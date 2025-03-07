package Beans;
import java.util.Date;


public class Db_productinfo implements  Cloneable
{
	private int Product_ID ;
	private String Product_Code ;
	private String Product_Name ;
	private String Product_Unit ;
	private double Product_Amount ;
	private double Product_NormalPrice ;
	private int Product_Status ;
	private int CasherID ;
	public void setProduct_ID(int Product_ID){
		this.Product_ID=Product_ID;
}
	public int getProduct_ID(){
		return Product_ID;
	}
	public void setProduct_Code(String Product_Code){
		this.Product_Code=Product_Code;
}
	public String getProduct_Code(){
		return Product_Code;
	}
	public void setProduct_Name(String Product_Name){
		this.Product_Name=Product_Name;
}
	public String getProduct_Name(){
		return Product_Name;
	}
	public void setProduct_Unit(String Product_Unit){
		this.Product_Unit=Product_Unit;
}
	public String getProduct_Unit(){
		return Product_Unit;
	}
	public void setProduct_Amount(double Product_Amount){
		this.Product_Amount=Product_Amount;
}
	public double getProduct_Amount(){
		return Product_Amount;
	}
	public void setProduct_NormalPrice(double Product_NormalPrice){
		this.Product_NormalPrice=Product_NormalPrice;
}
	public double getProduct_NormalPrice(){
		return Product_NormalPrice;
	}
	public void setProduct_Status(int Product_Status){
		this.Product_Status=Product_Status;
}
	public int getProduct_Status(){
		return Product_Status;
	}
	public void setCasherID(int CasherID){
		this.CasherID=CasherID;
}
	public int getCasherID(){
		return CasherID;
	}

	@Override
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
}

