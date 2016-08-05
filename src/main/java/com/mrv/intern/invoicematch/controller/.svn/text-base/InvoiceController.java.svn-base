package com.mrv.intern.invoicematch.controller;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mrv.intern.invoicematch.model.ReportInvStat;
import com.mrv.intern.invoicematch.model.ReportStgVendInvHdrVO;
import com.mrv.intern.invoicematch.model.ReportVendInvHdrVO;
import com.mrv.intern.invoicematch.model.SearchInvoice;
import com.mrv.intern.invoicematch.service.InvoiceService;
import com.mrv.intern.invoicematch.utils.Constants;
import com.mrv.intern.invoicematch.utils.Helper;

@Controller
public class InvoiceController {
	@Autowired
	@Qualifier("invoiceService")
	private InvoiceService invoiceService;
	
	Constants constant;

	
	/**
	  * Search Report 
	  * @return List
	  * @author Phuoc Nguyen
	  * 
	  */
	
	@ResponseBody
	@RequestMapping(value = "/searchReport", method = RequestMethod.POST)
	public String Report(@RequestParam("dayStart") String dayStart, @RequestParam("dayEnd") String dayEnd,
			@RequestParam("invStat") String invStat) throws IOException, ParseException {
		List<ReportVendInvHdrVO> listInvoiceView = new ArrayList<ReportVendInvHdrVO>();
		
		if (invStat.equals(constant.INV_STAT_DEFAULD) && dayEnd.equals("") && dayStart.equals("")) {
			listInvoiceView = invoiceService.getAllInvoice();
		} else {
			String timeStart = Helper.dateConvert(dayStart);
			String timeEnd = Helper.dateConvert(dayEnd);
			listInvoiceView = invoiceService.searchInvoice(timeStart, timeEnd, invStat);

		}

		
		
		String json = new Gson().toJson(listInvoiceView);
		JsonObject jsonObj = new JsonObject();
		JsonParser parser = new JsonParser();
		JsonArray o = parser.parse(json).getAsJsonArray();
		jsonObj.add("data", o);


		return jsonObj.toString();
	}
	

	/**
	  * Export File
	  * @return File
	  * @author Phuoc Nguyen
	  * 
	  */

	@ResponseBody
	@RequestMapping(value = "/downloadFile")
	public void downloadFile(HttpServletResponse response) throws IOException {
		List<ReportVendInvHdrVO> listInvoice = new ArrayList<ReportVendInvHdrVO>();

		listInvoice = invoiceService.getAllInvoice();
		
		String timeNow = new SimpleDateFormat(Constants.FORMAR_TIME_NEW).format(Calendar.getInstance().getTime());
		response.setHeader(constant.HEADER_KEY, constant.HEADER_VALUE);

		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

		csvWriter.writeHeader("Time : " + timeNow);
		csvWriter.writeHeader(constant.HEADER);

		for (ReportVendInvHdrVO vo : listInvoice) {
			if (vo != null) {
				csvWriter.writeHeader(String.valueOf(vo.getVendId()), vo.getVendInvNbr(),
						Helper.parseTimeStampToString(vo.getInvTs()), vo.getInvTypCd(),
						Helper.parseTimeStampToString(vo.getInvRecdTs()), vo.getInvRecdUsrId(),
						Helper.parseTimeStampToString(vo.getInvApprTs()), vo.getInvApprUsrId(),
						Helper.parseTimeStampToString(vo.getLstUpdtTs()), vo.getLstUpdtUnid(), vo.getInvStatCd(),
						Helper.trim(vo.getInvExcpTypCd()), String.valueOf(vo.getInvAmt()),
						Helper.parseTimeStampToString(vo.getApPostTs()), String.valueOf(vo.getLocNbr()),
						vo.getLocTypCd(), String.valueOf(vo.getLinItmCnt()), vo.getInvSrcCd(),
						Helper.parseTimeStampToString(vo.getManCre8Ts()), vo.getApBusUntDes(), vo.getHebSchPymtDt(),
						vo.getBdmCd(), vo.getCre8Uid(), Helper.parseTimeStampToString(vo.getCre8Ts()),
						vo.getManCre8RsnTxt(), vo.getPostToXnetSw(), vo.getRuleSw(),
						Helper.parseTimeStampToString(vo.getBiPostTs()),
						Helper.parseTimeStampToString(vo.getGlPostTs()),
						Helper.parseTimeStampToString(vo.getRcgpPostTs()));
			}
		}
		csvWriter.close();
	}
	

	/**
	  * Get List Status
	  * @return List
	  * @author Phuoc Nguyen
	  * 
	  */
	
	@ResponseBody
	@RequestMapping(value = "/getListInvStat", method = RequestMethod.POST)
	public String getListInvStat() throws IOException, ParseException {
		List<ReportInvStat> listInvStat = new ArrayList<ReportInvStat>();
		
		listInvStat = invoiceService.getInvStat();
		JsonArray josnArr = new JsonArray();
		for (ReportInvStat invStat : listInvStat) {
			JsonObject jsonObj = new JsonObject();
			jsonObj.addProperty("invStatId", invStat.getInvStatId());
			josnArr.add(jsonObj);
		}
		JsonObject jsonObj = new JsonObject();
		jsonObj.add("data", josnArr);
		

		return jsonObj.toString();
	}
	
}
