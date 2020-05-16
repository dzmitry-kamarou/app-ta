# diamond-taf-java
Test automation framework written in Java to test [diamond](https://github.com/dzmitry-kamarou/diamond) application.
## Prerequisites
Require **Java** and **Maven** installed.
## Install
```shell script
$ mvn clean install -DskipTests
```
## Launch
```shell script
$ mvn clean install -Denv=qa -Dscope=regression
```
## Contribute
#### To encrypt some value in property file:
###### Ubuntu
```shell script
$ mvn exec:java -Dexec.mainClass="com.dzmitrykamarou.diamond.taf.util.CryptoUtil" -Dexec.args="<YOUR_VALUE_HERE>"
```
###### Windows
```shell script
$ mvn exec:java -D"exec.mainClass"="com.dzmitrykamarou.diamond.taf.util.CryptoUtil" -D"exec.args"="<YOUR_VALUE_HERE>"
``` 