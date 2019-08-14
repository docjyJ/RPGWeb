<link rel="stylesheet" href="/file/style.css"/>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<form method="post" action="?put&type=<c:out value="${ type }"/>&id=<c:out value="${ id }"/>">
    <h1><c:out value="${ type }"/>:<c:out value="${ id }"/></h1>
    <label>
        Name
        <input type="text" name="name" value="<c:out value="${ object.name }"/>"/>
    </label>
    <label>
        Picture
        <input type="url" name="picture" value="<c:out value="${ object.picture }"/>"/>
        Help: link a landscape image.
    </label>
    <label>
        Description
        <input type="text" name="description" value="<c:out value="${ object.description }"/>"/>
    </label>
    <label>
        Color
        <input type="color" name="color" value="<c:out value="${ object.color }"/>"/>
    </label>
    <label>
        X
        <input type="number" name="x" value="<c:out value="${ object.x }"/>"/>
    </label>
    <label>
        Y
        <input type="number" name="y" value="<c:out value="${ object.y }"/>"/>
    </label>
    <label>
        TX
        <input type="number" name="tX" value="<c:out value="${ object.tX }"/>"/>
    </label>
    <label>
        TY
        <input type="number" name="tY" value="<c:out value="${ object.tY }"/>"/>
    </label>
    <nav>
        <button type="submit"><i class="material-icons">check</i></button>
        <button type="button" onclick="location.href='?'"><i class="material-icons">close</i></button>
    </nav>
</form>
