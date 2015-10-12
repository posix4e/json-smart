# Example 1 - Merge 2 JSON object #

Json-Smart offer you a real json merge operator.
for example to merge those 2 values:
```
String json1 = "{'car':{'color':'blue'}}";
String json2 = "{'car':{'size':'3.5m'}}";
```
Process like this:
```
JSONParser p = new JSONParser();
JSonObject o1 = (JSonObject)p.parse(json1);
JSonObject o2 = (JSonObject)p.parse(json2);

o1.merge(o2);

System.out.println(o2):
```

Merge done and return:
```
{"car":{"size":"3.5m", "color":"blue"}}";
```

Merging 2 arrays are simply done by appening elements from one to other.