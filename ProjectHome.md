## NEWS ##

Json smart is now hosted on github:

https://github.com/netplex/json-smart-v1

https://github.com/netplex/json-smart-v2


this page moved to

http://netplex.github.io/json-smart/


## Overview ##
Json-smart is a performance focused, JSON processor lib.
[Getting Start guide](GettingStart.md)

Json-smart interfaces are almost the same that json-simple, So migration from json-simple to json-smart, is very easy. [Migration Guide Available](http://code.google.com/p/json-smart/wiki/MigratingFromJsonSimpleToJsonSmart)

Json-smart is one of the **fastest** java base Json API.
See bench for more details. [Benchmarks](http://code.google.com/p/json-smart/wiki/Benchmark)

## json-smart overview ##
  * Fast _(it's at least **twice** faster)_ than the original json-simple [See Benchmarks](http://code.google.com/p/json-smart/wiki/Benchmark)
  * Use java Generics.
  * Parser permissibility is highly customisable from permissive to strict.
  * The **json generator** can generate **compressed** json data.
  * Interfaces are the same, so json-simple projects can be easily port to json-smart.
  * It uses **maven** build.
  * Is available on maven central
```
 <dependency>
  <groupId>net.minidev</groupId>
  <artifactId>json-smart</artifactId>
  <version>1.3</version>
 </dependency>
```

## Lasts changes ##
[Changelog](http://code.google.com/p/json-smart/wiki/Changelog)

current stable version: 1.3.1 / 2.1.0

current V2 version is available on Maven central:
```
 <dependency>
  <groupId>net.minidev</groupId>
  <artifactId>json-smart</artifactId>
  <version>2.0</version>
 </dependency>
```

| json-smart Version | **1.X** | **2.X** |
|:-------------------|:--------|:--------|
| interface          | extanded version of **json-simple** | new interface |
| serialization      | map, array, beans | map, array, beans |
| de-serialization   | map, array | map, array, **beans** |
| speed              |         | same as V 1.1, and faster on beans |
| usage              | can easily replace json-simple | usage of POJO |

## Study case ##

I use this parser to process small json data stored in MySQL String records, limited to 255 chars.

In my case, every record contains simple JSon Object like:
```
{"first":"john", "last":"Doe"} # 30 chars long
```

I have rewritten the generator and the parser to also support smaller json data:

```
{first:john,last:Doe} # 21 chars long
```

So, I was able to reduce the json data size by **30%**

Generation of simplified json string is only supported by the full json-smart version.


## Features ##
  * **No** external dependance
  * Very small **17 KB** for light version **30 KB** for full version
  * Posibility to read every json data [FeaturesTests](http://code.google.com/p/json-smart/wiki/FeaturesTests)
  * Realy fast [Benchmark](http://code.google.com/p/json-smart/wiki/Benchmark)
  * Required JDK 1.5

## [References](References.md) ##

## Samples ##
  * [Encoding](http://code.google.com/p/json-smart/wiki/EncodingSamples)
  * [Merge](http://code.google.com/p/json-smart/wiki/MergeSample)