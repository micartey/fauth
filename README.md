# fauth

<div align="center">
  <a href="https://www.oracle.com/java/">
    <img
      src="https://img.shields.io/badge/Written%20in-java-%23EF4041?style=for-the-badge"
      height="30"
    />
  </a>
  <a href="https://jitpack.io/#Clientastisch/jairo/main-SNAPSHOT">
    <img
      src="https://img.shields.io/badge/jitpack-main-%2321f21?style=for-the-badge"
      height="30"
    />
  </a>
  <a href="https://clientastisch.github.io/jairo/docs" target="_blank">
    <img
      src="https://img.shields.io/badge/javadoc-reference-5272B4.svg?style=for-the-badge"
      height="30"
    />
  </a>
</div>

<br />

<p align="center">
  <a href="#-introduction">Introduction</a> |
  <a href="#-build-tools">Maven/Gradle</a> |
  <a href="#-getting-started">Getting started</a>
</p>

## 📚 Introduction

fauth is a rolling keys generator which is commonly used for 2-factor authentication these days. The number sequences depend on a seed. The length of the sequence can also be specified.

### Motivation

I could lie and tell yout that this project has much use, but there are already far better and secure authenticators using secure algorithms. However, writing it yourself will enhance your understanding of the functionality. Moreover, you have all the control you want.

*Should you use it?* **Absolutely not!**

## 🔗 Build Tools

To use fauth as a dependency you might want to use a build tool like maven or gradle. An easy way for each and every project, is to use [jitpack](https://jitpack.io/#Clientastisch/jairo/main-SNAPSHOT) as it makes it easy to implement and use. The following example is for maven specific, as I personally don't use gradle that much.

### Maven

First of all add a new repository to your `pom.xml` file to be able to download the dependecies provided by jitpack.

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Lastly, after adding the repository to all your other repositories, you have to add the following segment to your dependencies.

```xml
<dependency>
    <groupId>com.github.Clientastisch</groupId>
    <artifactId>fauth</artifactId>
    <version>main-SNAPSHOT</version>
</dependency>
```

## 🎈 Getting started

There is really not much to know about fauth. This project consists of only one class called `Authenticator`

```java
Authenticator authenticator = new Authenticator(
    System.currentTimeMillis(), //seed
    6                           //digits
);
```

After instantiating the authenticator, you have to call only one method called `generate`

```java
authenticator.generate(index);
```