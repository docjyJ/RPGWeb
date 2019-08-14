<link rel="stylesheet" href="/file/style.css"/>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<article>
    <c:forEach items="${ data }" var="object" varStatus="status">
        <div class="article">
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
                        <td style="background-color: <c:out value="${ item.color }"/>">
                            <c:out value="${ status2.index }"/>
                        </td>
                        <td>
                            <img src="<c:out value="${ item.picture }"/>" width="20px" height="20px">
                            <c:out value="${ item.name }"/>
                        </td>
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
        </div>
        <c:if test="${ status.index == 1 }" ></article><article></c:if>
    </c:forEach>
</article>
<div class="article">
    <h1>room</h1>
    <table>
        <thead>
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>X</td>
            <td>Y</td>
            <td>TX</td>
            <td>TY</td>
            <td>Acction</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ rooms }" var="item" varStatus="status2">
            <tr>
                <td style="background-color: <c:out value="${ item.color }"/>"><c:out value="${ status2.index }"/></td>
                <td><c:out value="${ item.name }"/></td>
                <td><c:out value="${ item.x }"/></td>
                <td><c:out value="${ item.y }"/></td>
                <td><c:out value="${ item.tX }"/></td>
                <td><c:out value="${ item.tY }"/></td>
                <td>
                    <button onclick="location.href='?edit&type=room&id=<c:out value="${ status2.index }"/>'"><i class="material-icons small">edit</i></button>
                    <button onclick="location.href='?remove&type=room&id=<c:out value="${ status2.index }"/>'"><i class="material-icons small">remove</i></button>
                    <button onclick="location.href='?chepaencorelurl&type=room&id=<c:out value="${ status2.index }"/>'"><i class="material-icons small">view_list</i></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td>
                <button onclick="location.href='?edit&type=room&id=add'"><i class="material-icons small">add</i></button>
            </td>
        </tr>
        </tfoot>
    </table>
</div>
<div class="map" style="top: 100%;">
    <c:forEach items="${ rooms }" var="item">
        <div
                class="room"
                style="
                        width: calc(( 60px * <c:out value="${ item.tX }"/> ) - 1px );
                        height: calc(( 50px * <c:out value="${ item.tY }"/> ) - 1px );
                        line-height: calc(( 50px * <c:out value="${ item.tY }"/> ) - 1px );
                        top : calc(( 50px * <c:out value="${ item.y }"/> ) + 26px );
                        left: calc(( 60px * <c:out value="${ item.x }"/> ) + 26px );
                        background-color: <c:out value="${ item.color }"/>55;"
        >
            <span><c:out value="${ item.name }"/></span>
            <div>
                <text style="background-color: <c:out value="${ item.color }"/>55;">
                    <h2><c:out value="${ item.name }"/></h2>
                    <p><c:out value="${ item.description }"/></p>
                </text>
            </div>
        </div>
    </c:forEach>
</div>