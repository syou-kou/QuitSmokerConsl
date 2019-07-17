package com.gk.itpm.develop.quitsmokercnsl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class QuitSmoker {
	private static LocalDate noSmokingStartDay;
	private static LocalDate now;
	private static int priceOfCigarettes;
	private static int numberOfCigarettes;

	public static void main(String[] args) {
		noSmokingStartDay = QuitSmoker.readDate();
		now = LocalDate.now();
		priceOfCigarettes = QuitSmoker.readPriceOfCigarettes();
		numberOfCigarettes = QuitSmoker.readNumberOfCigarettes();
		System.out.println("あなたがこれまでに使ってきたor節約したお金は"
			+ QuitSmoker.calcPriceOfNoSmoking() + "円です。");
	}
	
	private static long calcPriceOfNoSmoking() {
		return ChronoUnit.DAYS.between(noSmokingStartDay, now)
			* priceOfCigarettes * numberOfCigarettes;
		
	}

	private static int readNumberOfCigarettes() {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("１日に吸うタバコの箱数を整数で入力してください。");
			System.out.print("入力：");
			String line = sc.nextLine();
			
			int number;
			try {
				number = Integer.parseInt(line);
			} catch (Exception e) {
				System.out.println("箱数が不正です。");
				continue;
			}
			
			if (number < 0) {
				System.out.println("箱数が不正です。");
				continue;
			}
			
			return number;
		}
	}
	
	private static int readPriceOfCigarettes() {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("タバコの値段を整数で入力してください。");
			System.out.print("入力：");
			String line = sc.nextLine();
			
			int price;
			try {
				price = Integer.parseInt(line);
			} catch (Exception e) {
				System.out.println("値段が不正です。");
				continue;
			}
			
			if (price <= 0) {
				System.out.println("値段が不正です。");
				continue;
			}
			
			return price;
		}
	}
	
	private static LocalDate readDate() {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("喫煙開始日をYYYY-MM-DD形式で入力してください。");
			System.out.print("入力：");
			String line = sc.nextLine();
			
			try {
				String[] buffers = line.split("-");
				LocalDate ld = LocalDate.of(
					Integer.parseInt(buffers[0]),
					Integer.parseInt(buffers[1]),
					Integer.parseInt(buffers[2])
				);
				return ld;
			} catch (Exception e) {
				System.out.println("日付が不正です。");
				continue;
			}
		}
	}
}
