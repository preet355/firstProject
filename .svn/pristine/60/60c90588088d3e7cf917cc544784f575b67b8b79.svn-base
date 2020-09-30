package in.hkcl.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import in.hkcl.dao.ExamCenterDao;
import in.hkcl.model.ExamCenterAllocation;
import in.hkcl.model.ExamCenterDetails;
import in.hkcl.model.ExamDetails;
import in.hkcl.model.ExamInvigilatorsDetails;
import in.hkcl.model.ZoneDistrictMapping;
import in.hkcl.pagination.ExtendedPaginatedList;
import in.hkcl.utils.ApplicationLogFactory;
import in.hkcl.utils.ApplicationLogger;
import in.hkcl.utils.CommonUtils;

@Repository("examDataService")
@Transactional
public class ExamCenterServiceImpl implements ExamDataService{
	
	private static ApplicationLogger logger = ApplicationLogFactory.getLogger(ExamCenterServiceImpl.class);
	
	@Autowired
	ExamCenterDao examDataDao;
	
	private void fetchExamCentersList(Integer ExamId, HashMap<Integer, HashMap<String, ExamCenterDetails>> examCentersMap) throws Exception {
		HashMap<String, ExamCenterDetails> examCenters=null;
		List<ExamCenterDetails> examCenterList=examDataDao.getExamCentersList(ExamId);
		if(CommonUtils.isNotEmpty(examCenterList)) {
			for(ExamCenterDetails obj:examCenterList) {
				String uniqueExamCenterCode=obj.getExamCenterName().substring(0,2).concat(obj.getExamCenterId().toString());
				if(examCentersMap.containsKey(obj.getIdDistrict())) {
					examCentersMap.get(obj.getIdDistrict()).put(uniqueExamCenterCode, obj);
				}else {
					examCenters=new HashMap<String,ExamCenterDetails>();
					examCenters.put(uniqueExamCenterCode, obj);
					examCentersMap.put(obj.getIdDistrict(), examCenters);
				}
			}
		}
		
	}
	
	private void fetchInvigilatorList(Integer examId, HashMap<Integer, HashMap<String, ExamInvigilatorsDetails>> invigilatorsMap) throws Exception {
		HashMap<String, ExamInvigilatorsDetails> invigMap=null;
		List<ExamInvigilatorsDetails> invigilatorsList=examDataDao.getInvigilatorsList(examId);
		if(CommonUtils.isNotEmpty(invigilatorsList)) {
			for(ExamInvigilatorsDetails obj:invigilatorsList) {
				String uniqueInvigilatorCode=obj.getInvigilatorName().substring(0,2).concat(obj.getInvigilatorId().toString());
				if(invigilatorsMap.containsKey(obj.getIdDistrict())) {
					invigilatorsMap.get(obj.getIdDistrict()).put(uniqueInvigilatorCode, obj);
				}else {
					invigMap=new HashMap<String,ExamInvigilatorsDetails>();
					invigMap.put(uniqueInvigilatorCode, obj);
					invigilatorsMap.put(obj.getIdDistrict(), invigMap);
				}
			}
		}
	}
	private void fetchZonesDetails(HashMap<Integer, List<ZoneDistrictMapping>> zoneDistrictMap) throws Exception {
		List<ZoneDistrictMapping> zoneList=examDataDao.getZoneDistrictMapping();
		if(CommonUtils.isNotEmpty(zoneList)) {
			for(ZoneDistrictMapping obj:zoneList) {
				if(zoneDistrictMap.containsKey(obj.getZoneId())) {
					zoneDistrictMap.get(obj.getZoneId()).add(obj);
				}else {
					List<ZoneDistrictMapping> list=new ArrayList<ZoneDistrictMapping>();
					list.add(obj);
					zoneDistrictMap.put(obj.getZoneId(), list);
				}
			}
		}
	}

	@Override
	public String AllocateInvigilators(Integer ExamId) throws Exception {
		
		HashMap<Integer, HashMap<String, ExamCenterDetails>> examCentersMap=new HashMap<Integer, HashMap<String, ExamCenterDetails>>();
		HashMap<Integer, HashMap<String, ExamInvigilatorsDetails>> invigilatorsMap=new HashMap<Integer,  HashMap<String, ExamInvigilatorsDetails>>();
		HashMap<Integer, List<ZoneDistrictMapping>> zoneDistrictMap=new HashMap<Integer, List<ZoneDistrictMapping>>();
		HashMap<String, ExamCenterAllocation> allocationMap=new HashMap<String, ExamCenterAllocation>();

		examDataDao.deleteExamCenterAllocation(ExamId);
		fetchExamCentersList(ExamId, examCentersMap);
		fetchInvigilatorList(ExamId, invigilatorsMap);
		fetchZonesDetails(zoneDistrictMap);
		
		zoneWiseAllocation(ExamId,examCentersMap,invigilatorsMap,zoneDistrictMap,allocationMap);
		outSideZoneAllocation(ExamId,examCentersMap,invigilatorsMap,zoneDistrictMap,allocationMap);
		lastAllocationOutsideZone(ExamId,examCentersMap,invigilatorsMap,zoneDistrictMap,allocationMap);
		
		saveExamCenterAllocation(allocationMap);
		return null;
	}


	

