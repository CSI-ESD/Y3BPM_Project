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
        <%@ include file="/resources/jsp/session/session-include.jspf" %>
    </head>
    <body>
        <%@ include file="/resources/jsp/notification.jspf" %>
        <%@ include file="/resources/jsp/header.jspf" %>
        <div class="container-fluid alex-main-container">
            <div class="alex-centre">
                <div class="row justify-content-center">
                    <div class="col-2">
                        <div class="row spinner">

                            <div class="double-bounce1"></div>
                            <div class="double-bounce2"></div>

                        </div>
                        <div class="row">
                            <h2>Searching for device...</h2>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </body>
</html>
