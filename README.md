[![](https://jitpack.io/v/justADeni/HexColorLib.svg)](https://jitpack.io/#justADeni/HexColorLib)
# HexColorLib
Simple library for using hex color codes in spigot strings

## Examples

`"#B511BAThis is example monocolor message"`

![monocolor](https://github.com/justADeni/HexColorLib/blob/master/src/resources/monocolor.png?raw=true)

`"#B511BAThis is example multi-color message#11BAB4"`

![monocolor](https://github.com/justADeni/HexColorLib/blob/master/src/resources/multicolor.png?raw=true)

## Usage
- The string has to either contain
	- one color code before message e.g. `#da0808` + msg
	- or two color codes, one before and one after message e.g. `#08bada` + msg + `#1b9135`
	- or old-school & characters with appropriate color codes anywhere in message


## Implementation in Kotlin

```kotlin
val example = "#B511BAExample"
example.color()
```
- then sendMessage it to recipient
## Implementation in Java

```java
private static HexColorLib hex = HexColorLib.INSTANCE;
String example = "#B511BAExample";
hex.color(example)
```
- then sendMessage it to recipient
## To add as dependency

### Maven
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

### Gradle
```gradle
repositories {
	maven { url 'https://jitpack.io' }
}

dependencies {
	implementation 'com.github.justADeni:HexColorLib:Tag'
}
```
