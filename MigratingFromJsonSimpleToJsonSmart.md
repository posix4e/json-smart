# Introduction #

JSON Smart is a fork of the popular JSON Simple library. It retains its simple data mapping model while offering top parse performance and configuration.

This quick guide will demonstrate how easy it is to switch your existing code from the JSON Simple library to JSON Smart (version 1.0.9 and compatible).


# Migration Steps #

## 1. Package download ##

Remove your current JSON Simple library JAR. Then download the JSON Smart JAR and include it in your CLASSPATH.


## 2. Change package names ##

JSON Smart retains the naming of the main JSON related classes and methods, these are just namespaced into new package names.

| **JSON Simple**          | **JSON Smart**          |
|:-------------------------|:------------------------|
| org.json.simple          | net.minidev.json        |
| org.json.simple.parser   | net.minidev.json.parser |

So change the existing import statements from

```
import org.json.simple.*;
import org.json.simple.parser.*;
```

to

```
import net.minidev.json.*;
import net.minidev.json.parser.*;
```

If you're using a UNIX shell and the [sed](http://www.grymoire.com/Unix/Sed.html) tool you can quickly change the imports in a single sweep like that:

```
sed -i 's/org.json.simple/net.minidev.json/g' path/to/your/java/files/*.java
```

## 3. JSON parser configuration ##

The new JSON Smart parser is highly configurable. It allows for setting the level of parser strictness and for controlling the representation of JSON numbers in Java.

JSON Simple parses integer numbers as _java.lang.Long_ instances and fractions as _java.lang.Double_. To retain this behaviour in JSON Smart make sure each parser instance is constructed with the _JSONSmart.MODE\_JSON\_SIMPLE_ argument, e.g.

```
JSONParser parser = new JSONParser(JSONParser.MODE_JSON_SIMPLE);
```

The _sed_ utility may help here too:

```
sed -i s'/new JSONParser()/new JSONParser(JSONParser.MODE_JSON_SIMPLE)/g' /path/to/your/java/files/*.java
```


## 4. Fixing typo in ContainerFactory interface implementations ##

JSON Smart also fixes an ugly typo in the original _ContainerFactory_ interface of JSON Simple.

So the method name (notice the mistyped "create")

```
public List creatArrayContainer()
```

is corrected to

```
public List createArrayContainer()
```

If you're providing your own container implementation (e.g. to enable ordered parsing of JSON object members), make sure you also correct your method names.


Finally, save your changes, recompile and you're set!