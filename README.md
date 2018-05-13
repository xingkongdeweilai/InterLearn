# InterLearn
需要改进或添加的功能
1、表单后台验证
2、用户注册验证用户名、电话号码、以及邮箱是否已被注册，以及必填项是否填写完，在页面提示哪些是必填项
3、系统增加操作日志
4、注册使用邮箱验证
5、解决单词在表格中的换行问题
6、更新单词成功返回框title中文问题
7、表格样式
8、个人信息

遇到的问题以及解决方式
1、验证登录用的ajax导致后台处理数据后无法跳转页面，所以放弃了ajax请求，改用$("form").submit();
2、jpa建表失败，原因：字段名与数据库关键词冲突，解决：修改实体字段名
3、js获取后台model的值：[[${}]],<script type="text/javascript" th:inline="javascript"></script>
4、<a href="javascript:verifyLogin();"></a>
5、iframe与父级框架的数据沟通：在control层定义一个局部变量json，子框架的请求调用此json的数据
6、使用layui表格不能正确加载后台传来的数据，原因table.render里面把默认成功返回值修改response:{statusCode:json code}
7、jquery与layui冲突，解决：换了一个jquery版本，1.9.1
