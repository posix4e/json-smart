Json-Smart has been designed to deliver impressive performance.
For best results, I recommend using it as follows:

# json-simple migration best practice #
allwai

# Using Json as internal storage format #

if you are using json as internal data format, compresse it before you store it, compressed json will stil be humain-redable but will take less space and will parsed and serialized faster.

## Output Compressed json ##
To export a compressed JSON:
```
Object value;
JSONValue.toJSONString(value, JSONStyle.MAX_COMPRESS);
```
Or from a string json
```
String json;
JSONValue.compress(json);
```

## Output non compressed RFC4627 json ##
Data out of the system must be encoded in json RFC4627 to avoid compatibility issues.
To export a JSON has the standard RFC4627:
```
Object value;
JSONValue.toJSONString(value, JSONStyle.NO_COMPRESS)
```
Or from a string json
```
String json;
JSONValue.uncompress(json)
```
