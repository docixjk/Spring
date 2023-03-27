<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="UTF-8">
				<title>상세조회</title>
				<style>
					table,
					tr,
					th,
					td {
						border: 1px solid black;
					}
				</style>
				<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
			</head>

			<body>
				<!-- submit을 막을 수 있다. (동작하지 않게 하는거) -->
				<form onSubmit="return false">
					<div>
						<label>employee_id : <input type="text" name="employeeId" value="${empInfo.employeeId}" readonly></label>
					</div>
					<div>
						<label>first_name : <input type="text" name="firstName" value="${empInfo.firstName}"></label>
					</div>
					<div>
						<label>last_name : <input type="text" name="lastName" value="${empInfo.lastName}"></label>
					</div>
					<div>
						<label>email : <input type="text" name="email" value="${empInfo.email}"></label>
					</div>
					<div>
						<label>phone_number : <input type="text" name="phoneNumber" value="${empInfo.phoneNumber}"></label>
					</div>
					<div>
						<label>hire_date : <input type="date" name="hireDate"
								value='<fmt:formatDate value="${empInfo.hireDate}" pattern="yyyy-MM-dd" />'></label>
					</div>
					<div>
						<label>job_id : <input type="text" name="jobId" value="${empInfo.jobId}"></label>
					</div>
					<div>
						<label>salary : <input type="text" name="salary" value="${empInfo.salary}"></label>
					</div>
					<div>
						<label>commission_pct : <input type="text" name="commissionPct" value="${empInfo.commissionPct}"></label>
					</div>
					<div>
						<label>manager_id : <input type="text" name="managerId" value="${empInfo.managerId}"></label>
					</div>
					<div>
						<label>department_id : <input type="text" name="departmentId" value="${empInfo.departmentId}"></label>
					</div>
					<button type="submit">수정</button>
					<button type="button">취소</button>
				</form>

				<script>
					// 통신은 많은 것을 지켜주어야함 ( 규칙 )
					// 페이지 전환이 되는 것과 안되는 것을 구분해서 작업해야한다
					function updateEmpInfo() {
						fetch('empUpdate', {
							method: 'post',
							headers: { // 빠지면 안됨 !!! 컨텐트타입 중요함
								'Content-Type': 'application/json' // json포맷으로 보내기때문에 지정
							},
							body: JSON.stringify(serializeObject()) // data를 json으로 인코딩하는 작업
							// serializeObject() 이것은 우리가 만들 함수
						})
							.then((res) => res.json())
							.then((data) => {
								if (data != null && data['결과'] == 'Success') {
									alert('사원번호' + data['사원번호'] + ' 의 정보가\n'
										+ '수정이 완료 되었습니다.');
								} else {
									alert('수정이 되지않았습니다.')
								}
							})
							.catch((rej) => console.log(rej))

					}
					function serializeObject() {
						let formData = $('form').serializeArray();
						// 배열 형태로 변환 시킴
						// [{name:'firstName',value:'Steven'},{name:'',value:''}...]

						let objectData = {}
						formData.forEach(function (obj, idx) { // form 태그의 내용들을 하나의 객체로 변환 시킴
							// 순차적으로 키 벨류 형태로 만들어줌 
							objectData[obj.name] = obj.value
						});
						return objectData;
					}

					// type이 submit인 button을 click시 발생하는 event를 걸어줌
					document.querySelector('button[type="submit"]').addEventListener('click', updateEmpInfo);

				</script>
			</body>

			</html>