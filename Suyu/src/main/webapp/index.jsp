<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
            <div class="inputForm">
                <a class="showList" href="http://localhost:8080/Suyu_war/api/passengers">show list of all passengers</a>
            </div>
            <div class="inputForm">
                <form action="${pageContext.request.contextPath}/api/passengers/id"
                      method="get">
                    <div class="inputBox inputBox1">
                        <input id="passengerId" name="passengerId" placeholder="Show one passenger by id">
                    </div>
                    <input type="submit" value="Search" class="searchBtn"/>
                </form>
            </div>
            <div class="inputForm">
                <form action="${pageContext.request.contextPath}/api/passengers/find/lastName" method="get">
                    <div class="inputBox inputBox1">
                        <input id="lastName" name="lastName" placeholder="Show passengers by last Name">
                    </div>
                    <input type="submit" value="Search" class="searchBtn"/>
                </form>
            </div>
            <div class="inputForm">
                <form action="${pageContext.request.contextPath}/api/passengers/city/same-city" method="get">
                    <div class="inputBox inputBox1">
                        <input id="toCity" name="toCity" placeholder="Show passengers by same destination city">
                    </div>
                    <input type="submit" value="Search" class="searchBtn searchBtn2"/>
                </form>
            </div>
            <div class="inputForm">
                <a class="showList" href="${pageContext.request.contextPath}/api/passengers/sorted/lastName">Show list
                    of passengers ordered by last name</a>
            </div>
            <div class="inputForm">
                <form action="${pageContext.request.contextPath}/api/passengers/departureDate" method="get">
                    <div class="inputBox inputBox1">
                        <input id="departureDate" name="departureDate"
                               placeholder="Show passengers by same departure date">
                    </div>
                    <input type="submit" value="Search" class="searchBtn"/>
                </form>
            </div>
            <div class="inputForm">
                <form action="${pageContext.request.contextPath}/api//passengers/find/date/{date}/city/{city}"
                      method="get">
                    <div class="inputBox inputBox2">
                        <input id="departureDate1" name="departureDate" placeholder="Input departure date">
                    </div>
                    <div class="inputBox inputBox2">
                        <input id="toCity1" name="toCity" placeholder="Input destination city">
                    </div>
                    <input type="submit" value="Search" class="searchBtn"/>
                </form>
            </div>

        </div>
    </div>
</div>
</body>
</html>
