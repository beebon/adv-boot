package org.adv.modules.quartz.job;

import org.adv.common.util.DateUtils;
import org.adv.common.util.DateUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import lombok.extern.slf4j.Slf4j;

/**
 * 示例不带参定时任务
 * 
 * @author Scott
 */
@Slf4j
public class SampleJob implements Job {

	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

		log.info(String.format(" adv-boot 普通定时任务 SampleJob !  时间:" + DateUtils.getTimestamp()));
	}
}
