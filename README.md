## Hướng dẫn cài đặt chương trình:
### Yêu cầu: 
- Cài đặt Java JDK 17
- SQL Server

### Các bước cài đặt:
- Clone hoặc tải xuống repo
- Mở và chạy file ?.sql trong thư mục Database (SQL SERVER)
- Mở project bằng NetBeans IDE thêm các thư viện (file JAR) trong thư mục lib vào project
- Mở file src/quanlylaptop/Connect/ConnectDB.java: Thay đổi CODE, USERNAME và PASSWORD kết nối với SQL SERVER

### Chạy chương trình:
- Màn hình đăng nhập được hiển thị(chạy file login)
- Đăng nhập với tài khoản mặc định:
  * Tài khoản Admin
    ``` bash
      Tài khoản: admin
      Mật khẩu: 123
    ```
  * Tài khoản Employee
    ``` bash
      Tài khoản: trung0
      Mật khẩu: 123
    ```

#### Chức năng trưởng phòng (đăng nhập với admin)
- Đăng nhập/ đăng xuất
- Quản lý nhân viên:
  * Xem
  * Thêm
  * Sửa 
  * Xóa
  * Tìm kiếm nhân viên theo tên
  * Nhập/xuất dữ liệu giữa SQL và ACCOUNT.txt
  * Xem chi tiết các đơn hàng đã thực hiện bởi 1 nhân viên
- Báo cáo doanh thu
  * Tất cả:
    * Hiển thị tất cả
    * Hiển thị theo năm
    * Hiển thị theo tháng và năm

#### Chức năng nhân viên (đăng nhập với user)
- Đăng nhập/ đăng xuất
- Quản lý Laptop:
  * Hiển thị tất cả Laptop
  * Thêm Laptop mới
  * Sửa Laptop
  * Xóa Laptop
  * Tìm kiếm Laptop theo tên laptop
- Quản lý đơn hàng:
  * Hiển thị tất cả Laptop
  * Thêm vào giỏ hàng
  * Xóa Laptop trong giỏ hàng
  * Thanh toán để tạo đơn hàng
  * Tìm kiếm Laptop trong bảng Laptop
  * Hiện lịch sử giao dịch của nhân viên đó
