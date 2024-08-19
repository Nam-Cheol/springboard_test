<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/layout/header.jsp"%>
    <div class="container mt-5">
    
    	<c:if test="${not empty message}">
	        <script>
	            alert('${message}');
	        </script>
    	</c:if>
    
        <h2>게시판 글쓰기</h2>
        <form action="/board/write" method="post">
            <div class="mb-3">
                <label for="title" class="form-label">제목</label>
                <input type="text" class="form-control" id="title" name="title" required>
            </div>
            
            <div class="mb-3">
                <label for="title" class="form-label">작성자</label>
                <input type="text" class="form-control" id="username" name="username" required>
            </div>
            
            <div class="mb-3">
                <label for="content" class="form-label">내용</label>
                <textarea class="form-control" id="content" name="content" rows="5" required></textarea>
            </div>
            <button type="submit" class="btn btn-primary">작성</button>
            <a href="/board/view" class="btn btn-secondary">취소</a>
        </form>
    </div>
<%@ include file="/WEB-INF/view/layout/footer.jsp" %>
