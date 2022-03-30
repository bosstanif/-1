package model;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IntimePostLogic {
	// 出社時に、attendance.jspからPostを受けMainサーブレットから起動されるモデル
	public boolean isExecute(String mail, Date today) throws ClassNotFoundException,SQLException {

		// 現在日時と時刻を取得
		SimpleDateFormat tdf = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");

		String day = tdf.format(today);
		String admission = sdf.format(today);
		String leaving = sdf.format(today);

		TimeBeans time = new TimeBeans (mail, day, admission, leaving);

		TimeDAO dao = new TimeDAO();
		return dao.canAdmission(time);
	}
}
