# Table
android 表单详情 封装实践 架构图如下
![image](https://github.com/Papeone/Table/raw/master/architecture/ArchitectureDesc.jpg)

## Activity：

### 1.Activity作为View层 只负责UI的展示，toolbar、recyclerView、multiTypeAdapter、bottomView四个常用部分组成

### 2.multiTypeAdapter是封装好的框架，是个自定义的Adatper，该框架旨在项目中，免去写Adapter的麻烦。支持自动排序（默认正序），拖拽，左右滑动删除等功能，还有加载更多，空布局展示，头尾布局等

## Presenter：

### 1.Presenter层 负责页面数据的转换，从Tables里拿到配置好的列表数据，通过ItemTransformationFactory将数据转化为页面需要ViewData，添加到multiTypeAdapter中。

### 2.ItemValidate 负责认证每一项数据的合法性

### 3.ItemTableType 负责不同的Item项，如： 只显示文本的样式，显示文本加输入框的的样式，支持拓展新样式

### 4.ItemTableBean 负责一项Item的基本属性，key、keyName、itemUUID、ItemTableType等属性

### 5.ItemTableList 最终由ItemTransformationFactory转换成multiTypeAdapter需要的页面数据类型。

### 6.需要展示默认信息的页面：需要一层Map映射，Map的key就对应ItemTableBean中的key

### 7.在Presenter中创建一个新的map，传入到ItemTransformationFactory的方法中可以自动将EditText，Select的数据自动映射到这个map中，在网络提交的时候直接作为参数即可。
