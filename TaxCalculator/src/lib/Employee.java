package lib;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Employee {

	private static final int SALARY_GRADE_1 = 3000000;
	private static final int SALARY_GRADE_2 = 5000000;
	private static final int SALARY_GRADE_3 = 7000000;
	private static final double FOREIGNER_MULTIPLIER = 1.5;

	private String employeeId;
	private String firstName;
	private String lastName;
	private String idNumber;
	private String address;
	
	private int yearJoined;
	private int monthJoined;
	private int dayJoined;
	
	private boolean isForeigner;
	private boolean gender; //true = Laki-laki, false = Perempuan
	
	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;
	
	private String spouseName;
	private String spouseIdNumber;

	private List<String> childNames;
	private List<String> childIdNumbers;
	
	public Employee(String employeeId, String firstName, String lastName, String idNumber, String address,
			int yearJoined, int monthJoined, int dayJoined, boolean isForeigner, boolean gender) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.address = address;
		this.yearJoined = yearJoined;
		this.monthJoined = monthJoined;
		this.dayJoined = dayJoined;
		this.isForeigner = isForeigner;
		this.gender = gender;

		childNames = new LinkedList<>();
		childIdNumbers = new LinkedList<>();
	}

	public void setMonthlySalary(int grade) {
		switch (grade) {
			case 1:
				monthlySalary = SALARY_GRADE_1;
				break;
			case 2:
				monthlySalary = SALARY_GRADE_2;
				break;
			case 3:
				monthlySalary = SALARY_GRADE_3;
				break;
			default:
				monthlySalary = 0;
		}

		if (isForeigner) {
			monthlySalary *= FOREIGNER_MULTIPLIER;
		}
	}

	public void setAnnualDeductible(int deductible) {
		this.annualDeductible = deductible;
	}

	public void setAdditionalIncome(int income) {
		this.otherMonthlyIncome = income;
	}

	public void setSpouse(String spouseName, String spouseIdNumber) {
		this.spouseName = spouseName;
		this.spouseIdNumber = spouseIdNumber;
	}

	public void addChild(String childName, String childIdNumber) {
		childNames.add(childName);
		childIdNumbers.add(childIdNumber);
	}

	public int getAnnualIncomeTax() {
		LocalDate date = LocalDate.now();

		int monthWorked;
		if (date.getYear() == yearJoined) {
			monthWorked = date.getMonthValue() - monthJoined;
		} else {
			monthWorked = 12;
		}

		TaxData data = new TaxData(
			monthlySalary,
			otherMonthlyIncome,
			monthWorked,
			annualDeductible,
			spouseIdNumber == null || spouseIdNumber.isEmpty(),
			childIdNumbers.size()
		);

		return TaxFunction.calculateTax(data);
	}
}
