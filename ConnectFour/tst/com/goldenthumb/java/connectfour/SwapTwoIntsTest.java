package com.goldenthumb.java.connectfour;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SwapTwoIntsTest {

	@Test
	void testSwapTwoIntsWithTmp() {
		assertEquals(3, 3);
		
		int a = 13;
		int b = 17;
		assertEquals(13, a);
		assertEquals(17, b);
		
		int tmp = a;
		a = b;
		b = tmp;
		
		assertEquals(17, a);
		assertEquals(13, b);
	}

	@Test
	void testSwapTwoIntsWithoutTmp() {
		assertEquals(3, 3);
		
		int a = 13;
		int b = 17;
		assertEquals(13, a);
		assertEquals(17, b);
		
		a = a + b;
		b = a - b;
		a = a - b;
		
		assertEquals(17, a);
		assertEquals(13, b);
	}

	
}
