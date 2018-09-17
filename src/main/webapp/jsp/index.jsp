<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!-- 奇怪了，为什么不需要呢?-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>mystores</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css"/>
    <script src="/js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="/js/bootstrap.min.js" type="text/javascript"></script>
</head>

<body>
<div class="container-fluid">

    <!--
        时间：2015-12-30
        描述：菜单栏
    -->

    <!--
        时间：2015-12-30
        描述：导航条
    -->
    <%@include file="head.jsp" %>

    <!--
        作者：ci2713@163.com
        时间：2015-12-30
        描述：轮播条
    -->
    <div class="container-fluid">
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img src="/img/1.jpg">
                    <div class="carousel-caption">

                    </div>
                </div>
                <div class="item">
                    <img src="/img/2.jpg">
                    <div class="carousel-caption">

                    </div>
                </div>
                <div class="item">
                    <img src="/img/3.jpg">
                    <div class="carousel-caption">

                    </div>
                </div>
            </div>

            <!-- Controls -->
            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
    <!--
        作者：ci2713@163.com
        时间：2015-12-30
        描述：商品显示
    -->
    <div class="container-fluid">
        <div class="col-md-12">
            <h2>热门商品&nbsp;&nbsp;<img src="/img/title2.jpg"/></h2>
        </div>
        <div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
            <img src="/products/hao/big01.jpg" width="205" height="404" style="display: inline-block;"/>
        </div>
        <div class="col-md-10">
            <div class="col-md-6" style="text-align:center;height:200px;padding:0px;">
                <a href="product_info.htm">
                    <img src="/products/hao/middle01.jpg" width="516px" height="200px" style="display: inline-block;">
                </a>
            </div>
                      <c:if test="${not empty hotList}">
                <c:forEach items="${hotList}" var="product">
                    <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
                        <a href="product_info.htm">
                            <img src="${product.pimage}" width="130" height="130"
                                 style="display: inline-block;">
                        </a>
                        <p><a href="product_info.html" style='color:#666'>${product.pname}</a></p>
                        <p><font color="#E4393C" style="font-size:16px">${product.shop_price}</font></p>
                    </div>
                </c:forEach>
            </c:if>
            <%--            <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
                <a href="product_info.htm">
                    <img src="/products/hao/small03.jpg" width="130" height="130" style="display: inline-block;">
                </a>
                <p><a href="product_info.html" style='color:#666'>冬瓜</a></p>
                <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
            </div>

            <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
                <a href="product_info.htm">
                    <img src="/products/hao/small04.jpg" width="130" height="130" style="display: inline-block;">
                </a>
                <p><a href="product_info.html" style='color:#666'>冬瓜</a></p>
                <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
            </div>

            <div class="col-md-2 yes-right-border" style="text-align:center;height:200px;padding:10px 0px;">
                <a href="product_info.htm">
                    <img src="/products/hao/small05.jpg" width="130" height="130" style="display: inline-block;">
                </a>
                <p><a href="product_info.html" style='color:#666'>冬瓜</a></p>
                <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
            </div>

            <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
                <a href="product_info.htm">
                    <img src="/products/hao/small03.jpg" width="130" height="130" style="display: inline-block;">
                </a>
                <p><a href="product_info.html" style='color:#666'>冬瓜</a></p>
                <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
            </div>

            <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
                <a href="product_info.htm">
                    <img src="/products/hao/small04.jpg" width="130" height="130" style="display: inline-block;">
                </a>
                <p><a href="product_info.html" style='color:#666'>冬瓜</a></p>
                <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
            </div>

            <div class="col-md-2 yes-right-border" style="text-align:center;height:200px;padding:10px 0px;">
                <a href="product_info.htm">
                    <img src="/products/hao/small05.jpg" width="130" height="130" style="display: inline-block;">
                </a>
                <p><a href="product_info.html" style='color:#666'>冬瓜</a></p>
                <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
            </div>
            <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
                <a href="product_info.htm">
                    <img src="/products/hao/small03.jpg" width="130" height="130" style="display: inline-block;">
                </a>
                <p><a href="product_info.html" style='color:#666'>冬瓜</a></p>
                <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
            </div>

            <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
                <a href="product_info.htm">
                    <img src="/products/hao/small04.jpg" width="130" height="130" style="display: inline-block;">
                </a>
                <p><a href="product_info.html" style='color:#666'>冬瓜</a></p>
                <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
            </div>

            <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
                <a href="product_info.htm">
                    <img src="/products/hao/small05.jpg" width="130" height="130" style="display: inline-block;">
                </a>
                <p><a href="product_info.html" style='color:#666'>冬瓜</a></p>
                <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
            </div>--%>
        </div>
    </div>
    <!--
        作者：ci2713@163.com
        时间：2015-12-30
        描述：广告部分
    -->
    <div class="container-fluid">
        <img src="/products/hao/ad.jpg" width="100%"/>
    </div>
    <!--
        作者：ci2713@163.com
        时间：2015-12-30
        描述：商品显示
    -->
    <div class="container-fluid">
        <div class="col-md-12">
            <h2>热门商品&nbsp;&nbsp;<img src="/img/title2.jpg"/></h2>
        </div>
        <div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
            <img src="/products/hao/big01.jpg" width="205" height="404" style="display: inline-block;"/>
        </div>
        <div class="col-md-10">
            <div class="col-md-6" style="text-align:center;height:200px;padding:0px;">
                <a href="product_info.htm">
                    <img src="/products/hao/middle01.jpg" width="516px" height="200px" style="display: inline-block;">
                </a>
            </div>
            <c:if test="${not empty newList}">
            <c:forEach items="${newList}" var="product1">
            <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
                <a href="product_info.htm">
                    <img src="${product1.pimage}" width="130" height="130" style="display: inline-block;">
                </a>
                <p><a href="product_info.html" style='color:#666'>${product1.pname}</a></p>
                <p><font color="#E4393C" style="font-size:16px">&yen;${product1.shop_price}</font></p>
            </div>
            </c:forEach>
            </c:if>
