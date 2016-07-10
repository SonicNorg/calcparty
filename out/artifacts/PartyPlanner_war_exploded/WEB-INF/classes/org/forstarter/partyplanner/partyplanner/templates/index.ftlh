<!DOCTYPE html>
<html>
<head>
    <title>Welcome!</title>
</head>
<body>
<h2>PartyPlanner</h2>
<table>
    <#list itemList as item>
      <tr><td>${item.foodName}</td><td>${item.eaters}</td><td>${item.count}</td><td>${item.unit}</td></tr>
    </#list>
</table>
</body>
</html>