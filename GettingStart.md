

# Get binarys #

If you are dependency manager, you can add:

for Maven user:
```xml


<dependency>

<groupId>net.minidev

Unknown end tag for &lt;/groupId&gt;



<artifactId>json-smart

Unknown end tag for &lt;/artifactId&gt;



<version>1.2

Unknown end tag for &lt;/version&gt;





Unknown end tag for &lt;/dependency&gt;



```

for Ivy user:

```xml

<dependency org="net.minidev" name="json-smart" rev="1.2"/>
```

if you have no dependency manager, simply download the last release from the download page.

# configure global variable #
you may easily change json-smart default feature by changing the public static field:
net.minidev.json.JSONValue.COMPRESSION = JSONStyle.**;
you can use a built in compression mode:**

**JSONStyle.NO\_COMPRESS**

**JSONStyle.LT\_COMPRESS**

**JSONStyle.MAX\_COMPRESS**

or a custom one

**`new JSONStyle(JSONStyle.FLAG_PROTECT_4WEB | ...);`**

default parsing mode can not be change globaly.

# Parse json string / json stream #

the simplest way to parse json data is to use net.minidev.json.JSONValue static's methodes like:

**`JSONValue.parse(String/Reader data);`**

**`JSONValue.parseStrict(String/Reader data);`**

**`JSONValue.parseWithException(String/Reader data);`**

if you are using json-smart 2.X you will be able to use:

**`JSONValue.parse(String/Reader data, Class<T> mapTo);`**

**`JSONValue.parseStrict(String/Reader data, Class<T> mapTo);`**

**`JSONValue.parseWithException(String/Reader data, Class<T> mapTo);`**

to map the input to a java bean of the given type.

if you are using json-smart 2.X you will be able to use:

**`JSONValue.parse(String/Reader data, T toUpdate);`**

**`JSONValue.parseStrict(String/Reader data, T toUpdate);`**

**`JSONValue.parseWithException(String/Reader data, T toUpdate);`**

to fill a bean with the given data.

# Build a json-object using default Object mapper #

JSONObject is the default Object mapper.
to build an json object, you can simply use this Class to build your object:
```java

JSONObject obj=new JSONObject();
obj.put("name","foo");
obj.put("num",new Integer(100));
obj.put("balance",new Double(1000.21));
obj.put("is_vip",new Boolean(true));
obj.put("nickname",null);
System.out.print(obj);
```

Result: {"balance":1000.21,"num":100,"nickname":null,"is\_vip":true,"name":"foo"}

# Build a json-object using JSONNavi #

```java

JSONNavi navi = JSONNavi.newInstance();
navi.set("name","foo").set("num",100).set("balance",1000.21).set obj.put("is_vip",true)set("nickname",(String)null);
System.out.print(navi);
```

Result: {"balance":1000.21,"num":100,"nickname":null,"is\_vip":true,"name":"foo"}