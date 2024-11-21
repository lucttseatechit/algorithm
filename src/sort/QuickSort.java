package sort;

import java.util.Scanner;

import helpler.ArrayHelper;

/**
 * <ul>
 * Độ phức tạp thời gian:
 * <li>Trường hợp tốt nhất: O(n log n)</li>
 * <li>Trường hợp xấu nhất: O(n²)</li>
 * <li>Trường hợp trung bình: O(n log n)</li>
 * </ul>
 * <ul>
 * Độ phức tạp không gian:
 * <li>O(log n) trong trường hợp tốt nhất và trung bình</li>
 * <li>O(n) trong trường hợp xấu nhất (nếu mảng không được chia đều)</li>
 * </ul>
 * 
 * @author NTS
 *
 */
public class QuickSort {
	/**
	 * hàm phân vùng
	 * 
	 * @param arr  mảng
	 * @param low	chỉ số bắt đầu
	 * @param high	chỉ số kết thúc
	 */
	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];// lấy phần tử cuối cùng làm pivot
		int i = low - 1;// chỉ số của của phần tử nhỏ hơn pivot
		// duyệt từ low to high -1
		for (int j = low; j < high; j++) {
			// nếu cái phần tử này mà bé hơn cái pivot thì đổi chỗ
			if (arr[j] < pivot) {
				i++;
				// swap a.i và a.j
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		// đổi chỗ a.i+1 và a.high (pivot)
		int temp = arr[i+1];
		arr[i+1] = pivot;
		arr[high] = temp;

		return i + 1;// trả về index của pivot
	}

	private static void sort(int[] arr, int low, int high) {
		if (low < high) {
			int index = partition(arr, low, high);// lấy index pivot
			sort(arr, low, index - 1);// sắp xếp mảng bên trái
			sort(arr, index + 1, high);// sắp xếp phía bên phải
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
		sort(arrIntegers, 0, n - 1);
		// in mảng ra
		System.out.print("Dãy sau khi sắp xếp tăng dần là: ");
		ArrayHelper.print(arrIntegers);
	}
}
