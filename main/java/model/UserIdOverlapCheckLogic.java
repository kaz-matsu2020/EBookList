package model;

import DAO.UserIdOverlapCheckDAO;

public class UserIdOverlapCheckLogic {
	public boolean userIdOverlapCheck(String userId) {
		UserIdOverlapCheckDAO checkOverlap = new UserIdOverlapCheckDAO();
		return checkOverlap.userIdOverlapCheck(userId);
	}
}
