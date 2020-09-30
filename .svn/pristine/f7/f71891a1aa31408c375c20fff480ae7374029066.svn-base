package in.hkcl.dao;

import java.util.List;

import org.displaytag.properties.SortOrderEnum;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import in.hkcl.dao.common.DaoSupport;
import in.hkcl.model.ExamCenterAllocation;
import in.hkcl.model.ExamCenterDetails;
import in.hkcl.model.ExamDetails;
import in.hkcl.model.ExamInvigilatorsDetails;
import in.hkcl.model.ZoneDistrictMapping;
import in.hkcl.utils.ApplicationLogFactory;
import in.hkcl.utils.ApplicationLogger;
import in.hkcl.utils.CommonUtils;

public class ExamCenterDaoImpl extends DaoSupport implements ExamCenterDao{
	
	private static ApplicationLogger logger = ApplicationLogFactory.getLogger(ExamCenterDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<ExamCenterDetails> getExamCentersList(Integer examId) throws Exception {
		DetachedCriteria criteria=DetachedCriteria.forClass(ExamCenterDetails.class);
		try {
			if(CommonUtils.isNotEmpty(examId)) {
				criteria.add(Restrictions.eq("examId", examId));
				
				List<ExamCenterDetails>  examCentersList= (List<ExamCenterDetails>) getHibernateTemplate().findByCriteria(criteria);
				
				if (CommonUtils.isNotEmpty(examCentersList)) {
					return examCentersList;
				} else {
					return null;
				}
			}
			
		}catch(Exception e) {
			logger.logError("getExamCentersList", "Error while getting examcenter data", e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExamInvigilatorsDetails> getInvigilatorsList(Integer examId) throws Exception {
		DetachedCriteria criteria=DetachedCriteria.forClass(ExamInvigilatorsDetails.class);
		try {
			if(CommonUtils.isNotEmpty(examId)) {
				criteria.add(Restrictions.eq("examId", examId));
				
				List<ExamInvigilatorsDetails>  invigilatorList= (List<ExamInvigilatorsDetails>) getHibernateTemplate().findByCriteria(criteria);
				
				if (CommonUtils.isNotEmpty(invigilatorList)) {
					return invigilatorList;
				} else {
					return null;
				}
			}
			
		}catch(Exception e) {
			logger.logError("getInvigilatorsList", "Error while getting invigilator data", e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ZoneDistrictMapping> getZoneDistrictMapping() throws Exception {
		DetachedCriteria criteria=DetachedCriteria.forClass(ZoneDistrictMapping.class);
		try {
			
			List<ZoneDistrictMapping>  zoneMappingList= (List<ZoneDistrictMapping>) getHibernateTemplate().findByCriteria(criteria);
			if(CommonUtils.isNotEmpty(zoneMappingList)) {
				return zoneMappingList;
			}
		}catch(Exception e) {
			logger.logError("getZoneDistrictMapping", "Error while getting zonemapping data", e);
		}
		return null;
	}

	@Override
	public void saveExamCenterAllocation(ExamCenterAllocation value) throws Exception {
		getHibernateTemplate().save(value);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public ZoneDistrictMapping getZoneID(Integer idDistrict) throws Exception {
		DetachedCriteria criteria=DetachedCriteria.forClass(ZoneDistrictMapping.class);
		try {
			if(CommonUtils.isNotEmpty(idDistrict)) {
				criteria.add(Restrictions.eq("idDistrict", idDistrict));
			}
			List<ZoneDistrictMapping>  zoneMappingList= (List<ZoneDistrictMapping>) getHibernateTemplate().findByCriteria(criteria);
			if(CommonUtils.isNotEmpty(zoneMappingList)) {
				return zoneMappingList.get(0);
			}
		}catch(Exception e) {
			logger.logError("getZoneDistrictMapping", "Error while getting zonemapping data", e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExamDetails> getAllExams(int firstRecordIndex, int pageSize, SortOrderEnum sortDirection,
			String sortCriterion) throws Exception {
		DetachedCriteria criteria=DetachedCriteria.forClass(ExamDetails.class);
		try {
			if (CommonUtils.isNotEmpty(sortCriterion)) {
				if (sortDirection.equals(SortOrderEnum.ASCENDING)) {
					criteria.addOrder(Order.asc(sortCriterion));
				}
				if (sortDirection.equals(SortOrderEnum.DESCENDING)) {
					criteria.addOrder(Order.desc(sortCriterion));
				}
			}else {
				criteria.addOrder(Order.asc("createdDate"));
			}
			
			List<ExamDetails>	examsList = (List<ExamDetails>) getHibernateTemplate().findByCriteria(criteria, firstRecordIndex, pageSize);
			if (CommonUtils.isNotEmpty(examsList)) {
				return examsList;
			} else {
				return null;
			}
		}catch(Exception e) {
			logger.logError("getAllExams", "Error while getting Exams List", e);
		}
		return null;
	}

	@Override
	public int getAllExamsCount() throws Exception {
		final DetachedCriteria criteria = DetachedCriteria.forClass(ExamDetails.class);
		criteria.setProjection(Projections.rowCount());
		final List<?> results = getHibernateTemplate().findByCriteria(criteria);
		return CommonUtils.isEmpty(results) == true ? 0 : ((Long) results.get(0)).intValue();
	}

	@Override
	public void deleteExamCenterAllocation(Integer examId) throws Exception {
		String deleteQuery="delete from ExamCenterAllocation where examId=?";
		getHibernateTemplate().bulkUpdate(deleteQuery, examId);
	}

	@Override
	public int getAllocationCount(int examId) throws Exception {
		final DetachedCriteria criteria = DetachedCriteria.forClass(ExamCenterAllocation.class);
		if(CommonUtils.isNotEmpty(examId)) {
			criteria.add(Restrictions.eq("examId", examId));
		}
		criteria.setProjection(Projections.rowCount());
		final List<?> results = getHibernateTemplate().findByCriteria(criteria);
		return CommonUtils.isEmpty(results) == true ? 0 : ((Long) results.get(0)).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExamCenterAllocation> getAllocationList(int examId) throws Exception {
		DetachedCriteria criteria=DetachedCriteria.forClass(ExamCenterAllocation.class);
		try {
			if(CommonUtils.isNotEmpty(examId)) {
				criteria.add(Restrictions.eq("examId", examId));
				
				List<ExamCenterAllocation>  allcationList= (List<ExamCenterAllocation>) getHibernateTemplate().findByCriteria(criteria);
				
				if (CommonUtils.isNotEmpty(allcationList)) {
					return allcationList;
				} else {
					return null;
				}
			}
			
		}catch(Exception e) {
			logger.logError("getAllocationList", "Error while getting Allcation data", e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ExamDetails getCenterAllotmentData(int examId) throws Exception {
		DetachedCriteria criteria=DetachedCriteria.forClass(ExamDetails.class);
		try {
			if(CommonUtils.isNotEmpty(examId)) {
				criteria.add(Restrictions.eq("examId", examId));
				
				List<ExamDetails>  centerAllotmentList= (List<ExamDetails>) getHibernateTemplate().findByCriteria(criteria);
				
				if (CommonUtils.isNotEmpty(centerAllotmentList)) {
					return centerAllotmentList.get(0);
				} else {
					return null;
				}
			}
			
		}catch(Exception e) {
			logger.logError("getCenterAllotmentData", "Error while getting Center Allotment data", e);
		}
		return null;
	}

	

}
