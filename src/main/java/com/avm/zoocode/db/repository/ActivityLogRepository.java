package com.avm.zoocode.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avm.zoocode.db.entity.ActivityLog;

public interface ActivityLogRepository extends JpaRepository<ActivityLog, Integer> {

	public ActivityLog findActivityLogByUserId(Integer userId);
}
