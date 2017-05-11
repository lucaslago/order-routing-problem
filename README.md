# order-routing-problem

**Antes de começar**:

* Fazer uma coisa de cada vez, baby steps! Desenvolver de maneira incremental.
* Pratique TDD
* Tentar resolver as coisas da maneira mais simples possivel para forçar escrever testes que vc n
  pensou ainda.
* Lembrar de refatorar após cada vez que o teste ficar verde
* Qual o próximo passo? o proximo passo é sempre o mais simples
* Se lembrar de red green refactor!!!

![](https://media.giphy.com/media/GHycyakNPWSoo/giphy.gif)

## Introduction 

An electronics company is planning to sell products worldwide. In order to supply the new demand, the company is going to create multiple warehouses around the world:

| Name  		| Shipping Methods 	| Capacity 
| -------- 		| ---------------- 	| --------
| Brazil 		| DHL, Fedex		|       15
| France  		| DHL, Fedex, UPS	|		10
| South Africa  | Fedex, UPS		|		10
| China  		| DHL				|		20
| Canada  		| Fedex				|		5

Each warehouse supports one or more shipping methods and has a capacity which means the number of units that it can handle in the same order.

Additionally, there is a strategy that can be applied for each order to prioritize the warehouses:

* None: no prioritization strategy.
* LargestInventory: for warehouses with more units available.
* ShortestInventory: for warehouses with less units available.
* LargestCapacity: for warehouses with higher capacity.

Finally, a customer order that will be fulfilled by one or more warehouses have a customer location, a shipping method, a cost saving strategy and a list of products with the required quantity for each one.

## Problem

The purpose of this problem is to fulfill an order choosing one or more warehouse from the table above with the following constraints:

1. The shipping method must be supported by the warehouse.
2. The required quantity must respect the warehouse capacity.
3. The prioritization strategy must be in compliance.

The input has two parts separated by a blank line:

1. List of warehouses and the products available in each one of them.
2. Customer order information with products.

Format:

    [Warehouse1] [Product1] [Quantity Available]
    ...
    [WarehouseN] [ProductN] [Quantity Available]
    
    [Shipping Method],[Prioritization Strategy]
    [Product1] [Quantity Needed]
    ...
    [ProductN] [Quantity Needed]

The output is a list of warehouses that will fulfill the order with the product and quantity. In addition, the message "Order cannot be fulfilled." should be given if one or more products are not available.

### Test Examples

#### Test Case #1 - Standard

##### Input

    Brazil Keyboard 2
    France Mouse 2

	DHL, None
    Keyboard 2

##### Output

    Brazil Keyboard 2

#### Test Case #2 - Shipping method

##### Input

    Brazil Mouse 2
    South Africa Mouse 2

	UPS, None
    Mouse 1

##### Output

    South Africa Mouse 1

#### Test Case #3 - Capacity

##### Input

    Canada Mouse 4
    Canada Keyboard 3
    France Keyboard 2

	FedEx, None
    Mouse 4
    Keyboard 3

##### Output

    Canada Mouse 4
    Canada Keyboard 1
    France Keyboard 2

#### Test Case #4 - Prioritize by largest inventory

##### Input

    China Mouse 4
    Brazil Mouse 3
    Brazil Keyboard 3
    France Mouse 2
    France Keyboard 2

	DHL, LargestInventory
    Mouse 1
    Keyboard 1

##### Output

    Brazil Mouse 1
    Brazil Keyboard 1

#### Test Case #5 - Prioritize by shortest inventory

##### Input

    China Mouse 4
    Brazil Mouse 3
    Brazil Keyboard 3
    France Keyboard 2

	DHL, ShortestInventory
    Mouse 1
    Keyboard 1

##### Output

    China Mouse 1
    France Keyboard 1

#### Test Case #5 - Prioritize by largest capacity

##### Input

    China Mouse 4
    Brazil Mouse 3
    Brazil Keyboard 3
    France Keyboard 2

	DHL, LargestCapacity
    Mouse 1
    Keyboard 1

##### Output

    China Mouse 1
    Brazil Keyboard 1

#### Test Case #6 - Many Products

##### Input

    Canada Mouse 2
    Brazil Mouse 2
    Brazil Keyboard 3
    France Keyboard 2
    South Africa Monitor 4
    South Africa Camera 1
    South Africa Mouse 2

	FedEx, None
    Mouse 6
    Keyboard 3
    Monitor 3
    Camera 1

##### Output

    Canada Mouse 2
    Brazil Mouse 2
    Brazil Keyboard 3
    South Africa Mouse 2
    South Africa Monitor 3
    South Africa Camera 1

#### Test Case #7 - Invalid

##### Input

    China Mouse 4
    Brazil Mouse 3

	FedEx, None
    Mouse 5

##### Output

    Order cannot be fulfilled.

