package com.smp.user.dao;

import com.smp.bean.Uregister;

public interface UregisterDao {
	public int register(Uregister ar);
	public boolean login(String userName,String password);

}
