<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <%@ include file="/resources/jsp/include.jspf" %>
        <script src="resources/js/login.js"></script>
    </head>
    <body>
        <div class="container-fluid h-100 alex-main-container">
            <div class="row">
                <%@ include file="/resources/jsp/notification.jspf" %>
                <%@ include file="/resources/jsp/login-notification.jspf" %>
            </div>

            <div class="row justify-content-center align-items-center h-100">
                <div class="col-md-auto">
                    <div class="card" id="login-card" style="width: 18rem;">
                        <div class="card-body">
                            <h5 id="login-card-title" class="card-title">Login</h5>
                            <form:form action="${pageContext.request.contextPath}/authenticate" method="POST">
                                <div class="form-group">
                                    <input path="username" name="username" type="text" class="form-control" id="login-form-username" placeholder="User"/>
                                    <input path="password" name="password" type="password" class="form-control" id="login-form-password" placeholder="Password"/>
                                </div>
                                <button id="login-button" type="submit" class="btn btn-light">Login</button>
                                <button id="register-button" type="button" class="btn btn-primary" data-toggle="modal" data-target="#registerModal">Register</button>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
            <c:set var = "register" value = "${param.register != null ? 'true' : 'false'}"/>
            <input type="hidden" id="register-variable" value="${register}"/>
            <!-- Modal -->
            <%@ include file="/resources/jsp/register-user-modal.jspf" %>
        </div>
    </body>
</html>
