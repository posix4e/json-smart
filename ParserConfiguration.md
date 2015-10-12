> # JSON Smart Parser Configuration #


In addition to high-performance the JSON Smart parser offers a rich set of
configuration options for specifying strictness and Java type mapping. These
are passed as one or more constant flags to the _JSONParser_ and
_JSONParserStream_ constructors.



---


## Predefined parser strictness modes ##

The following set of constants controls the strictness of the JSON Smart parser.


### MODE\_RFC4627 ###

Specifies strict parsing according to the JSON standard (RFC 4627).


### MODE\_PERMISSIVE ###

Specifies a "Smart" mode which accepts a wide range of non-standard JSON syntax
and results in faster parsing.

  * Strings may be unenclosed, or enclosed by single quotes (') or double quotes (").
  * JSON object keys may be unenclosed, or enclosed by single quotes (') or double quotes (").
  * Accepts unescaped single quotes (') in strings that are unenclosed or  enclosed by double quotes (").
  * Accepts unescaped double quotes (") in strings that are unenclosed or enclosed by single quotes (').
  * ...

### MODE\_JSON\_SIMPLE ###
Equivalent to: ACCEPT\_USELESS\_COMMA | USE\_HI\_PRECISION\_FLOAT


---


> ## Custom parser strictness modes ##

The JSON Smart parser can also be configured to mix several options at once:

```
new JSONParser(JSONParser.ACCEPT_SIMPLE_QUOTE | JSONParser.ACCEPT_LEADING_ZERO);
```


### ACCEPT\_SIMPLE\_QUOTE ###

**If enabled:**
Accepts strings enclosed by single quotes (') in addition to strings enclosed by
double quotes (").

**If disabled:**
Throws _ParseException_ on a string enclosed by single quotes if ACCEPT\_NON\_QUOTE is disabled, returns a String enclosed by single quotes if ACCEPT\_NON\_QUOTE is enabled.

### ACCEPT\_NON\_QUOTE ###

**If enabled:**
Accepts unenclosed strings in addition to strings enclosed by double quotes ("). and single quotes (') if ACCEPT\_SIMPLE\_QUOTE option is enabled.

**If disabled:**
Throws _ParseException_ on a string that isn't enclosed.

### IGNORE\_CONTROL\_CHAR ###
**If enabled:**
Ignores control characters in parsed text.

**If disabled:**
Throws _ParseException_ on an unexpected control character.


### ACCEPT\_NAN ###

**If enabled:**
Parses _NaN_ literals as _java.lang.Float.NaN_

**If disabled:**
Returns _NaN_ or throws _ParseException_ if ACCEPT\_NON\_QUOTE is enabled.


### ACCEPT\_LEADING\_ZERO ###

**If enabled:**
Accepts leading zeros in parsed numbers.

**If disabled:**
Throws _ParseException_ on redundant leading zeros in numbers.


### ACCEPT\_USELESS\_COMMA ###

**If enabled:**
Accepts redundant commas in parsed JSON arrays and objects.

**If disabled:**
Throws _ParseException_ on redundant commas.


---


## Java type mapping ##

The JSON Smart library applies the following mapping between JSON and Java entities:

| **JSON**     | **Java**                                                 |
|:-------------|:---------------------------------------------------------|
| true|false   | java.lang.Boolean                                        |
| number       | java.lang.Number                                         |
| string       | java.lang.String                                         |
| array        | net.minidev.json.JSONArray (implements java.util.List)   |
| object       | net.minidev.json.JSONObject (implements java.util.Map)   |
| null         | null                                                     |


JSON Smart can parse JSON numbers into the following _java.lang.Number_
instances:

  * For integer amounts: _java.lang.Integer_, _java.lang.Long_ or _java.math.BigInteger_
  * For fraction amounts: _java.lang.Float_, _java.lang.Double or_java.math.BigDecimal


The number parsing policy in _MODE\_RFC4627_ and _MODE\_PERMISSIVE_:

For integer amounts:
  * If the integer fits within the _int_ datatype it is returned as  _java.lang.Integer_
  * If the integer exceeds the _int_ datatype it is returned as _java.lang.Long_
  * If the integer exceeds the _long\_datatype it is returned as_java.math.BigInteger

For fraction amounts:
  * If the fraction amount fits within the _double_ datatype it is returned as _java.lang.Double_
  * If the fraction amount exceeds the _double_ datatype it is returned as _java.math.BigDecimal_


The following constant flags modify the number parsing behaviour:


### USE\_INTEGER\_STORAGE ###

**If enabled:**
Uses _java.lang.Integer_ for integer amounts, else _java.lang.Long_ or
_java.math.BigInteger_ for larger values.

**If Disabled:**
Uses _java.lang.Long_ for integer amounts, or _java.math.BigInteger_ for larger values.


### USE\_HI\_PRECISION\_FLOAT ###
**If Enabled:**
Uses _java.lang.Double_ for fraction amounts, or _java.math.BigDecimal_ for
larger or higher precision values.

**If Diabled:**
Uses _java.lang.Float_ for all fraction amounts.


### ACCEPT\_TAILLING\_DATA ###
**If Enabled:**
Uses Json-smart allow junk data at the end of the inputs.

**If Diabled:**
Uses Json-smart throws ParseException if non space data is present after the end of inputs.



---


## JSON Simple Compatibility ##
see [Migrating from JSON Simple To JSON Smart](MigratingFromJsonSimpleToJsonSmart.md)

JSON Smart is a fork of JSON Simple and provides parsing mode _MODE\_JSON\_SIMPLE_
for ensuring backwards compatibility:
  * Accepts redundant commas in parsed JSON arrays and objects.
  * Uses _java.lang.Long_ as preferred class for integer amounts, else _java.math.BigInteger_ on overflow.
  * Uses _java.lang.Double_ as preferred class for fraction amounts, else _java.math.BigDecimal_ on overflow.