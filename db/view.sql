CREATE VIEW `orderedDishesView` AS
select  o.id as orderId, 
	d.dishId as dishId,
	d.amount as amount, 
    h.name as name,
	d.price as price
from orders o, orderDish d, dish h where o.id = d.orderId and d.dishId=h.dishId;