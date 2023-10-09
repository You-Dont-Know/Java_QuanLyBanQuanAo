create database QUANLYSHOPQUANAO
go

use QUANLYSHOPQUANAO
go
SET DATEFORMAT DMY
go

create table loaikhachhang(
	maloaikhachhang int ,
	tenloaikhachhang nvarchar(50),
	ghichu nvarchar(255),
	constraint pk_loaikhachhang primary key (maloaikhachhang)
)

create table khachhang
(
  makh int not null,
  tenkhach nvarchar(50),
  diachi nvarchar(50),
  gioitinh nvarchar(3),
  sdt nvarchar(20),
  maloaikhachhang int,
  constraint pk_khachhang primary key (makh),
  constraint fk_khachhang_loaikhachhang foreign key (maloaikhachhang) references loaikhachhang(maloaikhachhang)
)

--ALTER TABLE [dbo].[khachhang]  WITH CHECK ADD  CONSTRAINT [FK_khachhang_loaikhachhang] FOREIGN KEY([loaikhachhang])
--REFERENCES [dbo].[loaikhachhang] ([maloaikhachhang])
--GO
--ALTER TABLE [dbo].[khachhang] CHECK CONSTRAINT [FK_khachhang_loaikhachhang]
--GO

create table loaisanpham
(
	maloaisanpham int  NOT NULL,
	tenloaisanpham nvarchar(50) NOT NULL,
	constraint pk_loaisanpham primary key (maloaisanpham)
)


create table sanpham
(
  masanpham varchar(10) not null,
  tensanpham nvarchar(50),
  maloaisanpham int,
  gianhap float NOT NULL,
  giaban float NOT NULL,
  motasanpham nvarchar(50),
  size nvarchar(10),
  ngaysanxuat date,
  soluong int,
  anhsp image,
  constraint pk_sanpham primary key (masanpham),
  constraint fk_sanpham_loaisanpham foreign key (maloaisanpham) references loaisanpham(maloaisanpham)
)




--ALTER TABLE [dbo].[sanpham]  WITH CHECK ADD  CONSTRAINT [FK_sanpham_loaisanpham ] FOREIGN KEY([loaisanpham ])
--REFERENCES [dbo].[loaisanpham ] ([maloaisanpham ])
--GO
--ALTER TABLE [dbo].[sanpham] CHECK CONSTRAINT [FK_sanpham_loaisanpham ]
--GO
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
  chucvu nvarchar(30) ,
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

INSERT into loaikhachhang
VALUES 
(1, N'vip', N'giảm 10%'),
 (2, N'thường', N'giảm 0%'),
(3, N'sinh viên', N'giảm 5%');

INSERT INTO khachhang
VALUES
(1,N'TRẦN XUÂN PHÚC',N'TÂN PHÚ',N'NAM','0123456781',2),
(2,N'NGUYỄN QUANG HẢI',N'QUẬN 12',N'NAM','0123456782',2),
(3,N'TRẦN THỊ THU BÍCH',N'GÒ VẤP',N'NỮ','0123456783',3),
(4,N'TRẦN ĐÌNH BẢO',N'TÂN BÌNH',N'NAM','0123456784',3),
(5,N'LÊ THỊ BẢO TRÂN',N'QUẬN 1',N'NỮ','0123456784',1),
(6,N'LÊ ĐÌNH TIẾN',N'BÌNH TÂN',N'NAM','0123456785',1),
(7,N'NGUYỄN TIẾN GIA',N'QUẬN 5',N'NAM','0123456786',2),
(8,N'NGUYỄN THỊ LAN',N'QUẬN 4',N'NỮ','0123456787',3),
(9,N'VÕ XUÂN PHÚC',N'QUẬN 8',N'NAM','0123456788',2),
(10,N'NGÔ HUY TRUNG',N'QUẬN 5',N'NAM','0123456789',1),
(11,N'VÕ PHẠM NHƯ NGỌC',N'TÂN PHÚ',N'NỮ','0123456785',3);

INSERT INTO nhanvien
VALUES
('NV01',N'Nguyễn Trung Hiếu',N'NAM','07/06/2000',N'Tân Phú',N'0988.438.442','admin','123',N'CHỦ SHOP'),
('NV02',N'Bùi Thị Như Hảo',N'NỮ','26/05/2000',N'Tân Bình',N'028.736.3764','hao','124',N'QUẢN LÝ'),
('NV03',N'Lê Minh Nhựt','NAM','01/10/2000',N'Bình Thạnh',N'038.343.8643','nhut','125',N'NHÂN VIÊN'),
('NV04',N'Trần Minh Nhân','NAM','29/11/2000',N'Gò Vấp',N'0961042098','nhan','125',N'NHÂN VIÊN');

