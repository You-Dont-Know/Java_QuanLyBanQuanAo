create database QUANLYSHOPQUANAO
go

use QUANLYSHOPQUANAO
go
SET DATEFORMAT DMY
go

create table khachhang
(
  makh int identity not null,
  tenkhach nvarchar(50),
  diachi nvarchar(50),
  gioitinh nvarchar(3),
  sdt nvarchar(20),
  constraint pk_khachhang primary key (makh)
)

create table sanpham
(
  masanpham varchar(10) not null,
  tensanpham nvarchar(50),
  giasanpham float,
  motasanpham nvarchar(50),
  size nvarchar(10),
  ngaysanxuat DateTime,
  soluong int,
  constraint pk_sanpham primary key (masanpham)
)

create table nhanvien
(
  manhanvien varchar(10) not null,
  tennhanvien nvarchar(50),
  gioitinh nvarchar(10),
  ngaysinh date,
  diachi nvarchar(50),
  sdt nvarchar(20),
  tendangnhap varchar(50),
  matkhau varchar(50),
  chucvu nvarchar(30),
  constraint pk_nhanvien primary key (manhanvien)
)

create table hoadon
(
  sohd varchar(20) not null,
  manhanvien varchar(10),
  nhanvienlap nvarchar(50),
  ngaylap date,
  makh int,
  constraint pk_hoadon primary key (sohd),
  constraint fk_hoadon_nhanvien foreign key (manhanvien) references nhanvien(manhanvien),
  constraint fk_hoadon_khachhang foreign key (makh) references khachhang(makh)
)

create table cthoadon
(
  sohd varchar(20) not null,
  masanpham varchar(10) not null,
  sanpham nvarchar(50),
  dongia float,
  soluong int,
  tongtien float,
  constraint pk_cthoadon primary key (sohd,masanpham),
  constraint fk_cthoadon_hoadon foreign key (sohd) references hoadon(sohd),
  constraint fk_cthoadon_sanpham foreign key (masanpham) references sanpham(masanpham)
)
go
--1. Trigger cập nhật số lượng trong kho sau khi mua hàng 
CREATE TRIGGER TRIGGER_MUA
ON CTHOADON 
FOR INSERT
AS
	UPDATE SANPHAM
	SET soluong = SANPHAM.soluong - (
		SELECT soluong
		FROM inserted
		WHERE masanpham = SANPHAM.masanpham
	)
	FROM SANPHAM
	JOIN inserted ON SANPHAM.masanpham = inserted.masanpham
GO
--2. Trigger cập nhật hàng trong kho sau khi cập nhật mua hàng 
CREATE  TRIGGER TRIGGER_CAPNHAT 
on CTHOADON 
FOR update
AS
   UPDATE SANPHAM SET soluong = SANPHAM.soluong -
	   (SELECT soluong FROM inserted WHERE masanpham = SANPHAM.masanpham) +
	   (SELECT soluong FROM deleted WHERE masanpham = SANPHAM.masanpham)
   FROM SANPHAM 
   JOIN deleted ON SANPHAM.masanpham = deleted.masanpham

GO
--3. Trigger cập nhật hàng trong kho sau khi hủy mua hàng
create TRIGGER trigger_HUY
ON CTHOADON
FOR DELETE 
AS
	UPDATE SANPHAM
	SET soluong = SANPHAM.soluong + (SELECT soluong FROM deleted WHERE masanpham = SANPHAM.masanpham)
	FROM SANPHAM 
	JOIN deleted ON SANPHAM.masanpham = deleted.masanpham
GO
---------------------INSERT
INSERT INTO khachhang
VALUES
(N'TRẦN XUÂN PHÚC',N'TÂN PHÚ',N'NAM','0123456781'),
(N'NGUYỄN QUANG HẢI',N'QUẬN 12',N'NAM','0123456782'),
(N'TRẦN THỊ THU BÍCH',N'GÒ VẤP',N'NỮ','0123456783'),
(N'TRẦN ĐÌNH BẢO',N'TÂN BÌNH',N'NAM','0123456784'),
(N'LÊ THỊ BẢO TRÂN',N'QUẬN 1',N'NỮ','0123456784'),
(N'LÊ ĐÌNH TIẾN',N'BÌNH TÂN',N'NAM','0123456785'),
(N'NGUYỄN TIẾN GIA',N'QUẬN 5',N'NAM','0123456786'),
(N'NGUYỄN THỊ LAN',N'QUẬN 4',N'NỮ','0123456787'),
(N'VÕ XUÂN PHÚC',N'QUẬN 8',N'NAM','0123456788'),
(N'NGÔ HUY TRUNG',N'QUẬN 5',N'NAM','0123456789'),
(N'VÕ PHẠM NHƯ NGỌC',N'TÂN PHÚ',N'NỮ','0123456785');

INSERT INTO nhanvien
VALUES
('NV01',N'Trần Thái Chân',N'NAM','07/06/2000',N'Tân Phú',N'0988.438.442','chan','123',N'CHỦ SHOP'),
('NV02',N'Bùi Thị Như Hảo',N'NỮ','26/05/2000',N'Tân Bình',N'028.736.3764','hao','124',N'QUẢN LÝ'),
('NV03',N'Lê Minh Nhựt','NAM','01/10/2000',N'Bình Thạnh',N'038.343.8643','nhut','125',N'NHÂN VIÊN'),
('NV04',N'Trần Minh Nhân','NAM','29/11/2000',N'Gò Vấp',N'0961042098','nhan','125',N'NHÂN VIÊN');

