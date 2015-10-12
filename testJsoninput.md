# Validating JSON input #

You can use the following methods for validating JSON input:
  * _JSONValue.isValidJson(String)_ To validate a string that conforms to the (non-strict) JSON Smart mode.
  * _JSONValue.isValidStrictJson(String)_ To validate a string of JSON for strict conformance to RFC4627.

Note that these dedicated methods provide much faster JSON checking than using the ordinary _parse()_ methods.

@Since 1.0.6.1

```
String s = "{intValue:123}";
if (JSONValue.isValidJson(s))
  System.out.println(s + " validates as Smart JSON");

if (JSONValue.isValidJsonStrict(s))
  System.out.println(s + " validates as strict JSON");
else
  System.out.println(s + " does not validate as strict JSON");

```

Will display :
```
{intValue:123} validates as Smart JSON
{intValue:123} does not validate as strict JSON
```