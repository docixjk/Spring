<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
      <!DOCTYPE html>
      <html lang="en">

      <head>
        <meta charset="UTF-8">
        <title>등록</title>
      </head>
      <!-- 
            ContextPath 
            1) C 태그
            <form action="<시:유알아이 value='empInsert'/>" method="post">
            2) el
            <form action="달러{pageContext.request.contextPath}/empInsert" method="post">
        -->

      <body>
        <form action="empInsert" method="post">
          <div>
            <label>
              first_name :
              <input type="text" name="firstName">
            </label>
          </div>
          <div>
            <label>
              last_name :
              <input type="text" name="lastName">
            </label>
          </div>
          <div>
            <label>
              email :
              <input type="email" name="email">
            </label>
          </div>
          <div>
            <label>
              job_id :
              <input type="text" name="jobId">
            </label>
          </div>
          <div>
            <label>
              salary :
              <input type="text" name="salary">
            </label>
          </div>
          <button type="submit">등록</button>
          <button type="button">목록</button>

        </form>
      </body>

      </html>