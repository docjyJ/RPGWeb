<link rel="stylesheet" href="/file/style.css"/>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<form method="post" action="?remove&type=<c:out value="${ name }"/>&id=<c:out value="${ id }"/>">
    <h1><c:out value="${ name }"/>:<c:out value="${ id }"/></h1>
    <label>
        Remove
    </label>
    <nav>
        <button type="submit"><i class="material-icons">check</i></button>
        <button type="button" onclick="location.href='?'"><i class="material-icons">close</i></button>
    </nav>
</form>
