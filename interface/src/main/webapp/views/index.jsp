<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
        <%@ include file="/resources/jsp/include.jspf" %>
    </head>
    <body>
        <%@ include file="/resources/jsp/notification.jspf" %>
        <%@ include file="/resources/jsp/header.jspf" %>
        <div class="container-fluid alex-main-container alex-transition-left" id="main-container">
            <div class="alex-centre">
                <div class="row justify-content-center">
                    <div class="col-5">
                        <div class="row">
                            <h1>Hello <span style="color: #33A0CC"><security:authentication property="principal.username"/></span>, </h1>
                        </div>
                        <div class="row">
                            <h1>Would you like to...</h1>
                        </div>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-5">
                        <!-- <div class="col-2 text-center"> -->
                        <div class="row">
                            <button class="btn btn-lg" id="alex-start-button" type="button" onclick="location.href = '${pageContext.request.contextPath}/session/new-session';">
                                Start a new session
                            </button>
                            <!-- </div>-->
                            <div class="col-1 text-center">
                                <h1>or</h1>
                            </div>
                            <!-- <div class="col-2 text-center"> -->
                            <button class="btn btn-lg" id="alex-saved-sessions-button" type="button" onClick="">
                                View saved sessions
                            </button> 
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div> <!-- main-container -->
</div>
</body>
</html>
