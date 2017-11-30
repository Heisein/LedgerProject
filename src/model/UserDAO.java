package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UserDAO {
   ArrayList<User> users = new ArrayList<User>();
   FileDAO files = new FileDAO();

   public UserDAO() {
      this.loadUser();
   }

   public ArrayList<User> getUsers() {
      return users;
   }

   public void setUsers(ArrayList<User> users) {
      this.users = users;
   }

   public User findUsers(String userId) {
      for (int i = 0; i < users.size(); i++) {
         if ((userId.equals(users.get(i).getUserID()))) {
            return users.get(i);
         }
      }

      return null;
   }

   // 아이디 찾기
   public User findId(String userName, String userPhone) {
      for (int i = 0; i < users.size(); i++) {
         if ((userName.equals(users.get(i).getUserName()))) {
            if ((userPhone.equals(users.get(i).getUserPhone())))
               return users.get(i);
         }
      }

      return null;
   }
   
   // 비밀번호 찾기
   public User findPwd(String userID, String userPhone) {
      for (int i = 0; i < users.size(); i++) {
         if ((userID.equals(users.get(i).getUserID()))) {
            if ((userPhone.equals(users.get(i).getUserPhone())))
               return users.get(i);
         }
      }

      return null;
   }
   
   
   // 비밀번호 변경
   public boolean changePWD(String userId, String newPwd) {
      for (int i = 0; i < users.size(); i++) {
         if ((userId.equals(users.get(i).getUserID()))) {
            users.get(i).setUserPwd(newPwd);
            saveUser();
            return true;
         } 
      }
      return false;
   }

   public boolean insertUser(String userId, String userPwd, String userName, String userPhone,String budget) {
      if (!checkUser(userId)) {
         users.add(new User(userId, userPwd, userName, userPhone,budget));
         this.saveUser();
         return true;
      } else {
         return false;
      }

   }

   public boolean checkUser(String userId) {
      boolean result = false;

      for (int i = 0; i < users.size(); i++) {
         if (userId.equals(users.get(i).getUserID())) {
            result = true;
            break;
         }
      }

      return result;
   }

   public User loginMethod(String userId, String userPwd) {
      User userTemp = null;

      if (checkUser(userId)) {
         for (int i = 0; i < users.size(); i++) {
            if ((userId.equals(users.get(i).getUserID()) && (userPwd.equals(users.get(i).getUserPwd())))) {
               userTemp = users.get(i);
            }
         }
      }

      return userTemp;
   }

   public void saveUser() {
      try (BufferedWriter bOut = new BufferedWriter(new FileWriter("user.dat"))) {
         for (int i = 0; i < users.size(); i++) {
            bOut.write(users.get(i).toString() + "\n"); // user 벡터의 크기만큼 한줄로
                                             // 데이터를 저장함
         }
         System.out.println("파일 저장!!");
      } catch (FileNotFoundException e) { // FileNotFound : 해당 파일이 없을때
         System.out.println("user.dat 존재하지 않음 : 새로 만들어짐");
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public void loadUser() {
      try (BufferedReader br = new BufferedReader(new FileReader("user.dat"))) {
         while (true) {
            String str = br.readLine();

            if (str == null) {
               System.out.println("user.dat 파일 읽기 완료 (로그인)");
               break;
            }
            String[] sArr = str.split(",");

            User userTemp = new User(sArr[0].trim(), sArr[1].trim(), sArr[2].trim(), sArr[3].trim(),sArr[4].trim());

            users.add(userTemp);

         }
      } catch (FileNotFoundException e) {
         System.out.println("user.dat가 존재하지 않음!");
      } catch (IOException e) {
         e.printStackTrace();
      }

   }
   
   public void budgetchange(String userId,String budget) {
      for (int i = 0; i < users.size(); i++) {
         if ((userId.equals(users.get(i).getUserID()))) {
            users.get(i).setBudget(budget);
            saveUser();
         } 
      }
   }
}