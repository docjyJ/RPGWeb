<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/style.css"/>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<form method="post" action="?put-<c:out value="${ name }"/>&id=<c:out value="${ id }"/>">
    <h1><c:out value="${ name }"/>:<c:out value="${ id }"/></h1>
    <label>
        Name
        <input type="text" name="name" value="<c:out value="${ object.name }"/>"/>
    </label>
    <label>
        Picture
        <input type="text" name="picture" value="<c:out value="${ object.picture }"/>"/>
    </label>
    <label>
        Description
        <input type="text" name="description" value="<c:out value="${ object.description }"/>"/>
    </label>
    <label>
        Health
        <input type="number" name="health" value="<c:out value="${ object.health }"/>"/>
    </label>
    <label>
        Srength
        <input type="number" name="srength" value="<c:out value="${ object.srength }"/>"/>
    </label>
    <label>
        Agility
        <input type="number" name="agility" value="<c:out value="${ object.agility }"/>"/>
    </label>
    <label>
        Focus
        <input type="number" name="focus" value="<c:out value="${ object.focus }"/>"/>
    </label>
    <label>
        Attack
        <input type="number" name="attack" value="<c:out value="${ object.attack }"/>"/>
    </label>
    <nav>
        <button type="submit"><i class="material-icons">check</i></button>
        <button onclick="location.href='?'"><i class="material-icons">close</i></button>
    </nav>
</form>
