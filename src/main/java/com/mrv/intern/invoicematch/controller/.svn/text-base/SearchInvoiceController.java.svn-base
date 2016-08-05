
package com.mrv.intern.invoicematch.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mrv.intern.invoicematch.model.SearchInvoice;
import com.mrv.intern.invoicematch.service.SeachInvoiceService;
import com.mrv.intern.invoicematch.utils.Constants;
//
@Controller
public class SearchInvoiceController {
	@Autowired
	private SeachInvoiceService seachInvoiceService;
	@Controller
	public class RootController {
	    @SuppressWarnings("unused")
		@RequestMapping(value = "/", method = RequestMethod.GET)
	    public String root() {
	        return "home";
	    }
	}
	/**
	 * importing data
	 * @return void
	 * @author Xuan Vu
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/importData", method = RequestMethod.POST)
	public void importData(){
		ArrayList<Job> job = new ArrayList<Job>();
		JobLauncher jobLauncher = (JobLauncher) context.getBean(Constants.KEY_JOBLOUNCHER);
		Job jobitm1 = (Job) context.getBean(Constants.KEY_JOB1);
		Job jobitm2 = (Job) context.getBean(Constants.KEY_JOB2);
		Job jobitm3 = (Job) context.getBean(Constants.KEY_JOB3);
		Job jobitm4 = (Job) context.getBean(Constants.KEY_JOB4);
		Job jobitm5 = (Job) context.getBean(Constants.KEY_JOB5);
		job.add(jobitm1);
		job.add(jobitm2);
		job.add(jobitm3);
		job.add(jobitm4);
		job.add(jobitm5);
		for (int i = 0; i < job.size(); i++) {
			try {

				JobParameters jobParameters = new JobParametersBuilder()
						.addLong(Constants.KEY_TIME, System.currentTimeMillis()).toJobParameters();

				JobExecution execution = jobLauncher.run(job.get(i), jobParameters);
				System.out.println(Constants.KEY_STT + execution.getStatus());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		}
	/**
	 * matching data
	 * @return void
	 * @author Xuan Vu
	 * 
	 */
	
	@ResponseBody
	@RequestMapping(value = "/matchData", method = RequestMethod.POST)
	public void matchData(){
		JobLauncher jobLauncher = (JobLauncher) context.getBean(Constants.KEY_JOBLOUNCHER);
		Job jobitm5 = (Job) context.getBean(Constants.KEY_JOB6);
		try {

			JobParameters jobParameters = new JobParametersBuilder()
					.addLong(Constants.KEY_TIME, System.currentTimeMillis()).toJobParameters();

			JobExecution execution = jobLauncher.run(jobitm5, jobParameters);
			System.out.println(Constants.KEY_STT + execution.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @author tuhv
	 * @param invoiceID
	 * @param orderID
	 * @param trackingID
	 * @param vendorID
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	@ResponseBody
	@RequestMapping(value = "/searchInvoice", method = RequestMethod.POST)
	public String searchInvoiceMatch(@RequestParam("invoiceID") String invoiceID,
			@RequestParam("orderID") String orderID, @RequestParam("trackingID") String trackingID,
			@RequestParam("vendorID") String vendorID) throws IOException, ParseException {
		List<SearchInvoice> lstsearch = new ArrayList<SearchInvoice>();
		if (vendorID.equals(Constants.VENDOR_DEFAULD) && invoiceID.equals("") && trackingID.equals("") && orderID.equals("")) {
			lstsearch = seachInvoiceService.list();
			for (SearchInvoice searchInvoice : lstsearch) {
				if(searchInvoice.getInvoiceAmt() == null){
					searchInvoice.setInvoiceAmt(" ");
				}
			}
		} else {
			lstsearch = seachInvoiceService.searchInvoice(vendorID, invoiceID, trackingID, orderID);
			for (SearchInvoice searchInvoice : lstsearch) {
				if(searchInvoice.getInvoiceAmt() == null){
					searchInvoice.setInvoiceAmt(" ");
				}
			}

		}
		String json = new Gson().toJson(lstsearch);
		JsonObject jsonObj = new JsonObject();
		JsonParser parser = new JsonParser();
		JsonArray o = parser.parse(json).getAsJsonArray();
		jsonObj.add("data", o);
		

		return jsonObj.toString();
	}
	/**
	 * @author tuhv
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */

	@ResponseBody
	@RequestMapping(value = "/listVendor", method = RequestMethod.POST)
	public String listVendor() throws IOException, ParseException {
		List<SearchInvoice> lstsearch = new ArrayList<SearchInvoice>();
		lstsearch = seachInvoiceService.listVendor();
		JsonArray arr = new JsonArray();
		for (SearchInvoice inv : lstsearch) {
			JsonObject jsonObj = new JsonObject();
			jsonObj.addProperty("vendorId", inv.getVendorID());
			arr.add(jsonObj);
		}
		JsonObject jsonObj = new JsonObject();
		jsonObj.add("data", arr);
	

		return jsonObj.toString();
	}

	@Autowired
	ApplicationContext context;
}
