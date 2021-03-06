package com.controlstock.helpers;

public class ViewRouteHelper {

	//Views ------------------------------------------------------------------
	
	//Index
	public final static String INDEX = "home/index";
	
	//Producto (Product)
	
	public final static String PRODUCT_INDEX = "product/index";
	public final static String PRODUCT_NEW = "product/new";
	public final static String PRODUCT_UPDATE = "product/update";
	
	//ProductRanking
	
	public final static String PRODUCT_RANKING_INDEX = "productRanking/index";
	
	//Lote (Batch)
	
	public final static String BATCH_INDEX = "batch/index";
	public final static String BATCH_NEW = "batch/new";
	public final static String BATCH_UPDATE = "batch/update";
	
	//Locales (Store)
	
	public final static String STORE_INDEX = "store/index";
	public final static String STORE_NEW = "store/new";
	public final static String STORE_UPDATE = "store/update";
	public final static String STORE_PARTIAL_VIEW = "store/partialStoreView";
	public final static String STORE_PARTIAL_VIEW_EMPLOYEES = "store/partialEmployeeView";

	//Clientes (Client)
	
	public final static String CLIENT_INDEX = "client/index";
	public final static String CLIENT_NEW = "client/new";
	public final static String CLIENT_UPDATE = "client/update";
	
	//Empleados (Employee)
	
	public final static String EMPLOYEE_INDEX = "employee/index";
	public final static String EMPLOYEE_NEW = "employee/new";
	public final static String EMPLOYEE_UPDATE = "employee/update";
	public final static String EMPLOYEE_SALARY = "employee/salary";
	public final static String EMPLOYEE_SALARY_TABLE = "employee/table";

	
	//Direcciones (Address)
	
	public final static String ADDRESS_INDEX = "address/index";
	public final static String ADDRESS_NEW = "address/new";
	public final static String ADDRESS_UPDATE = "address/update";
		
	//Pedidos (SaleRequest)
	
	public final static String SALEREQUEST_INDEX = "saleRequest/index";
	public final static String SALEREQUEST_NEW = "saleRequest/new";
	public final static String SALEREQUEST_OTHERNEW = "new";
	public final static String SALEREQUEST_NEW2 = "saleRequest/new2";
	public final static String SALEREQUEST_UPDATE = "saleRequest/update";
	public final static String SALEREQUEST_VERIFY_STOCK = "/saleRequest/stockVerify";
	
	//Ventas (Sale)
	
	public final static String SALE_INDEX = "sale/index";
	public final static String SALE_NEW = "sale/new";
	public final static String SALE_INITIAL = "sale/initial";
	public final static String SALE_FINAL = "sale/final";
	public final static String SALE_SELECTEMPLOYEE = "sale/selectEmployee";

	//Reporte de productos vendidos (productsDates)
	
	public final static String PRODUCTSDATES_INDEX = "productsDates/index";
	public final static String PRODUCTSDATES_TABLE = "productsDates/table";
	
	//Redirects ------------------------------------------------------------
	
	public final static String ROUTE = "/index";
	public final static String PRODUCT_ROOT = "/product";
	public final static String PRODUCTRANKING_ROOT = "/productRanking";
	public final static String BATCH_ROOT = "/batch";
	public final static String STORE_ROOT = "/store";
	public final static String CLIENT_ROOT = "/client";
	public final static String EMPLOYEE_ROOT = "/employee";
	public final static String ADDRESS_ROOT = "/address";
	public final static String SALEREQUEST_ROOT = "/saleRequest";
	public final static String SALEREQUEST_ROOT2 = "/sale/saleRequest/new";
	public final static String SALE_ROOT = "/sale";
}
