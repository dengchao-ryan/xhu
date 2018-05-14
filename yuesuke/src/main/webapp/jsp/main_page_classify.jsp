<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商品分类页面</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main_page_css.css"/>
</head>

<body>

<jsp:include page="head_page.jsp" flush="true"/>


<div>

</div>

<div class="goods-display">

    <ul class="goods-display">
        <%--//循环输出一个商品框，数据由数据库查询包含名字.价格.库存--%>
        <c:forEach items="${mainList}" var="entry">
            <form id="cratGoods" name="cratGoods" action="${pageContext.request.contextPath}/mainAction!cart.do?op=add" target="posthere" method="post">
                <ui class="view">
                    <div class="imgLink">
                        <img src="${pageContext.request.contextPath}/img/beauty.jpg"/></div>
                    <div class="info">
                        <span class="price">¥  <strong class="price_st">${entry.price}</strong></span>

                        <div class="button">
                            <input type='submit' id='cart' value='添加购物车'>
                        </div>
                        <br/>

                        <div class="goodsName"><span class="name">商品名称:${entry.name}</span></div>
                        <ul class="nameNum">
                            <li><span class="storeName">${entry.storeName}</span></li>
                            <li><span class="num">库存:${entry.number}</span></li>
                        </ul>
                    </div>
                </ui>
                    <%--//为JS获取数据--%>
                <input type="hidden" name="priceName" value="${entry.price}">
                <input type="hidden" name="nameName" value="${entry.name}">
                <input type="hidden" name="numberName" value="${entry.number}">
                <input type="hidden" name="storeNameName" value="${entry.storeName}">
                <input type="hidden" name="idName" value="${entry.inventoryId}">
            </form>
        </c:forEach>
        <iframe name="posthere" frameborder=0 width=0 height=0></iframe>
    </ul>
</div>

<script type="text/javascript">
    $('#cart').live("click", function () {
        //获取商品的价格，名字，店铺，库存
        var nameStr = document.getElementsByName("nameName")[0].value;
        //输出商品名
        var goodsCart = "商品:" + nameStr + "\n添加到购物车成功!";
        alert(goodsCart);
        //将数据传到另一个页面
        var url = '${pageContext.request.contextPath}/mainAction!cart.do?op=add';
        var data = {
            'nameStr': entry.name,
            'priceStr': entry.price,
            'numberStr': entry.number,
            'storeNameStr': entry.storeName,
            'idStr': entry.invertoryId,
            'op': 'add'
        };
        var success = function (response) {
            if (response.errno == 0) {
                alert(response.errmsg);
            }
        };
        $.post(url, data, success, 'json');
    });
</script>

<div class="wit">
    <div class="limit">
        <form class="form" name="f1" method="POST" action="${pageContext.request.contextPath}/mainAction!classifyLimit.do?present=${present}&&type=${type}">
            <table border="0" align="center" class="tb">
                <tr>
                    <td><span class="page-size">当前第 ${present} 页       共 ${total} 页</span>></td>
                    <td><a href="${pageContext.request.contextPath}/mainAction!classifyLimit.do?page=start&&present=${present}&&type=${type}">首页</a></td>
                    <td><a href="${pageContext.request.contextPath}/mainAction!classifyLimit.do?page=last&&present=${present}&&type=${type}"> 上一页</a></td>
                    <td><a href="${pageContext.request.contextPath}/mainAction!classifyLimit.do?page=next&&present=${present}&&type=${type}"> 下一页</a></td>
                    <td><a href="${pageContext.request.contextPath}/mainAction!classifyLimit.do?page=end&&present=${present}&&type=${type}">最后一页</a></td>
                    <td>转到第:<input type="text" name="page" size="8"
                                   onkeypress="return event.keyCode>=48&&event.keyCode<=57" ng-pattern="/[^a-zA-Z]/"/>页
                        <input type="submit" value="GO" name="GO"></td>
                </tr>
            </table>
        </form>
    </div>
</div>


</body>
</html>