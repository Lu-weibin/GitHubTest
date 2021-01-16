# 生成PDF



## PDF 制作模板

1. 先在word里面制作模板
2. 导出为PDF
3. 在Adobe Acrobat DC软件中配置数据源
   + 点击页面的准备表单，录入字段信息

## 代码编写

```java
<!-- PDF导出-->
<!-- https://mvnrepository.com/artifact/com.itextpdf/itextpdf -->
<dependency>
  <groupId>com.itextpdf</groupId>
  <artifactId>itextpdf</artifactId>
  <version>5.5.13</version>
</dependency>
```

详见代码