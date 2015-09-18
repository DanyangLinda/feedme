/**
 * @author Danyang Li
 */
function loadRestaurants(){
	restGet("/restaurants/restaurantList",GET_METHOD,renderLoadRestaurants,"#resultDiv1");
}

function renderLoadRestaurants(data){
	console.log(data);
	var list=data.rList;
	if(list==null || list.length==0){
		jQuery("#resultDiv1").html("No restuarant found.");
	}else{
		jQuery.each(list, function(i, object){
			var line="<li id="+i+" onclick=displayRestaurant("+ object.id+","+i+")>"+object.name+"</li>";
			jQuery("#rsrList").append(line);
		})
	}
}

function displayRestaurant(id,i){
	storage.setItem("index",i);
	storage.setItem("restaurantId", id);
	restGet("/restaurants/query?id="+id, GET_METHOD, renderDisplayRestaurant, "#resultDiv2");
}

function renderDisplayRestaurant(data){
	jQuery("#name").val(data.name);
	jQuery("#type").val(data.type);
	jQuery("#phone").val(data.phone);
	jQuery("#email").val(data.email);
	jQuery("#description").val(data.description);
}

function editRestaurant(param){
	if(storage.getItem("restaurantId")!=null){
		var Eid=param.name;
		jQuery("#"+Eid).removeAttr("readonly");
	}	
}

function closeEdit(){
	jQuery("#name").attr("readonly","readonly");
	jQuery("#type").attr("readonly","readonly");
	jQuery("#phone").attr("readonly","readonly");
	jQuery("#email").attr("readonly","readonly");
	jQuery("#description").attr("readonly","readonly");
}

function updateRestaurant(){
	var Rid=storage.getItem("restaurantId");
	if(Rid!=null){
		closeEdit();
		var restaurant=new Object();
		restaurant.id=Rid;
		restaurant.name=jQuery.trim(jQuery("#name").val());
		restaurant.type=jQuery.trim(jQuery("#type").val());
		restaurant.email=jQuery.trim(jQuery("#email").val());
		restaurant.phone=jQuery.trim(jQuery("#phone").val());
		restaurant.description=jQuery.trim(jQuery("#description").val());
		var putData = JSON.stringify(restaurant);
		console.log(putData);
		restSet("/restaurants/update", PUT_METHOD, putData, renderUpdate,"#resultDiv2");
	}	
}

function renderUpdate(data){
	jQuery("#resultDiv2").html("success");
	var updatedName=jQuery.trim(jQuery("#name").val());
	var index=storage.getItem("index");
	jQuery("#"+index).html(updatedName);
}

function addDish(){
	var Sid=storage.getItem("restaurantId");
	if (Did!=null){
		var name=jQuery.trim(jQuery("#dName").val());
		var type=jQuery.trim(jQuery("#dType").val());
		var price=jQuery.trim(jQuery("#dPrice").val());

		if(name!=null&&type!=null&&price!=null){
			var ingredient=jQuery.trim(jQuery("#dIngredient").val()); 
			var description=jQuery.trim(jQuery("#dDiscount").val());
			var discount=jQuery.trim(jQuery("#dDiscount").val());
			var dish=new Object();
			dish.shopId=Sid;
			dish.name=name;
			dish.type=type;
			dish.price=price;
			dish.discount=discount;
			dish.ingredient=ingredient;
			dish.description=description;
			var putData=JSON.stringify(dish);
			//restSet("/dishs/newdish", POST_METHOD, putData, renderAddDish,"#resultDiv3");
		}else{
			jQuery("#resultDiv3").html("Name, type and price can't be empty");
		}		
	}	
}

function renderAddDish(data){
	jQuery("#resultDiv3").html("Success");
}

function clean(){
	jQuery("#dName").val("");
	jQuery("#dType").val("");
	jQuery("#dPrice").val("");
	jQuery("#dDiscount").val("");
	jQuery("#dIngredient").val("");
	jQuery("#dDescription").val("");
}
