package net.minidev.json.test;

import junit.framework.TestCase;
import net.minidev.json.parser.ParseException;

public class TestString extends TestCase {

	public void testS1() throws Exception {
		MustThrows.testStrictInvalidJson("{\"1\":\"one\"\n\"2\":\"two\"}", ParseException.ERROR_UNEXPECTED_TOKEN);
	}
}
