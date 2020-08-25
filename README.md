
https://www.jianshu.com/p/903498747f47
https://www.imooc.com/article/291714
https://blog.csdn.net/SmallCatBaby/article/details/89877926

# springboot-netty
用springboot集成了netty server，针对自定义私有协议的拆包组包，并对粘包，半包问题进行处理，实现链接保持并保存协议内容和channel关系，需要心跳来保持链接，超时未收到数据断开链接。
# Dashboard
启动后可以通过http://127.0.0.1:8080/dashboard 链接来查看当前设备接入情况。
# 自定义协议介绍
在自定义协议中，long占4个字节，int占两个字节，可以根据自己的需求来重新定义。
````
4byte(编号)+2byte(CMD命令字)+2byte(data长度)+(data)byte[]
(01 02 03 03) + (01 10) + (01 00) + (01)
其中解析编号，命令字，长度为反序解析
比如：01 02 03 03解析结果为03 03 02 01所对应的long
````
# 测试
并未单独编写客户端，可以通过tcp client工具进行发包测试。
