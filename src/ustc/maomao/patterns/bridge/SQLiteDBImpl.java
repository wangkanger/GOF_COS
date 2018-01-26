package ustc.maomao.patterns.bridge;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Keene. Mail: waterzhj@ustc.edu.cn
 * 
 *         该代码遵循MIT License, 详细见 https://mit-license.org/
 * 
 *         Copyright {2017} {Keene}
 * 
 *         designed by Keene, implemented by {Keene}
 * 
 *         sqlite数据库访问实现
 *      
 */
public class SQLiteDBImpl implements DBImpl {

	/* (non-Javadoc)
	 * @see ustc.maomao.patterns.bridge.DBImpl#insert(java.lang.Object)
	 */
	SQLiteDBImpl()
	{
		 Connection conn=null;
		 Statement stat=null;
		 try{
	         //连接SQLite的JDBC
	         Class.forName("org.sqlite.JDBC");      
	         //建立一个数据库名wxs.db的连接，如果不存在就在当前目录下创建之
	         conn = DriverManager.getConnection("jdbc:sqlite:message.db");   
	         stat = conn.createStatement();
	         stat.executeUpdate("drop table if exists menu;");//若存在则删除
	         stat.executeUpdate("create table if not exists menu"
	         		+ "(mtype int,mname varchar(20), mprice float);");// 创建一个表，两列
	         
	         stat.executeUpdate("insert into menu values(1001,'fish',24.5);");
	         //关闭连接
	         conn.close(); //结束数据库的连接 
		 }
	        catch( Exception e )
	        {
	        	 
	        		e.printStackTrace ( );
	        }
		 	finally
		 	{
		 		
		 	}
	}
	@Override
	public boolean insert(Object o) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		String sql=null;
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
			//查询数据库
			
			try{
		         //连接SQLite的JDBC
		         Class.forName("org.sqlite.JDBC");      
		         //建立一个数据库名wxs.db的连接，如果不存在就在当前目录下创建之
		         conn = DriverManager.getConnection("jdbc:sqlite:message.db");   
		         stat = conn.createStatement();	
		         sql="insert into menu values("+map.get("mType").toString()+","
		        		 +"'"+map.get("mName").toString()+"',"
		        		 +map.get("mPrice").toString()+");";
		         System.out.println(sql);
		         stat.executeUpdate(sql); //更新数据
		         //验证是否更新 
		         rs=stat.executeQuery("select * from menu where mname='mutton'");
		         while (rs.next()) { //将查询到的数据存入对象返回
		        	 System.out.println("mType:"+rs.getObject("mtype")+
		        	 " mName:"+rs.getObject("mName")+
		        	" mPrice:"+rs.getObject("mprice"));
		        	 	}   
		         
		        	 	  
		         //关闭连接
			     rs.close();   
			     conn.close(); //结束数据库的连接 
			     
		         
			    }
		        catch( Exception e )
		        {
		        		e.printStackTrace ( );
		        		return false;
		        }
		        
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see ustc.maomao.patterns.bridge.DBImpl#update(java.lang.Object)
	 */
	@Override
	public boolean update(Object o) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		String sql=null;
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
			//查询数据库
			
			try{
		         //连接SQLite的JDBC
		         Class.forName("org.sqlite.JDBC");      
		         //建立一个数据库名wxs.db的连接，如果不存在就在当前目录下创建之
		         conn = DriverManager.getConnection("jdbc:sqlite:message.db");   
		         stat = conn.createStatement();	
		         sql="update menu set mprice="+map.get("mPrice").toString()+" where mname="
		         +"'"+map.get("mName").toString()+"';";
		         //System.out.println(sql);
		         
		         stat.executeUpdate(sql); //更新数据
		         //验证是否更新 
		         rs=stat.executeQuery("select * from menu where mname='fish'");
		         while (rs.next()) { //将查询到的数据存入对象返回
		        	 System.out.println("mType:"+rs.getObject("mtype")+
		        	 " mName:"+rs.getObject("mName")+
		        	 " mPrice:"+rs.getObject("mprice"));
		        	 	}   
		        	 	  
		         //关闭连接
			     rs.close();    
			     conn.close(); //结束数据库的连接 
			     
		         
			    }
		        catch( Exception e )
		        {
		        		e.printStackTrace ( );
		        		return false;
		        }
		        
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see ustc.maomao.patterns.bridge.DBImpl#delete(java.lang.Object)
	 */
		
