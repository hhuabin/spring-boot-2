-- 1. 给用户表 `user` 创建 100w 条数据

-- 临时关闭唯一性检查，插入更快（会话级）
SET SESSION unique_checks = 0;
-- 关闭外键检查（本表无外键，保险起见）
SET SESSION foreign_key_checks = 0;
-- 调大递归深度
SET SESSION cte_max_recursion_depth = 1000000;

INSERT INTO `user`
(user_name, password, real_name, phone, birthday, gender,
 email, address, avatar, signature, status,
 last_login_time, last_login_ip, create_time)
WITH RECURSIVE seq AS (
  SELECT 1 AS n
  UNION ALL
  SELECT n + 1 FROM seq WHERE n < 1000000
)
SELECT
  CONCAT('user_', n + 0),                                        -- user_name 唯一
  MD5(RAND()),                                                   -- password
  CONCAT('姓名', n + 0),                                         -- real_name
  CONCAT('1', LPAD(n + 0, 10, '0')),                             -- phone 唯一 (1+10位)
  DATE_SUB(CURDATE(), INTERVAL FLOOR(RAND()*365*30) DAY),        -- birthday
  ELT(FLOOR(1 + RAND()*3), 0,1,2),                               -- gender
  CONCAT('user', n + 0, '@example.com'),                         -- email
  CONCAT('某省某市某区某街道', n + 0, '号'),                     -- address
  CONCAT('https://cdn.example.com/avatar/', (n + 0) % 1000, '.png'), -- avatar
  CONCAT('这是我的个性签名 ', n + 0),                            -- signature
  1,                                                             -- status
  NOW() - INTERVAL FLOOR(RAND()*365) DAY,                        -- last_login_time
  CONCAT('192.168.', (n+0) % 255, '.', (n*7) % 255),             -- last_login_ip
  NOW() - INTERVAL FLOOR(RAND()*365) DAY                         -- create_time
FROM seq;

-- 还原默认
SET SESSION unique_checks = 1;
SET SESSION foreign_key_checks = 1;
SET SESSION cte_max_recursion_depth = 1000;
