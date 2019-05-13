# workable-converter
基于libreoffice实现的文档转换工具模块

## 技术栈

* LibreOffice:v6.2.3

* jodconverter:4.2.2

* Apache_OpenOffice:4.1.6

* cglib动态代理 + 懒汉工厂模式 + 策略模式 + 装饰器模式

* qtools-property管理配置文件(application.yml、bootstrap.yml、workable-converter.yml三种命名的配置文件任意包含一种即可)

## 功能

* doc、docx、html转PDF

* doc、docx转每一页的png

* pdf转每一页的png

* 多个png按照顺序合并为一个PDF文件

## 使用

* 

## 注意事项

* 经过测试，LibreOffice在最新版本的Mac OS上存在异常奔溃问题，并且OfficeManager无法与其建立连接，所以请在windows或者Linux系统上使用LibreOffice，在Mac系统上请使用OpenOffice 

## 参考链接

* https://www.libreoffice.org/download/download/?type=rpm-x86_64&version=6.2.3&lang=zh-CN

* https://api.libreoffice.org/




