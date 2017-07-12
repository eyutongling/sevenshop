<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>异步验证用户名</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  </head>
  
  <body>
  <table>
  <tr>
  <td>用户名：</td>
    <td><input type="text" name="username" id="name" onblur="change()"/></td>
    <td><span style="display: none;color: red" id="span"></span></td>
  </tr>
    <tr>
    <td>密码</td>
    <td><input type="password" name="pwd" id="password" /></td>
    </tr>
        <tr>
   
    <td><input type="button" value="提交" onclick="change()"></td>
        </tr>
  
  </table>


  </body>
  <script type="text/javascript">
  //使用异步刷新技术实现验证用户名
  
  //声明全局对象
  var xmlhttp;
  //第一步：创建ck对象
  function ck(){
      if(window.XMLHttpRequest){
          xmlhttp=new XMLHttpRequest;
      }else if(window.ActiveObject){
          xmlhttp=new ActiveObject("Microsoft.XMLHTTP")
      }
      
  }
  
  //第二步：响应鼠标事件
  function change(){
      //获取用户名
      var username=document.getElementById("name");
      var password = document.getElementById("password");

      if(!username.value){
          alert("用户名不能为空");
      }else if(!password.value){
              alert("密码不能为空！！！")
              
              }else{
               
    
          //请求异步刷新;以请求地址作为参数传递
          doAjax("select/doselect?username="+username.value);
      }
  }
  //第三步：获取URL
  function doAjax(url){
      //初始化ck;
          ck();
          //判断对象是否初始化成功
          if(xmlhttp!=null){
              //如果不为空，则说明初始化成功
              //开始请求服务器
              xmlhttp.open("post",url,true);//初始化请求参数
              xmlhttp.onreadystatechange=ok;//指定回调函数
              xmlhttp.send(null);
              
          }else{
              alert("xmlhttp初始化失败！！！");
          }
    }
  //指定回调函数
  function ok(){
      //判断响应状态
      if(xmlhttp.readyState==4){
          if(xmlhttp.status==200){
              chuli(xmlhttp.responseText);
          }
      }
      
  }
  function chuli(status){
      var span=document.getElementById("span");
      span.innerHTML=status;
      span.style.display="block";
      
  }
  
  
  </script>
</html>
