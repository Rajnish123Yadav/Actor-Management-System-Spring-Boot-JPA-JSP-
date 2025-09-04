<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register Actor</title>
        <!-- ✅ External CSS File -->
    <link rel="stylesheet" href="css/Register.css">
</head>
<body>

    <div class="navbar">
        Actor Registration
    </div>

    <div class="form-container">
        <h2>Register a New Actor</h2>
        <frm:form action="actor_register" modelAttribute="actor" method="POST">
            <table>
                <tr>
                    <td><label>Actor Name:</label></td>
                    <td><frm:input path="aname" /></td>
                </tr>
                <tr>
                    <td><label>Actor Address:</label></td>
                    <td><frm:input path="addrs" /></td>
                </tr>
                <tr>
                    <td><label>Actor Category:</label></td>
                    <td><frm:input path="category" /></td>
                </tr>
                <tr>
                    <td><label>Actor Fee:</label></td>
                    <td><frm:input path="fee" /></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align:center;">
                        <input type="submit" value="Register">
                        <input type="reset" value="Reset">
                    </td>
                </tr>
            </table>
        </frm:form>
    </div>

    <div class="footer">
        &copy; 2025 | Developed by Rajnish Yadav | MCA | Spring Boot Mini Project
    </div>

   
</body>
</html>
