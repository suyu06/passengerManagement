<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>List passengers</title>
    <link type="text/css"
          rel="stylesheet"
          href="<c:url value="/static/style.css"/>"/>
</head>
<body>
<div class="form-container">
    <div id="wrapper">
        <div id="header">
            <h2>passenger Management</h2>
        </div>
    </div>
    <div id="container">
        <div id="content">
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Birth Date</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                    <th>Gender</th>
                    <th>Payment</th>
                    <th>Address</th>
                    <th>Delete</th>
                </tr>
                <c:forEach var="tempPassenger" items="${passengers}">
                    <c:url var="deleteLink" value="/api/passengers/delete">
                        <c:param name="passengerId" value="${tempPassenger.passengerId}"/>
                    </c:url>
                    <tr>
                        <td> ${tempPassenger.firstName} </td>
                        <td> ${tempPassenger.lastName} </td>
                        <td> ${tempPassenger.birthDate} </td>
                        <td> ${tempPassenger.email} </td>
                        <td> ${tempPassenger.phoneNumber} </td>
                        <td> ${tempPassenger.gender} </td>
                        <td> ${tempPassenger.payment}</td>
                        <td> ${tempPassenger.address} </td>
                        <td>
                            <a href="${deleteLink}"
                               onclick="if(!(confirm('Are you sure you want to delete this passenger?'))) return false">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <p>
        <a class="backToSearch" href="${pageContext.request.contextPath}">Back to Search</a>
    </p>
</div>
</body>
</html>