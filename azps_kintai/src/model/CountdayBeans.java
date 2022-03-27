package model;

import java.io.Serializable;
import java.util.List;

public class CountdayBeans implements Serializable {

	private int monthAllTime;//拘束時間
	private int monthWorkTime;//実労働時間
	private int numberOfMonth;//出勤数
	int breakTimeOfMonth;

	//DATE-String
	/*String-DATE SimpleDateFormat.parse*/

	@Override
	public String toString() {
		return "CountdayBeans [monthAllTime=" + monthAllTime + ", monthWorkTime=" + monthWorkTime + ", numberOfMonth="
				+ numberOfMonth + "]";
	}

	public void MonthCalc(List<AccountBeans> workTime_List) {

		this.numberOfMonth = workTime_List.size();//出勤数�?List�?の件数

		for (AccountBeans work : workTime_List) {

			this.monthAllTime += (Integer.parseInt(work.getInTime()) - Integer.parseInt(work.getOutTime()));//拘束時間�?出勤から�?勤まで
			breakTimeOfMonth += (Integer.parseInt(work.getBreakIn()) - Integer.parseInt(work.getBreakOut()));
		}
		this.monthWorkTime = monthAllTime - breakTimeOfMonth;//実労働時�?

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
