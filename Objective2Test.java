import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Objective2Test {
	Objective2 objective2;
	@BeforeEach
	void setUp() throws Exception {
		
		objective2 = new Objective2();
	}

	@Test
	void test() {
		objective2.main(new String[] {"arg1", "arg2", "arg3"});

	}

}
