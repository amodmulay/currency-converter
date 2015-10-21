package com.avm.zoocode.service.user;

import com.avm.zoocode.db.entity.ActivityLog;

public interface ActivityLogService {
	public ActivityLog findActivityLogByUserId(Integer userId);
}