<%--            <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
                <a href="product_info.htm">
                    <img src="/products/hao/small03.jpg" width="130" height="130" style="display: inline-block;">
                </a>
                <p><a href="product_info.html" style='color:#666'>冬瓜</a></p>
                <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
            </div>

            <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
                <a href="product_info.htm">
                    <img src="/products/hao/small04.jpg" width="130" height="130" style="display: inline-block;">
                </a>
                <p><a href="product_info.html" style='color:#666'>冬瓜</a></p>
                <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
            </div>

            <div class="col-md-2 yes-right-border" style="text-align:center;height:200px;padding:10px 0px;">
                <a href="product_info.htm">
                    <img src="/products/hao/small05.jpg" width="130" height="130" style="display: inline-block;">
                </a>
                <p><a href="product_info.html" style='color:#666'>冬瓜</a></p>
                <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
            </div>

            <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
                <a href="product_info.htm">
                    <img src="/products/hao/small03.jpg" width="130" height="130" style="display: inline-block;">
                </a>
                <p><a href="product_info.html" style='color:#666'>冬瓜</a></p>
                <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
            </div>

            <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
                <a href="product_info.htm">
                    <img src="/products/hao/small04.jpg" width="130" height="130" style="display: inline-block;">
                </a>
                <p><a href="product_info.html" style='color:#666'>冬瓜</a></p>
                <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
            </div>

            <div class="col-md-2 yes-right-border" style="text-align:center;height:200px;padding:10px 0px;">
                <a href="product_info.htm">
                    <img src="/products/hao/small05.jpg" width="130" height="130" style="display: inline-block;">
                </a>
                <p><a href="product_info.html" style='color:#666'>冬瓜</a></p>
                <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
            </div>
            <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
                <a href="product_info.htm">
                    <img src="/products/hao/small03.jpg" width="130" height="130" style="display: inline-block;">
                </a>
                <p><a href="product_info.html" style='color:#666'>冬瓜</a></p>
                <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
            </div>

            <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
                <a href="product_info.htm">
                    <img src="/products/hao/small04.jpg" width="130" height="130" style="display: inline-block;">
                </a>
                <p><a href="product_info.html" style='color:#666'>冬瓜</a></p>
                <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
            </div>

            <div class="col-md-2 yes-right-border" style="text-align:center;height:200px;padding:10px 0px;">
                <a href="product_info.htm">
                    <img src="/products/hao/small05.jpg" width="130" height="130" style="display: inline-block;">
                </a>
                <p><a href="product_info.html" style='color:#666'>冬瓜</a></p>
                <p><font color="#E4393C" style="font-size:16px">&yen;299.00</font></p>
            </div>--%>
        </div>
    </div>
    <!--
        作者：ci2713@163.com
        时间：2015-12-30
        描述：页脚部分
    -->
    <div class="container-fluid">
        <div style="margin-top:50px;">
            <img src="/img/footer.jpg" width="100%" height="78" alt="我们的优势" title="我们的优势"/>
        </div>

        <div style="text-align: center;margin-top: 5px;">
            <ul class="list-inline">
                <li><a href="info.html">关于我们</a></li>
                <li><a>联系我们</a></li>
                <li><a>招贤纳士</a></li>
                <li><a>法律声明</a></li>
                <li><a>友情链接</a></li>
                <li><a>支付方式</a></li>
                <li><a>配送方式</a></li>
                <li><a>服务声明</a></li>
                <li><a>广告声明</a></li>
            </ul>
        </div>
        <div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
            Copyright &copy; 2005-2018 测试商城 版权所有
        </div>
    </div>
</div>
</body>

</html>