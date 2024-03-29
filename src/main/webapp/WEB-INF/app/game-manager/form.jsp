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
        Help: link a square image.
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
        Health
        <input type="number" name="health" value="<c:out value="${ object.health }"/>"/>
        Help: set to 0 to disable the ability.
    </label>
    <label>
        Srength
        <input type="number" name="srength" value="<c:out value="${ object.srength }"/>"/>
        Help: set to 0 to disable the ability.
    </label>
    <label>
        Agility
        <input type="number" name="agility" value="<c:out value="${ object.agility }"/>"/>
        Help: set to 0 to disable the ability.
    </label>
    <label>
        Focus
        <input type="number" name="focus" value="<c:out value="${ object.focus }"/>"/>
        Help: set to 0 to disable the ability.
    </label>
    <label>
        Attack
        <input type="number" name="attack" value="<c:out value="${ object.attack }"/>"/>
        Help: set to 0 to disable the ability.
    </label>
    <nav>
        <button type="submit"><i class="material-icons">check</i></button>
        <button type="button" onclick="location.href='?'"><i class="material-icons">close</i></button>
    </nav>
</form>
