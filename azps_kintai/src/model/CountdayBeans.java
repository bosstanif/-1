package model;

import java.io.Serializable;
import java.util.List;

public class CountdayBeans implements Serializable {

	private int /* date */ monthAllTime;//諡俶據譎る俣
	private int monthWorkTime;//螳溷感蜒肴凾髢�
	private int numberOfMonth;//蜃ｺ蜍､謨ｰ
	int breakTimeOfMonth;

	//DATE-String
	/*String-DATE SimpleDateFormat.parse*/

	@Override
	public String toString() {
		return "CountdayBeans [monthAllTime=" + monthAllTime + ", monthWorkTime=" + monthWorkTime + ", numberOfMonth="
				+ numberOfMonth + "]";
	}

	public void MonthCalc(List<AccountBeans> workTime_List) {

		this.numberOfMonth = workTime_List.size();//蜃ｺ蜍､謨ｰ縲�List蜀�縺ｮ莉ｶ謨ｰ

		for (AccountBeans work : workTime_List) {

			this.monthAllTime += (Integer.parseInt(work.getInTime()) - Integer.parseInt(work.getOutTime()));//諡俶據譎る俣縲�蜃ｺ蜍､縺九ｉ騾�蜍､縺ｾ縺ｧ
			breakTimeOfMonth += (Integer.parseInt(work.getBreakIn()) - Integer.parseInt(work.getBreakOut()));
		}

		this.monthWorkTime = monthAllTime - breakTimeOfMonth;//螳溷感蜒肴凾髢�

	}

	public int getMonthAllTime() {
		return monthAllTime;
	}

	public int getMonthWorkTime() {
		return monthWorkTime;
	}

	public int getNumberOfMonth() {
		return numberOfMonth;
	}

}
