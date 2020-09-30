package in.hkcl.dao;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.displaytag.properties.SortOrderEnum;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import in.hkcl.dao.common.DaoSupport;
import in.hkcl.model.CourtCaseDetails;
import in.hkcl.model.DepartmentVO;
import in.hkcl.model.DepartmentWiseCountHelper;
import in.hkcl.model.District;
import in.hkcl.model.HearingDateGraphHelper;
import in.hkcl.model.HearingDetails;
import in.hkcl.model.ImpactGraphHelper;
import in.hkcl.model.PetitionerDetails;
import in.hkcl.model.Police;
import in.hkcl.model.UserEditLogs;
import in.hkcl.model.YearWiseCountHelper;
import in.hkcl.utils.ApplicationLogFactory;
import in.hkcl.utils.ApplicationLogger;
import in.hkcl.utils.CommonUtils;

public class CourtCaseDaoImpl extends DaoSupport implements CourtCaseDao {
	
	private static ApplicationLogger logger = ApplicationLogFactory.getLogger(CourtCaseDaoImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@SuppressWarnings("unchecked")
	@Override
	public List<CourtCaseDetails> getCaseDetails(Integer srNo) throws Exception {
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(CourtCaseDetails.class);
			criteria.add(Restrictions.eq("sRNo", srNo));
			List<CourtCaseDetails>  CourtCaseList= (List<CourtCaseDetails>) getHibernateTemplate().findByCriteria(criteria);
			if (CommonUtils.isNotEmpty(CourtCaseList)) {
				return CourtCaseList;
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.logError("getCaseDetails", "error while fetching data for CaseDetails", e);
			throw e;
		}
	}

	@Override
	public List<CourtCaseDetails> getAllHsscCourtCasesForDept() {
		 List<CourtCaseDetails> AllHsscCourtCaseForDept=new ArrayList<CourtCaseDetails>();
		 List<CourtCaseDetails> AllHsscCourtCaseForDeptyear=new ArrayList<CourtCaseDetails>();
		 List<CourtCaseDetails> AllHsscCourtCaseForDeptstatus=new ArrayList<CourtCaseDetails>();
		 List<CourtCaseDetails> AllHsscCourtCaseForDeptType=new ArrayList<CourtCaseDetails>();
		
		  try{
			  
				  AllHsscCourtCaseForDept=(List<CourtCaseDetails>)getJdbcTemplate().query("select DISTINCT writNo from courtcasedetails",
						  new RowMapper<CourtCaseDetails>()      
				    {
					  @Override
						public CourtCaseDetails mapRow(final ResultSet resultSet, final int arg1) throws SQLException
						{
							final CourtCaseDetails courtcase = new CourtCaseDetails();
							courtcase.setWritNo(resultSet.getInt("writNo"));
							return courtcase;
						}
					});
			AllHsscCourtCaseForDeptyear = (List<CourtCaseDetails>) getJdbcTemplate()
					.query("select DISTINCT year from courtcasedetails", new RowMapper<CourtCaseDetails>() {
						@Override
						public CourtCaseDetails mapRow(final ResultSet resultSet, final int arg1) throws SQLException {
							final CourtCaseDetails courtcase = new CourtCaseDetails();
							courtcase.setYear(resultSet.getString("year"));
							return courtcase;
						}
					});
			AllHsscCourtCaseForDeptstatus = (List<CourtCaseDetails>) getJdbcTemplate()
					.query("select DISTINCT caseStatus	 from courtcasedetails", new RowMapper<CourtCaseDetails>() {
						@Override
						public CourtCaseDetails mapRow(final ResultSet resultSet, final int arg1) throws SQLException {
							final CourtCaseDetails courtcase = new CourtCaseDetails();
							courtcase.setCaseStatus(resultSet.getString("caseStatus"));
							return courtcase;
						}
					});
			AllHsscCourtCaseForDeptType = (List<CourtCaseDetails>) getJdbcTemplate()
					.query("select DISTINCT caseType from courtcasedetails", new RowMapper<CourtCaseDetails>() {
						@Override
						public CourtCaseDetails mapRow(final ResultSet resultSet, final int arg1) throws SQLException {
							final CourtCaseDetails courtcase = new CourtCaseDetails();
							courtcase.setCaseType(resultSet.getString("caseType"));
							return courtcase;
						}
					});
			AllHsscCourtCaseForDept.addAll(AllHsscCourtCaseForDeptyear);
			AllHsscCourtCaseForDept.addAll(AllHsscCourtCaseForDeptstatus);
			AllHsscCourtCaseForDept.addAll(AllHsscCourtCaseForDeptType);
		} catch (Exception e) {
			logger.logError("getAllHsscCourtCasesForDept", "error while fetching data for CaseDetails", e);
		}

		return AllHsscCourtCaseForDept;
	}

	@Override
	public List<String> getAllHsscPetitionerNames() {
		List<String> distinctPetitionerNamesList = new ArrayList<String>();
		List<PetitionerDetails> AllHsscPetitionerNames = new ArrayList<PetitionerDetails>();
		try {

			AllHsscPetitionerNames = (List<PetitionerDetails>) getJdbcTemplate()
					.query("select DISTINCT name from petitionerdetails	", new RowMapper<PetitionerDetails>() {
						@Override
						public PetitionerDetails mapRow(final ResultSet resultSet, final int arg1) throws SQLException {
							final PetitionerDetails petitionerName = new PetitionerDetails();
							if (CommonUtils.isNotEmpty(resultSet.getString("name"))) {
								petitionerName.setName(resultSet.getString("name"));
							}
							return petitionerName;
						}
					});

			for (PetitionerDetails s : AllHsscPetitionerNames) {
				distinctPetitionerNamesList.add(s.getName());
			}

		} catch (Exception e) {
			logger.logError("getAllHsscCourtCasesForDept", "error while fetching data for CaseDetails", e);
		}

		return distinctPetitionerNamesList;
	}

	@Override

	@Transactional(readOnly = false)
	public CourtCaseDetails updateCourtCaseDetails(CourtCaseDetails courtCase) {
		try {

			String DELETE_petitionerDetails = "delete from PetitionerDetails where caseId=?";
			String DELETE_CMDetails = "delete from CivilMiscellaneousDetails where caseId=?";
			String DELETE_SimilarCaseDetails = "delete from SimilarCases where caseId=?";
			String DELETE_InterimOrderDetails = "delete from InterimOrderDetails where caseId=?";
			String DELETE_HearingDates="delete from HearingDetails where caseId=?";
			getHibernateTemplate().bulkUpdate(DELETE_petitionerDetails, courtCase.getCaseId());
			getHibernateTemplate().bulkUpdate(DELETE_CMDetails, courtCase.getCaseId());
			getHibernateTemplate().bulkUpdate(DELETE_SimilarCaseDetails, courtCase.getCaseId());
			getHibernateTemplate().bulkUpdate(DELETE_InterimOrderDetails, courtCase.getCaseId());
			getHibernateTemplate().bulkUpdate(DELETE_HearingDates, courtCase.getCaseId());

			UserEditLogs userEdit = new UserEditLogs();
			userEdit.setUserId(courtCase.getUserId());
			userEdit.setDateOfEdit(new Date());

			if (CommonUtils.isNotEmpty(courtCase.getCaseId())) {
				if (CommonUtils.isNotEmpty(courtCase.getHearingDetailsList().get(0).getDate())) {
					courtCase.getHearingDetailsList().get(0).setCaseId(courtCase.getCaseId());
				}
				// courtCase.getPetitionerDetailsList().get(0).setCaseId(courtCase.getCaseId());
				getHibernateTemplate().update(courtCase);

			} else {
				/*
				 * String value=null; List<CourtCaseDetails> distinctWritNo=
				 * getAllWritNo(); Integer writNo=courtCase.getWritNo(); for(int
				 * i=0; i<distinctWritNo.size(); i++){
				 * if(distinctWritNo.get(i).getWritNo().equals(writNo)) {
				 * System.out.println("sameCase"); value="sameCase"; break; }
				 * else{ System.out.println("does not have same Case"); value=
				 * "does not have same Case"; } } if(value=="sameCase"){ return
				 * courtCase; } else{
				 */
				courtCase.getPoliceDetailsObj().setsRNo(courtCase.getsRNo());
				getHibernateTemplate().save(courtCase);
				courtCase.setUniqueCaseId("CC" + courtCase.getWritNo() + courtCase.getCaseId());

				/* } */
				if (CommonUtils.isNotEmpty(courtCase.getHearingDetailsList())) {
					for (int i = 0; i < courtCase.getHearingDetailsList().size(); i++) {
						courtCase.getHearingDetailsList().get(i).setCaseId(courtCase.getCaseId());
					}
				}
				if (CommonUtils.isNotEmpty(courtCase.getPetitionerDetailsList())) {
					for (int i = 0; i < courtCase.getPetitionerDetailsList().size(); i++) {
						courtCase.getPetitionerDetailsList().get(i).setCaseId(courtCase.getCaseId());
					}
				}
				if (CommonUtils.isNotEmpty(courtCase.getCivilMiscellaneousDetailsList())) {
					for (int i = 0; i < courtCase.getCivilMiscellaneousDetailsList().size(); i++) {
						courtCase.getCivilMiscellaneousDetailsList().get(i).setCaseId(courtCase.getCaseId());
					}

				}
				if (CommonUtils.isNotEmpty(courtCase.getSimilarCasesList())) {
					for (int i = 0; i < courtCase.getSimilarCasesList().size(); i++) {
						courtCase.getSimilarCasesList().get(i).setCaseId(courtCase.getCaseId());
					}

				}
				if (CommonUtils.isNotEmpty(courtCase.getInterimOrderList())) {
					for (int i = 0; i < courtCase.getInterimOrderList().size(); i++) {
						courtCase.getInterimOrderList().get(i).setCaseId(courtCase.getCaseId());
					}

				}
			}
			getHibernateTemplate().save(userEdit);

		} catch (Exception e) {
			logger.logError("updateCourtCaseDetails", "error while updating Court Details", e);
			return courtCase;
		}
		return courtCase;
	}

	@Override
	public List<CourtCaseDetails> getAllWritNo() {
		List<CourtCaseDetails> distinctWritNo = new ArrayList<CourtCaseDetails>();
		try {
			distinctWritNo = (List<CourtCaseDetails>) getJdbcTemplate()
					.query("select DISTINCT writNo from courtcasedetails", new RowMapper<CourtCaseDetails>() {
						@Override
						public CourtCaseDetails mapRow(final ResultSet resultSet, final int arg1) throws SQLException {
							final CourtCaseDetails courtcase = new CourtCaseDetails();
							if (CommonUtils.isNotEmpty(resultSet.getInt("writNo"))) {
								courtcase.setWritNo(resultSet.getInt("writNo"));
							}
							return courtcase;
						}
					});

		} catch (Exception e) {
			logger.logError("getdistinctWritNoList", "error while fetching distinct writNO", e);
		}
		return distinctWritNo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CourtCaseDetails> getAllCourtCaseData(CourtCaseDetails courtCaseDetailsObj, int firstRecordIndex,
			int pageSize, SortOrderEnum sortDirection, String sortCriterion) throws Exception {
		DetachedCriteria criteria;

		try {
			criteria = DetachedCriteria.forClass(CourtCaseDetails.class);
			if (CommonUtils.isNotEmpty(courtCaseDetailsObj.getCaseType())) {
				if (courtCaseDetailsObj.getCaseType().contains("Search by case Type...")) {
				} else {
					criteria.add(Restrictions.eq("caseType", courtCaseDetailsObj.getCaseType()));
				}
			}
			if (CommonUtils.isNotEmpty(courtCaseDetailsObj.getHearingDetailsList())
					&& CommonUtils.isNotEmpty(courtCaseDetailsObj.getHearingDetailsList().get(0).getDate())) {
				if (courtCaseDetailsObj.getHearingDetailsList().get(0).getDate().toString()
						.contains("Search by Hearing Date...")) {
				} else {
					criteria.createCriteria("hearingDetailsList", "hr");
					criteria.add(
							Restrictions.eq("hr.date", courtCaseDetailsObj.getHearingDetailsList().get(0).getDate()));

				}
			}

			if (CommonUtils.isNotEmpty(courtCaseDetailsObj.getWritNo())) {
				if (courtCaseDetailsObj.getWritNo().toString().contains("Search Case No...")) {
				} else {
					criteria.add(Restrictions.eq("writNo", courtCaseDetailsObj.getWritNo()));
				}
			}
			if (CommonUtils.isNotEmpty(courtCaseDetailsObj.getCaseStatus())) {
				if (courtCaseDetailsObj.getCaseStatus().contains("Search by caseStatus...")) {
				} else {
					criteria.add(Restrictions.eq("caseStatus", courtCaseDetailsObj.getCaseStatus()));
				}
			}
			if (CommonUtils.isNotEmpty(courtCaseDetailsObj.getYear())) {
				if (courtCaseDetailsObj.getYear().contains("Search by year...")) {
				} else {
					criteria.add(Restrictions.eq("year", courtCaseDetailsObj.getYear()));
				}
			}
			if (CommonUtils.isNotEmpty(courtCaseDetailsObj.getPetitionerDetailsList())
					&& CommonUtils.isNotEmpty(courtCaseDetailsObj.getPetitionerDetailsList().get(0).getName())) {
				criteria.createCriteria("petitionerDetailsList", "pet");
				// criteria.addOrder(Order.desc("pet.name"));
				criteria.add(
						Restrictions.eq("pet.name", courtCaseDetailsObj.getPetitionerDetailsList().get(0).getName()));

			}

			if (CommonUtils.isNotEmpty(courtCaseDetailsObj.getPoliceDetailsObj())
					&& CommonUtils.isNotEmpty(courtCaseDetailsObj.getPoliceDetailsObj().getaDvtNo())) {
				criteria.createCriteria("policeDetailsObj", "advt");
				// criteria.addOrder(Order.desc("pet.name"));
				criteria.add(Restrictions.eq("advt.aDvtNo", courtCaseDetailsObj.getPoliceDetailsObj().getaDvtNo()));

			}

			if (CommonUtils.isNotEmpty(sortCriterion)) {

				if (sortCriterion.contains("policeDetailsObj.aDvtNo")) {
					criteria.createCriteria("policeDetailsObj", "pol");
					if (sortDirection.equals(SortOrderEnum.ASCENDING)) {
						criteria.addOrder(Order.asc("pol.aDvtNo"));
					}
					if (sortDirection.equals(SortOrderEnum.DESCENDING)) {
						criteria.addOrder(Order.desc("pol.aDvtNo"));
					}
				} else if(sortCriterion.contains("dateList")){
					criteria.createCriteria("hearingDetailsList", "hearingDate");
					if (sortDirection.equals(SortOrderEnum.ASCENDING)) {
						criteria.addOrder(Order.asc("hearingDate.date"));
					}
					if (sortDirection.equals(SortOrderEnum.DESCENDING)) {
						criteria.addOrder(Order.desc("hearingDate.date"));
				 }
			}
				else if (sortCriterion.contains("policeDetailsObj.nAmeOfPost")) {
					criteria.createCriteria("policeDetailsObj", "pol");
					if (sortDirection.equals(SortOrderEnum.ASCENDING)) {
						criteria.addOrder(Order.asc("pol.nAmeOfPost"));
					}
					if (sortDirection.equals(SortOrderEnum.DESCENDING)) {
						criteria.addOrder(Order.desc("pol.nAmeOfPost"));
					}
				} else if (sortCriterion.contains("policeDetailsObj.cAtNo")) {
					criteria.createCriteria("policeDetailsObj", "pol");
					if (sortDirection.equals(SortOrderEnum.ASCENDING)) {
						criteria.addOrder(Order.asc("pol.cAtNo"));
					}
					if (sortDirection.equals(SortOrderEnum.DESCENDING)) {
						criteria.addOrder(Order.desc("pol.cAtNo"));
					}
				} else if (sortCriterion.contains("petitioners")) {
					criteria.createCriteria("petitionerDetailsList", "pet");
					if (sortDirection.equals(SortOrderEnum.ASCENDING)) {
						criteria.addOrder(Order.asc("pet.name"));
					}
					if (sortDirection.equals(SortOrderEnum.DESCENDING)) {
						criteria.addOrder(Order.desc("pet.name"));
					}
				}
				else if(sortCriterion.contains("policeDetailsObj.deptObj.dEpartment")){
					criteria.createCriteria("policeDetailsObj", "pol");
					criteria.createCriteria("pol.deptObj","p");
					
					if (sortDirection.equals(SortOrderEnum.ASCENDING)) {
						criteria.addOrder(Order.asc("p.dEpartment"));
					}
					if (sortDirection.equals(SortOrderEnum.DESCENDING)) {
						criteria.addOrder(Order.desc("p.dEpartment"));
					}					
				}	
								
			    else{
						if (sortDirection.equals(SortOrderEnum.ASCENDING)) {
							criteria.addOrder(Order.asc(sortCriterion));
						}
						if (sortDirection.equals(SortOrderEnum.DESCENDING)) {
							criteria.addOrder(Order.desc(sortCriterion));
				 		}
			    }

			} else {
				criteria.addOrder(Order.asc("writNo"));
			}

			List<CourtCaseDetails> courtCaseDataList = (List<CourtCaseDetails>) getHibernateTemplate().findByCriteria(criteria, firstRecordIndex, pageSize);
			
		if(CommonUtils.isNotEmpty(courtCaseDataList)){
			return courtCaseDataList;
		}else{
			return courtCaseDataList;
		}	
			
			
		} catch (Exception e) {
			logger.logError("getAllCourtCaseData", "error while fetching details", e);
			throw e;
		}

	}

	@Override
	public int getAllCourtCaseDataCount(CourtCaseDetails courtCaseDetailsObj) {
		DetachedCriteria criteria;
		try {
			criteria = DetachedCriteria.forClass(CourtCaseDetails.class);
			if (CommonUtils.isNotEmpty(courtCaseDetailsObj.getCaseType())) {
				if (courtCaseDetailsObj.getCaseType().contains("Search by case Type...")) {
				} else {
					criteria.add(Restrictions.eq("caseType", courtCaseDetailsObj.getCaseType()));
				}
			}
			if (CommonUtils.isNotEmpty(courtCaseDetailsObj.getWritNo())) {
				if (courtCaseDetailsObj.getWritNo().toString().contains("Search Case No...")) {
				} else {
					criteria.add(Restrictions.eq("writNo", courtCaseDetailsObj.getWritNo()));
				}
			}
			if (CommonUtils.isNotEmpty(courtCaseDetailsObj.getCaseStatus())) {
				if (courtCaseDetailsObj.getCaseStatus().contains("Search by caseStatus...")) {
				} else {
					criteria.add(Restrictions.eq("caseStatus", courtCaseDetailsObj.getCaseStatus()));
				}
			}
			if (CommonUtils.isNotEmpty(courtCaseDetailsObj.getYear())) {
				if (courtCaseDetailsObj.getYear().contains("Search by year...")) {
				} else {
					criteria.add(Restrictions.eq("year", courtCaseDetailsObj.getYear()));
				}
			}

			if (CommonUtils.isNotEmpty(courtCaseDetailsObj.getPetitionerDetailsList())
					&& CommonUtils.isNotEmpty(courtCaseDetailsObj.getPetitionerDetailsList().get(0).getName())) {
				criteria.createCriteria("petitionerDetailsList", "pet");
				// criteria.addOrder(Order.desc("pet.name"));
				criteria.add(
						Restrictions.eq("pet.name", courtCaseDetailsObj.getPetitionerDetailsList().get(0).getName()));

			}

			if (CommonUtils.isNotEmpty(courtCaseDetailsObj.getPoliceDetailsObj())
					&& CommonUtils.isNotEmpty(courtCaseDetailsObj.getPoliceDetailsObj().getaDvtNo())) {
				criteria.createCriteria("policeDetailsObj", "advt");
				// criteria.addOrder(Order.desc("pet.name"));
				criteria.add(Restrictions.eq("advt.aDvtNo", courtCaseDetailsObj.getPoliceDetailsObj().getaDvtNo()));

			}

			if (CommonUtils.isNotEmpty(courtCaseDetailsObj.getHearingDetailsList())
					&& CommonUtils.isNotEmpty(courtCaseDetailsObj.getHearingDetailsList().get(0).getDate())) {
				if (courtCaseDetailsObj.getHearingDetailsList().get(0).getDate().toString()
						.contains("Search by Hearing Date...")) {
				} else {
					criteria.createCriteria("hearingDetailsList", "hr");
					criteria.add(
							Restrictions.eq("hr.date", courtCaseDetailsObj.getHearingDetailsList().get(0).getDate()));
				}
			}

			criteria.setProjection(Projections.rowCount());
			final List<?> results = getHibernateTemplate().findByCriteria(criteria);
			return CommonUtils.isEmpty(results) == true ? 0 : ((Long) results.get(0)).intValue();

		} catch (Exception e) {
			logger.logError("getAllCourtCaseDataCount", "error while fetching details", e);
		}
		return 0;
	}

	@Override
	public List<CourtCaseDetails> getAllCourtCasesDataForDropDown() {
		List<CourtCaseDetails> AllHsscCourtCaseForDept = new ArrayList<CourtCaseDetails>();
		List<CourtCaseDetails> AllHsscCourtCaseForDeptyear = new ArrayList<CourtCaseDetails>();
		List<CourtCaseDetails> AllHsscCourtCaseForDeptstatus = new ArrayList<CourtCaseDetails>();
		List<CourtCaseDetails> AllHsscCourtCaseForDeptType = new ArrayList<CourtCaseDetails>();

		try {

			AllHsscCourtCaseForDept = (List<CourtCaseDetails>) getJdbcTemplate()
					.query("select DISTINCT writNo from courtcasedetails", new RowMapper<CourtCaseDetails>() {
						@Override
						public CourtCaseDetails mapRow(final ResultSet resultSet, final int arg1) throws SQLException {
							final CourtCaseDetails courtcase = new CourtCaseDetails();
							courtcase.setWritNo(resultSet.getInt("writNo"));
							return courtcase;
						}
					});
			AllHsscCourtCaseForDeptyear = (List<CourtCaseDetails>) getJdbcTemplate()
					.query("select DISTINCT year from courtcasedetails", new RowMapper<CourtCaseDetails>() {
						@Override
						public CourtCaseDetails mapRow(final ResultSet resultSet, final int arg1) throws SQLException {
							final CourtCaseDetails courtcase = new CourtCaseDetails();
							courtcase.setYear(resultSet.getString("year"));
							return courtcase;
						}
					});
			AllHsscCourtCaseForDeptstatus = (List<CourtCaseDetails>) getJdbcTemplate()
					.query("select DISTINCT caseStatus	 from courtcasedetails", new RowMapper<CourtCaseDetails>() {
						@Override
						public CourtCaseDetails mapRow(final ResultSet resultSet, final int arg1) throws SQLException {
							final CourtCaseDetails courtcase = new CourtCaseDetails();
							courtcase.setCaseStatus(resultSet.getString("caseStatus"));
							return courtcase;
						}
					});
			AllHsscCourtCaseForDeptType = (List<CourtCaseDetails>) getJdbcTemplate()
					.query("select DISTINCT caseType from courtcasedetails", new RowMapper<CourtCaseDetails>() {
						@Override
						public CourtCaseDetails mapRow(final ResultSet resultSet, final int arg1) throws SQLException {
							final CourtCaseDetails courtcase = new CourtCaseDetails();
							courtcase.setCaseType(resultSet.getString("caseType"));
							return courtcase;
						}
					});
			AllHsscCourtCaseForDept.addAll(AllHsscCourtCaseForDeptyear);
			AllHsscCourtCaseForDept.addAll(AllHsscCourtCaseForDeptstatus);
			AllHsscCourtCaseForDept.addAll(AllHsscCourtCaseForDeptType);
		} catch (Exception e) {
			logger.logError("getAllHsscCourtCasesForDept", "error while fetching data for CaseDetails", e);
		}

		return AllHsscCourtCaseForDept;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CourtCaseDetails> editCourtCaseDetails(Integer caseId) {
		List<CourtCaseDetails> courtCaseDetailsList = new ArrayList<CourtCaseDetails>();
		try {
			DetachedCriteria criteria;
			criteria = DetachedCriteria.forClass(CourtCaseDetails.class);
			criteria.add(Restrictions.eq("caseId", caseId));
			courtCaseDetailsList = (List<CourtCaseDetails>) getHibernateTemplate().findByCriteria(criteria);

		} catch (Exception e) {
			logger.logError("editCourtCaseDetails", "error while fetching data for CaseDetails", e);
		}
		return courtCaseDetailsList;
	}

	@Override
	public List<CourtCaseDetails> getAllCourtCaseDataListForCount() throws Exception {
		List<CourtCaseDetails> CourtCaseDataListForCount = new ArrayList<CourtCaseDetails>();
		try {

			CourtCaseDataListForCount = (List<CourtCaseDetails>) getJdbcTemplate()
					.query("select * from courtcasedetails", new RowMapper<CourtCaseDetails>() {
						@Override
						public CourtCaseDetails mapRow(final ResultSet resultSet, final int arg1) throws SQLException {
							final CourtCaseDetails courtCaseDetails = new CourtCaseDetails();
							courtCaseDetails.setCaseStatus(resultSet.getString("caseStatus"));
							courtCaseDetails.setsRNo(resultSet.getInt("sRNo"));
							return courtCaseDetails;
						}
					});

		} catch (Exception e) {
			logger.logError("getAllCourtCaseDataListForCount", "error while fetching data for Court Case Details", e);
		}
		return CourtCaseDataListForCount;
	}

	/*------------------------distinct Lists for dropdown-------------------------------------------------------*/
	@Override
	public List<String> getdistinctWritNoList() {
		List<String> distinctWritNoList = new ArrayList<String>();
		List<CourtCaseDetails> AllHsscCourtCaseList = new ArrayList<CourtCaseDetails>();
		try {
			AllHsscCourtCaseList = (List<CourtCaseDetails>) getJdbcTemplate()
					.query("select DISTINCT writNo from courtcasedetails", new RowMapper<CourtCaseDetails>() {
						@Override
						public CourtCaseDetails mapRow(final ResultSet resultSet, final int arg1) throws SQLException {
							final CourtCaseDetails courtcase = new CourtCaseDetails();
							if (CommonUtils.isNotEmpty(resultSet.getInt("writNo"))) {
								courtcase.setWritNo(resultSet.getInt("writNo"));
							}
							return courtcase;
						}
					});
			for (CourtCaseDetails s : AllHsscCourtCaseList) {
				distinctWritNoList.add(s.getWritNo().toString());
			}
		} catch (Exception e) {
			logger.logError("getdistinctWritNoList", "error while fetching distinct writNO", e);
		}
		return distinctWritNoList;
	}

	@Override
	public List<String> getdistinctCaseStatusList() {
		List<String> distinctCaseStatusList = new ArrayList<String>();
		List<CourtCaseDetails> AllHsscCourtCaseList = new ArrayList<CourtCaseDetails>();
		try {
			AllHsscCourtCaseList = (List<CourtCaseDetails>) getJdbcTemplate()
					.query("select DISTINCT caseStatus	 from courtcasedetails", new RowMapper<CourtCaseDetails>() {
						@Override
						public CourtCaseDetails mapRow(final ResultSet resultSet, final int arg1) throws SQLException {
							final CourtCaseDetails courtcase = new CourtCaseDetails();
							if (CommonUtils.isNotEmpty(resultSet.getString("caseStatus"))) {
								courtcase.setCaseStatus(resultSet.getString("caseStatus"));
							}
							return courtcase;
						}
					});
			for (CourtCaseDetails s : AllHsscCourtCaseList) {
				distinctCaseStatusList.add(s.getCaseStatus());
			}
		} catch (Exception e) {
			logger.logError("getdistinctWritNoList", "error while fetching distinct writNO", e);
		}
		return distinctCaseStatusList;
	}

	@Override
	public List<String> getdistinctCaseTypeList() {
		List<String> distinctCaseTypeList = new ArrayList<String>();
		List<CourtCaseDetails> AllHsscCourtCaseList = new ArrayList<CourtCaseDetails>();
		try {
			AllHsscCourtCaseList = (List<CourtCaseDetails>) getJdbcTemplate()
					.query("select DISTINCT caseType from courtcasedetails", new RowMapper<CourtCaseDetails>() {
						@Override
						public CourtCaseDetails mapRow(final ResultSet resultSet, final int arg1) throws SQLException {
							final CourtCaseDetails courtcase = new CourtCaseDetails();
							if (CommonUtils.isNotEmpty(resultSet.getString("caseType"))) {
								courtcase.setCaseType(resultSet.getString("caseType"));
							}
							return courtcase;
						}
					});
			for (CourtCaseDetails s : AllHsscCourtCaseList) {
				distinctCaseTypeList.add(s.getCaseType());
			}
		} catch (Exception e) {
			logger.logError("getdistinctWritNoList", "error while fetching distinct writNO", e);
		}
		return distinctCaseTypeList;
	}

	@Override
	public List<String> getdistinctYearList() {
		List<String> distinctYearList = new ArrayList<String>();
		List<CourtCaseDetails> AllHsscCourtCaseList = new ArrayList<CourtCaseDetails>();
		try {
			AllHsscCourtCaseList = (List<CourtCaseDetails>) getJdbcTemplate()
					.query("select DISTINCT year from courtcasedetails", new RowMapper<CourtCaseDetails>() {
						@Override
						public CourtCaseDetails mapRow(final ResultSet resultSet, final int arg1) throws SQLException {
							final CourtCaseDetails courtcase = new CourtCaseDetails();
							if (CommonUtils.isNotEmpty(resultSet.getString("year"))) {
								courtcase.setYear(resultSet.getString("year"));
							}
							return courtcase;
						}
					});
			for (CourtCaseDetails s : AllHsscCourtCaseList) {
				distinctYearList.add(s.getYear());
			}
		} catch (Exception e) {
			logger.logError("getdistinctWritNoList", "error while fetching distinct writNO", e);
		}
		return distinctYearList;
	}

	@Override
	public List<District> getAllDistrict() {
		List<District> distinctDistrictNamesList = new ArrayList<District>();
		try {

			distinctDistrictNamesList = (List<District>) getJdbcTemplate()
					.query("select DISTINCT districtName from district", new RowMapper<District>() {
						@Override
						public District mapRow(final ResultSet resultSet, final int arg1) throws SQLException {
							final District DistrictName = new District();
							if (CommonUtils.isNotEmpty(resultSet.getString("districtName"))) {
								DistrictName.setDistrictName(resultSet.getString("districtName"));
							}
							return DistrictName;
						}
					});

		} catch (Exception e) {
			logger.logError("getAllHsscCourtCasesForDept", "error while fetching data for CaseDetails", e);
		}

		return distinctDistrictNamesList;
	}
	/*-----------------------------------------------------------------------------------------------------------------------*/

	@Override
	public List<Date> getHearingDetailsUniqueDateList() {
		List<HearingDetails> distinctHearingDetailsDateList = new ArrayList<HearingDetails>();
		List<Date> hearingDateList = new ArrayList<Date>();
		try {
			distinctHearingDetailsDateList = (List<HearingDetails>) getJdbcTemplate().query(
					"select distinct MAX(`date`) as date from `hearingdetails` group by `caseId`",
					new RowMapper<HearingDetails>() {
						@Override
						public HearingDetails mapRow(final ResultSet resultSet, final int arg1) throws SQLException {
							final HearingDetails obj = new HearingDetails();
							if (CommonUtils.isNotEmpty(resultSet.getDate("date"))) {
								obj.setDate(resultSet.getDate("date"));
							}
							return obj;
						}
					});

			for (HearingDetails obj : distinctHearingDetailsDateList) {
				hearingDateList.add(obj.getDate());
			}
		} catch (Exception e) {
			logger.logError("getHearingDetailsUniqueDateList", "error while fetching data for hearing details", e);
		}
		return hearingDateList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void updateMacroStatusinMis(Integer sRNo, String macro) {
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(CourtCaseDetails.class);
			criteria.add(Restrictions.eq("sRNo", sRNo));
			criteria.add(Restrictions.eq("stay", "Stay"));
			criteria.setProjection(Projections.rowCount());
			final List<?> results = getHibernateTemplate().findByCriteria(criteria);
			int count = CommonUtils.isEmpty(results) == true ? 0 : ((Long) results.get(0)).intValue();

			DetachedCriteria criteria2 = DetachedCriteria.forClass(Police.class);
			criteria2.add(Restrictions.eq("sRNo", sRNo));
			List<Police> list = (List<Police>) getHibernateTemplate().findByCriteria(criteria2);
			Police obj = list.get(0);
			if (obj.getmAcroStatus().contains("Recommended") || obj.getmAcroStatus().contains("Withdrawn")) {

			} else {
				if (macro.contains("No Stay")) {
					if (count > 0) {
						count = count - 1;
					}
					if (count == 0) {
						obj.setmAcroStatus("In Process");
					}
				} else if (macro.contains("Stay") || macro.contains("Stay Qua Petitioner")) {
					obj.setmAcroStatus("Court Stay");
				} else if (macro.contains("Process Halted") && count == 0) {
					obj.setmAcroStatus("Process Halted");
				} else if (macro.contains("Status Quo") && count == 0) {
					obj.setmAcroStatus("In Process");
				} else if (macro.contains("Stay in favour of Haryana") && count == 0) {
					obj.setmAcroStatus("In Process");
				}
			}
			getHibernateTemplate().update(obj);

		} catch (Exception e) {
			logger.logError("updateMacroStatusinMis", "error while fetching data for mis macro update", e);
		}

	}
	@Override
	public List<String> getUniqueYearList() {
		List<String> list=new ArrayList<String>();
		try {
			list = (List<String>)getJdbcTemplate().query("select distinct year from courtcasedetails ",
					new RowMapper<String>(){
				@Override
				public String mapRow(final ResultSet resultSet, final int arg1) throws SQLException
				{	
					return resultSet.getString("year");
				}				
		});
			if(CommonUtils.isNotEmpty(list)) {
				return 	list;
				}else {
				return null;	
				}			
		}catch(Exception e) {
		logger.logError("getUniqueYearList", "error while fetching data for getUniqueYearList", e);		
		}
		return null;
	}


	@Override
	public List<YearWiseCountHelper> getyearWiseCountList(List<String> uniqueYearList,String deptId,String nameOfPost,String caseStatus) {
		
		try {
			ArrayList<YearWiseCountHelper> list=new ArrayList<YearWiseCountHelper>();
			String countQuery="select count(*) as count, year from (Select c.*,p.dEpartmentId,p.nAmeOfPost,d.dEpartment from courtcasedetails c JOIN police p ON c.sRNo=p.sRNo " + 
					" JOIN department d ON p.dEpartmentId=d.dEpartmentId) s where year in (";
				
					Iterator<String> it = uniqueYearList.iterator();
					if (it.hasNext()) {
						countQuery += it.next();
						
					}
					while (it.hasNext()) {
						countQuery +=  ","+it.next() ;
						
					}
									
										
			countQuery=countQuery+") ";
					
			if(CommonUtils.isNotEmpty(deptId)&& !deptId.contains("Department...")) {
				countQuery=countQuery+"AND dEpartmentId="+deptId;
			}
			if(CommonUtils.isNotEmpty(nameOfPost)&& !nameOfPost.contains("Name Of Post..."))
			{
				countQuery=countQuery+" AND s.nAmeOfPost='"+nameOfPost+"'";	
			}	
			if(CommonUtils.isNotEmpty(caseStatus)&& !caseStatus.contains("status..."))
			{
				countQuery=countQuery+" AND s.caseStatus='"+caseStatus+"'";	
			}	
			countQuery=countQuery+"	Group By year";
			list = (ArrayList<YearWiseCountHelper>)getJdbcTemplate().query(countQuery,
					new RowMapper<YearWiseCountHelper>(){
				@Override
				public YearWiseCountHelper mapRow(final ResultSet resultSet, final int arg1) throws SQLException
				{	
					YearWiseCountHelper obj=new YearWiseCountHelper();
					obj.setYear(resultSet.getString("year"));
					obj.setCount(resultSet.getInt("count"));
					return obj;
				}				
		});
		
		if(CommonUtils.isNotEmpty(list)) {
		
		return list;
		}else {
			return null;
		}	
			
		}catch(Exception e) {
		logger.logError("getyearWiseCountList", "error while fetching data for getyearWiseCountList", e);		
		}
		return null;
	}


	@Override
	public List<DepartmentWiseCountHelper> getdeptWiseCount(String year,String legalIssue) {
		try {
		
			ArrayList<DepartmentWiseCountHelper> list=new ArrayList<DepartmentWiseCountHelper>();
			//Iterator Itr = uniqueYearList.iterator();
			String countQuery="Select Count(*) as count,b.dEpartment,b.nOOfPosts  from (Select c.*,p.dEpartmentId,p.nOOfPosts,d.dEpartment from courtcasedetails c " + 
					"JOIN police p ON c.sRNo=p.sRNo " + 
					"JOIN department d ON p.dEpartmentId=d.dEpartmentId) b ";
			
			if(CommonUtils.isNotEmpty(year)&& !year.contains("Year...")) {
			 countQuery=countQuery+"WHERE year='"+year+"'";
			}
			if(CommonUtils.isNotEmpty(legalIssue)&& !legalIssue.contains("LegalIssue...")) {
				if(countQuery.contains("WHERE")) {
					countQuery=countQuery+"AND legalIssue='"+legalIssue+"'";	
				}else {
			    countQuery=countQuery+" Where legalIssue='"+legalIssue+"'";	
				}
			}			
			 countQuery=countQuery+"  group by b.dEpartment ";
			list = (ArrayList<DepartmentWiseCountHelper>)getJdbcTemplate().query(countQuery,
					new RowMapper<DepartmentWiseCountHelper>(){
				@Override
				public DepartmentWiseCountHelper mapRow(final ResultSet resultSet, final int arg1) throws SQLException
				{	
					DepartmentWiseCountHelper obj=new DepartmentWiseCountHelper();
					obj.setCount(resultSet.getInt("count"));
					obj.setDeptName(resultSet.getString("dEpartment"));
					obj.setNoOfPost(resultSet.getInt("nOOfPosts"));
					return obj;
				}				
		});
		
		if(CommonUtils.isNotEmpty(list)) {
		
		return list;
		}else {
			return null;
		}	
			
			
		}catch(Exception e) {
		logger.logError("getdeptWiseCount", "error while fetching data for getdeptWiseCount", e);	
		}
		return null;
	}

	@Override
	public List<String> getUniqueStatusList() {
		List<String> list=new ArrayList<String>();
		try {
			list = (List<String>)getJdbcTemplate().query("select distinct caseStatus from courtcasedetails ",
					new RowMapper<String>(){
				@Override
				public String mapRow(final ResultSet resultSet, final int arg1) throws SQLException
				{	
					return resultSet.getString("caseStatus");
				}				
		});
			if(CommonUtils.isNotEmpty(list)) {
				return 	list;
				}else {
				return null;	
				}	
		}catch(Exception e) {
			logger.logError("getUniqueStatusList", "error while fetching data for getUniqueStatusList", e);	
		}
		return null;
	}

	@Override
	public List<String> getUniqueLegalIssuesList() {
		List<String> list=new ArrayList<String>();
		try {
			list = (List<String>)getJdbcTemplate().query("select distinct legalIssue from courtcasedetails ",
					new RowMapper<String>(){
				@Override
				public String mapRow(final ResultSet resultSet, final int arg1) throws SQLException
				{	
					return resultSet.getString("legalIssue");
				}				
		});
			if(CommonUtils.isNotEmpty(list)) {
				return 	list;
				}else {
				return null;	
				}
		}catch(Exception e) {
			logger.logError("getUniqueLegalIssuesList", "error while fetching data for getUniqueLegalIssuesList", e);		
		}
		return null;
	}

	@Override
	public List<ImpactGraphHelper> getImpactGraphCount(String advtNo, String cAtNo, String departId, String caseStatusForImpact) {
		List<ImpactGraphHelper> list=new ArrayList<ImpactGraphHelper>();
		try {
			
			String query="select year,sum(ifnull(noofposts,0)) noofposts,sum(ifnull(noofcases ,0)) noofcases from (\r\n" + 
					"select  year,sum(p.noofposts) noofposts,null noofcases  from \r\n" + 
					"(select min(year) year ,srno from (SELECT DISTINCT  `year`,`sRNo`\r\n" + 
					"FROM `courtcasedetails`  ) a group by srno ) s left join police p on s.srno=p.srno \r\n" + 
					"group by year\r\n" + 
					"union all\r\n" + 
					"SELECT  `year`, null noofposts,COUNT(*) noofcases FROM `courtcasedetails` GROUP BY `year`) l group by year";
		/*	if(CommonUtils.isNotEmpty(advtNo) && !advtNo.contains("Advt...")) {
				query=query+"WHERE p.aDvtNo='"+advtNo+"'";
			}
			if(CommonUtils.isNotEmpty(cAtNo) && !cAtNo.contains("CatNo...")) {
				if(query.contains("WHERE")) {
				query=query+"WHERE p.cAtNo='"+cAtNo+"'";
				}else {
					query=query+"AND p.cAtNo='"+cAtNo+"'";	
				}
			}
			if(CommonUtils.isNotEmpty(departId) && !departId.contains("Department...")) {
				if(!query.contains("WHERE")) {
				query=query+" WHERE p.dEpartmentId='"+departId+"'";
				}else if(query.contains("AND")){
					query=query+"p.dEpartmentId='"+departId+"'";	
				}
				else {
					query=query+"AND p.dEpartmentId='"+departId+"'";	
				}
			}
			if(CommonUtils.isNotEmpty(caseStatusForImpact) && !caseStatusForImpact.contains("Status...")) {
				if(!query.contains("WHERE")) {
				query=query+" WHERE c.caseStatus='"+caseStatusForImpact+"'";
				}else if(query.contains("AND")){
					query=query+"c.caseStatus='"+caseStatusForImpact+"'";	
				}
				else {
					query=query+"AND c.caseStatus='"+caseStatusForImpact+"'";	
				}
			}
			query=query+" Group By c.year";*/
			list = (List<ImpactGraphHelper>)getJdbcTemplate().query(query,	new RowMapper<ImpactGraphHelper>(){
				@Override
				public ImpactGraphHelper mapRow(final ResultSet resultSet, final int arg1) throws SQLException
				{
					ImpactGraphHelper obj=new ImpactGraphHelper();
					/*obj.setAdvtNo(resultSet.getString("advtNo"));
					obj.setcAtNo(resultSet.getString("cAtNo"));*/
					obj.setCount(resultSet.getInt("noofcases"));
					obj.setYear(resultSet.getString("year"));
					obj.setSumOfNoOfPost(resultSet.getLong("noofposts"));
					return obj;	
					
				}				
		});
			if(CommonUtils.isNotEmpty(list)) {
				return 	list;
				}else {
				return null;	
				}	
		}catch(Exception e) {
		logger.logError("getImpactGraphCount", "error while fetching data for getImpactGraphCount", e);		
		}
		return null;
	}
	@Override
	public List<ImpactGraphHelper> getImpactGraphLegalIssueCount(String year, String departIdForLegal) {
		List<ImpactGraphHelper> list=new ArrayList<ImpactGraphHelper>();
		try {
			
			String query="Select Count(*) as count, p.advtNo,p.cAtNo, p.nOOfPosts as sumOfNoOfPost, "+
			" c.legalIssue, c.year from courtcasedetails c " +" JOIN police p ON c.sRNo=p.sRNo "+" JOIN department d ON p.dEpartmentId=d.dEpartmentId WHERE (length(trim(legalIssue))!=0) ";
			
			if(CommonUtils.isNotEmpty(year)&& !year.contains("Year...")) {
				if(query.contains("WHERE")) {
				query=query+" AND year='"+year+"'";
				  }
				}
			if(CommonUtils.isNotEmpty(departIdForLegal)&& !departIdForLegal.contains("Department...")) {
				if(query.contains("WHERE")) {
				query=query+" AND p.dEpartmentId='"+departIdForLegal+"'";
				  }
				else if (query.contains("AND")) {
					query=query+" AND p.dEpartmentId='"+departIdForLegal+"'";
				}
			}
			
			query=query+" Group By c.legalIssue";
			list = (List<ImpactGraphHelper>)getJdbcTemplate().query(query,	new RowMapper<ImpactGraphHelper>(){
				@Override
				public ImpactGraphHelper mapRow(final ResultSet resultSet, final int arg1) throws SQLException
				{
					ImpactGraphHelper obj=new ImpactGraphHelper();
					obj.setAdvtNo(resultSet.getString("advtNo"));
					obj.setcAtNo(resultSet.getString("cAtNo"));
					obj.setCount(resultSet.getInt("count"));
					obj.setLegalIssue(resultSet.getString("legalIssue"));
					obj.setSumOfNoOfPost(resultSet.getLong("sumOfNoOfPost"));
					return obj;	
					
				}				
		});
			if(CommonUtils.isNotEmpty(list)) {
				return 	list;
				}else {
				return null;	
				}	
		}catch(Exception e) {
		logger.logError("getImpactGraphCount", "error while fetching data for getImpactGraphCount", e);		
		}
		return null;
	}
	
	@Override
	public List<HearingDateGraphHelper> getHearingDateGraphData(String deptIdForHearingGraph, String nameOfPostForHearingGraph) {
		List<HearingDateGraphHelper> list=new ArrayList<HearingDateGraphHelper>();
		try {
			
			String query="Select b.sRNo,b.nAmeOfPost,b.dEpartment,b.nOOfPosts,b.cAtNo, b.aDvtNo,b.mAcroStatus, b.caseId, MAX(b.date) as date  from (Select c.*, p.dEpartmentId,p.nOOfPosts,p.nAmeOfPost,p.cAtNo,\r\n" + 
					"p.mAcroStatus,d.dEpartment,h.date\r\n" + 
					"from courtcasedetails c \r\n" + 
					"JOIN police p ON c.sRNo=p.sRNo Join hearingdetails h ON h.caseId=c.caseId\r\n" + 
					"JOIN department d ON p.dEpartmentId=d.dEpartmentId) b";
			
			if(CommonUtils.isNotEmpty(deptIdForHearingGraph) && !deptIdForHearingGraph.contains("Department For Hearing...")) {
				query=query+" WHERE b.dEpartment='"+deptIdForHearingGraph+"'";
			}
			if(CommonUtils.isNotEmpty(nameOfPostForHearingGraph) && !nameOfPostForHearingGraph.contains("Name Of Post for Hearing...")) {
				if(!query.contains("WHERE")) {
				query=query+" WHERE b.nAmeOfPost='"+nameOfPostForHearingGraph+"'";
				}else {
					query=query+"AND b.nAmeOfPost='"+nameOfPostForHearingGraph+"'";	
				}
			}
			
			query=query+" Group By b.nAmeOfPost";
			list = (List<HearingDateGraphHelper>)getJdbcTemplate().query(query,	new RowMapper<HearingDateGraphHelper>(){
				@Override
				public HearingDateGraphHelper mapRow(final ResultSet resultSet, final int arg1) throws SQLException
				{
					HearingDateGraphHelper obj=new HearingDateGraphHelper();
					obj.setsRNo(resultSet.getInt("sRNo"));
					obj.setnAmeOfPost(resultSet.getString("nAmeOfPost"));
					obj.setdEpartment(resultSet.getString("dEpartment"));
					obj.setnOOfPosts(resultSet.getLong("nOOfPosts"));
					obj.setcAtNo(resultSet.getString("cAtNo"));
					obj.setAdvtNo(resultSet.getString("advtNo"));
					obj.setmAcroStatus(resultSet.getString("mAcroStatus"));
					obj.setDate(resultSet.getDate("date"));
					
					return obj;	
					
				}				
		});
			if(CommonUtils.isNotEmpty(list)) {
				return 	list;
				}else {
				return null;	
				}	
		}catch(Exception e) {
		logger.logError("getHearingDateGraphData", "error while fetching data for getHearingDateGraphData", e);		
		}
		return null;
	}

	@Override
	public List<String> getUniqueAdvtList() {
		List<String> list=new ArrayList<String>();
		try {
			list = (List<String>)getJdbcTemplate().query("select distinct advtNo from police ",
					new RowMapper<String>(){
				@Override
				public String mapRow(final ResultSet resultSet, final int arg1) throws SQLException
				{	
					return resultSet.getString("advtNo");
				}				
		});
			if(CommonUtils.isNotEmpty(list)) {
				return 	list;
				}else {
				return null;	
				}
		}catch(Exception e) {
		logger.logError("getUniqueAdvtList", "error while fetching data for getUniqueAdvtList", e);	
		}
		return null;
	}

	@Override
	public List<String> getuniqueCatNoList() {
		List<String> list=new ArrayList<String>();
		try {
			list = (List<String>)getJdbcTemplate().query("select distinct cAtNo from police ",
					new RowMapper<String>(){
				@Override
				public String mapRow(final ResultSet resultSet, final int arg1) throws SQLException
				{	
					return resultSet.getString("cAtNo");
				}				
		});
			if(CommonUtils.isNotEmpty(list)) {
				return 	list;
				}else {
				return null;	
				}
		}catch(Exception e) {
		logger.logError("getuniqueCatNoList", "error while fetching data for getuniqueCatNoList", e);	
		}
		return null;
	}

	public List<DepartmentVO> getUniqueAdvtWithCasesList() throws Exception{
		     List<DepartmentVO> list=new ArrayList<DepartmentVO>();
		try {
			list = (List<DepartmentVO>)getJdbcTemplate().query("SELECT  p.`aDvtNo`, p.`cAtNo`,p.`nOOfPosts`, COUNT(*) as `No of Cases`\r\n" + 
					"\r\n" + 
					"FROM `courtcasedetails` c left join police p on c.srno=p.srno\r\n" + 
					"\r\n" + 
					"GROUP BY c.`sRNo` order by 1,2",
					new RowMapper<DepartmentVO>(){
				@Override
				public DepartmentVO mapRow(final ResultSet resultSet, final int arg1) throws SQLException
				{	
					DepartmentVO obj=new DepartmentVO();
					obj.setAdvtNo(resultSet.getString("aDvtNo"));
					obj.setCatNo(resultSet.getInt("cAtNo"));
					obj.setnOOfPosts(resultSet.getLong("nOOfPosts"));
					obj.setCount(resultSet.getInt("No of Cases"));
					return obj;
				}				
		});
			if(CommonUtils.isNotEmpty(list)) {
				return 	list;
				}else {
				return null;	
				}
		}catch(Exception e) {
			logger.logError("getUniqueAdvtWithCasesList", "error while fetching data for getUniqueAdvtWithCasesList", e);	
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HearingDetails> getAllHearingDates(Date yesterdayDate) throws Exception {
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(HearingDetails.class);
			criteria.add(Restrictions.eq("date", yesterdayDate));
			List<HearingDetails>  hearingDateList= (List<HearingDetails>) getHibernateTemplate().findByCriteria(criteria);
			if (CommonUtils.isNotEmpty(hearingDateList)) {
				return hearingDateList;
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.logError("getAllHearingDates", "error while fetching dates for CaseDetails", e);
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public CourtCaseDetails getCourtCaseByCaseId(Integer caseId) throws Exception {
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(CourtCaseDetails.class);
			criteria.add(Restrictions.eq("caseId", caseId));
			List<CourtCaseDetails>  courtCaseList= (List<CourtCaseDetails>) getHibernateTemplate().findByCriteria(criteria);
			if (CommonUtils.isNotEmpty(courtCaseList)) {
				return courtCaseList.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.logError("getCourtCaseByCaseId", "error while fetching data for CaseDetails", e);
			throw e;
		}
	}
}
