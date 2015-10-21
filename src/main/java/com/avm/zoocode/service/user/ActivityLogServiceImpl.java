package com.avm.zoocode.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avm.zoocode.db.entity.ActivityLog;
import com.avm.zoocode.db.repository.ActivityLogRepository;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {

	@Autowired
	private ActivityLogRepository activityLogRepository;

	@Override
	public ActivityLog findActivityLogByUserId(Integer userId) {

		return activityLogRepository.findActivityLogByUserId(userId);

	}

}
