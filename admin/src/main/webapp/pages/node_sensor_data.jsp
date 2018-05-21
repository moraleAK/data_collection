<%@ page import="java.util.List" %>
<%@ page import="com.el.dc.api.entity.NodeInfo" %>
<%@ page import="com.el.dc.api.entity.NodeSensorData" %>
<%@ page import="com.el.dc.admin.util.TimeUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="/js/jquery.min.js"></script>
<html>
<head>
    <meta charset="utf-8">
    <title>传感器信息</title>
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
        <div class="col-xs-6 w-title"><span class="w-title-text">传感器数据</span></div>
    </div>
    <%
        List<NodeSensorData> nodeSensorDatas = (List<NodeSensorData>) request.getAttribute("nodeSensorDatas");
    %>
    <table class="w-table" id="recentRecord">
        <thead>
        <th class="transactionType" style="text-align: left;padding-left: 30px;">id</th>
        <th class="transactionType" style="text-align: left;">设备Id【deviceId】</th>
        <th class="transactionType" style="text-align: left;">时间戳【timestamp】</th>
        <th class="transactionType" style="text-align: left;">PH【PH】</th>
        <th class="transactionType" style="text-align: left;">COD【COD】</th>
        <th class="transactionType" style="text-align: left;">DOG【DOG】</th>
        <th class="transactionType" style="text-align: left;">TEMP【TEMP】</th>
        <th class="transactionType" style="text-align: left;">GPS经度【gpsLongitude】</th>
        <th class="transactionType" style="text-align: left;">GPS纬度【gpsLatitude】</th>
        <th class="transactionType" style="text-align: left;">错误码【errorCode】</th>
        <th class="transactionType" style="text-align: left;">图片名称【pictureName】</th>
        <%--<th class="transactionType" style="text-align: left;"></th>--%>
        </thead>
        <tbody>
        <%
            if (nodeSensorDatas != null && nodeSensorDatas.size() != 0) {
                for (int i = 0; i < nodeSensorDatas.size(); i++) {
        %>
        <tr>
            <td class="transactionType" style="text-align: left;padding-left: 30px;"><%=nodeSensorDatas.get(i).getId()%>
            </td>
            <td class="transactionType" style="text-align: left;padding-left: 30px;"><%=nodeSensorDatas.get(i).getDeviceId()%>
            <td class="transactionType" style="text-align: left;padding-left: 30px;"><%=TimeUtils.timeFormatter(nodeSensorDatas.get(i).getTimestamp())%>
            </td>
            <td class="transactionType" style="text-align: left;"><%=nodeSensorDatas.get(i).getPh()%>
            </td>
            <td class="transactionType" style="text-align: left;"><%=nodeSensorDatas.get(i).getCod()%>
            </td>
            <td class="transactionType" style="text-align: left;"><%=nodeSensorDatas.get(i).getDog()%>
            </td>
            <td class="transactionType" style="text-align: left;"><%=nodeSensorDatas.get(i).getTemp()%>
            <td class="transactionType" style="text-align: left;"><%=nodeSensorDatas.get(i).getGpsLongitude()%>
            <td class="transactionType" style="text-align: left;"><%=nodeSensorDatas.get(i).getGpsLatitude()%>
            <td class="transactionType" style="text-align: left;"><%=nodeSensorDatas.get(i).getErrorCode()%>
            <td class="transactionType" style="text-align: left;"><%=nodeSensorDatas.get(i).getPictureName()%>
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

