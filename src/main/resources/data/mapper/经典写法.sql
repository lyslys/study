 ##mysql 字符串替换
 update 表名 set 字段名=REPLACE (字段名,'原来的值','要修改的值')

#解除sql_mode=only_full_group_by 这个异常
select @@GLOBAL.sql_mode;
set sql_mode ='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';