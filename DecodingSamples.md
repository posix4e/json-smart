# Decoding JSON text #

```
  System.out.println("=======decode=======");
                
  String s="[0,{'1':{'2':{'3':{'4':[5,{'6':7}]}}}}]";
  Object obj=JSONValue.parse(s);
  JSONArray array=(JSONArray)obj;
  System.out.println("======the 2nd element of array======");
  System.out.println(array.get(1));
  System.out.println();
                
  JSONObject obj2=(JSONObject)array.get(1);
  System.out.println("======field \"1\"==========");
  System.out.println(obj2.get("1"));

  s="{}";
  obj=JSONValue.parse(s);
  System.out.println(obj);                

  String s="{\"key\":\"Value\"}";
  // JSONValue.parseStrict()
  // can be use to be sure that the input is wellformed
  Object obj=JSONValue.parseStrict(s);
  JSONObject obj3=(JSONObject)obj;
  System.out.println("====== Object content ======");
  System.out.println(obj3.get("key"));
  System.out.println();
```