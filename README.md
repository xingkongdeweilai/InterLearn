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
9、添加单词验证单词有效性
10、将iframe替代掉
11、管理员的单词回收站
12、我的单词分析图表
13、记单词排行榜
14、密码加密存储

遇到的问题以及解决方式
1、验证登录用的ajax导致后台处理数据后无法跳转页面，所以放弃了ajax请求，改用$("form").submit();
2、jpa建表失败，原因：字段名与数据库关键词冲突，解决：修改实体字段名
3、js获取后台model的值：[[${}]],<script type="text/javascript" th:inline="javascript"></script>
4、<a href="javascript:verifyLogin();"></a>
5、iframe与父级框架的数据沟通：在control层定义一个局部变量json，子框架的请求调用此json的数据
6、使用layui表格不能正确加载后台传来的数据，原因table.render里面把默认成功返回值修改response:{statusCode:json code}
7、jquery与layui冲突，解决：换了一个jquery版本，1.9.1
8、wordList跳转到wordDetail传参问题，向controller层传值时用?的形式
9、在单词详情页面由于例句有多条，jsonArray设置三条，没有的用空字符串表示
10、分页，layui数据表格分页都是已经封装好的，233
11、代替iframe，$.get('a.html',function(data){$('#body').html(data)});a.html中写具体网页以及JavaScript。

UserAndWord表
字段：user_id,word_id,relation(关系程度0-3)
