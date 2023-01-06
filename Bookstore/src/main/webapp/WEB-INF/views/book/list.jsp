<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>book::list</title>
	</head>
	<body>
		<h3>도서목록</h3>
		
		<a href="/Bookstore/index">처음으로</a>
		<a href="/Bookstore/book/register">도서등록</a>
		
		<table border="1">
			<tr>
				<th>도서번호</th>
				<th>도서명</th>
				<th>출판사</th>
				<th>가격</th>
				<th>관리</th>
			</tr>
			<c:forEach var="book" items="${books}">
			<tr>
				<td>${book.bookID}</td>
				<td>${book.bookName}</td>
				<td>${book.publisher}</td>
				<td>${book.price}</td>
				<td>
					<a href="/Bookstore/book/modify?bookID=${book.bookID}">수정</a>
					<a href="/Bookstore/book/delete?bookID=${book.bookID}">삭제</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>