<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Update Actor</title>

    <!-- ✅ External CSS File -->
    <link rel="stylesheet" href="css/Update.css">

   
</head>
<body>

    <!-- Header -->
    <div class="navbar">
        Update Actor
    </div>

    <!-- Form -->
    <div class="form-container">
        <h2 style="text-align:center; color:#e53935;">Update Actor Details</h2>

        <frm:form modelAttribute="actor" method="POST" action="actor_edit">
            <table>
                <tr>
                    <td><label>Actor Id:</label></td>
                    <td><frm:input path="aid" readonly="true"/> </td>
                </tr>
                <tr>
                    <td><label>Actor Name:</label></td>
                    <td><frm:input path="aname"/> </td>
                </tr>
                <tr>
                    <td><label>Actor Address:</label></td>
                    <td><frm:input path="addrs"/> </td>
                </tr>
                <tr>
                    <td><label>Actor Category:</label></td>
                    <td><frm:input path="category"/></td>
                </tr>
                <tr>
                    <td><label>Actor Fee:</label></td>
                    <td><frm:input path="fee"/> </td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align:center;">
                        <input type="submit" value="Update Actor" class="btn-submit">
                        <input type="reset" value="Cancel" class="btn-reset">
                    </td>
                </tr>
            </table>
        </frm:form>
    </div>

    <!-- Footer -->
    <div class="footer">
        &copy; 2025 | Developed by Rajnish Yadav | MCA | Spring Boot Mini Project
    </div>

</body>
</html>
