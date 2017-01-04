package com.yosanai.web.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mastercard.api.core.model.RequestMap;
import com.mastercard.api.retaillocationinsights.MerchantIndustries;
import com.mastercard.api.retaillocationinsights.RetailUnits;
import com.mastercard.api.retaillocationinsights.RetailUnitsMetrics;
import com.mastercard.api.retaillocationinsights.Subscriptions;
import com.yosanai.web.model.MetricsRequest;
import com.yosanai.web.model.RetailUnitRequest;

@RestController
public class RLIController {

	@RequestMapping(value = "/retailUnits", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody RetailUnits retailUnits(@RequestBody RetailUnitRequest req) throws Exception {
		RequestMap map = new RequestMap();
		map.set("PageLength", req.getPageLength());
		map.set("PageOffset", req.getPageOffset());
		map.set("CountryCode", req.getCountry());
		return RetailUnits.query(map);
	}

	@RequestMapping(value = "/metrics", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody RetailUnitsMetrics metrics(@RequestBody MetricsRequest req) throws Exception {
		RequestMap map = new RequestMap();
		map.set("PageLength", req.getPageLength());
		map.set("PageOffset", req.getPageOffset());
		map.set("CountryCode", req.getCountry());
		map.set("RetailUnitType", req.getUnitType());
		map.set("RetailUnitId", req.getUnitId());
		return RetailUnitsMetrics.query(map);
	}

	@RequestMapping(value = "/subscriptions", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Subscriptions subscriptions() throws Exception {
		RequestMap map = new RequestMap();
		return Subscriptions.query(map);
	}

	@RequestMapping(value = "/industries", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody MerchantIndustries industries() throws Exception {
		RequestMap map = new RequestMap();
		return MerchantIndustries.query(map);
	}
}
