package sax.metadata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TargetMetadata {

	private String _targetName;
	private List<TargetMetric> _metrics = new ArrayList<TargetMetric>();
	private Map<String, String> _properties = new HashMap<String, String>();
	
	public String getTargetName() {
		return _targetName;
	}
	public void setTargetName(String targetName) {
		_targetName = targetName;
	}

	@Override
	public String toString() {
		String targetData = "@" + _targetName + "\n";
		targetData += "**********PROPERTIES**********\n"; 
				
		Iterator<String> keyIt = _properties.keySet().iterator();
		while(keyIt.hasNext()){
			String key = keyIt.next();
			String value = _properties.get(key);
			targetData += "\t" + value + " - " + key + "\n";
		}
		targetData += "*********METRICS**********\n";
		for(TargetMetric metric : _metrics){
			targetData += metric.toString();			
		}
		return targetData;
	}
	public List<TargetMetric> getMetrics() {
		return _metrics;
	}
	public void setMetrics(List<TargetMetric> metrics) {
		_metrics = metrics;
	}
	
	public void addMetric(TargetMetric metric){
		_metrics.add(metric);
	}
	
	public Map<String, String> getProperties() {
		return _properties;
	}
	
	public void setProperties(Map<String, String> properties) {
		_properties = properties;
	}
	
	public void addProperty(String propertyName, String propertyDesc){
		_properties.put(propertyName, propertyDesc);
		
	}
	
}
