package com.yuntong.controller;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yuntong.common.Foundation;

@Controller
@RequestMapping(Foundation.MODULE_MAPPING_ROOT + "service/driver")
public class DriverController {

	private static Logger logger = LogManager.getLogger(DriverController.class.getName());
	
	@RequestMapping("/addDriver")
	public void addDriver(
			@RequestParam("driverName") String driverName,
			@RequestParam("driverAge") String driverAge,
			@RequestParam("driverSex") String driverSex,
			@RequestParam("driverDriverCardId") String driverDriverCardId,
			@RequestParam("driverCardId") String driverCardId,
			@RequestParam("driverPhoneNum") String driverPhoneNum,
			@RequestParam("driverCompanyId") String driverOrganization
			){
		
	}
	
	
}
