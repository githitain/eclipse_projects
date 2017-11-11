package com.utilites;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvPerformanceMetricLogger extends CsvLogger 
{
		    private final String label;
		    private final static String TEST_OUTPUT_DIR = "../test-output";
		
		    public CsvPerformanceMetricLogger(String pathToFile, String label) {
		        this(pathToFile, label,"timeStamp", "elapsed", "label");
		    }
		
		    public CsvPerformanceMetricLogger(String pathToFile, String label, String... columns) {
		        super(pathToFile, columns);
		        this.label = label;
		    }
		
		    public void logAction(long duration) {
		        logAction(duration, new String[]{});
		    }
		
		    public void logAction(long duration, String... params) {
		        List<String> values = new ArrayList<>();
		        values.add(String.valueOf(System.currentTimeMillis()));
		        values.add(String.valueOf(duration));
		        values.add(label);
		
		        if (params != null) {
		            values.addAll(Arrays.asList(params));
		        }
		
		        appendLine(values.toArray(new String[0]));
		    }
		
		    public static volatile CsvPerformanceMetricLogger loginPerformanceMetrics =
		            new CsvPerformanceMetricLogger(TEST_OUTPUT_DIR + "/LoginPerformanceMetrics.csv", "LoginTime");
		
		    public static volatile CsvPerformanceMetricLogger logoutPerformanceMetrics =
		            new CsvPerformanceMetricLogger(TEST_OUTPUT_DIR + "/LogoutPerformanceMetrics.csv", "LogoutTime");
		
		    public static volatile CsvPerformanceMetricLogger openLoginPagePerformanceMetrics =
		            new CsvPerformanceMetricLogger(TEST_OUTPUT_DIR + "/OpenLoginPagePerformanceMetrics.csv", "OpenLoginPageTime");
		
		    public static volatile CsvPerformanceMetricLogger searchPatronRecordMetrics =
		            new CsvPerformanceMetricLogger(TEST_OUTPUT_DIR + "/SearchPatronRecordMetrics.csv", "SearchPatronRecordMetrics");
		
		    public static volatile CsvPerformanceMetricLogger httpResponseTimeMetrics =
		            new CsvPerformanceMetricLogger(TEST_OUTPUT_DIR + "/HttpResponseTimeMetrics.csv", "HttpResponseTimeMetrics", "timeStamp", "elapsed", "label", "method", "url", "requestText", "error");
}