package com.tiancaibao.service.interfaces.activity;

import com.tiancaibao.pojo.activity.Activity;
import com.tiancaibao.pojo.activity.ActivityLottery;
import com.tiancaibao.pojo.user.Users;

public interface IActivityService {
	
	void isValidActive();

	void isUserHaveQualification(Long userid);

	void isAlreadyAttendToday(Long userid);

	ActivityLottery extractRandomPrize();

	void savePrize(Users user, ActivityLottery prize);

	Activity selectActiveByNameAndIsClose(String name, Integer is_close);

}
