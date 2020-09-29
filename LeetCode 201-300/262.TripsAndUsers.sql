# Write your MySQL query statement below

SELECT tb1.Request_at AS Day, ROUND(SUM(CASE WHEN tb1.Status = 'completed' THEN 0
ELSE 1 END) / COUNT(*), 2) AS 'Cancellation Rate'
FROM Trips AS tb1
INNER JOIN Users AS tb2
ON tb1.Client_Id = tb2.Users_Id AND tb2.Banned ='No'
INNER JOIN Users As tb3
ON tb1.Driver_Id = tb3.Users_Id AND tb3.Banned = 'No'
WHERE tb1.Request_at BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY tb1.Request_at
ORDER BY Day;
