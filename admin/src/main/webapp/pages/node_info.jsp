<%@ page import="java.util.List" %>
<%@ page import="com.el.dc.api.entity.NodeInfo" %>
<%@ page import="com.el.dc.admin.util.TimeUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="/js/jquery.min.js"></script>
<html>
<head>
    <meta charset="utf-8">
    <title>设备信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script type="text/javascript" src="../pages/bootstrap/js/bootstrap.min.js"></script>
    <link href="/pages/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="/pages/theme/css/main.css" rel="stylesheet" media="screen">
</head>

<body>
<div class="w-index-dash container-fluid" style="">
    <div class="container container-padding">

    </div>
</div>


<div class="container w-index-chart content">

    <div class="row w-record">
        <div class="col-xs-6 w-title"><span class="w-title-text">设备信息</span></div>
        <%--<div class="col-xs-6 w-more">--%>
            <%--<a href="/pages/node_info_add.jsp" target="_blank"--%>
               <%--class="w-title-text">添加</a>--%>
        <%--</div>--%>
    </div>
    <%
        List<NodeInfo> nodeInfos = (List<NodeInfo>) request.getAttribute("nodeInfos");
    %>
    <table class="w-table" id="recentRecord">
        <thead>
        <th class="transactionType" style="text-align: left;padding-left: 30px;">id</th>
        <th class="transactionType" style="text-align: left;">设备Id【deviceId】</th>
        <th class="transactionType" style="text-align: left;">所属单位【companyName】</th>
        <th class="transactionType" style="text-align: left;">制造商【manufacturer】</th>
        <th class="transactionType" style="text-align: left;">上次接受数据时间【lastDataReceiveTimestamp】</th>
        <th class="transactionType" style="text-align: left;">设备类型【type】</th>
        <%--<th class="transactionType" style="text-align: left;"></th>--%>
        </thead>
        <tbody>
        <%
            if (nodeInfos != null && nodeInfos.size() != 0) {
                for (int i = 0; i < nodeInfos.size(); i++) {
        %>
        <tr>
            <td class="transactionType" style="text-align: left;padding-left: 30px;"><%=nodeInfos.get(i).getId()%>
            </td>
            <td class="transactionType" style="text-align: left;padding-left: 30px;"><%=nodeInfos.get(i).getDeviceId()%>
            </td>
            <td class="transactionType" style="text-align: left;"><%=nodeInfos.get(i).getCompanyName()%>
            </td>
            <td class="transactionType" style="text-align: left;"><%=nodeInfos.get(i).getManufacturer()%>
            </td>
            <td class="transactionType" style="text-align: left;"><%=TimeUtils.timeFormatter(nodeInfos.get(i).getLastDataReceiveTimestamp())%>
            </td>
            <td class="transactionType" style="text-align: left;"><%=nodeInfos.get(i).getType()%>
            <td class="transactionType" style="text-align: left;">
            <%--<a href="/web/edit_student?id=<%=nodeInfos.get(i).getId()%>" target="_blank">编辑</a>--%>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <%
    } else {
    %>
    </tbody>
    </table>
    <div style="text-align: center;height: 40px"><span style="line-height: 40px">无记录</span></div>
    <%
        }
    %>
    <hr>
</div>
</body>
</html>

