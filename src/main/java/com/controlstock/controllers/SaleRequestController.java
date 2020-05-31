package com.controlstock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.controlstock.converters.SaleConverter;
import com.controlstock.entities.Sale;
import com.controlstock.entities.SaleRequest;
import com.controlstock.helpers.ViewRouteHelper;
import com.controlstock.models.SaleModel;
import com.controlstock.models.SaleRequestModel;
import com.controlstock.services.ISaleRequestService;
import com.controlstock.services.ISaleService;
import com.controlstock.services.IStoreService;
import com.controlstock.services.IProductService;
import com.controlstock.services.IEmployeeService;

@Controller
//@RequestMapping("/saleRequest")
@RequestMapping("/sale/saleRequest")
public class SaleRequestController {

	@Autowired
	@Qualifier("saleRequestService")
	private ISaleRequestService saleRequestService;
	
	@Autowired
	@Qualifier("productService")
	private IProductService productService;
	
	@Autowired
	@Qualifier("employeeService")
	private IEmployeeService employeeService;
	
	@Autowired
	@Qualifier("saleService")
	private ISaleService saleService;
	
	@Autowired
	@Qualifier("storeService")
	private IStoreService storeService;
	
	@Autowired
	@Qualifier("saleConverter")
	private SaleConverter saleConverter;
	
	@GetMapping("")
	public ModelAndView index () {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SALEREQUEST_INDEX);
		mAV.addObject("saleRequests", saleRequestService.getAll());
		return mAV;
	}
	
	//Crea el SaleRequest.
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SALEREQUEST_NEW);
		mAV.addObject("saleRequest", new SaleRequestModel());
		//mAV.addObject("sales", saleService.getSaleListByStatus()); //Lista de sales abiertos
		mAV.addObject("sales", saleService.getSaleByStatus()); //Tiene que haber 1 solo sale.
		mAV.addObject("saleRequests", saleService.findById(saleService.getSaleByStatus().getId()).getSetSaleRequests());
		mAV.addObject("products", storeService.getProductsByStore(saleService.getSaleByStatus().getStore().getId()));
		mAV.addObject("employees", employeeService.getAll());
		mAV.addObject("batchs", storeService.findById(saleService.getSaleByStatus().getStore().getId()).getSetBatchs());
		return mAV;
	}
	
	//Crea el SaleRequest cuando se requiere un producto de otra sucursal.
	@GetMapping("/new2")
	public ModelAndView create2() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SALEREQUEST_NEW2);
		mAV.addObject("saleRequest", new SaleRequestModel());
		mAV.addObject("sales", saleService.getSaleByStatus()); //Tiene que haber 1 solo sale.
		mAV.addObject("products", productService.getAll());
		mAV.addObject("batchs", storeService.findById(saleService.getSaleByStatus().getStore().getId()).getSetBatchs());
		return mAV;
	}
	
	//SR de la store actual
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("saleRequest") SaleRequestModel saleRequestModel) {
		saleRequestService.insert(saleRequestModel);
		return new RedirectView(ViewRouteHelper.SALEREQUEST_OTHERNEW);
	}
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SALEREQUEST_UPDATE);
		mAV.addObject("saleRequest", saleRequestService.findById(id));
		mAV.addObject("products", productService.getAll());
		mAV.addObject("employee", employeeService.getAll());
		return mAV;
	}
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("saleRequest") SaleRequestModel saleRequestModel) {
		saleRequestService.update(saleRequestModel);
		return new RedirectView(ViewRouteHelper.SALEREQUEST_ROOT);
	}
	
	@PostMapping("/delete/{id}")
	public RedirectView delete (@PathVariable("id") int id) {
		saleRequestService.remove(id);
		return new RedirectView(ViewRouteHelper.SALEREQUEST_ROOT2);
	}
		
}
