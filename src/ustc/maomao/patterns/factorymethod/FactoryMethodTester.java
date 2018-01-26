package ustc.maomao.patterns.factorymethod;

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
 *         工厂方法模式测试器
 *      
 */
public class FactoryMethodTester implements PatternTester{

	/* (non-Javadoc)
	 * @see ustc.maomao.patterns.support.PatternTester#test()
	 */
	@Override
	public void test() {
		String fileName="test";
		DocumentCreator dc=new PdfDocumentCreator();
		dc.exportDocument(fileName);		
	}	

}
