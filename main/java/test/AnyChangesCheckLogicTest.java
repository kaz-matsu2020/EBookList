package test;

import model.AnyChangesCheckLogic;

public class AnyChangesCheckLogicTest {
	public static void main(String args[]) {
		changePassOK(); // 変更がある場合のテスト
		changePassNG(); // 変更がない場合のテスト
		changeMailOK(); // 変更がある場合のテスト
		changeMailNG(); // 変更がない場合のテスト
		changeNameOK(); // 変更がある場合のテスト
		changeNameNG(); // 変更がない場合のテスト
		changeAgeOK(); // 変更がある場合のテスト
		changeAgeNG(); // 変更がない場合のテスト
	}
	public static void changePassOK() {
		AnyChangesCheckLogic d = new AnyChangesCheckLogic();
		boolean b = d.changeCheckPass("kaz1", "5678");
		if(b == true) {
			System.out.print(b);
			System.out.println(":PassOKテスト成功");
		} else {
			System.out.print(b);
			System.out.println(":PassOKテスト失敗");
		}
	}
	public static void changePassNG() {
		AnyChangesCheckLogic d = new AnyChangesCheckLogic();
		boolean b = d.changeCheckPass("kaz1", "1234");
		if(b == false) {
			System.out.print(b);
			System.out.println(":PassNGテスト成功");
		} else {
			System.out.print(b);
			System.out.println(":PassNGテスト失敗");
		}
	}
	public static void changeMailOK() {
		AnyChangesCheckLogic d = new AnyChangesCheckLogic();
		boolean b = d.changeCheckMail("kaz1", "c@c");
		if(b == true) {
			System.out.print(b);
			System.out.println(":MailOKテスト成功");
		} else {
			System.out.print(b);
			System.out.println(":MailOKテスト失敗");
		}
	}
	public static void changeMailNG() {
		AnyChangesCheckLogic d = new AnyChangesCheckLogic();
		boolean b = d.changeCheckMail("kaz1", "a@a");
		if(b == false) {
			System.out.print(b);
			System.out.println(":MailNGテスト成功");
		} else {
			System.out.print(b);
			System.out.println(":MailNGテスト失敗");
		}
	}
	public static void changeNameOK() {
		AnyChangesCheckLogic d = new AnyChangesCheckLogic();
		boolean b = d.changeCheckName("kaz1", "ははは");
		if(b == true) {
			System.out.print(b);
			System.out.println(":NameOKテスト成功");
		} else {
			System.out.print(b);
			System.out.println(":NameOKテスト失敗");
		}
	}
	public static void changeNameNG() {
		AnyChangesCheckLogic d = new AnyChangesCheckLogic();
		boolean b = d.changeCheckName("kaz1", "松 和");
		if(b == false) {
			System.out.print(b);
			System.out.println(":NameNGテスト成功");
		} else {
			System.out.print(b);
			System.out.println(":NameNGテスト失敗");
		}
	}
	public static void changeAgeOK() {
		AnyChangesCheckLogic d = new AnyChangesCheckLogic();
		boolean b = d.changeCheckAge("kaz1", 120);
		if(b == true) {
			System.out.print(b);
			System.out.println(":AgeOKテスト成功");
		} else {
			System.out.print(b);
			System.out.println(":AgeOKテスト失敗");
		}
	}
	public static void changeAgeNG() {
		AnyChangesCheckLogic d = new AnyChangesCheckLogic();
		boolean b = d.changeCheckAge("kaz1", 36);
		if(b == false) {
			System.out.print(b);
			System.out.println(":AgeNGテスト成功");
		} else {
			System.out.print(b);
			System.out.println(":AgeNGテスト失敗");
		}
	}
}
