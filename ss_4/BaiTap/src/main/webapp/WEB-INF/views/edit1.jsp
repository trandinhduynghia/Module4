<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/28/2022
  Time: 7:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<style>

    #form table{
        border: black solid 1px;
        background-color: floralwhite;

    }
    #form tr, td{
        border: black solid 1px;
    }
</style>
<body>
<h3>Update Declaration</h3>

<div id="form">
    <form:form action="/declaration/update" modelAttribute="declaration" method="post">
        <table>
            <tr>
                <td>Id</td>
                <td><form:input type="text" path="id"/></td>
            </tr>
            <tr>
                <td>Họ tên</td>
                <td><form:input type="text" path="hoTen"/></td>
            </tr>
            <tr>
                <td>Giới tính</td>
                <td><form:input type="text" path="gioiTinh"/></td>
            </tr>
            <tr>
                <td>Quốc tịnh</td>
                <td><form:input type="text" path="quocTich"/></td>
            </tr>
            <tr>
                <td>CMND</td>
                <td><form:input type="text" path="CMND"/></td>
            </tr>
            <tr>
                <td>Thông tin đi lại</td>
                <td><form:input type="text" path="thongTinDiLai"/></td>
            </tr>
            <tr>
                <td>Số hiệu phương tiện</td>
                <td><form:input type="text" path="soHieuDiLai"/></td>
            </tr>
            <tr>
                <td>Số ghế</td>
                <td><form:input type="text" path="soGhe"/></td>
            </tr>
            <tr>
                <td>Ngày khởi hành</td>
                <td><form:input type="text" path="ngayKhoiHanh"/></td>
            </tr>
            <tr>
                <td>Ngày kết thúc</td>
                <td><form:input type="text" path="ngayKetThuc"/></td>
            </tr>
            <tr>
                <td>Trong 14 ngày qua, Anh/Chị có đến tỉnh thành phố nào?</td>
                <td><form:input type="text" path="denThanhPho"/></td>
            </tr>
            <tr>
                <td>Tỉnh/thành</td>
                <td><form:input type="text" path="tinh"/></td>
            </tr>
            <tr>
                <td>Quận/huyện</td>
                <td><form:input type="text" path="huyen"/></td>
            </tr>
            <tr>
                <td>Phường/xã</td>
                <td><form:input type="text" path="xa"/></td>
            </tr>
            <tr>
                <td>Địa chỉ nơi ở</td>
                <td><form:input type="text" path="diaChi"/></td>
            </tr>
            <tr>
                <td>Điện thoại</td>
                <td><form:input type="text" path="dienThoai"/></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><form:input type="text" path="email"/></td>
            </tr>
            <tr>
                <td>Sốt</td>
                <td><form:checkbox path="sot" /></td>
            </tr>
            <tr>
                <td>Ho</td>
                <td><form:checkbox path="ho" /></td>
            </tr>
            <tr>
                <td>Khó thở</td>
                <td><form:checkbox path="khoTho" /></td>
            </tr>
            <tr>
                <td>Đau họng</td>
                <td><form:checkbox path="dauHong" /></td>
            </tr>
            <tr>
                <td>Nôn</td>
                <td><form:checkbox path="non" /></td>
            </tr>
            <tr>
                <td>Tiêu chảy</td>
                <td><form:checkbox path="tieuChay" /></td>
            </tr>
            <tr>
                <td>Xuất huyết ngoài da</td>
                <td><form:checkbox path="xuatHuyetNgoaiDa" /></td>
            </tr>
            <tr>
                <td>Nổi ban ngoài da</td>
                <td><form:checkbox path="noiBanNgoaiDa" /></td>
            </tr>
            <tr>
                <td>Đến chăn trại chăn nuôi</td>
                <td><form:checkbox path="denNongTrai" /></td>
            </tr>
            <tr>
                <td>Tiếp xúc gần với người bị nhiễm</td>
                <td><form:checkbox path="tiepXucNguoiMac" /></td>
            </tr>
        </table>

        <input type="submit" value="Update"/>
    </form:form>

</div>
</body>
</html>
