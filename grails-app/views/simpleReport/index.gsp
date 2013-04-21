<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Country Report</title>
</head>
<body>
    <h1>Country Code List</h1>
    <h3>Searched for ${report.search} at ${report.date}</h3>
    <g:form>
        <input name="countryName">
        <button type="submit">Search Countries</button>
    </g:form>

    <table>
        <tr><th>Name</th><th>Tld</th><th>Currency</th><th>Calling Code</th></tr>
        <g:each in="${report.countries}" var="country">
            <tr><td>${country.name}</td><td>${country.tld}</td>
                <td>${country.currency}</td><td>${country."calling-code"}</td></tr>
        </g:each>
    </table>



</body>
</html>