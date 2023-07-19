package co.yedam.inherit;

public class PhoneExe {

	public static void main(String[] args) {
		CellPhone cellPhone = new CellPhone();
		cellPhone.setModel("이재용 S23");
		cellPhone.setColor("다라이 레드");
		cellPhone.powerOn();
		cellPhone.sendMessage();
		cellPhone.powerOff();
		System.out.println(cellPhone.showInfo());

		System.out.println("-----------------------");
		// 자식클래스는 부모클래스의 필드, 메소드, 생성자를 상속
		DmbCellPhone dmbphone = new DmbCellPhone();
		dmbphone.setModel("잡스 14");
		dmbphone.setColor("국방 그린");
		dmbphone.powerOn();
		dmbphone.sendMessage();
		dmbphone.turnOn();
		dmbphone.changeChannel(10);
		dmbphone.turnOff();
		dmbphone.powerOff();
		System.out.println(dmbphone.showInfo());

		// 부모클래스의 변수에 자식클래스의 변수 대입.
		CellPhone parent = new DmbCellPhone(); // promotion(자동형변환)
		CellPhone parent1 = new DmbCellPhone("DMB 1", "black", 10);
//		parent.turnOn(); // 자식클래스의 필드, 메소드 사용불가
		System.out.println(parent.getModel());

		DmbCellPhone child = null;
		
		if (parent1 instanceof DmbCellPhone) {
			child = (DmbCellPhone) parent1; // casting(강제형변환)
//		child.turnOn();
		}
		// 부모클래스의 변수를 자식변수로 casting 할 경우 체크. 메소드 사용가능
		if (cellPhone instanceof DmbCellPhone) {
			child = (DmbCellPhone) cellPhone;
			child.turnOn();
		}
	}

}
