[![](https://jitpack.io/v/justADeni/HexColorLib.svg)](https://jitpack.io/#justADeni/HexColorLib)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/d2333897b7144333b85ed5275816d962)](https://www.codacy.com/gh/justADeni/HexColorLib/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=justADeni/HexColorLib&amp;utm_campaign=Badge_Grade)
# HexColorLib
Simple library for using hex color codes in spigot strings
## Examples
`"#B511BAThis is example monocolor message"`

![monocolor](https://github.com/justADeni/HexColorLib/blob/master/img/monocolor.png?raw=true)

`"#B511BAThis is example multi-color message#11BAB4"`

![monocolor](https://github.com/justADeni/HexColorLib/blob/master/img/multicolor.png?raw=true)
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
## Implementation in Java
```java
private static HexColorLib hex = HexColorLib.INSTANCE;
String example = "#B511BAExample";
hex.color(example)
```
- then store it or sendMessage to recipient
## To add as dependency
- shade this into your plugin or copy-paste this whole class into your project
- if you include it with maven, replace Tag with version at the top
### Maven
```xml
<repository>
	<id>jitpack.io</id>
	<url>https://jitpack.io</url>
</repository>
```
```xml
<dependency>
	<groupId>com.github.justADeni</groupId>
	<artifactId>HexColorLib</artifactId>
	<version>Tag</version>
        <scope>compile</scope>
</dependency>
```

### Gradle
```kotlin
repositories {
	maven { url 'https://jitpack.io' }
}
```
```kotlin
dependencies {
	compile 'com.github.justADeni:HexColorLib:Tag'
}
```
## Dependencies

If you aren't using Kotlin, you need to add Kotlin runtime for this to work. For example, [kLib](https://github.com/zorbeytorunoglu/kLib) or [kotlin-stdlib](https://www.spigotmc.org/resources/kotlin-stdlib.80808/) 
