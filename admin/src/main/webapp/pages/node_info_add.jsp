<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../pages/bootstrap/js/bootstrap.min.js"></script>

    <meta name="description" content="">
    <meta name="author" content="">
    <title>设备信息录入</title>
    <link rel="icon" href="../../favicon.ico">
    <link href="/pages/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="/pages/theme/css/main.css" rel="stylesheet" media="screen">
    <script src="/js/jquery.min.js"></script>

</head>

<body style="background-color: #eee">
<%
    //Student student = (Student) request.getAttribute("student");
%>
<form method="post" action="/dc/node_info_add_4_form_data">
    <div style="margin-top: 20px">
        <div class="container content">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">设备信息录入</h3>
                </div>
                <div class="panel-body" style="padding-top: 12px;">
                    <%--<div>
                        <span class="pannel-name">id：</span>
                        <input type="text" id="id" readonly name="name" class="form-control inputbox"/>
                    </div>--%>
                    <div style="padding-bottom: 5px;margin-top: 5px"><b>基本信息</b></div>
                    <div>
                        <span class="pannel-name">设备ID(唯一)【deviceId】：</span>
                        <input type="text" name="deviceId" value="" class="form-control inputbox"/>
                    </div>
                    <div>
                        <span class="pannel-name">软件版本【softwareVersion】：</span>
                        <input type="text" name="softwareVersion" class="form-control inputbox"/>
                    </div>
                    <div>
                        <span class="pannel-name">硬件版本【hardwareVersion】：</span>
                        <input type="text" name="hardwareVersion" class="form-control inputbox"/>
                    </div>
                    <div>
                        <span class="pannel-name">设备类型（int）【type】：</span>
                        <input type="text" name="type" class="form-control inputbox"/>
                    </div>
                    <div>
                        <span class="pannel-name">所属单位【companyName】：</span>
                        <input type="text" name="companyName" class="form-control inputbox"/>
                    </div>
                    <div>
                        <span class="pannel-name">制造商【manufacturer】：</span>
                        <input type="text" name="manufacturer" class="form-control inputbox"/>
                    </div>
                    <div>
                        <span class="pannel-name">销售日期【saleDate】：</span>
                        <input type="text" name="saleDate" class="form-control inputbox"/>
                    </div>
                    <div>
                        <span class="pannel-name">生产日期【productionDate】：</span>
                        <input type="text" name="productionDate" class="form-control inputbox"/>
                    </div>
                    <%--<div>--%>
                        <%--<span class="pannel-name">memo：</span>--%>
                        <%--<input type="text" name="memo" class="form-control inputbox"/>--%>
                    <%--</div>--%>
                    <%--<div style="padding-bottom: 5px;margin-top: 5px"><b>execute params</b></div>--%>
                    <%--<div>--%>
                    <%--<span class="pannel-name">executeType：</span>--%>
                    <%--<select class="form-control inputbox" name="executeType" value="">--%>
                    <%--<option value="1">Hibernate</option>--%>
                    <%--<option value="2">Jdbc</option>--%>
                    <%--</select>--%>
                    <%--</div>--%>
                    <%--<div>--%>
                    <%--<span class="pannel-name">readonly：</span>--%>
                    <%--<select class="form-control inputbox" name="readonly" value="">--%>
                    <%--<option value="false">false</option>--%>
                    <%--<option value="true">true </option>--%>
                    <%--</select>--%>
                    <%--</div>--%>
                    <td style="min-width: 180px;border-bottom: 1px solid #ddd;"></td>
                    <td width="70%" style="border-bottom: 1px solid #ddd">
                        <div><span style="color: red">${error}</span></div>
                    </td>
                    <td width="30%" style="border-bottom: 1px solid #ddd;"></td>
                </div>

                <div class="panel-footer" style="text-align: right;">
                    <%--<a href="/web/load_students" class="btn btn-default" style="margin-right: 15px;width:120px;">返回</a>--%>
                    <input type="submit" class="btn btn-primary btn-padding" style="width: 120px;"/>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
</script>
