<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>Forum</title>
</head>
<body>
<div class="container pt-3">
    <a href="<c:url value="/index"/>">На главную</a>
    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                <div class="container">
                    <div class="row">
                        <div class="col-sm">Forum
                        </div>
                        <a class="col-sm " href="<c:url value="/create"/>">Create new post</a>
                        <div class="col-md-6 text-right text-info">Login as ${user.username}</div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card-body">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Theme</th>
                        <th scope="col">Created</th>
                        <th scope="col">Edit</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="post" items="${posts}">
                        <tr>
                            <td>
                                <h4 class="text-secondary"><a href="<c:url value='/topic?id=${post.id}'/>"><c:out
                                        value="${post.name}"/></a></h4>
                                <br>
                                <c:out value="${post.description}"/>
                            </td>
                            <td>
                                <c:out value="${post.created}"/>
                            </td>
                            <td>
                                <a href="<c:url value='/edit?id=${post.id}'/>">
                                    Edit
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

</body>
</html>
