<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
			<style>
				body,
				html {
					width: 100%;
				}

				main {
					width: 100%;
					margin: 0 auto;
				}

				th {
					width: 200px;
				}
			</style>
			<main>
				<h1>도서 등록</h1>
				<form action="bookInsert" method="post" name="insertForm" onsubmit="return false">
					<table>
						<tr>
							<th>도서번호</th>
							<td>
								<input type="text" name="bookNo" value="${bookNo}" readonly>
							</td>
						</tr>
						<tr>
							<th>도서명</th>
							<td>
								<input type="text" name="bookName">
							</td>
						</tr>
						<tr>
							<th>도서표지</th>
							<td>
								<input type="text" name="bookCoverimg">
							</td>
						</tr>
						<tr>
							<th>출판일자</th>
							<td>
								<input type="date" name="bookDate">
							</td>
						</tr>
						<tr>
							<th>금액</th>
							<td>
								<input type="text" name="bookPrice">
							</td>
						</tr>
						<tr>
							<th>출판사</th>
							<td>
								<input type="text" name="bookPublisher">
							</td>
						</tr>
						<tr>
							<th>도서소개</th>
							<td>
								<input type="text" name="bookInfo">
							</td>
						</tr>
					</table>
					<button type="submit">등록</button>
					<button type="button">조회</button>
				</form>

			</main>
			<script>
				function formOptionChk() {
					let bookName = document.getElementsByName("bookName")[0];
					let bookCoverimg = document.getElementsByName("bookCoverimg")[0];
					let bookDate = document.getElementsByName("bookDate")[0];
					let bookPrice = document.getElementsByName("bookPrice")[0];
					let bookPublisher = document.getElementsByName("bookPublisher")[0];
					let bookInfo = document.getElementsByName("bookInfo")[0];

					if (bookName.value == "") {
						alert("도서명이 입력되지 않았습니다");
						bookName.focus();
						return;
					}
					if (bookCoverimg.value == "") {
						alert("표지가 입력되지 않았습니다");
						bookCoverimg.focus();
						return;
					}
					if (bookDate.value == "") {
						alert("출판일자가 입력되지 않았습니다");
						bookDate.focus();
						return;
					}
					if (bookPrice.value == "") {
						alert("도서가격이 입력되지 않았습니다");
						bookPrice.focus();
						return;
					}
					if (bookPublisher.value == "") {
						alert("출판사가 입력되지 않았습니다");
						bookPublisher.focus();
						return;
					}
					if (bookInfo.value == "") {
						alert("도서정보가 입력되지 않았습니다");
						bookInfo.focus();
						return;
					}
					insertForm.submit();
				}
				document.querySelector('button[type="submit"]').addEventListener('click', formOptionChk);
			</script>