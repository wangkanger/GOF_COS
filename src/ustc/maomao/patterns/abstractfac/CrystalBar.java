package ustc.maomao.patterns.abstractfac;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
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
 *         水晶风格的柱状图
 *      
 */
public class CrystalBar extends Bar {
	
	private Data data;

	/* (non-Javadoc)
	 * @see ustc.maomao.patterns.abstractfac.Bar#draw()
	 */
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("绘制水晶样式的柱状图...");
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
		DefaultCategoryDataset dpd=getDataSet();//get data
		JFreeChart chart=ChartFactory.createBarChart3D("3D条形图",
				"Category","Score",  
				dpd,PlotOrientation.VERTICAL,
				true,true,false); 
		//可以查具体的API文档,第一个参数是标题，第二个参数是一个数据集，第三个参数表示是否显示Legend，第四个参数表示是否显示提示，第五个参数表示图中是否存在URL    
		ChartFrame chartFrame=new ChartFrame("3条形图",chart); 
		//chart要放在Java容器组件中，ChartFrame继承自java的Jframe类。该第一个参数的数据是放在窗口左上角的，不是正中间的标题。
		chartFrame.pack(); //以合适的大小展现图形
		chartFrame.setVisible(true);//图形是否可见
	}
	private DefaultCategoryDataset getDataSet()
	{
	        String fiat = "FIAT";        
	        String audi = "AUDI";        
	        String ford = "FORD";        
	        String speed = "Speed";        
	        String millage = "Millage";        
	        String userrating = "User Rating";        
	        String safety = "safety";  
		    DefaultCategoryDataset dataset = 
			      new DefaultCategoryDataset( );  

		    dataset.addValue( 1.0 , fiat , speed );        
		    dataset.addValue( 3.0 , fiat , userrating );        
		    dataset.addValue( 5.0 , fiat , millage ); 
		    dataset.addValue( 5.0 , fiat , safety );           

			dataset.addValue( 5.0 , audi , speed );        
			dataset.addValue( 6.0 , audi , userrating );       
			dataset.addValue( 10.0 , audi , millage );        
			dataset.addValue( 4.0 , audi , safety );

			dataset.addValue( 4.0 , ford , speed );        
			dataset.addValue( 2.0 , ford , userrating );        
			dataset.addValue( 3.0 , ford , millage );        
			dataset.addValue( 6.0 , ford , safety );               

			return dataset; 

	}
	

}