INSERT into loaisanpham VALUES 
(1, N'Áo Thun'),
 (2, N'Áo Sơ Mi'),
 (3, N'Quần Sort'),
 (4, N'Quần Tây'),
 (5, N'Quần Jean'),
 (6, N'Quần Jogger');

INSERT INTO sanpham
VALUES
('SP01',N'ÁO THUN 1',1,50000,55000,N'ÁO THUN TAY NGẮN TRƠN','M','10/11/2018',30,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\aothuntayngantron'),
('SP02',N'ÁO THUN 2',1,65000,70000,N'ÁO THUN TAY NGẮN HỌA TIẾT','L','14/08/2018',40,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\aothuntaynganhoatiet'),
('SP03',N'ÁO THUN 3',1,45000,60000,N'ÁO THUN TAY NGẮN CÓ CỔ','XL','01/05/2018',80,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\aothuntayngancoco'),
('SP04',N'ÁO THUN 4',1,80000,100000,N'ÁO THUN TAY NGẮN IN HÌNH','M','19/07/2018',45,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\aothuntaynganinhinh'),
('SP05',N'ÁO THUN 5',1,75000,80000,N'ÁO THUN TAY DÀI TRƠN','XL','10/09/2019',25,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\aothuntaydaitron'),
('SP06',N'ÁO THUN 6',1,70000,80000,N'ÁO THUN TAY DÀI SỌC','L','11/04/2018',14,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\aothuntaydaisoc'),
('SP07',N'ÁO THUN 7',1,120000,145000,N'ÁO THUN TAY DÀI LEN','L','25/03/2019',39,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\aothuntaydailen'),
('SP08',N'ÁO THUN 8',1,110000,115000,N'ÁO THUN TAY HỌA TIẾT','M','17/10/2018',48,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\aothuntaydaihoatiet'),
('SP09',N'QUẦN SORT 1',3,100000,105000,N'QUẦN SORT KAKI SỌC','L','24/11/2018',30,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\quansortkakisoc'),
('SP10',N'QUẦN SORT 2',3,90000,95000,N'QUẦN SORT KAKI TRƠN','M','26/05/2019',30,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\quansortkakitron'),
('SP11',N'QUẦN SORT 3',3,110000,120000,N'QUẦN SORT KAKI TÚI HỘP','XL','14/12/2018',50,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\quansortkakituihop'),
('SP12',N'QUẦN SORT 4',3,145000,255000,N'QUẦN SORT JEAN TRƠN','M','16/03/2018',70,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\quansortjeantron'),
('SP13',N'QUẦN SORT 5',3,135000,170000,N'QUẦN SORT JEAN RÁCH','L','17/10/2019',90,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\quansortjeanrach'),
('SP14',N'QUẦN SORT 6',3,120000,145000,N'QUẦN SORT THUN','XL','10/09/2019',60,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\quansortthun'),
('SP15',N'QUẦN JEAN',5,445000,545000,N'QUẦN JEAN M1QJN119008','XL','28/06/2018',32,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\quanjeanm1'),
('SP16',N'QUẦN JEAN',5,395000,450000,N'QUẦN JEAN M1QJN100008','XL','11/09/2019',45,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\quanjeanm2'),
('SP17',N'QUẦN JOGGER',6,385000,400000,N'QUẦN JOGGER M1QJG100001','XL','28/06/2018',60,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\quanjogger1'),
('SP19',N'QUẦN TÂY',4,445000,545000,N'QUẦN TÂY M1QTY129041','XL','20/09/2019',51,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\quantay'),
('SP20',N'ÁO SƠ MI 1',2,275000,300000,N'ÁO SOMI M1SMN050002','L','28/06/2018',25,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\aosomi1'),
('SP21',N'ÁO SƠ MI 2',2,275000,300000,N'ÁO SOMI M1SMN050001','L','11/05/2018',31,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\aosomi2'),
('SP22',N'ÁO SƠ MI 3',2,275000,295000,N'ÁO SOMI M1SMD020002','M','28/06/2018',50,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\aosomi3'),
('SP23',N'ÁO SƠ MI 4',2,295000,305000,N'ÁO SOMI M1SMD050001','M','10/09/2019',100,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\aosomi4'),
('SP24',N'ÁO SƠ MI 5',2,275000,300000,N'ÁO SOMI M1SMD040001','M','11/04/2018',20,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\aosomi5'),
('SP25',N'ÁO SƠ MI 6',2,285000,325000,N'ÁO SOMI M1SMD030002','M','28/06/2018',60,'D:\VisualStudio\Source\QuanLyShopQuanAo\QLSHOPQUANAO\Image\aosomi6');

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






