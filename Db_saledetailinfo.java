package Beans;
import java.util.Date;


public class Db_saledetailinfo implements  Cloneable{
	private int SaleDetailInfo_ID ;
	private String SaleInfo_Code ;
	private int Product_ID ;
	private int DiscountPriceInfo_ID ;
	private double Amount ;
	private double NormalPayment ;
	private double DiscountPayment ;
	private double FinalPayment ;
	private double NormalUnitPrice ;
	private double DiscountUnitPrice ;

	private String Product_Name;
	private String Product_Unit;

	public void setSaleDetailInfo_ID(int SaleDetailInfo_ID){
		this.SaleDetailInfo_ID=SaleDetailInfo_ID;
}
	public int getSaleDetailInfo_ID(){
		return SaleDetailInfo_ID;
	}
	public void setSaleInfo_Code(String SaleInfo_Code){
		this.SaleInfo_Code=SaleInfo_Code;
}
	public String getSaleInfo_Code(){
		return SaleInfo_Code;
	}
	public void setProduct_ID(int Product_ID){
		this.Product_ID=Product_ID;
}
	public int getProduct_ID(){
		return Product_ID;
	}
	public void setDiscountPriceInfo_ID(int DiscountPriceInfo_ID){
		this.DiscountPriceInfo_ID=DiscountPriceInfo_ID;
}
	public int getDiscountPriceInfo_ID(){
		return DiscountPriceInfo_ID;
	}
	public void setAmount(double Amount){
		this.Amount=Amount;
}
	public double getAmount(){
		return Amount;
	}
	public void setNormalPayment(double NormalPayment){
		this.NormalPayment=NormalPayment;
}
	public double getNormalPayment(){
		return NormalPayment;
	}
	public void setDiscountPayment(double DiscountPayment){
		this.DiscountPayment=DiscountPayment;
}
	public double getDiscountPayment(){
		return DiscountPayment;
	}
	public void setFinalPayment(double FinalPayment){
		this.FinalPayment=FinalPayment;
}
	public double getFinalPayment(){
		return FinalPayment;
	}
	public void setNormalUnitPrice(double NormalUnitPrice){
		this.NormalUnitPrice=NormalUnitPrice;
}
	public double getNormalUnitPrice(){
		return NormalUnitPrice;
	}
	public void setDiscountUnitPrice(double DiscountUnitPrice){
		this.DiscountUnitPrice=DiscountUnitPrice;
}
	public double getDiscountUnitPrice(){
		return DiscountUnitPrice;
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

	@Override
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
}