	private void saveExamCenterAllocation(HashMap<String, ExamCenterAllocation> allocationMap) throws Exception {
		for(Map.Entry<String, ExamCenterAllocation> entry:allocationMap.entrySet() ) {
			examDataDao.saveExamCenterAllocation(entry.getValue());
		}
	}
	
	
	private ExamCenterAllocation prepareAllocationObject(Integer examId, String allotedExamCenterName, String allotedExamCenterDistrict, String allotedZoneName, 
			String invigilatorDistrict, String invigilatorZone, String invigilatorName, String uniqueExamCenterCode, String uniqueInvigilatorCode) {
		ExamCenterAllocation object=new ExamCenterAllocation();
		object.setExamId(examId);
		object.setAllotedExamCenterName(allotedExamCenterName);
		object.setAllotedExamCenterDistrict(allotedExamCenterDistrict);
		object.setAllotedZoneName(allotedZoneName);
		object.setInvigilatorDistrict(invigilatorDistrict);
		object.setInvigilatorZone(invigilatorZone);
		object.setInvigilatorName(invigilatorName);
		object.setUniqueExamCenterCode(uniqueExamCenterCode);
		object.setUniqueInvigilatorCode(uniqueInvigilatorCode);
		return object;
	}


	@SuppressWarnings("rawtypes")
	private void zoneWiseAllocation(Integer ExamId,HashMap<Integer, HashMap<String, ExamCenterDetails>> examCentersMap,
			HashMap<Integer, HashMap<String, ExamInvigilatorsDetails>> invigilatorsMap,HashMap<Integer, List<ZoneDistrictMapping>> zoneDistrictMap,
			HashMap<String, ExamCenterAllocation> allocationMap) {
		try {
			for(Map.Entry<Integer, List<ZoneDistrictMapping>> zone : zoneDistrictMap.entrySet()) {
				for(ZoneDistrictMapping obj: zone.getValue()) {
					HashMap<String, ExamInvigilatorsDetails> invigilatorMap=invigilatorsMap.get(obj.getIdDistrict());
					
					for(ZoneDistrictMapping obj1: zone.getValue()) {
						if(!obj.getIdDistrict().equals(obj1.getIdDistrict())) {
							HashMap<String, ExamCenterDetails> examcenterMap=examCentersMap.get(obj1.getIdDistrict());
						
						if(CommonUtils.isNotEmpty(invigilatorMap)) {
							Iterator<?> invigilatorIterator = invigilatorMap.entrySet().iterator();
							while(invigilatorIterator.hasNext()) {
								Map.Entry  vo1= (Map.Entry)invigilatorIterator.next(); 
								
								
								ExamInvigilatorsDetails vo=(ExamInvigilatorsDetails) vo1.getValue();
								
								if(null!=examcenterMap) {
									if(!examcenterMap.isEmpty()) {
									
									Object[] randomKeys = examcenterMap.keySet().toArray();
									Object key = randomKeys[new Random().nextInt(randomKeys.length)];
									
									ExamCenterDetails examCenterObject=examcenterMap.get(key.toString());
									
									if(!allocationMap.containsKey(vo1.getKey())) {
										allocationMap.put(vo1.getKey().toString(), prepareAllocationObject(ExamId,examCenterObject.getExamCenterName(),
												obj1.getDistrictObj().getDistrictName(),obj1.getZoneObj().getZoneName(),vo.getDistrictObj().getDistrictName(),
												vo.getZoneObj().getZoneName(),vo.getInvigilatorName(),key.toString(),vo1.getKey().toString()));
										
										examcenterMap.remove(key.toString());
									 }
								   }else {
									   break;
								   }
							  }else {
								  break;
							  }
							}
						  }
						}
					}
				}
			}
		}catch(Exception e) {
			logger.logError("zoneWiseAllocation", "Error While allocating invigilators", e);
		}
		
	}
	
