/*
Navicat MySQL Data Transfer

Source Server         : lzh@localhost
Source Server Version : 50559
Source Host           : localhost:3306
Source Database       : applets_shop

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2019-03-21 20:34:59
*/

create database applets_shop;
use applets_shop;

SET FOREIGN_KEY_CHECKS=0;

-- ------------------------------ ------------------------------ ------------------------------ ----------------------------
-- Table structure for login_user
-- ------------------------------ ------------------------------ ------------------------------ ----------------------------
DROP TABLE IF EXISTS login_user;
CREATE TABLE login_user (
id int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
name varchar(40) COLLATE utf8_bin NOT NULL COMMENT '姓名',
password varchar(50) NOT NULL COMMENT '密码',
rank varchar(50) NOT NULL COMMENT '等级',
age int(3)  COMMENT '年龄',
birth int(8)  COMMENT '生日',
phone varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '手机',
sex varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '性别',
email varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
remark varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
creationdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
modifieddate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
PRIMARY KEY (id) USING BTREE,
UNIQUE key login_user_name (name) USING BTREE
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='登陆用户';
;
-- ----------------------------
-- Records of login_user
-- ----------------------------
insert into login_user (name,password,rank,phone,sex,email,birth,age) VALUES ('admin','123456','0','13579013562','男','13579013562@gmail.com','19990101',21);


-- ------------------------------ ------------------------------ ------------------------------ ----------------------------
-- Table structure for wx_customer
-- ------------------------------ ------------------------------ ------------------------------ ----------------------------
DROP TABLE IF EXISTS wx_customer;
CREATE TABLE wx_customer (
   id int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
   nick varchar(40) COLLATE utf8_bin not NULL COMMENT '微信昵称',
   name varchar(40) COLLATE utf8_bin not NULL COMMENT '名称',
   phone varchar(40) COLLATE utf8_bin not NULL COMMENT '电话(唯一标识)',
   openId varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT 'openId',
   address varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
   remark varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
   creationdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   modifieddate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
   PRIMARY KEY (id) USING BTREE,
   UNIQUE key wx_customer_phone (phone) USING BTREE   
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='微信客户信息';


-- ------------------------------ ------------------------------ ------------------------------ ----------------------------
-- Table structure for division
-- ------------------------------ ------------------------------ ------------------------------ ----------------------------
DROP TABLE IF EXISTS division;
CREATE TABLE division (
   id int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
   code varchar(40) COLLATE utf8_bin not NULL COMMENT '分类代码',
   name varchar(40) COLLATE utf8_bin not NULL COMMENT '分类名称',
   remark varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
   creationdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   modifieddate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
   PRIMARY KEY (id) USING BTREE,
   UNIQUE key division_code (code) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='商品分类';


-- ------------------------------ ------------------------------ ------------------------------ ----------------------------
-- Table structure for m_product
-- ------------------------------ ------------------------------ ------------------------------ ----------------------------
DROP TABLE IF EXISTS m_product;
CREATE TABLE m_product (
   id int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
   code varchar(40) COLLATE utf8_bin not NULL COMMENT '商品代码',
   name varchar(40) COLLATE utf8_bin not NULL COMMENT '商品名称',
   long_name varchar(100) COLLATE utf8_bin not NULL COMMENT '商品长名称',
   division_id int(10) not NULL COMMENT '商品分类',
   pricelist decimal(10,2) not null comment '吊牌价',
   imgUrl varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '图片地址',
   remark varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
   creationdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   modifieddate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
   PRIMARY KEY (id) USING BTREE,
   UNIQUE key m_product_code (code) USING BTREE,
   CONSTRAINT FK_m_product_division_id FOREIGN KEY (division_id) REFERENCES division (id) ON DELETE CASCADE ON UPDATE CASCADE   
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='商品信息';


-- ------------------------------ ------------------------------ ------------------------------ ----------------------------
-- Table structure for m_sale
-- ------------------------------ ------------------------------ ------------------------------ ----------------------------
DROP TABLE IF EXISTS m_sale;
CREATE TABLE m_sale (
   id int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
   docno varchar(40) COLLATE utf8_bin not NULL COMMENT '销售单单据编号',
   billdate int(8) NOT NULL COMMENT '单据日期',
   wx_customer_id int(10) not NULL COMMENT '顾客id',
   tot_qty int(10) not null comment '总数量',
   tot_amt decimal(10,2) not null comment '总金额',
   status varchar(40) COLLATE utf8_bin not NULL COMMENT '单据状态',
   remark varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
   creationdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   modifieddate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
   PRIMARY KEY (id) USING BTREE,
   UNIQUE key m_sale_docno (docno) USING BTREE,
   CONSTRAINT FK_m_sale_wx_customer_id FOREIGN KEY (wx_customer_id) REFERENCES wx_customer (id) ON DELETE CASCADE ON UPDATE CASCADE      
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='销售单';



-- ------------------------------ ------------------------------ ------------------------------ ----------------------------
-- Table structure for m_saleitem
-- ------------------------------ ------------------------------ ------------------------------ ----------------------------
DROP TABLE IF EXISTS m_saleitem;
CREATE TABLE m_saleitem (
   id int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
   m_sale_id int(10) not NULL COMMENT '销售单单据id',   
   m_product_id int(10) not NULL COMMENT '商品档案id',   
   qty int(10) not null comment '数量',
   amt decimal(10,2) not null comment '金额',
   remark varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
   creationdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   modifieddate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
   PRIMARY KEY (id) USING BTREE,   
   CONSTRAINT FK_m_saleitem_m_sale_id FOREIGN KEY (m_sale_id) REFERENCES m_sale (id) ON DELETE CASCADE ON UPDATE CASCADE,
   CONSTRAINT FK_m_saleitem_m_product_id FOREIGN KEY (m_product_id) REFERENCES m_product (id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='销售单明细';



-- ------------------------------ ------------------------------ ------------------------------ ----------------------------
-- Table structure for m_saleitem
-- ------------------------------ ------------------------------ ------------------------------ ----------------------------
DROP TABLE IF EXISTS m_saleitem;
CREATE TABLE m_saleitem (
   id int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
   m_sale_id int(10) not NULL COMMENT '销售单单据id',   
   m_product_id int(10) not NULL COMMENT '商品档案id',   
   qty int(10) not null comment '数量',
   amt decimal(10,2) not null comment '金额',
   remark varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
   creationdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   modifieddate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
   PRIMARY KEY (id) USING BTREE,   
   CONSTRAINT FK_m_saleitem_m_sale_id FOREIGN KEY (m_sale_id) REFERENCES m_sale (id) ON DELETE CASCADE ON UPDATE CASCADE,
   CONSTRAINT FK_m_saleitem_m_product_id FOREIGN KEY (m_product_id) REFERENCES m_product (id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='销售单明细';


-- ------------------------------ ------------------------------ ------------------------------ ----------------------------
-- Table structure for m_cart
-- ------------------------------ ------------------------------ ------------------------------ ----------------------------
DROP TABLE IF EXISTS m_cart;
CREATE TABLE m_cart (
   id int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',   
   wx_customer_id int(10) not NULL COMMENT '顾客id',
   m_product_id int(10) not NULL COMMENT '商品档案id',   
   qty int(10) not null comment '数量',
   amt decimal(10,2) not null comment '金额',
   remark varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
   creationdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   modifieddate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
   PRIMARY KEY (id) USING BTREE,      
   CONSTRAINT FK_m_cart_m_product_id FOREIGN KEY (m_product_id) REFERENCES m_product (id) ON DELETE CASCADE ON UPDATE CASCADE,
   CONSTRAINT FK_m_cart_wx_customer_id FOREIGN KEY (wx_customer_id) REFERENCES wx_customer (id) ON DELETE CASCADE ON UPDATE CASCADE    
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='购物车';


alter table wx_customer modify name varchar(40) COLLATE utf8_bin DEFAULT NULL  COMMENT '名称';
alter table wx_customer modify phone varchar(40) COLLATE utf8_bin DEFAULT NULL  COMMENT '电话(唯一标识)';
alter table wx_customer rename column  nick to nickName;
alter table wx_customer add userUrl varchar(400) COLLATE utf8_bin DEFAULT NULL  COMMENT '微信头像';