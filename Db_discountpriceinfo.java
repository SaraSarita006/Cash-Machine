package Beans;
import java.util.Date;


public class Db_discountpriceinfo{
	private int DiscountPrice_ID ;
	private int Product_ID ;
	private int DiscountPrice_Type ;
	private double DiscountPrice_Price ;
	private int DiscountPrice_Percent ;
	private Date DiscountPrice_StartDate ;
	private Date DiscountPrice_EndDate ;
	private int DiscountPrice_State ;
	private int Casher_ID ;
	public void setDiscountPrice_ID(int DiscountPrice_ID){
		this.DiscountPrice_ID=DiscountPrice_ID;
}
	public int getDiscountPrice_ID(){
		return DiscountPrice_ID;
	}
	public void setProduct_ID(int Product_ID){
		this.Product_ID=Product_ID;
}
	public int getProduct_ID(){
		return Product_ID;
	}
	public void setDiscountPrice_Type(int DiscountPrice_Type){
		this.DiscountPrice_Type=DiscountPrice_Type;
}
	public int getDiscountPrice_Type(){
		return DiscountPrice_Type;
	}
	public void setDiscountPrice_Price(double DiscountPrice_Price){
		this.DiscountPrice_Price=DiscountPrice_Price;
}
	public double getDiscountPrice_Price(){
		return DiscountPrice_Price;
	}
	public void setDiscountPrice_Percent(int DiscountPrice_Percent){
		this.DiscountPrice_Percent=DiscountPrice_Percent;
}
	public int getDiscountPrice_Percent(){
		return DiscountPrice_Percent;
	}
	public void setDiscountPrice_StartDate(Date DiscountPrice_StartDate){
		this.DiscountPrice_StartDate=DiscountPrice_StartDate;
}
	public Date getDiscountPrice_StartDate(){
		return DiscountPrice_StartDate;
	}
	public void setDiscountPrice_EndDate(Date DiscountPrice_EndDate){
		this.DiscountPrice_EndDate=DiscountPrice_EndDate;
}
	public Date getDiscountPrice_EndDate(){
		return DiscountPrice_EndDate;
	}
	public void setDiscountPrice_State(int DiscountPrice_State){
		this.DiscountPrice_State=DiscountPrice_State;
}
	public int getDiscountPrice_State(){
		return DiscountPrice_State;
	}
	public void setCasher_ID(int Casher_ID){
		this.Casher_ID=Casher_ID;
}
	public int getCasher_ID(){
		return Casher_ID;
	}
}

