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
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script><script>
	$(function() {
		$("#join-form").submit(function() {
			//회원 가입 폼 유효성 검증(validation)

			//1
			var name = $("#name").val();
			if (name == "") {
				alert("이름을 입력해 주세요");
				$("#name").focus();
				return false;
			}

			//2이메일 체크
			var id = $("#id").val();
			if (id == "") {
				alert("id이 비어있습니다.");
				$("#id").focus();
				return false;
			}

			var isVisible = $("#img-checkid").is(":visible");
			if (isVisible == false) {
				alert("id 중복 체크를 해주세요.");
				return false;
			}

			//3 비밀번호
			var password = $("input[type='password']").val();
			if (password == "") {
				alert("비밀번호가 비어있습니다.");
				$("input[type='password']").focus();

				return false;
			}

			//4
			var isChecked = $("#agree-prov").is(":checked");
			if (isChecked == false) {
				alert("약관동의를 해주세요.");
				return false;
			}

		});
		$("input[type='button']").click(function() {

			var id = $("#blog-id").val();
			if (id == "") {
				$("#blog-id").focus();
				return;
			}
			//ajax 통신
			$.ajax({
				url : "/jblog/user/checkid?id=" + id,
				type : "get",
				dataType : "json",
				data : "",
				//  contentType: "application/json",
				success : function(response) {
					if (response.result == "fail") {
						console.log("error:" + response.message);
						return;
					}
					//통신성공
					console.log(response);

					if (response.data == "exist") {
						$("#dialogMessage").dialog();

						return;
					}
					//존재하지 않는 경우(사용가능)
					$("#imgidChecked").show();
					$("input[type='button']").hide();
				},
				error : function(jqXHR, status, error) {
					console.error(status + " : " + error);
				}

			});

		});
	});
</script>
</head>
<body>
	<div class="center-content">
		<h1 class="logo">JBlog</h1>
		<ul class="menu">
			<c:import url="/WEB-INF/views/include/navigation.jsp" />
		</ul>
		<form class="join-form" id="join-form" method="post"
			action="${pageContext.request.contextPath}/user/join">
			<label class="block-label" for="name">이름</label> <input id="name"
				name="name" type="text" value=""> <label class="block-label"
				for="blog-id">아이디</label> <input id="blog-id" name="id" type="text">
			<input id="btn-checkid" type="button" value="id 중복체크"> <img
				id="imgidChecked" style="display: none;"
				src="${pageContext.request.contextPath}/assets/images/check.png">

			<label class="block-label" for="password">패스워드</label> <input
				id="password" name="password" type="password" />

			<fieldset>
				<legend>약관동의</legend>
				<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
				<label class="l-float">서비스 약관에 동의합니다.</label>
			</fieldset>

			<input type="submit" value="가입하기">

		</form>
	</div>
	<div id="dialogMessage" title="Basic dialog" style="display: none">
		<p>존재하는 이메일입니다.</p>
	</div>
</body>
</html>
