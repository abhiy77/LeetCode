# Write your MySQL query statement below

SELECT Email FROM 
    (SELECT Email,COUNT(Email) AS num FROM Person GROUP BY Email) as stats WHERE num  > 1;
