package in.hkcl.model;

import java.io.Serializable;


public class CMDashboardJSONRequestData implements Serializable {

	private static final long serialVersionUID = 1L;
    private String date;
    private String time;
    private Integer noOfRecommendedRequisitions;
    private Long noOfRecommendedPosts;
    private Integer noOfInprocessRequisitions;
    private Long noOfInprocessPosts;
    private float perOfRequisitionsProcessInIdealTime;
    private Integer noOfRequisitionsInCourtStay;
    private Long noOfPostsImpactedBecauseOfCourtStay;
    private Integer noOfBackReferredRequisitions;
    private Long noOfBackReferredPosts;
	
    
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getNoOfRecommendedRequisitions() {
		return noOfRecommendedRequisitions;
	}
	public void setNoOfRecommendedRequisitions(Integer noOfRecommendedRequisitions) {
		this.noOfRecommendedRequisitions = noOfRecommendedRequisitions;
	}
	public Long getNoOfRecommendedPosts() {
		return noOfRecommendedPosts;
	}
	public void setNoOfRecommendedPosts(Long noOfRecommendedPosts) {
		this.noOfRecommendedPosts = noOfRecommendedPosts;
	}
	public Integer getNoOfInprocessRequisitions() {
		return noOfInprocessRequisitions;
	}
	public void setNoOfInprocessRequisitions(Integer noOfInprocessRequisitions) {
		this.noOfInprocessRequisitions = noOfInprocessRequisitions;
	}
	public Long getNoOfInprocessPosts() {
		return noOfInprocessPosts;
	}
	public void setNoOfInprocessPosts(Long noOfInprocessPosts) {
		this.noOfInprocessPosts = noOfInprocessPosts;
	}
	public float getPerOfRequisitionsProcessInIdealTime() {
		return perOfRequisitionsProcessInIdealTime;
	}
	public void setPerOfRequisitionsProcessInIdealTime(float perOfRequisitionsProcessInIdealTime) {
		this.perOfRequisitionsProcessInIdealTime = perOfRequisitionsProcessInIdealTime;
	}
	public Integer getNoOfRequisitionsInCourtStay() {
		return noOfRequisitionsInCourtStay;
	}
	public void setNoOfRequisitionsInCourtStay(Integer noOfRequisitionsInCourtStay) {
		this.noOfRequisitionsInCourtStay = noOfRequisitionsInCourtStay;
	}
	public Long getNoOfPostsImpactedBecauseOfCourtStay() {
		return noOfPostsImpactedBecauseOfCourtStay;
	}
	public void setNoOfPostsImpactedBecauseOfCourtStay(Long noOfPostsImpactedBecauseOfCourtStay) {
		this.noOfPostsImpactedBecauseOfCourtStay = noOfPostsImpactedBecauseOfCourtStay;
	}
	public Integer getNoOfBackReferredRequisitions() {
		return noOfBackReferredRequisitions;
	}
	public void setNoOfBackReferredRequisitions(Integer noOfBackReferredRequisitions) {
		this.noOfBackReferredRequisitions = noOfBackReferredRequisitions;
	}
	public Long getNoOfBackReferredPosts() {
		return noOfBackReferredPosts;
	}
	public void setNoOfBackReferredPosts(Long noOfBackReferredPosts) {
		this.noOfBackReferredPosts = noOfBackReferredPosts;
	}
    
    
    
    
}
