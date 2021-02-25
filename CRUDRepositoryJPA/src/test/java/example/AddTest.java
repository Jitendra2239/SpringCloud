package example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
@RunWith(MockitoJUnitRunner.class)
class AddTest {
	@Autowired
      Add add;
int res=add.add(2, 3);
	@Test
	void testAdd() {
		assertEquals(5,res);
	}

}
