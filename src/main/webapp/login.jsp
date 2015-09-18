<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <jsp:include page="includes/head.jsp"/>
  <body>
    <jsp:include page="includes/header.jsp"/>
    <div class="row">
    <jsp:include page="includes/navigation.jsp"/>

      <div class="col-md-5">
        <form method="POST" action="j_security_check">
            <input class="login-box" placeholder="Username" type="text" name="j_username">
            <input class="login-box" placeholder="password" type="password" name="j_password">
            <input class="login-button" type="submit" value="Submit" />
        </form>
      </div>
    </div>
    <jsp:include page="includes/footer.jsp"/>
  </body>
</html>
