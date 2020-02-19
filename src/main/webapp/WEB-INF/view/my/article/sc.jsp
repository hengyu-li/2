<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resource/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
	<a href="my/article/toadd">添加</a>
	<table>
		<tr>
			<th>标题</th>
		</tr>
	<c:forEach items="${info.list}" var="i">
		<tr>
			<td>${i.title}</td>
			<td>
				<input type="button" value="删除" onclick="del(${i.id})">
			</td>
		</tr>
	</c:forEach>
	</table>	
<jsp:include page="/WEB-INF/view/common/pages.jsp" />
</div>
<script type="text/javascript">
	function goPage(page) {
		//location.href="/user/selects?page="+page
		var url = "/my/article/sc?page=" + page
		$("#center").load(url); //

	}
</script>
<script type="text/javascript">
	function del(id){
	if(confirm("你确定要删除吗")){
		alert(id)
		$.post("my/article/del",{id:id},function(obj){
			if(obj){
				alert("成功");
				location="list"
			}else{
				alert("失败");
			}
		})
	}
}
</script>
</body>
</html>