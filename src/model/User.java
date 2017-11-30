package model;

public class User implements java.io.Serializable {
   private String userID;
   private String userPwd;
   private String userName;
   private String userPhone;
   private String budget;
   

   public User() {

   }

   public User(String userID, String userPwd, String userName, String userPhone,String budget) {
      this.userID = userID;
      this.userPwd = userPwd;
      this.userName = userName;
      this.userPhone = userPhone;
      this.budget=budget;
   }
   
   @Override
   public String toString(){
      return userID + "," + userPwd + "," + userName + "," + userPhone+","+budget;
   }

   public String getUserID() {
      return userID;
   }

   public void setUserID(String userID) {
      this.userID = userID;
   }

   public String getUserPwd() {
      return userPwd;
   }

   public void setUserPwd(String userPwd) {
      this.userPwd = userPwd;
   }

   public String getUserName() {
      return userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   public String getUserPhone() {
      return userPhone;
   }

   public void setUserPhone(String userPhone) {
      this.userPhone = userPhone;
   }

   public String getBudget() {
      return budget;
   }

   public void setBudget(String budget) {
      this.budget = budget;
   }

}