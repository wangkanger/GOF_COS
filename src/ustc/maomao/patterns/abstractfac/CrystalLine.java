package ustc.maomao.patterns.abstractfac;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import ustc.maomao.patterns.support.Data;

/**
 * @author Keene. Mail: waterzhj@ustc.edu.cn
 * 
 *         该代码遵循MIT License, 详细见 https://mit-license.org/
 * 
 *         Copyright {2017} {Keene}
 * 
 *         designed by Keene, implemented by {Keene}
 * 
 *         水晶风格的线状图
 *      
 */
public class CrystalLine extends Line {
	
	private Data data;

	/* (non-Javadoc)
	 * @see ustc.maomao.patterns.abstractfac.Line#draw()
	 */
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		 System.out.println("绘制水晶样式的线状图...");
		 drawTest();
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Data data) {
		this.data = data;
	}	
	public void drawTest()
	{
		DefaultCategoryDataset  dpd=getDataSet();//get data
		JFreeChart chart=ChartFactory.createLineChart3D("3D折线图",
				"Years","Number of Schools",
		         (CategoryDataset) dpd,PlotOrientation.VERTICAL,
		         true,true,false);
		//可以查具体的API文档,第一个参数是标题，第二个参数是一个数据集，第三个参数表示是否显示Legend，第四个参数表示是否显示提示，第五个参数表示图中是否存在URL    
		ChartFrame chartFrame=new ChartFrame("3D折线图",chart); 
		//chart要放在Java容器组件中，ChartFrame继承自java的Jframe类。该第一个参数的数据是放在窗口左上角的，不是正中间的标题。
		chartFrame.pack(); //以合适的大小展现图形
		chartFrame.setVisible(true);//图形是否可见
	}
	private DefaultCategoryDataset  getDataSet()
	{
		DefaultCategoryDataset  dataset=new DefaultCategoryDataset (); //建立一个默认的饼图
		 dataset.addValue( 15 , "schools" , "1970" );
	     dataset.addValue( 30 , "schools" , "1980" );
	     dataset.addValue( 60 , "schools" ,  "1990" );
	     dataset.addValue( 120 , "schools" , "2000" );
	     dataset.addValue( 240 , "schools" , "2010" );
	     dataset.addValue( 300 , "schools" , "2014" );
		return dataset;
	}
	

}
