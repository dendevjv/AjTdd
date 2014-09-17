package ajtdd.chess;

import junit.framework.TestCase;

public class MoveTest extends TestCase {
	public void testCreate() {
		Move a1 = new Move("a1");
		assertEquals(1, a1.getRank());
		assertEquals(1, a1.getColumn());
		assertEquals("a1", a1.toString());
		
		Move d2 = new Move(2, 4);
		assertEquals(2, d2.getRank());
		assertEquals(4, d2.getColumn());
		assertEquals("d2", d2.toString());
		
		Move f3 = new Move("f3");
		assertEquals(3, f3.getRank());
		assertEquals(6, f3.getColumn());
		assertEquals("f3", f3.toString());
	}
	
	public void testEqual() {
		Move a1_1 = new Move("a1");
		assertTrue(a1_1.equals(a1_1));
		assertFalse(a1_1.equals(null));
		
		Move a1_2 = new Move("a1");
		assertEquals(a1_1, a1_2);
		assertEquals(a1_2, a1_1);
		
		Move d2 = new Move(2, 4);
		assertFalse(a1_1.equals(d2));
		assertFalse(d2.equals(a1_1));
	}
	
	public void testHashcode() {
		Move a1_1 = new Move("a1");
		Move a1_2 = new Move("a1");
		assertEquals(a1_1.hashCode(), a1_2.hashCode());
	}
	
	public void testMake() {
		Move a1 = new Move("a1");
		
		Move b1 = a1.make(0, 1);
		assertEquals(2, b1.getColumn());
		assertEquals(1, b1.getRank());
		assertEquals("b1", b1.toString());
		
		Move b2 = b1.make(1, 0);
		assertEquals(2, b2.getColumn());
		assertEquals(2, b2.getRank());
		assertEquals("b2", b2.toString());
		
		Move a2 = b2.make(0, -1);
		assertEquals(1, a2.getColumn());
		assertEquals(2, a2.getRank());
		assertEquals("a2", a2.toString());
		
		Move a1_2 = a2.make(-1, 0);
		assertEquals(1, a1_2.getColumn());
		assertEquals(1, a1_2.getRank());
		assertEquals("a1", a1_2.toString());
		assertEquals(a1, a1_2);
	}
}
