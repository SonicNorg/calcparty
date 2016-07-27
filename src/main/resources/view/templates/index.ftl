<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>PartyPlanner</title>
    <link rel="stylesheet" href="./css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="./css/main.css" type="text/css">
</head>
<body>
    <div class="container">
        <div class="row">
        <h2>PartyPlanner</h2>
            <form action="" method="GET">
                <input name="eaters" type="range" min="2" max="25" value=${foodList.eaters} step="1" />
                <input name="duration" type="range" min="3" max="12" value=${foodList.duration} step="3" />
                <input name="hunger" type="range" min="1" max="2" value=${foodList.hunger} step="0.2" />
                <table class="table table-striped table-hover">
                    <#list itemList as item>
                        <tr>
                            <td><div class="quarter quarter-${item.sort}"></div></td>
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