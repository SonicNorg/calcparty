<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>PartyPlanner</title>
    <link rel="stylesheet" href="./css/bootstrap.min.css" type="text/css">
</head>
<body>
    <div class="container">
        <div class="row">
        <h2>PartyPlanner</h2>
            <form action="" method="GET">
                <table class="table table-striped table-hover">
                    <#list itemList as item>
                        <tr><td>${item.sort}</td>
                            <td>${item.foodName}</td>
                            <td><input type="text" name="${item.id?c}" value="${item.eaters}"></td>
                            <td>${item.count}</td>
                        </tr>
                    </#list>
                </table>
                <input type="submit" value="Рассчитать">
            </form>
        </div>
    </div>
</body>
</html>