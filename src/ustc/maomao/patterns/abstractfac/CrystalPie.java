package ustc.maomao.patterns.abstractfac;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

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
 *         水晶风格的饼状图
 *      
 */
public class CrystalPie extends Pie {
	
	private Data data;

	/* (non-Javadoc)
	 * @see ustc.maomao.patterns.abstractfac.Pie#draw()
	 */
	@Override
	public void draw() {
		// TODO Auto-generated method stub
        System.out.println("绘制水晶样式的饼状图...");
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
		DefaultPieDataset dpd=getDataSet();//get data
		JFreeChart chart=ChartFactory.createPieChart3D("3D饼图",dpd,true,true,false); 
		//可以查具体的API文档,第一个参数是标题，第二个参数是一个数据集，第三个参数表示是否显示Legend，第四个参数表示是否显示提示，第五个参数表示图中是否存在URL    
		ChartFrame chartFrame=new ChartFrame("3D饼图",chart); 
		//chart要放在Java容器组件中，ChartFrame继承自java的Jframe类。该第一个参数的数据是放在窗口左上角的，不是正中间的标题。
		chartFrame.pack(); //以合适的大小展现图形
		chartFrame.setVisible(true);//图形是否可见
	}
	private DefaultPieDataset getDataSet()
	{
		DefaultPieDataset dpd=new DefaultPieDataset(); //建立一个默认的饼图
		dpd.setValue("管理人员", 25);  //输入数据
		dpd.setValue("市场人员", 25);
		dpd.setValue("开发人员", 45);
		dpd.setValue("其他人员", 10);
		return dpd;
	}

}
