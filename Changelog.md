## Next developpement focus ##
  * Improve JsonP support
  * ~~Add advanced datamapping~~
  * Add XPath like expression

## Changelog V2 stream ##

**V 2.1**
  * net.minidev.json.mapper renamed to net.minidev.json.writer
  * Add ACCEPT\_TAILLING\_SPACE Parssing Flag.
  * Mapper classes now non static.
  * Reader mapper are now available in net.minidev.json.reader.JsonReader class
  * Writer mapper are now available in net.minidev.json.writer.JsonWriter class

**V 2.0**
  * Fix Double Identification [issue 44](http://code.google.com/p/json-smart/issues/detail?id=44)
  * Fix Collection Interface Serialisation
  * Fix security Exception in ASM code
  * Project moved to GitHub
  * Fix [issue 42](http://code.google.com/p/json-smart/issues/detail?id=42)

**V 2.0-RC3**
  * Add custom data binding inside the ASM layer.
  * Add Date support
  * Add \x escape sequence support [issue 39](http://code.google.com/p/json-smart/issues/detail?id=39)
  * fix issue [issue 37](http://code.google.com/p/json-smart/issues/detail?id=37)

**V 2.0-RC2**
  * Fix critical [issue 23](http://code.google.com/p/json-smart/issues/detail?id=23)
  * Improve Javadoc in JSONStyle [issue 24](http://code.google.com/p/json-smart/issues/detail?id=23)

**V 2.0-RC1**
  * speed improvement in POJO manipulation
  * add JSONStyle.LT\_COMPRESS predefined generate strct json, but ignoring / escapement.



## Changelog V1 stream ##


**V 1.3.1**
  * Add ACCEPT\_TAILLING\_SPACE Parssing Flag.
  * Reader mapper are now available in net.minidev.json.reader.JsonReader class

**V 1.3**
  * Fix Double Identification [issue 44](http://code.google.com/p/json-smart/issues/detail?id=44)
  * Project moved to GitHub
  * Fix [issue 26](http://code.google.com/p/json-smart/issues/detail?id=26)
  * Fix [issue 42](http://code.google.com/p/json-smart/issues/detail?id=42)

**V 1.2**
  * Add \x escape sequence support [issue 39](http://code.google.com/p/json-smart/issues/detail?id=39)
  * Fix missing handle params forward in JSONParser
  * fix issue [issue 37](http://code.google.com/p/json-smart/issues/detail?id=37)
  * Add verbose json format option [issue 35](http://code.google.com/p/json-smart/issues/detail?id=35)

**V 1.1.1**
  * Fix critical [issue 23](http://code.google.com/p/json-smart/issues/detail?id=23)
  * Improve Javadoc in JSONStyle [issue 24](http://code.google.com/p/json-smart/issues/detail?id=23)

**V 1.1**
  * add support for char[.md](.md) input.
  * add support for byte[.md](.md) input.
  * fix parser crash on some non valid data input.
  * reduce code duplication.

V 1.1.0 (deprecate)
  * Add marshaling support: can now read json as beans.
```
   Car car = JSONValue.parse("{'model':'mazda','color':'red'}", Car.class);
```
  * [ASM](http://asm.ow2.org) is needed to used Json-smart 1.1
  * WARNING: in this version some interfaces change and are no more compatible with json-simple.
  * speed improvement on beans Objects

V 1.0.9
  * add support for beans serialisation
  * add support for Date serialisation
  * add support for Enum serialisation
  * add support for primitive array serialisation
  * add support for JQuery like JSon manipulation.
```
  JSONNavi json = new JSONNavi();
  json.set("name", "jhone").set("age", 42).at("childName");
  json.add("fifi", "riri", "loulou").up().at("car");
  json.set("color", "red").set("brand", "Mazda");
  System.out.println(json);
```
output:
```
 {"name":"jhone","age":42,"childName":["fifi","riri","loulou"],"car":{"color":"red","brand":"Mazda"}}
```
  * Fix bug in compressor
  * Speed improvement
  * Add JSON-simple to json-smart migration tester helper. by adding -DJSON\_SMART\_SIMPLE to your java binary, json-smart will process json data more like json-simple.

V 1.0.8
  * fix regression: support for unused comma in PERMISIVE\_MODE loose
  * fix regression: support empty object in STRICT\_MODE

V 1.0.7 (deprecate)
  * Hide some IOException
  * Improve RFC4627 compatibility.
  * Using JSONParserBase.MODE\_JSON\_SIMPLE mode Json-smart will return every non-bigNumber as Long, like json-simple. ie:
`new JSONParser(JSONParser.MODE_JSON_SIMPLE).parse(text)`
  * add ACCEPT\_LEADING\_ZERO Parssing option
  * reject json containing excessive comma

V 1.0.6.3
  * Json-smart is now available on the maven central repository.
  * Reduce stack memory usage
  * Improve passer speed
  * Add missing direct primitive parssing support
  * Merge parsers implementation code.
  * Reduce source code size.

V 1.0.6.2
  * Big Speed improvement of JSONValue.compress and JSONValue.uncompress
  * Add SAX parssing features
  * Add JSONValue.SAXParse(Reader input, ContentHandler handler)
  * Add JSONValue.SAXParse(String input, ContentHandler handler)
  * Fix error parssing {{}} String.
  * Reduce source code size.

V 1.0.6.1
  * JsonValue.isValidJson(json)
  * JsonValue.isValidJsonStrict(json)
  * Fix bug in space trimming
  * Small improvements in big int parssing.
  * JSONValue.compress(json) return a compressed json string
  * JSONValue.uncompress(json) return a RFC4627 json string
  * JSONValue.parseKeepingOrder(json)

V 1.0.6
  * Support Strict parssing RFC4627 Mode

V 1.0.5
  * Improve serialisation speed of large object
  * Fix a parssing bug, in float in streaming mode.
  * Add json-smart-mini for a simplest usage.

V 1.0.4-2
  * first public version