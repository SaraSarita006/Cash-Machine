package Beans;
import java.util.Date;


public class Db_saleinfo{
	private int SaleInfo_ID ;
	private int Casher_ID ;
	private String SaleInfo_Code ;
	private double SaleInfo_TotalNormalPayment ;
	private double SaleInfo_TotalPayment ;
	private double SaleInfo_DisountTotal ;
	private double SaleInfo_ClientPay ;
	private double SaleInfo_Charge ;
	private int SaleInfo_PayType ;
	private Date SaleInfo_Date ;
	private String SaleInfo_State ;
	public void setSaleInfo_ID(int SaleInfo_ID){
		this.SaleInfo_ID=SaleInfo_ID;
}
	public int getSaleInfo_ID(){
		return SaleInfo_ID;
	}
	public void setCasher_ID(int Casher_ID){
		this.Casher_ID=Casher_ID;
}
	public int getCasher_ID(){
		return Casher_ID;
	}
	public void setSaleInfo_Code(String SaleInfo_Code){
		this.SaleInfo_Code=SaleInfo_Code;
}
	public String getSaleInfo_Code(){
		return SaleInfo_Code;
	}
	public void setSaleInfo_TotalNormalPayment(double SaleInfo_TotalNormalPayment){
		this.SaleInfo_TotalNormalPayment=SaleInfo_TotalNormalPayment;
}
	public double getSaleInfo_TotalNormalPayment(){
		return SaleInfo_TotalNormalPayment;
	}
	public void setSaleInfo_TotalPayment(double SaleInfo_TotalPayment){
		this.SaleInfo_TotalPayment=SaleInfo_TotalPayment;
}
	public double getSaleInfo_TotalPayment(){
		return SaleInfo_TotalPayment;
	}
	public void setSaleInfo_DisountTotal(double SaleInfo_DisountTotal){
		this.SaleInfo_DisountTotal=SaleInfo_DisountTotal;
}
	public double getSaleInfo_DisountTotal(){
		return SaleInfo_DisountTotal;
	}
	public void setSaleInfo_ClientPay(double SaleInfo_ClientPay){
		this.SaleInfo_ClientPay=SaleInfo_ClientPay;
}
	public double getSaleInfo_ClientPay(){
		return SaleInfo_ClientPay;
	}
	public void setSaleInfo_Charge(double SaleInfo_Charge){
		this.SaleInfo_Charge=SaleInfo_Charge;
}
	public double getSaleInfo_Charge(){
		return SaleInfo_Charge;
	}
	public void setSaleInfo_PayType(int SaleInfo_PayType){
		this.SaleInfo_PayType=SaleInfo_PayType;
}
	public int getSaleInfo_PayType(){
		return SaleInfo_PayType;
	}
	public void setSaleInfo_Date(Date SaleInfo_Date){
		this.SaleInfo_Date=SaleInfo_Date;
}
	public Date getSaleInfo_Date(){
		return SaleInfo_Date;
	}
	public void setSaleInfo_State(String SaleInfo_State){
		this.SaleInfo_State=SaleInfo_State;
}
	public String getSaleInfo_State(){
		return SaleInfo_State;
	}
}

