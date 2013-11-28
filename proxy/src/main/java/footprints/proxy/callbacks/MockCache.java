package footprints.proxy.callbacks;

import net.sf.cglib.proxy.FixedValue;

public class MockCache implements FixedValue {

	@Override
	public Object loadObject() throws Exception {
		return "mock_value";
	}

}
