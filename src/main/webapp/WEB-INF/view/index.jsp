<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>PartyPlanner</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Калькулятор закупки для пикника, шашлыка, вечеринки">
    <link rel="shortcut icon" href="<c:url value="/favicon.png"/>">
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>" type="text/css">
    <link rel="stylesheet" href="<c:url value="/css/range-sliders.css"/>" type="text/css">
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>" type="text/css">

    <!-- Open Graph -->
    <meta property="og:title" content="Калькулятор закупки для пикника, шашлыка, вечеринки" />
    <meta property="og:type" content="website" />
    <meta property="og:image" content="http://calcparty.ru/favicon.png" />
    <meta property="og:image:type" content="image/png" />
    <meta property="og:image:width" content="512" />
    <meta property="og:image:height" content="512" />
    <meta property="og:url" content="http://calcparty.ru/" />
    <meta property="og:locale" content="ru_RU" />

    <!-- Custom Fonts -->
    <link href="<c:url value="/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- Social Share -->
    <script type="text/javascript" src="//vk.com/js/api/openapi.js?130"></script>
    <!-- Yandex.Metrika counter -->
    <script type="text/javascript" >
        (function(m,e,t,r,i,k,a){m[i]=m[i]||function(){(m[i].a=m[i].a||[]).push(arguments)};
            m[i].l=1*new Date();k=e.createElement(t),a=e.getElementsByTagName(t)[0],k.async=1,k.src=r,a.parentNode.insertBefore(k,a)})
        (window, document, "script", "https://mc.yandex.ru/metrika/tag.js", "ym");

        ym(65073976, "init", {
            clickmap:true,
            trackLinks:true,
            accurateTrackBounce:true
        });
    </script>
    <noscript><div><img src="https://mc.yandex.ru/watch/65073976" style="position:absolute; left:-9999px;" alt="" /></div></noscript>
    <!-- /Yandex.Metrika counter -->
</head>
<body id="page-top" class="index">

<!-- Navigation -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header page-scroll">
            <a class="navbar-brand" href="#page-top"><img src="<c:url value="/favicon.png"/>" class="logo" />PartyPlanner</a>
        </div>
    </div>
</nav>

<!-- Header -->
<header>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="alert alert-info" role="alert">
                    <p>Калькулятор закупки для пикника/шашлыка/пьянки. Находится в разработке, о найденных ошибках просьба сообщать на адрес pavel.proger[собака]gmail.com. Будем рады вашим отзывам и предложениям!</p>
                </div>
            </div>
        </div>
    </div>
</header>

<section id="calcultaion">
    <div class="container">
        <form action="" method="post">
            <div class="row">
                <div class="col-lg-6">
                    <p>Количество гостей</p>
                    <div class="range range-primary">
                        <input name="eaters" type="range" id="eaters" min="3" max="30" value="${foodBean.eaters}" step="1"/>
                        <output data-id="eaters">${foodBean.eaters}</output>
                    </div>
                    <br />
                    <p>Продолжительность (в часах)</p>
                    <div class="range range-success">
                        <input name="duration" type="range" id="duration" min="2" max="12" value="${foodBean.duration}" step="1"/>
                        <output data-id="duration">${foodBean.duration}</output>
                    </div>
                    <br />
                    <p>Прожорливость</p>
                    <div class="range range-warning">
                        <input name="hunger" type="range" min="1" max="2" value="${foodBean.hunger}" step="0.2"/>
                        <output data-id="duration">${foodBean.hunger}</output>
                    </div>
                </div>
                <div class="col-lg-6">
                    <table class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th></th>
                            <th>Продукт</th>
                            <th style="width:30%">Едоков</th>
                            <th>Нужно</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${foodBean.itemList}">
                            <tr>
                                <td>
                                    <div class="quarter quarter-${item.sort}"></div>
                                </td>
                                <td>${item.foodName}</td>
                                <td><input type="text" name="itemMap['${item.id}']" value="${item.eaters}"></td>
                                <td>${item.count}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <input type="submit" value="Рассчитать">
                </div>
            </div>
        </form>
        <div class="row">
            <div class="col-lg-2">
                <div id="vk_like"></div>
                <script type="text/javascript">
                    VK.init({apiId: 5637974, onlyWidgets: true});
                    VK.Widgets.Like("vk_like", {type: "button", height: 20});
                </script>
            </div>
            <div class="col-lg-3">
                <div id="fb-root"></div>
                <script>(function(d, s, id) {
                    var js, fjs = d.getElementsByTagName(s)[0];
                    if (d.getElementById(id)) return;
                    js = d.createElement(s); js.id = id;
                    js.src = "//connect.facebook.net/ru_RU/sdk.js#xfbml=1&version=v2.7";
                    fjs.parentNode.insertBefore(js, fjs);
                }(document, 'script', 'facebook-jssdk'));</script>
                <div class="fb-like" data-href="http://calcparty.ru/" data-width="280" data-layout="standard" data-action="like" data-size="large" data-show-faces="true" data-share="true"></div>
            </div>
            <div class="col-lg-7"></div>
        </div>
    </div>
</section>

<!-- Footer -->
<footer class="text-center">
    <div class="footer-below">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    Copyright &copy; PartyPlanner 2016
                </div>
            </div>
        </div>
    </div>
</footer>

<script src="<c:url value="/js/jquery-3.1.0.min.js"/>"></script>
<script src="<c:url value="/js/bootstrap.min.js"/>"></script>

<script src="<c:url value="/js/jquery-ui-1.12.effect.js.min.js"/>"></script>
<script src="<c:url value="/js/classie.js"/>"></script>
<script src="<c:url value="/js/cbpAnimatedHeader.js"/>"></script>
<script src="<c:url value="/js/freelancer.js"/>"></script>

<script src="<c:url value="/js/main.js"/>"></script>
</body>
</html>