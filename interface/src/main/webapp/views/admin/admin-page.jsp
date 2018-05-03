<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin page</title>
        <%@ include file="/resources/jsp/admin/admin-include.jspf" %>
    </head>
    <body>
        <%@ include file="/resources/jsp/admin/admin-header.jspf" %>
        <div class="container-fluid" id="main-container">
            <div class="row justify-content-center">
                <%@ include file="/resources/jsp/notification.jspf" %>
            </div>
            <%@ include file="/resources/jsp/admin/users-table.jspf" %>
            <form class="form-inline" action="../admin/deleteUser">
                <input type="text" class="form-control" id="delete-user-field" name="username" placeholder="Username"/>
                <button type="submit" class="btn btn-danger">Delete</button>
            </form>
        </div>
    </body>
</html>