	private void outSideZoneAllocation(Integer examId,HashMap<Integer, HashMap<String, ExamCenterDetails>> examCentersMap,
			HashMap<Integer, HashMap<String, ExamInvigilatorsDetails>> invigilatorsMap,HashMap<Integer, List<ZoneDistrictMapping>> zoneDistrictMap,
			HashMap<String, ExamCenterAllocation> allocationMap) {
		try {
			HashMap<String, ExamInvigilatorsDetails> invigilatorMap=invigilatorsMap.get(100);
			
			for(Map.Entry<Integer, HashMap<String, ExamCenterDetails>> vo:examCentersMap.entrySet()) {
				
				HashMap<String, ExamCenterDetails> examCenterHashmap=vo.getValue();
				
				for(Map.Entry<String, ExamInvigilatorsDetails> vo1:invigilatorMap.entrySet()) {
					ExamInvigilatorsDetails obj=vo1.getValue();
						
						if(!examCenterHashmap.isEmpty() && null!=examCenterHashmap) {
							
							
							Object[] randomKeys = examCenterHashmap.keySet().toArray();
							Object key = randomKeys[new Random().nextInt(randomKeys.length)];
							
							ExamCenterDetails examCenterObject=examCenterHashmap.get(key.toString());
							
							if(!allocationMap.containsKey(vo1.getKey())) {
								
								ZoneDistrictMapping zoneMappingObj=examDataDao.getZoneID(examCenterObject.getDistrictObj().getIdDistrict());
								allocationMap.put(vo1.getKey(), prepareAllocationObject(examId,examCenterObject.getExamCenterName(),
										examCenterObject.getDistrictObj().getDistrictName(),zoneMappingObj.getZoneObj().getZoneName(),"Outside Haryana",
										"Z100",obj.getInvigilatorName(),key.toString(),vo1.getKey()));
								
								examCenterHashmap.remove(key.toString());
							}
							
					}else {
						break;
					}
				}
			}
			
			
		}catch(Exception e) {
			logger.logError("outSideZoneAllocation", "Error While allocating invigilators of outsideZone", e);
		}
		
	}
	
	private void lastAllocationOutsideZone(Integer examId,HashMap<Integer, HashMap<String, ExamCenterDetails>> examCentersMap,
			HashMap<Integer, HashMap<String, ExamInvigilatorsDetails>> invigilatorsMap,HashMap<Integer, List<ZoneDistrictMapping>> zoneDistrictMap,
			HashMap<String, ExamCenterAllocation> allocationMap) {
		try {
			for(Map.Entry<Integer, HashMap<String, ExamCenterDetails>> obj:examCentersMap.entrySet()) {
				   
				for(Map.Entry<Integer, HashMap<String, ExamInvigilatorsDetails>> vo:invigilatorsMap.entrySet()) {
					 HashMap<String, ExamInvigilatorsDetails> invigMap=vo.getValue();
					 
					if(!obj.getKey().equals(vo.getKey())) {
						HashMap<String, ExamCenterDetails> examCenterHashmap=obj.getValue();
						
						if(CommonUtils.isNotEmpty(invigMap)) {	
						for(Map.Entry<String, ExamInvigilatorsDetails> vo1:invigMap.entrySet()) {
							
							ExamInvigilatorsDetails obj1=vo1.getValue();
							if(null!=examCenterHashmap) {
								if(!examCenterHashmap.isEmpty()) {
									
									Object[] randomKeys = examCenterHashmap.keySet().toArray();
									Object key = randomKeys[new Random().nextInt(randomKeys.length)];
									
									ExamCenterDetails examCenterObject=examCenterHashmap.get(key.toString());
									
									if(!allocationMap.containsKey(vo1.getKey())) {
										
										ZoneDistrictMapping zoneMappingObj=examDataDao.getZoneID(examCenterObject.getDistrictObj().getIdDistrict());
										
										allocationMap.put(vo1.getKey(), prepareAllocationObject(examId,examCenterObject.getExamCenterName(),
												examCenterObject.getDistrictObj().getDistrictName(),zoneMappingObj.getZoneObj().getZoneName(),obj1.getDistrictObj().getDistrictName(),
												obj1.getZoneObj().getZoneName(),obj1.getInvigilatorName(),key.toString(),vo1.getKey()));
										
										examCenterHashmap.remove(key.toString());
									}
									
							}else {
								break;
							}
									  
								}
						     }
						  }
						}
					}
				}
		}catch(Exception e) {
			logger.logError("lastAllocationOutsideZone", "Error While allocating invigilators of outsideZone", e);
		}
		
	}

	@Override
	public ExtendedPaginatedList getAllExams(ExtendedPaginatedList paginatedListFromRequest) throws Exception {
		List<ExamDetails> list=examDataDao.getAllExams(paginatedListFromRequest.getFirstRecordIndex(), paginatedListFromRequest.getPageSize(),
				paginatedListFromRequest.getSortDirection(), paginatedListFromRequest.getSortCriterion());
		if (list != null) {
			paginatedListFromRequest.setList(list);
			paginatedListFromRequest.setTotalNumberOfRows(examDataDao.getAllExamsCount());
			return paginatedListFromRequest;
		} else {
			return null;
		}
	}

	@Override
	public List<ExamCenterDetails> getExamCenterList(int parseInt) throws Exception {
		
		return examDataDao.getExamCentersList(parseInt);
	}

	@Override
	public List<ExamInvigilatorsDetails> getInvigilatorsList(int examId) throws Exception {
		return examDataDao.getInvigilatorsList(examId);
	}

	@Override
	public int getAllocationCount(int examId) throws Exception {
		
		return examDataDao.getAllocationCount(examId);
	}

	@Override
	public List<ExamCenterAllocation> getAllocationList(int examId) throws Exception {
		// TODO Auto-generated method stub
		return examDataDao.getAllocationList(examId);
	}

	@Override
	public ExamDetails getCenterAllotmentData(int examId) throws Exception {
		// TODO Auto-generated method stub
		return examDataDao.getCenterAllotmentData(examId);
	}

}
