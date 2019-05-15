# workable-converter

基于libreoffice实现的文档转换项目，无框架依赖，即插即用

## 1. 技术栈

* LibreOffice:v6.2.3

* jodconverter:4.2.2

* cglib动态代理 + 懒汉工厂模式 + 策略模式 + 装饰器模式

* qtools-property管理配置文件(application.yml、bootstrap.yml、workable-converter.yml三种命名的配置文件任意包含一种即可)

## 2. 功能

* 支持doc、docx、html、ppt、png、pdf等等类型的文件**互相转换**

* 支持按照文件路径、字节输入输出流、Base64等不同姿势转换

* 不依赖第三方框架，即插即用，支持application.yml、bootstrap.yml、workable-converter.yml三种配置（自己项目中具体配置一个即可）

## 3. 使用

### 3.1 安装配置LibreOffice6.2.3

CentOS请直接参考这篇文章：[CentOS7安装LibreOffice6.2.3](http://www.liumapp.com/articles/2019/04/25/1556178926172.html)

windows跟Mac同样可以在上述文章中拿到下载链接

安装完成后，请记住您的LibreOffice的Home目录，后面需要用到

默认目录：

* CentOS: /opt/libreoffice6.2/

* Mac: /Applications/LibreOffice.app/Contents/

* Windows: C:\\Program Files\\LibreOffice\\

### 3.2 获取依赖

* Maven

```` mxml
<dependency>
  <groupId>com.liumapp.workable.converter</groupId>
  <artifactId>workable-converter</artifactId>
  <version>v1.0.0</version>
</dependency>
````
* Gradle

````yaml
compile group: 'com.liumapp.workable.converter', name: 'workable-converter', version: 'v1.0.0'
````

### 3.3 编辑配置文件

在项目的resources目录下，创建一个yml配置文件，需要确保文件名称为application.yml、bootstrap.yml或workable-converter.yml三种命名任意一个即可

添加以下配置：

````yaml
com:
  liumapp:
    workable-converter:
      libreofficePath: "/Applications/LibreOffice.app/Contents"
````

libreofficePath的值为LibreOffice:6.2.3的安装目录

下表列出了其他支持的配置项

<table>
<tr><th>参数名</th><th>解释</th><th>默认值</th></tr>
<tr><td>1</td><td>2</td><td>3</td></tr>
</table>

### 3.4 命令行使用

### 3.5  

## 4. 待办事项

* 文档跟图片之间的转换还不够智能，比如：一份20多页的doc文档转图片，只支持单页转换，不能批量按页转换，后续迭代改进

* 已经测试通过的有doc、docx、html 按照不同姿势转PDF，其他类型的并没有编写测试单元，后续改进

* 目前只支持yml配置，后续添加其他类型的配置支持（xml、properties等） 

## 5. 参考链接

* https://www.libreoffice.org/download/download/?type=rpm-x86_64&version=6.2.3&lang=zh-CN

* https://api.libreoffice.org/

* https://github.com/sbraconnier/jodconverter/


