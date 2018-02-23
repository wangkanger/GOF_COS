
package ustc.maomao.patterns;

import ustc.maomao.patterns.abstractfac.AbstractFacTester;
import ustc.maomao.patterns.adapter.AdapterTester;
import ustc.maomao.patterns.bridge.BridageTester;
import ustc.maomao.patterns.builder.BuilderTester;
import ustc.maomao.patterns.command.CommandTester;
import ustc.maomao.patterns.composite.CompositeTester;
import ustc.maomao.patterns.cor.CORTester;
import ustc.maomao.patterns.decorator.DecoratorTester;
import ustc.maomao.patterns.facade.FacadeTester;
import ustc.maomao.patterns.factorymethod.FactoryMethodTester;
import ustc.maomao.patterns.flyweight.FlyweightTester;
import ustc.maomao.patterns.interpreter.InterpreterTester;
import ustc.maomao.patterns.iterator.IteratorTester;
import ustc.maomao.patterns.mediator.MediatorTester;
import ustc.maomao.patterns.memento.MementoTester;
import ustc.maomao.patterns.observer.ObserverTester;
import ustc.maomao.patterns.prototype.ProtoTester;
import ustc.maomao.patterns.proxy.ProxyTester;
import ustc.maomao.patterns.singleton.SingletonTester;
import ustc.maomao.patterns.state.StateTester;
import ustc.maomao.patterns.strategy.StrategyTester;
import ustc.maomao.patterns.support.PatternTester;
import ustc.maomao.patterns.templatemethod.TemplateMethodTester;
import ustc.maomao.patterns.visitor.VisitorTester;

/**
 * @author Keene. Mail: waterzhj@ustc.edu.cn
 * 
 *         该代码遵循MIT License, 详细见 https://mit-license.org/
 * 
 *         Copyright {2017} {Keene}
 * 
 *         designed by Keene, implemented by {Keene}
 * 
 *         调用每个模式包中的测试器，即可完成对应的模式示例测试
 *      
 */
public class PatternsApp {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {		
		///////////////////BEFORE///////////////////////	
		//将SingletonTester替换成目标模式测试器
			
		//AbstractFacTester aft=new AbstractFacTester();//抽象工厂测试
		//aft.test();
		//AdapterTester at=new AdapterTester();//适配器模式
		//at.test();
		//BridageTester bt=new BridageTester();//桥模式
		//bt.test();
		//BuilderTester bt=new BuilderTester();//构造器模式
		//bt.test();
		//CommandTester ct=new CommandTester();//命令模式
		//ct.test();
		//CompositeTester ct=new CompositeTester();//组合模式
		//ct.test();
		//SingletonTester st=new SingletonTester();//单例模式(解析xml文件???使用xml文件)
		//st.test();
		//ProtoTester pt=new ProtoTester();//原型模式-->邮件发送场景（UI，消息队列）
		//UI以及构建，具体发送内容?????
		//pt.test();
		//DecoratorTester dt=new DecoratorTester();//装饰器模式-->定菜功能
		//dt.test();
		////////////////////TODAY////////////////////////
		//CORTester ct=new CORTester();//责任链模式
		//ct.test();
		//ProxyTester pt=new ProxyTester();//代理模式//图形界面做好了
		//pt.test();
		//ObserverTester ot=new ObserverTester();//观察者模式
		//ot.test();
		//VisitorTester vt=new VisitorTester();//访问者模式
		//vt.test();
		/////////////////////AFTER//////////////////
		FacadeTester ft=new FacadeTester();//门面模式
		ft.test();
		//FactoryMethodTester fmt=new FactoryMethodTester();//工厂模式
		//fmt.test();
		//FlyweightTester ft=new FlyweightTester();//享元模式
		//ft.test();
		//InterpreterTester it=new InterpreterTester();//解释器模式
		//it.test();
		//TemplateMethodTester tmt=new TemplateMethodTester();//模板模式
		//tmt.test();
		//StrategyTester st=new StrategyTester();//策略模式
		//st.test();
		//MediatorTester mt =new MediatorTester();//中介模式
		//mt.test();
		//IteratorTester it =new IteratorTester();//迭代器模式
		//it.test();	
		//StateTester st=new StateTester();//状态模式
		//st.test();
		//MementoTester mt=new MementoTester();//备忘录模式
		//mt.test();
		
	}

}
