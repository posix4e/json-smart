# Example 1-1 - Encode a JSON object #
```
  //import net.minidev.json.JSONObject;
  
  // Json Object is an HashMap<String, Object> extends
  JSONObject obj = new JSONObject();
  obj.put("name", "foo");
  obj.put("num", 100);
  obj.put("balance", 1000.21);
  obj.put("is_vip", true);
  obj.put("nickname",null);

  System.out.println("Standard RFC4627 JSON");
  System.out.println(obj.toJSONString());

  System.out.println("Compacted JSON Value");
  System.out.println(obj.toJSONString(JSONStyle.MAX_COMPRESS));

  // if obj is an common map you can use:

  System.out.println("Standard RFC4627 JSON");
  System.out.println(JSONValue.toJSONString(obj));

  System.out.println("Compacted JSON Value");
  System.out.println(JSONValue.toJSONString(obj, JSONStyle.MAX_COMPRESS));

```

## Result: ##

Standard RFC4627 JSON:
```
{"balance":1000.21,"num":100,"nickname":null,"is_vip":true,"name":"foo"}
```

Compacted JSON:
```
{balance:1000.21,num:100,nickname:null,is_vip:true,name:foo}
```