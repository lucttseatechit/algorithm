package sort;

import java.util.Scanner;

/**
 * Độ phức tạp thời gian:
	Trường hợp tốt nhất: O(n²) — Dù mảng có được sắp xếp sẵn hay không, thuật toán vẫn phải duyệt qua toàn bộ mảng.
	Trường hợp xấu nhất: O(n²) — Dù mảng có được sắp xếp hay không, thuật toán vẫn cần duyệt qua n-1 phần tử để tìm phần tử nhỏ nhất trong mảng con.
	Trường hợp trung bình: O(n²) — Cũng giống như trường hợp xấu nhất.
	Độ phức tạp không gian: O(1) — Selection Sort là một thuật toán sắp xếp tại chỗ, nghĩa là nó không yêu cầu bộ nhớ bổ sung ngoài mảng ban đầu.
 */
public class SelectionSort {
	private static void sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			// gán min index là phần tử ban đầu
			int minIndex = i;
			// tìm phần tử nhỏ nhất ở mảng con đối với sắp xếp tăng dần/ngc lại
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			// hoán đổi vị trí phần tử min và phần tử đầu dãy con
			if (minIndex != i) {
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
	}

	private static void printArr(int[] arr) {
		for (int x : arr) {
			System.out.print(x + " ");
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
		//sắp xếp mảng
		sort(arrIntegers);
		//in mảng ra
		System.out.print("Dãy sau khi sắp xếp tăng dần là: ");
		printArr(arrIntegers);
	}
}
