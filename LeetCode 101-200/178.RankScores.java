# Write your MySQL query statement below
SELECT S.Score, Dense_Rank() over(ORDER BY S.Score desc) AS 'Rank'
            from Scores S
