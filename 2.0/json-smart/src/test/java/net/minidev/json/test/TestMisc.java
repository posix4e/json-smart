package net.minidev.json.test;

import junit.framework.TestCase;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

public class TestMisc extends TestCase {

	public void testEmptyStrict() throws Exception {
		String s = "{\"key1\":\"v1\", \"key2\":{}, \"key3\":[]}";
		JSONObject o = (JSONObject) JSONValue.parseStrict(s);
		
		assertEquals(o.get("key1"), "v1");
		assertEquals(((JSONObject)o.get("key2")).size(), 0);
		assertEquals(((JSONArray)o.get("key3")).size(), 0);
	}
	
	public void testBool() throws Exception {
		String s = "{\"key1\":\"v1\", \"key2\":{}, \"key3\":[]}";
		JSONObject o = (JSONObject) JSONValue.parseWithException(s);
		
		assertEquals(o.get("key1"), "v1");
		assertEquals(((JSONObject)o.get("key2")).size(), 0);
		assertEquals(((JSONArray)o.get("key3")).size(), 0);
	}
	
}
