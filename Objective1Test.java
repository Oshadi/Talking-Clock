import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Objective1Test {

	Objective1 objective1;
	@BeforeEach
	void setUp() throws Exception {
		objective1 = new Objective1();
	}

	@Test
	void test() {
		objective1.main(new String[] {"arg1", "arg2", "arg3"});
	}

}
