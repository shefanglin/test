<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#ed{
		display:none;
		background-color:lightblue;
	}
</style>
</head>
<body>
<div class="pd-20">
	<form action="selStuByName.action" method="post">
    <input type="text" class="input-text" style="width:250px" placeholder="输入学生姓名" id="" name="name"><button type="submit" id="" name=""> 搜索</button>
 	</form>
 	<a href="selAll.action">查看全部</a>
  </div>
  <div>
    <a href="student-add.html">添加学生</a></span>
    <span class="r">共有数据：<strong>${page.totalCount }</strong> 条</span>
  </div>
  <table border="1px" cellspacing=0>
    <thead>
      <tr class="text-c">
        <th width="60"><input type="checkbox" id="allChoose" onChange="allChoose()" >全选</th>
        <th width="80">ID</th>
        <th width="100">姓名</th>
        <th width="90">年龄</th>
        <th width="150">成绩</th>
        <th width="100">操作</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="stu" items="${list}">
      	<tr class="text-c">
        <td><input type="checkbox" name="ByChoosed" value="${stu.id }"></td>
        <td>${stu.id }</td>
        <td>${stu.name}</td>
        <td>${stu.age }</td>
        <td>${stu.socre }</td>
        <td>
        <a title="编辑" onclick="edit(this)" href="javaScripte:void(0)" style="text-decoration:none">编辑</a> 
        <a title="删除" onclick="delStu(this)" href="javaScripte:void(0)" style="text-decoration:none">删除</a>
        </td>
      	</tr>
      </c:forEach>
    </tbody>
  </table>
	<input type="checkbox" id="revChoose" onChange="revChoose()" />反选
    <a href="javascript:void(0)" onclick="delMany()" >批量删除</a> <p/>
   <c:choose><c:when test="${page.hasPre}"><a href="selAll.action?pageNow=${page.pageNow - 1}&pageSize=${page.pageSize}" >上一页</a></c:when><c:otherwise><a>首页</a></c:otherwise></c:choose> 
   <c:choose><c:when test="${page.hasNext}"><a href="selAll.action?pageNow=${page.pageNow + 1}&pageSize=${page.pageSize}" >下一页</a></c:when><c:otherwise><a>尾页</a></c:otherwise></c:choose> 
       当前是第<Strong>${page.pageNow }</Strong>页   / 共 <Strong>${page.totalPageCount }</Strong> 页
       每页显示<Strong>${page.pageSize }</Strong>条
   <form action="selAll.action" method="post">  
       每页显示<input type="text" name="pageSize" id="pageSize" />条
      <input type="submit" name="sel" value="查询"/>
   </form>  
<div id="ed">
	<form action="updateStu.action" method="post">
		ID &nbsp&nbsp:<input type="text" name="id" readOnly id="edid" /><p/>
		姓名:<input type="text" name="name" id="edname" /><p/>
		年龄:<input type="text" name="age" id="edage" /><p/>
		成绩:<input type="text" name="socre" id="edscore" /><p/>
		<input type="submit" value="确认修改" />
		<a href="javascript:void(0)" onclick="cancel()">取消</a>
	</form>
</div>
<script type="text/javascript" src="jquery.min.js"></script> 
<script>
	function edit(obj){
		$("#ed").css({"display":"block"})
		$("#edid").val($(obj).parent().parent().children("td").eq(1).text());
		$("#edname").val($(obj).parent().parent().children("td").eq(2).text());
		$("#edage").val($(obj).parent().parent().children("td").eq(3).text());
		$("#edscore").val($(obj).parent().parent().children("td").eq(4).text());
	}
	
	function delStu(obj){
		$.ajax({
			url:"delStu.action",
			data:"id=" + $(obj).parent().parent().children('td').eq(1).text(),
			datatype:"text/html",
			success:function(data){
				if(data){
				alert("删除成功！！！")
				}else{
					alert("删除失败！！！")
				}
				window.location.reload();
			},
			error:function(){
				alert("操作出错！！！")
				window.location.reload();
			}	
		})
	}	
	
	function cancel(){
		$("#ed").css({"display":"none"});
	}
	
	function allChoose(){
		var allByChoosed = document.getElementsByName("ByChoosed");
		var all = document.getElementById("allChoose");
		if(all.checked){
			for(var i = 0;i < allByChoosed.length;i++){
				allByChoosed[i].checked=true;
			}
		}else{
			for(var i = 0;i < allByChoosed.length;i++){
				allByChoosed[i].checked=false;
			}
		}
		
	}
	
	function revChoose(){
		var allByChoosed = document.getElementsByName("ByChoosed");
		var rev = document.getElementById("revChoose");
		for(var i = 0;i < allByChoosed.length;i++){
			if(allByChoosed[i].checked){
				allByChoosed[i].checked = false;
			}else{
				allByChoosed[i].checked = true;
			}
		}
	}
	
	function delMany(){
		var ids = new Array();
		$("input[name='ByChoosed']:checked").each(function(){
			ids.push($(this).val());
		})
		$.ajax({
			url:"delMany.action",
			data:"ids="+ids.toString(),
			success:function(){
				alert("删除成功")
				window.location.reload();
			},
			error:function(){
				alert("删除失败")
				window.location.reload();
			}
		})
	}
</script>
</body>
</html>