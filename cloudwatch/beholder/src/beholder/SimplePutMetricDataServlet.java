package beholder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.cloudwatch.AmazonCloudWatchClient;
import com.amazonaws.services.cloudwatch.model.MetricDatum;
import com.amazonaws.services.cloudwatch.model.PutMetricDataRequest;

public class SimplePutMetricDataServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		AWSCredentials credentials = new PropertiesCredentials(
	            getClass().getClassLoader().getResourceAsStream("AwsCredentials.properties"));
		AmazonCloudWatchClient cwClient = new AmazonCloudWatchClient(credentials);
		PutMetricDataRequest request = new PutMetricDataRequest();
		
		Collection<MetricDatum> metricData = new ArrayList<MetricDatum>();
		MetricDatum datum = new MetricDatum();
		datum.setMetricName("SimpleClicks");
		datum.setTimestamp(new Date());
		datum.setValue(1.00);
		metricData.add(datum);
		request.setMetricData(metricData);
		String namespace = "faermanj";
		request.setNamespace(namespace);

		cwClient.putMetricData(request);
		resp.getWriter().println("OK");
	}
}
