<html>
<head>
    <title>JPA测试页面</title>
    <script src="${request.contextPath}/static/js/jquery-1.11.1.min.js"></script>
    <link href="${request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">
        .pageDetail {
            display: none;
        }

        .show {
            display: table-row;
        }
    </style>
    <script>
        $(function () {
            $('#list').click(function () {
                $('.pageDetail').toggleClass('show');
            });
        });

    </script>
</head>
<body>
<div class="wrapper">
    <div class="middle">
        <h1 style="padding: 50px 0 20px;">国家(地区)列表</h1>

        <form action="${request.contextPath}/countries" method="post">
            <table class="gridtable" style="width:100%;">
                <tr>
                    <th>国家(地区)名称：</th>
                    <td><input type="text" name="countryname"
                               value="<#if queryParam.countryname??>${queryParam.countryname}</#if>"/></td>
                    <th>国家(地区)代码：</th>
                    <td><input type="text" name="countrycode"
                               value="<#if queryParam.countrycode??>${queryParam.countrycode}</#if>"/></td>
                    <td rowspan="2"><input type="submit" value="查询"/></td>
                </tr>
                <tr>
                    <th>页码：</th>
                    <td><input type="text" name="page" value="${page!0}"/></td>
                    <th>页面大小：</th>
                    <td><input type="text" name="rows" value="${rows!10}"/></td>
                </tr>
            </table>
        </form>
    <#if pageInfo??>
        <table class="gridtable" style="width:100%;">
            <tr>
                <th colspan="2">分页信息 - [<a href="javascript:;" id="list">展开/收缩</a>]</th>
            </tr>
            <tr class="pageDetail">
                <th style="width: 300px;">当前页号</th>
                <td>${pageInfo.number}</td>
            </tr>
            <tr class="pageDetail">
                <th>页面大小</th>
                <td>${pageInfo.size}</td>
            </tr>
            <tr class="pageDetail">
                <th>总结果数</th>
                <td>${pageInfo.totalElements}</td>
            </tr>
            <tr class="pageDetail">
                <th>总页数</th>
                <td>${pageInfo.totalPages}</td>
            </tr>
            <tr class="pageDetail">
                <th>是否第一页</th>
                <td>${pageInfo.first?c}</td>
            </tr>
            <tr class="pageDetail">
                <th>是否最后一页</th>
                <td>${pageInfo.last?c}</td>
            </tr>
        </table>
        <table class="gridtable" style="width:100%;">
            <#if msg??>
                <tr style="color:red;">
                    <th colspan="5">${msg}</th>
                    <th colspan="5">${code}</th>
                </tr>
            </#if>
        </table>
        <table class="gridtable" style="width:100%;">
            <thead>
            <tr>
                <th colspan="4">查询结果 - [<a href="${request.contextPath}/countries/add">新增国家(地区)</a>]</th>
            </tr>
            <tr>
                <th>ID</th>
                <th>国家(地区)名</th>
                <th>国家(地区)代码</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
                <#list pageInfo.content as country>
                <tr>
                    <td>${country.id}</td>
                    <td>${country.countryname}</td>
                    <td>${country.countrycode}</td>
                    <td style="text-align:center;">[<a
                            href="${request.contextPath}/countries/view/${country.id}">修改</a>] -
                        [<a href="${request.contextPath}/countries/delete/${country.id}">删除</a>]
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
        <table class="gridtable" style="width:100%;text-align: center;">
            <tr>
                <#if !pageInfo.first>
                    <td>
                        <a href="${request.contextPath}/countries?page=1&rows=${pageInfo.size}&countryname=${queryParam.countryname!}&countrycode=${queryParam.countrycode!}">首页</a>
                    </td>
                    <td>
                        <a href="${request.contextPath}/countries?page=${pageInfo.number-1}&rows=${pageInfo.size}&countryname=${queryParam.countryname!}&countrycode=${queryParam.countrycode!}">前一页</a>
                    </td>
                </#if>
                <#if !pageInfo.last>
                    <td>
                        <a href="${request.contextPath}/countries?page=${pageInfo.number+1}&rows=${pageInfo.size}&countryname=<#if queryParam.countryname??>${queryParam.countryname}</#if>&countrycode=<#if queryParam.countrycode??>${queryParam.countrycode}</#if>">下一页</a>
                    </td>
                    <td>
                        <a href="${request.contextPath}/countries?page=${pageInfo.size}&rows=${pageInfo.size}&countryname=<#if queryParam.countryname??>${queryParam.countryname}</#if>&countrycode=<#if queryParam.countrycode??>${queryParam.countrycode}</#if>">尾页</a>
                    </td>
                </#if>
            </tr>
        </table>
    </#if>
    </div>
    <div class="push"></div>
</div>
</body>
</html>