package model;

/**
 * バリデーションチェック
 * @author kazuo
 */

public class ValidationLogic {
	// userIdをチェック
	// 半角英数字6文字以上10文字以下であることをチェックする
	public boolean idCheck(String userId) {
		String checkId = userId.trim();
		boolean isLongEnough = checkId.length() >= 3;
		boolean isTooLong = checkId.length() > 10 ;
		boolean isHalfChars = checkId.matches("^[\\\\x00-\\\\x7F]+$");
		if(isLongEnough && isTooLong && isHalfChars) {
			return true;
		} else {
			return false;
		}
	}
	// passをチェック
	// 半角英数字6文字以上10文字以下であることをチェックする
	public boolean passCheck(String pass) {
		String checkPass = pass.trim();
		boolean isLongEnough = checkPass.length() >= 3;
		boolean isTooLong = checkPass.length() > 10 ;
		boolean isHalfChars = checkPass.matches("^[\\\\x00-\\\\x7F]+$");
		if(isLongEnough && isTooLong && isHalfChars) {
			return true;
		} else {
			return false;
		}
	}
	
}
