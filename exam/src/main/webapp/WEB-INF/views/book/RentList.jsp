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
                <h3>도서별 대여매출현황</h3>
                <table>
                    <thead>
                        <tr>
                            <th>도서번호</th>
                            <th>도서명</th>
                            <th>대여총계</th>
                            <th>대여횟수</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${RentList}" var="rent">
                            <tr>
                                <td>${rent.bookNo}</td>
                                <td>${rent.bookName}</td>
                                <td>${rent.sumPrice}</td>
                                <td>${rent.count}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </main>