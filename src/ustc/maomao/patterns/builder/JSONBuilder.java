package ustc.maomao.patterns.builder;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

/**
 * @author Keene. Mail: waterzhj@ustc.edu.cn
 * 
 *         该代码遵循MIT License, 详细见 https://mit-license.org/
 * 
 *         Copyright {2017} {Keene}
 * 
 *         designed by Keene, implemented by {Keene}
 * 
 *         JSON文本构造器
 * 
 */
public class JSONBuilder implements TextBuilder {

	private JSONText json;// json文本对象
	private String jsonElement;

	public JSONBuilder() {
		json = new JSONText();
	}

	/**
	 * @return 构造的json文本
	 */
	public JSONText getJsonText() {
		//保存为json文件
		try
		{
			File file = new File("menu.json");  
			StringBuffer sb = new StringBuffer();
			sb.append(json.getText().toString());
			Writer write = new FileWriter(file); 
			//System.out.println("####"+sb);
	        write.write(sb.toString());  
	        write.flush();  
	        write.close();  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return json;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ustc.maomao.patterns.builder.TextBuilder#convertmType(int)
	 */
	@Override
	public void convertmType(int mType) {
		jsonElement="\n{\"MType\":\""+mType+"\"";
		jsonElement+=",";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ustc.maomao.patterns.builder.TextBuilder#convertmName(java.lang.String)
	 */
	@Override
	public void convertmName(String mName) {
		jsonElement+="\"MName\":\""+mName+"\"";
		jsonElement+=",";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ustc.maomao.patterns.builder.TextBuilder#convertmPrice(float)
	 */
	@Override
	public void convertmPrice(float mPrice) {
		jsonElement+="\"MPrice\":\""+mPrice+"\"}";
		json.add(jsonElement);
	}

}
