<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>All cars</title>
</head>
<style>
    body {
        align-content: center;
    }
</style>
<body>
<sec:authorize access="hasAuthority('ROLE_ADMIN')">
<h1>All Cars</h1>
${cars}
<button onclick="window.location = '/car/all'">Show all cars</button>
</sec:authorize>
<h1>Actions</h1>
<form method="post" action="/car/add">
    <h3>Add new car</h3>
    <input name="brand" type="text" placeholder="Brand ...">
    <input name="model" type="model" placeholder="Model ...">
    <input name="capacity" type="number" placeholder="Engine capacity ...">
    <input name="price" type="number" placeholder="Price ...">
    <input name="speedMax" type="number" placeholder="Max speed ...">

    <button>Add a new car</button>
</form>
<br>
<br>
<form method="get" action="/car/findByBrand">
    <h3>Find car by brand</h3>
    <input name="brand" type="text" placeholder="Brand ...">
    <button>Find car</button>
</form>
<br>
<br>
<form method="get" action="/car/findByBrandAndModelAndSpeedMax">
    <h3>Find car by brand,model and max speed</h3>
    <input name="brand" type="text" placeholder="Brand ...">
    <input name="model" type="model" placeholder="Model ...">
    <input name="speedMax" type="number" placeholder="Max speed ...">
    <button>Find car</button>
</form>
<br>
<br>
<form action="/car/removeById">
    <h3>Delete car by id</h3>
    <input name="id" type="number" placeholder="Id car ...">
    <button>Delete car</button>
</form>
<br>
<br>
<form action="/car/removeAllByBrand">
    <h3>Delete all cars by brand</h3>
    <input name="brand" type="text" placeholder="Brand ...">
    <button>Delete cars</button>
</form>
</body>
</html>