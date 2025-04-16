package lib;

public class TaxFunction {

	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */
	
	
	 public static int calculateTax(TaxData data) {

		int tax = 0;
	
		if (data.numberOfMonthWorking > 12) {
			System.err.println("More than 12 month working per year");
		}
	
		int annualIncome = (data.monthlySalary + data.otherMonthlyIncome) * data.numberOfMonthWorking;
		int netIncome = annualIncome - data.deductible;
	
		int nonTaxable = 54000000;
	
		if (data.isMarried) {
			nonTaxable += 4500000;
		}
	
		nonTaxable += Math.min(data.numberOfChildren, 3) * 4500000;
	
		int taxableIncome = netIncome - nonTaxable;
		if (taxableIncome > 0) {
			tax = (int) (taxableIncome * 0.05);
		}
	
		return tax;
	}
	
}
