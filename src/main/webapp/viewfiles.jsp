<%@ page import="java.io.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<jsp:include page="includes/head.jsp"/>
<body>
<jsp:include page="includes/header.jsp"/>
    <br>
    <div class="row">
        <div class="col-xs-8 col-xs-offset-2 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1">
            <%
                List<String> list = (List<String>) request.getAttribute("files");
                List<String> texts = new ArrayList<String>();
                List<String> other = new ArrayList<String>();

                for(String fileName : list)
                {
                    if(fileName.endsWith("pdf") || fileName.endsWith("txt"))
                        texts.add(fileName);
                    else
                        other.add(fileName);
                }

                if(texts.size() > 0)
                {
                    out.println("<h3>Books</h3>");
                    out.println("<ul>");
                }

                for(String text: texts)
                {
                    out.println("<li><a href=\"/files/" + text + "\">" + text + "</a><br></li>\n");
                }

                if(texts.size() > 0)
                    out.println("</ul>");

                if(other.size() > 0)
                {
                    out.println("<h3>Other</h3>");
                    out.println("<ul>");
                }

                for(String file: other)
                {
                    out.println("<li><a href=\"/files/" + file + "\">" + file + "</a></li>\n");
                }

                if(other.size() > 0)
                    out.println("</ul>");
            %>
            </div>
    </div>
<jsp:include page="includes/footer.jsp"/>
</body>
</html>
