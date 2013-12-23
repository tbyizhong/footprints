package footprints.aop.advice;


public class XmlLogArgAdvice {
	public void hi(){}

	public void before() {
		System.out.println("-----");
	}
	
	public void after() {
		System.out.println("====");
	}
}
