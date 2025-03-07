package Sample;

import BLL.ProductInfoBLL;
import BLL.SaleDetailInfoBLL;
import BLL.SaleInfoBLL;
import Beans.Db_productinfo;
import Beans.Db_saledetailinfo;
import Beans.Db_saleinfo;
import Utils.CommonUtils;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.*;

public class CashPageController extends  BaseController implements Initializable
{
    @FXML
    private Label label_cashername;
    @FXML
    private Label label_cashercode;
    @FXML
    private Label label_currenttime;
    @FXML
    private Label label_billserialnumber;
    @FXML
    private Label label_cashmachinecode;
    @FXML
    private Label label_cashmachinestatus;
    @FXML
    private TableView tableview_productinfos;
    @FXML
    private TextField textfield_productcode;
    @FXML
    private Label label_productname;
    @FXML
    private TextField textfield_amount;
    @FXML
    private Label label_unit;
    @FXML
    private Label label_originalunitprice;
    @FXML
    private Button btn_addtolist;
    @FXML
    private Label label_discountunitprice;
    @FXML
    private Label label_totalprice;
    @FXML
    private Label label_totaldiscountprice;
    @FXML
    private TextField textfield_totalpayment;
    @FXML
    private Label label_recharge;
    @FXML
    private Button btn_cash;
    @FXML
    private TextField promng_textfield_productcode;
    @FXML
    private TextField promng_textfield_productname;
    @FXML
    private TextField promng_textfield_unit;
    @FXML
    private TextField promng_textfield_originalunitprice;
    @FXML
    private Button promng_btn_addnewproduct;

    @FXML
    private TableView tableview_productinfolist;

    private Db_productinfo currentProductInfo;
    private ObservableList<Db_saledetailinfo> currentBillProductInfos;
    private double currentBillTotalPrice=0.0;
    private ObservableList<Db_productinfo> productinfos;

