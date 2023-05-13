/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian_karyawan;
/**
 *
 * @author ramdanirfox
 */
public class Penggajian_Karyawan {
    private static String userId;
    private static String userName;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public static void setUserInfo(String id, String name) {
        userId = id;
        userName = name;
    }
    
    public static String getUserId() {
        return userId;
    }
    
    public static String getUsername() {
        return userName;
    }
    
}
