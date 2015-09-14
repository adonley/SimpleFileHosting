<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<jsp:include page="includes/head.jsp"/>
<body>
<jsp:include page="includes/header.jsp"/>
<div class="row">
    <div class="col-md-10 col-md-offset-1">
        <form method="POST" action="/upload/file" enctype="multipart/form-data">
            <input type="file" name="file"><br>
            <input type="submit">
            <jsp:include page="includes/footer.jsp"/>
        </form>
    </div>
</div>
</body>
</html>
