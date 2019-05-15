# workable-converter

基于libreoffice实现的文档转换项目，无框架依赖，即插即用

## 技术栈

* LibreOffice:v6.2.3

* jodconverter:4.2.2

* cglib动态代理 + 懒汉工厂模式 + 策略模式 + 装饰器模式

* qtools-property管理配置文件(application.yml、bootstrap.yml、workable-converter.yml三种命名的配置文件任意包含一种即可)

## 功能

* 支持doc、docx、html、ppt、png、pdf等等类型的文件**互相转换**

* 支持按照文件路径、字节输入输出流、Base64等不同姿势转换

* 不依赖第三方框架，即插即用，支持application.yml、bootstrap.yml、workable-converter.yml三种配置（自己项目中具体配置一个即可）

## 使用

 

## 待办事项

* 文档跟图片之间的转换还不够智能，比如：一份20多页的doc文档转图片，只支持单页转换，不能批量按页转换，后续迭代改进

* 已经测试通过的有doc、docx、html 按照不同姿势转PDF，其他类型的并没有编写测试单元，后续改进

* 目前只支持yml配置，后续添加其他类型的配置支持（xml、properties等） 

## 参考链接

* https://www.libreoffice.org/download/download/?type=rpm-x86_64&version=6.2.3&lang=zh-CN

* https://api.libreoffice.org/

* https://github.com/sbraconnier/jodconverter/


