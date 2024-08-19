<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/layout/header.jsp"%>
<div class="container mt-5">

	<c:choose>
		<c:when test="${boardList != null}">
			<table class="table table-hover">
				<thead class="table-dark">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>내용</th>
						<th>작성자</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="board" items="${boardList}">
							
						<tr>
							<td>${board.id}</td>
							<td><a href="/board/detail?id=${board.id}">${board.title}</a></td>
							<td>${board.content}</td>
							<td>${board.username}</td>
							<td>
			                    <a href="/board/delete?id=${board.id}" class="btn btn-danger" onclick="return confirm('정말 삭제하시겠습니까?');">삭제</a>
								<a href="/board/update?id=${board.id}" class="btn btn-warning">수정</a>
							</td>
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
					<!-- Pagination -->
		<div class="d-flex justify-content-center">
			<ul class="pagination">
				<!-- Previous Page Link -->
				<li class="page-item <c:if test='${currentPage == 1}'>disabled</c:if>"><a class="page-link" href="?page=${currentPage - 1}&size=${size}">Prev</a></li>

				<c:forEach begin="1" end="${totalPages}" var="page">
					<li class="page-item  <c:if test='${page == currentPage}'>active </c:if>"><a class="page-link" href="?page=${page}&size=${size}">${page}</a></li>
				</c:forEach>

				<!-- Next Page Link  -->
				<li class="page-item <c:if test='${currentPage == totalPages}'>disabled</c:if>"><a class="page-link" href="?page=${currentPage + 1}&size=${size}">Next</a></li>
			</ul>

		</div>
	</div>
			
		</c:when>
		<c:otherwise>
			<div class="d-flex justify-content-center align-items-center" style="height: 100vh;">
				<p class="text-muted fs-4">작성된 글이 없습니다.</p>
			</div>

		</c:otherwise>
	</c:choose>
</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
