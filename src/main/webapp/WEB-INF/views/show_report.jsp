<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Actor Report</title>
    <!-- ✅ External CSS File -->
    <link rel="stylesheet" href="css/Report.css">
    
    <script>
        function toggleTheme() {
            document.body.classList.toggle("dark-mode");
            localStorage.setItem("theme", document.body.classList.contains("dark-mode") ? "dark" : "light");
        }

        window.onload = function () {
            if (localStorage.getItem("theme") === "dark") {
                document.body.classList.add("dark-mode");
            }
        };
    </script>
</head>
<body>

    <!-- Header -->
    <div class="navbar">
        Actor Report
        <button class="theme-toggle" onclick="toggleTheme()">Theme</button>
    </div>

    <!-- Search Bar -->
    <div class="search-container">
        <form action="searchBy_Name" method="get" class="search-form">
            <input type="text" name="name" placeholder="Enter Actor Name..."
                   value="${param.name}" required class="search-input">
            <button type="submit" class="search-btn">Search</button>
        </form>
    </div>

    <div class="content">

        <!-- Correct content check -->
        <c:if test="${not empty content}">
            <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Category</th>
                    <th>Fee</th>
                    <th>Operations</th>
                </tr>
                <c:forEach var="vo" items="${content}">
                    <tr>
                        <td>${vo.aid}</td>
                        <td>${vo.aname}</td>
                        <td>${vo.addrs}</td>
                        <td>${vo.category}</td>
                        <td>${vo.fee}</td>
                        <td>
                            <a href="actor_edit?no=${vo.aid}">
                                <img src="images/edit.png" width="30" height="30" alt="Edit">
                            </a>
                            <a href="actor_delete?no=${vo.aid}" onclick="return confirm('Do you want to delete the actor data?')">
                                <img src="images/delete.png" width="30" height="30" alt="Delete">
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>

            <!-- Pagination -->
            <p style="text-align:center;">
                <c:if test="${hasPrevious}">
                    <a href="report?page=${currentPage - 1}">Previous</a>&nbsp;&nbsp;
                </c:if>

                <c:if test="${!isFirst}">
                    <a href="report?page=0">First</a>&nbsp;&nbsp;
                </c:if>

                <c:forEach var="i" begin="1" end="${totalPages}">
                    [<a href="report?page=${i - 1}">${i}</a>]&nbsp;&nbsp;
                </c:forEach>

                <c:if test="${!isLast}">
                    <a href="report?page=${totalPages - 1}">Last</a>&nbsp;&nbsp;
                </c:if>

                <c:if test="${hasNext}">
                    <a href="report?page=${currentPage + 1}">Next</a>&nbsp;&nbsp;
                </c:if>
            </p>
        </c:if>

        <!-- No Data -->
        <c:if test="${empty content}">
            <h2 style="color:blue; text-align: center;">No Actor Data Found</h2>
        </c:if>

        <!-- Success Message -->
        <c:if test="${not empty resultMsg}">
            <h3 style="color: green; text-align: center;">${resultMsg}</h3>
        </c:if>

        <!-- Buttons -->
        <div class="btn-group">
            <a href="actor_register">
                <img src="images/add.png" alt="Add">
                Add Actor
            </a>
            <a href="./">
                <img src="images/home (3).png" alt="Home">
                Back to Home
            </a>
        </div>
    </div>

    <!-- Footer -->
    <div class="footer">
        &copy; 2025 | Developed by <strong>Rajnish Yadav</strong> | MCA | Spring Boot Mini Project
    </div>

</body>

</html>