package Beans;
import java.util.Date;


public class Db_casher implements Cloneable{
	private int Casher_ID ;
	private String Casher_Code ;
	private String Casher_Name ;
	private String Casher_PWD ;
	private int Casher_Status ;
	private int Casher_Type ;
	private Date Casher_LastLoginDateTime ;
	public void setCasher_ID(int Casher_ID){
		this.Casher_ID=Casher_ID;
}
	public int getCasher_ID(){
		return Casher_ID;
	}
	public void setCasher_Code(String Casher_Code){
		this.Casher_Code=Casher_Code;
}
	public String getCasher_Code(){
		return Casher_Code;
	}
	public void setCasher_Name(String Casher_Name){
		this.Casher_Name=Casher_Name;
}
	public String getCasher_Name(){
		return Casher_Name;
	}
	public void setCasher_PWD(String Casher_PWD){
		this.Casher_PWD=Casher_PWD;
}
	public String getCasher_PWD(){
		return Casher_PWD;
	}
	public void setCasher_Status(int Casher_Status){
		this.Casher_Status=Casher_Status;
}
	public int getCasher_Status(){
		return Casher_Status;
	}
	public void setCasher_Type(int Casher_Type){
		this.Casher_Type=Casher_Type;
}
	public int getCasher_Type(){
		return Casher_Type;
	}
	public void setCasher_LastLoginDateTime(Date Casher_LastLoginDateTime){
		this.Casher_LastLoginDateTime=Casher_LastLoginDateTime;
}
	public Date getCasher_LastLoginDateTime(){
		return Casher_LastLoginDateTime;
	}

	@Override
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
}

