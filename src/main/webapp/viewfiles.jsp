<%@ page import="java.io.*" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<jsp:include page="includes/head.jsp"/>
<body>
<jsp:include page="includes/header.jsp"/>
    <br>
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <%
                List<String> list = (List<String>) request.getAttribute("files");

                for(String fileName : list)
                {
                    out.println("<a href=\"/files/" + fileName + "\">" + fileName + "</a><br>");
                }
            %>
            </div>
    </div>
<jsp:include page="includes/footer.jsp"/>
</body>
</html>
