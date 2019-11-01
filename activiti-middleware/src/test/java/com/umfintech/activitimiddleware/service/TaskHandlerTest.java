package com.umfintech.activitimiddleware.service;

import org.activiti.engine.task.Task;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TaskHandlerTest {

    private Logger logger = LoggerFactory.getLogger(TaskHandlerTest.class);
    private TaskHandler ts = new TaskHandler();

    @Test
    public void getAllTask() {
        List<Task> list = ts.getAllTask();
        Assert.assertNotNull(list);
        printTaskList(list);
    }

    @Test
    public void getAllTaskByUserID() {
        List<Task> list = ts.getAllTaskByUserID("smallyu");
        Assert.assertNotNull(list);
        printTaskList(list);
    }

    @Test
    public void taskAssignee() {
        Assert.assertFalse(ts.taskAssignee("aabbcc", "aabbcc"));
        Assert.assertTrue(ts.taskAssignee("2505", "smallyu"));
    }

    @Test
    public void completePersonalTask(){
        Assert.assertFalse(ts.completePersonalTask("6666"));
//        Assert.assertTrue(ts.completePersonalTask("2505"));
    }

    private void printTaskList(List<Task> list) {
        for(Task task : list){
            logger.info("------------------------");
            logger.info("Task ID: " + task.getId());
            logger.info("Task Name: " + task.getName());
            logger.info("Task CreateTime: " + task.getCreateTime());
            logger.info("Task Assignee: " + task.getAssignee());
            logger.info("ProcessInstance ID: " + task.getProcessInstanceId());
            logger.info("Excution ID: " + task.getExecutionId());
            logger.info("ProcessDefinitionHandler ID: " + task.getProcessDefinitionId());
        }
    }
}