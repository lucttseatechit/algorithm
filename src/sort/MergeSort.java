package sort;

import java.util.Scanner;

import helpler.ArrayHelper;

/**
 * <ul>
 * Độ phức tạp thời gian:
 * <li>Trường hợp tốt nhất: O(n log n)</li>
 * <li>Trường hợp xấu nhất: O(n log n)</li>
 * <li>Trường hợp trung bình: O(n log n)</li>
 * <li>Độ phức tạp không gian: O(n) — Merge Sort cần không gian phụ để chứa các
 * mảng con.</li>
 * </ul>
 */
public class MergeSort {
	private static void mergeSort(int[] arr) {
		// mảng có 1 phần tử tức là mảng đã được sắp xếp r
		if (arr.length < 2) {
			return;
		}
		// tìm phần tử ở giữa
		int middle = arr.length / 2;
		// chia mảng thành 2
		int[] left = new int[middle];// mảng bên trái
		int[] right = new int[arr.length - middle];// mảng bên phải
		// copy các phần tử vào mảng con
		System.arraycopy(arr, 0, left, 0, middle);
		System.arraycopy(arr, middle, right, 0, arr.length - middle);
		// đệ quy gọi lại mergeSort
		mergeSort(left);
		mergeSort(right);
		// ghép 2 phần lại với nhau
		merge(left, right, arr);
		// in ra
	}

	private static void merge(int[] left, int[] right, int[] arr) {
		/*
		 * i là chỉ số của mảng left =0 j là chỉ số của mảng right =0 k là chỉ số của
		 * mảng arr =0
		 */
		int i = 0, j = 0, k = 0;
		while (i < left.length && j < right.length) {
			// nếu là phần tử mảng left < mảng bên right thì thêm phần tử bên left vào mảng
			// arr ban đầu
			if (left[i] < right[j]) {
				arr[k++] = left[i++];
			} else {
				// ngc lại thì thêm phần tử mảng right vào arr ban đầu
				arr[k++] = right[j++];
			}
		}
		// mảng left mà còn phần tử thì thêm hết vào mảng arr ban đầu
		while (i < left.length) {
			arr[k++] = left[i++];
		}
		// mảng phải mà còn phần tử thì thêm hết vào mảng arr ban đầu
		while (j < right.length) {
			arr[k++] = right[j++];
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
		mergeSort(arrIntegers);
		// in mảng ra
		System.out.print("Dãy sau khi sắp xếp tăng dần là: ");
		ArrayHelper.print(arrIntegers);
	}
}
