package com.mrv.intern.invoicematch.model;

public class ReportInvStat {

		private String invStatId;
		private String invStatDes;
		public String getInvStatId() {
			return invStatId;
		}
		public void setInvStatId(String invStatId) {
			this.invStatId = invStatId;
		}
		public String getInvStatDes() {
			return invStatDes;
		}
		public void setInvStatDes(String invStatDes) {
			this.invStatDes = invStatDes;
		}
		public ReportInvStat(String invStatId, String invStatDes) {
			super();
			this.invStatId = invStatId;
			this.invStatDes = invStatDes;
		}
		public ReportInvStat() {
			
		}
		
		
}
