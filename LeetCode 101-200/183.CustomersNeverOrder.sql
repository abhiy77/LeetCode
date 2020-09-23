# Write your MySQL query statement below

SELECT Name as Customers FROM Customers 
    WHERE Customers.id 
    NOT IN (SELECT CustomerId FROM Orders);
