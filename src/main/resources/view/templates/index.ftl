<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>PartyPlanner</title>
    <link rel="stylesheet" href="./css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="./css/range-sliders.css" type="text/css">
    <link rel="stylesheet" href="./css/main.css" type="text/css">
</head>
<body>
<div class="container">
    <div class="row">
        <h2>PartyPlanner</h2>
    </div>
    <form action="" method="GET">
        <div class="row">
            <div class="col-xs-3">
                <p>Количество гостей</p>
            </div>
            <div class="col-xs-9">
                <div class="range range-primary">
                    <input name="eaters" type="range" id="eaters" min="2" max="30" value="${foodList.eaters}" step="1"/>
                    <output id="eaters">${foodList.eaters}</output>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-3">
                <p>Продолжительность (в часах)</p>
            </div>
            <div class="col-xs-9">
                <div class="range range-success">
                    <input name="duration" type="range" id="duration" min="2" max="12" value="${foodList.duration}"
                           step="2"/>
                    <output id="duration">${foodList.duration}</output>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-3">
                <p>Прожорливость</p>
            </div>
            <div class="col-xs-9">
                <div class="range range-warning">
                    <input name="hunger" type="range" min="1" max="2" value="${foodList.hunger}" step="0.2"/>
                    <output id="duration">${foodList.hunger}</output>
                </div>
            </div>
        </div>
        <div class="row">
            <table class="table table-striped table-hover">
            <#list itemList as item>
                <tr>
                    <td>
                        <div class="quarter quarter-${item.sort}"></div>
                    </td>
                    <td>${item.foodName}</td>
                    <td><input type="text" name="${item.id?c}" value="${item.eaters}"></td>
                    <td>${item.count}</td>
                </tr>
            </#list>
            </table>
            <input type="submit" value="Рассчитать">
        </div>
    </form>
</div>
<script src="./js/jquery-3.1.0.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/main.js"></script>
</body>
</html>