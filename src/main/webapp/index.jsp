<%@ page import="java.io.*" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<jsp:include page="includes/head.jsp"/>
<body>
<jsp:include page="includes/header.jsp"/>
<jsp:include page="includes/navigation.jsp"/>

<div class="col-md-6">
          <%
              out.println("<h1> Welcome Hackers </h1>");
              List<String> list = (List<String>) request.getAttribute("articles");
              if (list == null || list.isEmpty()){
                  out.println("<h3> No Posts Yet! </h3><br>");
              }
              else {
                  for (String title : list) {
                      out.println("<h3>" + title + "</h3><br>");
                  }
              }
          %>

      </div>
</div>
<jsp:include page="includes/footer.jsp"/>
</body>
</html>
