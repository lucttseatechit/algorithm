package search;

import java.util.Scanner;

public class BinarySearch {
	private static Integer search(Integer arr[], Integer target) {
		// phần tử đầu tiên
		int left = 0;
		// phần tử cuối cùng
		int right = arr.length - 1;
		// tìm kiếm phần tử đấy
		while (left <= right) {
			// phần tử nằm ở giữa
			int middle = left + (right - left);
			if (arr[middle].compareTo(target) == 0) {
				return middle;
			} else if (arr[middle].compareTo(target) == 1) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// Khai báo đối tượng nhập
		Scanner sc = new Scanner(System.in);
		// Nhập số phần tử của mảng
		System.out.print("Vui lòng nhập số phần tử của dãy: ");
		Integer n = sc.nextInt();
		// khai báo mảng ban đầu
		System.out.print("Vui lòng nhập các phần tử của dãy: ");
		Integer[] arrIntegers = new Integer[n];
		// nhập mảng từ bàn phím
		// tạm thời nhập mảng tăng dần hoặc giảm dần sau này sẽ bổ sung khi học thuật toán săps xếp
		for (int i = 0; i < n; i++) {
			arrIntegers[i] = sc.nextInt();
		}
		// nhập số cần tìm
		System.out.print("Vui lòng nhập số cần tìm: ");
		Integer target = sc.nextInt();
		sc.close();// đóng nhập
		Integer index = search(arrIntegers, target);
		if(index.compareTo(-1)==0) {
			System.out.print("Dãy không chứa phần tử "+target);
		}else {
			System.out.print("Dãy chứa phần tử "+target);
		}
	}
}
