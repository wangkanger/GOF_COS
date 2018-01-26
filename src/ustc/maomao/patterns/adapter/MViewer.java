package ustc.maomao.patterns.adapter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @author Keene. Mail: waterzhj@ustc.edu.cn
 * 
 *         该代码遵循MIT License, 详细见 https://mit-license.org/
 * 
 *         Copyright {2017} {Keene}
 * 
 *         designed by Keene, implemented by {Keene}
 * 
 *         显示List<HashMap<String,String>>菜单数据的视图类型
 * 
 */
public class MViewer {
	
	/**
	 * 显示List<HashMap<String,String>>菜单数据
	 * @param data 提供List<HashMap<String,String>>菜单数据的目标类型
	 */
	public void displayMenuList(MList dataSource){
	    List<HashMap<String,String>> data=dataSource.getData();
	    JFrame f = new JFrame();
	    Object[][] dataArray =new Object[data.size()][3];
	    int i=0;
	    for(HashMap<String,String> item:data){
	    //	System.out.println(item);
	    	System.out.println("渲染:"+item.get("mType")+"##"+item.get("mName")+"##"+item.get("mPrice"));
	    dataArray[i][0]= item.get("mType");
	    dataArray[i][1]=item.get("mName");
	    dataArray[i][2]=item.get("mPrice");
	    	i++;
	    }
	    String[] Names = { "Type", "Name", "Price" };
	    // 以Names和playerInfo为参数，创建一个表格
	    JTable table = new JTable(dataArray, Names);
	    // 设置此表视图的首选大小
	    table.setPreferredScrollableViewportSize(new Dimension(550, 100));
	    // 将表格加入到滚动条组件中
	    JScrollPane scrollPane = new JScrollPane(table);
	    f.getContentPane().add(scrollPane, BorderLayout.CENTER);
	    // 再将滚动条组件添加到中间容器中
	    f.setTitle("表格测试");
	    f.pack();
	    f.setVisible(true);
	    f.addWindowListener((WindowListener) new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent e) {
	            System.exit(0);
	        }
	    });
	}	

}
