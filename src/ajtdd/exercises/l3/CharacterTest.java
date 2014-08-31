package ajtdd.exercises.l3;

import junit.framework.TestCase;

public class CharacterTest extends TestCase {
	private static final char NEWLINE = '\n';
	private static final char TAB = '\t';
	private static final char SPACE = ' ';

	public void testWhitespace() {
		assertTrue("newline", Character.isWhitespace(NEWLINE));
		assertTrue("tab", Character.isWhitespace(TAB));
		assertTrue("space", Character.isWhitespace(SPACE));

		// assertAsciiWhitespaces(); // looking for additional white spaces
	}

	public void testGoodIdentifiers() {
		String[] goodIndentifiers = { "one", "value1", "numItems" };
//		String[] badIndentifiers = { "1one", "^value1", "num^Items" };

		for (String s : goodIndentifiers) {
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				assertTrue(String.format("identifier %c (%d)", ch, (int) ch),
						Character.isJavaIdentifierPart(ch));
			}
		}

		// for (int v = 0; v < 256; v++) {
		// char ch = (char) v;
		// assertTrue(String.format("identifier %c (%d)", ch, (int) ch),
		// Character.isJavaIdentifierPart(ch));
		// }
	}

	@SuppressWarnings("unused")
	private void assertAsciiWhitespaces() {
		for (int v = 0; v < 256; v++) {
			char ch = (char) v;
			if (ch == NEWLINE || ch == TAB || ch == SPACE) {
				continue;
			}
			assertFalse(String.format("character '%c' (0x%X) is whitespace",
					ch, (int) ch), Character.isWhitespace(ch));
		}
	}
}
