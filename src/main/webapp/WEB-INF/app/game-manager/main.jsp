<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/style.css"/>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<c:forEach items="${ data }" var="object" varStatus="status">
    <article>
        <h1><c:out value="${ object.name }"/></h1>
        <table>
            <thead>
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Acction</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ object.item }" var="item" varStatus="status2">
                <tr>
                    <td><c:out value="${ status2.index }"/></td>
                    <td><c:out value="${ item.name }"/></td>
                    <td>
                        <button onclick="location.href='?edit&type=<c:out value="${ object.name }"/>&id=<c:out value="${ status2.index }"/>'"><i class="material-icons small">edit</i></button>
                        <button onclick="location.href='?remove&type=<c:out value="${ object.name }"/>&id=<c:out value="${ status2.index }"/>'"><i class="material-icons small">remove</i></button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
            <tfoot>
            <tr>
                <td></td>
                <td></td>
                <td>
                    <button onclick="location.href='?edit&type=<c:out value="${ object.name }"/>&id=add'"><i class="material-icons small">add</i></button>
                </td>
            </tr>
            </tfoot>
        </table>
    </article>
</c:forEach>