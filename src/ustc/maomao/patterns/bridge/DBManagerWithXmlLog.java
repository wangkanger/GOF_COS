package ustc.maomao.patterns.bridge;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import java.io.File;
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


/**
 * @author Keene. Mail: waterzhj@ustc.edu.cn
 * 
 *         该代码遵循MIT License, 详细见 https://mit-license.org/
 * 
 *         Copyright {2017} {Keene}
 * 
 *         designed by Keene, implemented by {Keene}
 * 
 *         xml日志实现
 *      
 */
public class DBManagerWithXmlLog extends DBManager {
	static int i=0;

	/* (non-Javadoc)
	 * @see ustc.maomao.patterns.bridge.DBManager#log(java.lang.String)
	 */
	@Override
	public void log(String operation,Object o) {		
        System.out.println("<operation>"+operation+"</operation>");
   		Map<String,Object> map=new HashMap<String,Object>();
   		//获取Object信息
   		try
   		{
   			BeanInfo beanInfo = Introspector.getBeanInfo(o.getClass()); // 得到o的Bean信息
   			PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors(); //通过BeanInfo得到域的描述符
   			for (PropertyDescriptor pd : pds) {
   				if (pd.getName() == "getClass()") {
   					continue;
   			}
   			if (pd.getReadMethod() == null || pd.getWriteMethod() == null) { // 如果set, get不配对就不复制
   				continue;
   			}
   			//System.out.println(pd.getPropertyType().toString());
   			map.put(pd.getName(),pd.getReadMethod().invoke(o));
   			}     
   		}
   		catch(Exception e)
   		{
   			e.printStackTrace();
   		}
        //操作xml文件，日志记录
   		
   		//String ActionName=null;
   		//String startTime=null;
   		    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();   
   		    DocumentBuilder builder=null;  
   		    try {   
   		    builder = factory .newDocumentBuilder();   
   		    } catch (ParserConfigurationException pce) {   
   		    pce.printStackTrace();  
   		    } 
   		    try {
   		    	
   		    Document doc = null;   
   		    doc = builder.parse("./log.xml"); 
   		    //System.out.println("doc"+doc);
   		    
   		    NodeList logList =doc.getElementsByTagName("log");
   		    Element root=(Element) logList.item(0);
   		    
   		    Element Operation = doc.createElement("Operation"); 
   		    Operation.setTextContent(operation);
   		    root.appendChild(Operation);
   		    
   		    Date day=new Date();
   		    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   		    //System.out.println(df.format(day));
   		    Element mTime = doc.createElement("mTime"); 
   		    mTime.setTextContent(df.format(day));
		    Operation.appendChild(mTime);
		    
   		    Element mType = doc.createElement("mType"); 
   		    mType.setTextContent(map.get("mType").toString());
   		    Operation.appendChild(mType);
   		    
   		    Element mName = doc.createElement("mName"); 
		    mName.setTextContent(map.get("mName").toString());
		    Operation.appendChild(mName);
		    
		    Element mPrice = doc.createElement("mPrice"); 
   		    mPrice.setTextContent(map.get("mPrice").toString());
   		    Operation.appendChild(mPrice);
   	
   		    TransformerFactory  factory1=TransformerFactory.newInstance();
   		    Transformer transformer=factory1.newTransformer();
   		    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
   		    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); 
   		    transformer.setOutputProperty(OutputKeys.METHOD, "xml");  
   		    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
   		    transformer.transform(new DOMSource(doc),new StreamResult(new File("./log.xml")));
   		    //transformer.transform(xmlSource, outputTarget);
   		    }
   		    catch(Exception e)
   		    {
   		    	e.printStackTrace();
   		    }
   		
/*
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
   		    NodeList logList =doc.getElementsByTagName("log");
   		    Element root=(Element) logList.item(0);
   		    
   		    Element action = doc.createElement("action");      
   		    root.appendChild(action);   
   		    //
   		    Element name = doc.createElement("name"); 
   		    name.setTextContent("Action");
   		    action.appendChild(name);   
   		    //
   		    Element s_time = doc.createElement("s-time"); 
   		   
   		    s_time.setTextContent("startTime");
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
   		    transformer.transform(new DOMSource(doc),new StreamResult(new File("log.xml")));
   		    }
   		    catch(Exception e)
   		    {
   		    	e.printStackTrace();
   		    }
   		*/
   		//*****************
	}

}
