package ustc.maomao.patterns.bridge;

import ustc.maomao.patterns.support.MenuItem;
import ustc.maomao.patterns.support.PatternTester;

/**
 * @author Keene. Mail: waterzhj@ustc.edu.cn
 * 
 *         该代码遵循MIT License, 详细见 https://mit-license.org/
 * 
 *         Copyright {2017} {Keene}
 * 
 *         designed by Keene, implemented by {Keene}
 * 
 *         Bridge模式测试器
 *      
 */
public class BridageTester implements PatternTester {

	/* (non-Javadoc)
	 * @see ustc.maomao.patterns.support.PatternTester#test()
	 */
	@Override
	public void test() {
		DBImpl db=new SQLiteDBImpl();
		DBManager dbm=new DBManagerWithXmlLog();
        dbm.setDb(db);
        MenuItem item=new MenuItem();
        //查询鱼肉的信息(查)
        item.setmName("fish");
        MenuItem temp=(MenuItem)dbm.get(item);//查询结果
        System.out.println("Type: "+temp.getmType()+" Name: "
        +temp.getmName()+" Price: "
        	+temp.getmPrice());
        //将鱼肉价格翻倍（改）
        item.setmPrice(item.getmPrice()*2);
        if(dbm.modify(item))
        		System.out.println("Modify Successfully!");
        else
        		System.out.println("Modify Failurely!");
        //将鱼肉的信息去除（删）
        if(dbm.remove(item))
        		System.out.println("Remove Successfully!");
        else
        		System.out.println("Remove Failurely!");
        //新加羊肉的信息（增）
        item.setmType(1001);
        item.setmName("mutton");
        item.setmPrice(34);
        if(dbm.persist(item))
        		System.out.println("Persist Successfully!");
        else
        		System.out.println("Persist Failurely!");
	}

}
