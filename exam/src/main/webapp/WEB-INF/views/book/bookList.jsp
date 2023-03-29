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
					width: 250px;
				}
			</style>
			<main>
				<h3>도서 조회/수정</h3>
				<table>
					<thead>
						<tr>
							<th>도서번호</th>
							<th>도서명</th>
							<th>표지</th>
							<th>출판일자</th>
							<th>금액</th>
							<th>출판사</th>
							<th>도서소개</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${bookList}" var="book">
							<tr>
								<td>${book.bookNo}</td>
								<td>${book.bookName}</td>
								<td><img src="resources/images/${book.bookCoverimg}" alt="표지" style="width: 200px"></td>
								<td>
									<fmt:formatDate value="${book.bookDate}" pattern="yyyy/MM/dd" />
								</td>
								<td>${book.bookPrice}</td>
								<td>${book.bookPublisher}</td>
								<td>${book.bookInfo}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</main>
			<script>

				function printAlert(message) {
					if (message == null || message == '') {
						return;
					}
					alert(message);
				}
				printAlert(`${result}`);
			</script>