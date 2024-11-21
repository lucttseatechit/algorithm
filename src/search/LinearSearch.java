package search;

import java.util.Scanner;

//tìm kiếm Integer để làm demo
public class LinearSearch {
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
		for (int i = 0; i < n; i++) {
			arrIntegers[i] = sc.nextInt();
		}
		sc.close();// đóng nhập
		//nhập số cần tìm
		System.out.print("Vui lòng nhập số cần tìm: ");
		Integer k=sc.nextInt();
		//tìm kiếm k trong dãy
		for(int i=0;i<n;i++) {
			if(arrIntegers[i].compareTo(k)==0) {
				System.out.println("Số cần tìm nằm ở vị trí: "+(i+1));
				return;
			}
		}
		System.out.println("Không tìm thấy số cần tìm");
	}
}
