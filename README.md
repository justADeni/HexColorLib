[![](https://jitpack.io/v/justADeni/HexColorLib.svg)](https://jitpack.io/#justADeni/HexColorLib)
# HexColorLib
Simple library for using hex color codes in spigot messages

## Examples

code: `#B511BAThis is example monocolor message`
![monocolor](https://github.com/justADeni/HexColorLib/blob/master/src/resources/monocolor.png?raw=true)

code: `#B511BAThis is example multi-color message#11BAB4`
![monocolor](https://github.com/justADeni/HexColorLib/blob/master/src/resources/multicolor.png?raw=true)

## Usage
- The string has to either contain
	- one color code before message e.g. `#da0808` + msg
	- two color codes, one before and one after message e.g. `#08bada` + msg + `#1b9135`
	- or old-school & characters with appropriate color codes anywhere in message
	
- hex codes are case insensitive	
- on any such String, simply .color()

## To add as dependency
- add these to your pom.xml:

```xml
<repository>
	<id>jitpack.io</id>
	<url>https://jitpack.io</url>
</repository>
  
<dependency>
	<groupId>com.github.justADeni</groupId>
	<artifactId>HexColorLib</artifactId>
	<version>Tag</version>
</dependency>
```