    @Override
    public void  initialize(URL location, ResourceBundle resources)
    {
        currentProductInfo = new Db_productinfo();
        currentBillProductInfos = FXCollections.observableArrayList();
        productinfos = FXCollections.observableArrayList();

        //get the casher information who just logined from the globalobject class.
        label_cashername.setText(GlobalObject.currentcasher.getCasher_Name());
        label_cashercode.setText(GlobalObject.currentcasher.getCasher_Code());

        //get the machine information from the globalobject class.
        label_cashmachinecode.setText(GlobalObject.cashmachineinfo.getCashMachineInfo_Code());
        label_cashmachinestatus.setText(GlobalObject.cashmachineinfo.getCashMachineInfo_Status());

        CommonUtils.setTime(label_currenttime);
        try
        {//download all productinfos from DB to local system.
            GlobalObject.productinfos= ProductInfoBLL.getAllProductInfos();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        //once the textfield lost its focus, then the system will search the product in the productinfos list.
        textfield_productcode.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue)
            {
                if(oldValue && !newValue)
                {
                    for(Db_productinfo p : GlobalObject.productinfos)
                    {
                        if(p.getProduct_Code().equals(textfield_productcode.getText()))
                        {
                            currentProductInfo = p;
                            label_productname.setText(p.getProduct_Name());
                            label_unit.setText(p.getProduct_Unit());
                            label_originalunitprice.setText(String.valueOf(p.getProduct_NormalPrice()));
                            //left the discount price here...
                        }
                    }
                }
            }
        });

        TableColumn<Db_saledetailinfo, String> nameCol = new TableColumn<>("product name");
        TableColumn<Db_saledetailinfo, String> unitCol = new TableColumn<>("Unit");
        TableColumn<Db_saledetailinfo,Double> amountCol = new TableColumn<>("Amount");
        TableColumn<Db_saledetailinfo,Double> unitoriginalPriceCol = new TableColumn<>("OriginalUnitPrice");
        TableColumn<Db_saledetailinfo,Double> normalpaymentCol = new TableColumn<>("NormalPayment");
        TableColumn<Db_saledetailinfo,Double> finalpaymentCol = new TableColumn<>("Finalpayment");

        nameCol.setCellValueFactory(new PropertyValueFactory<>("Product_Name"));
        unitCol.setCellValueFactory(new PropertyValueFactory<>("Product_Unit"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        unitoriginalPriceCol.setCellValueFactory(new PropertyValueFactory<>("NormalUnitPrice"));
        normalpaymentCol.setCellValueFactory(new PropertyValueFactory<>("NormalPayment"));
        finalpaymentCol.setCellValueFactory(new PropertyValueFactory<>("FinalPayment"));

        tableview_productinfos.getColumns().addAll(nameCol,unitCol,amountCol,unitoriginalPriceCol,normalpaymentCol,finalpaymentCol);
        //display the items in the list of currentBillProductInfos...
        tableview_productinfos.setItems(currentBillProductInfos);
    }

    public void btn_addtolist_clicked(ActionEvent e) throws CloneNotSupportedException
    {
        try {
            currentProductInfo.setProduct_Amount(Double.parseDouble(textfield_amount.getText()));
        }
        catch (Exception ex)
        {
            getApp().gotoDialog("error","error","amount should not zero");
        }
        if(currentProductInfo.getProduct_Amount()!=0)
        {
            Db_saledetailinfo saledetailinfo = new Db_saledetailinfo();
            saledetailinfo.setAmount(currentProductInfo.getProduct_Amount());
            saledetailinfo.setProduct_ID(currentProductInfo.getProduct_ID());
            saledetailinfo.setProduct_Name(currentProductInfo.getProduct_Name());
            saledetailinfo.setProduct_Unit(currentProductInfo.getProduct_Unit());
            saledetailinfo.setNormalUnitPrice(currentProductInfo.getProduct_NormalPrice());
            saledetailinfo.setNormalPayment(currentProductInfo.getProduct_NormalPrice() * currentProductInfo.getProduct_Amount());
            saledetailinfo.setFinalPayment(saledetailinfo.getNormalPayment());

            currentBillProductInfos.add(saledetailinfo);

            currentBillTotalPrice += saledetailinfo.getFinalPayment();
            label_totalprice.setText(String.valueOf(currentBillTotalPrice));
            //to calculate out the payment of this bill.
        }
    }
    public void btn_cash_clicked(ActionEvent e) throws CloneNotSupportedException
    {
        if(!textfield_totalpayment.getText().isEmpty())
        {
            if(Double.valueOf(textfield_totalpayment.getText()) < Double.valueOf(label_totalprice.getText()))
            {
                getApp().gotoDialog("error","payment error","the payment is not adequate");
            }
            else
            {
                double recharge = Double.valueOf(textfield_totalpayment.getText())-Double.valueOf(label_totalprice.getText());
                label_recharge.setText(String.valueOf(recharge));
            }
            //start to save the sale detail infos and the sale info into database.
            //1. generate the saleinfo code first and then save info database to get the saleinfo id
            Db_saleinfo saleinfo=new Db_saleinfo();
            saleinfo.setSaleInfo_Code(SaleInfoBLL.GenerateNewSaleInfoCode());
            //set value to saleinfo's properties
            SaleInfoBLL.CreateNewSaleInfo(saleinfo);
            //2. add the code into each sale detail infos
            //3. save the sale detail infos into database.
            for(Db_saledetailinfo s : currentBillProductInfos)
                //save to db
            {
                Db_saledetailinfo temp = (Db_saledetailinfo) s.clone();
                temp.setSaleInfo_Code(saleinfo.getSaleInfo_Code());
                SaleDetailInfoBLL.CreateNewSaleDetailInfo(temp);
            }

        }
    }

    public void promng_btn_addnewproduct_clicked(ActionEvent e) throws ClassNotFoundException
    {
        //put the adding new product code here.
        Db_productinfo p = new Db_productinfo();
        p.setProduct_Code(ProductInfoBLL.generateProductCode(productinfos));
        p.setProduct_Name(promng_textfield_productname.getText());
        p.setProduct_Unit(promng_textfield_unit.getText());
        p.setProduct_NormalPrice(Double.parseDouble(promng_textfield_originalunitprice.getText()));
        p.setProduct_Amount(100);
        p.setProduct_Status(0);
        p.setCasherID(GlobalObject.currentcasher.getCasher_ID());
        boolean flag = ProductInfoBLL.createNewProductInfo(p);
        if(flag)
            productinfos.add(p);//if insert into db correctly, then update the current product list.
    }

    public void ProductMng_SelectionChanged(Event e) throws ClassNotFoundException
    {
        //when the productMng tab is selected, then load all the productinfos if the list is empty.
        //get all product infos from db
        productinfos = FXCollections.observableArrayList(ProductInfoBLL.getAllProductInfos());

        TableColumn<Db_productinfo, String> codeCol = new TableColumn<>("product code");
        TableColumn<Db_productinfo, String> nameCol = new TableColumn<>("product name");
        TableColumn<Db_productinfo, String> unitCol = new TableColumn<>("Unit");
        TableColumn<Db_productinfo,Double> unitoriginalPriceCol = new TableColumn<>("OriginalUnitPrice");

        codeCol.setCellValueFactory(new PropertyValueFactory<>("Product_Code"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("Product_Name"));
        unitCol.setCellValueFactory(new PropertyValueFactory<>("Product_Unit"));
        unitoriginalPriceCol.setCellValueFactory(new PropertyValueFactory<>("Product_NormalPrice"));

        tableview_productinfolist.getColumns().addAll(codeCol,nameCol,unitCol,unitoriginalPriceCol);
        tableview_productinfolist.setItems(productinfos);
    }
    public void gotologin(){
        getApp().gotoLogin();
    }
}
