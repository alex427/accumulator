/**
 * 
 */
package zhiguang.daily.accumulator.design_patterns.observers.test;


import zhiguang.daily.accumulator.design_patterns.observers.observer.CompanyA;
import zhiguang.daily.accumulator.design_patterns.observers.observer.CompanyB;
import zhiguang.daily.accumulator.design_patterns.observers.subject.WeatherStation;

/**
 * @author zhiguang
 *
 */
public class Main {
 
	public static void main(String[] args) {

		CompanyA companyA = new CompanyA();
		CompanyB companyB = new CompanyB();

		WeatherStation station = new WeatherStation();

		station.registObserver(companyA);
		station.registObserver(companyB);
		station.notifyObserver(30, 22, 33);
		
	}

}
