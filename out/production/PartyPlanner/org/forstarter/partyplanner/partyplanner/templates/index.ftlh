<!DOCTYPE html>
<html>
<head>
    <title>Welcome!</title>
</head>
<body>
    <h2>PartyPlanner</h2>
    <form action="" method="GET">
        <table>
            <#list itemList as item>
                <tr><td>${item.foodName}</td>
                    <td><input type="text" name=${item.id} value=${item.eaters}></td>
                    <td>${item.count}</td>
                </tr>
            </#list>
        </table>
        <input type="submit" value="Рассчитать">
    </form>
</body>
</html>