<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
			<c:import url="/WEB-INF/views/include/header.jsp" />
		<div id="wrapper">
			<div id="content">

				<div class="blog-content">
					<h4>${viewVo.title }</h4>
					<p>${viewVo.content }
					<p>
				</div>
				<ul class="blog-list">
					<c:forEach items="${writeList }" var="vo2" varStatus="status">
						<li><a
							href="${pageContext.request.contextPath }/blog/${authUser.id}?category_no=${vo2.categoryNo}&no=${vo2.no}">
								${vo2.title }</a> <span>${vo2.regDate }</span></li>
					</c:forEach>
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img src="${pageContext.request.contextPath}/${vo.saveFile}">
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<ul>
				<c:forEach items="${list }" var="vo" varStatus="status">
					<li><a
						href="${pageContext.request.contextPath }/blog/${authUser.id}?category_no=${vo.no}">${vo.title }</a></li>
				</c:forEach>
			</ul>
		</div>

		<div id="footer">
			<p>
				<strong>Spring 이야기</strong> is powered by JBlog (c)2016
			</p>
		</div>
	</div>
	<div id="dialogMessage" title="Basic dialog" style="display: none">
		<p>존재하는 이메일입니다.</p>
	</div>
</body>
</html>