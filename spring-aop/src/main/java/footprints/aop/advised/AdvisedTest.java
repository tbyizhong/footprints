package footprints.aop.advised;

import org.junit.Test;
import org.springframework.aop.framework.ProxyCreatorSupport;

import footprints.aop.advice.LogArgAdvice;
import footprints.aop.service.HiService;
import footprints.aop.service.HiServiceImpl;

public class AdvisedTest {

	@Test
	public void testAdvised() {
		ProxyCreatorSupport pcs = new ProxyCreatorSupport();
		pcs.addAdvice(new LogArgAdvice());
		
		HiService hi = new HiServiceImpl();
		pcs.setTarget(hi);
		
		hi = (HiService)pcs.getAopProxyFactory().createAopProxy(pcs).getProxy();
		hi.sayHi("haha");
	}
}
