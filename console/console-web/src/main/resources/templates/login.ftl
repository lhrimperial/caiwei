<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>console系统</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="keywords" content="vue.js, wms, vue2, 后台模板, 管理系统, element">
    <meta name="description" content="基于Vue2 + Element UI 的后台管理系统解决方案">
<#include "common/common.ftl">
<#include "common/head.ftl">
    <script type="text/javascript">
        function login(){
            var userVO = {
                userCode: Ext.getDom('userCode').value,
                passWord: Ext.getDom('passWord').value
            }
            var successFun = function(json) {
                window.location.href = "main";
            };
            var failureFun = function(json) {
                if (Ext.isEmpty(json)) {
                    document.getElementById("msg").innerText = "连接超时!";
                } else {
                    var message = json.resMsg;
                    //Caiwei.showErrorMes(message); // 提示失败原因
                    document.getElementById("msg").innerText = message+"!";
                }
            };
            console.requestJsonAjax('login', userVO, successFun, failureFun); // 发送AJAX请求
        }
    </script>
    <style type="text/css">
		* {
        margin: 0;
        padding: 0;
    }

    html, body, #app, .wrapper {
        width: 100%;
        height: 100%;
        overflow: hidden;
    }

    body {
        font-family: "Helvetica Neue", Helvetica, "microsoft yahei", arial, STHeiTi, sans-serif;
    }

    a {
        text-decoration: none
    }



    .el-button + .el-tooltip {
        margin-left: 10px;
    }

    .el-table tr:hover {
        background: #f6faff;
    }


    .form-box .line {
        text-align: center;
    }


    /*Readme*/
    .ms-doc .el-checkbox__input.is-disabled + .el-checkbox__label {
        color: #333;
        cursor: pointer;
    }


    .g-core-image-corp-container .info-aside {
        height: 45px;
    }


    .el-upload--text .el-icon-upload {
        font-size: 67px;
        color: #97a8be;
        margin: 40px 0 16px;
        line-height: 50px;
    }


    .el-upload--text em {
        font-style: normal;
    }


    .ql-snow .ql-tooltip {
        transform: translateX(117.5px) translateY(10px) !important;
    }
    /*# sourceURL=C:/YihooIsMe/codes/project/vue-manage-system/vue-manage-system/static/css/main.css */
    /*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIkM6L1lpaG9vSXNNZS9jb2Rlcy9wcm9qZWN0L3Z1ZS1tYW5hZ2Utc3lzdGVtL3Z1ZS1tYW5hZ2Utc3lzdGVtL3N0YXRpYy9jc3MvbWFpbi5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUEsRUFBRSxTQUFTLFVBQVUsQ0FBQztBQUN0QjtJQUNJLFdBQVc7SUFDWCxZQUFZO0lBQ1osaUJBQWlCO0NBQ3BCO0FBQ0Q7SUFDSSxzRkFBc0Y7Q0FDekY7QUFDRCxFQUFFLHFCQUFxQixDQUFDO0FBQ3hCO0lBQ0ksd0NBQXdDO0lBQ3hDLG1CQUFtQjtJQUNuQixZQUFZO0lBQ1osU0FBUztJQUNULFVBQVU7SUFDVixTQUFTO0lBQ1QsWUFBWTtJQUNaLGFBQWE7SUFDYix1QkFBdUI7SUFDdkIsbUJBQW1CO0NBQ3RCO0FBQ0Q7SUFDSSxvQkFBb0I7Q0FDdkI7QUFDRDtJQUNJLGVBQWU7SUFDZixrQkFBa0I7Q0FDckI7QUFDRDtJQUNJLGtCQUFrQjtJQUNsQixvQkFBb0I7Q0FDdkI7QUFDRDtJQUNJLGtCQUFrQjtDQUNyQjs7QUFFRDtJQUNJLG9CQUFvQjtDQUN2QjtBQUNEO0lBQ0ksb0JBQW9CO0NBQ3ZCOztBQUVEO0lBQ0ksd0JBQXdCO0NBQzNCO0FBQ0Q7SUFDSSxXQUFXO0NBQ2Q7QUFDRCxZQUFZO0FBQ1o7SUFDSSxZQUFZO0NBQ2Y7QUFDRDtJQUNJLG1CQUFtQjtDQUN0QjtBQUNEO0lBQ0ksaUJBQWlCO0NBQ3BCO0FBQ0QsVUFBVTtBQUNWO0lBQ0ksWUFBWTtJQUNaLGdCQUFnQjtDQUNuQjtBQUNELFVBQVU7QUFDVjtJQUNJLFlBQVk7SUFDWixZQUFZO0lBQ1osa0JBQWtCO0lBQ2xCLG1CQUFtQjtJQUNuQixZQUFZO0lBQ1osbUJBQW1CO0NBQ3RCO0FBQ0Q7SUFDSSxZQUFZO0NBQ2Y7QUFDRDtJQUNJLHVCQUF1QjtJQUN2QiwyQkFBMkI7SUFDM0IsbUJBQW1CO0lBQ25CLHVCQUF1QjtJQUN2QixhQUFhO0lBQ2IsY0FBYztJQUNkLG1CQUFtQjtJQUNuQixnQkFBZ0I7SUFDaEIsbUJBQW1CO0lBQ25CLGlCQUFpQjtDQUNwQjtBQUNEO0lBQ0ksZ0JBQWdCO0lBQ2hCLGVBQWU7SUFDZixvQkFBb0I7SUFDcEIsa0JBQWtCO0NBQ3JCO0FBQ0Q7SUFDSSxlQUFlO0lBQ2YsZ0JBQWdCO0lBQ2hCLG1CQUFtQjtDQUN0QjtBQUNEO0lBQ0ksbUJBQW1CO0NBQ3RCO0FBQ0QsYUFBYTtBQUNiO0lBQ0ksa0JBQWtCO0NBQ3JCO0FBQ0Q7SUFDSSwyREFBMkQ7Q0FDOUQ7QUFDRDtJQUNJLGlCQUFpQjtDQUNwQiIsImZpbGUiOiJtYWluLmNzcyIsInNvdXJjZXNDb250ZW50IjpbIip7bWFyZ2luOjA7cGFkZGluZzowO31cclxuaHRtbCxib2R5LCNhcHAsLndyYXBwZXJ7XHJcbiAgICB3aWR0aDoxMDAlO1xyXG4gICAgaGVpZ2h0OjEwMCU7XHJcbiAgICBvdmVyZmxvdzogaGlkZGVuO1xyXG59XHJcbmJvZHl7XHJcbiAgICBmb250LWZhbWlseTpcIkhlbHZldGljYSBOZXVlXCIsSGVsdmV0aWNhLCBcIm1pY3Jvc29mdCB5YWhlaVwiLCBhcmlhbCwgU1RIZWlUaSwgc2Fucy1zZXJpZjtcclxufVxyXG5he3RleHQtZGVjb3JhdGlvbjogbm9uZX1cclxuLmNvbnRlbnR7XHJcbiAgICBiYWNrZ3JvdW5kOiBub25lIHJlcGVhdCBzY3JvbGwgMCAwICNmZmY7XHJcbiAgICBwb3NpdGlvbjogYWJzb2x1dGU7XHJcbiAgICBsZWZ0OiAyNTBweDtcclxuICAgIHJpZ2h0OiAwO1xyXG4gICAgdG9wOiA3MHB4O1xyXG4gICAgYm90dG9tOjA7XHJcbiAgICB3aWR0aDogYXV0bztcclxuICAgIHBhZGRpbmc6NDBweDtcclxuICAgIGJveC1zaXppbmc6IGJvcmRlci1ib3g7XHJcbiAgICBvdmVyZmxvdy15OiBzY3JvbGw7XHJcbn1cclxuLmNydW1ic3tcclxuICAgIG1hcmdpbi1ib3R0b206IDIwcHg7XHJcbn1cclxuLnBhZ2luYXRpb257XHJcbiAgICBtYXJnaW46IDIwcHggMDtcclxuICAgIHRleHQtYWxpZ246IHJpZ2h0O1xyXG59XHJcbi5wbHVnaW5zLXRpcHN7XHJcbiAgICBwYWRkaW5nOjIwcHggMTBweDtcclxuICAgIG1hcmdpbi1ib3R0b206IDIwcHg7XHJcbn1cclxuLmVsLWJ1dHRvbisuZWwtdG9vbHRpcCB7XHJcbiAgICBtYXJnaW4tbGVmdDogMTBweDtcclxufVxyXG5cclxuLmVsLXRhYmxlIHRyOmhvdmVye1xyXG4gICAgYmFja2dyb3VuZDogI2Y2ZmFmZjtcclxufVxyXG4ubWdiMjB7XHJcbiAgICBtYXJnaW4tYm90dG9tOiAyMHB4O1xyXG59XHJcblxyXG4ubW92ZS1lbnRlci1hY3RpdmUsLm1vdmUtbGVhdmUtYWN0aXZle1xyXG4gICAgdHJhbnNpdGlvbjogb3BhY2l0eSAuNXM7XHJcbn1cclxuLm1vdmUtZW50ZXIsLm1vdmUtbGVhdmV7XHJcbiAgICBvcGFjaXR5OiAwO1xyXG59XHJcbi8qQmFzZUZvcm0qL1xyXG4uZm9ybS1ib3h7XHJcbiAgICB3aWR0aDo2MDBweDtcclxufVxyXG4uZm9ybS1ib3ggLmxpbmV7XHJcbiAgICB0ZXh0LWFsaWduOiBjZW50ZXI7XHJcbn1cclxuLmVsLXRpbWUtcGFuZWxfX2NvbnRlbnQ6OmFmdGVyLCAuZWwtdGltZS1wYW5lbF9fY29udGVudDo6YmVmb3JlIHtcclxuICAgIG1hcmdpbi10b3A6IC03cHg7XHJcbn1cclxuLypSZWFkbWUqL1xyXG4ubXMtZG9jIC5lbC1jaGVja2JveF9faW5wdXQuaXMtZGlzYWJsZWQrLmVsLWNoZWNrYm94X19sYWJlbHtcclxuICAgIGNvbG9yOiAjMzMzO1xyXG4gICAgY3Vyc29yOiBwb2ludGVyO1xyXG59XHJcbi8qVXBsb2FkKi9cclxuLnB1cmUtYnV0dG9ue1xyXG4gICAgd2lkdGg6MTUwcHg7XHJcbiAgICBoZWlnaHQ6NDBweDtcclxuICAgIGxpbmUtaGVpZ2h0OiA0MHB4O1xyXG4gICAgdGV4dC1hbGlnbjogY2VudGVyO1xyXG4gICAgY29sb3I6ICNmZmY7XHJcbiAgICBib3JkZXItcmFkaXVzOiAzcHg7XHJcbn1cclxuLmctY29yZS1pbWFnZS1jb3JwLWNvbnRhaW5lciAuaW5mby1hc2lkZXtcclxuICAgIGhlaWdodDo0NXB4O1xyXG59XHJcbi5lbC11cGxvYWQtLXRleHQge1xyXG4gICAgYmFja2dyb3VuZC1jb2xvcjogI2ZmZjtcclxuICAgIGJvcmRlcjogMXB4IGRhc2hlZCAjZDlkOWQ5O1xyXG4gICAgYm9yZGVyLXJhZGl1czogNnB4O1xyXG4gICAgYm94LXNpemluZzogYm9yZGVyLWJveDtcclxuICAgIHdpZHRoOiAzNjBweDtcclxuICAgIGhlaWdodDogMTgwcHg7XHJcbiAgICB0ZXh0LWFsaWduOiBjZW50ZXI7XHJcbiAgICBjdXJzb3I6IHBvaW50ZXI7XHJcbiAgICBwb3NpdGlvbjogcmVsYXRpdmU7XHJcbiAgICBvdmVyZmxvdzogaGlkZGVuO1xyXG59XHJcbi5lbC11cGxvYWQtLXRleHQgLmVsLWljb24tdXBsb2FkIHtcclxuICAgIGZvbnQtc2l6ZTogNjdweDtcclxuICAgIGNvbG9yOiAjOTdhOGJlO1xyXG4gICAgbWFyZ2luOiA0MHB4IDAgMTZweDtcclxuICAgIGxpbmUtaGVpZ2h0OiA1MHB4O1xyXG59XHJcbi5lbC11cGxvYWQtLXRleHQge1xyXG4gICAgY29sb3I6ICM5N2E4YmU7XHJcbiAgICBmb250LXNpemU6IDE0cHg7XHJcbiAgICB0ZXh0LWFsaWduOiBjZW50ZXI7XHJcbn1cclxuLmVsLXVwbG9hZC0tdGV4dCBlbSB7XHJcbiAgICBmb250LXN0eWxlOiBub3JtYWw7XHJcbn1cclxuLypWdWVFZGl0b3IqL1xyXG4ucWwtY29udGFpbmVye1xyXG4gICAgbWluLWhlaWdodDogNDAwcHg7XHJcbn1cclxuLnFsLXNub3cgLnFsLXRvb2x0aXB7XHJcbiAgICB0cmFuc2Zvcm06IHRyYW5zbGF0ZVgoMTE3LjVweCkgdHJhbnNsYXRlWSgxMHB4KSAhaW1wb3J0YW50O1xyXG59XHJcbi5lZGl0b3ItYnRue1xyXG4gICAgbWFyZ2luLXRvcDogMjBweDtcclxufSJdLCJzb3VyY2VSb290IjoiIn0= */</style>
    <style type="text/css">
		.header {
        background-color: #242f42;
    }

    .login-wrap {
        background: #324157;
    }


    .plugins-tips a {
        color: #20a0ff;
    }

    .el-upload--text em {
        color: #20a0ff;
    }


    /*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIkM6L1lpaG9vSXNNZS9jb2Rlcy9wcm9qZWN0L3Z1ZS1tYW5hZ2Utc3lzdGVtL3Z1ZS1tYW5hZ2Utc3lzdGVtL3N0YXRpYy9jc3MvY29sb3ItZGFyay5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7SUFDSSwwQkFBMEI7Q0FDN0I7QUFDRDtJQUNJLG9CQUFvQjtDQUN2QjtBQUNEO0lBQ0ksb0JBQW9CO0NBQ3ZCO0FBQ0Q7SUFDSSxlQUFlO0NBQ2xCO0FBQ0Q7SUFDSSxlQUFlO0NBQ2xCO0FBQ0Q7SUFDSSxvQkFBb0I7Q0FDdkIiLCJmaWxlIjoiY29sb3ItZGFyay5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIuaGVhZGVye1xyXG4gICAgYmFja2dyb3VuZC1jb2xvcjogIzI0MmY0MjtcclxufVxyXG4ubG9naW4td3JhcHtcclxuICAgIGJhY2tncm91bmQ6ICMzMjQxNTc7XHJcbn1cclxuLnBsdWdpbnMtdGlwc3tcclxuICAgIGJhY2tncm91bmQ6ICNlZWYxZjY7XHJcbn1cclxuLnBsdWdpbnMtdGlwcyBhe1xyXG4gICAgY29sb3I6ICMyMGEwZmY7XHJcbn1cclxuLmVsLXVwbG9hZC0tdGV4dCBlbSB7XHJcbiAgICBjb2xvcjogIzIwYTBmZjtcclxufVxyXG4ucHVyZS1idXR0b257XHJcbiAgICBiYWNrZ3JvdW5kOiAjMjBhMGZmO1xyXG59Il0sInNvdXJjZVJvb3QiOiIifQ== */</style>
    <style type="text/css">@charset "UTF-8";
    .el-checkbox__original, .el-pagination--small .arrow.disabled, .el-table .hidden-columns, .el-table td.is-hidden > *, .el-table th.is-hidden > * {
        visibility: hidden
    }

    .el-form-item__content:after {
        clear: both
    }

    .el-form-item:after {
        clear: both
    }

    .el-autocomplete-suggestion.is-loading li:after {
        display: inline-block;
        content: "";
        height: 100%;
        vertical-align: middle
    }

    @font-face {
        font-family: element-icons;
        src: url(data:application/font-woff;base64,d09GRgABAAAAAB9EABAAAAAANAAAAQAAAAAAAAAAAAAAAAAAAAAAAAAAAABGRlRNAAABbAAAABoAAAAcdCWJ3kdERUYAAAGIAAAAHQAAACAAWAAET1MvMgAAAagAAABNAAAAYFdvXOBjbWFwAAAB+AAAAFAAAAFS5mHtc2N2dCAAAAJIAAAAGAAAACQNZf70ZnBnbQAAAmAAAAT8AAAJljD3npVnYXNwAAAHXAAAAAgAAAAIAAAAEGdseWYAAAdkAAAUPAAAIUw4RPqwaGVhZAAAG6AAAAAvAAAANgxJKwtoaGVhAAAb0AAAAB4AAAAkCQwFDGhtdHgAABvwAAAAVgAAAKyk5AaSbG9jYQAAHEgAAABYAAAAWJwQpAxtYXhwAAAcoAAAACAAAAAgAU4CJG5hbWUAABzAAAABNQAAAit/uX3PcG9zdAAAHfgAAACyAAABsMLAXoJwcmVwAAAerAAAAJUAAACVpbm+ZnicY2BgYGQAgjO2i86D6MufP7fDaABY8wj8AAB4nGNgZGBg4ANiCQYQYGJgBEItIGYB8xgABhgAXQAAAHicY2Bh4WX8wsDKwMA0k+kMAwNDP4RmfM1gzMgJFGVgY2aAAUYBBgQISHNNYTjAUPFMnbnhfwNDDHMDQwNIDUiOWQKsRIGBEQCQ/wz4AAAAeJxjYGBgZoBgGQZGBhDwAfIYwXwWBgMgzQGETEC64pnKM/X//8Eshmdq////75ZikWKG6gIDRjYGOJcRpIeJARUwMtAMMNPOaJIAAAr1C6J4nGNgQANGDEbMEv8fMjf8b4DRAEVmCF94nJ1VaXfTRhSVvGRP2pLEUETbMROnNBqZsAUDLgQpsgvp4kBoJegiJzFd+AN87Gf9mqfQntOP/LTeO14SWnpO2xxL776ZO2/TexNxjKjseSCuUUdKXveksv5UKvGzpK7rXp4o6fWSumynnpIWUStNlczF/SO5RHUuVrJJsEnG616inqs874PSSzKsKEsi2iLayrwsTVNPHD9NtTi9ZJCmgZSMgp1Ko48QqlEvkaoOZUqHXr2eipsFUjYa8aijonoQKu4czzmljTpgpHKVw1yxWW3ke0nW8/qP0kSn2Nt+nGDDY/QjV4FUjMzA9jQeh08k09FeIjORf+y4TpSFUhtcAK9qsMegSvGhuPFBthPI1HjN8XVRqTQyFee6z7LZLB2PlRDlwd/YoZQbur+Ds9OmqFZjcfvAMwY5KZQoekgWgA5Tmaf2CNo8tEBmjfqj4hzwdQgvshBlKs+ULOhQBzJndveTYtrdSddkcaBfBjJvdveS3cfDRa+O9WW7vmAKZzF6khSLixHchzLrp0y71AhHGRdzwMU8XuLWtELIyAKMSiPMUVv4ntmoa5wdY290Ho/VU2TSRfzdTH49OKlY4TjLekfcSJy7x67rwlUgiwinGu8njizqUGWw+vvSkussOGGYZ8VCxZcXvncR+S8xbj+Qd0zhUr5rihLle6YoU54xRYVyGYWlXDHFFOWqKaYpa6aYoTxrilnKc0am/X/p+334Pocz5+Gb0oNvygvwTfkBfFN+CN+UH8E3pYJvyjp8U16Eb0pt4G0pUxGqmLF0+O0lWrWhajkzuMA+D2TNiPZFbwTSMEp11Ukpdb+lVf4k+euix2Prk5K6NWlsiLu6abP4+HTGb25dMuqGnatPjCPloT109dg0oVP7zeHfzl3dKi65q4hqw6g2IpgEgDbotwLxTfNsOxDzll18/EMwAtTPqTVUU3Xt1JUaD/K8q7sYnuTA44hjoI3rrq7ASxNTVkPz4WcpMhX7g7yplWrnsHX5ZFs1hzakwtsi9pVknKbtveRVSZWV96q0Xj6fhiF6ehbXhLZs3cmkEqFRM87x8K4qRdmRlnLUP0Lnl6K+B5xxdkHrwzHuRN1BtTXsdPj5ZiNrCyaGprS9E6BkLF0VY1HlWZxjdA1rHW/cEp6upycW8Sk2mY/CSnV9lI9uI80rdllm0ahKdXSX9lnsqzb9MjtoWB1nP2mqNu7qYVuNKlI9Vb4GtAd2Vt34UA8rPuqgUVU12+jayGM0LmvGfwzIYlz560arJtPv4JZqp81izV1Bc9+YLPdOL2+9yX4r56aRpv9Woy0jl/0cjvltEeDfOSh2U9ZAvTVpiHEB2QsYLtVE5w7N3cYg4jr7H53T/W/NwiA5q22N2Tz14erpKJI7THmcZZtZ1vUozVG0k8Q+RWKrw4nBTY3hWG7KBgbk7j+s38M94K4siw+8bSSAuM/axKie6uDuHlcjNOwruQ8YmWPHuQ2wA+ASxObYtSsdALvSJecOwGfkEDwgh+AhOQS75NwE+Jwcgi/IIfiSHIKvyLkF0COHYI8cgkfkEDwmpw2wTw7BE3IIviaH4BtyWgAJOQQpOQRPySF4ZmRzUuZvqch1oO8sugH0ve0aKFtQfjByZcLOqFh23yKyDywi9dDI1Qn1iIqlDiwi9blFpP5o5NqE+hMVS/3ZIlJ/sYjUF8aXmYGU13oveUcHfwIrvqx+AAEAAf//AA94nKVaC3Bc1Xk+/zn3uXe1e3fva6V9aXe1u5JWXq32aUlIun7IGGTZlsAPGTABHEUOIQkUcAgMESUEKMnQItl0SId2mEwyzWNipqV5kpB0ChNDQzLBtBPaztQJM23iaWdo+gi1rvufu7ItOWCcZnX3nHPP8z/nf33/WRFKsoRAlX6RMCKTPrdACGGUsH2EAtApQinsErAEWwiRJVHAbiwihku1SCZSrEVyWdD/7ZVX6BdX9mbpPI4VycDZf2bfZjFikwoZIbPkIByZOm7s3u9eTYF0hDpIaJ6wEITYQQKKAtfroCoBST0YgaAkSMGDRBO0w2FQiBRUpP0kIItU0ALCXBRCoY4Z0tERCG2OTx13cMapS8yoqIH533LKGE654/KmFOYva05350XTwTzOFwLl0P9vwrm5Obf3mmtGR6tDjnPNwWsOXrd/dHZ0dmpLqzE0Uh1xKk5lJjIUi/RarmGXQCpBNkSTkGnUC416mZbAyoiWaZshmpMKJShmZOxRzJbpGDhZybRr1Wa94EhyiKVgVKo2i2UoForQqI/TUajaSYDOeNc10Xwiyv4QArFi6iHvavoMWOlcKJQOdW/wrhpIZs3Ozm5DORKMRoMd0einFUnUBCqEQ/ktM7vdHsdWRVUUJe9zYrjL+na6j6Yh2Fns2tGnJ4SO7nj0pkfqzshI3lEBFhfBiHeHvjAR6Yrgc1+XbfSE9A4l1tWRixgmHPm5FjOCycLPUIRR9h4QCF0kSdLvFgNAiQMCpS4AoWSBARXoggiCcCN2TJKk4ZiOFC3l7WYLmmWQZBXKIEuW6UClZjs2/zrwL9H+EDwfpYVG1Lvdu9WoG2YUvgf8QwMAn1KkDljSN3RT3TsGCxHQ9Zite7fzZhE4SQSLZxdRZzhdWTed7HSsAJGAgMvbyDTvMoPUw2SfRfUSFDg9KZ+eFNKTyxah0igUC/xbBOnSC8LCpen16SFnF+nZy6aniasWQmAjO0KAx1JtIT3NVpN/W/RtpMe7zacHPuj98So98PhvQQ9+F5Fvn2jzzUE+BZBj1EVeUYHzjdAF3nM936AgySCloNni54Tk1PGccnhG/FukMVzX2+Kvi8Qc9df1Js6vSz9+abp9uhg5yr5OnyQacVyT0wnT/IRmeNtkPYKH0xaeQi6TlRx4KrErAR9ppadXxOl069kExOH9jR07Gv6Za2c/wzrYZhIk0l8EREDVK9RxqG1FTKkIUIhj5+aOHU3vs5CP745fmAc+8i7jm7jhgoTj7RbQt+Jx7ym+GMy/43jcy7E1e7mI0f5eoFl1wJZwL4XWRXuh9+H0n21OTTX9ucbP/rtYZgdIlIw8p+J4cKeO96DljKDHoAt8RuQawaXQ/IXX190495xlWroQLYko14U6rqniwraJvMzRnt6Ed29yeCYBLj2U3D2cWNmX6Isk4CFe9l6ghxLDu5NYh/qMMixwnQqTAhl1N6aAMi7AAlkggigsSCAycQH9GFvw3dg0d2OzBL3YNl3XC3rBjHU6umyUCJpHM0Wr47ReBgZSdpAW6hNIUhr8BCmjH3ztW4/t3v3Yt9qZ7D2mGIr8Q1muyab8R1DFtKoobPF8D5553/Mek2Xlh4rf+AQMKUoVh+H5XaA9TUqk4VZjukIErn94QCKIBOaRYgGl/xD6UkGcJqIozPBdTVrRLrMrKpkllPeqY5th1EdJRprRTmSLnO4iWg9sinaPg16G7hDoNg2c0FKapp04oUEAS5inAxdeG2CffvTR094vMIWvnNC0QJq3pbRA4OWXA2sGrKiPnj7fd90+wqTG91Hrz8QEgfJ9UBBQjedxDwSfQ3ju63THTJgJR8d9COh40LNUU9QMAWvWB6GQDeMmMJHMNO4KE7s6gdvEhDdfxIsRWW7g8S8fxaQhSUePShJ/P7rM32X56Hqe0EnZUmqKsrSkYGbJy0uY1GV5eVnGzFKWuI6f503eza7lDNcYLsEwg9xBneGcQDFWkWIZ7aKKBCOVaIwwQdVUuX6iP6HEu8caNU2w4GEsWeYoFuBhrLIs7x4s+DU/Xy149/i9rd/ojOPJqq0kHIGRPvKkq+mAIutG0WZNTB3XUAPz6O+AyQzkeY7mJCbPKSARIk1jJpFZEYhEtiHQsbFz6kJnbPWb9hJZZjOEsYCMunt5syEg0XrMTE/ejJjdqlPK1MYRLhRylVwFs6xkVaxKDjPTdmqNXLbQVi4bkQltnpx/fHlBWfrxsrKw/Pj8mwfMoPZp2ZA/EwgaB9jy/OGjyuHl5cPK0cPzy+zLtv56IPC6bvuyB6t8SpJRMugOjLYatd5U25cFOcdom2PU5xjzOTa4oSfXZwl6ybiki81fsvU9/C8lv5t/pu/pLtfoXQLRdcXdMNyoDVWKyUSMb77jXTZfHshl/c2/iz+fgAq68/w7NJ739RX2tiKG3tlpUgnAI+/a/B57p8HL2Dkl7z/7EHsY940+jGsnAURVQHjM8QFCGfONPJdeyibrZj3CnQwq43n/vNa/fb1rexcM1OPbVj61LV6DDeteb4nFIFHZurVCvxqLeW8Obd06xGMiUkIcdxLXd0gc7cMzqyrnowW4XgOVKLKq7AuATFBp9hJUkRnUIEICEo8tqti5h3eGhffo65ba3fwKSSXS/rUDGJOnMJPZLB/K1c9JJGKxRDqRTiVj8Vg8Gsk3MhE9aJUQ9ucsrnsIEmqZarMRqSNwaOQAQzf+pT/wPvxkNVEsJFghUSjGa0+u/B19wXsZ4ULojjuKiTP/kygWE0xJFO8482E6tvLXMHbWt0ESWcSzwD/SidHjANlItpLd5Ab3ADdPQIS5sBhiWKAy0DkiBwNUUWVlrkOjqiSp0zxXpRkdJFWazOe6ugjZOb39ys2brhhtNiqDfb25gfxAV7Yrm07iAp1NoxaJlLhRwVhFSkLO5DC9vaN6YRDERr1Z82MTf48Z3C0gsvCxVbbQYO9Spr+fiT3S2fcKHcrF6B/EcqlQ2Lu3J5HM4R4XG1Mri1NwT9jWdTv8dNgOh89n9Pv3x/OFrvsB7P6uQqErlhEF6nbjxz3zwlQDLT5pTMHPtUhE874Y1PUg7H3nMpfpPXiOX8Jz7ECJGnabaNAFxDEMkS+j81wMBAbCHFd6X7y5A6VkEoFwPGYbOg4L1qUweqE1HM4Zpi/ljUiNV+DJWPAN709mR+j4yOzsSKY/6YVSfb9O9uPDFr0nVn49PDs7TH8xPHvmuWR/XwqW+1MA/cl1tkZA5Bl1w7KE9IhkDNtujEO41GJ5KLZkB11eIXvttVCDN089f8/P7ipf/+Bfeq/sgTffeP6eN+4qP3g9158LeCFGekjdHSIgcdyGIsIQ3zDcp0iID3j4PkUyGdGzmUTcMvVYJIZwTV8PGIAHrDxeNXw/E+EvjYsQgvdGur801l9KZqtZfC4CBCdLYyV8vNNOJuN4/xvr7o6twQB+PEIEypAZGLUTKrRJJWwaXSQnkZFJy8rlDdEoRcwUtFFXrh1HpwBJzJbBd4LnoNNjuuPod790550vnX7pTifjwOJjvJo34ptfe+dLd2Mn7uYvnFeaDJIJst2d1CSVoVIxtHdzAUFhvp33C2jpfasxWa1ku6M6JSOtykR1or/YPZgd7HL0dDQdkEmYhoOhEicxCaaNEX1zDO0ju+h9fXv9ovZ6AeZ/Nbhly+CvKpvplqELRfhvzDZXzlW0S3DdlsH/rGzFmqGtNH+hYeUNrOc931pf78vcSdx3iZikQj7qhnosXURbkrMpqgWGGnE0pLYPJrmDC2wigsBtIdMYN7P92Gr6ng+x59zaNrdzTTVjwvRqo8CN6F+VWrFYN/IRMnyvKaE6zlocxkAkJaBmjdMJiISEHMrfILDFFdK3Lzr69AP3D9z/wNOj0X19Zxap3JkoOYxYpaQjSeHaZ+77dF/fIw/fWyyw0khPNFxdvHn3rps/UQsbPSPe2ytvMdWOhkKGIctUD234vf3bJ2+6OZv1MR4MIZGvop9Lu4l1vtyP1hBjiESjGguVjAyGTr6y15u72M2Zcjlz5mlM4dXy5jI+xPdbBAI4338RZD/6roybEpk/3TTPoe14EJUb/MNReZTrFAqxcFE+efMkPvDquizQrl3ztNdc5WGYDJFR0N3gaJVSeah3lYdB5FKVyCIV5YOESiKVDhFJECWMeQQmCuyQbwOUNn8Z46EbaMD5y7lfa4+k87/dUC4aQ5ccykeJMhHn1g50m5c7Bq339OpIBtv4VZ0NZHhjo14u9eQSXZahSiQMIRUZt94p51iZoo6FgSHcLAzSMsUXGkG3luHuCri/8j3X0tjevWP0pzz9FEhxw0yJ4vGAo0UFdgMNJOMJWd7en6ZLqX7vKvc6Fx9W2ju28iN/WGVsr/dJqgQ1UfT+1QgI4m1Mi0ZVdR+8kiqVUt4+SG4Yn9g/Pj6wGmus2p+4j7ZEQsVp1EPGUS6qkCjSGayik0YuZ+S6eVSa8S1fpm2IIxkuNrlMxDfO8DVvKV0qpeG20hUluI0XvSVe/AEmv9HUxrnFs99nz7MRlNskKbo9NsqqgqEl5RdV/EIPyxjd0xsJScSxk2wI4VJPW1RtMQQFjL/Gqe3YURljZR4hU+HYsdeOHYMDU9/42tar6/WlF1+8+n2JK182jGjDfIk3vXZs4Iqe1uTVL/7Ncr1+9fu8//jICaOBarHqC7+M53Et+RC5m9zuqh+69YN1gV87tO+N7VWfgGKHfoJyZV2VO343Ygj81CjsOd+LW6Su1bv2OWzltxTnBlKYROEJ3n3XHbd/+LadO2KOiEa7DBgeF3n8xAMR/w0lhkf//N4Sg1AULcDISpZ4wYdIaYxgsMaxsR+/zvTfEOsjXEr7t2atcZiAcT5Vq8kLrTaiGoK2vKFtYWdYIqJPZDJhUdQ69AGjW5L0YjA4+FBFCxZ1c8BAEewIimI4k5nQIwnUb1SDRCTs+kOCHeEBsz1Eq2zeUtG0Xt0Y4GLboYmCnsm4up4QuB3yhGs/9rE/P3JkD7yoJwVmbNw4EdaLWkenFmZUUjuCAwPBDlWSY0FDEAKFSHhi43CUCUndrNo5SX7HMdqGDZo/RjMFphV0fWLjRuPCGO+tuz5/Fz4oTjXEYX+Lsn4L2exO1IbQ4+/fi6ETjYQpEZnLAQplPhADkcJvAJVbbtq+7YrR3kKiy0E4lufwhPqX6vUWvyzNc37wUJLzDdEqHnut6vPDyfO4kl/O88oqr7JMzsx236KIXUzkgyXJpixyBrWQeey2eJ/j9DXHm30OP7olzQ51hEJ6eti0YzHbHE6Hw1hha3CYB1Axy9o4fqEpyVu8J+Hc50OBWBBHh9J/qvU1J5r+zGlVZPicVHVRoqzTtFsZf3LGJFFXX2OiKIiqiFVWZ6eFk2Y2WmZMkAU98BNRFUQlEBDROgqvqyE0maytz/TsI8IonvEV5BDZ4rqpLgpCfxG9Kp6zWxMpwkoBhAVuPBfQQYnkMMF1fJMqziIXxG2Hbtm9a3Sk2UjGo3jMou1kJbmJwstFuoUSXhhc1RIeufpqgIIvj0PR1wQsO2iReOeqgy++KrVHczVoVtvqkjqnSBK/jmLD4QDTgAp1NZE+HkICmWL8sne7fgM6blnGQOwGfXvvLw0FgbsQejaVUGsCBKmqn8gdyD5wojkcqovR6LOD9vhpp6ze0Hll5w1q2Tk9bg8+G42K9dBw84Q1PKKCwtToqd49XU8FFRYCgdqs0XMyIqPTjJzsaTAbwWcYbfdTXXt6T0VVpoB6xLJqR7r7x045zfBTfZsli2atkyMjJ60staTNfU+Fm86psf7uI0FuLs+dfZHEXOviu2x0MRSl1r92e89DKdLd1rB1ORsLBIOXQd8qRln1NTpJkA1k0t1M0NNSUfJxt8hxt6Tg0UvCgTUAXOb32pOpJJC+Yk8uuSE1EHOiEVUhOujoZEUffa9GCzSaDQFi9Oo4B7DZwpgfIiZRD7mVowRx+Myj3/nRdx6dwUz86TdvvfWbPPF+aiYSvYk/w9RcRPy+0O7A+7En2l0w8Y4mjTeNZNJ4LlFMkvWxjkNypOT28l9GBY4SsBqty9yFa+m2vbcsw/HvRNfdSJNVO9zwI9aIjwEujnB+5Uc27eeiW+iVcnYolxv6p85crhOMzmy2k8fuebR1b5yPK0bJFvIBssO9ioSIqoTUfeEOlLMAlUCR5jhC5PAQTxrjeE2Tp4ksazNEk7XJ+UM3Hbxu7trZXTuuunKTa9SNBv/UdKeE0Sj/4dEnmP9q6LzHu8Fj9hRwmI0xPDo3tM2ixftEzoWyuTbHRgGtJB+S5oyD+4NqCaUsUFKDXwmqA2rQT77iV/hN+1aeCQQordJAwBuBcrcov472aCaobprYsPLDDRObeL8fDwYa8b+PNwKDP1aD8EtvkU8Ji7zpXcqeST+28kg4FgzG6D/slCiVbsEVVx5pzexs0XtxZTX40VguF/tocK0sxEmNuFy2y0kq8zBfAmmByIJ8GIVcgGmqoK8Bhn0PoG7yO38QJoEMVXpyGOxHwx0BBUUoDnGVh3B+XJlsR5uj6DRsHpv5P99CcdwHP1yQuENpthweJqP+luk4TaFeffyJZG/yCS7T7UIyCbec2lKc2Dnxuc9/7v5NmyZ2vfranlPh/pT3hU3Hjz9YLj/op/D2Eh+zlOhLnC+s/OPP9vzk1Z3upk2fwLE4Q++WU+FUP0QwAPnkV48/ODj44PGvXri33IXnYGFMsMvd0d1JBRlcSeUZnsc8IjpRBvEQYjmRymL71oP/AwKZVfhvuNscm5JSf082mbCHnCE9HNQUmVjUCqCuZ87rBwrTuVseQHDUvuyJ+N63sfrTjo3CJYTPDMXz+UaezeTrhbz37YSxG992G4l4Xv+uMWx8V88vFrrAxU5xfu3Fc++FrgL9kjXn3cdvfuCTc1Y+Hou+blmvR2Px/P8BEpxdcHicY2BkYGAA4iUXFTLj+W2+MsizMIDA5c+f2xH0/wZWPeYGIJeDgQkkCgBf1AyCAHicY2BkYGBu+N/AEMOawAAErHoMjAyoQBsAVCkDJAAAeJxjLGNQYgACxlAGBuaXDDosQDYLAyMjEDOA2YwMzEA2NxgD2awJDHYQNWiYkYERiEHsVCDWBuIGIA7FqhYTq0P1GrPYMTCBMUJOFUz7MzAAAGi0Bh0AAAAAACgAKAAoAWQBsAH4AkACjAKyAtIC8gMYA1oDuAQcBIYE1gVaBdgGVAaUBxoHvggOCDQIiAjMCUgJyAnwCioLDAtMC5QMgg00DfIOQg6qDvgPsBA0EKYAAQAAACsAdwAGAAAAAAACACYANABsAAAAigF3AAAAAHicdY9Na8JAEIbfaNQWivTY45BL9bBhE6L4cZX4D3oXSTSQGkjWj0v/QQs99dxjf2ZfN0uhBxNm55mZd2dnADzgCx6un4cBHh134CNw3CW9Ovap+XbcQ+pNHfcx8D6o9Px7Zob21pU7uMOT4y5WeHbsU/PpuId3/DjuY+i9IUMJhQJbVDgAWamKbUX4y7RhagNjfY0drwlihND0C9r/Nm1uysycFlMVMUJaHUxa1btM4lDLQtxjpKmaq1hH1Nya54WVGg0r7QORe3xJM/xzbHCkr7Cn5jqqYIQTNSGHSDBmrNhbMLNU85zYDgpru4x20cV2TyyfeQasBzbK7dlwmKxuCg4ecY2lGJNvjqbaFwcjo5MO58lYVCkzUbVMtKi1xJruIlEi6izBOhCVi2puLvsLTjBRRQAAAHicbc3LNsJxGEbh3/47JHKIQomcwlomfV8Uw5Cb6ApMzLoCF46lPfSu9a49fEpV/vb9VbL8t/vfU6oyp2KFVdZYp8YGdTbZosE2O+yyR5N9DmjR5pAjjunQ5YQep5zR55wLLrnimgE33HJXW3x+zMbDoQ2bdmQf7KMd24l9ss92al/sq32zM/u+bOiHfuiHfuiHfuiHfuiHfuiHfuiHfuiHfuqnfuqnfuqnbk5+APaSXBUAAEu4AMhSWLEBAY5ZuQgACABjILABI0QgsAMjcLAORSAgS7gADlFLsAZTWliwNBuwKFlgZiCKVViwAiVhsAFFYyNisAIjRLMKCQUEK7MKCwUEK7MODwUEK1myBCgJRVJEswoNBgQrsQYBRLEkAYhRWLBAiFixBgNEsSYBiFFYuAQAiFixBgFEWVlZWbgB/4WwBI2xBQBEAAAA) format('woff'), url(/static/fonts/element-icons.b02bdc1.ttf) format('truetype');
        font-weight: 400;
        font-style: normal
    }

    [class*=" el-icon-"], [class^=el-icon-] {
        font-family: element-icons !important;
        speak: none;
        font-style: normal;
        font-weight: 400;
        font-variant: normal;
        text-transform: none;
        line-height: 1;
        vertical-align: baseline;
        display: inline-block;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale
    }




    @keyframes rotating {
        0% {
            transform: rotateZ(0)
        }
        100% {
            transform: rotateZ(360deg)
        }
    }


    .el-pagination button, .el-pagination span {
        display: inline-block;
        font-size: 13px;
        min-width: 28px;
        height: 28px;
        line-height: 28px;
        vertical-align: top;
        box-sizing: border-box
    }

    .el-pagination .el-select .el-input {
        width: 110px
    }

    .el-pagination .el-select .el-input input {
        padding-right: 25px;
        border-radius: 2px;
        height: 28px
    }

    .el-pagination button {
        border: none;
        padding: 0 6px;
        background: 0 0
    }

    .el-pagination button:focus {
        outline: 0
    }

    .el-pagination button:hover {
        color: #20a0ff
    }

    .el-pagination button.disabled {
        color: #e4e4e4;
        background-color: #fff;
        cursor: not-allowed
    }

    .el-pager li, .el-pager li.btn-quicknext:hover, .el-pager li.btn-quickprev:hover {
        cursor: pointer
    }

    .el-pagination .btn-next, .el-pagination .btn-prev {
        background: center center no-repeat #fff;
        background-size: 16px;
        border: 1px solid #d1dbe5;
        cursor: pointer;
        margin: 0;
        color: #97a8be
    }

    .el-pagination .btn-next .el-icon, .el-pagination .btn-prev .el-icon {
        display: block;
        font-size: 12px
    }

    .el-pagination .btn-prev {
        border-radius: 2px 0 0 2px;
        border-right: 0
    }

    .el-pagination .btn-next {
        border-radius: 0 2px 2px 0;
        border-left: 0
    }

    .el-pagination--small .btn-next, .el-pagination--small .btn-prev, .el-pagination--small .el-pager li, .el-pagination--small .el-pager li:last-child {
        border-color: transparent;
        font-size: 12px;
        line-height: 22px;
        height: 22px;
        min-width: 22px
    }

    .el-pagination--small .el-pager li {
        border-radius: 2px
    }


    .el-pagination__sizes .el-input .el-input__inner {
        font-size: 13px;
        border-color: #d1dbe5
    }

    .el-pagination__sizes .el-input .el-input__inner:hover {
        border-color: #20a0ff
    }



    .el-pager li:last-child {
        border-right: 1px solid #d1dbe5
    }

    .el-pager li.btn-quicknext, .el-pager li.btn-quickprev {
        line-height: 28px;
        color: #97a8be
    }

    .el-pager li.active + li {
        border-left: 0;
        padding-left: 5px
    }

    .el-pager li:hover {
        color: #20a0ff
    }

    .el-pager li.active {
        border-color: #20a0ff;
        background-color: #20a0ff;
        color: #fff;
        cursor: default
    }



    @keyframes dialog-fade-in {
        0% {
            transform: translate3d(0, -20px, 0);
            opacity: 0
        }
        100% {
            transform: translate3d(0, 0, 0);
            opacity: 1
        }
    }

    @keyframes dialog-fade-out {
        0% {
            transform: translate3d(0, 0, 0);
            opacity: 1
        }
        100% {
            transform: translate3d(0, -20px, 0);
            opacity: 0
        }
    }

    .el-autocomplete-suggestion li {
        list-style: none;
        line-height: 36px;
        padding: 0 10px;
        margin: 0;
        cursor: pointer;
        color: #48576a;
        font-size: 14px;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis
    }

    .el-autocomplete-suggestion li:hover {
        background-color: #e4e8f1
    }

    .el-autocomplete-suggestion li.highlighted {
        background-color: #20a0ff;
        color: #fff
    }

    .el-autocomplete-suggestion li:active {
        background-color: #0082e6
    }

    .el-autocomplete-suggestion.is-loading li:hover, .el-dropdown-menu {
        background-color: #fff
    }

    .el-autocomplete-suggestion li.divider {
        margin-top: 6px;
        border-top: 1px solid #d1dbe5
    }

    .el-autocomplete-suggestion li.divider:last-child {
        margin-bottom: -6px
    }

    .el-autocomplete-suggestion.is-loading li {
        text-align: center;
        height: 100px;
        line-height: 100px;
        font-size: 20px;
        color: #999
    }

    .el-autocomplete-suggestion.is-loading .el-icon-loading {
        vertical-align: middle
    }


    .el-dropdown .el-button-group {
        display: block
    }

    .el-dropdown .el-dropdown__caret-button {
        padding-right: 5px;
        padding-left: 5px
    }

    .el-dropdown .el-dropdown__caret-button .el-dropdown__icon {
        padding-left: 0
    }




    .el-menu li {
        list-style: none
    }

    .el-menu--dark .el-menu-item, .el-menu--dark .el-submenu__title {
        color: #bfcbd9
    }

    .el-menu--dark .el-menu-item:hover, .el-menu--dark .el-submenu__title:hover {
        background-color: #48576a
    }

    .el-menu--dark .el-submenu .el-menu {
        background-color: #1f2d3d
    }

    .el-menu--dark .el-submenu .el-menu .el-menu-item:hover {
        background-color: #48576a
    }

    .el-menu--horizontal .el-menu-item {
        float: left;
        height: 60px;
        line-height: 60px;
        margin: 0;
        cursor: pointer;
        position: relative;
        box-sizing: border-box;
        border-bottom: 5px solid transparent
    }

    .el-menu--horizontal .el-menu-item a, .el-menu--horizontal .el-menu-item a:hover {
        color: inherit
    }

    .el-menu--horizontal .el-submenu {
        float: left;
        position: relative
    }

    .el-menu--horizontal .el-submenu > .el-menu {
        position: absolute;
        top: 65px;
        left: 0;
        border: 1px solid #d1dbe5;
        padding: 5px 0;
        background-color: #fff;
        z-index: 100;
        min-width: 100%;
        box-shadow: 0 2px 4px 0 rgba(0, 0, 0, .12), 0 0 6px 0 rgba(0, 0, 0, .04)
    }

    .el-menu--horizontal .el-submenu .el-submenu__title {
        height: 60px;
        line-height: 60px;
        border-bottom: 5px solid transparent
    }

    .el-menu--horizontal .el-submenu .el-menu-item {
        background-color: #fff;
        float: none;
        height: 36px;
        line-height: 36px;
        padding: 0 10px
    }

    .el-menu--horizontal .el-submenu .el-submenu__icon-arrow {
        position: static;
        vertical-align: middle;
        margin-left: 5px;
        color: #97a8be;
        margin-top: -3px
    }

    .el-menu--horizontal .el-menu-item:hover, .el-menu--horizontal .el-submenu__title:hover {
        background-color: #eef1f6
    }

    .el-menu--horizontal > .el-menu-item:hover, .el-menu--horizontal > .el-submenu.is-active .el-submenu__title, .el-menu--horizontal > .el-submenu:hover .el-submenu__title {
        border-bottom: 5px solid #20a0ff
    }

    .el-menu--horizontal.el-menu--dark .el-menu-item:hover, .el-menu--horizontal.el-menu--dark .el-submenu__title:hover {
        background-color: #324157
    }

    .el-menu--horizontal.el-menu--dark .el-submenu .el-menu-item:hover, .el-menu--horizontal.el-menu--dark .el-submenu .el-submenu-title:hover, .el-menu-item:hover {
        background-color: #d1dbe5
    }

    .el-menu--horizontal.el-menu--dark .el-submenu .el-menu-item, .el-menu--horizontal.el-menu--dark .el-submenu .el-submenu-title {
        color: #48576a
    }

    .el-menu--horizontal.el-menu--dark .el-submenu .el-menu-item.is-active, .el-menu-item.is-active {
        color: #20a0ff
    }

    .el-menu-item [class^=el-icon-] {
        vertical-align: baseline;
        margin-right: 10px
    }


    .el-submenu [class^=el-icon-] {
        vertical-align: baseline;
        margin-right: 10px
    }

    .el-submenu .el-menu {
        background-color: #e4e8f1
    }

    .el-submenu .el-menu-item:hover, .el-submenu__title:hover {
        background-color: #d1dbe5
    }

    .el-submenu .el-menu-item {
        height: 50px;
        line-height: 50px;
        padding: 0 45px
    }

    .el-submenu.is-opened > .el-submenu__title .el-submenu__icon-arrow {
        -ms-transform: rotate(180deg);
        transform: rotateZ(180deg)
    }

    .el-submenu.is-active .el-submenu__title {
        border-bottom-color: #20a0ff
    }



    .el-menu-item-group > ul {
        padding: 0
    }



    .el-radio + .el-radio {
        margin-left: 15px
    }


    .el-radio__input.is-focus .el-radio__inner {
        border-color: #20a0ff
    }

    .el-radio__input.is-checked .el-radio__inner {
        border-color: #20a0ff;
        background: #20a0ff
    }

    .el-radio__input.is-checked .el-radio__inner::after {
        -ms-transform: translate(-50%, -50%) scale(1);
        transform: translate(-50%, -50%) scale(1)
    }

    .el-radio__input.is-disabled .el-radio__inner {
        background-color: #eef1f6;
        border-color: #d1dbe5;
        cursor: not-allowed
    }

    .el-radio__input.is-disabled .el-radio__inner::after {
        cursor: not-allowed;
        background-color: #eef1f6
    }

    .el-radio__input.is-disabled .el-radio__inner + .el-radio__label {
        cursor: not-allowed
    }

    .el-radio__input.is-disabled.is-checked .el-radio__inner {
        background-color: #d1dbe5;
        border-color: #d1dbe5
    }

    .el-radio__inner, .el-radio__input.is-disabled.is-checked .el-radio__inner::after {
        background-color: #fff
    }

    .el-radio__input.is-disabled + .el-radio__label {
        color: #bbb;
        cursor: not-allowed
    }



    .el-radio-group .el-radio {
        font-size: 14px
    }

    .el-radio-button:first-child .el-radio-button__inner {
        border-left: 1px solid #bfcbd9;
        border-radius: 4px 0 0 4px;
        box-shadow: none !important
    }

    .el-radio-button:last-child .el-radio-button__inner {
        border-radius: 0 4px 4px 0
    }


    .el-radio-button__inner [class*=el-icon-] {
        line-height: .9
    }

    .el-radio-button__inner [class*=el-icon-] + span {
        margin-left: 5px
    }


    .el-radio-button__orig-radio:checked + .el-radio-button__inner {
        color: #fff;
        background-color: #20a0ff;
        border-color: #20a0ff;
        box-shadow: -1px 0 0 0 #20a0ff
    }

    .el-radio-button__orig-radio:disabled + .el-radio-button__inner {
        color: #bfcbd9;
        cursor: not-allowed;
        background-image: none;
        background-color: #eef1f6;
        border-color: #d1dbe5;
        box-shadow: none
    }

    .el-radio-button--large .el-radio-button__inner {
        padding: 11px 19px;
        font-size: 16px;
        border-radius: 0
    }

    .el-radio-button--small .el-radio-button__inner {
        padding: 7px 9px;
        font-size: 12px;
        border-radius: 0
    }

    .el-radio-button--mini .el-radio-button__inner {
        padding: 4px;
        font-size: 12px;
        border-radius: 0
    }


    .el-switch .label-fade-enter, .el-switch .label-fade-leave-active {
        opacity: 0
    }

    .el-switch.is-disabled .el-switch__core {
        border-color: #e4e8f1 !important;
        background: #e4e8f1 !important
    }

    .el-switch.is-disabled .el-switch__core span {
        background-color: #fbfdff !important
    }

    .el-switch.is-disabled .el-switch__core ~ .el-switch__label * {
        color: #fbfdff !important
    }

    .el-switch.is-disabled .el-switch__input:checked + .el-switch__core {
        border-color: #e4e8f1;
        background-color: #e4e8f1
    }

    .el-switch.is-disabled .el-switch__core, .el-switch.is-disabled .el-switch__label {
        cursor: not-allowed
    }


    .el-switch__label * {
        line-height: 1;
        top: 4px;
        color: #fff
    }

    .el-switch__label--left i {
        left: 6px
    }

    .el-switch__label--right i {
        right: 6px
    }


    .el-switch__input:checked + .el-switch__core {
        border-color: #20a0ff;
        background-color: #20a0ff
    }


    .el-switch__core .el-switch__button {
        top: 0;
        left: 0;
        position: absolute;
        border-radius: 100%;
        transition: transform .3s;
        width: 16px;
        height: 16px;
        background-color: #fff
    }

    .el-switch--wide .el-switch__label.el-switch__label--left span {
        left: 10px
    }

    .el-switch--wide .el-switch__label.el-switch__label--right span {
        right: 10px
    }


    .el-select-dropdown .el-scrollbar.is-empty .el-select-dropdown__list {
        padding: 0
    }

    .el-select-dropdown.is-multiple .el-select-dropdown__item.selected {
        color: #20a0ff;
        background-color: #fff
    }

    .el-select-dropdown.is-multiple .el-select-dropdown__item.selected.hover, .el-select-dropdown__item.hover, .el-select-dropdown__item:hover {
        background-color: #e4e8f1
    }

    .el-select-dropdown.is-multiple .el-select-dropdown__item.selected::after {
        position: absolute;
        right: 10px;
        font-family: element-icons;
        content: "\E608";
        font-size: 11px;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale
    }



    .el-select-dropdown__item span {
        line-height: 1.5 !important
    }


    .el-select-group .el-select-dropdown__item {
        padding-left: 20px
    }


    .el-select:hover .el-input__inner {
        border-color: #8391a5
    }

    .el-select .el-input__inner {
        cursor: pointer;
        padding-right: 35px
    }

    .el-select .el-input__inner:focus {
        border-color: #20a0ff
    }

    .el-select .el-input .el-input__icon {
        color: #bfcbd9;
        font-size: 12px;
        transition: transform .3s;
        -ms-transform: translateY(-50%) rotate(180deg);
        transform: translateY(-50%) rotateZ(180deg);
        line-height: 16px;
        top: 50%;
        cursor: pointer
    }

    .el-select .el-input .el-input__icon.is-show-close {
        transition: 0s;
        width: 16px;
        height: 16px;
        font-size: 14px;
        right: 8px;
        text-align: center;
        -ms-transform: translateY(-50%) rotate(180deg);
        transform: translateY(-50%) rotateZ(180deg);
        border-radius: 100%;
        color: #bfcbd9
    }

    .el-select .el-input .el-input__icon.is-show-close:hover {
        color: #97a8be
    }

    .el-select .el-input .el-input__icon.is-reverse {
        -ms-transform: translateY(-50%);
        transform: translateY(-50%)
    }

    .el-select .el-input.is-disabled .el-input__inner {
        cursor: not-allowed
    }

    .el-select .el-input.is-disabled .el-input__inner:hover {
        border-color: #d1dbe5
    }

    .el-select > .el-input {
        display: block
    }

    .el-select .el-tag__close {
        margin-top: -2px
    }

    .el-select .el-tag {
        height: 24px;
        line-height: 24px;
        box-sizing: border-box;
        margin: 3px 0 3px 6px
    }





    .el-select__tag .el-icon-close {
        font-size: 12px
    }


    .el-table .el-tooltip.cell {
        white-space: nowrap;
        min-width: 50px
    }

    .el-table td, .el-table th {
        height: 40px;
        min-width: 0;
        text-overflow: ellipsis;
        vertical-align: middle
    }


    .el-table td.is-right, .el-table th.is-right {
        text-align: right
    }

    .el-table td.is-left, .el-table th.is-left {
        text-align: left
    }

    .el-table td.is-center, .el-table th.is-center {
        text-align: center
    }

    .el-table td, .el-table th.is-leaf {
        border-bottom: 1px solid #dfe6ec
    }

    .el-table td.gutter, .el-table th.gutter {
        width: 15px;
        border-right-width: 0;
        border-bottom-width: 0;
        padding: 0
    }

    .el-table .cell, .el-table th > div {
        padding-left: 18px;
        padding-right: 18px;
        box-sizing: border-box;
        text-overflow: ellipsis
    }


    .el-table .caret-wrapper, .el-table th > .cell {
        position: relative;
        display: inline-block;
        vertical-align: middle
    }

    .el-table th {
        white-space: nowrap;
        overflow: hidden;
        background-color: #eef1f6;
        text-align: left
    }

    .el-table th > div {
        display: inline-block;
        line-height: 40px;
        overflow: hidden;
        white-space: nowrap
    }

    .el-table td > div {
        box-sizing: border-box
    }

    .el-table th.required > div::before {
        display: inline-block;
        content: "";
        width: 8px;
        height: 8px;
        border-radius: 50%;
        background: #ff4d51;
        margin-right: 5px;
        vertical-align: middle
    }

    .el-table th > .cell {
        word-wrap: normal;
        text-overflow: ellipsis;
        line-height: 30px;
        width: 100%;
        box-sizing: border-box
    }

    .el-table th > .cell.highlight {
        color: #20a0ff
    }

    .el-table .caret-wrapper {
        cursor: pointer;
        margin-left: 5px;
        margin-top: -2px;
        width: 16px;
        height: 30px;
        overflow: visible;
        overflow: initial
    }

    .el-table .cell, .el-table__footer-wrapper, .el-table__header-wrapper {
        overflow: hidden
    }

    .el-table .sort-caret {
        display: inline-block;
        width: 0;
        height: 0;
        border: 0;
        content: "";
        position: absolute;
        left: 3px;
        z-index: 2
    }

    .el-table .sort-caret.ascending, .el-table .sort-caret.descending {
        border-right: 5px solid transparent;
        border-left: 5px solid transparent
    }

    .el-table .sort-caret.ascending {
        top: 9px;
        border-top: none;
        border-bottom: 5px solid #97a8be
    }

    .el-table .sort-caret.descending {
        bottom: 9px;
        border-top: 5px solid #97a8be;
        border-bottom: none
    }

    .el-table .ascending .sort-caret.ascending {
        border-bottom-color: #48576a
    }

    .el-table .descending .sort-caret.descending {
        border-top-color: #48576a
    }

    .el-table td.gutter {
        width: 0
    }

    .el-table .cell {
        white-space: normal;
        word-break: break-all;
        line-height: 24px
    }

    .el-badge__content, .el-message__group p, .el-steps.is-horizontal, .el-tabs__nav, .el-tag, .el-time-spinner, .el-tree-node, .el-upload-cover__title {
        white-space: nowrap
    }

    .el-table tr input[type=checkbox] {
        margin: 0
    }

    .el-table tr {
        background-color: #fff
    }

    .el-table .hidden-columns {
        position: absolute;
        z-index: -1
    }



    .el-table__expand-column .cell {
        padding: 0;
        text-align: center
    }


    .el-table__expand-icon > .el-icon {
        position: absolute;
        left: 50%;
        top: 50%;
        margin-left: -5px;
        margin-top: -5px
    }


    .el-table--border th, .el-table__fixed-right-patch {
        border-bottom: 1px solid #dfe6ec
    }

    .el-table--fit td.gutter, .el-table--fit th.gutter {
        border-right-width: 1px
    }

    .el-table--border td, .el-table--border th {
        border-right: 1px solid #dfe6ec
    }


    .el-table__fixed-right .el-table__fixed-body-wrapper, .el-table__fixed-right .el-table__fixed-footer-wrapper, .el-table__fixed-right .el-table__fixed-header-wrapper {
        left: auto;
        right: 0
    }


    .el-table__fixed-header-wrapper thead div {
        background-color: #eef1f6;
        color: #1f2d3d
    }


    .el-table__fixed-footer-wrapper tbody td {
        border-top: 1px solid #dfe6ec;
        background-color: #fbfdff;
        color: #1f2d3d
    }


    .el-table__footer-wrapper td {
        border-top: 1px solid #dfe6ec
    }

    .el-table__body, .el-table__footer, .el-table__header {
        table-layout: fixed
    }

    .el-table__footer-wrapper thead div, .el-table__header-wrapper thead div {
        background-color: #eef1f6;
        color: #1f2d3d
    }

    .el-table__footer-wrapper tbody td, .el-table__header-wrapper tbody td {
        background-color: #fbfdff;
        color: #1f2d3d
    }

    .el-table--striped .el-table__body tr:nth-child(2n) td {
        background: #FAFAFA;
        background-clip: padding-box
    }

    .el-table--striped .el-table__body tr:nth-child(2n).current-row td {
        background: #edf7ff
    }

    .el-table__body tr.hover-row > td {
        background-color: #eef1f6
    }

    .el-table__body tr.current-row > td {
        background: #edf7ff
    }


    .el-table__column-filter-trigger i {
        color: #97a8be
    }

    .el-table--enable-row-transition .el-table__body td {
        transition: background-color .25s ease
    }


    .el-table--enable-row-hover .el-table__body tr:hover > td {
        background-color: #eef1f6;
        background-clip: padding-box
    }

    .el-table--fluid-height .el-table__fixed, .el-table--fluid-height .el-table__fixed-right {
        bottom: 0;
        overflow: hidden
    }

    .el-table-column--selection .cell {
        padding-left: 14px;
        padding-right: 14px
    }



    .el-table-filter__bottom button {
        background: 0 0;
        border: none;
        color: #8391a5;
        cursor: pointer;
        font-size: 14px;
        padding: 0 3px
    }

    .el-table-filter__bottom button:hover {
        color: #20a0ff
    }

    .el-table-filter__bottom button:focus {
        outline: 0
    }

    .el-table-filter__bottom button.is-disabled {
        color: #bfcbd9;
        cursor: not-allowed
    }

    .el-table-filter__checkbox-group label.el-checkbox {
        display: block;
        margin-bottom: 8px;
        margin-left: 5px
    }

    .el-table-filter__checkbox-group .el-checkbox:last-child {
        margin-bottom: 0
    }


    .el-date-table td {
        width: 32px;
        height: 32px;
        box-sizing: border-box;
        text-align: center;
        cursor: pointer
    }

    .el-date-table td.next-month, .el-date-table td.prev-month {
        color: #ddd
    }

    .el-date-table td.today {
        color: #20a0ff;
        position: relative
    }

    .el-date-table td.today:before {
        content: " ";
        position: absolute;
        top: 0;
        right: 0;
        width: 0;
        height: 0;
        border-top: .5em solid #20a0ff;
        border-left: .5em solid transparent
    }

    .el-month-table td .cell, .el-year-table td .cell {
        width: 48px;
        height: 32px;
        display: block;
        line-height: 32px
    }

    .el-date-table td.available:hover {
        background-color: #e4e8f1
    }

    .el-date-table td.in-range {
        background-color: #d2ecff
    }

    .el-date-table td.in-range:hover {
        background-color: #afddff
    }

    .el-date-table td.current:not(.disabled), .el-date-table td.end-date, .el-date-table td.start-date {
        background-color: #20a0ff !important;
        color: #fff
    }

    .el-date-table td.disabled {
        background-color: #f4f4f4;
        opacity: 1;
        cursor: not-allowed;
        color: #ccc
    }


    .el-date-table td.week {
        font-size: 80%;
        color: #8391a5
    }


    .el-date-table th {
        padding: 5px;
        color: #8391a5;
        font-weight: 400
    }

    .el-date-table.is-week-mode .el-date-table__row:hover {
        background-color: #e4e8f1
    }

    .el-date-table.is-week-mode .el-date-table__row.current {
        background-color: #d2ecff
    }

    .el-month-table td {
        text-align: center;
        padding: 20px 3px;
        cursor: pointer
    }

    .el-month-table td .cell {
        color: #48576a
    }

    .el-month-table td .cell:hover {
        background-color: #e4e8f1
    }

    .el-month-table td.disabled .cell {
        background-color: #f4f4f4;
        cursor: not-allowed;
        color: #ccc
    }

    .el-month-table td.current:not(.disabled) .cell {
        background-color: #20a0ff !important;
        color: #fff
    }

    .el-year-table .el-icon {
        color: #97a8be
    }

    .el-year-table td {
        text-align: center;
        padding: 20px 3px;
        cursor: pointer
    }

    .el-year-table td .cell {
        color: #48576a
    }

    .el-year-table td .cell:hover {
        background-color: #e4e8f1
    }

    .el-year-table td.disabled .cell {
        background-color: #f4f4f4;
        cursor: not-allowed;
        color: #ccc
    }

    .el-year-table td.current:not(.disabled) .cell {
        background-color: #20a0ff !important;
        color: #fff
    }


    .el-date-range-picker table {
        table-layout: fixed;
        width: 100%
    }

    .el-date-range-picker .el-picker-panel__body {
        min-width: 513px
    }

    .el-date-range-picker .el-picker-panel__content {
        margin: 0
    }



    .el-date-range-picker__header button {
        float: left
    }

    .el-date-range-picker__header div {
        font-size: 14px;
        margin-right: 50px
    }

    .el-date-range-picker__content.is-right .el-date-range-picker__header button {
        float: right
    }

    .el-date-range-picker__content.is-right .el-date-range-picker__header div {
        margin-left: 50px;
        margin-right: 50px
    }


    .el-date-range-picker__time-header > .el-icon-arrow-right {
        font-size: 20px;
        vertical-align: middle;
        display: table-cell;
        color: #97a8be
    }


    .el-date-range-picker__time-picker-wrap .el-picker-panel {
        position: absolute;
        top: 13px;
        right: 0;
        z-index: 1;
        background: #fff
    }




    .el-picker-panel [slot=sidebar], .el-picker-panel__sidebar {
        position: absolute;
        top: 0;
        bottom: 0;
        width: 110px;
        border-right: 1px solid #e4e4e4;
        box-sizing: border-box;
        padding-top: 6px;
        background-color: #fbfdff
    }

    .el-picker-panel [slot=sidebar] + .el-picker-panel__body, .el-picker-panel__sidebar + .el-picker-panel__body {
        margin-left: 110px
    }


    .el-date-picker .el-picker-panel__content {
        min-width: 224px
    }

    .el-date-picker table {
        table-layout: fixed;
        width: 100%
    }



    .time-select .el-picker-panel__content {
        max-height: 200px;
        margin: 0
    }




    .el-date-editor .el-picker-panel {
        position: absolute;
        min-width: 180px;
        box-sizing: border-box;
        box-shadow: 0 2px 6px #ccc;
        background: #fff;
        z-index: 10;
        top: 41px
    }

    .el-time-spinner.has-seconds .el-time-spinner__wrapper {
        width: 33%
    }

    .el-time-spinner.has-seconds .el-time-spinner__wrapper .el-scrollbar__wrap:not(.el-scrollbar__wrap--hidden-default) {
        padding-bottom: 15px
    }

    .el-time-spinner.has-seconds .el-time-spinner__wrapper:nth-child(2) {
        margin-left: 1%
    }

    @keyframes v-modal-in {
        0% {
            opacity: 0
        }
    }

    @keyframes v-modal-out {
        100% {
            opacity: 0
        }
    }
    .el-message-box__input input.invalid, .el-message-box__input input.invalid:focus {
        border-color: #ff4949
    }
    .el-message-box__message p {
        margin: 0;
        line-height: 1.4
    }


    .el-message-box__btns button:nth-child(2) {
        margin-left: 10px
    }
    @keyframes msgbox-fade-in {
        0% {
            transform: translate3d(0, -20px, 0);
            opacity: 0
        }
        100% {
            transform: translate3d(0, 0, 0);
            opacity: 1
        }
    }

    @keyframes msgbox-fade-out {
        0% {
            transform: translate3d(0, 0, 0);
            opacity: 1
        }
        100% {
            transform: translate3d(0, -20px, 0);
            opacity: 0
        }
    }
    .el-breadcrumb__item:last-child .el-breadcrumb__item__inner, .el-breadcrumb__item:last-child .el-breadcrumb__item__inner a, .el-breadcrumb__item:last-child .el-breadcrumb__item__inner a:hover, .el-breadcrumb__item:last-child .el-breadcrumb__item__inner:hover {
        color: #97a8be;
        cursor: text
    }

    .el-breadcrumb__item:last-child .el-breadcrumb__separator {
        display: none
    }

    .el-breadcrumb__item__inner, .el-breadcrumb__item__inner a {
        transition: color .15s linear;
        color: #48576a
    }

    .el-breadcrumb__item__inner a:hover, .el-breadcrumb__item__inner:hover {
        color: #20a0ff;
        cursor: pointer
    }

    .el-form--label-left .el-form-item__label {
        text-align: left
    }

    .el-form--label-top .el-form-item__label {
        float: none;
        display: inline-block;
        text-align: left;
        padding: 0 0 10px
    }

    .el-form--inline .el-form-item {
        display: inline-block;
        margin-right: 10px;
        vertical-align: top
    }

    .el-form--inline .el-form-item__label {
        float: none;
        display: inline-block
    }

    .el-form--inline .el-form-item__content {
        display: inline-block;
        vertical-align: top
    }

    .el-form--inline.el-form--label-top .el-form-item__content {
        display: block
    }

    .el-form-item {
        margin-bottom: 22px
    }

    .el-form-item .el-form-item {
        margin-bottom: 0
    }

    .el-form-item .el-form-item .el-form-item__content {
        margin-left: 0 !important
    }

    .el-form-item.is-error .el-input-group__append .el-input__inner, .el-form-item.is-error .el-input-group__prepend .el-input__inner, .el-form-item.is-error .el-input__inner {
        border-color: transparent
    }

    .el-form-item.is-error .el-input__inner, .el-form-item.is-error .el-textarea__inner {
        border-color: #ff4949
    }

    .el-form-item.is-required .el-form-item__label:before {
        content: '*';
        color: #ff4949;
        margin-right: 4px
    }


    .el-form-item__content {
        line-height: 36px;
        position: relative;
        font-size: 14px
    }




    .el-tabs__new-tab .el-icon-plus {
        -ms-transform: scale(.8, .8);
        transform: scale(.8, .8)
    }





    .el-tabs__item .el-icon-close {
        border-radius: 50%;
        text-align: center;
        transition: all .3s cubic-bezier(.645, .045, .355, 1);
        margin-left: 5px
    }

    .el-tabs__item .el-icon-close:before {
        -ms-transform: scale(.7, .7);
        transform: scale(.7, .7);
        display: inline-block
    }

    .el-tabs__item .el-icon-close:hover {
        background-color: #97a8be;
        color: #fff
    }


    .el-tabs--card > .el-tabs__header .el-tabs__active-bar {
        display: none
    }


    .el-tabs--card > .el-tabs__header .el-tabs__item .el-icon-close {
        position: relative;
        font-size: 12px;
        width: 0;
        height: 14px;
        vertical-align: middle;
        line-height: 15px;
        overflow: hidden;
        top: -1px;
        right: -2px;
        -ms-transform-origin: 100% 50%;
        transform-origin: 100% 50%
    }

    .el-tabs--card > .el-tabs__header .el-tabs__item.is-active.is-closable .el-icon-close, .el-tabs--card > .el-tabs__header .el-tabs__item.is-closable:hover .el-icon-close {
        width: 14px
    }

    .el-tabs--card > .el-tabs__header .el-tabs__item {
        border: 1px solid transparent;
        transition: all .3s cubic-bezier(.645, .045, .355, 1)
    }

    .el-tabs--card > .el-tabs__header .el-tabs__item.is-closable:hover {
        padding-right: 9px;
        padding-left: 9px
    }

    .el-tabs--card > .el-tabs__header .el-tabs__item.is-active {
        border: 1px solid #d1dbe5;
        border-bottom-color: #fff;
        border-radius: 4px 4px 0 0
    }

    .el-tabs--card > .el-tabs__header .el-tabs__item.is-active.is-closable {
        padding-right: 16px;
        padding-left: 16px
    }


    .el-tabs--border-card > .el-tabs__content {
        padding: 15px
    }

    .el-tabs--border-card > .el-tabs__header {
        background-color: #eef1f6;
        margin: 0
    }

    .el-tabs--border-card > .el-tabs__header .el-tabs__item {
        transition: all .3s cubic-bezier(.645, .045, .355, 1);
        border: 1px solid transparent;
        border-top: 0;
        margin-right: -1px;
        margin-left: -1px
    }

    .el-tabs--border-card > .el-tabs__header .el-tabs__item.is-active {
        background-color: #fff;
        border-right-color: #d1dbe5;
        border-left-color: #d1dbe5
    }

    .el-tabs--border-card > .el-tabs__header .el-tabs__item.is-active:first-child {
        border-left-color: #d1dbe5
    }

    .el-tabs--border-card > .el-tabs__header .el-tabs__item.is-active:last-child {
        border-right-color: #d1dbe5
    }



    @keyframes slideInRight-enter {
        0% {
            opacity: 0;
            transform-origin: 0 0;
            transform: translateX(100%)
        }
        to {
            opacity: 1;
            transform-origin: 0 0;
            transform: translateX(0)
        }
    }

    @keyframes slideInRight-leave {
        0% {
            transform-origin: 0 0;
            transform: translateX(0);
            opacity: 1
        }
        100% {
            transform-origin: 0 0;
            transform: translateX(100%);
            opacity: 0
        }
    }

    @keyframes slideInLeft-enter {
        0% {
            opacity: 0;
            transform-origin: 0 0;
            transform: translateX(-100%)
        }
        to {
            opacity: 1;
            transform-origin: 0 0;
            transform: translateX(0)
        }
    }

    @keyframes slideInLeft-leave {
        0% {
            transform-origin: 0 0;
            transform: translateX(0);
            opacity: 1
        }
        100% {
            transform-origin: 0 0;
            transform: translateX(-100%);
            opacity: 0
        }
    }


    .el-tag .el-icon-close {
        border-radius: 50%;
        text-align: center;
        position: relative;
        cursor: pointer;
        font-size: 12px;
        -ms-transform: scale(.75, .75);
        transform: scale(.75, .75);
        height: 18px;
        width: 18px;
        line-height: 18px;
        vertical-align: middle;
        top: -1px;
        right: -2px
    }

    .el-tag .el-icon-close:hover {
        background-color: #fff;
        color: #8391a5
    }


    .el-tag--gray .el-tag__close:hover {
        background-color: #48576a;
        color: #fff
    }


    .el-tag--primary .el-tag__close:hover {
        background-color: #20a0ff;
        color: #fff
    }


    .el-tag--success .el-tag__close:hover {
        background-color: #13ce66;
        color: #fff
    }


    .el-tag--warning .el-tag__close:hover {
        background-color: #f7ba2a;
        color: #fff
    }


    .el-tag--danger .el-tag__close:hover {
        background-color: #ff4949;
        color: #fff
    }


    .el-tree-node > .el-tree-node__children {
        overflow: hidden;
        background-color: transparent
    }

    .el-tree-node.is-expanded > .el-tree-node__children {
        display: block
    }


    .el-tree-node__content > .el-checkbox, .el-tree-node__content > .el-tree-node__expand-icon {
        margin-right: 8px
    }

    .el-tree-node__content > .el-checkbox {
        vertical-align: middle
    }




    .el-tree--highlight-current .el-tree-node.is-current > .el-tree-node__content {
        background-color: #edf7ff
    }


    .el-alert .el-alert__description {
        color: #fff;
        font-size: 12px;
        margin: 5px 0 0
    }




    .el-notification .el-icon-circle-check {
        color: #13ce66
    }

    .el-notification .el-icon-circle-cross {
        color: #ff4949
    }

    .el-notification .el-icon-information {
        color: #50bfff
    }

    .el-notification .el-icon-warning {
        color: #f7ba2a
    }

    .el-input-number .el-input {
        display: block
    }

    .el-input-number .el-input__inner {
        -webkit-appearance: none;
        -moz-appearance: none;
        appearance: none;
        padding-right: 82px
    }

    .el-input-number.is-without-controls .el-input__inner {
        padding-right: 10px
    }

    .el-input-number.is-disabled .el-input-number__decrease, .el-input-number.is-disabled .el-input-number__increase {
        border-color: #d1dbe5;
        color: #d1dbe5
    }

    .el-input-number.is-disabled .el-input-number__decrease:hover, .el-input-number.is-disabled .el-input-number__increase:hover {
        color: #d1dbe5;
        cursor: not-allowed
    }


    .el-input-number__decrease:hover:not(.is-disabled) ~ .el-input .el-input__inner:not(.is-disabled), .el-input-number__increase:hover:not(.is-disabled) ~ .el-input .el-input__inner:not(.is-disabled) {
        border-color: #20a0ff
    }


    .el-input-number--large .el-input-number__decrease, .el-input-number--large .el-input-number__increase {
        line-height: 42px;
        width: 42px;
        font-size: 16px
    }

    .el-input-number--large .el-input-number__decrease {
        right: 43px
    }

    .el-input-number--large .el-input__inner {
        padding-right: 94px
    }

    .el-input-number--small .el-input-number__decrease, .el-input-number--small .el-input-number__increase {
        line-height: 30px;
        width: 30px;
        font-size: 13px
    }

    .el-input-number--small .el-input-number__decrease {
        right: 31px
    }

    .el-input-number--small .el-input__inner {
        padding-right: 70px
    }


    .el-tooltip__popper .popper__arrow, .el-tooltip__popper .popper__arrow::after {
        position: absolute;
        display: block;
        width: 0;
        height: 0;
        border-color: transparent;
        border-style: solid
    }

    .el-tooltip__popper .popper__arrow {
        border-width: 6px
    }

    .el-tooltip__popper .popper__arrow::after {
        content: " ";
        border-width: 5px
    }




    .el-slider__button-wrapper .el-tooltip, .el-slider__button-wrapper:after {
        display: inline-block;
        vertical-align: middle
    }

    .el-slider.is-vertical .el-slider__runway {
        width: 4px;
        height: 100%;
        margin: 0 16px
    }

    .el-slider.is-vertical .el-slider__bar {
        width: 4px;
        height: auto;
        border-radius: 0 0 3px 3px
    }

    .el-slider.is-vertical .el-slider__button-wrapper {
        top: auto;
        left: -16px;
        -ms-transform: translateY(50%);
        transform: translateY(50%)
    }

    .el-slider.is-vertical .el-slider__stop {
        -ms-transform: translateY(50%);
        transform: translateY(50%)
    }

    .el-slider.is-vertical.el-slider--with-input .el-slider__input {
        overflow: visible;
        float: none;
        position: absolute;
        bottom: 22px;
        width: 36px;
        margin-top: 15px
    }

    .el-slider.is-vertical.el-slider--with-input .el-slider__input .el-input__inner {
        text-align: center;
        padding-left: 5px;
        padding-right: 5px
    }

    .el-slider.is-vertical.el-slider--with-input .el-slider__input .el-input-number__decrease, .el-slider.is-vertical.el-slider--with-input .el-slider__input .el-input-number__increase {
        top: 30px;
        margin-top: -1px;
        border: 1px solid #bfcbd9;
        line-height: 20px;
        box-sizing: border-box;
        transition: border-color .2s cubic-bezier(.645, .045, .355, 1)
    }

    .el-slider.is-vertical.el-slider--with-input .el-slider__input .el-input-number__decrease {
        width: 18px;
        right: 18px;
        border-bottom-left-radius: 4px
    }

    .el-slider.is-vertical.el-slider--with-input .el-slider__input .el-input-number__increase {
        width: 19px;
        border-bottom-right-radius: 4px
    }

    .el-slider.is-vertical.el-slider--with-input .el-slider__input .el-input-number__increase ~ .el-input .el-input__inner {
        border-bottom-left-radius: 0;
        border-bottom-right-radius: 0
    }

    .el-slider.is-vertical.el-slider--with-input .el-slider__input:hover .el-input-number__decrease, .el-slider.is-vertical.el-slider--with-input .el-slider__input:hover .el-input-number__increase {
        border-color: #8391a5
    }

    .el-slider.is-vertical.el-slider--with-input .el-slider__input:active .el-input-number__decrease, .el-slider.is-vertical.el-slider--with-input .el-slider__input:active .el-input-number__increase {
        border-color: #20a0ff
    }


    .el-slider__runway.disabled .el-slider__bar, .el-slider__runway.disabled .el-slider__button {
        background-color: #bfcbd9
    }

    .el-slider__runway.disabled .el-slider__button-wrapper.dragging, .el-slider__runway.disabled .el-slider__button-wrapper.hover, .el-slider__runway.disabled .el-slider__button-wrapper:hover {
        cursor: not-allowed
    }

    .el-slider__runway.disabled .el-slider__button.dragging, .el-slider__runway.disabled .el-slider__button.hover, .el-slider__runway.disabled .el-slider__button:hover {
        -ms-transform: scale(1);
        transform: scale(1);
        cursor: not-allowed
    }



    .el-loading-mask.is-fullscreen .el-loading-spinner {
        margin-top: -25px
    }

    .el-loading-mask.is-fullscreen .el-loading-spinner .circular {
        width: 50px;
        height: 50px
    }

    .el-loading-spinner .el-loading-text {
        color: #20a0ff;
        margin: 3px 0;
        font-size: 14px
    }

    .el-loading-spinner .circular {
        width: 42px;
        height: 42px;
        animation: loading-rotate 2s linear infinite
    }

    .el-loading-spinner .path {
        animation: loading-dash 1.5s ease-in-out infinite;
        stroke-dasharray: 90, 150;
        stroke-dashoffset: 0;
        stroke-width: 2;
        stroke: #20a0ff;
        stroke-linecap: round
    }

    @keyframes loading-rotate {
        100% {
            transform: rotate(360deg)
        }
    }

    @keyframes loading-dash {
        0% {
            stroke-dasharray: 1, 200;
            stroke-dashoffset: 0
        }
        50% {
            stroke-dasharray: 90, 150;
            stroke-dashoffset: -40px
        }
        100% {
            stroke-dasharray: 90, 150;
            stroke-dashoffset: -120px
        }
    }

    .el-upload iframe {
        position: absolute;
        z-index: -1;
        top: 0;
        left: 0;
        opacity: 0;
        filter: alpha(opacity=0)
    }

    .el-upload--picture-card i {
        font-size: 28px;
        color: #8c939d
    }

    .el-upload-dragger .el-upload__text {
        color: #97a8be;
        font-size: 14px;
        text-align: center
    }

    .el-upload-dragger .el-upload__text em {
        color: #20a0ff;
        font-style: normal
    }

    .el-upload-dragger .el-icon-upload {
        font-size: 67px;
        color: #97a8be;
        margin: 40px 0 16px;
        line-height: 50px
    }

    .el-upload-dragger + .el-upload__tip {
        text-align: center
    }

    .el-upload-dragger ~ .el-upload__files {
        border-top: 1px solid rgba(191, 203, 217, .2);
        margin-top: 7px;
        padding-top: 5px
    }


    .el-upload-list__item .el-progress-bar {
        margin-right: 0;
        padding-right: 0
    }

    .el-upload-list__item .el-progress {
        position: absolute;
        top: 20px;
        width: 100%
    }

    .el-upload-list__item .el-progress__text {
        position: absolute;
        top: -13px;
        right: 0
    }
    .el-upload-list__item .el-icon-upload-success {
        color: #13ce66
    }

    .el-upload-list__item .el-icon-close {
        display: none;
        position: absolute;
        top: 5px;
        right: 5px;
        cursor: pointer;
        opacity: .75;
        color: #48576a;
        -ms-transform: scale(.7);
        transform: scale(.7)
    }

    .el-upload-list__item .el-icon-close:hover {
        opacity: 1
    }
    .el-upload-list__item:hover .el-icon-close {
        display: inline-block
    }

    .el-upload-list__item:hover .el-progress__text {
        display: none
    }

    .el-upload-list__item.is-success .el-upload-list__item-status-label {
        display: block
    }

    .el-upload-list__item.is-success .el-upload-list__item-name:hover {
        color: #20a0ff;
        cursor: pointer
    }

    .el-upload-list__item.is-success:hover .el-upload-list__item-status-label {
        display: none
    }
    .el-upload-list__item-name [class^=el-icon] {
        color: #97a8be;
        margin-right: 7px;
        height: 100%;
        line-height: inherit
    }

    .el-upload-list--picture-card .el-upload-list__item {
        overflow: hidden;
        background-color: #fff;
        border: 1px solid #c0ccda;
        border-radius: 6px;
        box-sizing: border-box;
        width: 148px;
        height: 148px;
        margin: 0 8px 8px 0;
        display: inline-block
    }

    .el-upload-list--picture-card .el-upload-list__item .el-icon-check, .el-upload-list--picture-card .el-upload-list__item .el-icon-circle-check {
        color: #fff
    }

    .el-upload-list--picture-card .el-upload-list__item .el-icon-close, .el-upload-list--picture-card .el-upload-list__item:hover .el-upload-list__item-status-label {
        display: none
    }

    .el-upload-list--picture-card .el-upload-list__item:hover .el-progress__text {
        display: block
    }

    .el-upload-list--picture-card .el-upload-list__item-name {
        display: none
    }

    .el-upload-list--picture-card .el-upload-list__item-thumbnail {
        width: 100%;
        height: 100%
    }

    .el-upload-list--picture-card .el-upload-list__item-status-label {
        position: absolute;
        right: -15px;
        top: -6px;
        width: 40px;
        height: 24px;
        background: #13ce66;
        text-align: center;
        -ms-transform: rotate(45deg);
        transform: rotate(45deg);
        box-shadow: 0 0 1pc 1px rgba(0, 0, 0, .2)
    }

    .el-upload-list--picture-card .el-upload-list__item-status-label i {
        font-size: 12px;
        margin-top: 11px;
        -ms-transform: rotate(-45deg) scale(.8);
        transform: rotate(-45deg) scale(.8)
    }

    .el-upload-list--picture-card .el-upload-list__item-actions {
        position: absolute;
        width: 100%;
        height: 100%;
        left: 0;
        top: 0;
        cursor: default;
        text-align: center;
        color: #fff;
        opacity: 0;
        font-size: 20px;
        background-color: rgba(0, 0, 0, .5);
        transition: opacity .3s
    }

    .el-upload-list--picture-card .el-upload-list__item-actions:after {
        display: inline-block;
        content: "";
        height: 100%;
        vertical-align: middle
    }

    .el-upload-list--picture-card .el-upload-list__item-actions span {
        display: none;
        cursor: pointer
    }

    .el-upload-list--picture-card .el-upload-list__item-actions span + span {
        margin-left: 15px
    }

    .el-upload-list--picture-card .el-upload-list__item-actions .el-upload-list__item-delete {
        position: static;
        font-size: inherit;
        color: inherit
    }

    .el-upload-list--picture-card .el-upload-list__item-actions:hover {
        opacity: 1
    }

    .el-upload-list--picture-card .el-upload-list__item-actions:hover span {
        display: inline-block
    }

    .el-upload-list--picture-card .el-progress {
        top: 50%;
        left: 50%;
        -ms-transform: translate(-50%, -50%);
        transform: translate(-50%, -50%);
        bottom: auto;
        width: 126px
    }

    .el-upload-list--picture-card .el-progress .el-progress__text {
        top: 50%
    }

    .el-upload-list--picture .el-upload-list__item {
        overflow: hidden;
        background-color: #fff;
        border: 1px solid #c0ccda;
        border-radius: 6px;
        box-sizing: border-box;
        margin-top: 10px;
        padding: 10px 10px 10px 90px;
        height: 92px
    }

    .el-upload-list--picture .el-upload-list__item .el-icon-check, .el-upload-list--picture .el-upload-list__item .el-icon-circle-check {
        color: #fff
    }

    .el-upload-list--picture .el-upload-list__item:hover .el-upload-list__item-status-label {
        background: 0 0;
        box-shadow: none;
        top: -2px;
        right: -12px
    }

    .el-upload-list--picture .el-upload-list__item:hover .el-progress__text {
        display: block
    }

    .el-upload-list--picture .el-upload-list__item.is-success .el-upload-list__item-name {
        line-height: 70px;
        margin-top: 0
    }

    .el-upload-list--picture .el-upload-list__item.is-success .el-upload-list__item-name i {
        display: none
    }

    .el-upload-list--picture .el-upload-list__item-thumbnail {
        vertical-align: middle;
        display: inline-block;
        width: 70px;
        height: 70px;
        float: left;
        position: relative;
        z-index: 1;
        margin-left: -80px
    }

    .el-upload-list--picture .el-upload-list__item-name {
        display: block;
        margin-top: 20px
    }

    .el-upload-list--picture .el-upload-list__item-name i {
        font-size: 70px;
        line-height: 1;
        position: absolute;
        left: 9px;
        top: 10px
    }

    .el-upload-list--picture .el-upload-list__item-status-label {
        position: absolute;
        right: -17px;
        top: -7px;
        width: 46px;
        height: 26px;
        background: #13ce66;
        text-align: center;
        -ms-transform: rotate(45deg);
        transform: rotate(45deg);
        box-shadow: 0 1px 1px #ccc
    }

    .el-upload-list--picture .el-upload-list__item-status-label i {
        font-size: 12px;
        margin-top: 12px;
        -ms-transform: rotate(-45deg) scale(.8);
        transform: rotate(-45deg) scale(.8)
    }

    .el-upload-list--picture .el-progress {
        position: relative;
        top: -7px
    }
    .el-upload-cover img {
        display: block;
        width: 100%;
        height: 100%
    }

    .el-upload-cover + .el-upload__inner {
        opacity: 0;
        position: relative;
        z-index: 1
    }

    .el-upload-cover__label i {
        font-size: 12px;
        margin-top: 11px;
        -ms-transform: rotate(-45deg) scale(.8);
        transform: rotate(-45deg) scale(.8);
        color: #fff
    }
    .el-upload-cover__progress + .el-upload__inner {
        opacity: 0
    }
    .el-upload-cover__interact .btn {
        display: inline-block;
        color: #fff;
        font-size: 14px;
        cursor: pointer;
        vertical-align: middle;
        transition: transform .3s cubic-bezier(.23, 1, .32, 1) .1s, opacity .3s cubic-bezier(.23, 1, .32, 1) .1s;
        margin-top: 60px
    }

    .el-upload-cover__interact .btn span {
        opacity: 0;
        transition: opacity .15s linear
    }

    .el-upload-cover__interact .btn:not(:first-child) {
        margin-left: 35px
    }

    .el-upload-cover__interact .btn:hover {
        -ms-transform: translateY(-13px);
        transform: translateY(-13px)
    }

    .el-upload-cover__interact .btn:hover span {
        opacity: 1
    }

    .el-upload-cover__interact .btn i {
        color: #fff;
        display: block;
        font-size: 24px;
        line-height: inherit;
        margin: 0 auto 5px
    }
    .el-progress.is-exception .el-progress-bar__inner {
        background-color: #ff4949
    }

    .el-progress.is-exception .el-progress__text {
        color: #ff4949
    }

    .el-progress.is-success .el-progress-bar__inner {
        background-color: #13ce66
    }

    .el-progress.is-success .el-progress__text {
        color: #13ce66
    }
    .el-progress__text i {
        vertical-align: middle;
        display: block
    }
    .el-progress--circle .el-progress__text {
        position: absolute;
        top: 50%;
        left: 0;
        width: 100%;
        text-align: center;
        margin: 0;
        -ms-transform: translate(0, -50%);
        transform: translate(0, -50%)
    }

    .el-progress--circle .el-progress__text i {
        vertical-align: middle;
        display: inline-block
    }

    .el-progress--without-text .el-progress__text {
        display: none
    }

    .el-progress--without-text .el-progress-bar {
        padding-right: 0;
        margin-right: 0;
        display: block
    }
    .el-progress--text-inside .el-progress-bar {
        padding-right: 0;
        margin-right: 0
    }
    @keyframes progress {
        0% {
            background-position: 0 0
        }
        100% {
            background-position: 32px 0
        }
    }
    .el-spinner-inner .path {
        stroke: #ececec;
        stroke-linecap: round;
        animation: dash 1.5s ease-in-out infinite
    }

    @keyframes rotate {
        100% {
            transform: rotate(360deg)
        }
    }

    @keyframes dash {
        0% {
            stroke-dasharray: 1, 150;
            stroke-dashoffset: 0
        }
        50% {
            stroke-dasharray: 90, 150;
            stroke-dashoffset: -35
        }
        100% {
            stroke-dasharray: 90, 150;
            stroke-dashoffset: -124
        }
    }
    .el-message .el-icon-circle-check {
        color: #13ce66
    }

    .el-message .el-icon-circle-cross {
        color: #ff4949
    }

    .el-message .el-icon-information {
        color: #50bfff
    }

    .el-message .el-icon-warning {
        color: #f7ba2a
    }
    .el-message__group p {
        font-size: 14px;
        margin: 0 34px 0 0;
        color: #8391a5;
        text-align: justify
    }
    .el-steps > :last-child .el-step__line {
        display: none
    }

    .el-step.is-horizontal, .el-step.is-vertical .el-step__head, .el-step.is-vertical .el-step__main, .el-step__line {
        display: inline-block
    }
    .el-step:last-child .el-step__main {
        padding-right: 0
    }

    .el-step.is-vertical .el-step__main {
        padding-left: 10px
    }
    .el-step__icon > * {
        line-height: inherit;
        vertical-align: middle
    }

    .el-carousel__arrow i {
        cursor: pointer
    }
    .el-carousel__indicators--outside .el-carousel__indicator:hover button {
        opacity: .64
    }

    .el-carousel__indicators--outside button {
        background-color: #8391a5;
        opacity: .24
    }
    .el-carousel__indicators--labels .el-carousel__button {
        width: auto;
        height: auto;
        padding: 2px 18px;
        font-size: 12px
    }

    .el-carousel__indicators--labels .el-carousel__indicator {
        padding: 6px 4px
    }
    .el-carousel__indicator:hover button {
        opacity: .72
    }

    .el-carousel__indicator.is-active button {
        opacity: 1
    }
    .el-scrollbar:active .el-scrollbar__bar, .el-scrollbar:focus .el-scrollbar__bar, .el-scrollbar:hover .el-scrollbar__bar {
        opacity: 1;
        transition: opacity 340ms ease-out
    }
    .el-scrollbar__bar.is-horizontal > div {
        height: 100%
    }
    .el-scrollbar__bar.is-vertical > div {
        width: 100%
    }
    .el-carousel__item--card.is-in-stage.is-hover .el-carousel__mask, .el-carousel__item--card.is-in-stage:hover .el-carousel__mask {
        opacity: .12
    }

    .el-collapse-item.is-active > .el-collapse-item__header .el-collapse-item__header__arrow {
        -ms-transform: rotate(90deg);
        transform: rotate(90deg)
    }
    .el-cascader .el-input, .el-cascader .el-input__inner {
        cursor: pointer
    }

    .el-cascader .el-input__icon {
        transition: none
    }

    .el-cascader .el-icon-caret-bottom {
        transition: transform .3s
    }

    .el-cascader .el-icon-caret-bottom.is-reverse {
        -ms-transform: rotate(180deg);
        transform: rotateZ(180deg)
    }

    .el-cascader.is-disabled .el-cascader__label {
        z-index: 2;
        color: #bbb
    }
    .el-cascader__label span {
        color: #97a8be
    }

    .el-cascader--large .el-cascader__label {
        line-height: 40px
    }


    .el-cascader--small .el-cascader__label {
        line-height: 28px
    }
    .el-color-hue-slider.is-vertical .el-color-hue-slider__bar {
        background: linear-gradient(to bottom, red 0, #ff0 17%, #0f0 33%, #0ff 50%, #00f 67%, #f0f 83%, red 100%)
    }

    .el-color-hue-slider.is-vertical .el-color-hue-slider__thumb {
        left: 0;
        top: 0;
        width: 100%;
        height: 4px
    }

    .el-color-svpanel__cursor > div {
        cursor: head;
        width: 4px;
        height: 4px;
        box-shadow: 0 0 0 1.5px #fff, inset 0 0 1px 1px rgba(0, 0, 0, .3), 0 0 1px 2px rgba(0, 0, 0, .4);
        border-radius: 50%;
        -ms-transform: translate(-2px, -2px);
        transform: translate(-2px, -2px)
    }
    .el-color-alpha-slider.is-vertical .el-color-alpha-slider__bar {
        background: linear-gradient(to bottom, rgba(255, 255, 255, 0) 0, rgba(255, 255, 255, 1) 100%)
    }

    .el-color-alpha-slider.is-vertical .el-color-alpha-slider__thumb {
        left: 0;
        top: 0;
        width: 100%;
        height: 4px
    }

    .el-input {
        position: relative;
        font-size: 14px;
        display: inline-block;
        width: 100%
    }

    .el-input.is-disabled .el-input__inner {
        background-color: #eef1f6;
        border-color: #d1dbe5;
        color: #bbb;
        cursor: not-allowed
    }

    .el-input.is-disabled .el-input__inner::-webkit-input-placeholder {
        color: #bfcbd9
    }

    .el-input.is-disabled .el-input__inner::-moz-placeholder {
        color: #bfcbd9
    }

    .el-input.is-disabled .el-input__inner:-ms-input-placeholder {
        color: #bfcbd9
    }

    .el-input.is-disabled .el-input__inner::placeholder {
        color: #bfcbd9
    }

    .el-input.is-active .el-input__inner {
        outline: 0;
        border-color: #20a0ff
    }

    .el-input__inner {
        -webkit-appearance: none;
        -moz-appearance: none;
        appearance: none;
        background-color: #fff;
        background-image: none;
        border-radius: 4px;
        border: 1px solid #bfcbd9;
        box-sizing: border-box;
        color: #1f2d3d;
        display: block;
        font-size: inherit;
        height: 36px;
        line-height: 1;
        outline: 0;
        padding: 3px 10px;
        transition: border-color .2s cubic-bezier(.645, .045, .355, 1);
        width: 100%
    }

    .el-button, .el-checkbox-button__inner {
        -webkit-appearance: none;
        -moz-user-select: none;
        -webkit-user-select: none;
        -ms-user-select: none;
        outline: 0;
        text-align: center
    }

    .el-input__inner::-webkit-input-placeholder {
        color: #97a8be
    }

    .el-input__inner::-moz-placeholder {
        color: #97a8be
    }

    .el-input__inner:-ms-input-placeholder {
        color: #97a8be
    }

    .el-input__inner::placeholder {
        color: #97a8be
    }

    .el-input__inner:hover {
        border-color: #8391a5
    }

    .el-input__inner:focus {
        outline: 0;
        border-color: #20a0ff
    }
    .el-input__icon + .el-input__inner {
        padding-right: 35px
    }

    .el-input__icon.is-clickable:hover + .el-input__inner {
        border-color: #8391a5
    }
    .el-input--large .el-input__inner {
        height: 42px
    }
    .el-input--small .el-input__inner {
        height: 30px
    }
    .el-input--mini .el-input__inner {
        height: 22px
    }

    .el-input-group > .el-input__inner {
        vertical-align: middle;
        display: table-cell
    }

    .el-input-group--prepend .el-input__inner, .el-input-group__append {
        border-top-left-radius: 0;
        border-bottom-left-radius: 0
    }

    .el-input-group--append .el-input__inner, .el-input-group__prepend {
        border-top-right-radius: 0;
        border-bottom-right-radius: 0
    }

    .el-input-group__append .el-button, .el-input-group__append .el-select, .el-input-group__prepend .el-button, .el-input-group__prepend .el-select {
        display: block;
        margin: -10px
    }

    .el-input-group__append button.el-button, .el-input-group__append div.el-select .el-input__inner, .el-input-group__append div.el-select:hover .el-input__inner, .el-input-group__prepend button.el-button, .el-input-group__prepend div.el-select .el-input__inner, .el-input-group__prepend div.el-select:hover .el-input__inner {
        border-color: transparent;
        background-color: transparent;
        color: inherit;
        border-top: 0;
        border-bottom: 0
    }

    .el-input-group__append .el-button, .el-input-group__append .el-input, .el-input-group__prepend .el-button, .el-input-group__prepend .el-input {
        font-size: inherit
    }

    .el-button, .el-textarea__inner {
        font-size: 14px;
        box-sizing: border-box
    }
    .el-textarea.is-disabled .el-textarea__inner {
        background-color: #eef1f6;
        border-color: #d1dbe5;
        color: #bbb;
        cursor: not-allowed
    }

    .el-textarea.is-disabled .el-textarea__inner::-webkit-input-placeholder {
        color: #bfcbd9
    }

    .el-textarea.is-disabled .el-textarea__inner::-moz-placeholder {
        color: #bfcbd9
    }

    .el-textarea.is-disabled .el-textarea__inner:-ms-input-placeholder {
        color: #bfcbd9
    }

    .el-textarea.is-disabled .el-textarea__inner::placeholder {
        color: #bfcbd9
    }
    .el-button {
        display: inline-block;
        line-height: 1;
        white-space: nowrap;
        cursor: pointer;
        background: #fff;
        border: 1px solid #bfcbd9;
        color: #1f2d3d;
        margin: 0;
        padding: 10px 15px;
        border-radius: 4px
    }

    .el-button + .el-button {
        margin-left: 10px
    }

    .el-button:focus, .el-button:hover {
        color: #20a0ff;
        border-color: #20a0ff
    }

    .el-button:active {
        color: #1d90e6;
        border-color: #1d90e6;
        outline: 0
    }

    .el-button::-moz-focus-inner {
        border: 0
    }

    .el-button [class*=el-icon-] + span {
        margin-left: 5px
    }

    .el-button.is-loading {
        position: relative;
        pointer-events: none
    }

    .el-button.is-loading:before {
        pointer-events: none;
        content: '';
        position: absolute;
        left: -1px;
        top: -1px;
        right: -1px;
        bottom: -1px;
        border-radius: inherit;
        background-color: rgba(255, 255, 255, .35)
    }

    .el-button.is-disabled, .el-button.is-disabled:focus, .el-button.is-disabled:hover {
        color: #bfcbd9;
        cursor: not-allowed;
        background-image: none;
        background-color: #eef1f6;
        border-color: #d1dbe5
    }
    .el-button.is-disabled.el-button--text {
        background-color: transparent
    }

    .el-button.is-disabled.is-plain, .el-button.is-disabled.is-plain:focus, .el-button.is-disabled.is-plain:hover {
        background-color: #fff;
        border-color: #d1dbe5;
        color: #bfcbd9
    }

    .el-button.is-active {
        color: #1d90e6;
        border-color: #1d90e6
    }

    .el-button.is-plain:focus, .el-button.is-plain:hover {
        background: #fff;
        border-color: #20a0ff;
        color: #20a0ff
    }

    .el-button.is-plain:active {
        background: #fff;
        border-color: #1d90e6;
        color: #1d90e6;
        outline: 0
    }

    .el-button--primary {
        color: #fff;
        background-color: #20a0ff;
        border-color: #20a0ff
    }

    .el-button--primary:focus, .el-button--primary:hover {
        background: #4db3ff;
        border-color: #4db3ff;
        color: #fff
    }

    .el-button--primary.is-active, .el-button--primary:active {
        background: #1d90e6;
        border-color: #1d90e6;
        color: #fff
    }

    .el-button--primary:active {
        outline: 0
    }

    .el-button--primary.is-plain {
        background: #fff;
        border: 1px solid #bfcbd9;
        color: #1f2d3d
    }

    .el-button--primary.is-plain:focus, .el-button--primary.is-plain:hover {
        background: #fff;
        border-color: #20a0ff;
        color: #20a0ff
    }

    .el-button--primary.is-plain:active {
        background: #fff;
        border-color: #1d90e6;
        color: #1d90e6;
        outline: 0
    }
    .el-button-group .el-button--primary:first-child {
        border-right-color: rgba(255, 255, 255, .5)
    }

    .el-button-group .el-button--primary:last-child {
        border-left-color: rgba(255, 255, 255, .5)
    }

    .el-button-group .el-button--primary:not(:first-child):not(:last-child) {
        border-left-color: rgba(255, 255, 255, .5);
        border-right-color: rgba(255, 255, 255, .5)
    }

    .el-button-group .el-button--success:first-child {
        border-right-color: rgba(255, 255, 255, .5)
    }

    .el-button-group .el-button--success:last-child {
        border-left-color: rgba(255, 255, 255, .5)
    }

    .el-button-group .el-button--success:not(:first-child):not(:last-child) {
        border-left-color: rgba(255, 255, 255, .5);
        border-right-color: rgba(255, 255, 255, .5)
    }

    .el-button-group .el-button--warning:first-child {
        border-right-color: rgba(255, 255, 255, .5)
    }

    .el-button-group .el-button--warning:last-child {
        border-left-color: rgba(255, 255, 255, .5)
    }

    .el-button-group .el-button--warning:not(:first-child):not(:last-child) {
        border-left-color: rgba(255, 255, 255, .5);
        border-right-color: rgba(255, 255, 255, .5)
    }

    .el-button-group .el-button--danger:first-child {
        border-right-color: rgba(255, 255, 255, .5)
    }

    .el-button-group .el-button--danger:last-child {
        border-left-color: rgba(255, 255, 255, .5)
    }

    .el-button-group .el-button--danger:not(:first-child):not(:last-child) {
        border-left-color: rgba(255, 255, 255, .5);
        border-right-color: rgba(255, 255, 255, .5)
    }

    .el-button-group .el-button--info:first-child {
        border-right-color: rgba(255, 255, 255, .5)
    }

    .el-button-group .el-button--info:last-child {
        border-left-color: rgba(255, 255, 255, .5)
    }

    .el-button-group .el-button--info:not(:first-child):not(:last-child) {
        border-left-color: rgba(255, 255, 255, .5);
        border-right-color: rgba(255, 255, 255, .5)
    }

    .el-button-group .el-button {
        float: left;
        position: relative
    }

    .el-button-group .el-button + .el-button {
        margin-left: 0
    }

    .el-button-group .el-button:first-child {
        border-top-right-radius: 0;
        border-bottom-right-radius: 0
    }

    .el-button-group .el-button:last-child {
        border-top-left-radius: 0;
        border-bottom-left-radius: 0
    }

    .el-button-group .el-button:not(:first-child):not(:last-child) {
        border-radius: 0
    }

    .el-button-group .el-button:not(:last-child) {
        margin-right: -1px
    }

    .el-button-group .el-button.is-active, .el-button-group .el-button:active, .el-button-group .el-button:focus, .el-button-group .el-button:hover {
        z-index: 1
    }
    .el-checkbox + .el-checkbox {
        margin-left: 15px
    }

    .el-checkbox__input.is-indeterminate .el-checkbox__inner {
        background-color: #20a0ff;
        border-color: #0190fe
    }

    .el-checkbox__input.is-indeterminate .el-checkbox__inner::before {
        content: '';
        position: absolute;
        display: block;
        border: 1px solid #fff;
        margin-top: -1px;
        left: 3px;
        right: 3px;
        top: 50%
    }

    .el-checkbox__input.is-indeterminate .el-checkbox__inner::after {
        display: none
    }

    .el-checkbox__input.is-focus .el-checkbox__inner {
        border-color: #20a0ff
    }

    .el-checkbox__input.is-checked .el-checkbox__inner {
        background-color: #20a0ff;
        border-color: #0190fe
    }

    .el-checkbox__input.is-checked .el-checkbox__inner::after {
        -ms-transform: rotate(45deg) scaleY(1);
        transform: rotate(45deg) scaleY(1)
    }

    .el-checkbox__input.is-disabled .el-checkbox__inner {
        background-color: #eef1f6;
        border-color: #d1dbe5;
        cursor: not-allowed
    }

    .el-checkbox__input.is-disabled .el-checkbox__inner::after {
        cursor: not-allowed;
        border-color: #eef1f6
    }

    .el-checkbox__input.is-disabled .el-checkbox__inner + .el-checkbox__label {
        cursor: not-allowed
    }

    .el-checkbox__input.is-disabled.is-checked .el-checkbox__inner {
        background-color: #d1dbe5;
        border-color: #d1dbe5
    }

    .el-checkbox__input.is-disabled.is-checked .el-checkbox__inner::after {
        border-color: #fff
    }

    .el-checkbox__input.is-disabled.is-indeterminate .el-checkbox__inner {
        background-color: #d1dbe5;
        border-color: #d1dbe5
    }

    .el-checkbox__input.is-disabled.is-indeterminate .el-checkbox__inner::before {
        border-color: #fff
    }

    .el-checkbox__input.is-disabled + .el-checkbox__label {
        color: #bbb;
        cursor: not-allowed
    }
    .el-checkbox-button.is-checked .el-checkbox-button__inner {
        color: #fff;
        background-color: #20a0ff;
        border-color: #20a0ff;
        box-shadow: -1px 0 0 0 #20a0ff
    }

    .el-checkbox-button.is-disabled .el-checkbox-button__inner {
        color: #bfcbd9;
        cursor: not-allowed;
        background-image: none;
        background-color: #eef1f6;
        border-color: #d1dbe5;
        box-shadow: none
    }
    .el-checkbox-button.is-focus .el-checkbox-button__inner {
        border-color: #20a0ff
    }

    .el-checkbox-button:first-child .el-checkbox-button__inner {
        border-left: 1px solid #bfcbd9;
        border-radius: 4px 0 0 4px;
        box-shadow: none !important
    }

    .el-checkbox-button:last-child .el-checkbox-button__inner {
        border-radius: 0 4px 4px 0
    }
    .el-checkbox-button__inner [class*=el-icon-] {
        line-height: .9
    }

    .el-checkbox-button__inner [class*=el-icon-] + span {
        margin-left: 5px
    }
    .el-checkbox-button--large .el-checkbox-button__inner {
        padding: 11px 19px;
        font-size: 16px;
        border-radius: 0
    }

    .el-checkbox-button--small .el-checkbox-button__inner {
        padding: 7px 9px;
        font-size: 12px;
        border-radius: 0
    }

    .el-checkbox-button--mini .el-checkbox-button__inner {
        padding: 4px;
        font-size: 12px;
        border-radius: 0
    }
    .el-transfer__buttons .el-button {
        display: block;
        margin: 0 auto;
        padding: 8px 12px
    }

    .el-transfer-panel__item + .el-transfer-panel__item, .el-transfer__buttons .el-button [class*=el-icon-] + span {
        margin-left: 0
    }

    .el-transfer__buttons .el-button:first-child {
        margin-bottom: 6px
    }
    .el-transfer-panel .el-transfer-panel__header {
        height: 36px;
        line-height: 36px;
        background: #fbfdff;
        margin: 0;
        padding-left: 20px;
        border-bottom: 1px solid #d1dbe5;
        box-sizing: border-box;
        color: #1f2d3d
    }

    .el-transfer-panel .el-transfer-panel__footer {
        height: 36px;
        background: #fff;
        margin: 0;
        padding: 0;
        border-top: 1px solid #d1dbe5;
        position: absolute;
        bottom: 0;
        left: 0;
        width: 100%;
        z-index: 1
    }

    .el-transfer-panel .el-transfer-panel__footer:after {
        display: inline-block;
        content: "";
        height: 100%;
        vertical-align: middle
    }

    .el-transfer-panel .el-transfer-panel__footer .el-checkbox {
        padding-left: 20px;
        color: #8391a5
    }

    .el-transfer-panel .el-transfer-panel__empty {
        margin: 0;
        height: 32px;
        line-height: 32px;
        padding: 6px 20px 0;
        color: #8391a5
    }

    .el-transfer-panel .el-checkbox__label {
        padding-left: 14px
    }

    .el-transfer-panel .el-checkbox__inner {
        width: 14px;
        height: 14px;
        border-radius: 3px
    }

    .el-transfer-panel .el-checkbox__inner::after {
        height: 6px;
        width: 3px;
        left: 4px
    }
    .el-transfer-panel__item .el-checkbox__label {
        width: 100%;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
        display: block;
        box-sizing: border-box;
        padding-left: 28px
    }

    .el-transfer-panel__item .el-checkbox__input {
        position: absolute;
        top: 9px
    }
    .el-transfer-panel__filter .el-input__inner {
        height: 22px;
        width: 100%;
        display: inline-block;
        box-sizing: border-box
    }

    .el-transfer-panel__filter .el-input__icon {
        right: 10px
    }

    .el-transfer-panel__filter .el-icon-circle-close {
        cursor: pointer
    }
    </style>
    <style type="text/css">
        .login-wrap[data-v-4b3ab49a] {
            position: relative;
            width: 100%;
            height: 100%;
        }

        .ms-title[data-v-4b3ab49a] {
            position: absolute;
            top: 50%;
            width: 100%;
            margin-top: -230px;
            text-align: center;
            font-size: 30px;
            color: #fff;
        }

        .ms-login[data-v-4b3ab49a] {
            position: absolute;
            left: 50%;
            top: 50%;
            width: 300px;
            height: 160px;
            margin: -150px 0 0 -190px;
            padding: 40px;
            border-radius: 5px;
            background: #fff;
        }

        .login-btn[data-v-4b3ab49a] {
            text-align: center;
        }

        .login-btn button[data-v-4b3ab49a] {
            width: 100%;
            height: 36px;
        }
    </style>

</head>

<body>
<div id="app">
    <div data-v-4b3ab49a="" class="login-wrap">
        <div data-v-4b3ab49a="" class="ms-title">后台管理系统</div>
        <div data-v-4b3ab49a="" class="ms-login">
            <form data-v-4b3ab49a="" class="el-form demo-ruleForm">
                <div data-v-4b3ab49a="" class="el-form-item is-required">
                    <div class="el-form-item__content" style="margin-left: 0px;">
                        <div data-v-4b3ab49a="" class="el-input">
							<input id="userCode" autocomplete="off" placeholder="username" type="text"
                                                                                      rows="2" validateevent="true"
                                                                                      class="el-input__inner">

						</div>
					</div>
                </div>
                <div data-v-4b3ab49a="" class="el-form-item is-required">
                    <div class="el-form-item__content" style="margin-left: 0px;">
                        <div data-v-4b3ab49a="" class="el-input">
							<input id="passWord" autocomplete="off" placeholder="password" type="password" rows="2"
                                                                                      validateevent="true"
                                                                                      class="el-input__inner">

						</div>
					</div>
                </div>
                <div data-v-4b3ab49a="" class="login-btn">
                    <button data-v-4b3ab49a="" onclick="login()" type="button" class="el-button el-button--primary">
						<span>登录</span>
					</button>
                </div>
                <p data-v-4b3ab49a="" style="font-size: 12px; line-height: 30px; color: rgb(153, 153, 153);">
					Tips :<span id="msg" color="red"></span></p></form>
        </div>
    </div>
</div>
</body>
</html>
