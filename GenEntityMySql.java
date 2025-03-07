package Utils;

import org.apache.commons.dbutils.DbUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//generate entity classes definition according to the mysql database's definition
//each table is a class
//each record in a table is an object
//each column of a record is the property of the above object.
//if we can get columns name and columns' type, then we can write the class definition out.
//so, we can generate the classes definition based on the database automatically by code.
// now, we are writing this automatically generation code.
public class GenEntityMySql
{
    private String packageOutPath = "Beans";
    private String authoerName;
    private String tableName;
    private String databaseName;
    private List<String> tablenames;//store all the tables' name
    private List<String> colnames;// columns' name in a table
    private List<String> colTypes;// columns' type in a table
    private boolean f_util = false;  // to indicate whether import the java.util.* package;
    private boolean f_sql = false; // to indicate whether import the java.sql.* package;

    private void getEntity(List<String> tablenames, Connection conn)//provide tablenames and then
            //retrieve the tables one by one
    {
        for(String tablename: tablenames)
            this.getEntity(tablename,conn);
    }

    private void getEntity(String tablename, Connection conn)//visit table
    {
        String sql = "select * from  "+tablename;
        PreparedStatement pstmt = null;
        ResultSetMetaData rsmd = null;
        try
        {
            pstmt = DBUtils.getPStmt(conn,sql);//generate the prepared statement.
            rsmd = pstmt.getMetaData();//get the metadata of the pstmt
            int size = rsmd.getColumnCount();//get the column count by rsmd
            colnames = new ArrayList<String>();
            colTypes =new ArrayList<String>();
            for(int i =0;i<size;i++)
            {
                colnames.add(rsmd.getColumnName(i+1)); //add each column into the list.
                colTypes.add(rsmd.getColumnTypeName(i+1));
                if(colTypes.get(i).equalsIgnoreCase("datetime"))//if the type is datetime
                    //we need to import the java.util.* package;
                {
                    f_util = true;
                }
                if(colTypes.get(i).equalsIgnoreCase("image") ||
                    colTypes.get(i).equalsIgnoreCase("text"))//if the type is image or text
                //we need to import the java.sql.* package;
                {
                    f_sql = true;
                }
            }
            System.out.println(colnames);
            System.out.println(colTypes);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String content = parse(tablename);// parse the table name and then generate the code of the class.
        try
        {
            File directory = new File("");
            String outputPath = directory.getAbsolutePath()+"\\src\\main\\java\\"
                    +this.packageOutPath.replace(".","\\")+"\\";
            System.out.println("the output path is :" + outputPath);
            File path = new File(outputPath);
            if(!path.exists() && !path.isDirectory())
            {
                path.mkdir();
                System.out.println(path.exists());
            }
            outputPath += initcap(tablename)+".java";
            File file= new File(outputPath);
            if(!file.exists())
                file.createNewFile();
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(content);//save the content into the file.
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String parse(String tablename)
    {
        StringBuffer sb = new StringBuffer();
        sb.append("package "+this.packageOutPath+";\r\n");
        if(f_util)
            sb.append("import java.util.Date;\r\n");
        if(f_sql)
            sb.append("import java.sql.*;\r\n");
        sb.append("\r\n");
        sb.append("\r\npublic class "+initcap(tablename)+"{\r\n");
        processAllAttrs(sb);
        processAllMethods(sb);
        sb.append("}\r\n");
        return sb.toString();
    }
    //to generate all properties.
    private void processAllAttrs(StringBuffer sb)
    {
        for(int i=0;i<colnames.size();i++)
            sb.append("\tprivate "+sqlType2JavaType(colTypes.get(i))+" "+colnames.get(i)+" ;\r\n");
    }
    //to generate all getter and setter for each property
    private void processAllMethods(StringBuffer stringBuffer)
    {
        for(int i=0;i<colnames.size();i++)
        {
            stringBuffer.append("\tpublic void set"+initcap(colnames.get(i))+"("
            +sqlType2JavaType(colTypes.get(i))+" "+colnames.get(i)+"){\r\n");
            stringBuffer.append("\t\tthis."+colnames.get(i)+"="+colnames.get(i)+";\r\n");
            stringBuffer.append("}\r\n");
            stringBuffer.append("\tpublic "+ sqlType2JavaType(colTypes.get(i))+" get"+initcap(colnames.get(i))+"(){\r\n");
            stringBuffer.append("\t\treturn "+colnames.get(i)+";\r\n");
            stringBuffer.append("\t}\r\n");            
        }
    }

    private String sqlType2JavaType(String sqlType)
    {
        if (sqlType.equalsIgnoreCase("bit")) {
            return "boolean";
        } else if (sqlType.equalsIgnoreCase("tinyint")) {
            return "byte";
        } else if (sqlType.equalsIgnoreCase("smallint")) {
            return "short";
        } else if (sqlType.equalsIgnoreCase("int")) {
            return "int";
        } else if (sqlType.equalsIgnoreCase("bigint")) {
            return "long";
        } else if (sqlType.equalsIgnoreCase("float")) {
            return "float";
        } else if (sqlType.equalsIgnoreCase("decimal")
                || sqlType.equalsIgnoreCase("numeric")
                || sqlType.equalsIgnoreCase("real")
                || sqlType.equalsIgnoreCase("money")
                || sqlType.equalsIgnoreCase("smallmoney")) {
            return "double";
        } else if (sqlType.equalsIgnoreCase("varchar")
                || sqlType.equalsIgnoreCase("char")
                || sqlType.equalsIgnoreCase("nvarchar")
                || sqlType.equalsIgnoreCase("nchar")
                || sqlType.equalsIgnoreCase("text")
                || sqlType.equalsIgnoreCase("MEDIUMTEXT")
                || sqlType.equalsIgnoreCase("LONGTEXT")) {
            return "String";
        } else if (sqlType.equalsIgnoreCase("datetime")) {
            return "Date";
        } else if (sqlType.equalsIgnoreCase("image")) {
            return "Blod";
        }
        return null;
    }

    //uppercase the firstletter of tablename
    private String initcap(String tablename)
    {
        char[] ch=tablename.toCharArray();
        if(ch[0]>='a' && ch[0]<='z')
            ch[0]=(char)(ch[0]-32);
        return new String(ch);
    }

    public void StartGenEntity() throws SQLException
    {
        Connection con=DBUtils.getConn();
        databaseName = con.getCatalog();
        if(databaseName !=null && !databaseName.equals("") && tableName!=null && !tableName.equals(""))
        {
            System.out.println("databasename and tablename can not exist at the same time.");
        }
        else
        {
            if(databaseName!=null && !databaseName.equals(""))
            {
                tablenames=new ArrayList<String>();
                getAllEntityTable(con,tablenames);//get all tables in the database
                System.out.println(tablenames);
                getEntity(tablenames, con);//generate classes based on the tablenames list.
            }
            else
            {
                getEntity(tableName,con);//generate a class for the given tableName.
            }
            DbUtils.closeQuietly(con);
        }
    }

    private void getAllEntityTable(Connection con, List<String> tablenames) throws SQLException
    {
        ResultSet rs = null;
        try
        {
            DatabaseMetaData dmd = (DatabaseMetaData)con.getMetaData();
            rs=dmd.getTables(con.getCatalog(),"root",null,new String[]{"TABLE"});
            while(rs.next())
                tablenames.add(rs.getString("TABLE_NAME"));
        }
        finally {
            try{
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
