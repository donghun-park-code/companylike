<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" rel="stylesheet">
<script src="/webjars/sockjs-client/sockjs.min.js"></script>
<script src="/webjars/stomp-websocket/stomp.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="/boards">로고</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="collapsibleNavbar">
				<ul class="navbar-nav" style="width: 100%">
					<c:choose>
						<c:when test="${empty principal}">
							<li class="nav-item"><a class="nav-link" href="/loginForm">로그인/회원가입</a></li>
						</c:when>
						<c:when test="${principal.companyId != null}">
							<li class="nav-item"><a class="nav-link" href="#">관심 이력서 보기</a></li>
							<li class="nav-item"><a class="nav-link" href="#"> 공고관리</a></li>
							<li class="nav-item"><a class="nav-link" onclick="sendmessage()">기업정보</a></li>
							<li class="nav-item"><a class="nav-link" href="/logout">로그아웃</a></li>
							<li style="position: fixed; color: aliceblue; margin-top: 7px; right: 100px;" class="nav-item">${principal.userinfo.companyName}님환영합니다.</li>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="nav-link" href="#">이력서관리</a></li>
							<li class="nav-item"><a class="nav-link" href="#">지원이력보기</a></li>
							<li class="nav-item"><a class="nav-link" onclick="sendmessage()">내정보</a></li>
							<li id="myinfo" style="display: none;" value="${principal.userinfo}"></li>
							<li class="nav-item"><a class="nav-link" onclick="disconnect()" href="/logout">로그아웃</a></li>
							<li class="nav-item" style="position: fixed; color: aliceblue; margin-top: 7px; right: 100px;">${principal.userinfo.personalName}님환영합니다.</li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</nav>
	<div id="main">
		<br /> <input id="resume_title" type="text" class="form-control" placeholder="이력서 제목을 입력해주세요.">
		<div class="tool">
			<div class="left">
				<br />
				<h3>개인정보 입력</h3>
				<div class="left_input">
					<div id="userId">sopu5555</div>
					<br />
					<div id="userName">박동훈</div>
					<br />
					<div id="phonenumber">01024102957</div>
					<br />
					<div id="email">sop55544@gmail.com</div>
					<input type="hidden" id="resumesId" value="1">
				</div>
			</div>
			<div class="right">
				<img id="previewImg" />
			</div>
		</div>
		<input type="file" Id="fileUpload" accept='image/*' /> <br /> <br />
		<div class="form">
			<h2>자기소개서 작성</h2>
			<div id="summernote"></div>
		</div>
		<div class="btn-update">
			<button id="btnlike" type="button" class="btn btn-primary">좋아요</button>
			<button id="btnapply" type="button" class="btn btn-primary">연락하기</button>
		</div>

	</div>

	<script>
	$(function() {
	  $('#btnlike').click( function() {
	    if( $(this).html() == '좋아요') {
	      
	      $(this).html('좋아요취소');
	      insertLike();
	    }
	    else {
	      
	      $(this).html('좋아요');
	      deleteLike();
	    }
	  });
	});

function deleteLike() {
	let resumesId = $("#resumesId").val();
	$.ajax("/personalLike/" + resumesId + "/likes",{
		type: "DELETE",
		dataType: "json",
		headers: { // http header에 들고갈 요청 데이터
			"Content-Type": "application/json; charset=utf-8"
		}
	}).done((res) => {
		if (res.code == 1) {
			
		} else {
			alert("좋아요 추가 실패");
			return;
		}
	});
}

function insertLike() {
	let resumesId = $("#resumesId").val();
	$.ajax("/personalLike/" + resumesId + "/likes",{
		type: "POST",
		dataType: "json",
		headers: { // http header에 들고갈 요청 데이터
			"Content-Type": "application/json; charset=utf-8"
		}
	}).done((res) => {
		if (res.code == 1) {
			
		} else {
			alert("좋아요 추가 실패");
			return;
		}
	});
}
</script>


</body>
</html>