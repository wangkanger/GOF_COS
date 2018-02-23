package ustc.a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
public class Test {
	public static void main(String[] args){
		/*
		for(int i=0;i<10;i++)
			writePreActionXML("111","222");
		System.out.println("Success!");
		*/
		//Date day=new Date();
		//SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//System.out.println(df.format(day));
		//readJson("fun.json");
		//System.out.println("Success!");
		 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();   
		    DocumentBuilder builder=null;  
		    try {   
		    builder = factory .newDocumentBuilder();   
		    } catch (ParserConfigurationException pce) {   
		    pce.printStackTrace();  
		    } 
		    try {
		    	
		    Document doc = null;   
		    doc = builder.parse("./info.xml"); 
		    System.out.println(doc);
		    }
		    catch(Exception e)
		    {
		    		e.printStackTrace();
		    }
		System.out.println("Success!");

    }
	//UI
	public static void testUI()
	{
		
	}
	public static void testReadJson()
	{
		try
		{ 
			FileOutputStream out = null;
	        FileOutputStream outSTr = null;
	        BufferedOutputStream Buff = null;
	        FileWriter fw = null;
			outSTr = new FileOutputStream(new File("menu.json"));
            Buff = new BufferedOutputStream(outSTr);
            Buff.write("测试java 文件操作\r\n".getBytes());
           
            Buff.flush();
            Buff.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("Success!");

	}
	//读json文件
	public static void readJson(String path)
	{
		 JsonParser parse =new JsonParser();  //创建json解析器
	        try {
	            JsonObject json=(JsonObject) parse.parse(new FileReader(path));  //创建jsonObject对象
	            
	            JsonArray array=json.get("MenuItems").getAsJsonArray();    //得到为json的数组
	            for(int i=0;i<array.size();i++){
	                System.out.println("---------------");
	                JsonObject subObject=array.get(i).getAsJsonObject();
	                System.out.println("MType="+subObject.get("MType").getAsInt());
	                System.out.println("MName="+subObject.get("MName").getAsString());
	                System.out.println("MPrice="+subObject.get("MPrice").getAsString());
	            }
	            /*
	            System.out.println("resultcode:"+json.get("resultcode").getAsInt());  //将json数据转为为int型的数据
	            System.out.println("reason:"+json.get("reason").getAsString());     //将json数据转为为String型的数据
	             
	            JsonObject result=json.get("result").getAsJsonObject();
	            JsonObject today=result.get("today").getAsJsonObject();
	            System.out.println("temperature:"+today.get("temperature").getAsString());
	            System.out.println("weather:"+today.get("weather").getAsString());
	             */
	        } catch (JsonIOException e) {
	            e.printStackTrace();
	        } catch (JsonSyntaxException e) {
	            e.printStackTrace();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	}
	//写xml文件
	public  static void writePreActionXML(String Action,String startTime)
	{
	//String ActionName=null;
	//String startTime=null;
	 String endTime=null;
	 String actionResult=null;
	 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();   
	    DocumentBuilder builder=null;  
	    try {   
	    builder = factory .newDocumentBuilder();   
	    } catch (ParserConfigurationException pce) {   
	    pce.printStackTrace();  
	    } 
	    try {
	    	
	    Document doc = null;   
	    doc = builder.parse("log.xml"); 
	    //System.out.println("doc"+doc);
	    
	    NodeList logList =doc.getElementsByTagName("log");
	    Element root=(Element) logList.item(0);
	    
	    Element action = doc.createElement("action");      
	    root.appendChild(action);   
	    //
	    Element name = doc.createElement("name"); 
	    name.setTextContent(Action);
	    action.appendChild(name);   
	    //
	    Element s_time = doc.createElement("s-time"); 
	   
	    s_time.setTextContent(startTime);
	    action.appendChild(s_time);
	    //
	    Element e_time = doc.createElement("e-time"); 
	  
	    e_time.setTextContent(endTime);
	    action.appendChild(e_time);
	    //
	    Element result = doc.createElement("result");   
	    result.setTextContent(actionResult);
	    action.appendChild(result); 
	    
	   
	    TransformerFactory  factory1=TransformerFactory.newInstance();
	    Transformer transformer=factory1.newTransformer();
	    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	    transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
	    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); 
	    transformer.transform(new DOMSource(doc),new StreamResult(new File("log.xml")));
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	}
	//增删查改
	public static void CRUD()
	{
        try{

            //连接SQLite的JDBC
           Class.forName("org.sqlite.JDBC");      

            //建立一个数据库名wxs.db的连接，如果不存在就在当前目录下创建之
            Connection conn = DriverManager.getConnection("jdbc:sqlite:wxs.db");   
            Statement stat = conn.createStatement();
            stat.executeUpdate("drop table if exists wxs;");//若存在则删除
            stat.executeUpdate("create table if not exists wxs"
            		+ "(name varchar(20), salary int);");// 创建一个表，两列
            //添加
            stat.executeUpdate( "insert into wxs values('ZhangSan',8000);" ); //插入数据
            stat.executeUpdate( "insert into wxs values('LiSi',7800);" );
            stat.executeUpdate( "insert into wxs values('WangWu',5800);" );
            stat.executeUpdate( "insert into wxs values('ZhaoLiu',9100);" ); 
            stat.executeUpdate( "insert into wxs values('wxs',9100);" );
   		
            ResultSet rs = stat.executeQuery("select * from wxs;"); //查询数据 

            while (rs.next()) { //将查询到的数据打印出来
                System.out.print("name ：" + rs.getString("name") + " "); //列属性一
                System.out.println("salary ： " + rs.getString("salary")); //列属性二
            }
            System.out .println("******************************");
            //删除
            stat.executeUpdate("delete from wxs where name="+"'"+"WangWu"+"'");
            rs = stat.executeQuery("select * from wxs;"); //查询数据 

            while (rs.next()) { //将查询到的数据打印出来
                System.out.print("name ：" + rs.getString("name") + " "); //列属性一
                System.out.println("salary ： " + rs.getString("salary")); //列属性二
            }
            System.out.println("*******************************");
            //查询
            rs=stat.executeQuery("select * from wxs where salary=9100");
            while (rs.next()) { //将查询到的数据打印出来
                System.out.print("name ：" + rs.getString("name") + " "); //列属性一
                System.out.println("salary ： " + rs.getString("salary")); //列属性二
            }
            System.out.println("**********************************");
            //修改更新
            stat.executeUpdate("update wxs set salary=100000000 "
            		+ "where name="
            		+ "'"+"wxs"+"'");
            rs=stat.executeQuery("select * from wxs");
            while (rs.next()) { //将查询到的数据打印出来
                System.out.print("name ：" + rs.getString("name") + " "); //列属性一
                System.out.println("salary ： " + rs.getString("salary")); //列属性二
            }
            
            //关闭连接
            rs.close();
            conn.close(); //结束数据库的连接 
           }
           catch( Exception e )
           {
            e.printStackTrace ( );
           }
	}

}