	@Override
	public boolean delete(Object o) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		String sql=null;
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
			if(pd.getPropertyType().toString().equals("class java.lang.String"))
			{
				if(pd.getReadMethod().invoke(o)==null)
				{
					//sql=null;
					//System.out.println("String null");
				}
				else
				{
					//System.out.println(pd.getName());
					sql="delete  from menu where "+pd.getName()+"="
							+"'"+pd.getReadMethod().invoke(o)+"';";
					break;
				//System.out.println(sql);
				}
			}
			else if(pd.getPropertyType().toString().equals("float"))
			{
				if(pd.getReadMethod().invoke(o).toString().equals("0.0"))
				{
					//sql=null;
					//System.out.println("float null");
				}
				else
				{
					sql="delete from menu where "+pd.getName()+"="
							+"'"+pd.getReadMethod().invoke(o)+"';";
					break;
					//System.out.println(sql);
				}
			}
			else if(pd.getPropertyType().toString().equals("int"))
			{
				if(pd.getReadMethod().invoke(o).toString().equals("0"))
				{
					//sql=null;	
					//System.out.println("int null");
				}
				else
				{
					sql="delete  from menu where "+pd.getName()+"="
							+"'"+pd.getReadMethod().invoke(o)+"';";
					//System.out.println(sql);
				}
			}
			}
			
			//查询数据库
			try{
		         //连接SQLite的JDBC
		         Class.forName("org.sqlite.JDBC");      
		         //建立一个数据库名wxs.db的连接，如果不存在就在当前目录下创建之
		         conn = DriverManager.getConnection("jdbc:sqlite:message.db");   
		         stat = conn.createStatement();	
		         stat.executeUpdate(sql);
			     conn.close(); //结束数据库的连接 
			    }
		        catch( Exception e )
		        {
		        		e.printStackTrace ( );
		        		return false;
		        }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see ustc.maomao.patterns.bridge.DBImpl#query(java.lang.Object)
	 */
	@Override
	public Object query(Object o) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		String sql=null;
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
			if(pd.getPropertyType().toString().equals("class java.lang.String"))
			{
				if(pd.getReadMethod().invoke(o)==null)
				{
					//sql=null;
					//System.out.println("String null");
				}
				else
				{
					//System.out.println(pd.getName());
					sql="select * from menu where "+pd.getName()+"="
							+"'"+pd.getReadMethod().invoke(o)+"';";
					break;
				//System.out.println(sql);
				}
			}
			else if(pd.getPropertyType().toString().equals("float"))
			{
				if(pd.getReadMethod().invoke(o).toString().equals("0.0"))
				{
					//sql=null;
					//System.out.println("float null");
				}
				else
				{
					sql="select * from menu where "+pd.getName()+"="
							+"'"+pd.getReadMethod().invoke(o)+"';";
					break;
					//System.out.println(sql);
				}
			}
			else if(pd.getPropertyType().toString().equals("int"))
			{
				if(pd.getReadMethod().invoke(o).toString().equals("0"))
				{
					//sql=null;	
					//System.out.println("int null");
				}
				else
				{
					sql="select * from menu where "+pd.getName()+"="
							+"'"+pd.getReadMethod().invoke(o)+"';";
					break;
					//System.out.println(sql);
				}
			}
			}
			
			//查询数据库
			try{
		         //连接SQLite的JDBC
		         Class.forName("org.sqlite.JDBC");      
		         //建立一个数据库名wxs.db的连接，如果不存在就在当前目录下创建之
		         conn = DriverManager.getConnection("jdbc:sqlite:message.db");   
		         stat = conn.createStatement();	         
		         rs = stat.executeQuery(sql); //查询数据 
		         while (rs.next()) { //将查询到的数据存入对象返回
		        	 	for (PropertyDescriptor pd : pds) {
		 				if (pd.getName() == "getClass()") {
		 					continue;
		 				}
		 				if (pd.getReadMethod() == null || pd.getWriteMethod() == null) { // 如果set, get不配对就不复制
		 					continue;
		 				}
		 				//根据数据类型将对象的数据域赋值
		 				if(pd.getPropertyType().toString().equals("class java.lang.String"))
		 					{
		 					
		 					pd.getWriteMethod().invoke(o, rs.getString(pd.getName()));
		 					//System.out.println(rs.getString(pd.getName()));
		 					}
		 				else if(pd.getPropertyType().toString().equals("float"))
		 				    {
		 					
		 					pd.getWriteMethod().invoke(o, rs.getFloat(pd.getName()));
		 					//System.out.println(rs.getString(pd.getName()));
		 				    }
		 				else if(pd.getPropertyType().toString().equals("int"))
		 					{
		 					
		 					pd.getWriteMethod().invoke(o, rs.getInt(pd.getName()));
		 					//System.out.println(rs.getInt(pd.getName()));
		 					}
		        	 	}      
		         
		         }
		         //关闭连接
			     rs.close();    
			     conn.close(); //结束数据库的连接 
			    }
		        catch( Exception e )
		        {
		        		e.printStackTrace ( );
		        		return null;
		        }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return o;
	}
}
