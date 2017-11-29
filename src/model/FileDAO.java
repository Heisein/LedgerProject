package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileDAO {
	public void saveUser() {
		UserDAO userDao = new UserDAO();

		ArrayList<User> user = userDao.getUsers();

		try (BufferedWriter bOut = new BufferedWriter(new FileWriter("user.dat"))) {
			for (int i = 0; i < user.size(); i++) {
				bOut.write(user.get(i).toString() + "\n"); // user 벡터의 크기만큼 한줄로
															// 데이터를 저장함
			}
			System.out.println("파일 저장!!");
		} catch (FileNotFoundException e) { // FileNotFound : 해당 파일이 없을때
			System.out.println("user.dat 존재하지 않음 : 새로 만들어짐");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<User> loadUser() {
		try (BufferedReader br = new BufferedReader(new FileReader("user.dat"))) {
			while (true) {
				String str = br.readLine();
				ArrayList<User> u = new ArrayList<User>();

				if (str == null) {
					System.out.println("user.txt 파일 읽기 완료");
					break;
				}
				String[] sArr = str.split(",");

				User userTemp = new User(sArr[0], sArr[1], sArr[2], sArr[3]);

				u.add(userTemp);

				return u;
			}
		} catch (FileNotFoundException e) {
			System.out.println("user.txt가 존재하지 않음!");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
