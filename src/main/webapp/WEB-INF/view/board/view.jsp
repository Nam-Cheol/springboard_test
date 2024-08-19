<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/layout/header.jsp"%>

<div class="container mt-5">
    <c:choose>
        <c:when test="${board != null}">
            <div class="card">
                <div class="card-header">
                    <h3>${board.title}</h3>
                </div>
                <div class="card-body">
                    <p class="card-text"><strong>작성자:</strong> ${board.username}</p>
                    <p class="card-text"><strong>작성일:</strong> ${board.createdAt}</p>
                    <hr>
                    <p class="card-text">${board.content}</p>
                </div>
                <div class="card-footer text-right">
                    <a href="/board/update?id=${board.id}" class="btn btn-warning">수정</a>
                    <a href="/board/delete?id=${board.id}" class="btn btn-danger" onclick="return confirm('정말 삭제하시겠습니까?');">삭제</a>
                    <a href="/board/view" class="btn btn-secondary">목록으로</a>
                </div>
            </div>
        </c:when>
        <c:otherwise>
            <div class="d-flex justify-content-center align-items-center" style="height: 100vh;">
                <p class="text-muted fs-4">게시글이 존재하지 않습니다.</p>
            </div>
        </c:otherwise>
    </c:choose>
</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
