package Beans;
import java.util.Date;


public class Db_cashmachineinfo{
	private int CashMachineInfo_ID ;
	private String CashMachineInfo_Code ;
	private String CashMachineInfo_Status ;
	public void setCashMachineInfo_ID(int CashMachineInfo_ID){
		this.CashMachineInfo_ID=CashMachineInfo_ID;
}
	public int getCashMachineInfo_ID(){
		return CashMachineInfo_ID;
	}
	public void setCashMachineInfo_Code(String CashMachineInfo_Code){
		this.CashMachineInfo_Code=CashMachineInfo_Code;
}
	public String getCashMachineInfo_Code(){
		return CashMachineInfo_Code;
	}
	public void setCashMachineInfo_Status(String CashMachineInfo_Status){
		this.CashMachineInfo_Status=CashMachineInfo_Status;
}
	public String getCashMachineInfo_Status(){
		return CashMachineInfo_Status;
	}

	//to simulate getting the cash mashine infomation.
	public Db_cashmachineinfo(int id, String code, String status)
	{
		this.CashMachineInfo_ID=id;
		this.CashMachineInfo_Code=code;
		this.CashMachineInfo_Status=status;
	}
}

