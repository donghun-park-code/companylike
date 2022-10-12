<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>구인공고 리스트</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h2>관심이력서</h2>
		<c:forEach var="personalLike" items="${personalLikeList}">
			<div class="container p-5 my-4 border">${personalLike.resumesTitle}</div>
			<div class="d-grid gap-2 d-md-flex justify-content-md-end">
				<button id="btndelete" type="button" class="btn btn-primary">관심 목록 제거</button>
			</div>
		</c:forEach>
	</div>

</body>
</html>