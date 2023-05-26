package main;

public class Main {

	public static void main(String[] args) {

		// 무작위 숫자 입력
//		Scanner sc = new Scanner(System.in);
//		
//		String ad = sc.nextLine();
//		String[] split = ad.split(" ");
//		
//		int[] arr = new int[split.length];
//		
//		for (int i = 0; i < split.length; i++) {
//			arr[i] = Integer.parseInt(split[i]);
//		}
//		
//		Arrays.sort(arr);
//		for(int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + " ");
//			
//		}

		int[] arr = new int[] { 3, 4, 1, 2, 6 };
		printSortedResult(arr);

	}

	public static void printSortedResult(int[] arr) {

		// 가장 작은 수를 담을 변수 선언
		// 가장 작은 수의 위치를 담을 변수 선언
		// 요소의 0번 인덱스부터 마지막 인덱스까지 탐색하면서
		// 가장 작은 숫자를 변수에 저장하기, 해당 숫자의 위치(인덱스) 기억하기
		// 다 돌았으면, 해당 숫자 출력
		// 출력한건 없애기 == 해당 숫자 자리를 -1로 바꿔버리기

		for (int i = 0; i < arr.length; i++) {
			int minValue = Integer.MAX_VALUE;
			int minIdx = -1;

			for (int j = 0; j < arr.length; j++) {
				if(arr[j] < minValue) {
					minValue = arr[j];
					minIdx = j;
				}
			}
			
			System.out.println(minValue);
			arr[minIdx] = Integer.MAX_VALUE;

		}
	}

}