INSERT INTO sanpham
VALUES
('SP01',N'ÁO THUN 1',50000,N'ÁO THUN TAY NGẮN TRƠN','M','10/11/2018',30,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\aothuntayngantron'),
('SP02',N'ÁO THUN 2',65000,N'ÁO THUN TAY NGẮN HỌA TIẾT','L','14/08/2018',40,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\aothuntaynganhoatiet'),
('SP03',N'ÁO THUN 3',45000,N'ÁO THUN TAY NGẮN CÓ CỔ','XL','01/05/2018',80,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\aothuntayngancoco'),
('SP04',N'ÁO THUN 4',80000,N'ÁO THUN TAY NGẮN IN HÌNH','M','19/07/2018',45,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\aothuntaynganinhinh'),
('SP05',N'ÁO THUN 5',75000,N'ÁO THUN TAY DÀI TRƠN','XL','10/09/2019',25,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\aothuntaydaitron'),
('SP06',N'ÁO THUN 6',70000,N'ÁO THUN TAY DÀI SỌC','L','11/04/2018',14,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\aothuntaydaisoc'),
('SP07',N'ÁO THUN 7',120000,N'ÁO THUN TAY DÀI LEN','L','25/03/2019',39,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\aothuntaydailen'),
('SP08',N'ÁO THUN 8',110000,N'ÁO THUN TAY HỌA TIẾT','M','17/10/2018',48,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\aothuntaydaihoatiet'),
('SP09',N'QUẦN SORT 1',100000,N'QUẦN SORT KAKI SỌC','L','24/11/2018',30,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\quansortkakisoc'),
('SP10',N'QUẦN SORT 2',90000,N'QUẦN SORT KAKI TRƠN','M','26/05/2019',30,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\quansortkakitron'),
('SP11',N'QUẦN SORT 3',110000,N'QUẦN SORT KAKI TÚI HỘP','XL','14/12/2018',50,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\quansortkakituihop'),
('SP12',N'QUẦN SORT 4',145000,N'QUẦN SORT JEAN TRƠN','M','16/03/2018',70,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\quansortjeantron'),
('SP13',N'QUẦN SORT 5',135000,N'QUẦN SORT JEAN RÁCH','L','17/10/2019',90,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\quansortjeanrach'),
('SP14',N'QUẦN SORT 6',120000,N'QUẦN SORT THUN','XL','10/09/2019',60,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\quansortthun'),
('SP15',N'QUẦN JEAN',445000,N'QUẦN JEAN M1QJN119008','XL','28/06/2018',32,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\quanjeanm1'),
('SP16',N'QUẦN JEAN',395000,N'QUẦN JEAN M1QJN100008','XL','11/09/2019',45,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\quanjeanm2'),
('SP17',N'QUẦN JOGGER',385000,N'QUẦN JOGGER M1QJG100001','XL','28/06/2018',60,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\quanjogger1'),
('SP19',N'QUẦN TÂY',445000,N'QUẦN TÂY M1QTY129041','XL','20/09/2019',51,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\quantay'),
('SP20',N'ÁO SƠ MI 1',275000,N'ÁO SOMI M1SMN050002','L','28/06/2018',25,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\aosomi1'),
('SP21',N'ÁO SƠ MI 2',275000,N'ÁO SOMI M1SMN050001','L','11/05/2018',31,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\aosomi2'),
('SP22',N'ÁO SƠ MI 3',275000,N'ÁO SOMI M1SMD020002','M','28/06/2018',50,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\aosomi3'),
('SP23',N'ÁO SƠ MI 4',295000,N'ÁO SOMI M1SMD050001','M','10/09/2019',100,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\aosomi4'),
('SP24',N'ÁO SƠ MI 5',275000,N'ÁO SOMI M1SMD040001','M','11/04/2018',20,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\aosomi5'),
('SP25',N'ÁO SƠ MI 6',285000,N'ÁO SOMI M1SMD030002','M','28/06/2018',60,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\aosomi6');

insert into hoadon
values
('HD01','NV01',N'Trần Thái Chân','16/05/2020',1),
('HD02','NV01',N'Trần Thái Chân','6/10/2020',2),
('HD03','NV03',N'Lê Minh Nhựt','06/02/2020',5),
('HD04','NV02',N'Bùi Thị Như Hảo','30/12/2020',10),
('HD05','NV03',N'Lê Minh Nhựt','04/05/2020',7),
('HD06','NV01',N'Trần Thái Chân','14/08/2020',4),
('HD07','NV03',N'Lê Minh Nhựt','22/06/2020',3),
('HD08','NV03',N'Lê Minh Nhựt','15/11/2020',6);

INSERT INTO cthoadon
VALUES
('HD01','SP03',N'ÁO THUN TAY NGẮN CÓ CỔ',45000,5,90000);
INSERT INTO cthoadon
VALUES
('HD02','SP02',N'ÁO THUN TAY NGẮN HỌA TIẾT',65000,3,195000);
INSERT INTO cthoadon
VALUES
('HD01','SP13',N'QUẦN SORT JEAN RÁCH',135000,8,270000);
INSERT INTO cthoadon
VALUES
('HD02','SP03',N'ÁO THUN TAY NGẮN CÓ CỔ',45000,2,90000);
INSERT INTO cthoadon
VALUES
('HD04','SP14',N'QUẦN SORT THUN',120000,3,360000);
INSERT INTO cthoadon
VALUES
('HD01','SP10',N'QUẦN SORT KAKI TRƠN',90000,3,180000);
INSERT INTO cthoadon
VALUES
('HD08','SP06',N'ÁO THUN TAY DÀI SỌC',70000,4,280000);
INSERT INTO cthoadon
VALUES
('HD05','SP10',N'QUẦN SORT KAKI TRƠN',90000,1,90000);

drop table cthoadon
drop table hoadon
drop table nhanvien
drop table khachhang
drop table sanpham
