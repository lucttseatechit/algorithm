package sort;

import java.util.Scanner;

import helpler.ArrayHelper;

/**
 * Độ phức tạp thời gian:
	Trường hợp tốt nhất (mảng đã được sắp xếp): O(n) — Vì không cần dịch chuyển phần tử nào, chỉ cần một lần duyệt qua mảng.
	Trường hợp xấu nhất (mảng được sắp xếp ngược): O(n²) — Vì mỗi phần tử cần được dịch chuyển qua tất cả các phần tử đã sắp xếp.
	Trường hợp trung bình: O(n²) — Do phần lớn các phần tử cần dịch chuyển.
	Độ phức tạp không gian: O(1) — Vì thuật toán thực hiện sắp xếp tại chỗ, không yêu cầu bộ nhớ phụ ngoài mảng ban đầu.
 */
public class InsertionSort {
	private static void sort(int[] arr) {
		// lặp mảng
		for (int i = 1; i < arr.length; i++) {
			int current = arr[i];// phần tử hiện tại
			int j = i - 1;
			while (j >= 0 && arr[j] > current) {
				arr[j + 1] = arr[j];// dịch các phần tử lớn hơn sang bên phải
				j--;
			}
			// chèn vào vị trí thích hợp tại j+1
			arr[j + 1] = current;
		}
	}

	public static void main(String[] args) {
		// Khai báo đối tượng nhập
		Scanner sc = new Scanner(System.in);
		// Nhập số phần tử của mảng
		System.out.print("Vui lòng nhập số phần tử của dãy: ");
		Integer n = sc.nextInt();
		// khai báo mảng ban đầu
		System.out.print("Vui lòng nhập các phần tử của dãy: ");
		int[] arrIntegers = new int[n];
		// nhập mảng từ bàn phím
		for (int i = 0; i < n; i++) {
			arrIntegers[i] = sc.nextInt();
		}
		sc.close();// đóng nhập
		// sắp xếp mảng
		sort(arrIntegers);
		// in mảng ra
		System.out.print("Dãy sau khi sắp xếp tăng dần là: ");
		ArrayHelper.print(arrIntegers);
	}
}
