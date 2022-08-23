# fauth

<div align="center">
  <a href="https://www.oracle.com/java/">
    <img
      src="https://img.shields.io/badge/Written%20in-java-%23EF4041?style=for-the-badge"
      height="30"
    />
  </a>
  <a href="https://jitpack.io/#Clientastisch/fauth/master-SNAPSHOT">
    <img
      src="https://img.shields.io/badge/jitpack-master-%2321f21?style=for-the-badge"
      height="30"
    />
  </a>
  <a href="https://clientastisch.github.io/fauth/docs" target="_blank">
    <img
      src="https://img.shields.io/badge/javadoc-reference-5272B4.svg?style=for-the-badge"
      height="30"
    />
  </a>
</div>

<br />

<p align="center">
  <a href="#-introduction">Introduction</a> •
  <a href="#-getting-started">Getting started</a> •
  <a href="https://github.com/Clientastisch/fauth/issues">Troubleshooting</a>
</p>

## 📚 Introduction

fauth is a rolling keys generator which is commonly used for 2-factor authentication these days. The number sequences depend on a seed. The length of the sequence can also be specified.

### Motivation

I could lie and tell yout that this project has much use, but there are already far better and secure authenticators using secure algorithms. However, writing it yourself will enhance your understanding of the functionality. Moreover, you have all the control you want.

*Should you use it?* **Absolutely not!**

## 📖 Getting started

There is really not much to know about fauth. This project consists of only one class called `Authenticator`

```java
Authenticator authenticator = new Authenticator(
    System.currentTimeMillis(), // seed
    6                           // digits
);
```

After instantiating the authenticator, you have to call only one method called `generate`

```java
authenticator.generate(index); // index > 0
```

You can specify which sequence should be calculated. However, keep in mind that index should be bigger that 0 and thus positiv. This index should be calculated by the elippsed time since creation in order to have a rolling key algorithm.