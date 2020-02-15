## 晓默的博客 - 文件服务器 ##
> [传送门](https://www.moinros.com)
* #### 2020/2/13 ####
> + 项目创建 : 防止源码丢失，在Github做一个备份
* #### 2020/2/14 ####
> + 文件上传完成！
* #### 2020/2/15 ####
> + 新增日志文件,方便调试
------------
#### 调用接口 - API ####
| METHOD |  URL  |  PARAM  |  NOTE  |
|:------:|:-----:|:-------:|:------:|
| POST | /server/file/upload/binary/face | 文件流 | 头像图片上传接口 |
| POST | /server/file/upload/binary | 文件流 | 通用上传文件接口 |
| GET  | /server/file/find/list/face | 无参 | 查询头像图片文件接口 |
| GET  | /server/file/find/list | type,postfix,fastCode| 指定条件查询文件数据 |
| GET  | /server/file/find/list/page | page,size| 分页查询文件数据 |
 * 参数解释
> | NAME | NOTE |
> |:----:|:----:|
> | type | 文件类型(image/jpeg) |
> | postfix | 文件后缀名 (jpg,png,mp3,txt) |
> | fastCode | 文件检索码 |
> | page | 分页页码数 |
> | size | 分页时每页显示的条数 |
----
