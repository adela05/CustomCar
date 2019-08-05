Custom Cars Scenario:

A client is running a custom car manufacturing firm. They hand build custom cars to order. They work with 5 different suppliers who all provide different parts.

Supplier A provides tires, brakes, rims, exhaust, and bumpers. 
Supplier B provides radios, speakers, miscellaneous electronics, upholstery, and trim. 
Supplier C provides fiberglass, steel, and molded plastic parts. 
Supplier D provides engines, differentials, catalytic converters, fuel pumps, and axles. 
Supplier E provides radiators, fans, belts, compressors, and heater cores.

******************************************************************
Client Requirements:

--Add new type of item to inventory and associate it with a specific vendor. 

--Add or update vendor information (name, email, phone)

--Update type of items in inventory  (part name, associated vendor, quantity in stock, price per item)

--Add a new individual item to the inventory (each type like brake can have hundreds of individual items each with a unique serial number. If we have 50 brakes in stock, there should be at least 50 entries in table of individual parts with brake as their type and a unique serial number for each)

--Delete individual items from inventory (when a new car is built, it should be associated with the requisite parts by serial number and those should be marked as “used” in a status column, they should not be removed from the database. Items will be deleted if they are lost or defective) 


--Search for low inventory (any item with less than 50 remaining in stock). 

--Add new orders with a start date and completion date (this should automatically decrement inventory by the specified amount on the start date - this requires scheduling a task to run on a given date. This should also associate individual parts serial numbers with this build and mark those parts as “used” in the individual parts table). 

--Delete orders (should mark any previously associated parts as unused). 

--Update quantity in stock of any part.

******************************************************************
Routes:

GET ("/inventory") - This lists all items in the inventory.

POST ("/inventory") - Adds new type of items and specific supplier in the inventory.

PUT ("/inventory/{id}"), takes in an Id number as a parameter - Updates types of items in the inventory.

DELETE ("/inventory") - This route deletes individual items from the inventory that are marked as "lost" or "defective".

GET ("/inventory/quantity"), does not take any parameter - List the quantity items less than 50 in stock. 