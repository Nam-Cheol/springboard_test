<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/layout/header.jsp"%>
    <div class="container mt-5">
        <h2>게시판 글쓰기</h2>
        <form action="/board/update?id=${board.id}" method="post">
            <div class="mb-3">
                <label for="title" class="form-label">제목</label>
                <input type="text" class="form-control" id="title" name="title" required value="${board.title}">
            </div>
            <div class="mb-3">
                <label for="content" class="form-label">내용</label>
                <textarea class="form-control" id="content" name="content" rows="5" required>${board.content}</textarea>
            </div>
            <button type="submit" class="btn btn-primary">작성</button>
            <a href="/board/view" class="btn btn-secondary">취소</a>
        </form>
    </div>
<%@ include file="/WEB-INF/view/layout/footer.jsp" %>