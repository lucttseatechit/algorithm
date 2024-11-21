package sort;

/**
 * <ul>
 * Quá trình hoạt động:
 * <li>Bước 1: Xây dựng max-heap từ mảng.</li>
 * <li>Bước 2: Lấy phần tử lớn nhất (gốc của max-heap) và đặt nó vào cuối
 * mảng.</li>
 * <li>Bước 3: Điều chỉnh lại heap để duy trì tính chất max-heap, lặp lại cho
 * đến khi tất cả các phần tử được sắp xếp.</li>
 * </ul>
 * <ul>
 * Độ phức tạp thời gian:
 * <li>Xây dựng max-heap: O(n).</li>
 * <li>Sắp xếp: O(n log n), do có log n bước để điều chỉnh heap với mỗi phần
 * tử.</li>
 * <li>Tổng thời gian: O(n log n).</li>
 * </ul>
 * <ul>
 * Độ phức tạp không gian:
 * <li>O(1), vì thuật toán thực hiện sắp xếp tại chỗ, không yêu cầu thêm bộ nhớ
 * ngoài mảng ban đầu.</li>
 * </ul>
 * 
 * @author NTS
 *
 */
public class HeapSort {
	// Hàm chính để sắp xếp mảng bằng Heap Sort
	public static void heapSort(int[] arr) {
		int n = arr.length;

		// Xây dựng max-heap
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}

		// Trích xuất từng phần tử từ heap
		for (int i = n - 1; i > 0; i--) {
			// Di chuyển phần tử gốc (lớn nhất) đến cuối
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// Gọi hàm heapify trên heap bị giảm kích thước
			heapify(arr, i, 0);
		}
	}

	// Hàm heapify để duy trì tính chất max-heap
	private static void heapify(int[] arr, int n, int i) {
		int largest = i; // Gốc ban đầu
		int left = 2 * i + 1; // Con trái
		int right = 2 * i + 2; // Con phải

		// Nếu con trái lớn hơn gốc
		if (left < n && arr[left] > arr[largest]) {
			largest = left;
		}

		// Nếu con phải lớn hơn gốc
		if (right < n && arr[right] > arr[largest]) {
			largest = right;
		}

		// Nếu gốc không phải là lớn nhất
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Đệ quy heapify vào cây con bị ảnh hưởng
			heapify(arr, n, largest);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 12, 11, 13, 5, 6, 7 };
		System.out.println("Mảng ban đầu:");
		printArray(arr);

		heapSort(arr);

		System.out.println("\nMảng sau khi sắp xếp:");
		printArray(arr);
	}

	// Hàm in mảng
	public static void printArray(int[] arr) {
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
