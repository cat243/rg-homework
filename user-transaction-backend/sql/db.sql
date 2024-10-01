-- 创建库
create database if not exists user_transaction;

-- 切换库
use user_transaction;

-- 用户表
create table if not exists user
(
    id           bigint auto_increment comment 'id' primary key,
    userName     varchar(256)                           null comment '用户昵称',
    userAccount  varchar(256)                           not null comment '账号',
    userAvatar   varchar(1024)                          null comment '用户头像',
    gender       tinyint                                null comment '性别，1表示男，0表示女',
    age          int                                    null comment '年龄',
    phone        varchar(256)                           null  comment '电话',
    userRole     varchar(256) default 'user'            not null comment '用户角色：user / admin',
    userPassword varchar(512)                           not null comment '密码',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除',
    constraint uni_userAccount
        unique (userAccount)
) comment '用户';

-- 创建商品表
create table  if not exists goods
(
    id           bigint auto_increment comment 'id' primary key,
    goodsTitle   varchar(256)    not null  comment '商品标题',
    description   varchar(512)    null  comment '商品描述',
    images      varchar(1024)    null comment '商品图片',
    tags        varchar(512)     null  comment '商品标签',
    prices      double           null  default 0 comment '价格',
    sellerId     int            null  comment '商家的id',
    num          bigint         null  comment '商品剩余的数量',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
);

-- 插入商品表表结构
INSERT INTO goods (goodsTitle, description, images, tags, prices, sellerId, num)
VALUES ('商品a', '这是商品a的描述', 'https://gw.alipayobjects.com/zos/rmsportal/KDpgvguMpGfqaHPjicRK.svg', '标签1,标签2', 99.99, 1, 100);

INSERT INTO goods (goodsTitle, description, images, tags, prices, sellerId, num)
VALUES ('商品2', '这是商品2的描述', 'https://m.baidu.com/sf/vsearch?pd=image_content&word=%E4%BA%AC%E5%89%A7%E7%8C%AB%E7%99%BD%E7%B3%96%E5%9B%BE%E7%89%87&tn=vsearch&atn=mediacy&fr=&sa=tkb&imgpn=1&imgspn=&tt=1&di=41943041&pi=0&cs=1250093720%2C644140981&imgos=2478990901%2C365804798&imgis=0%2C0&imgtype=0&ssrlid=7795750144431524617&imgcontent=%7B%22subjectJson%22%3A%7B%7D%7D&ssr=1', '标签1,标签2', 99.99, 1, 100),
       ('商品3', '这是商品3的描述', 'https://m.baidu.com/sf/vsearch?pd=image_content&word=%E4%BA%AC%E5%89%A7%E7%8C%AB%E7%99%BD%E7%B3%96%E5%9B%BE%E7%89%87&tn=vsearch&atn=mediacy&fr=&sa=tkb&imgpn=1&imgspn=&tt=1&di=41943041&pi=0&cs=1250093720%2C644140981&imgos=2478990901%2C365804798&imgis=0%2C0&imgtype=0&ssrlid=7795750144431524617&imgcontent=%7B%22subjectJson%22%3A%7B%7D%7D&ssr=1', '标签2,标签3', 99.99, 1, 100),
       ('商品4', '这是商品4的描述', 'https://m.baidu.com/sf/vsearch?pd=image_content&word=%E4%BA%AC%E5%89%A7%E7%8C%AB%E7%99%BD%E7%B3%96%E5%9B%BE%E7%89%87&tn=vsearch&atn=mediacy&fr=&sa=tkb&imgpn=1&imgspn=&tt=1&di=41943041&pi=0&cs=1250093720%2C644140981&imgos=2478990901%2C365804798&imgis=0%2C0&imgtype=0&ssrlid=7795750144431524617&imgcontent=%7B%22subjectJson%22%3A%7B%7D%7D&ssr=1', '标签2,标签3', 99.99, 1, 100);
