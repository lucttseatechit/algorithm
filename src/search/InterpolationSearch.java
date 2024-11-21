package search;

/**
 * <b>Tìm kiếm nội suy</b>
 * <li>Trường hợp tốt nhất: O(log(log n)), khi dữ liệu được phân phối đều và
 * thuật toán tìm được phần tử nhanh chóng.</li>
 * <li>Trường hợp xấu nhất: O(n), khi dữ liệu không đều hoặc phần tử cần tìm nằm
 * ở một vị trí khiến thuật toán phải duyệt qua toàn bộ mảng.</li>
 * <li>Độ phức tạp không gian: O(1), vì không yêu cầu sử dụng thêm bộ nhớ ngoài
 * mảng ban đầu.</li>
 * 
 * @author NTS công thức nội suy pos=low + ((x - arr[low]) * (high - low) /
 *         (arr[high] - arr[low]))
 */
public class InterpolationSearch {
	public static int interpolationSearch(int[] arr, int x) {
		int low = 0, high = arr.length - 1;

		while (low <= high && x >= arr[low] && x <= arr[high]) {
			// Công thức nội suy để tính vị trí
			int pos = low + ((x - arr[low]) * (high - low) / (arr[high] - arr[low]));

			// Kiểm tra nếu tìm thấy phần tử
			if (arr[pos] == x) {
				return pos;
			}

			// Nếu x lớn hơn, dịch sang phải
			if (arr[pos] < x) {
				low = pos + 1;
			} else {
				// Nếu x nhỏ hơn, dịch sang trái
				high = pos - 1;
			}
		}
		return -1; // Không tìm thấy
	}

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		int x = 50;

		int result = interpolationSearch(arr, x);
		if (result != -1) {
			System.out.println("Phần tử " + x + " được tìm thấy tại chỉ số: " + result);
		} else {
			System.out.println("Phần tử " + x + " không tồn tại trong mảng.");
		}
	}
}
